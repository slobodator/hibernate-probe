package com.sloboda.hibernateprobe.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.sloboda.hibernateprobe.entity.OrderStatus;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {
    @Override
    public String convertToDatabaseColumn(OrderStatus status) {
        return status.getCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String code) {
        return OrderStatus.findBy(code);
    }
}
