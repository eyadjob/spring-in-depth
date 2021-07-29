package com.spring.in.depth.mastering.test;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import com.relevantcodes.extentreports.ExtentReports;
import com.spring.in.depth.mastering.pojo.ExtentReportsFactory;
import com.spring.in.depth.mastering.report.*;
import com.spring.in.depth.mastering.report.ready.ReportManager;
import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.AllPostApiService;
import com.spring.in.depth.mastering.service.ApisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.testng.Assert;
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
        ResponseEntity<String> response = postApiService.createNewCustomer(apisData);
        ResponseEntity<String> vehicleResponse =  postApiService.createNewVehicle(apisData);
        ResponseEntity<String> vehiclePreprationResponse =  getApiServices.getVehiclePreprationData(apisData);
        System.out.println(vehicleResponse);
        System.out.println(apisData.getCustomerInfo().getCreateCustomerReadyPayload(apisData));
        String customerPayload = apisData.getCustomerInfo().getCreateCustomerReadyPayload(apisData).toString();

//        ReportManager reportManager = new ReportManager("\\Ejar APIs Regression Report.html");
//        reportManager.fillStep("Create New Customer",countryName,customerPayload,response.getBody());
//        reportManager.getReport().flush();

    }
}
