package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.bean.post.UploadFile;
import com.spring.in.depth.mastering.bean.receivevehicle.ReceiveVehicle;
import com.spring.in.depth.mastering.bean.response.UploadFileResponse;
import com.spring.in.depth.mastering.bean.vehicle.VehicleCreate;
import com.spring.in.depth.mastering.pojo.CustomerInfo;
import com.spring.in.depth.mastering.pojo.ReceiveNewVehicleInfo;
import com.spring.in.depth.mastering.pojo.VehicleInfo;
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
        HttpEntity<String> httpEntity = apisData.buildHttpEntity(JsonUtility.setNodesValuesAndGetJsonString(PropManager.getInstance().getProperty("api.authenticate.post.payload"), "userNameOrEmailAddress:" + userName, "password:" + password));
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
        return requestApiService.requestPostAPI("api.create.customer", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(createCustomerPayload), apisData.getDefaultHeaders()));
    }

    public ResponseEntity<String> createNewVehicle(ApisData apisData) {
        VehicleCreate createVehiclePayload = new VehicleInfo().getCreateVehiclePayloadWithPogo(apisData);
        apisData.setVehicleCreate(createVehiclePayload);
        return requestApiService.requestPostAPI("api.create.vehicle", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(createVehiclePayload), apisData.getDefaultHeaders()));
    }

    public ResponseEntity<String> ReceiveNewVehicle(ApisData apisData) {
        ReceiveVehicle receiveNewVehicleInfo = new ReceiveNewVehicleInfo().getReceiveNewVehicleInfo(apisData);
        apisData.setReceiveVehicle(receiveNewVehicleInfo);
        return requestApiService.requestPostAPI("api.receive.new.vehicle", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(receiveNewVehicleInfo), apisData.getDefaultHeaders()));
    }
    public ResponseEntity<Object> uploadFile(ApisData apisData,String fileName) {
        UploadFile uploadFile = new UploadFile();
        apisData.setUploadFile(uploadFile);
        ResponseEntity<Object> response = requestApiService.requestPostAPI("api.UploadBase64File", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(uploadFile), apisData.getDefaultHeaders()), UploadFile.class);
        UploadFileResponse uploadFileResponse = (UploadFileResponse) response.getBody();
        uploadFileResponse.setNameOfFile(fileName);
        apisData.getUploadFileResponse().add(uploadFileResponse);
        return response;
    }

}
