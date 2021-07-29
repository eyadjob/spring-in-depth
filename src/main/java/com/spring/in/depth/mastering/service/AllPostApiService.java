package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.bean.post.BookingCalculateBillingInformation;
import com.spring.in.depth.mastering.bean.post.UploadFile;
import com.spring.in.depth.mastering.bean.receivevehicle.ReceiveVehicle;
import com.spring.in.depth.mastering.bean.response.CalculateBillingInformationResponse;
import com.spring.in.depth.mastering.bean.response.CreateCustomerResponse;
import com.spring.in.depth.mastering.bean.response.UploadFileResponse;
import com.spring.in.depth.mastering.bean.vehicle.CalculateBillingInfo;
import com.spring.in.depth.mastering.bean.vehicle.VehicleCreate;
import com.spring.in.depth.mastering.pojo.CustomerInfo;
import com.spring.in.depth.mastering.pojo.ReceiveNewVehicleInfo;
import com.spring.in.depth.mastering.pojo.VehicleInfo;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCommonRepository;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllPostApiService {

    @Autowired
    RequestApiService requestApiService;

    @Autowired
    AllGetApiServices allGetApiServices;

    @Autowired
    EjarCommonRepository ejarCommonRepository;

    public ResponseEntity<String> authenticateUser(ApisData apisData, String userRole, String userName, String password) {
        HttpEntity<String> httpEntity = apisData.buildHttpEntity(JsonUtility.setNodesValuesAndGetJsonString(PropManager.getInstance().getProperty("api.authenticate.post.payload"), "userNameOrEmailAddress:" + userName, "password:" + password));
        ResponseEntity<String> response = requestApiService.requestPostAPI("api.authentication", httpEntity);
        ObjectNode authResponse = JsonUtility.getObjectNodFromString(response.getBody());
        String userAccessToken = "Bearer " + authResponse.get("result").get("accessToken").textValue();
        apisData.getDefaultHeaders().addIfAbsent("Authorization", userAccessToken);
        apisData.getAuthenticationInfo().getUserAccessTokens().put(userRole, userAccessToken);
        return response;
    }

    public ApisData createNewCustomer(ApisData apisData) {
        allGetApiServices.getCountryInfoByName(apisData, "Saudi");
        ObjectNode createCustomerPayload = new CustomerInfo().getCreateCustomerReadyPayload(apisData);
        apisData.setCreateCustomerResponse((CreateCustomerResponse) requestApiService.requestPostAPI("api.create.customer", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(createCustomerPayload), apisData.getDefaultHeaders()), CreateCustomerResponse.class).getBody());
        return apisData;
    }

    public ResponseEntity<String> createNewVehicle(ApisData apisData) {
        VehicleCreate createVehiclePayload = new VehicleInfo().getCreateVehiclePayloadWithPogo(apisData);
        apisData.setVehicleCreate(createVehiclePayload);
        return requestApiService.requestPostAPI("api.create.vehicle", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(createVehiclePayload), apisData.getDefaultHeaders()));
    }

//    public ApisData createCalculateBillingInformationForBooking(ApisData apisData) {
//
//        List<String> re = ejarCommonRepository.getVehicleInfoFormDB(apisData.getVehicleCreate().getVehicleDtos().get(0).getVehicleLicenseInfo().getPlateNo(), "147");
//        BookingCalculateBillingInformation bookingCalculateBillingInformation = new CalculateBillingInfo().getCreateBookingCalculateBillingInformationF(apisData, re);
//        apisData.setBookingCalculateBillingInformation(bookingCalculateBillingInformation);
//        apisData.getDefaultHeaders().remove("Content-Length");
//        apisData.setCalculateBillingInformationResponse((CalculateBillingInformationResponse) requestApiService.requestPostByJava(CalculateBillingInformationResponse.class,bookingCalculateBillingInformation,apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(bookingCalculateBillingInformation),apisData.getDefaultHeaders()),"api.create.vehicle"));
////        apisData.setCalculateBillingInformationResponse((CalculateBillingInformationResponse) requestApiService.requestPostAPI1("api.create.vehicle", apisData.buildHttpEntity(bookingCalculateBillingInformation, apisData.getDefaultHeaders()), CalculateBillingInformationResponse.class).getBody());
////        apisData.setCalculateBillingInformationResponse((CalculateBillingInformationResponse) requestApiService.requestPostAPI("api.create.vehicle", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(bookingCalculateBillingInformation), apisData.getDefaultHeaders()), CalculateBillingInformationResponse.class).getBody());
//        return apisData;
//    }

    public ResponseEntity<String> ReceiveNewVehicle(ApisData apisData) {
        ReceiveVehicle receiveNewVehicleInfo = new ReceiveNewVehicleInfo().getReceiveNewVehicleInfo(apisData);
        apisData.setReceiveVehicle(receiveNewVehicleInfo);
        return requestApiService.requestPostAPI("api.receive.new.vehicle", apisData.buildHttpEntity(JsonUtility.getJsonStringFromObjectNode(receiveNewVehicleInfo), apisData.getDefaultHeaders()));
    }

    public ResponseEntity<Object> uploadFile(ApisData apisData, String fileName) {
        UploadFile uploadFile = new UploadFile();
        apisData.setUploadFile(uploadFile);
        ResponseEntity<Object> response = requestApiService.requestPostAPI("api.UploadBase64File", apisData.buildHttpEntity(uploadFile.getData(), apisData.getDefaultHeaders()), UploadFileResponse.class);
        UploadFileResponse uploadFileResponse = (UploadFileResponse) response.getBody();
        uploadFileResponse.setNameOfFile(fileName);
        apisData.getUploadFileResponse().add(uploadFileResponse);
        apisData.getDefaultHeaders().add("Accept", "application/jso");
        return response;
    }

}
