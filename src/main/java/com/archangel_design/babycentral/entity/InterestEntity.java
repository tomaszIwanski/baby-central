/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interests")
public class InterestEntity {
    @Id
    @GeneratedValue
    private Long id;
}
