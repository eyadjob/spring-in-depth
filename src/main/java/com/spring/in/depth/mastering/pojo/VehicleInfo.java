package com.spring.in.depth.mastering.pojo;

import com.spring.in.depth.mastering.bean.FuelTypes;
import com.spring.in.depth.mastering.bean.InsuranceCompanies;
import lombok.Setter;

import java.util.Date;
import java.util.Random;

@Setter
public class VehicleInfo {


    private String plateNumber;
    private String chassisNumber;
    private FuelTypes fuelTypes;
    private InsuranceCompanies insuranceCompanies = new InsuranceCompanies();


    public VehicleInfo() {
        settRandomValidPlateNumber();
        settRandomValidChassisNumber();
    }

    public void settRandomValidPlateNumber() {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        this.plateNumber = alpha.charAt(r.nextInt(26)) + " " + alpha.charAt(r.nextInt(26)) + " " + alpha.charAt(r.nextInt(26)) + " " + r.nextInt(3) + r.nextInt(2) + r.nextInt(7) + r.nextInt(6);
    }

    public void settRandomValidChassisNumber() {
        String cn = String.valueOf(new Date().getTime());
        this.chassisNumber = "perChas" + cn.substring(2, cn.length() - 1);
    }


}