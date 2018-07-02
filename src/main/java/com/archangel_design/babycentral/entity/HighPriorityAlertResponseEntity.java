package com.archangel_design.babycentral.entity;

import javax.persistence.*;

@Entity
@Table(name = "high_priority_alert_response")
public class HighPriorityAlertErsponseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ScheduleEntryEntity tmp;
}
