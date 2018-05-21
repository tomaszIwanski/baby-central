package com.archangel_design.babyscheduller.repository;

import com.archangel_design.babyscheduller.entity.LocationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LocationRepository extends GenericRepository {

    public List<LocationEntity> fetchRecent(Long userId, int limit) {
        TypedQuery<LocationEntity> q = em.createQuery(
                "select l from LocationEntity l "
                + "where l.user.id = :uid "
                + "order by l.date desc ",
                LocationEntity.class
        );
        q.setParameter("uid", userId);
        q.setMaxResults(limit);

        return q.getResultList();
    }
}
