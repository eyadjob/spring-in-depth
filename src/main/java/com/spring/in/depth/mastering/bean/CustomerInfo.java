package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CustomerInfo {
    @Autowired
    JsonUtility jsonUtility;

    private String customerNumber;

    public CustomerInfo() {
        String currentTime = String.valueOf(new Date().getTime());
        this.customerNumber = currentTime.substring(2, currentTime.length() - 1);
    }

    public void setCustomerNumber(String number) {
        customerNumber = number;
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

    public ObjectNode getCreateCustomerReadyPayload(String createCustomerPayload) {
        ObjectNode customerPayload = jsonUtility.getObjectNodFromString(PropManager.getInstance().getProperty("api.create.customer.post.payload"));
        customerPayload.put("first", getFirstName());
        customerPayload.put("second", getSecondName());
        customerPayload.put("family", getLastName());

        customerPayload.put("primaryPhone", getPhoneNumber());
        customerPayload.put("email", getEmail());
//        customerPayload.put("nationalityId", getNationality);
        customerPayload.put("countryId", getFirstName());
        customerPayload.put("cityId", getFirstName());
        customerPayload.put("issueCountryId", getFirstName());
        customerPayload.put("typeId", getFirstName());
        customerPayload.put("number", getFirstName());
        customerPayload.put("typeName", getFirstName());
        customerPayload.put("issueCountry", getFirstName());
        customerPayload.put("sourceId", getFirstName());
        return customerPayload;
    }

}
