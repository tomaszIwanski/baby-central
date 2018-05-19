package com.archangel_design.babyscheduller.repository;

import com.archangel_design.babyscheduller.entity.SessionEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class SessionRepository {

    @PersistenceContext
    EntityManager em;

    public void removeSessions(Long userId, String deviceId) {
        Query q = em.createQuery(
                "delete from SessionEntity s "
                        + "where s.user.id = :id and s.deviceId = :deviceId"
        );

        q.setParameter("id", userId);
        q.setParameter("deviceId", deviceId);

        q.executeUpdate();
    }

    public SessionEntity save(SessionEntity session) {
        return em.merge(session);
    }
}
