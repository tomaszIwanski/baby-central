package com.archangel_design.babyscheduller.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "baby_metrics")
public class BabyMetricsEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    private Integer heightmm;

    private Float weight;

    public Long getId() {
        return id;
    }

    public BabyMetricsEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public BabyMetricsEntity setDate(Date date) {
        this.date = date;
        return this;
    }

    public Integer getHeightmm() {
        return heightmm;
    }

    public BabyMetricsEntity setHeightmm(Integer heightmm) {
        this.heightmm = heightmm;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public BabyMetricsEntity setWeight(Float weight) {
        this.weight = weight;
        return this;
    }
}
