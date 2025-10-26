package com.app.bxl.entity.enums;

public enum ProjectTagEnum {
    HOT_SELLING("Hot Selling"),
    MOST_VIEWED("Most Viewed"),
    FREQUENTLY_VISITED("Frequently Visited"),
    NEW("New");

    private String value;

    public String getVal(){
        return value;
    }

    ProjectTagEnum(String value) {
        this.value = value;
    }

    public static ProjectTagEnum getEnumfromValue(String code){
        for(ProjectTagEnum projectTagEnum : ProjectTagEnum.values()){
            if(projectTagEnum.value.equals(code)) return projectTagEnum;
        }
        return null;
    }

}
