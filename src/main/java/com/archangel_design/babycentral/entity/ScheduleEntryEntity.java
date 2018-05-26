/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.entity;

import com.archangel_design.babycentral.enums.ScheduleEntryPriority;
import com.archangel_design.babycentral.enums.ScheduleEntryRepeatType;
import com.archangel_design.babycentral.enums.ScheduleEntryType;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "schedule_entries")
@Getter
@Setter
public class ScheduleEntryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private ScheduleEntryType type;

    private Time start;

    private Time stop;

    @Enumerated(EnumType.STRING)
    private ScheduleEntryPriority priority;

    @Enumerated(EnumType.STRING)
    private ScheduleEntryRepeatType repeatType;

    private Date startDate;

    private Date endDate;
}
