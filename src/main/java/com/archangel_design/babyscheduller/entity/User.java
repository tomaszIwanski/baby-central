package com.archangel_design.babyscheduller.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

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

    @OneToMany(targetEntity = Baby.class)
    @JoinColumn(name = "parent_id")
    private List<Baby> babies = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public User setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getRegistration() {
        return registration;
    }

    public User setRegistration(Date registration) {
        this.registration = registration;
        return this;
    }

    public Date getLastUsage() {
        return lastUsage;
    }

    public User setLastUsage(Date lastUsage) {
        this.lastUsage = lastUsage;
        return this;
    }
}
