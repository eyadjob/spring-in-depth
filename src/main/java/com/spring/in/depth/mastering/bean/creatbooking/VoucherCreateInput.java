package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VoucherCreateInput {

    @JsonProperty("voucherOperationTypeId")
    private Integer voucherOperationTypeId;
    @JsonProperty("voucherTypeId")
    private Integer voucherTypeId;
    @JsonProperty("basePaymentInformationDto")
    private BasePaymentInformationDto basePaymentInformationDto;
    @JsonProperty("sourceId")
    private Integer sourceId;

}