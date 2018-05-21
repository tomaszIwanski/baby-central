/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babyscheduller.controller;

import com.archangel_design.babyscheduller.entity.ProfileEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.request.LocationUpdateRequest;
import com.archangel_design.babyscheduller.service.LocationService;
import com.archangel_design.babyscheduller.service.SessionService;
import com.archangel_design.babyscheduller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Main controller responsible for user operations
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/my-account")
    public UserEntity myAccount() {
        return userService.getCurrentUser();
    }

    @PostMapping("/update-profile")
    public UserEntity updateProfile(
            @RequestBody ProfileEntity request
            ) {
        return userService.updateProfile(request);
    }

    @PostMapping("/create-organization/{name}")
    public UserEntity createOrganization(
            @PathVariable String name
    ) {
        return userService.createOrganization(name);
    }

    @PostMapping("/update-location")
    public void reportLocation(
            @RequestBody LocationUpdateRequest request
            ) {
        locationService.reportPosition(
                request.getLat(),
                request.getLon(),
                request.getAlt(),
                request.getPrecision(),
                request.getDate(),
                sessionService.getCurrentSession().getUser(),
                request.getDeviceId()
        );
    }
}
