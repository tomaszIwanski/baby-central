package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.SessionEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    SessionService sessionServiceService;

    @Autowired
    UserRepository userRepository;

    public boolean isPasswordValid(String password, String hash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hash);
    }

    public String hashPassword(String passwordRaw) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(passwordRaw);
    }

    public SessionEntity login(String email, String password) {
        UserEntity user = userRepository.fetch(email, hashPassword(password));
        if (user == null) {
            // register failed login attempt
            return null;
        }
        return new SessionEntity();
    }
}
