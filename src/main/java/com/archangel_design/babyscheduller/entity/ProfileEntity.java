/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babyscheduller.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "profiles")
@JsonIgnoreProperties(value = {"id"})
public class ProfileEntity {
    /**
     * Unique ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Surname.
     */
    private String lastName;

    /**
     * Country of origin.
     */
    private String countryOfOrigin;

    /**
     * Country of current residence.
     */
    private String currentCountry;

    /**
     * Date of birth.
     */
    private Date dob;

    /**
     * List of interests used for suggestions.
     */
    private List<InterestEntity> interests = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfileEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public ProfileEntity setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public ProfileEntity setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public ProfileEntity setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public List<InterestEntity> getInterests() {
        return interests;
    }

    public ProfileEntity setInterests(List<InterestEntity> interests) {
        this.interests = interests;
        return this;
    }
}
