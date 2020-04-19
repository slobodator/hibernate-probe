package com.sloboda.hibernateprobe.mapper;

import com.sloboda.hibernateprobe.dto.ItemDto;
import com.sloboda.hibernateprobe.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ItemMapper {
    @Mapping(source = "price.number", target = "priceAmount")
    @Mapping(source = "price.currency.currencyCode", target = "priceCurrency")
    ItemDto toDto(Item item);
}
