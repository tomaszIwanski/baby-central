package com.archangel_design.babyscheduller.controller;

import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.request.LocationUpdateRequest;
import com.archangel_design.babyscheduller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/my-account")
    public UserEntity myAccount() {
        return userService.getCurrentUser();
    }

    @PostMapping("/update-profile")
    public void updateProfile() {}

    @PostMapping("/update-location")
    public void updateLocation(
            @RequestBody LocationUpdateRequest request
            ) {

    }
}
