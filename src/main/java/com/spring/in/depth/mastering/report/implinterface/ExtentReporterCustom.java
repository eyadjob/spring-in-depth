package com.spring.in.depth.mastering.report.implinterface;

import com.aventstack.extentreports.ReportAggregates;
import com.spring.in.depth.mastering.report.ReportAggregatesCustom;

public interface ExtentReporterCustom
        extends TestListenerCustom, AnalysisStrategyServiceCustom {

    /**
     * Starts passing run information to the reporter
     */
    void start();

    /**
     * Stops the reporter. Ensures no information is passed to the reporter.
     */
    void stop();

    /**
     * Write to or update the target source (file, database)
     *
     * @param reportAggregates a {@link ReportAggregates} object
     */
    void flush(ReportAggregatesCustom reportAggregates);

    /**
     * Get the reporter name
     *
     * @return reporter name
     */
    String getReporterName();
}
