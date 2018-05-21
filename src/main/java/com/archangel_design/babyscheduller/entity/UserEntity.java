package com.archangel_design.babyscheduller.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"id", "deleted", "password"})
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 36)
    private String uuid = UUID.randomUUID().toString();

    @Column(length = 150)
    private String email;

    @Column(length = 150)
    private String password;

    private Date registration;

    private Date lastUsage;

    private Boolean deleted = false;

    @OneToMany(targetEntity = BabyEntity.class)
    @JoinColumn(name = "parent_id")
    private List<BabyEntity> babies = new ArrayList<>();

    @ManyToOne(targetEntity = OrganizationEntity.class,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH})
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UserEntity setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getRegistration() {
        return registration;
    }

    public UserEntity setRegistration(Date registration) {
        this.registration = registration;
        return this;
    }

    public Date getLastUsage() {
        return lastUsage;
    }

    public UserEntity setLastUsage(Date lastUsage) {
        this.lastUsage = lastUsage;
        return this;
    }

    public List<BabyEntity> getBabies() {
        return babies;
    }

    public UserEntity setBabies(List<BabyEntity> babies) {
        this.babies = babies;
        return this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public UserEntity setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public UserEntity setOrganization(OrganizationEntity organization) {
        this.organization = organization;
        return this;
    }
}
