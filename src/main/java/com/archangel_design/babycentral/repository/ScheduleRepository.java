/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.repository;

import com.archangel_design.babycentral.entity.ScheduleEntity;

public class ScheduleRepository extends GenericRepository {

    public ScheduleEntity save(ScheduleEntity scheduleEntity) {
        return em.merge(scheduleEntity);
    }

}
