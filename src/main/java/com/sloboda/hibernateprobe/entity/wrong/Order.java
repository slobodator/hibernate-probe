package com.sloboda.hibernateprobe.entity.wrong;

import java.time.LocalDateTime;

import javax.money.MonetaryAmount;

import com.sloboda.hibernateprobe.entity.article.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Order {
    private LocalDateTime dateTime;
    private OrderStatus status;
    private boolean express;
    private Address address;
    private MonetaryAmount money;
    private Client client;

    @AllArgsConstructor
    public enum OrderStatus {
        NEW("N"),
        PROCESSING("P"),
        COMPLETED("C"),
        DEFERRED("D");

        @Getter
        private final String code;
    }

    public static class Address {
        private String city;
        private String street;
        private String building;
    }
}
