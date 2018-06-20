package com.archangel_design.babycentral.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shopping_card_entries")
@Getter
@Setter
public class ShoppingCardEntryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 36)
    private String uuid = UUID.randomUUID().toString();

    @Column(length = 120)
    private String articleName;

    private Integer quantity;

    private Boolean isPurchased = false;

}
