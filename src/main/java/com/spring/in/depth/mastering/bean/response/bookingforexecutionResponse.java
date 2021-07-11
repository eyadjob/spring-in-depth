package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class bookingforexecutionResponse {

    @JsonProperty("result")
    public Result result;
    @JsonProperty("targetUrl")
    public Object targetUrl;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("error")
    public String error;
    @JsonProperty("unAuthorizedRequest")
    public Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    public Boolean abp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class Result {

        @JsonProperty("countryId")
        public Integer countryId;
        @JsonProperty("pickupDate")
        public String pickupDate;
        @JsonProperty("dropoffDate")
        public String dropoffDate;
        @JsonProperty("contractExpectedDropoffDateUponExecute")
        public String contractExpectedDropoffDateUponExecute;
        @JsonProperty("nowDate")
        public String nowDate;
        @JsonProperty("pickupBranchId")
        public Integer pickupBranchId;
        @JsonProperty("dropoffBranchId")
        public Integer dropoffBranchId;
        @JsonProperty("categoryId")
        public Integer categoryId;
        @JsonProperty("modelId")
        public Integer modelId;
        @JsonProperty("year")
        public Integer year;
        @JsonProperty("driverId")
        public Integer driverId;
        @JsonProperty("rentalRateId")
        public Integer rentalRateId;
        @JsonProperty("transferCostId")
        public Integer transferCostId;
        @JsonProperty("sourceId")
        public Integer sourceId;
        @JsonProperty("comment")
        public Object comment;
        @JsonProperty("voucherCreateInput")
        public Object voucherCreateInput;
        @JsonProperty("extras")
        public List<Object> extras = null;
        @JsonProperty("bookingOffers")
        public List<BookingOffer> bookingOffers = null;
        @JsonProperty("billingInformation")
        public BillingInformation billingInformation;
        @JsonProperty("validatePickUpDate")
        public Boolean validatePickUpDate;
        @JsonProperty("userDiscounts")
        public List<Object> userDiscounts = null;
        @JsonProperty("flightNumber")
        public String flightNumber;
        @JsonProperty("couponCode")
        public Object couponCode;
        @JsonProperty("lastModificationTime")
        public Object lastModificationTime;
        @JsonProperty("lastModifierUserId")
        public Object lastModifierUserId;
        @JsonProperty("creationTime")
        public String creationTime;
        @JsonProperty("creatorUserId")
        public Integer creatorUserId;
        @JsonProperty("id")
        public Integer id;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public class BillingInformation {

            @JsonProperty("paid")
            public Double paid;
            @JsonProperty("totalDueAmount")
            public Double totalDueAmount;
            @JsonProperty("remaining")
            public Double remaining;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public class BookingOffer {

            @JsonProperty("offerId")
            public Integer offerId;
            @JsonProperty("isFullPaid")
            public Boolean isFullPaid;
            @JsonProperty("isCumulativeDiscountEnabled")
            public Object isCumulativeDiscountEnabled;

        }
    }
}
