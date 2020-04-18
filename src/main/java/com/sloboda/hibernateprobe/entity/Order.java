package com.sloboda.hibernateprobe.entity;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import com.sloboda.hibernateprobe.converter.OrderStatusConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client client;

    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus status;

    @Setter
    private boolean express;

    private ZonedDateTime created;

    @Embedded
    @AttributeOverride(name = "city", column = @Column(name = "address_city"))
    @AttributeOverride(name = "street", column = @Column(name = "address_street"))
    @AttributeOverride(name = "building", column = @Column(name = "address_building"))
    private Address address;

    @ElementCollection
    @Column(name = "quantity")
    @MapKeyJoinColumn(name = "item_id")
    private Map<Item, Integer> items;

    public Order(Client client, Address address) {
        this.client = client;
        this.address = address;

        this.status = OrderStatus.NEW;
        this.express = false;
        this.created = ZonedDateTime.now();
        this.items = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order that = (Order) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
