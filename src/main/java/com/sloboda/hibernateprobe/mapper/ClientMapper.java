package com.sloboda.hibernateprobe.mapper;

import com.sloboda.hibernateprobe.dto.ClientDto;
import com.sloboda.hibernateprobe.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientDto toDto(Client client);
}
