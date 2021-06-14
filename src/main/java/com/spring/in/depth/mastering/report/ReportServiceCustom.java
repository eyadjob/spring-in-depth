package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.ExtentReporter;

public interface ReportServiceCustom {

    void attachReporter(ExtentReporterCustom... reporter);
}
