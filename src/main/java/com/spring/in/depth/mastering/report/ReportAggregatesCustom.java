package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Device;
import com.aventstack.extentreports.model.Test;

import java.util.Date;
import java.util.List;

public class ReportAggregatesCustom {

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public StatusCustom getStatus() {
        return StatusCustom.getHighestStatus(getStatusList());
    }

    public List<TestCustom> getTestList() {
        return testList;
    }

    public void setTestList(List<TestCustom> testList) {
        this.testList = testList;
    }

    public List<String> getTestRunnerLogs() {
        return testRunnerLogs;
    }

    public void setTestRunnerLogs(List<String> testRunnerLogs) {
        this.testRunnerLogs = testRunnerLogs;
    }

    public TestAttributeTestContextProviderCustom<Category> getCategoryContext() {
        return categoryContext;
    }

    public void setCategoryContext(TestAttributeTestContextProviderCustom<Category> categoryContext) {
        this.categoryContext = categoryContext;
    }

    public TestAttributeTestContextProviderCustom<Author> getAuthorContext() {
        return authorContext;
    }

    public void setAuthorContext(TestAttributeTestContextProviderCustom<Author> authorContext) {
        this.authorContext = authorContext;
    }

    public TestAttributeTestContextProviderCustom<Device> getDeviceContext() {
        return deviceContext;
    }

    public void setDeviceContext(TestAttributeTestContextProviderCustom<Device> deviceContext) {
        this.deviceContext = deviceContext;
    }

    public ExceptionTestContextImplCustom getExceptionContext() {
        return exceptionContext;
    }

    public void setExceptionContext(ExceptionTestContextImplCustom exceptionContext) {
        this.exceptionContext = exceptionContext;
    }

    public SystemAttributeContext getSystemAttributeContext() {
        return systemAttributeContext;
    }

    public void setSystemAttributeContext(SystemAttributeContext systemAttributeContext) {
        this.systemAttributeContext = systemAttributeContext;
    }

    public ReportStatusStatsCustom getReportStatusStats() {
        return reportStatusStats;
    }

    public void setReportStatusStats(ReportStatusStatsCustom reportStatusStats) {
        this.reportStatusStats = reportStatusStats;
    }

    public List<StatusCustom> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<StatusCustom> statusList) {
        this.statusList = statusList;
    }

}
