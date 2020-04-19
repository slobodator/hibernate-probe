package com.sloboda.hibernateprobe.service;

import java.util.List;

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

        order.addItem(item);
    }

    public Order load(long orderId) {
        return em.find(Order.class, orderId);
    }

    public List<Order> loadAll() {
        return em.createQuery("select o from Order o", Order.class)
                .getResultList();
    }
}
