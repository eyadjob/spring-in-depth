package com.spring.in.depth.mastering.bean.contract;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CalculateBillingInformation {

    @JsonProperty("bookingId")
    public String bookingId;
    @JsonProperty("extras")
    public List<Object> extras = null;
    @JsonProperty("userDiscounts")
    public List<Object> userDiscounts = null;
    @JsonProperty("offers")
    public List<Integer> offers = null;
    @JsonProperty("contractType")
    public Integer contractType;
    @JsonProperty("vehicleId")
    public Integer vehicleId;
    @JsonProperty("rentalRateId")
    public Integer rentalRateId;
    @JsonProperty("dropoffDate")
    public String dropoffDate;
    @JsonProperty("pickupDate")
    public String pickupDate;
    @JsonProperty("statusId")
    public Integer statusId;
    @JsonProperty("voucherOperationTypeId")
    public Integer voucherOperationTypeId;
    @JsonProperty("pickupBranchId")
    public Integer pickupBranchId;
    @JsonProperty("dropoffBranchId")
    public Integer dropoffBranchId;
    @JsonProperty("fuelOutId")
    public Integer fuelOutId;
    @JsonProperty("customerId")
    public Integer customerId;
    @JsonProperty("driverAuthorizationTypeId")
    public Integer driverAuthorizationTypeId;
    @JsonProperty("categoryId")
    public Integer categoryId;

}