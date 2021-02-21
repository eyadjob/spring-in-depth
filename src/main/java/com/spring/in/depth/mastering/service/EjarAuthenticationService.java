package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCountryRepository;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EjarAuthenticationService {

    @Autowired
    RequestApiService requestApiService;

    @Autowired
    EjarCountryRepository ejarCountryRepository;

    @Autowired
    ApisData apisDataEntity;

    @Autowired
    JsonUtility jsonUtility;

    public ResponseEntity<String> authenticateUser(String userName, String password) {
        HttpEntity<String> httpEntity = apisDataEntity.getHttpEntity(jsonUtility.setNodesValuesAndGetJsonString(PropManager.getInstance().getProperty("api.authenticate.post.payload"), "userNameOrEmailAddress:" + userName, "password:" + password));
        ResponseEntity<String> response = requestApiService.requestPostAPI("api.authentication", httpEntity );
        ObjectNode authResponse = jsonUtility.getObjectNodFromString(response.getBody());
        apisDataEntity.getDefaultHeaders().addIfAbsent("Authorization", "Bearer" + authResponse.get("result").get("accessToken").textValue());
        return response;
    }
}
