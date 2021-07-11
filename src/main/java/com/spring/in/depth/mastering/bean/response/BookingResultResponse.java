package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.in.depth.mastering.bean.common.BillingInformation;
import com.spring.in.depth.mastering.bean.common.BookingOffer;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BookingResultResponse {

    @JsonProperty("countryId")
    private Integer countryId;
    @JsonProperty("pickupDate")
    private String pickupDate;
    @JsonProperty("dropoffDate")
    private String dropoffDate;
    @JsonProperty("contractExpectedDropoffDateUponExecute")
    private String contractExpectedDropoffDateUponExecute;
    @JsonProperty("nowDate")
    private String nowDate;
    @JsonProperty("pickupBranchId")
    private Integer pickupBranchId;
    @JsonProperty("dropoffBranchId")
    private Integer dropoffBranchId;
    @JsonProperty("categoryId")
    private Integer categoryId;
    @JsonProperty("modelId")
    private Integer modelId;
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
    @JsonProperty("comment")
    private Object comment;
    @JsonProperty("voucherCreateInput")
    private Object voucherCreateInput;
    @JsonProperty("extras")
    private List<Object> extras = null;
    @JsonProperty("bookingOffers")
    private List<BookingOffer> bookingOffers = null;
    @JsonProperty("billingInformation")
    private BillingInformation billingInformation;
    @JsonProperty("validatePickUpDate")
    private Boolean validatePickUpDate;
    @JsonProperty("userDiscounts")
    private List<Object> userDiscounts = null;
    @JsonProperty("flightNumber")
    private String flightNumber;
    @JsonProperty("couponCode")
    private Object couponCode;
    @JsonProperty("lastModificationTime")
    private Object lastModificationTime;
    @JsonProperty("lastModifierUserId")
    private Object lastModifierUserId;
    @JsonProperty("creationTime")
    private String creationTime;
    @JsonProperty("creatorUserId")
    private Integer creatorUserId;
    @JsonProperty("id")
    private Integer id;

}