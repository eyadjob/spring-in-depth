package com.spring.in.depth.mastering.bean.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleDto {

    @JsonProperty("odometer")
    private String odometer;
    @JsonProperty("fuelId")
    private Integer fuelId;
    @JsonProperty("branchId")
    private String branchId;
    @JsonProperty("vehicleManufacturingInfo")
    private VehicleManufacturingInfo vehicleManufacturingInfo;
    @JsonProperty("vehicleLicenseInfo")
    private VehicleLicenseInfo vehicleLicenseInfo;
    @JsonProperty("vehicleInsuranceInfo")
    private VehicleInsuranceInfo vehicleInsuranceInfo;
    @JsonProperty("locationInfo")
    private LocationInfo locationInfo;
    @JsonProperty("purchaseInfo")
    private PurchaseInfo purchaseInfo;
    @JsonProperty("specs")
    private Specs specs;
    @JsonProperty("countryId")
    private String countryId;

    @JsonProperty("odometer")
    public String getOdometer() {
        return odometer;
    }

    @JsonProperty("odometer")
    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    @JsonProperty("fuelId")
    public Integer getFuelId() {
        return fuelId;
    }

    @JsonProperty("fuelId")
    public void setFuelId(Integer fuelId) {
        this.fuelId = fuelId;
    }

    @JsonProperty("branchId")
    public String getBranchId() {
        return branchId;
    }

    @JsonProperty("branchId")
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @JsonProperty("vehicleManufacturingInfo")
    public VehicleManufacturingInfo getVehicleManufacturingInfo() {
        return vehicleManufacturingInfo;
    }

    @JsonProperty("vehicleManufacturingInfo")
    public void setVehicleManufacturingInfo(VehicleManufacturingInfo vehicleManufacturingInfo) {
        this.vehicleManufacturingInfo = vehicleManufacturingInfo;
    }

    @JsonProperty("vehicleLicenseInfo")
    public VehicleLicenseInfo getVehicleLicenseInfo() {
        return vehicleLicenseInfo;
    }

    @JsonProperty("vehicleLicenseInfo")
    public void setVehicleLicenseInfo(VehicleLicenseInfo vehicleLicenseInfo) {
        this.vehicleLicenseInfo = vehicleLicenseInfo;
    }

    @JsonProperty("vehicleInsuranceInfo")
    public VehicleInsuranceInfo getVehicleInsuranceInfo() {
        return vehicleInsuranceInfo;
    }

    @JsonProperty("vehicleInsuranceInfo")
    public void setVehicleInsuranceInfo(VehicleInsuranceInfo vehicleInsuranceInfo) {
        this.vehicleInsuranceInfo = vehicleInsuranceInfo;
    }

    @JsonProperty("locationInfo")
    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    @JsonProperty("locationInfo")
    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    @JsonProperty("purchaseInfo")
    public PurchaseInfo getPurchaseInfo() {
        return purchaseInfo;
    }

    @JsonProperty("purchaseInfo")
    public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }

    @JsonProperty("specs")
    public Specs getSpecs() {
        return specs;
    }

    @JsonProperty("specs")
    public void setSpecs(Specs specs) {
        this.specs = specs;
    }

    @JsonProperty("countryId")
    public String getCountryId() {
        return countryId;
    }

    @JsonProperty("countryId")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }


}