package com.spring.in.depth.mastering.bean;

import com.spring.in.depth.mastering.bean.common.DefaultItemsResponseBean;

public class InsuranceCompanyInfo extends DefaultItemsResponseBean {

    private String insuranceCompanyName;
    private String insuranceCompanyId;

    public InsuranceCompanyInfo(String insuranceCompanyId, String insuranceCompanyName) {
        this.insuranceCompanyId = insuranceCompanyId;
        this.insuranceCompanyName = insuranceCompanyName;
    }

}
