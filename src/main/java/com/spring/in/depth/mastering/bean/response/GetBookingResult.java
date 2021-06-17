package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.in.depth.mastering.bean.common.BillingInformation;
import com.spring.in.depth.mastering.bean.common.BookingOffer;

import java.util.List;

public class GetBookingResult {

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

    @JsonProperty("countryId")
    public Integer getCountryId() {
        return countryId;
    }

    @JsonProperty("countryId")
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("pickupDate")
    public String getPickupDate() {
        return pickupDate;
    }

    @JsonProperty("pickupDate")
    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    @JsonProperty("dropoffDate")
    public String getDropoffDate() {
        return dropoffDate;
    }

    @JsonProperty("dropoffDate")
    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    @JsonProperty("contractExpectedDropoffDateUponExecute")
    public String getContractExpectedDropoffDateUponExecute() {
        return contractExpectedDropoffDateUponExecute;
    }

    @JsonProperty("contractExpectedDropoffDateUponExecute")
    public void setContractExpectedDropoffDateUponExecute(String contractExpectedDropoffDateUponExecute) {
        this.contractExpectedDropoffDateUponExecute = contractExpectedDropoffDateUponExecute;
    }

    @JsonProperty("nowDate")
    public String getNowDate() {
        return nowDate;
    }

    @JsonProperty("nowDate")
    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }

    @JsonProperty("pickupBranchId")
    public Integer getPickupBranchId() {
        return pickupBranchId;
    }

    @JsonProperty("pickupBranchId")
    public void setPickupBranchId(Integer pickupBranchId) {
        this.pickupBranchId = pickupBranchId;
    }

    @JsonProperty("dropoffBranchId")
    public Integer getDropoffBranchId() {
        return dropoffBranchId;
    }

    @JsonProperty("dropoffBranchId")
    public void setDropoffBranchId(Integer dropoffBranchId) {
        this.dropoffBranchId = dropoffBranchId;
    }

    @JsonProperty("categoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("modelId")
    public Integer getModelId() {
        return modelId;
    }

    @JsonProperty("modelId")
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("driverId")
    public Integer getDriverId() {
        return driverId;
    }

    @JsonProperty("driverId")
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @JsonProperty("rentalRateId")
    public Integer getRentalRateId() {
        return rentalRateId;
    }

    @JsonProperty("rentalRateId")
    public void setRentalRateId(Integer rentalRateId) {
        this.rentalRateId = rentalRateId;
    }

    @JsonProperty("transferCostId")
    public Integer getTransferCostId() {
        return transferCostId;
    }

    @JsonProperty("transferCostId")
    public void setTransferCostId(Integer transferCostId) {
        this.transferCostId = transferCostId;
    }

    @JsonProperty("sourceId")
    public Integer getSourceId() {
        return sourceId;
    }

    @JsonProperty("sourceId")
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @JsonProperty("comment")
    public Object getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(Object comment) {
        this.comment = comment;
    }

    @JsonProperty("voucherCreateInput")
    public Object getVoucherCreateInput() {
        return voucherCreateInput;
    }

    @JsonProperty("voucherCreateInput")
    public void setVoucherCreateInput(Object voucherCreateInput) {
        this.voucherCreateInput = voucherCreateInput;
    }

    @JsonProperty("extras")
    public List<Object> getExtras() {
        return extras;
    }

    @JsonProperty("extras")
    public void setExtras(List<Object> extras) {
        this.extras = extras;
    }

    @JsonProperty("bookingOffers")
    public List<BookingOffer> getBookingOffers() {
        return bookingOffers;
    }

    @JsonProperty("bookingOffers")
    public void setBookingOffers(List<BookingOffer> bookingOffers) {
        this.bookingOffers = bookingOffers;
    }

    @JsonProperty("billingInformation")
    public BillingInformation getBillingInformation() {
        return billingInformation;
    }

    @JsonProperty("billingInformation")
    public void setBillingInformation(BillingInformation billingInformation) {
        this.billingInformation = billingInformation;
    }

    @JsonProperty("validatePickUpDate")
    public Boolean getValidatePickUpDate() {
        return validatePickUpDate;
    }

    @JsonProperty("validatePickUpDate")
    public void setValidatePickUpDate(Boolean validatePickUpDate) {
        this.validatePickUpDate = validatePickUpDate;
    }

    @JsonProperty("userDiscounts")
    public List<Object> getUserDiscounts() {
        return userDiscounts;
    }

    @JsonProperty("userDiscounts")
    public void setUserDiscounts(List<Object> userDiscounts) {
        this.userDiscounts = userDiscounts;
    }

    @JsonProperty("flightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("flightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("couponCode")
    public Object getCouponCode() {
        return couponCode;
    }

    @JsonProperty("couponCode")
    public void setCouponCode(Object couponCode) {
        this.couponCode = couponCode;
    }

    @JsonProperty("lastModificationTime")
    public Object getLastModificationTime() {
        return lastModificationTime;
    }

    @JsonProperty("lastModificationTime")
    public void setLastModificationTime(Object lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    @JsonProperty("lastModifierUserId")
    public Object getLastModifierUserId() {
        return lastModifierUserId;
    }

    @JsonProperty("lastModifierUserId")
    public void setLastModifierUserId(Object lastModifierUserId) {
        this.lastModifierUserId = lastModifierUserId;
    }

    @JsonProperty("creationTime")
    public String getCreationTime() {
        return creationTime;
    }

    @JsonProperty("creationTime")
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    @JsonProperty("creatorUserId")
    public Integer getCreatorUserId() {
        return creatorUserId;
    }

    @JsonProperty("creatorUserId")
    public void setCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

}