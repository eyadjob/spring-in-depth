package com.spring.in.depth.mastering.pojo;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportManager {


    public static void main(String[] args) {
        ExtentReports reports = new ExtentReports((System.getProperty("user.dir") + "\\ExtentReportResults.html"));
        ExtentTest test = reports.startTest("TestName");
        reports.endTest(test);
        test.log(LogStatus.PASS, "Test Passed");
        test.log(LogStatus.FAIL, "Test Failed");
        test.log(LogStatus.SKIP, "Test Skipped");
        test.log(LogStatus.INFO, "Test Info");
        reports.flush();
    }


    public ExtentReports createReport(String reportName) {
        ExtentReports reports = new ExtentReports((System.getProperty("user.dir") + "\\ApisReports\\" + reportName));
        return reports;

    }

    public ExtentTest createTest(ExtentReports reports, String scenarioName) {
        return reports.startTest(scenarioName);
    }

    public ExtentTest addTestStep(ExtentTest test, String stepName, String stepStatus) {
        switch (stepStatus) {
            case "pass":
                test.log(LogStatus.PASS, stepName);
                break;
            case "fail":
                test.log(LogStatus.FAIL, stepName);
                break;
            case "skip":
                test.log(LogStatus.SKIP, stepName);
                break;
            case "info":
                test.log(LogStatus.INFO, stepName);
                break;

        }
        return test;
    }
}
