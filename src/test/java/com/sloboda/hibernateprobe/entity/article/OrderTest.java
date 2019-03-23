package com.sloboda.hibernateprobe.entity.article;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class OrderTest {
    @Test
    public void addRemoveItem() {
        Item item = new Item("test", Money.of(100, "USD"));
        Order order = new Order();

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