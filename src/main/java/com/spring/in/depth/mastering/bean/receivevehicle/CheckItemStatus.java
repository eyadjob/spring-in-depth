package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckItemStatus {

    @JsonProperty("checklistId")
    private Integer checklistId;
    @JsonProperty("checkItemId")
    private Integer checkItemId;
    @JsonProperty("choiceId")
    private Integer choiceId;

    @JsonProperty("checklistId")
    public Integer getChecklistId() {
        return checklistId;
    }

    @JsonProperty("checklistId")
    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    @JsonProperty("checkItemId")
    public Integer getCheckItemId() {
        return checkItemId;
    }

    @JsonProperty("checkItemId")
    public void setCheckItemId(Integer checkItemId) {
        this.checkItemId = checkItemId;
    }

    @JsonProperty("choiceId")
    public Integer getChoiceId() {
        return choiceId;
    }

    @JsonProperty("choiceId")
    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }

}