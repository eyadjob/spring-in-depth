package com.spring.in.depth.mastering.test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import com.spring.in.depth.mastering.pojo.ExtentReportsFactory;
import com.spring.in.depth.mastering.report.ExtentTestCustom;
import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.AllPostApiService;
import com.spring.in.depth.mastering.service.ApisData;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void test(String countryName) {
        ApisData apisData = new ApisData();
        postApiService.authenticateUser(apisData, "admin", "ejarAdmin", "123456");
        getApiServices.fillInitialData(apisData, countryName);
        getApiServices.fillVehicleData(apisData);
        getApiServices.getBranches(apisData, String.valueOf(apisData.getCountryInfo().getCountryId()), String.valueOf(false), String.valueOf(false), String.valueOf(8900), String.valueOf(8902));
        postApiService.createNewCustomer(apisData);
        System.out.println(apisData.getCustomerInfo().getCreateCustomerReadyPayload(apisData));

         ExtentReportsFactory.createExtentHtmlReporter("Eyad first report");
        ExtentReports extentReports = new ExtentReports();
        ExtentTestCustom testResult = new ExtentTestCustom(extentReports, "eyad new", "eyad first report");
        System.out.println("test");

    }
}
