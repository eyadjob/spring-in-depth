package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.bean.CustomerInfo;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCommonRepository;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCountryRepository;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    RequestApiService requestApiService;

    @Autowired
    CustomerInfo customerInfo;

    @Autowired
    JsonUtility jsonUtility;

    @Autowired
    EjarCommonRepository ejarCommonRepository;

    @Autowired
    EjarCountryRepository ejarCountryRepository;

//    @Test
//    @DisplayName("Create new customer with unique name and identity")
    public void createNewCustomer() {
//        ejarCommonRepository.getCountryInfoBasedOnCountryName("Saudi");
        ejarCountryRepository.getCountryLikeName("Saudi");
        ejarCountryRepository.getCountryById(1);

        HttpHeaders httpHeaders = requestApiService.buildDefaultHeaders();
        HttpEntity<String> httpEntity = requestApiService.buildHttpEntity(PropManager.getInstance().getProperty("api.authenticate.post.payload"), httpHeaders);
        ObjectNode authorizationResponse = requestApiService.requestPostAPI("api.authentication", httpEntity);

        httpHeaders.addIfAbsent("Authorization", "Bearer" + authorizationResponse.get("result").get("accessToken").textValue());
        requestApiService.getJsonNodeValue(authorizationResponse,"result","accessToken");
        HttpEntity<String> countryInfoEntity = requestApiService.buildHttpEntity(httpHeaders);
        ObjectNode countryInfoResponse = requestApiService.requestGetAPI("api.GetCountryCurrencyInfo", countryInfoEntity,"countryId=1");
//        customerInfo.getCreateCustomerReadyPayload()
        HttpEntity<String> createCustomerHttpEntity = requestApiService.buildHttpEntity(PropManager.getInstance().getProperty("api.create.customer.post.payload"), httpHeaders);
        ObjectNode createCustomerResponse = requestApiService.requestPostAPI("api.create.customer", createCustomerHttpEntity);

    }
}
