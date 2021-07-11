package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result {

    @JsonProperty("countryId")
    private Integer countryId;
    @JsonProperty("fuelId")
    private Integer fuelId;
    @JsonProperty("odometer")
    private Object odometer;
    @JsonProperty("minimumOdomter")
    private Integer minimumOdomter;
    @JsonProperty("maximumOdomter")
    private Integer maximumOdomter;
    @JsonProperty("checkType")
    private CheckType checkType;
    @JsonProperty("checklistDetails")
    private List<ChecklistDetail> checklistDetails = null;
    @JsonProperty("latestVehicleCheckListStatus")
    private List<Object> latestVehicleCheckListStatus = null;
    @JsonProperty("vehicleSkeletonDetails")
    private VehicleSkeletonDetails vehicleSkeletonDetails;
    @JsonProperty("latestVehicleDamages")
    private LatestVehicleDamages latestVehicleDamages;
    @JsonProperty("skeletonBodiesWithTheirRepairTasks")
    private List<SkeletonBodiesWithTheirRepairTask> skeletonBodiesWithTheirRepairTasks = null;
    @JsonProperty("definedDamageTypes")
    private List<DefinedDamageType> definedDamageTypes = null;
    @JsonProperty("damageStatusId")
    private Object damageStatusId;
    @JsonProperty("vehicleSummary")
    private VehicleSummary vehicleSummary;
    @JsonProperty("lastECheckId")
    private Integer lastECheckId;
    @JsonProperty("disableDamageStatus")
    private Boolean disableDamageStatus;
    @JsonProperty("isTestingMode")
    private Boolean isTestingMode;

}