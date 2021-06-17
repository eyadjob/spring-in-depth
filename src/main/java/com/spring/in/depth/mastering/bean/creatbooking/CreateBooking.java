package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
    public String getCategoryId() {
        return categoryId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("modelId")
    public String getModelId() {
        return modelId;
    }

    @JsonProperty("modelId")
    public void setModelId(String modelId) {
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

    @JsonProperty("voucherCreateInput")
    public VoucherCreateInput getVoucherCreateInput() {
        return voucherCreateInput;
    }

    @JsonProperty("voucherCreateInput")
    public void setVoucherCreateInput(VoucherCreateInput voucherCreateInput) {
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

}