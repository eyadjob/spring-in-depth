package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.bean.FuelTypes;
import com.spring.in.depth.mastering.bean.InsuranceCompanies;
import com.spring.in.depth.mastering.bean.countryinfo.CurrnecyInfo;
import com.spring.in.depth.mastering.bean.response.BranchesComboBoxResponse;
import com.spring.in.depth.mastering.bean.response.CreateBookingDateInputsResponse;
import com.spring.in.depth.mastering.bean.response.GetAllBranchVehicles;
import com.spring.in.depth.mastering.bean.response.VehicleCheckPreparationDataResponse;
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

    public ApisData fillInitialData(ApisData apisData, String countryName,String branchName) {
        getCountryInfoByName(apisData, countryName);
        getCountryCurrencyInfo(apisData);
        getBranches(apisData,branchName,false);
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

    public ApisData getCountryBranch(ApisData apisData, boolean includeActive) {
        InsuranceCompanies insuranceCompanies = (InsuranceCompanies) requestApiService.requestExchangeAPI(InsuranceCompanies.class, apisData.buildHttpEntity(), "api.GetBranches", "countryId=" + apisData.getCountryInfo().getCountryId(), "includeActive=" + includeActive).getBody();
        apisData.getVehicleInfo().setInsuranceCompanies(insuranceCompanies);
        return apisData;
    }


    public ApisData getInsuranceCompany(ApisData apisData,  boolean includeActive) {
        InsuranceCompanies insuranceCompanies = (InsuranceCompanies) requestApiService.requestExchangeAPI(InsuranceCompanies.class, apisData.buildHttpEntity(), "api.GetInsuranceCompany", "countryId=" + apisData.getCountryInfo().getCountryId(), "includeActive=" + includeActive).getBody();
        apisData.getVehicleInfo().setInsuranceCompanies(insuranceCompanies);
        return apisData;
    }

    public ApisData getBranches(ApisData apisData,String branchName, boolean  includeInActive) {
        apisData.setBranchesComboBoxResponse((BranchesComboBoxResponse) requestApiService.requestExchangeAPI(BranchesComboBoxResponse.class, apisData.buildHttpEntity(apisData.getDefaultHeaders()), "api.GetBranches", "countryId=" + apisData.getCountryInfo().getCountryId(), "includeInActive=" + includeInActive, "includeAll=false" ).getBody());
        String  branchValue = apisData.getBranchesComboBoxResponse().getResult().getItems().stream().filter(b -> b.getDisplayText().contains(branchName)).findFirst().get().getValue();
        apisData.setSelectedBranchId(branchValue);
        apisData.setSelectedBranchName(branchName);
        return apisData;
    }
    public ApisData getCreateBookingDateInputs(ApisData apisData) {
        apisData.setCreateBookingDateInputsResponse((CreateBookingDateInputsResponse) requestApiService.requestExchangeAPI(CreateBookingDateInputsResponse.class, apisData.buildHttpEntity(apisData.getDefaultHeaders()), "api.GetCreateBookingDateInputs", "countryId=" + apisData.getCountryInfo().getCountryId()).getBody());
        return apisData;
    }


    public ApisData getVehicleCheckPreparationData(ApisData apisData) {
       apisData.getVehicleInfo().setId( apisData.getGetAllBranchVehicles().getResult().getData().stream().filter(d -> d.getPlateNo().contains(apisData.getVehicleCreate().getVehicleDtos().get(0).getVehicleLicenseInfo().getPlateNo())).findFirst().get().getId());
        apisData.getVehicleInfo().setFuelId( apisData.getGetAllBranchVehicles().getResult().getData().stream().filter(d -> d.getPlateNo().contains(apisData.getVehicleCreate().getVehicleDtos().get(0).getVehicleLicenseInfo().getPlateNo())).findFirst().get().getFuelId());
        apisData.setVehicleCheckPreparationDataResponse((VehicleCheckPreparationDataResponse) requestApiService.requestExchangeAPI(VehicleCheckPreparationDataResponse.class, apisData.buildHttpEntity(apisData.getDefaultHeaders()), "api.GetVehicleCheckPreparationData", "VehicleId=" + apisData.getVehicleInfo().getId(), "CheckTypeId=" + 6 ).getBody());
        return apisData;
    }
    public ApisData getAllBranchVehicles(ApisData apisData) {
        System.out.println("Request=page%3D1%26pageSize%3D15%26sort%3DlastModificationTime-desc%26filter%3D(countryId~eq~"+apisData.getCountryInfo().getCountryId()+"~and~currentLocationId~eq~"+apisData.getSelectedBranchId()+"~and~plateNo~contains~"+ apisData.getVehicleCreate().getPlateNumberForAngular()+")");
        apisData.setGetAllBranchVehicles((GetAllBranchVehicles) requestApiService.requestGetByJava(GetAllBranchVehicles.class, apisData.buildHttpEntity(apisData.getDefaultHeaders()), "api.GetAllBranchVehicles", "Request=page%3D1%26pageSize%3D15%26sort%3DlastModificationTime-desc%26filter%3D(countryId~eq~"+apisData.getCountryInfo().getCountryId()+"~and~currentLocationId~eq~"+apisData.getSelectedBranchId()+"~and~plateNo~contains~"+ apisData.getVehicleCreate().getPlateNumberForAngular()+")"));
        return apisData;
    }


}
