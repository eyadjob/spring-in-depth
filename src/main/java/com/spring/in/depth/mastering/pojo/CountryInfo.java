package com.spring.in.depth.mastering.pojo;

import com.spring.in.depth.mastering.bean.countryinfo.CurrnecyInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryInfo {

    private String countryName;
    private int countryId;
    private String currencyIsoCode;
    private String currencyName;
    private String currencyDecimalPlaces;
    private CurrnecyInfo currnecyInfo = new CurrnecyInfo();
    private String selectedBranch;



    public  CountryInfo(int countryId, String countryName, String selectedBranch)
    {
        this.countryId = countryId;
        this.countryName = countryName;
        this.selectedBranch = selectedBranch;
    }


}
