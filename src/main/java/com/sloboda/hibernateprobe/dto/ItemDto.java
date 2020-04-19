package com.sloboda.hibernateprobe.dto;

import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private Number priceAmount;
    private String priceCurrency;
}
