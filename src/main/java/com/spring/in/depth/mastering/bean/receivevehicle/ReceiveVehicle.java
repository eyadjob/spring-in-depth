package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ReceiveVehicle {

        @JsonProperty("vehicleId")
        private Integer vehicleId;
        @JsonProperty("fuelId")
        private Integer fuelId;
        @JsonProperty("odometer")
        private Integer odometer;
        @JsonProperty("signature")
        private Signature signature;
        @JsonProperty("referenceDetails")
        private ReferenceDetails referenceDetails;
        @JsonProperty("skeletonDetails")
        private SkeletonDetails skeletonDetails;
        @JsonProperty("vehicleCheckDamages")
        private VehicleCheckDamages vehicleCheckDamages;
        @JsonProperty("snapshots")
        private List<Snapshot> snapshots = null;
        @JsonProperty("totalDamagesCost")
        private TotalDamagesCost totalDamagesCost;
        @JsonProperty("damageStatusId")
        private Object damageStatusId;

    }
