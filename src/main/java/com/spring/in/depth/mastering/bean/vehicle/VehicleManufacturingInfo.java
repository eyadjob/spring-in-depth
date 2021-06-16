package com.spring.in.depth.mastering.bean.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleManufacturingInfo {

    @JsonProperty("modelId")
    private String modelId;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("chassisNo")
    private String chassisNo;

    @JsonProperty("modelId")
    public String getModelId() {
        return modelId;
    }

    @JsonProperty("modelId")
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("chassisNo")
    public String getChassisNo() {
        return chassisNo;
    }

    @JsonProperty("chassisNo")
    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

}