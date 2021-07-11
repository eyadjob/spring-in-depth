package com.spring.in.depth.mastering.report.implinterface;

import com.spring.in.depth.mastering.report.implinterface.ExtentReporterCustom;

public interface ReportServiceCustom {

    void attachReporter(ExtentReporterCustom... reporter);
}
