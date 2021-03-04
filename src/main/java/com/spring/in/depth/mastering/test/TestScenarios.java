package com.spring.in.depth.mastering.test;

import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.AllPostApiService;
import com.spring.in.depth.mastering.service.ApisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestScenarios {


    @Autowired
    AllPostApiService postApiService;

    @Autowired
    AllGetApiServices getApiServices;

    public void test(String countryName) {
        ApisData apisData = new ApisData();
        postApiService.authenticateUser(apisData, "admin", "ejarAdmin", "123456");
        getApiServices.fillInitialData(apisData, countryName);
        getApiServices.fillVehicleData(apisData);
        getApiServices.getBranches(apisData,String.valueOf(apisData.getCountryInfo().getCountryId()),String.valueOf(false),String.valueOf(false),String.valueOf(8900),String.valueOf(8902));
        postApiService.createNewCustomer(apisData);
        System.out.println("test");

    }
}
