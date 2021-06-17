package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoucherCreateInput {

    @JsonProperty("voucherOperationTypeId")
    private Integer voucherOperationTypeId;
    @JsonProperty("voucherTypeId")
    private Integer voucherTypeId;
    @JsonProperty("basePaymentInformationDto")
    private BasePaymentInformationDto basePaymentInformationDto;
    @JsonProperty("sourceId")
    private Integer sourceId;

    @JsonProperty("voucherOperationTypeId")
    public Integer getVoucherOperationTypeId() {
        return voucherOperationTypeId;
    }

    @JsonProperty("voucherOperationTypeId")
    public void setVoucherOperationTypeId(Integer voucherOperationTypeId) {
        this.voucherOperationTypeId = voucherOperationTypeId;
    }

    @JsonProperty("voucherTypeId")
    public Integer getVoucherTypeId() {
        return voucherTypeId;
    }

    @JsonProperty("voucherTypeId")
    public void setVoucherTypeId(Integer voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
    }

    @JsonProperty("basePaymentInformationDto")
    public BasePaymentInformationDto getBasePaymentInformationDto() {
        return basePaymentInformationDto;
    }

    @JsonProperty("basePaymentInformationDto")
    public void setBasePaymentInformationDto(BasePaymentInformationDto basePaymentInformationDto) {
        this.basePaymentInformationDto = basePaymentInformationDto;
    }

    @JsonProperty("sourceId")
    public Integer getSourceId() {
        return sourceId;
    }

    @JsonProperty("sourceId")
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

}