package com.sloboda.hibernateprobe.entity;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderStatus {
    NEW("N"),
    PROCESSING("P"),
    COMPLETED("C"),
    DEFERRED("D");

    @Getter
    private final String code;

    public static OrderStatus findBy(String code) {
        return Stream.of(values())
                .filter(v -> v.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown code " + code));
    }
}
