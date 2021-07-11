package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CheckItemStatus {

    @JsonProperty("checklistId")
    private Integer checklistId;
    @JsonProperty("checkItemId")
    private Integer checkItemId;
    @JsonProperty("choiceId")
    private Integer choiceId;

}