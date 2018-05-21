/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.repository;

import com.archangel_design.babycentral.entity.LocationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Persistence layer for location services
 */
@Repository
public class LocationRepository extends GenericRepository {

    /**
     * Returns <code>limit</code> last location updates.
     *
     * @param userId ID of the user
     * @param limit integer
     * @return recent location updates
     */
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
