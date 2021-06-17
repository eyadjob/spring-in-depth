package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    @JsonProperty("value")
    private String value;
    @JsonProperty("displayText")
    private String displayText;
    @JsonProperty("isSelected")
    private Boolean isSelected;

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("displayText")
    public String getDisplayText() {
        return displayText;
    }

    @JsonProperty("displayText")
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    @JsonProperty("isSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("isSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

}