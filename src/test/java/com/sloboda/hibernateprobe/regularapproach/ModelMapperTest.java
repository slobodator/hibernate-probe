package com.sloboda.hibernateprobe.regularapproach;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModelMapperTest {
    @Test
    void mapping() {
        ModelMapper modelMapper = new ModelMapper();
        User user = new User("John", "Doe");
        UserDto userDto = modelMapper.map(user, UserDto.class);

        assertThat(userDto.getFistName()).isEqualTo("John");
        assertThat(userDto.getLastName()).isEqualTo("Doe");
    }
}
