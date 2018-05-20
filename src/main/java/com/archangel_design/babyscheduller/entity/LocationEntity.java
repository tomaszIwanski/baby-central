package com.archangel_design.babyscheduller.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "locations")
public class LocationEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long lat;

    private Long lon;

    private Long alt;

    private Date date;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public LocationEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getLat() {
        return lat;
    }

    public LocationEntity setLat(Long lat) {
        this.lat = lat;
        return this;
    }

    public Long getLon() {
        return lon;
    }

    public LocationEntity setLon(Long lon) {
        this.lon = lon;
        return this;
    }

    public Long getAlt() {
        return alt;
    }

    public LocationEntity setAlt(Long alt) {
        this.alt = alt;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public LocationEntity setDate(Date date) {
        this.date = date;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public LocationEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
