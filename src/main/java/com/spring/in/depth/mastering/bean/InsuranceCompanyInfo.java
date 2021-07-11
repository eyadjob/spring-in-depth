package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.in.depth.mastering.bean.common.DefaultItemsResponseBean;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class InsuranceCompanyInfo extends DefaultItemsResponseBean {

    private String insuranceCompanyName;
    private String insuranceCompanyId;

    public InsuranceCompanyInfo(String insuranceCompanyId, String insuranceCompanyName) {
        this.insuranceCompanyId = insuranceCompanyId;
        this.insuranceCompanyName = insuranceCompanyName;
    }

}
