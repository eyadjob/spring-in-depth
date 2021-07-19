package com.spring.in.depth.mastering.test;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import com.spring.in.depth.mastering.bean.vehicle.VehicleCreate;
import com.spring.in.depth.mastering.report.ready.ReportManager;
import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.AllPostApiService;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.utility.JsonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
//        getApiServices.fillVehicleData(apisData);
//        getApiServices.getBranches(apisData,branchName, false);
//        postApiService.createNewCustomer(apisData);
//        postApiService.createNewVehicle(apisData);
//        System.out.println(apisData.getCustomerInfo().getCreateCustomerReadyPayload(apisData));
//        System.out.println(apisData.getVehicleInfo().getCreateVehiclePayloadWithPogo(apisData));
//        getApiServices.getAllBranchVehicles(apisData);
//        getApiServices.getVehicleCheckPreparationData(apisData);
        postApiService.uploadFile(apisData,"signature");
        postApiService.uploadFile(apisData,"first car image");
        postApiService.uploadFile(apisData,"secondCarImage");
//        System.out.println(apisData.getVehicleInfo().getCreateVehiclePayloadWithPogo(apisData));
//        postApiService.ReceiveNewVehicle(apisData);
//        System.out.println(apisData.getVehicleCheckPreparationDataResponse());
//        String customerPayload = apisData.getCustomerInfo().getCreateCustomerReadyPayload(apisData).toString();
//        ReportManager reportManager = new ReportManager("\\Ejar APIs Regression Report.html");
//        reportManager.fillStep("Create New Customer",countryName,customerPayload,response.getBody());
//        reportManager.getReport().flush();
    }
}
