package com.spring.in.depth.mastering.bean.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleLicenseInfo {

    @JsonProperty("licenseTypeId")
    private String licenseTypeId;
    @JsonProperty("usageTypeId")
    private String usageTypeId;
    @JsonProperty("plateNo")
    private String plateNo;

    @JsonProperty("licenseTypeId")
    public String getLicenseTypeId() {
        return licenseTypeId;
    }

    @JsonProperty("licenseTypeId")
    public void setLicenseTypeId(String licenseTypeId) {
        this.licenseTypeId = licenseTypeId;
    }

    @JsonProperty("usageTypeId")
    public String getUsageTypeId() {
        return usageTypeId;
    }

    @JsonProperty("usageTypeId")
    public void setUsageTypeId(String usageTypeId) {
        this.usageTypeId = usageTypeId;
    }

    @JsonProperty("plateNo")
    public String getPlateNo() {
        return plateNo;
    }

    @JsonProperty("plateNo")
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

}