package com.sloboda.hibernateprobe.mapper;

import com.sloboda.hibernateprobe.dto.OrderDto;
import com.sloboda.hibernateprobe.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        uses = {
                ClientMapper.class,
                ItemMapper.class
        }
)
public interface OrderMapper {
    OrderDto toFullDto(Order order);

    @Mapping(target = "items", ignore = true)
    OrderDto toBriefDto(Order order);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "items", ignore = true)
    OrderDto toMinimalDto(Order order);
}
