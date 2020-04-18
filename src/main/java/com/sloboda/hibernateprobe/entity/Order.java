package com.sloboda.hibernateprobe.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private boolean express;
    private ZonedDateTime created;

    private String addressCity;
    private String addressStreet;
    private String addressBuilding;
}
