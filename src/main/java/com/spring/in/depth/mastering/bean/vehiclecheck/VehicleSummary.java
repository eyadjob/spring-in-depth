package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleSummary {

    @JsonProperty("statusId")
    private Integer statusId;
    @JsonProperty("plateNumber")
    private String plateNumber;
    @JsonProperty("category")
    private String category;
    @JsonProperty("model")
    private String model;
    @JsonProperty("manufactureYear")
    private Integer manufactureYear;

    @JsonProperty("statusId")
    public Integer getStatusId() {
        return statusId;
    }

    @JsonProperty("statusId")
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @JsonProperty("plateNumber")
    public String getPlateNumber() {
        return plateNumber;
    }

    @JsonProperty("plateNumber")
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("manufactureYear")
    public Integer getManufactureYear() {
        return manufactureYear;
    }

    @JsonProperty("manufactureYear")
    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

}