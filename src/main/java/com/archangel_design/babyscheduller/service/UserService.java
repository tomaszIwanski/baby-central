package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.OrganizationEntity;
import com.archangel_design.babyscheduller.entity.ProfileEntity;
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

    /**
     * Compares plain text password with given hash.
     *
     * @param password plain text password
     * @param hash hashed password
     * @return boolean
     */
    public boolean isPasswordValid(String password, String hash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hash);
    }

    /**
     * Returns password hash using BCrypt.
     *
     * @param passwordRaw plain text password
     * @return hashed password
     */
    public String hashPassword(String passwordRaw) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(passwordRaw);
    }

    /**
     * Performs login, creates session or registers failed login attempt.
     *
     * @param email user email
     * @param password user password
     * @param deviceId unique ID of the device being used
     * @return created session
     */
    public SessionEntity login(String email, String password, String deviceId) {
        UserEntity user = userRepository.fetch(email);
        if (user == null)
            return null;

        if (isPasswordValid(password, user.getPassword()))
            return sessionService.startSession(user, deviceId);

        // @TODO: register failed login attempt
        return null;
    }

    /**
     * Performs user registration.
     *
     * @param email valid email (to be verified)
     * @param firstName first name or a nick name
     * @param password valid password
     * @param passwordRepeat password repeated
     * @return newly created user entity
     * @throws InvalidArgumentException if case of validation errors
     */
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

    /**
     *
     * @return entity of current user.
     */
    public UserEntity getCurrentUser() {
        return sessionService.getCurrentSession().getUser();
    }

    /**
     * Creates organization which allows multiple
     * users to collaborate.
     *
     * @param name organization name
     * @return updated user entity
     */
    public UserEntity createOrganization(String name) {
        UserEntity currentUser = sessionService.getCurrentSession().getUser();

        if (currentUser.getOrganization() != null)
            throw new InvalidArgumentException(
                    "User is already in organization "
                            + currentUser.getOrganization().getName()
            );

        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setName(name);
        currentUser.setOrganization(organizationEntity);

        return userRepository.save(currentUser);
    }

    /**
     * Updates user profile with given information (overwrite).
     *
     * @param request current user information
     * @return updated entity
     * @todo: 21/05/2018 input validation
     */
    public UserEntity updateProfile(ProfileEntity request) {
        UserEntity userEntity = sessionService.getCurrentSession().getUser();
        userEntity.setProfile(request);

        return userRepository.save(userEntity);
    }
}
