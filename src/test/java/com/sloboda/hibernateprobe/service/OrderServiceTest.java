package com.sloboda.hibernateprobe.service;

import com.sloboda.hibernateprobe.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class OrderServiceTest extends BaseTest {
    @Autowired
    private OrderService orderService;

    @Test
    void save() {
        orderService.save();
    }

    @Test
    void setExpress() {
        orderService.setExpress(1L, false);
    }

    @Test
    void addItem() {
        orderService.addItem(1, 1);
    }
}