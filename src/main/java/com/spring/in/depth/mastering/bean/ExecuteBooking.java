package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ExecuteBooking {

    @JsonProperty("rentalRateId")
    public Integer rentalRateId;
    @JsonProperty("contractPaymentInfo")
    public ContractPaymentInfo contractPaymentInfo;
    @JsonProperty("userDiscounts")
    public List<Object> userDiscounts = null;
    @JsonProperty("externalLoyaltyId")
    public Object externalLoyaltyId;
    @JsonProperty("contractOffers")
    public List<ContractOffer> contractOffers = null;
    @JsonProperty("bookingId")
    public String bookingId;
    @JsonProperty("calculationResult")
    public CalculationResult calculationResult;
    @JsonProperty("paymentInfo")
    public PaymentInfo paymentInfo;
    @JsonProperty("pickupBranchId")
    public Integer pickupBranchId;
    @JsonProperty("dropoffBranchId")
    public Integer dropoffBranchId;
    @JsonProperty("dropoffDate")
    public String dropoffDate;
    @JsonProperty("source")
    public Integer source;
    @JsonProperty("transferCostId")
    public Integer transferCostId;
    @JsonProperty("extras")
    public List<Object> extras = null;
    @JsonProperty("vehicleInfo")
    public VehicleInfo vehicleInfo;
    @JsonProperty("customerInfo")
    public CustomerInfo customerInfo;
    @JsonProperty("skipAuthorization")
    public Boolean skipAuthorization;
    @JsonProperty("readyVehicleBlockingKey")
    public String readyVehicleBlockingKey;
    @JsonProperty("pickupDate")
    public String pickupDate;
    @JsonProperty("comments")
    public String comments;
    @JsonProperty("driverAuthorizationTypeId")
    public Integer driverAuthorizationTypeId;
    @JsonProperty("vehicleCheckData")
    public VehicleCheckData vehicleCheckData;
    @JsonProperty("totalDamagesCost")
    public TotalDamagesCost totalDamagesCost;
    @JsonProperty("damageStatusId")
    public Object damageStatusId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class ContractOffer {

        @JsonProperty("offerId")
        public Integer offerId;
        @JsonProperty("isFullPaid")
        public Boolean isFullPaid;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)

    @Data
    public class CustomerInfo {

        @JsonProperty("driverId")
        public Integer driverId;
        @JsonProperty("identityId")
        public Integer identityId;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class ContractPaymentInfo {

        @JsonProperty("voucherCreateInput")
        public VoucherCreateInput voucherCreateInput;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
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

            public class DiscountDescription {

                @JsonProperty("type")
                public String type;
                @JsonProperty("percentage")
                public String percentage;
                @JsonProperty("isOffer")
                public Boolean isOffer;

            }

            public class Duration {

                @JsonProperty("start")
                public String start;
                @JsonProperty("end")
                public String end;
                @JsonProperty("duration")
                public String duration;

            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class Amount {

        @JsonProperty("value")
        public Integer value;
        @JsonProperty("currencyId")
        public Integer currencyId;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class VoucherCreateInput {

        @JsonProperty("voucherOperationTypeId")
        public Integer voucherOperationTypeId;
        @JsonProperty("voucherTypeId")
        public Integer voucherTypeId;
        @JsonProperty("basePaymentInformationDto")
        public BasePaymentInformationDto basePaymentInformationDto;
        @JsonProperty("voucherDateTime")
        public String voucherDateTime;
        @JsonProperty("sourceId")
        public Integer sourceId;

        public class BasePaymentInformationDto {

            @JsonProperty("discriminator")
            public String discriminator;
            @JsonProperty("paymentMethodId")
            public Integer paymentMethodId;
            @JsonProperty("amount")
            public Amount amount;

        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class VehicleInfo {

        @JsonProperty("vehicleId")
        public Integer vehicleId;
        @JsonProperty("categoryId")
        public Integer categoryId;
        @JsonProperty("odometer")
        public Integer odometer;
        @JsonProperty("fuelId")
        public Integer fuelId;
        @JsonProperty("branchId")
        public Integer branchId;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class VehicleCheckData {

        @JsonProperty("vehicleId")
        public Integer vehicleId;
        @JsonProperty("fuelId")
        public Integer fuelId;
        @JsonProperty("odometer")
        public Integer odometer;
        @JsonProperty("referenceDetails")
        public ReferenceDetails referenceDetails;
        @JsonProperty("skeletonDetails")
        public SkeletonDetails skeletonDetails;
        @JsonProperty("vehicleCheckDamages")
        public VehicleCheckDamages vehicleCheckDamages;
        @JsonProperty("skeletonBodyDamages")
        public List<Object> skeletonBodyDamages = null;
        @JsonProperty("otherDamages")
        public List<Object> otherDamages = null;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class VehicleCheckDamages {

        @JsonProperty("checkItemStatuses")
        public List<CheckItemStatus> checkItemStatuses = null;
        @JsonProperty("skeletonBodyDamages")
        public List<Object> skeletonBodyDamages = null;
        @JsonProperty("otherDamages")
        public List<Object> otherDamages = null;

        public class CheckItemStatus {

            @JsonProperty("checklistId")
            public Integer checklistId;
            @JsonProperty("checkItemId")
            public Integer checkItemId;
            @JsonProperty("choiceId")
            public Integer choiceId;

        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class TotalDamagesCost {

        @JsonProperty("value")
        public Integer value;
        @JsonProperty("currencyId")
        public Integer currencyId;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class SkeletonImage {

        @JsonProperty("id")
        public String id;
        @JsonProperty("url")
        public String url;
        @JsonProperty("isNewDocument")
        public Boolean isNewDocument;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class SkeletonDetails {

        @JsonProperty("skeletonId")
        public Integer skeletonId;
        @JsonProperty("skeletonImage")
        public SkeletonImage skeletonImage;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class ReferenceDetails {

        @JsonProperty("checkTypeId")
        public Integer checkTypeId;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class ItemNameLocalized {

        @JsonProperty("stringValue")
        public String stringValue;
        @JsonProperty("currentCultureText")
        public String currentCultureText;

    }
}