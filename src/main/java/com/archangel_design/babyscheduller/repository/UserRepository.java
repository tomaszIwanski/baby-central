package com.archangel_design.babyscheduller.repository;

import com.archangel_design.babyscheduller.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserRepository {

    @PersistenceContext
    EntityManager em;

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


}
