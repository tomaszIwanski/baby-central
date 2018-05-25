/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.entity;

import com.archangel_design.babycentral.enums.ScheduleEntryPriority;
import com.archangel_design.babycentral.enums.ScheduleEntryType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "schedule_entries")
public class ScheduleEntryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private ScheduleEntryType type;

    private Date start;

    private Date stop;

    @Enumerated(EnumType.STRING)
    private ScheduleEntryPriority priority;

    public Long getId() {
        return id;
    }

    public ScheduleEntryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ScheduleEntryType getType() {
        return type;
    }

    public ScheduleEntryEntity setType(ScheduleEntryType type) {
        this.type = type;
        return this;
    }

    public Date getStart() {
        return start;
    }

    public ScheduleEntryEntity setStart(Date start) {
        this.start = start;
        return this;
    }

    public Date getStop() {
        return stop;
    }

    public ScheduleEntryEntity setStop(Date stop) {
        this.stop = stop;
        return this;
    }

    public ScheduleEntryPriority getPriority() {
        return priority;
    }

    public ScheduleEntryEntity setPriority(ScheduleEntryPriority priority) {
        this.priority = priority;
        return this;
    }
}
