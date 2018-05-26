/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.request;

import com.archangel_design.babycentral.enums.ScheduleEntryType;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateScheduleEntryRequest {
    private String scheduleId;
    private ScheduleEntryType entryType;
    private Date start;
    private Date stop;

}
