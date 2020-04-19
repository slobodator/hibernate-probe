package com.sloboda.hibernateprobe.dto;

import java.time.ZonedDateTime;
import java.util.Map;

import com.sloboda.hibernateprobe.entity.OrderStatus;
import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private ClientDto client;
    private OrderStatus status;
    private boolean express;
    private ZonedDateTime created;
    private AddressDto address;
    private Map<ItemDto, Integer> items;
}
