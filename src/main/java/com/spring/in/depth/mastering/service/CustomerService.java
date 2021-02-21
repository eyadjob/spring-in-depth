package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

    private String customerNumber;

    public CustomerService() {
        String currentTime = String.valueOf(new Date().getTime());
        this.customerNumber = currentTime.substring(2, currentTime.length() - 1);
    }


    public String getFirstName() {
        return "perfFN" + customerNumber;
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
        return "perfTest" + customerNumber + "*-@iyelo.com";
    }

    public ObjectNode getCreateCustomerReadyPayload(ApisData apisData) {
        ObjectNode customerPayload = jsonUtility.getObjectNodFromString(PropManager.getInstance().getProperty("api.create.customer.post.payload"));
        customerPayload.put("first", getFirstName());
        customerPayload.put("second", getSecondName());
        customerPayload.put("family", getLastName());
        customerPayload.put("primaryPhone", getPhoneNumber());
        customerPayload.put("email", getEmail());
        customerPayload.put("nationalityId", apisData.getValuesCache().get("countryId"));
        customerPayload.put("countryId", apisData.getValuesCache().get("countryId"));
        customerPayload.put("cityId", getFirstName());
        customerPayload.put("issueCountryId", apisData.getValuesCache().get("countryId"));
        customerPayload.put("typeId", 250);
        customerPayload.put("number", customerNumber);
        customerPayload.put("typeName", "Identity");
        customerPayload.put("issueCountry", customerPayload.put("issueCountry", getFirstName()));
        customerPayload.put("sourceId", getFirstName());
        return customerPayload;
    }


    public ResponseEntity<String> createNewCustomer() {
        authenticationService.authenticateUser("ejarAdmin", "123456");
        allGetApiServices.getCountryInfoByName("Saudi");
        ObjectNode createCustomerPayload = getCreateCustomerReadyPayload(apisData);
        return requestApiService.requestPostAPI("api.create.customer", apisData.getHttpEntity(jsonUtility.getJsonStringFromObjectNode(createCustomerPayload), apisData.getDefaultHeaders()));
    }
}
