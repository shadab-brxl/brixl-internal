package com.app.bxl.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImgRequest {
    @JsonProperty("img_type")
    private String imgType;

    @JsonProperty("img_category")
    private String imgCategory;

    @JsonProperty("img_context")
    private String imgContext;

    @JsonProperty("img_priority")
    private Integer imgPriority;

    @JsonProperty("img_url")
    private String imgUrl;

    @JsonProperty("img_desc")
    private String imgDesc;
}
