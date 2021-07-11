package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result {

    @JsonProperty("items")
    private List<Item> items = null;

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

}
