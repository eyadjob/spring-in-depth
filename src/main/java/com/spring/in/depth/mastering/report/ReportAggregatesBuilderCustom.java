package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Device;
import com.aventstack.extentreports.model.Test;

import java.util.Date;
import java.util.List;

public class ReportAggregatesBuilderCustom {

    private List<Test> testList;
    private List<String> testRunnerLogs;
    private TestAttributeTestContextProvider<Category> categoryContext;
    private TestAttributeTestContextProvider<Author> authorContext;
    private TestAttributeTestContextProvider<Device> deviceContext;
    private ExceptionTestContextImpl exceptionContext;
    private SystemAttributeContext systemAttributeContext;
    private ReportStatusStats reportStatusStats;
    private List<Status> statusList;
    private Date startTime;
    private Date endTime;

    public ReportAggregatesBuilderCustom build() {
        ReportAggregatesBuilderCustom aggregates = new ReportAggregatesBuilderCustom();
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

    public ReportAggregatesBuilderCustom setTestList(List<Test> testList) {
        this.testList = testList;
        return this;
    }

    public ReportAggregatesBuilderCustom setTestRunnerLogs(List<String> testRunnerLogs) {
        this.testRunnerLogs = testRunnerLogs;
        return this;
    }

    public ReportAggregatesBuilderCustom setCategoryContext(TestAttributeTestContextProvider<Category> categoryContext) {
        this.categoryContext = categoryContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setAuthorContext(TestAttributeTestContextProvider<Author> authorContext) {
        this.authorContext = authorContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setDeviceContext(TestAttributeTestContextProvider<Device> deviceContext) {
        this.deviceContext = deviceContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setExceptionContext(ExceptionTestContextImpl exceptionContext) {
        this.exceptionContext = exceptionContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setSystemAttributeContext(SystemAttributeContext systemAttributeContext) {
        this.systemAttributeContext = systemAttributeContext;
        return this;
    }

    public ReportAggregatesBuilderCustom setReportStatusStats(ReportStatusStats reportStatusStats) {
        this.reportStatusStats = reportStatusStats;
        return this;
    }

    public ReportAggregatesBuilderCustom setStatusList(List<Status> statusList) {
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
