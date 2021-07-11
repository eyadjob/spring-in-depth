package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Item {

    @JsonProperty("value")
    private String value;
    @JsonProperty("displayText")
    private String displayText;
    @JsonProperty("isSelected")
    private Boolean isSelected;
    @JsonProperty("number")
    private String number;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phoneCode")
    private String phoneCode;
    @JsonProperty("flagUrl")
    private String flagUrl;
    @JsonProperty("flagId")
    private String flagId;
    @JsonProperty("id")
    private int id;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("locations")
    private List<Location> locations = null;
    @JsonProperty("isAirport")
    private Boolean isAirport;

}
