package com.sloboda.hibernateprobe.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.sloboda.hibernateprobe.entity.Address;
import com.sloboda.hibernateprobe.entity.Client;
import com.sloboda.hibernateprobe.entity.Order;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class OrderService {
    @PersistenceContext
    private EntityManager em;

    public void save() {
        Client client = new Client("John", "Doe");
        em.persist(client);

        Address address = new Address("Kiev", "Kreschatik str.", "10");

        Order order = new Order(client, address);
        em.persist(order);
    }

    public void setExpress(long orderId, boolean express) {
        Order order = em.find(Order.class, orderId);
        order.setExpress(express);

        // em.persist() or em.merge() ?
        // em.flush() ?
    }
}
