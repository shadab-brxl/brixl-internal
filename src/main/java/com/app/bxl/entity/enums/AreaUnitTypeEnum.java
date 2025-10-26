package com.app.bxl.entity.enums;

public enum AreaUnitTypeEnum {
    ACRES("acres"),
    SQUARE_FEET("sq. ft."),
    SQUARE_METER("sq. mt.");

    private String value;

    AreaUnitTypeEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
