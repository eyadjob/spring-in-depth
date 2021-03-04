package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.bean.Branches;
import com.spring.in.depth.mastering.bean.FuelTypes;
import com.spring.in.depth.mastering.bean.InsuranceCompanies;
import com.spring.in.depth.mastering.bean.countryinfo.CurrnecyInfo;
import com.spring.in.depth.mastering.entity.ejar.stg.EjarCountryEntity;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCountryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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
        getCountryCurrencyInfo(apisData);
        getInsuranceCompany(apisData, false);
        return apisData;
    }

    public ApisData fillVehicleData(ApisData apisData) {
        FuelTypes fuelTypes = (FuelTypes) requestApiService.requestExchangeAPI(FuelTypes.class, apisData.buildHttpEntity(), "api.GetFuelTypes", "countryId=" + apisData.getCountryInfo().getCountryId(), "includeActive=" + false, "isSelectedId=" + -1).getBody();
        apisData.getVehicleInfo().setFuelTypes(fuelTypes);
        return apisData;
    }

    public ApisData getCountryInfoByName(ApisData apisData, String countryName) {
        List<EjarCountryEntity> ejarCountryEntityList = ejarCountryRepository.getCountryLikeName(countryName);
        apisData.getCountryInfo().setCountryName(ejarCountryEntityList.get(0).getCountryNameBasedOnLang());
        apisData.getCountryInfo().setCountryId(ejarCountryEntityList.get(0).getId());
        return apisData;
    }

    public ApisData getCountryCurrencyInfo(ApisData apisData) {
        CurrnecyInfo currnecyInfo = (CurrnecyInfo) requestApiService.requestExchangeAPI(CurrnecyInfo.class, apisData.buildHttpEntity(), "api.GetCountryCurrencyInfo", "countryId=" + apisData.getCountryInfo().getCountryId()).getBody();
        apisData.getCountryInfo().setCurrnecyInfo(currnecyInfo);
        return apisData;
    }

    public ApisData getInsuranceCompany(ApisData apisData, boolean includeActive) {
        InsuranceCompanies insuranceCompanies = (InsuranceCompanies) requestApiService.requestExchangeAPI(InsuranceCompanies.class, apisData.buildHttpEntity(), "api.GetInsuranceCompany", "countryId=" + apisData.getCountryInfo().getCountryId(), "includeActive=" + includeActive).getBody();
        apisData.getVehicleInfo().setInsuranceCompanies(insuranceCompanies);
        return apisData;
    }


    public ApisData getBranches(ApisData apisData, String... params) {
        apisData.getCountryInfo().setBranchesList((Branches) requestApiService.requestExchangeAPI(Branches.class, apisData.buildHttpEntity(apisData.getDefaultHeaders()), "api.GetBranches", "countryId=" + params[0], "includeInActive=" + params[1], "includeAll=" + params[2], "filterTypes=" + params[3], "filterTypes=" + params[4]).getBody());
        return apisData;
    }

}
