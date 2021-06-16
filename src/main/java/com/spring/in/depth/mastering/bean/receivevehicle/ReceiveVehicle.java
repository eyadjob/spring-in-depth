package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

        @JsonProperty("vehicleId")
        public Integer getVehicleId() {
            return vehicleId;
        }

        @JsonProperty("vehicleId")
        public void setVehicleId(Integer vehicleId) {
            this.vehicleId = vehicleId;
        }

        @JsonProperty("fuelId")
        public Integer getFuelId() {
            return fuelId;
        }

        @JsonProperty("fuelId")
        public void setFuelId(Integer fuelId) {
            this.fuelId = fuelId;
        }

        @JsonProperty("odometer")
        public Integer getOdometer() {
            return odometer;
        }

        @JsonProperty("odometer")
        public void setOdometer(Integer odometer) {
            this.odometer = odometer;
        }

        @JsonProperty("signature")
        public Signature getSignature() {
            return signature;
        }

        @JsonProperty("signature")
        public void setSignature(Signature signature) {
            this.signature = signature;
        }

        @JsonProperty("referenceDetails")
        public ReferenceDetails getReferenceDetails() {
            return referenceDetails;
        }

        @JsonProperty("referenceDetails")
        public void setReferenceDetails(ReferenceDetails referenceDetails) {
            this.referenceDetails = referenceDetails;
        }

        @JsonProperty("skeletonDetails")
        public SkeletonDetails getSkeletonDetails() {
            return skeletonDetails;
        }

        @JsonProperty("skeletonDetails")
        public void setSkeletonDetails(SkeletonDetails skeletonDetails) {
            this.skeletonDetails = skeletonDetails;
        }

        @JsonProperty("vehicleCheckDamages")
        public VehicleCheckDamages getVehicleCheckDamages() {
            return vehicleCheckDamages;
        }

        @JsonProperty("vehicleCheckDamages")
        public void setVehicleCheckDamages(VehicleCheckDamages vehicleCheckDamages) {
            this.vehicleCheckDamages = vehicleCheckDamages;
        }

        @JsonProperty("snapshots")
        public List<Snapshot> getSnapshots() {
            return snapshots;
        }

        @JsonProperty("snapshots")
        public void setSnapshots(List<Snapshot> snapshots) {
            this.snapshots = snapshots;
        }

        @JsonProperty("totalDamagesCost")
        public TotalDamagesCost getTotalDamagesCost() {
            return totalDamagesCost;
        }

        @JsonProperty("totalDamagesCost")
        public void setTotalDamagesCost(TotalDamagesCost totalDamagesCost) {
            this.totalDamagesCost = totalDamagesCost;
        }

        @JsonProperty("damageStatusId")
        public Object getDamageStatusId() {
            return damageStatusId;
        }

        @JsonProperty("damageStatusId")
        public void setDamageStatusId(Object damageStatusId) {
            this.damageStatusId = damageStatusId;
        }

    }
