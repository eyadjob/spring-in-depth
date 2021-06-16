package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    @JsonProperty("countryId")
    public Integer getCountryId() {
        return countryId;
    }

    @JsonProperty("countryId")
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("fuelId")
    public Integer getFuelId() {
        return fuelId;
    }

    @JsonProperty("fuelId")
    public void setFuelId(Integer fuelId) {
        this.fuelId = fuelId;
    }

    @JsonProperty("odometer")
    public Object getOdometer() {
        return odometer;
    }

    @JsonProperty("odometer")
    public void setOdometer(Object odometer) {
        this.odometer = odometer;
    }

    @JsonProperty("minimumOdomter")
    public Integer getMinimumOdomter() {
        return minimumOdomter;
    }

    @JsonProperty("minimumOdomter")
    public void setMinimumOdomter(Integer minimumOdomter) {
        this.minimumOdomter = minimumOdomter;
    }

    @JsonProperty("maximumOdomter")
    public Integer getMaximumOdomter() {
        return maximumOdomter;
    }

    @JsonProperty("maximumOdomter")
    public void setMaximumOdomter(Integer maximumOdomter) {
        this.maximumOdomter = maximumOdomter;
    }

    @JsonProperty("checkType")
    public CheckType getCheckType() {
        return checkType;
    }

    @JsonProperty("checkType")
    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }

    @JsonProperty("checklistDetails")
    public List<ChecklistDetail> getChecklistDetails() {
        return checklistDetails;
    }

    @JsonProperty("checklistDetails")
    public void setChecklistDetails(List<ChecklistDetail> checklistDetails) {
        this.checklistDetails = checklistDetails;
    }

    @JsonProperty("latestVehicleCheckListStatus")
    public List<Object> getLatestVehicleCheckListStatus() {
        return latestVehicleCheckListStatus;
    }

    @JsonProperty("latestVehicleCheckListStatus")
    public void setLatestVehicleCheckListStatus(List<Object> latestVehicleCheckListStatus) {
        this.latestVehicleCheckListStatus = latestVehicleCheckListStatus;
    }

    @JsonProperty("vehicleSkeletonDetails")
    public VehicleSkeletonDetails getVehicleSkeletonDetails() {
        return vehicleSkeletonDetails;
    }

    @JsonProperty("vehicleSkeletonDetails")
    public void setVehicleSkeletonDetails(VehicleSkeletonDetails vehicleSkeletonDetails) {
        this.vehicleSkeletonDetails = vehicleSkeletonDetails;
    }

    @JsonProperty("latestVehicleDamages")
    public LatestVehicleDamages getLatestVehicleDamages() {
        return latestVehicleDamages;
    }

    @JsonProperty("latestVehicleDamages")
    public void setLatestVehicleDamages(LatestVehicleDamages latestVehicleDamages) {
        this.latestVehicleDamages = latestVehicleDamages;
    }

    @JsonProperty("skeletonBodiesWithTheirRepairTasks")
    public List<SkeletonBodiesWithTheirRepairTask> getSkeletonBodiesWithTheirRepairTasks() {
        return skeletonBodiesWithTheirRepairTasks;
    }

    @JsonProperty("skeletonBodiesWithTheirRepairTasks")
    public void setSkeletonBodiesWithTheirRepairTasks(List<SkeletonBodiesWithTheirRepairTask> skeletonBodiesWithTheirRepairTasks) {
        this.skeletonBodiesWithTheirRepairTasks = skeletonBodiesWithTheirRepairTasks;
    }

    @JsonProperty("definedDamageTypes")
    public List<DefinedDamageType> getDefinedDamageTypes() {
        return definedDamageTypes;
    }

    @JsonProperty("definedDamageTypes")
    public void setDefinedDamageTypes(List<DefinedDamageType> definedDamageTypes) {
        this.definedDamageTypes = definedDamageTypes;
    }

    @JsonProperty("damageStatusId")
    public Object getDamageStatusId() {
        return damageStatusId;
    }

    @JsonProperty("damageStatusId")
    public void setDamageStatusId(Object damageStatusId) {
        this.damageStatusId = damageStatusId;
    }

    @JsonProperty("vehicleSummary")
    public VehicleSummary getVehicleSummary() {
        return vehicleSummary;
    }

    @JsonProperty("vehicleSummary")
    public void setVehicleSummary(VehicleSummary vehicleSummary) {
        this.vehicleSummary = vehicleSummary;
    }

    @JsonProperty("lastECheckId")
    public Integer getLastECheckId() {
        return lastECheckId;
    }

    @JsonProperty("lastECheckId")
    public void setLastECheckId(Integer lastECheckId) {
        this.lastECheckId = lastECheckId;
    }

    @JsonProperty("disableDamageStatus")
    public Boolean getDisableDamageStatus() {
        return disableDamageStatus;
    }

    @JsonProperty("disableDamageStatus")
    public void setDisableDamageStatus(Boolean disableDamageStatus) {
        this.disableDamageStatus = disableDamageStatus;
    }

    @JsonProperty("isTestingMode")
    public Boolean getIsTestingMode() {
        return isTestingMode;
    }

    @JsonProperty("isTestingMode")
    public void setIsTestingMode(Boolean isTestingMode) {
        this.isTestingMode = isTestingMode;
    }

}