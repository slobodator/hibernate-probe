package com.sloboda.hibernateprobe.mapper;

import com.sloboda.hibernateprobe.dto.AddressDto;
import com.sloboda.hibernateprobe.entity.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {
    AddressDto toDto(Address address);
}
