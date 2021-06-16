package com.spring.in.depth.mastering.bean.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleInsuranceInfo {

    @JsonProperty("insuranceCompanyId")
    private Object insuranceCompanyId;

    @JsonProperty("insuranceCompanyId")
    public Object getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    @JsonProperty("insuranceCompanyId")
    public void setInsuranceCompanyId(Object insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }



}