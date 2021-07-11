package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CreateBooking {

    @JsonProperty("countryId")
    private Integer countryId;
    @JsonProperty("pickupDate")
    private String pickupDate;
    @JsonProperty("dropoffDate")
    private String dropoffDate;
    @JsonProperty("pickupBranchId")
    private Integer pickupBranchId;
    @JsonProperty("dropoffBranchId")
    private Integer dropoffBranchId;
    @JsonProperty("categoryId")
    private String categoryId;
    @JsonProperty("modelId")
    private String modelId;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("driverId")
    private Integer driverId;
    @JsonProperty("rentalRateId")
    private Integer rentalRateId;
    @JsonProperty("transferCostId")
    private Integer transferCostId;
    @JsonProperty("sourceId")
    private Integer sourceId;
    @JsonProperty("voucherCreateInput")
    private VoucherCreateInput voucherCreateInput;
    @JsonProperty("extras")
    private List<Object> extras = null;
    @JsonProperty("bookingOffers")
    private List<BookingOffer> bookingOffers = null;

}