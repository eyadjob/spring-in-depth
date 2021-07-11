package com.spring.in.depth.mastering.report;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum StatusCustom implements Serializable {

    PASS,
    FAIL,
    FATAL,
    ERROR,
    WARNING,
    INFO,
    DEBUG,
    SKIP;

    private static final List<StatusCustom> statusHierarchyCustom = Arrays.asList(
            StatusCustom.FATAL,
            StatusCustom.FAIL,
            StatusCustom.ERROR,
            StatusCustom.WARNING,
            StatusCustom.SKIP,
            StatusCustom.PASS,
            StatusCustom.INFO,
            StatusCustom.DEBUG
    );

    /**
     * Returns the hierarchical list of status, in the below order:
     *
     * <ul>
     * 	<li>FATAL</li>
     * 	<li>FAIL</li>
     * 	<li>ERROR</li>
     * 	<li>WARNING</li>
     * 	<li>SKIP</li>
     * 	<li>PASS</li>
     *  <li>DEBUG</li>
     * 	<li>INFO</li>
     * </ul>
     *
     * @return Hierarchical list of status
     */
    public static List<StatusCustom> getStatusHierarchy() {
        return statusHierarchyCustom;
    }

    static void setStatusHierarchy(List<StatusCustom> statusHierarchyCustom) {
        statusHierarchyCustom = statusHierarchyCustom;
    }

    public static StatusCustom getHighestStatus(List<StatusCustom> statusList) {
        StatusCustom highestStatus = StatusCustom.PASS;
        if (statusList == null || statusList.isEmpty()) {
            return highestStatus;
        }
        for (StatusCustom status : statusList) {
            highestStatus = StatusCustom.getStatusHierarchy().indexOf(status) < StatusCustom.getStatusHierarchy().indexOf(highestStatus)
                    ? status
                    : highestStatus;
        }
        return highestStatus;
    }

    static void resetStatusHierarchy() {
        List<StatusCustom> statusHierarchy = Arrays.asList(
                StatusCustom.FATAL,
                StatusCustom.FAIL,
                StatusCustom.ERROR,
                StatusCustom.WARNING,
                StatusCustom.SKIP,
                StatusCustom.PASS,
                StatusCustom.INFO,
                StatusCustom.DEBUG
        );

        setStatusHierarchy(statusHierarchy);
    }

    @Override
    public String toString() {
        switch (this) {
            case PASS:
                return "pass";
            case FAIL:
                return "fail";
            case FATAL:
                return "fatal";
            case ERROR:
                return "error";
            case WARNING:
                return "warning";
            case INFO:
                return "info";
            case DEBUG:
                return "debug";
            case SKIP:
                return "skip";
            default:
                return "unknown";
        }
    }
}
