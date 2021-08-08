package com.spring.in.depth.mastering.pojo;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.bean.FuelTypes;
import com.spring.in.depth.mastering.bean.InsuranceCompanies;
import com.spring.in.depth.mastering.bean.vehicle.VehicleCreate;
import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Random;

@Data
public class VehicleInfo {

    @Autowired
    AllGetApiServices allGetApiServices;

    private String plateNumber;
    private String chassisNumber;
    private FuelTypes fuelTypes;
    private InsuranceCompanies insuranceCompanies = new InsuranceCompanies();
    private String angularPlateNumber;
    private int id;
    private int fuelId;


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

    public String getPlateNumberForAngular() {
        StringBuilder pnk = new StringBuilder(plateNumber);
        angularPlateNumber=  pnk.insert(0, "%27").append("%27").toString().replaceAll(" ", "%2520");
        return angularPlateNumber;
    }

    public String getPlateNumberForAngular(String plateNumber) {
        StringBuilder pnk = new StringBuilder(plateNumber);
        angularPlateNumber=  pnk.insert(0, "%27").append("%27").toString().replaceAll(" ", "%2520");
        return angularPlateNumber;
    }

    public String getDataInAngularEncoding(String... params) {
       String angularEncodedUrl =  "Request=page%3D1%26pageSize%3D15%26sort%3DlastModificationTime-desc%26filter%3D(countryId~eq~"+params[0]+"~and~(currentLocationId~eq~"+params[1]+"~or~currentLocationId~eq~"+params[2]+")~and~statusId~eq~"+params[3]+"~and~plateNo~contains~"+getPlateNumberForAngular()+")";
       return angularEncodedUrl;
    }

    public VehicleCreate getCreateVehiclePayloadWithPogo(ApisData apisData) {
        VehicleCreate vehicleCreatePayload = new VehicleCreate();
        vehicleCreatePayload.getVehicleDtos().get(0).setOdometer("22");
        vehicleCreatePayload.getVehicleDtos().get(0).setFuelId(208);
        vehicleCreatePayload.getVehicleDtos().get(0).setBranchId(apisData.getBranchesComboBoxResponse().getSelectedBranch().getBranchId());
        vehicleCreatePayload.getVehicleDtos().get(0).getLocationInfo().setCurrentLocationId(apisData.getBranchesComboBoxResponse().getSelectedBranch().getBranchId());
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleManufacturingInfo().setModelId("107");
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleManufacturingInfo().setYear(2021);
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleManufacturingInfo().setChassisNo(chassisNumber);
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleLicenseInfo().setLicenseTypeId("181");
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleLicenseInfo().setUsageTypeId("190");
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleLicenseInfo().setPlateNo(plateNumber);
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleLicenseInfo().setPlateNo(plateNumber);
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleLicenseInfo().setPlateNo(plateNumber);
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleLicenseInfo().setPlateNo(plateNumber);
        vehicleCreatePayload.getVehicleDtos().get(0).getVehicleInsuranceInfo().setInsuranceCompanyId(apisData.getVehicleInfo().getInsuranceCompanies().getResult().getItems().get(1).getValue());
        vehicleCreatePayload.getVehicleDtos().get(0).getSpecs().setColorId("1001339");
        vehicleCreatePayload.getVehicleDtos().get(0).getSpecs().setTrimLevelId("171");
        vehicleCreatePayload.getVehicleDtos().get(0).getSpecs().setFuelTypeId("3");
        vehicleCreatePayload.getVehicleDtos().get(0).getSpecs().setFuelTankSize(60);
        vehicleCreatePayload.getVehicleDtos().get(0).setCountryId(String.valueOf(apisData.getCountryInfo().getCountryId()));
        return vehicleCreatePayload;
    }

}