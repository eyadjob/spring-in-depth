package com.spring.in.depth.mastering.bean.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VehicleCreate {

    @JsonProperty("vehicleDtos")
    public List<VehicleDto> vehicleDtos;


    public VehicleCreate() {
        vehicleDtos = new ArrayList<>();
        vehicleDtos.add(new VehicleDto());
        vehicleDtos.get(0).setVehicleInsuranceInfo(new VehicleCreate.VehicleDto.VehicleInsuranceInfo());
        vehicleDtos.get(0).setVehicleLicenseInfo(new VehicleCreate.VehicleDto.VehicleLicenseInfo());
        vehicleDtos.get(0).setVehicleManufacturingInfo(new VehicleCreate.VehicleDto.VehicleManufacturingInfo());
        vehicleDtos.get(0).setSpecs(new VehicleCreate.VehicleDto.Specs());
        vehicleDtos.get(0).setPurchaseInfo(new VehicleCreate.VehicleDto.PurchaseInfo());
        vehicleDtos.get(0).setVehicleInsuranceInfo(new VehicleCreate.VehicleDto.VehicleInsuranceInfo());
        vehicleDtos.get(0).setLocationInfo(new VehicleCreate.VehicleDto.LocationInfo());
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class VehicleDto {

        @JsonProperty("odometer")
        public String odometer;
        @JsonProperty("fuelId")
        public Integer fuelId;
        @JsonProperty("branchId")
        public String branchId;
        @JsonProperty("vehicleManufacturingInfo")
        public VehicleManufacturingInfo vehicleManufacturingInfo;
        @JsonProperty("vehicleLicenseInfo")
        public VehicleLicenseInfo vehicleLicenseInfo;
        @JsonProperty("vehicleInsuranceInfo")
        public VehicleInsuranceInfo vehicleInsuranceInfo;
        @JsonProperty("locationInfo")
        public LocationInfo locationInfo;
        @JsonProperty("purchaseInfo")
        public PurchaseInfo purchaseInfo;
        @JsonProperty("specs")
        public Specs specs;
        @JsonProperty("countryId")
        public String countryId;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class Specs {

            @JsonProperty("colorId")
            public String colorId;
            @JsonProperty("trimLevelId")
            public String trimLevelId;
            @JsonProperty("fuelTypeId")
            public String fuelTypeId;
            @JsonProperty("fuelTankSize")
            public Integer fuelTankSize;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public  static class PurchaseInfo {

            @JsonProperty("vendorId")
            public Object vendorId;
            @JsonProperty("date")
            public String date;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public  static class LocationInfo {

            @JsonProperty("currentLocationId")
            public String currentLocationId;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class VehicleManufacturingInfo {

            @JsonProperty("modelId")
            public String modelId;
            @JsonProperty("year")
            public Integer year;
            @JsonProperty("chassisNo")
            public String chassisNo;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class VehicleLicenseInfo {

            @JsonProperty("licenseTypeId")
            public String licenseTypeId;
            @JsonProperty("usageTypeId")
            public String usageTypeId;
            @JsonProperty("plateNo")
            public String plateNo;



        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public  static class VehicleInsuranceInfo {

            @JsonProperty("insuranceCompanyId")
            public String insuranceCompanyId;


        }
    }

    public  String getPlateNumberForAngular() {
        StringBuilder pnk = new StringBuilder(this.vehicleDtos.get(0).vehicleLicenseInfo.getPlateNo());
        return pnk.insert(0, "%27").append("%27").toString().replaceAll(" ", "%2520");
    }

}