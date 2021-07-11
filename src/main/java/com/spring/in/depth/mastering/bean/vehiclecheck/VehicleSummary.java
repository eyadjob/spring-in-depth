package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
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

}