/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.request;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    private String name;
    private String babyId;
}
