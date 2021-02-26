package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.service.ApisData;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class VehicleInfo {


    private List<InsuranceCompanyInfo> insuranceCompanyInfoList;

    public VehicleInfo() {
        insuranceCompanyInfoList = new ArrayList<>();
    }

    public void setInsuranceCompanyInfoList(ApisData apisData, ObjectNode insuranceResponse) {
        for(JsonNode js : insuranceResponse.get("result").get("items") ) {
            insuranceCompanyInfoList.add(new InsuranceCompanyInfo(js.get("value").asText(), js.get("displayText").asText()));
        }
    }
}