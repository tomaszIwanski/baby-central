/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.service;

import com.archangel_design.babycentral.entity.BabyEntity;
import com.archangel_design.babycentral.entity.ScheduleEntity;
import com.archangel_design.babycentral.entity.ScheduleEntryEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import com.archangel_design.babycentral.enums.ScheduleEntryPriority;
import com.archangel_design.babycentral.enums.ScheduleEntryRepeatType;
import com.archangel_design.babycentral.enums.ScheduleEntryType;
import com.archangel_design.babycentral.exception.InvalidArgumentException;
import com.archangel_design.babycentral.repository.ScheduleRepository;
import com.archangel_design.babycentral.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

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
            @NotNull final Time start,
            @NotNull final Time stop,
            @NotNull final ScheduleEntryPriority priority,
            @NotNull final ScheduleEntryRepeatType repeatType,
            final Date dateStart,
            final Date dateStop
            ) {
        ScheduleEntity scheduleEntity = scheduleRepository.fetch(scheduleId);
        if (scheduleEntity == null)
            throw new InvalidArgumentException("Schedule does not exist. " + scheduleId);
        ScheduleEntryEntity entry = new ScheduleEntryEntity();
        entry.setPriority(priority);
                entry.setStart(start);
                entry.setType(entryType);
                entry.setStop(stop);
                entry.setRepeatType(repeatType);
                entry.setStartDate(dateStart);
                entry.setEndDate(dateStop);
        scheduleEntity.getEntries().add(entry);

        return scheduleRepository.save(scheduleEntity);
    }

    public List<ScheduleEntity> getList() {
        UserEntity user = sessionService.getCurrentSession().getUser();

        return scheduleRepository.fetchList(user);
    }

    public ScheduleEntity fetch(String uuid) {
        return scheduleRepository.fetch(uuid);
    }

    public List<ScheduleEntity> getList(String uuid) {
        UserEntity user = sessionService.getCurrentSession().getUser();
        return scheduleRepository.fetchList(user, uuid);
    }
}
