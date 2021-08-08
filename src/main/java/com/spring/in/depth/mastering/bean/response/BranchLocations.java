package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BranchLocations {

    @JsonProperty("result")
    public Result result;
    @JsonProperty("targetUrl")
    public Object targetUrl;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("error")
    public Object error;
    @JsonProperty("unAuthorizedRequest")
    public Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    public Boolean abp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class Result {

        @JsonProperty("isAirport")
        public Boolean isAirport;
        @JsonProperty("locations")
        public List<Location> locations = null;
        @JsonProperty("name")
        public String name;
        @JsonProperty("code")
        public String code;
        @JsonProperty("isActive")
        public Boolean isActive;
        @JsonProperty("addressInformation")
        public AddressInformation addressInformation;
        @JsonProperty("contactInformation")
        public ContactInformation contactInformation;
        @JsonProperty("guid")
        public String guid;
        @JsonProperty("discriminator")
        public String discriminator;
        @JsonProperty("lastModificationTime")
        public String lastModificationTime;
        @JsonProperty("lastModifierUserId")
        public Integer lastModifierUserId;
        @JsonProperty("creationTime")
        public String creationTime;
        @JsonProperty("creatorUserId")
        public Integer creatorUserId;
        @JsonProperty("id")
        public Integer id;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class ContactInformation {

            @JsonProperty("phone")
            public Object phone;
            @JsonProperty("mobile")
            public Object mobile;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class Location {

            @JsonProperty("id")
            public Integer id;
            @JsonProperty("guid")
            public String guid;
            @JsonProperty("name")
            public String name;
            @JsonProperty("isActive")
            public Boolean isActive;
            @JsonProperty("addressInformation")
            public AddressInformation addressInformation;
            @JsonProperty("contactInformation")
            public ContactInformation contactInformation;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class ContactInformation {

                @JsonProperty("phone")
                public Object phone;
                @JsonProperty("mobile")
                public Object mobile;

            }

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class AddressInformation {

            @JsonProperty("address")
            public Object address;
            @JsonProperty("cityId")
            public Integer cityId;
            @JsonProperty("geoLocation")
            public GeoLocation geoLocation;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class GeoLocation {

                @JsonProperty("longitude")
                public Float longitude;
                @JsonProperty("latitude")
                public Float latitude;


            }

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class ContactInformation {

                @JsonProperty("phone")
                public Object phone;
                @JsonProperty("mobile")
                public Object mobile;

            }
        }

    }
}
