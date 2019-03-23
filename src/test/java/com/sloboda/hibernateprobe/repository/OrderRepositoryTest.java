package com.sloboda.hibernateprobe.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import javax.money.Monetary;

import com.sloboda.hibernateprobe.BaseTest;
import com.sloboda.hibernateprobe.entity.article.Address;
import com.sloboda.hibernateprobe.entity.article.Item;
import com.sloboda.hibernateprobe.entity.article.Order;
import com.sloboda.hibernateprobe.entity.article.Client;
import org.javamoney.moneta.Money;
import org.junit.Test;

public class OrderRepositoryTest extends BaseTest {
    @Test
    public void test() {
        Order order = new Order(
                new Address("Kiev", "Shevchenko av.", "23"),
                new Client("John", "Doe")
        );
        Item item1 = new Item("item1", Money.of(100, "USD"));
        em.persist(item1);

        order.addItem(item1);
        em.persist(order);

        assertThat(
                em.createQuery("select i from Item i where i.price.currencyUnit = :c", Item.class)
                        .setParameter("c", Monetary.getCurrency("USD"))
                        .getResultList(),
                hasSize(1)
        );

        assertThat(
                em.createQuery("select o from Order o where o.client.id = :id", Order.class)
                        .setParameter("id", -1L)
                        .getResultList(),
                hasSize(0)
        );

        Long clientId = order.getClient().getId();
        assertThat(
                em.createQuery("select o from Order o where o.client = :client", Order.class)
                        .setParameter("client", em.getReference(Client.class, clientId))
                        .getResultList(),
                hasSize(1)
        );
    }
}