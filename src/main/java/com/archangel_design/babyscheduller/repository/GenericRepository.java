package com.archangel_design.babyscheduller.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GenericRepository {
    @PersistenceContext
    protected EntityManager em;
}
