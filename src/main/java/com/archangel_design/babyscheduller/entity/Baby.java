package com.archangel_design.babyscheduller.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "babies")
public class Baby {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 80)
    private String name;

    private Date birthday;

    public Long getId() {
        return id;
    }

    public Baby setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Baby setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Baby setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}
