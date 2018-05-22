/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.entity;

import javax.persistence.*;

/**
 * Represents user's single interest.
 */
@Entity
@Table(name = "interests")
public class InterestEntity {
    /**
     * Unique id.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Keyword.
     */
    @Column(length = 50)
    private String keyword;

    /**
     * Interest category
     */
    @Enumerated(value = EnumType.STRING)
    private InterestCategory category;

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public InterestEntity setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public InterestCategory getCategory() {
        return category;
    }

    public InterestEntity setCategory(InterestCategory category) {
        this.category = category;
        return this;
    }
}
