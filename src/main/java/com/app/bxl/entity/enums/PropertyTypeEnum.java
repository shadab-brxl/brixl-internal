package com.app.bxl.entity.enums;

//public enum PropertyTypeEnum {
//    APARTMENT, VILLA, STUDIO, PENTHOUSE, FARMHOUSE, COTTAGE
//}

public enum PropertyTypeEnum {
    APARTMENT("Apartment"),
    VILLA("Villa"),
    STUDIO("Studio"),
    PENTHOUSE("Penthouse"),
    FARMHOUSE("Farmhouse"),
    COTTAGE("Cottage"),
    PLOT("Plot");

    private final String value;

    PropertyTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
