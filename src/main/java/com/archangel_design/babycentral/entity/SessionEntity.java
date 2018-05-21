package com.archangel_design.babycentral.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "sessions")
public class SessionEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String sessionId = UUID.randomUUID().toString();

    private Date created;

    private Date expiration;

    private String deviceId;

    public Long getId() {
        return id;
    }

    public SessionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public SessionEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public SessionEntity setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public SessionEntity setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getExpiration() {
        return expiration;
    }

    public SessionEntity setExpiration(Date expiration) {
        this.expiration = expiration;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public SessionEntity setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }
}
