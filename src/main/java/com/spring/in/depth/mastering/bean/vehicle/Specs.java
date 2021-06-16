package com.spring.in.depth.mastering.bean.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Specs {

    @JsonProperty("colorId")
    private String colorId;
    @JsonProperty("trimLevelId")
    private String trimLevelId;
    @JsonProperty("fuelTypeId")
    private String fuelTypeId;
    @JsonProperty("fuelTankSize")
    private Integer fuelTankSize;


    @JsonProperty("colorId")
    public String getColorId() {
        return colorId;
    }

    @JsonProperty("colorId")
    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    @JsonProperty("trimLevelId")
    public String getTrimLevelId() {
        return trimLevelId;
    }

    @JsonProperty("trimLevelId")
    public void setTrimLevelId(String trimLevelId) {
        this.trimLevelId = trimLevelId;
    }

    @JsonProperty("fuelTypeId")
    public String getFuelTypeId() {
        return fuelTypeId;
    }

    @JsonProperty("fuelTypeId")
    public void setFuelTypeId(String fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    @JsonProperty("fuelTankSize")
    public Integer getFuelTankSize() {
        return fuelTankSize;
    }

    @JsonProperty("fuelTankSize")
    public void setFuelTankSize(Integer fuelTankSize) {
        this.fuelTankSize = fuelTankSize;
    }

}