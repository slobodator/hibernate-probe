package com.sloboda.hibernateprobe.entity.article;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {
    NEW("N"),
    PROCESSING("P"),
    COMPLETED("C"),
    DEFERRED("D");

    @Getter
    private final String code;
}
