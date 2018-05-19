package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.SessionEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.exception.InvalidArgumentException;
import com.archangel_design.babyscheduller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.mysql.jdbc.StringUtils.isNullOrEmpty;

@Service
public class UserService {

    @Autowired
    SessionService sessionService;

    @Autowired
    private UserRepository userRepository;

    public boolean isPasswordValid(String password, String hash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hash);
    }

    public String hashPassword(String passwordRaw) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(passwordRaw);
    }

    public SessionEntity login(String email, String password, String deviceId) {
        UserEntity user = userRepository.fetch(email);
        if (user == null)
            return null;

        if (isPasswordValid(password, user.getPassword()))
            return sessionService.startSession(user, deviceId);

        // register failed login attempt
        return null;
    }

    public UserEntity register(
            String email, String firstName,
            String password, String passwordRepeat) throws InvalidArgumentException {
        if (isNullOrEmpty(email) || isNullOrEmpty(firstName)
                || isNullOrEmpty(password) || isNullOrEmpty(passwordRepeat))
            throw new InvalidArgumentException("Missing required field.");

        if (!password.equals(passwordRepeat))
            throw new InvalidArgumentException("Passwords do not match.");

        if (userRepository.userExists(email))
            throw new InvalidArgumentException(String.format("User %s is already registered.", email));

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email)
                .setLastUsage(new Date())
                .setPassword(hashPassword(password))
                .setRegistration(new Date());

        return userRepository.save(userEntity);
    }

    public UserEntity getCurrentUser() {
        return sessionService.getCurrentSession().getUser();
    }
}
