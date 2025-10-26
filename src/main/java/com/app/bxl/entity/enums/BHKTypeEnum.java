package com.app.bxl.entity.enums;

public enum BHKTypeEnum {
    ONE_RK("1RK"),
    ONE_BHK("1BHK"),
    TWO_BHK("2BHK"),
    TWO_AND_HALF_BHK("2.5BHK"),
    THREE_BHK("3BHK"),
    THREE_AND_HALF_BHK("3.5BHK"),
    FOUR_BHK("4BHK"),
    FOUR_AND_HALF_BHK("4.5BHK"),
    FIVE_BHK("5BHK");

    private String name;

    private BHKTypeEnum(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public static String getEnumByString(String code){
        for(BHKTypeEnum bhkTypeEnum : BHKTypeEnum.values()){
            if(bhkTypeEnum.name.equals(code)) return bhkTypeEnum.name();
        }
        return null;
    }

    public static BHKTypeEnum getEnumfromValue(String code){
        for(BHKTypeEnum bhkTypeEnum : BHKTypeEnum.values()){
            if(bhkTypeEnum.name.equals(code)) return bhkTypeEnum;
        }
        return null;
    }

    public String getVal(){
        return name;
    }
}
