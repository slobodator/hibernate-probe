package com.sloboda.hibernateprobe.entity.article;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Getter
@EqualsAndHashCode(of = {"created", "client"})
@ToString(of = {"created", "address", "express", "status"})
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "address_city", nullable = false, length = 32)),
            @AttributeOverride(name = "street", column = @Column(name = "address_street", nullable = false, length = 32)),
            @AttributeOverride(name = "building", column = @Column(name = "address_building", nullable = false, length = 32))
    })
    private Address address;

    @Setter
    private boolean express;

    @Column(length = 1, nullable = false)
    @Setter
    private Status status = Status.NEW;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false)
    private Client client;

    @LazyCollection(LazyCollectionOption.EXTRA)
    @ElementCollection
    @Column(name = "quantity", nullable = false)
    @MapKeyJoinColumn(name = "item_id")
    private Map<Item, Integer> items = new HashMap<>();

    public Order(Address address, Client client) {
        this.address = address;
        this.client = client;
    }

    public Map<Item, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public void addItem(Item item) {
        items.merge(item, 1, Integer::sum);
    }

    public void removeItem(Item item) {
        items.computeIfPresent(item, (k, v) -> v > 1 ? v - 1 : null);
    }
}


