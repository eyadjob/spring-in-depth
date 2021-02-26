package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;

import java.util.Date;

public class CustomerInfo {

    private String customerNumber;

    public CustomerInfo() {
        String currentTime = String.valueOf(new Date().getTime());
        this.customerNumber =  currentTime.substring(2, currentTime.length() - 1);
    }
    public String getCustomerNumber() {
        String currentTime = String.valueOf(new Date().getTime());
        return currentTime.substring(2, currentTime.length() - 1);
    }
    public String getFirstName() {
        return "FromEyadApiTestFrameworkPerfFN" + customerNumber;
    }

    public String getSecondName() {
        return "perSFN" + customerNumber;
    }

    public String getLastName() {
        return "perLFN" + customerNumber;
    }

    public String getPhoneNumber() {
        String currentTime = String.valueOf(new Date().getTime());
        return "966-51" + currentTime.substring(5, currentTime.length() - 1);
    }

    public String getEmail() {
        return "perfTest" + customerNumber + "@iyelo.com";
    }

    public ObjectNode getCreateCustomerReadyPayload(ApisData apisData) {

        ObjectNode customerPayload = JsonUtility.getObjectNodFromString(PropManager.getInstance().getProperty("api.create.customer.post.payload"));
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("first", getFirstName());
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("second", getSecondName());
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("family", getLastName());
        ((ObjectNode) customerPayload.get("customer").get("contactInformation")).put("primaryPhone", getPhoneNumber());
        ((ObjectNode) customerPayload.get("customer").get("contactInformation")).put("email", getEmail());
        ((ObjectNode) customerPayload.get("customer").get("basicInformation")).put("nationalityId", apisData.getValuesCache().get("countryId"));
        ((ObjectNode) customerPayload.get("customer").get("address")).put("countryId", apisData.getValuesCache().get("countryId"));
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:issueCountryId:1","1:issueCountryId:1");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:typeId:250","1:typeId:250");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:number:"+customerNumber,"1:number:"+customerNumber);
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:typeName:Identity","1:typeName:Identity");
        String countryName =apisData.getValuesCache().get("countryName");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:issueCountry:"+countryName,"1:issueCountry:"+countryName);
        customerPayload.put("sourceId", 120);
        return customerPayload;
    }


}
