package com.app.bxl.entity.converter;

import com.app.bxl.entity.enums.BHKTypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BHKTypeConverter implements AttributeConverter<BHKTypeEnum, String> {
    @Override
    public String convertToDatabaseColumn(BHKTypeEnum bhkType) {
        return bhkType != null ? bhkType.getVal() : null;
    }

    @Override
    public BHKTypeEnum convertToEntityAttribute(String code) {
        return code != null ? BHKTypeEnum.getEnumfromValue(code) : null;
    }
}
