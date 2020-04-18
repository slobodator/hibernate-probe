package com.sloboda.hibernateprobe.entity;

import org.javamoney.moneta.Money;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OrderTest {
    @Test
    public void addRemoveItem() {
        Item item = new Item("test", Money.of(100, "USD"));
        Order order = new Order(
                new Client("anyName", "anySurname"),
                new Address("address", "doesn't", "exist")
        );

        order.addItem(item);
        assertThat(order.getItems().get(item), equalTo(1));
        order.addItem(item);
        assertThat(order.getItems().get(item), equalTo(2));

        order.removeItem(item);
        assertThat(order.getItems().get(item), equalTo(1));

        order.removeItem(item);
        assertThat(order.getItems().get(item), equalTo(null));
    }
}