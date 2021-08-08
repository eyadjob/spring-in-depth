package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.bean.AuthenticationInfo;
import com.spring.in.depth.mastering.bean.post.BookingCalculateBillingInformation;
import com.spring.in.depth.mastering.bean.post.UploadFile;
import com.spring.in.depth.mastering.bean.receivevehicle.ReceiveVehicle;
import com.spring.in.depth.mastering.bean.response.*;
import com.spring.in.depth.mastering.bean.vehicle.VehicleCreate;
import com.spring.in.depth.mastering.pojo.CountryInfo;
import com.spring.in.depth.mastering.pojo.CustomerInfo;
import com.spring.in.depth.mastering.pojo.VehicleInfo;
import com.spring.in.depth.mastering.utility.PropManager;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.*;

@Data
public class ApisData {

    private final Map<String, String> valuesCache;
    private final HttpHeaders defaultHeaders;
    private CountryInfo countryInfo;
    private VehicleInfo vehicleInfo;
    private CustomerInfo customerInfo;
    private CreateCustomerResponse createCustomerResponse;
    private AuthenticationInfo authenticationInfo;
    private BranchesComboBoxResponse branchesComboBoxResponse;
    private BranchLocations branchLocations;
    private String selectedBranchId;
    private String getSelectedBranchLocation;
    private String selectedBranchName;
    private VehicleCreate vehicleCreate;
    private VehicleCheckPreparationDataResponse vehicleCheckPreparationDataResponse;
    private GetAllBranchVehicles getAllBranchVehicles;
    private UploadFile uploadFile;
    private List<UploadFileResponse> uploadFileResponse = new ArrayList<>();
    private ReceiveVehicle receiveVehicle;
    private CreateBookingDateInputsResponse createBookingDateInputsResponse;
    private BookingCalculateBillingInformation bookingCalculateBillingInformation;
    private CalculateBillingInformationResponse calculateBillingInformationResponse;



    public ApisData() {
        this.valuesCache = new HashMap<>();
        this.defaultHeaders = buildDefaultHeaders();
        this.countryInfo = new CountryInfo();
        this.customerInfo = new CustomerInfo();
        this.authenticationInfo = new AuthenticationInfo();
        this.vehicleInfo = new VehicleInfo();
    }

    public HttpEntity<String> buildHttpEntity(String jsonPayload, HttpHeaders headers) {
        return new HttpEntity<>(jsonPayload, headers);
    }
    public HttpEntity<Object> buildHttpEntity(Object jsonPayload, HttpHeaders headers) {
        return new HttpEntity<Object>(jsonPayload, headers);
    }

    public HttpEntity<String> buildHttpEntity(String jsonPayload) {
        return new HttpEntity<>(jsonPayload, defaultHeaders);
    }


    public HttpEntity<String> buildHttpEntity(HttpHeaders headers) {
        return new HttpEntity<>(headers);
    }


    public HttpEntity<String> buildHttpEntity() {
        return new HttpEntity<>(defaultHeaders);
    }

    public HttpHeaders getDefaultHeaders() {
        return defaultHeaders;
    }

    public Map<String, String> getValuesCache() {
        return valuesCache;
    }

    public HttpHeaders buildDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        for (Map.Entry<String, Properties> p : PropManager.getInstance().getPropertiesValues().entrySet()) {
            if (p.getKey().contains("default.headers")) {
                p.getValue().entrySet().forEach(prop -> headers.set( prop.getKey().toString().trim(), ((String) prop.getValue()).trim()));
            }
        }
        return headers;
    }
}
