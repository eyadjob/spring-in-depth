package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SnapshotDetails {

    @JsonProperty("snapshotName")
    private String snapshotName;
    @JsonProperty("snapshotId")
    private Integer snapshotId;
    @JsonProperty("isRequired")
    private Boolean isRequired;
    @JsonProperty("snapshotMonth")
    private Integer snapshotMonth;
    @JsonProperty("snapshotYear")
    private Integer snapshotYear;
    @JsonProperty("image")
    private Object image;

}