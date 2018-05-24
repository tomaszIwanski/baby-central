/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.entity;

import com.archangel_design.babycentral.enums.ScheduleEntryType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = BabyEntity.class, optional = false)
    @JoinColumn(name = "baby_id")
    private BabyEntity baby;

    @ManyToOne(targetEntity = UserEntity.class, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Enumerated(value = EnumType.STRING)
    private ScheduleEntryType type;

    private Date start;

    private Date stop;

    public Long getId() {
        return id;
    }

    public ScheduleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public BabyEntity getBaby() {
        return baby;
    }

    public ScheduleEntity setBaby(BabyEntity baby) {
        this.baby = baby;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ScheduleEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public ScheduleEntryType getType() {
        return type;
    }

    public ScheduleEntity setType(ScheduleEntryType type) {
        this.type = type;
        return this;
    }

    public Date getStart() {
        return start;
    }

    public ScheduleEntity setStart(Date start) {
        this.start = start;
        return this;
    }

    public Date getStop() {
        return stop;
    }

    public ScheduleEntity setStop(Date stop) {
        this.stop = stop;
        return this;
    }
}
