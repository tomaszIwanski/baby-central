package com.archangel_design.babyscheduller.controller;

import com.archangel_design.babyscheduller.entity.SessionEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.entity.dto.UserDto;
import com.archangel_design.babyscheduller.exception.InvalidArgumentException;
import com.archangel_design.babyscheduller.request.LoginRequest;
import com.archangel_design.babyscheduller.request.RegistrationRequest;
import com.archangel_design.babyscheduller.response.LoginResponse;
import com.archangel_design.babyscheduller.service.UserService;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    public LoginResponse login(
            @RequestBody LoginRequest request
    ) throws InvalidCredentialsException {
        SessionEntity newSession = userService.login(request.getEmail(), request.getPassword());
        if (newSession == null)
            throw new InvalidCredentialsException();
        LoginResponse response = new LoginResponse();
        return response
                .setCreated(newSession.getCreated())
                .setExpiration(newSession.getExpiration())
                .setSessionId(newSession.getSessionId());
    }

    public UserDto register(
            @RequestBody RegistrationRequest request
            ) throws InvalidArgumentException {
        UserEntity user = userService.register(
                request.getEmail(),
                request.getFirstName(),
                request.getPassword(),
                request.getPasswordRepeat());
        return UserDto.build(user);
    }
}
