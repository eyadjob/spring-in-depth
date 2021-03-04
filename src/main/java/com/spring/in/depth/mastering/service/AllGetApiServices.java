package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.bean.Branches;
import com.spring.in.depth.mastering.bean.FuelTypes;
import com.spring.in.depth.mastering.entity.ejar.stg.EjarCountryEntity;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCountryRepository;
import com.spring.in.depth.mastering.utility.JsonUtility;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AllGetApiServices {

    @Autowired
    EjarCountryRepository ejarCountryRepository;

    @Autowired
    RequestApiService requestApiService;


    public ApisData fillInitialData(ApisData apisData, String countryName) {
        getCountryInfoByName(apisData, countryName);
        getCountryCurrencyInfo(apisData, apisData.getCountryInfo().getCurrencyId());
        getInsuranceCompany(apisData, apisData.getCountryInfo().getCurrencyId(), false);
        return apisData;
    }

    public ApisData fillVehicleData(ApisData apisData) {
       FuelTypes fuelTypes = (FuelTypes) requestApiService.requestExchangeAPI(FuelTypes.class, apisData.buildHttpEntity(),"api.GetFuelTypes", "countryId=" + apisData.getCountryInfo().getCountryId(), "includeActive=" + false, "isSelectedId=" + -1).getBody();
       apisData.getVehicleInfo().setFuelTypes(fuelTypes);
        return apisData;
    }

    public ApisData getCountryInfoByName(ApisData apisData, String countryName) {
        List<EjarCountryEntity> ejarCountryEntityList = ejarCountryRepository.getCountryLikeName(countryName);
        apisData.getCountryInfo().setCountryId(ejarCountryEntityList.get(0).getId());
        apisData.getCountryInfo().setCurrencyId(ejarCountryEntityList.get(0).getCurrencyId());
        apisData.getCountryInfo().setCountryName(ejarCountryEntityList.get(0).getCountryNameBasedOnLang());
        return apisData;
    }

    public ApisData getCountryCurrencyInfo(ApisData apisData, long countryId) {
        ResponseEntity<String> response = requestApiService.requestGetAPI("api.GetCountryCurrencyInfo", "countryId=" + countryId);
        fillCountryCurrencyInfo(apisData, JsonUtility.getObjectNodFromString(response.getBody()));
        return apisData;
    }

    public ApisData getInsuranceCompany(ApisData apisData, long countryId, boolean includeActive) {
        ResponseEntity<String> response = requestApiService.requestGetAPI("api.GetInsuranceCompany", "countryId=" + countryId, "includeActive=" + includeActive);
        apisData.getVehicleInfo().setInsuranceCompanyInfoList(apisData, JsonUtility.getObjectNodFromString(response.getBody()));
        return apisData;
    }


    public ApisData getFuelType(ApisData apisData, long countryId, boolean includeActive) {
        ResponseEntity<String> response = requestApiService.requestGetAPI("api.GetInsuranceCompany", "countryId=" + countryId, "includeActive=" + includeActive);
        apisData.getVehicleInfo().setInsuranceCompanyInfoList(apisData, JsonUtility.getObjectNodFromString(response.getBody()));
        return apisData;
    }

    public ApisData getBranches(ApisData apisData, String... params) {
        apisData.getCountryInfo().setBranchesList( (Branches)requestApiService.requestExchangeAPI(Branches.class,apisData.buildHttpEntity(apisData.getDefaultHeaders()), "api.GetBranches", "countryId=" + params[0], "includeInActive=" + params[1],"includeAll="+params[2],"filterTypes="+params[3],"filterTypes="+params[4]).getBody());
        return apisData;
    }

    private void fillCountryCurrencyInfo(ApisData apisData, ObjectNode currencyInfoResponse) {
        apisData.getCountryInfo().setCurrencyName(currencyInfoResponse.get("result").get("name").textValue());
        apisData.getCountryInfo().setCurrencyIsoCode(currencyInfoResponse.get("result").get("isoCode").textValue());

//        apisData.getValuesCache().put("currencyId", currencyInfoResponse.get("result").get("id").textValue());
//        apisData.getValuesCache().put("currencyName", currencyInfoResponse.get("result").get("name").textValue());
//        apisData.getValuesCache().put("currencyIsoCode", currencyInfoResponse.get("result").get("isoCode").textValue());
//        0apisData.getValuesCache().put("currencyDecimalPlaces", currencyInfoResponse.get("result").get("decimalPlaces").textValue());
    }


}
