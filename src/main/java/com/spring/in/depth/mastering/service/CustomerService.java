package com.spring.in.depth.mastering.service;

import com.eclipsesource.json.JsonArray;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {

    @Autowired
    RequestApiService requestApiService;

    @Autowired
    JsonUtility jsonUtility;

    @Autowired
    EjarAuthenticationService authenticationService;

    @Autowired
    AllGetApiServices allGetApiServices;


    @Autowired
    ApisData apisData;

    public CustomerService() {

    }

    public String getCustomerNumber() {
        String currentTime = String.valueOf(new Date().getTime());
        return currentTime.substring(2, currentTime.length() - 1);
    }
    public String getFirstName() {
        return "FromEyadApiTestFrameworkPerfFN" + getCustomerNumber();
    }

    public String getSecondName() {
        return "perSFN" + getCustomerNumber();
    }

    public String getLastName() {
        return "perLFN" + getCustomerNumber();
    }

    public String getPhoneNumber() {
        String currentTime = String.valueOf(new Date().getTime());
        return "966-51" + currentTime.substring(5, currentTime.length() - 1);
    }

    public String getEmail() {
        return "perfTest" + getCustomerNumber() + "*-@iyelo.com";
    }

    public ObjectNode getCreateCustomerReadyPayload(ApisData apisData) {

        ObjectNode customerPayload = jsonUtility.getObjectNodFromString(PropManager.getInstance().getProperty("api.create.customer.post.payload"));
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("first", getFirstName());
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("second", getSecondName());
        ((ObjectNode) customerPayload.get("customer").get("fullName")).put("family", getLastName());
        ((ObjectNode) customerPayload.get("customer").get("contactInformation")).put("primaryPhone", getPhoneNumber());
        ((ObjectNode) customerPayload.get("customer").get("contactInformation")).put("email", getEmail());
//        ((ObjectNode) customerPayload.get("basicInformation")).put("genderId", apisData.getValuesCache().get("genderId"));
        ((ObjectNode) customerPayload.get("customer").get("basicInformation")).put("nationalityId", apisData.getValuesCache().get("countryId"));
        ((ObjectNode) customerPayload.get("customer").get("address")).put("countryId", apisData.getValuesCache().get("countryId"));
//        ((ObjectNode) customerPayload.get("address")).put("cityId", apisData.getValuesCache().get("cityId"));
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:issueCountryId:1","1:issueCountryId:1");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:typeId:250","1:typeId:250");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:number:"+getCustomerNumber(),"1:number:"+getCustomerNumber());
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:typeName:Identity","1:typeName:Identity");
        String countryName =apisData.getValuesCache().get("countryName");
        JsonUtility.fillJsonArraysNodes((ArrayNode) customerPayload.get("customer").get("documents"),"0:issueCountry:"+countryName,"1:issueCountry:"+countryName);
        customerPayload.put("sourceId", 120);
        return customerPayload;
    }


    public ResponseEntity<String> createNewCustomer() {
        authenticationService.authenticateUser("ejarAdmin", "123456");
        allGetApiServices.getCountryInfoByName("Saudi");
        ObjectNode createCustomerPayload = getCreateCustomerReadyPayload(apisData);
        return requestApiService.requestPostAPI("api.create.customer", apisData.getHttpEntity(jsonUtility.getJsonStringFromObjectNode(createCustomerPayload), apisData.getDefaultHeaders()));
    }
}
