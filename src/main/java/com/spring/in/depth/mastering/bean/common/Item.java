package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @JsonProperty("isAirport")
    public Boolean getIsAirport() {
        return isAirport;
    }

    @JsonProperty("isAirport")
    public void setIsAirport(Boolean isAirport) {
        this.isAirport = isAirport;
    }


    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("phoneCode")
    public String getPhoneCode() {
        return phoneCode;
    }

    @JsonProperty("phoneCode")
    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @JsonProperty("flagUrl")
    public String getFlagUrl() {
        return flagUrl;
    }

    @JsonProperty("flagUrl")
    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    @JsonProperty("flagId")
    public String getFlagId() {
        return flagId;
    }

    @JsonProperty("flagId")
    public void setFlagId(String flagId) {
        this.flagId = flagId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }


}
