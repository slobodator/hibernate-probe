package com.sloboda.hibernateprobe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String str;
    private Optional<Integer> i;
    private Instant instant = Instant.now();
    private LocalDateTime localDateTime = LocalDateTime.now();

    public ItemDto(String str, Integer i) {
        this.str = str;
        this.i = Optional.ofNullable(i);
    }
}
