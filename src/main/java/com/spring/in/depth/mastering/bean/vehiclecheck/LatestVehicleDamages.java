package com.spring.in.depth.mastering.bean.vehiclecheck;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LatestVehicleDamages {

    @JsonProperty("skeletonBodyDamages")
    private List<Object> skeletonBodyDamages = null;
    @JsonProperty("otherDamages")
    private List<Object> otherDamages = null;
    @JsonProperty("checkItemLatestStatuses")
    private List<Object> checkItemLatestStatuses = null;

}