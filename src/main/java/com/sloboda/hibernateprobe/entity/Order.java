package com.sloboda.hibernateprobe.entity;

import java.time.ZonedDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sloboda.hibernateprobe.converter.OrderStatusConverter;
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

    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus status;

    private boolean express;
    private ZonedDateTime created;

    private String addressCity;
    private String addressStreet;
    private String addressBuilding;
}
