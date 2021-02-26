package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.bean.CustomerInfo;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AllPostApiService {

    @Autowired
    RequestApiService requestApiService;

    @Autowired
    AllGetApiServices allGetApiServices;

    public ResponseEntity<String> authenticateUser(ApisData apisData, String userRole,String userName, String password) {
        HttpEntity<String> httpEntity = apisData.buildHttpEntityWithPayload(JsonUtility.setNodesValuesAndGetJsonString(PropManager.getInstance().getProperty("api.authenticate.post.payload"), "userNameOrEmailAddress:" + userName, "password:" + password));
        ResponseEntity<String> response = requestApiService.requestPostAPI("api.authentication", httpEntity);
        ObjectNode authResponse = JsonUtility.getObjectNodFromString(response.getBody());
        String userAccessToken = "Bearer " + authResponse.get("result").get("accessToken").textValue();
        apisData.getDefaultHeaders().addIfAbsent("Authorization", userAccessToken);
        apisData.getAuthenticationInfo().getUserAccessTokens().put(userRole,userAccessToken);
        return response;
    }

    public ResponseEntity<String> createNewCustomer(ApisData apisData) {
        allGetApiServices.getCountryInfoByName(apisData,"Saudi");
        ObjectNode createCustomerPayload = new CustomerInfo().getCreateCustomerReadyPayload(apisData);
        return requestApiService.requestPostAPI("api.create.customer", apisData.buildHttpEntityWithPayload(JsonUtility.getJsonStringFromObjectNode(createCustomerPayload), apisData.getDefaultHeaders()));
    }

}
