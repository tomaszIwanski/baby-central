/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.service;

import com.archangel_design.babycentral.entity.BabyEntity;
import com.archangel_design.babycentral.entity.ScheduleEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import com.archangel_design.babycentral.enums.ScheduleEntryType;
import com.archangel_design.babycentral.exception.InvalidArgumentException;
import com.archangel_design.babycentral.repository.ScheduleRepository;
import com.archangel_design.babycentral.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Service
public class ScheduleService {

    @Autowired
    SessionService sessionService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    public ScheduleEntity createSchedule(
            @NotNull final String babyId,
            @NotNull final String name
            ) {
        UserEntity user = sessionService.getCurrentSession().getUser();
        BabyEntity baby = userRepository.fetchBaby(babyId);
        if (baby == null) {
            throw new InvalidArgumentException("Baby does not exist.");
        }
        ScheduleEntity scheduleEntity = new ScheduleEntity();

        scheduleEntity
                .setName(name)
                .setBaby(baby)
                .setUser(user);

        return scheduleRepository.save(scheduleEntity);
    }

    public ScheduleEntity createEntry(
            @NotNull final String scheduleId,
            @NotNull final ScheduleEntryType entryType,
            @NotNull final Date start,
            @NotNull final Date stop) {
        return null;
    }
}
