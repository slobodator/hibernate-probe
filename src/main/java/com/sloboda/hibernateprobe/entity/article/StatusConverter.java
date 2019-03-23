package com.sloboda.hibernateprobe.entity.article;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getCode();
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        for (Status status : Status.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown code " + code);
    }
}
