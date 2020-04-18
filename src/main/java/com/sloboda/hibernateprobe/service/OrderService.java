package com.sloboda.hibernateprobe.service;

import java.time.ZonedDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.sloboda.hibernateprobe.entity.Client;
import com.sloboda.hibernateprobe.entity.Item;
import com.sloboda.hibernateprobe.entity.Order;
import com.sloboda.hibernateprobe.entity.OrderItem;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class OrderService {
    @PersistenceContext
    private EntityManager em;

    public void save() {
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Doe");

        em.persist(client);

        Order order = new Order();
        order.setClient(client);
        order.setCreated(ZonedDateTime.now());
        order.setExpress(true);
        order.setStatus("N"); // NEW
        order.setAddressCity("Kiev");
        order.setAddressStreet("Kreschatik str.");
        order.setAddressBuilding("10");

        em.persist(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setItem(em.find(Item.class, 1L));
        orderItem.setOrder(order);
        orderItem.setQuantity(2);

        em.persist(orderItem);
    }
}
