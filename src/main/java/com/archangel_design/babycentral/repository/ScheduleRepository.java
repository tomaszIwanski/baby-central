/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.repository;

import com.archangel_design.babycentral.entity.ScheduleEntity;
import com.archangel_design.babycentral.entity.ScheduleEntryEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public class ScheduleRepository extends GenericRepository {

    public ScheduleEntity fetch(@NotNull final String scheduleId) {
        TypedQuery<ScheduleEntity> query = em.createQuery(
                "select s from ScheduleEntity s "
                + "where s.uuid = :id", ScheduleEntity.class
        );

        query.setParameter("id", scheduleId);

        return query.getResultList().stream().findFirst().orElse(null);
    }

    public List<ScheduleEntity> fetchList(UserEntity user) {
        TypedQuery<ScheduleEntity> query = em.createQuery(
                "select s from ScheduleEntity s "
                + "where s.user.id = :uid", ScheduleEntity.class
        );

        query.setParameter("uid", user.getId());

        return query.getResultList();
    }
}
