package com.spring.in.depth.mastering.bean.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BookingCalculateBillingInformation {


    @JsonProperty("extras")
    public List<Integer> extras = new ArrayList<>();
    @JsonProperty("modelId")
    public String modelId;
    @JsonProperty("year")
    public Integer year;
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
    @JsonProperty("customerId")
    public Integer customerId;
    @JsonProperty("categoryId")
    public String categoryId;


}
