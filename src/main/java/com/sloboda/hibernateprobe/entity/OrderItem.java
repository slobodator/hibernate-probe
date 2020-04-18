package com.sloboda.hibernateprobe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem implements Serializable {
    @Id
    @ManyToOne
    private Order order;

    @Id
    @ManyToOne
    private Item item;

    private Integer quantity;
}
