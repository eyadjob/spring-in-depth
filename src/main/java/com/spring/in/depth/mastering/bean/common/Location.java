package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Location {

    @JsonProperty("value")
    private String value;
    @JsonProperty("displayText")
    private String displayText;
    @JsonProperty("isSelected")
    private Boolean isSelected;
}