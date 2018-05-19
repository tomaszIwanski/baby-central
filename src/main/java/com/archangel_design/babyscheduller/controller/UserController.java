package com.archangel_design.babyscheduller.controller;

import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/my-account")
    public UserEntity myAccount() {

        return null;
    }
}
