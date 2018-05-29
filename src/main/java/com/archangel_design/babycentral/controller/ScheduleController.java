/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.controller;

import com.archangel_design.babycentral.entity.ScheduleEntity;
import com.archangel_design.babycentral.request.CreateScheduleEntryRequest;
import com.archangel_design.babycentral.request.CreateScheduleRequest;
import com.archangel_design.babycentral.service.ScheduleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@Api(tags = "Schedule management")
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

    @GetMapping("/list")
    public List<ScheduleEntity> getList() {
        return scheduleService.getList();
    }

    @PutMapping("/entry")
    public ScheduleEntity createEntry(
            @RequestBody CreateScheduleEntryRequest request
    ) {
        return scheduleService.createEntry(
                request.getScheduleId(),
                request.getEntryType(),
                request.getStart(),
                request.getStop(),
                request.getPriority(),
                request.getRepeatType(),
                request.getStartDate(),
                request.getEndDate()
        );
    }
}
