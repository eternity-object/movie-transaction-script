package org.eternity.script.generic;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class MoneyConverter implements AttributeConverter<Money, Long> {
    @Override
    public Long convertToDatabaseColumn(Money attribute) {
        return attribute.longValue();
    }

    @Override
    public Money convertToEntityAttribute(Long dbData) {
        return Money.wons(dbData);
    }
}
