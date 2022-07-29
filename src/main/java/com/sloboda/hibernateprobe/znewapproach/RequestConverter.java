package com.sloboda.hibernateprobe.znewapproach;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;

//@Converter(autoApply = true)
public class RequestConverter implements AttributeConverter<Request, String> {
    @Override
    public String convertToDatabaseColumn(Request request) {
        return request.name() + "1";
    }

    @Override
    public Request convertToEntityAttribute(String s) {
        return Request.valueOf(s);
    }
}
