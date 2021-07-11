package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Device;
import com.aventstack.extentreports.model.Test;

import java.util.Date;
import java.util.List;

public class ReportAggregatesBuilderCustom {

    private List<TestCustom> testList;
    private List<String> testRunnerLogs;
    private TestAttributeTestContextProviderCustom<Category> categoryContext;
    private TestAttributeTestContextProviderCustom<Author> authorContext;
    private TestAttributeTestContextProviderCustom<Device> deviceContext;
    private ExceptionTestContextImplCustom exceptionContext;
    private SystemAttributeContext systemAttributeContext;
    private ReportStatusStatsCustom reportStatusStats;
    private List<StatusCustom> statusList;
    private Date startTime;
    private Date endTime;

    public ReportAggregatesCustom build() {
        ReportAggregatesCustom aggregates = new ReportAggregatesCustom();
        aggregates.setTestList(testList);
        aggregates.setTestRunnerLogs(testRunnerLogs);
        aggregates.setCategoryContext(categoryContext);
        aggregates.setAuthorContext(authorContext);
        aggregates.setDeviceContext(deviceContext);
        aggregates.setExceptionContext(exceptionContext);
        aggregates.setSystemAttributeContext(systemAttributeContext);
        aggregates.setReportStatusStats(reportStatusStats);
        aggregates.setStatusList(statusList);
        aggregates.setStartTime(startTime);
        aggregates.setEndTime(endTime);
        return aggregates;
    }

    public ReportAggregatesBuilderCustom setTestList(List<TestCustom> testList) {
        this.testList = testList;
        return this;
    }

    public ReportAggregatesBuilderCustom setTestRunnerLogs(List<String> testRunnerLogs) {
        this.testRunnerLogs = testRunnerLogs;
        return this;
    }

    public ReportAggregatesBuilderCustom setCategoryContext(TestAttributeTestContextProviderCustom<Category> categoryContext) {
        this.categoryContext = categoryContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setAuthorContext(TestAttributeTestContextProviderCustom<Author> authorContext) {
        this.authorContext = authorContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setDeviceContext(TestAttributeTestContextProviderCustom<Device> deviceContext) {
        this.deviceContext = deviceContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setExceptionContext(ExceptionTestContextImplCustom exceptionContext) {
        this.exceptionContext = exceptionContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setSystemAttributeContext(SystemAttributeContext systemAttributeContext) {
        this.systemAttributeContext = systemAttributeContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setReportStatusStats(ReportStatusStatsCustom reportStatusStats) {
        this.reportStatusStats = reportStatusStats;
        return this;
    }

    public ReportAggregatesBuilderCustom setStatusList(List<StatusCustom> statusList) {
        this.statusList = statusList;
        return this;
    }

    public ReportAggregatesBuilderCustom setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public ReportAggregatesBuilderCustom setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

}
