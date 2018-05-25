/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.controller;

import com.archangel_design.babycentral.entity.ScheduleEntity;
import com.archangel_design.babycentral.request.CreateScheduleRequest;
import com.archangel_design.babycentral.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/create-schedule")
    public ScheduleEntity addSchedule(
            @RequestBody CreateScheduleRequest request
    ) {
        return scheduleService.createSchedule(
                request.getBabyId(), request.getName()
        );
    }
}
