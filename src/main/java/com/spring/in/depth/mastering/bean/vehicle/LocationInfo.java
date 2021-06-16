package com.spring.in.depth.mastering.bean.vehicle;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "currentLocationId"
})
@Generated("jsonschema2pojo")
public class LocationInfo {

    @JsonProperty("currentLocationId")
    private String currentLocationId;

    @JsonProperty("currentLocationId")
    public String getCurrentLocationId() {
        return currentLocationId;
    }

    @JsonProperty("currentLocationId")
    public void setCurrentLocationId(String currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

}