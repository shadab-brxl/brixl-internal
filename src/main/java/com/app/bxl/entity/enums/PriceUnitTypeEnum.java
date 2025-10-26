package com.app.bxl.entity.enums;

public enum PriceUnitTypeEnum {
    LAKHS("L"),
    CRORES("Cr");

    private String value;

    PriceUnitTypeEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
