package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.entity.ejar.stg.EjarCountryEntity;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCountryRepository;
import com.spring.in.depth.mastering.utility.PropManager;
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

    @Autowired
    private ApisData apisData;


    public ApisData getCountryInfoByName(String countryName) {
        List<EjarCountryEntity> ejarCountryEntityList = ejarCountryRepository.getCountryLikeName(PropManager.getInstance().getProperty("country.name"));
        apisData.getValuesCache().put("countryId",String.valueOf(ejarCountryEntityList.get(0).getId()));
        apisData.getValuesCache().put("currencyId",String.valueOf(ejarCountryEntityList.get(0).getCurrencyId()));
        apisData.getValuesCache().put("countryName",String.valueOf(ejarCountryEntityList.get(0).getCountryName()));
        return apisData;
    }

}
