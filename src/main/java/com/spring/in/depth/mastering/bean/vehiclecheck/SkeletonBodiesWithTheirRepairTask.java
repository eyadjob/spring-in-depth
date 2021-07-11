package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SkeletonBodiesWithTheirRepairTask {

    @JsonProperty("skeletonBodyId")
    private Integer skeletonBodyId;
    @JsonProperty("skeletonBodyColor")
    private Double skeletonBodyColor;
    @JsonProperty("damageId")
    private Integer damageId;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("damageName")
    private String damageName;
    @JsonProperty("repairTask")
    private RepairTask repairTask;

}