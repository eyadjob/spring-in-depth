package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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


    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("passedChoices")
    public List<Integer> getPassedChoices() {
        return passedChoices;
    }

    @JsonProperty("passedChoices")
    public void setPassedChoices(List<Integer> passedChoices) {
        this.passedChoices = passedChoices;
    }

    @JsonProperty("choices")
    public List<Choice> getChoices() {
        return choices;
    }

    @JsonProperty("choices")
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @JsonProperty("repairTasks")
    public List<RepairTask> getRepairTasks() {
        return repairTasks;
    }

    @JsonProperty("repairTasks")
    public void setRepairTasks(List<RepairTask> repairTasks) {
        this.repairTasks = repairTasks;
    }


}