package com.archangel_design.babycentral.entity;

import com.archangel_design.babycentral.enums.EventType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue
    private Long id;

    private EventType type;

    private Date date;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public EventEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public EventType getType() {
        return type;
    }

    public EventEntity setType(EventType type) {
        this.type = type;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public EventEntity setDate(Date date) {
        this.date = date;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public EventEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
