package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BranchesComboBoxResponse {

    @JsonIgnore
    public SelectedBranch selectedBranch = new SelectedBranch();


    @JsonProperty("result")
    private Result result;
    @JsonProperty("targetUrl")
    private String targetUrl;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("error")
    private String error;
    @JsonProperty("unAuthorizedRequest")
    private Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    private Boolean abp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class Result {

        @JsonProperty("items")
        private List<Item> items = null;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static  class Item {

            @JsonProperty("isActive")
            public Boolean isActive;
            @JsonProperty("locations")
            public List<Location> locations = null;
            @JsonProperty("isAirport")
            public Boolean isAirport;
            @JsonProperty("value")
            public String value;
            @JsonProperty("displayText")
            public String displayText;
            @JsonProperty("isSelected")
            public Boolean isSelected;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class Location {

                @JsonProperty("value")
                public String value;
                @JsonProperty("displayText")
                public String displayText;
                @JsonProperty("isSelected")
                public Boolean isSelected;

            }

        }

    }

    @Data
    @NoArgsConstructor
    public static class SelectedBranch {

        public SelectedBranch(String branchName) {
            this.branchName = branchName;
            this.branchId = branchId;

        }
        @JsonIgnore
        String branchId;
        @JsonIgnore
        String branchName;

    }
}
