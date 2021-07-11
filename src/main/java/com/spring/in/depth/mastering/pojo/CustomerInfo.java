package com.spring.in.depth.mastering.pojo;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;

import java.util.Date;

public class CustomerInfo {

    private String customerNumber;
    private String phoneNumber;
    private String firstName;
    private String secondName;
    private String LastName;
    private String email;

    public CustomerInfo() {
        String currentTime = String.valueOf(new Date().getTime());
        this.customerNumber =  currentTime.substring(2, currentTime.length() - 1);
        this.phoneNumber = "966-51" + currentTime.substring(5, currentTime.length() - 1);
        this.firstName =  "EyadApiTestFrameworkPayaPay" + customerNumber;
        this.secondName =  "perSN" + customerNumber;
        this.LastName = "perLN" + customerNumber;
        this.email = "perfTest" + customerNumber + "@iyelo.com";

    }
    public String getCustomerNumber() {
        String currentTime = String.valueOf(new Date().getTime());
        return currentTime.substring(2, currentTime.length() - 1);
    }

    public ObjectNode getCreateCustomerReadyPayload(ApisData apisData) {

        ObjectNode customerPayload = JsonUtility.getObjectNodFromString(PropManager.getInstance().getProperty("api.create.customer.post.payload"));
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("first", firstName);
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("second", secondName);
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("family", LastName);
        ((ObjectNode) customerPayload.get("customer").get("contactInformation")).put("primaryPhone", phoneNumber);
        ((ObjectNode) customerPayload.get("customer").get("contactInformation")).put("email", email);
        ((ObjectNode) customerPayload.get("customer").get("basicInformation")).put("nationalityId", apisData.getCountryInfo().getCountryId());
        ((ObjectNode) customerPayload.get("customer").get("address")).put("countryId", apisData.getCountryInfo().getCountryId());
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:issueCountryId:1","1:issueCountryId:1");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:typeId:250","1:typeId:250");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:number:"+customerNumber,"1:number:"+customerNumber);
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:typeName:Identity","1:typeName:Identity");
        String countryName =apisData.getCountryInfo().getCountryName();
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:issueCountry:"+countryName,"1:issueCountry:"+countryName);
        customerPayload.put("sourceId", 120);
        return customerPayload;
    }


}
