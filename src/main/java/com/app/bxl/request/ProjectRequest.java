package com.app.bxl.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {

    private String name;

    @JsonProperty("appr_auth")
    private String apprAuth; // Approving Authority.

    @JsonProperty("builder_name")
    private String builderName;

    @JsonProperty("is_brix_adv")
    private Boolean isBrixAdv;

    @JsonProperty("is_biaapa_approved")
    private Boolean isBiaapaApproved;

    private String status;

    @JsonProperty("is_active")
    private Boolean isActive;

    private String type;

    @JsonProperty("total_area")
    private BigDecimal totalArea;

    @JsonProperty("pta_unit_type")
    private String ptaUnitType;

    @JsonProperty("about_project")
    private String aboutProject;

    @JsonProperty("poss_date")
    private Date possDate;

    @JsonProperty("total_units")
    private Integer totalUnits;

    private String tag;

    @JsonProperty("city_code")
    private String cityCode;

    private String locality;
    private String state;
    private String country;

    private String addr1;
    private String addr2;

    private Double lat;
    private Double lon;

    private String pincode;
    private String landmark;

    @JsonProperty("project_id")
    private String projectId;

    private ImgRequest img;
    // UNIT DETAILS
    @JsonProperty("unit")
    private String unit;

    @JsonProperty("unit_cat")
    private String unitCat;

    @JsonProperty("unit_name")
    private String unitName;

    @JsonProperty("unit_status")
    private String unitStatus;

    @JsonProperty("carpet_area")
    private BigDecimal carpetArea;

    @JsonProperty("superbuiltup_area")
    private BigDecimal superBuiltupArea;

    private BigDecimal price;

    @JsonProperty("unit_type")
    private String unitType;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("unit_img_url")
    private String unitImgUrl;

    // AMENITY DETAILS
    @JsonProperty("amenity_type")
    private String amenityType;

    @JsonProperty("amenity_name")
    private String amenityName;

    private String dist;

    // builder details
    @JsonProperty("builder_logo")
    private String builderLogo;

    @JsonProperty("builder_rera")
    private String builderRera;

    @JsonProperty("builder_yoe")
    private Integer builderYoe;

    @JsonProperty("completed_projects")
    private Integer completedProjects;

    @JsonProperty("new_launches")
    private Integer newLaunches;

    @JsonProperty("under_construction")
    private Integer underConstruction;

    @JsonProperty("total_projects")
    private Integer totalProjects;

    @JsonProperty("builder_about_us")
    private String builderAboutUs;

}