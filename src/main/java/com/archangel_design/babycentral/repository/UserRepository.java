/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.repository;

import com.archangel_design.babycentral.entity.BabyEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
public class UserRepository extends GenericRepository {

    /**
     * Returns UserEntity matching criteria
     * or null if not found
     *
     * @param email        user email
     * @param passwordHash hashed password
     * @return UserEntity|null
     */
    public UserEntity fetch(String email, String passwordHash) {
        TypedQuery<UserEntity> query = em.createQuery(
                "select u from UserEntity u "
                        + "where u.email = :email "
                        + "and u.password = :password",
                UserEntity.class
        );

        query.setParameter("email", email);
        query.setParameter("password", passwordHash);

        return query.getResultList().stream().findFirst().orElse(null);
    }

    /**
     * Returns UserEntity matching criteria
     * or null if not found
     *
     * @param email user email
     * @return UserEntity|null
     */
    public UserEntity fetch(String email) {
        TypedQuery<UserEntity> query = em.createQuery(
                "select u from UserEntity u "
                        + "where u.email = :email ",
                UserEntity.class
        );

        query.setParameter("email", email);

        return query.getResultList().stream().findFirst().orElse(null);
    }

    /**
     * Returns true if user identified by given email
     * is already registered. Does not include deleted accounts
     *
     * @param email user email
     * @return true|false
     */
    public Boolean userExists(String email) {
        TypedQuery<Long> query = em.createQuery(
                "select count(u) from UserEntity u "
                        + "where lower(u.email) = :email "
                        + "and u.deleted = false",
                Long.class
        );
        query.setParameter("email", email.toLowerCase());

        return query.getSingleResult() > 0;
    }

    public BabyEntity fetchBaby(String babyId) {
        TypedQuery<BabyEntity> query = em.createQuery(
                "select b from BabyEntity b "
                + "where b.uuid = :uuid", BabyEntity.class
        );
        query.setParameter("uuid", babyId);

        return query.getResultList().stream().findFirst().orElse(null);
    }
}
