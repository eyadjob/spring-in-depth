package com.spring.in.depth.mastering.pojo;

import com.spring.in.depth.mastering.bean.Branches;
import com.spring.in.depth.mastering.bean.countryinfo.CurrnecyInfo;
import lombok.Data;

@Data
public class CountryInfo {

    private String countryName;
    private long countryId;
    private String currencyIsoCode;
    private String currencyName;
    private String currencyDecimalPlaces;
    private Branches branchesList;
    private CurrnecyInfo currnecyInfo = new CurrnecyInfo();

}
