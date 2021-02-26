package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.entity.ejar.stg.EjarCountryEntity;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCountryRepository;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
        getCountryInfoByName(apisData,countryName);
        getCountryCurrencyInfo(apisData,apisData.getValuesCache().get("countryId"));
        return apisData;
    }

    public ApisData getCountryInfoByName(ApisData apisData,String countryName) {
        List<EjarCountryEntity> ejarCountryEntityList = ejarCountryRepository.getCountryLikeName(countryName);
        apisData.getValuesCache().put("countryId",String.valueOf(ejarCountryEntityList.get(0).getId()));
        apisData.getValuesCache().put("currencyId",String.valueOf(ejarCountryEntityList.get(0).getCurrencyId()));
        apisData.getValuesCache().put("countryName",ejarCountryEntityList.get(0).getCountryNameBasedOnLang());
        return apisData;
    }

    public ApisData getCountryCurrencyInfo(ApisData apisData,String countryId) {
        ResponseEntity<String> response = requestApiService.requestGetAPI("api.GetCountryCurrencyInfo","countryId="+countryId);
        ObjectNode currencyInfoResponse = JsonUtility.getObjectNodFromString(response.getBody());
        fillCountryCurrencyInfo(apisData,currencyInfoResponse);
        return apisData;
    }

    private void fillCountryCurrencyInfo(ApisData apisData,ObjectNode currencyInfoResponse) {
        apisData.getValuesCache().put("currencyId",currencyInfoResponse.get("result").get("id").textValue());
        apisData.getValuesCache().put("currencyName",currencyInfoResponse.get("result").get("name").textValue());
        apisData.getValuesCache().put("currencyIsoCode",currencyInfoResponse.get("result").get("isoCode").textValue());
        apisData.getValuesCache().put("currencyDecimalPlaces",currencyInfoResponse.get("result").get("decimalPlaces").textValue());
    }

}
