package com.app.bxl.entity.enums;

public enum ProjectAssetCategoryEnum {
    COVER(0),
    VIDEOS( 1),
    ELEVATION( 2),
    AMENITIES(3),
    BEDROOM( 4),
    KITCHEN( 5),
    LIVING_AREA( 6),
    BALCONY(7),
    BATHROOM(8),
    DINING_AREA(9),
    KIDS_PLAY_AREA(10),
    PLAY_AREA(11),
    DROP_OFF_AREA(12),
    GYM(13),
    MINI_SOCCER(14),
    MULTIPURPOSE_COURT(15),
    SEATING_AREA(16),
    SECURITY_CABIN(17),
    GARDEN(18),
    SWIMMING_POOL(19),
    ENTRANCE(20),
    FOOTBALL_COURT(21),
    AMPHITHEATRE(22),
    BIRD_WATCHING_AREA(23),
    CLUBHOUSE(24),
    BONFIRE(25),
    LOBBY(26),
    PARKING_AREA(27),
    SPA(28),
    INDOOR_GAME_ROOM(29),
    PARTY_HALL(30),
    FLOOR_PLAN( 31),
    MASTER_PLAN(32),
    LOCATION_PLAN( 33),
    CLUSTER_PLAN( 34),
    LAYOUT(35),
    PLOT(36),
    //VILLA(15),
    ONE_RK_2D(37),
    ONE_RK_3D(38),
    ONE_BHK_2D(39),
    ONE_BHK_3D(40),
    TWO_BHK_2D(41),
    TWO_BHK_3D(42),
    TWO_AND_HALF_BHK_2D(43),
    TWO_AND_HALF_BHK_3D(44),
    THREE_BHK_2D(45),
    THREE_BHK_3D(46),
    THREE_AND_HALF_BHK_2D(47),
    THREE_AND_HALF_BHK_3D(48),
    FOUR_BHK_2D(49),
    FOUR_BHK_3D(50),
    FOUR_AND_HALF_BHK_2D(51),
    FOUR_AND_HALF_BHK_3D(52),
    FIVE_BHK_2D(53),
    FIVE_BHK_3D(54),
    BROCHURE(55);

    private int priority;

    ProjectAssetCategoryEnum( int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }

    public static ProjectAssetCategoryEnum getEnumfromValue(String priority){
        for(ProjectAssetCategoryEnum projectAssetCategoryEnum : ProjectAssetCategoryEnum.values()){
            if(projectAssetCategoryEnum.name().equals(priority))
                return projectAssetCategoryEnum;
        }
        return null;
    }
}


