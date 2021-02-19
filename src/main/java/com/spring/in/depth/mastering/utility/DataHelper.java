package com.spring.in.depth.mastering.utility;

import com.spring.in.depth.mastering.bean.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DataHelper {


    public CustomerInfo getCustomerInfo() {
        String  re = String.valueOf(new Date().getTime());
        return new CustomerInfo();
    }


}
