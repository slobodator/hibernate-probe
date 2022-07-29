package com.sloboda.hibernateprobe.regularapproach;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Mapping(target = "fistName", ignore = true)
    UserDto toResponse(User user);

    default <T> T unwrap(Optional<T> optional) {
        return optional.orElse(null);
    }
}
