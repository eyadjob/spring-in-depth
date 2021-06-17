package com.spring.in.depth.mastering.bean;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.in.depth.mastering.bean.common.DefaultItemsResponseBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InsuranceCompanies extends DefaultItemsResponseBean {
    

}