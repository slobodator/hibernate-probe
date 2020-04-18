package com.sloboda.hibernateprobe.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.sloboda.hibernateprobe.entity.Address;
import com.sloboda.hibernateprobe.entity.Client;
import com.sloboda.hibernateprobe.entity.Item;
import com.sloboda.hibernateprobe.entity.Order;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class OrderService {
    @PersistenceContext
    private EntityManager em;

    public void save() {
        Order order = new Order(
                new Client("John", "Doe"),
                new Address("Kiev", "Kreschatik str.", "10")
        );
        em.persist(order);
    }

    public void setExpress(long orderId, boolean express) {
        Order order = em.find(Order.class, orderId);
        order.setExpress(express);
    }

    public void addItem(long orderId, long itemId) {
        Order order = em.find(Order.class, orderId);
        Item item = em.find(Item.class, itemId);

        Integer quantity = order.getItems().get(item);

        if (quantity == null) {
            quantity = 1;
        } else {
            quantity = quantity + 1;
        }

        order.getItems().put(item, quantity);
    }
}
