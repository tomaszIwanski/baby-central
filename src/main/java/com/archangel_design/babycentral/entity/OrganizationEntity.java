package com.archangel_design.babycentral.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "organizations")
@JsonIgnoreProperties(value = {"id"})
public class OrganizationEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Date creationDate = new Date();

    public Long getId() {
        return id;
    }

    public OrganizationEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrganizationEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public OrganizationEntity setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
