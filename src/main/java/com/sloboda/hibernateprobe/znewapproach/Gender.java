package com.sloboda.hibernateprobe.znewapproach;

import lombok.RequiredArgsConstructor;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

@RequiredArgsConstructor
public enum Gender {
    FEMALE("F"),
    MALE("M"),
    DIVERSE("D");

    private final String abbr;

    @javax.persistence.Converter(autoApply = true)
    public static class Converter implements AttributeConverter<Gender, String> {
        @Override
        public String convertToDatabaseColumn(Gender gender) {
            return gender != null
                    ? gender.abbr
                    : null;
        }

        @Override
        public Gender convertToEntityAttribute(String s) {
            return Stream.of(values())
                    .filter(v -> v.abbr.equals(s))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown gender %s", s)));
        }
    }
}
