package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CalculateBillingInformationResponse {

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

    public class Result {

        @JsonProperty("calculationResult")
        public CalculationResult calculationResult;
        @JsonProperty("paymentInfo")
        public PaymentInfo paymentInfo;
        @JsonProperty("voucherBasicInfo")
        public VoucherBasicInfo voucherBasicInfo;
        @JsonProperty("deferredDisbursementInfo")
        public DeferredDisbursementInfo deferredDisbursementInfo;
        @JsonProperty("includeInsuranceDepositIfExists")
        public Boolean includeInsuranceDepositIfExists;
        @JsonProperty("transferCostId")
        public Integer transferCostId;
        @JsonProperty("comments")
        public Object comments;
        @JsonProperty("refundDetails")
        public Object refundDetails;

        public class DeferredDisbursementInfo {

            @JsonProperty("amount")
            public Object amount;

        }
        public class CalculationResult {

            @JsonProperty("netAmount")
            public Double netAmount;
            @JsonProperty("insuranceDeposit")
            public Object insuranceDeposit;
            @JsonProperty("serializedCalculationItems")
            public String serializedCalculationItems;
            @JsonProperty("paymentItemsSerialKey")
            public Integer paymentItemsSerialKey;
            @JsonProperty("isCummlative")
            public Boolean isCummlative;
            @JsonProperty("isAdditional")
            public Boolean isAdditional;
            @JsonProperty("calculationItems")
            public List<CalculationItem> calculationItems = null;

            public class CalculationItem {

                @JsonProperty("itemTypeId")
                public Integer itemTypeId;
                @JsonProperty("itemName")
                public String itemName;
                @JsonProperty("itemNameLocalized")
                public ItemNameLocalized itemNameLocalized;
                @JsonProperty("itemNameRaw")
                public String itemNameRaw;
                @JsonProperty("quantity")
                public Double quantity;
                @JsonProperty("isPctDiscount")
                public Boolean isPctDiscount;
                @JsonProperty("discountPCT")
                public Double discountPCT;
                @JsonProperty("discountAmount")
                public Double discountAmount;
                @JsonProperty("minimumDiscount")
                public Double minimumDiscount;
                @JsonProperty("maximumDiscount")
                public Double maximumDiscount;
                @JsonProperty("minimumDiscountAmount")
                public Double minimumDiscountAmount;
                @JsonProperty("maximumDiscountAmount")
                public Double maximumDiscountAmount;
                @JsonProperty("discountDescription")
                public List<DiscountDescription> discountDescription = null;
                @JsonProperty("taxPercentage")
                public Double taxPercentage;
                @JsonProperty("taxAmount")
                public Double taxAmount;
                @JsonProperty("unitPrice")
                public Double unitPrice;
                @JsonProperty("totalPrice")
                public Double totalPrice;
                @JsonProperty("netPrice")
                public Double netPrice;
                @JsonProperty("isVisible")
                public Boolean isVisible;
                @JsonProperty("unitDescription")
                public String unitDescription;
                @JsonProperty("duration")
                public Duration duration;
                @JsonProperty("taxConfigurations")
                public String taxConfigurations;

                public class Duration {

                    @JsonProperty("start")
                    public String start;
                    @JsonProperty("end")
                    public String end;
                    @JsonProperty("duration")
                    public String duration;

                }

                public class DiscountDescription {

                    @JsonProperty("type")
                    public String type;
                    @JsonProperty("percentage")
                    public String percentage;
                    @JsonProperty("isOffer")
                    public Boolean isOffer;

                }

                public class ItemNameLocalized {

                    @JsonProperty("stringValue")
                    public String stringValue;
                    @JsonProperty("currentCultureText")
                    public String currentCultureText;

                }
            }
        }

        public class VoucherBasicInfo {

            @JsonProperty("typeName")
            public String typeName;
            @JsonProperty("typeId")
            public Integer typeId;

        }

        public class PaymentInfo {

            @JsonProperty("paidAmount")
            public Double paidAmount;
            @JsonProperty("remainingAmount")
            public Double remainingAmount;
            @JsonProperty("refundAmount")
            public Object refundAmount;
            @JsonProperty("minimumPayment")
            public Double minimumPayment;
            @JsonProperty("maximumPayment")
            public Double maximumPayment;
            @JsonProperty("minimumPaymentPercentage")
            public Double minimumPaymentPercentage;
            @JsonProperty("maximumPaymentPercentage")
            public Double maximumPaymentPercentage;
            @JsonProperty("defaultPayment")
            public Double defaultPayment;
            @JsonProperty("currencyIso")
            public String currencyIso;
            @JsonProperty("currencyId")
            public Integer currencyId;
            @JsonProperty("currencyDecimalPlaces")
            public Integer currencyDecimalPlaces;
            @JsonProperty("voucherAmount")
            public Double voucherAmount;
            @JsonProperty("nonDeferredAmount")
            public Object nonDeferredAmount;

        }

    }


}