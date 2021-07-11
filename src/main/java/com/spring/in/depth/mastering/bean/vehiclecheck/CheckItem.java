package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CheckItem {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("passedChoices")
    private List<Integer> passedChoices = null;
    @JsonProperty("choices")
    private List<Choice> choices = null;
    @JsonProperty("repairTasks")
    private List<RepairTask> repairTasks = null;
}