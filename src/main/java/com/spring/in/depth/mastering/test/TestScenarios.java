package com.spring.in.depth.mastering.test;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.AllPostApiService;
import com.spring.in.depth.mastering.service.ApisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Service
@Listeners(ExtentITestListenerClassAdapter.class)
public class TestScenarios {


    @Autowired
    AllPostApiService postApiService;

    @Autowired
    AllGetApiServices getApiServices;

    @Test(groups = {"tagName", "t:another-tagName", "a:authorName", "d:deviceName"})
    public void CreateNewCustomer(String countryName,String branchName) {
        ApisData apisData = new ApisData();
        postApiService.authenticateUser(apisData, "admin", "ejarAdmin", "123456");
        getApiServices.fillInitialData(apisData, countryName, branchName);
        getApiServices.fillVehicleData(apisData);
        getApiServices.getBranches(apisData, String.valueOf(apisData.getCountryInfo().getCountryId()),branchName, String.valueOf(false), String.valueOf(false), String.valueOf(8900), String.valueOf(8902));
        postApiService.createNewCustomer(apisData);
        postApiService.createNewVehicle(apisData);
        getApiServices.getBranchVehicleForPlateNumber(apisData);
        getApiServices.getBranchLocations(apisData);

        System.out.println(apisData.getCustomerInfo().getCreateCustomerReadyPayload(apisData));
        System.out.println(apisData.getVehicleInfo().getCreateVehiclePayloadWithPogo(apisData));
        System.out.println(apisData.getVehicleInfo().getCreateVehiclePayloadWithPogo(apisData));

        getApiServices.getVehiclePreparationData(apisData);
        System.out.println(apisData.getVehicleCheckPreparationDataResponse().toString());
        postApiService.uploadFile(apisData,"signature");
        postApiService.ReceiveNewVehicle(apisData);
        System.out.println(apisData.getReceiveVehicle().toString());
//        postApiService.uploadFile(apisData,"first car image");
//        postApiService.uploadFile(apisData,"secondCarImage");
//        System.out.println(apisData.getVehicleInfo().getCreateVehiclePayloadWithPogo(apisData));

//        getApiServices.getCreateBookingDateInputs(apisData);
//        postApiService.createCalculateBillingInformationForBooking(apisData);
//        System.out.println(apisData.getCalculateBillingInformationResponse());
//        System.out.println(apisData.getVehicleCheckPreparationDataResponse());
//        String customerPayload = apisData.getCustomerInfo().getCreateCustomerReadyPayload(apisData).toString();
//        ReportManager reportManager = new ReportManager("\\Ejar APIs Regression Report.html");
//        reportManager.fillStep("Create New Customer",countryName,customerPayload,response.getBody());
//        reportManager.getReport().flush();
    }
}
