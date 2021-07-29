package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GetAllBranchVehicles {

    @JsonProperty("result")
    public Result result;
    @JsonProperty("targetUrl")
    public Object targetUrl;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("error")
    public Object error;
    @JsonProperty("unAuthorizedRequest")
    public Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    public Boolean abp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class Result {

        @JsonProperty("total")
        public Integer total;
        @JsonProperty("data")
        public List<Datum> data = null;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class Datum {

            @JsonProperty("category")
            public String category;
            @JsonProperty("manufacturer")
            public String manufacturer;
            @JsonProperty("model")
            public String model;
            @JsonProperty("year")
            public Integer year;
            @JsonProperty("plateNo")
            public String plateNo;
            @JsonProperty("status")
            public String status;
            @JsonProperty("statusId")
            public Integer statusId;
            @JsonProperty("additionalStatuses")
            public String additionalStatuses;
            @JsonProperty("additionalStatusIds")
            public Object additionalStatusIds;
            @JsonProperty("usageType")
            public String usageType;
            @JsonProperty("vendor")
            public Object vendor;
            @JsonProperty("branch")
            public String branch;
            @JsonProperty("currentLocationId")
            public Integer currentLocationId;
            @JsonProperty("currentLocation")
            public String currentLocation;
            @JsonProperty("countryId")
            public Integer countryId;
            @JsonProperty("branchId")
            public Integer branchId;
            @JsonProperty("dailyRentalRate")
            public Double dailyRentalRate;
            @JsonProperty("isNeedCleaning")
            public Boolean isNeedCleaning;
            @JsonProperty("isAssignVehicleToBranch")
            public Boolean isAssignVehicleToBranch;
            @JsonProperty("isAllowedToChangeVehicleLocation")
            public Boolean isAllowedToChangeVehicleLocation;
            @JsonProperty("usageTypeId")
            public Integer usageTypeId;
            @JsonProperty("engineSize")
            public Object engineSize;
            @JsonProperty("trimId")
            public Integer trimId;
            @JsonProperty("modelId")
            public Integer modelId;
            @JsonProperty("needToBeChecked")
            public Boolean needToBeChecked;
            @JsonProperty("recordActions")
            public List<RecordAction> recordActions = null;
            @JsonProperty("isExternal")
            public Boolean isExternal;
            @JsonProperty("odometer")
            public Integer odometer;
            @JsonProperty("hasPreventiveMaintenance")
            public Boolean hasPreventiveMaintenance;
            @JsonProperty("rentalRate")
            public RentalRate rentalRate;
            @JsonProperty("categoryId")
            public Integer categoryId;
            @JsonProperty("discountDescription")
            public List<Object> discountDescription = null;
            @JsonProperty("authorizationStatus")
            public Boolean authorizationStatus;
            @JsonProperty("fuelId")
            public Integer fuelId;
            @JsonProperty("fuel")
            public String fuel;
            @JsonProperty("lastModificationTime")
            public String lastModificationTime;
            @JsonProperty("lastModifierUserId")
            public Object lastModifierUserId;
            @JsonProperty("creationTime")
            public String creationTime;
            @JsonProperty("creatorUserId")
            public Object creatorUserId;
            @JsonProperty("id")
            public Integer id;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class RentalRate {

                @JsonProperty("rentalRateId")
                public Integer rentalRateId;
                @JsonProperty("dailyRate")
                public Double dailyRate;
                @JsonProperty("originalDailyRate")
                public Double originalDailyRate;
                @JsonProperty("extraKMRate")
                public Double extraKMRate;
                @JsonProperty("periodName")
                public String periodName;
                @JsonProperty("periodId")
                public Integer periodId;
                @JsonProperty("freeKM")
                public Integer freeKM;
                @JsonProperty("currencyIso")
                public String currencyIso;
                @JsonProperty("utilizationRateDiscountPercentage")
                public Object utilizationRateDiscountPercentage;
                @JsonProperty("utilizationRateId")
                public Object utilizationRateId;
                @JsonProperty("hasOffers")
                public Boolean hasOffers;
                @JsonProperty("hasUtilizationRateOrOffers")
                public Boolean hasUtilizationRateOrOffers;

            }

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class RecordAction {

                @JsonProperty("title")
                public String title;
                @JsonProperty("icon")
                public String icon;
                @JsonProperty("customClass")
                public Object customClass;
                @JsonProperty("frontEndFunction")
                public String frontEndFunction;
                @JsonProperty("frontEndFunctionParameter")
                public String frontEndFunctionParameter;
                @JsonProperty("orderNumber")
                public Integer orderNumber;

            }
        }
    }

}