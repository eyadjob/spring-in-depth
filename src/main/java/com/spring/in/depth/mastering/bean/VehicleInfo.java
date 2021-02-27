package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.service.RequestApiService;
import com.spring.in.depth.mastering.service.SpringContextHelper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Setter
public class VehicleInfo {


    private String plateNumber;
    private String chassisNumber;
    private FuelTypes fuelTypes;
    private List<InsuranceCompanyInfo> insuranceCompanyInfoList;


    public VehicleInfo() {
        insuranceCompanyInfoList = new ArrayList<>();
        settRandomValidPlateNumber();
        settRandomValidChassisNumber();
    }

    public void fillVehicleRequiredDate(ApisData apisData) {
       this.fuelTypes = getFuelTypes(apisData);
    }


    public FuelTypes getFuelTypes(ApisData apisData) {
       return (FuelTypes) SpringContextHelper.getBean(RequestApiService.class).requestGetAPI(FuelTypes.class, "api.GetFuelTypes", "countryId=" + apisData.getCountryInfo().getCountryId(), "includeActive=" + false, "isSelectedId=" + -1).getBody();
    }

    public void settRandomValidPlateNumber() {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        this.plateNumber = alpha.charAt(r.nextInt(26)) + " " + alpha.charAt(r.nextInt(26)) + " " + alpha.charAt(r.nextInt(26)) + " " + r.nextInt(3) + r.nextInt(2) + r.nextInt(7) + r.nextInt(6);
    }

    public void settRandomValidChassisNumber() {
        String cn = String.valueOf(new Date().getTime());
        this.chassisNumber = "perChas" + cn.substring(2, cn.length() - 1);
    }


    public void setInsuranceCompanyInfoList(ApisData apisData, ObjectNode insuranceResponse) {
        for (JsonNode js : insuranceResponse.get("result").get("items")) {
            insuranceCompanyInfoList.add(new InsuranceCompanyInfo(js.get("value").asText(), js.get("displayText").asText()));
        }
    }

}