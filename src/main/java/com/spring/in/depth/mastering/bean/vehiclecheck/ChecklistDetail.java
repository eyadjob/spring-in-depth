package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChecklistDetail {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("checkItems")
    private List<CheckItem> checkItems = null;

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

    @JsonProperty("checkItems")
    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    @JsonProperty("checkItems")
    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }


}