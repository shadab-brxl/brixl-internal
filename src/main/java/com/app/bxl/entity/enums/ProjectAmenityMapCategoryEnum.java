package com.app.bxl.entity.enums;

public enum ProjectAmenityMapCategoryEnum {

    TRANSPORTATION("Transportation", 0),
    HEALTHCARE("Healthcare", 1),
    EDUCATION("Education", 2),
    LIFESTYLE("Lifestyle", 3),
    FOOD_HUB("Food Hub", 4),
    BUSINESS_HUB("Business Hub", 5),
    OTHER("Other", 6);

    private String value;
    private int priority;


    ProjectAmenityMapCategoryEnum(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue(){
        return value;
    }

    public int getPriority(){
        return priority;
    }
}
