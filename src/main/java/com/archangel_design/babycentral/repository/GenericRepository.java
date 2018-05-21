package com.archangel_design.babycentral.repository;

import com.archangel_design.babycentral.entity.LocationEntity;
import com.archangel_design.babycentral.entity.SessionEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class GenericRepository {
    @PersistenceContext
    protected EntityManager em;

    public SessionEntity save(SessionEntity session) {
        return em.merge(session);
    }

    public UserEntity save(UserEntity userEntity) {
        return em.merge(userEntity);
    }

    public LocationEntity save(LocationEntity locationEntity) {
        return em.merge(locationEntity);
    }

    public Object save(Object object) {
        return em.merge(object);
    }
}
