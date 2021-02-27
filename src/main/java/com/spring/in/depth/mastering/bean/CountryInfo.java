package com.spring.in.depth.mastering.bean;

import lombok.Data;

import java.util.List;

@Data
public class CountryInfo {

    private String countryName;
    private long countryId;
    private String currencyIsoCode;
    private String currencyName;
    private String currencyDecimalPlaces;
    private long currencyId;
    private Branches branchesList;

}
