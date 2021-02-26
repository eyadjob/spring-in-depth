package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.utility.JsonUtility;

import java.util.Map;

public class InsuranceCompanyInfo {

    private String insuranceCompanyName;
    private String insuranceCompanyId;

    public InsuranceCompanyInfo(String insuranceCompanyId, String insuranceCompanyName) {
        this.insuranceCompanyId = insuranceCompanyId;
        this.insuranceCompanyName = insuranceCompanyName;
    }

}
