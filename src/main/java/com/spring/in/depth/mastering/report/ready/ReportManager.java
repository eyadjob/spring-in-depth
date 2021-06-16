package com.spring.in.depth.mastering.report.ready;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.spring.in.depth.mastering.utility.JsonUtility;
import lombok.Data;


@Data
public class ReportManager {

    private ExtentReports report;

    public ReportManager(String reportPathAndName) {
        this.report = new ExtentReports((System.getProperty("user.dir") + reportPathAndName));

    }


    public static void main(String[] args) {
        ExtentReports reports = new ExtentReports((System.getProperty("user.dir") + "\\ExtentReportResults.html"));
        ExtentTest test = reports.startTest("Create New Customer");
        reports.endTest(test);
        test.log(LogStatus.PASS, "Test Passed");
        test.log(LogStatus.FAIL, "Test Failed");
        test.log(LogStatus.SKIP, "Test Skipped");
        test.log(LogStatus.INFO, "Test Info");
        reports.flush();
    }


    public ExtentTest createTest(String scenarioName) {
        return this.report.startTest(scenarioName);
    }

    public ExtentTest addTestStep(String scenarioName, String stepName, String stepStatus) {
        ExtentTest test = this.report.startTest(scenarioName);
        switch (stepStatus.toLowerCase()) {
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

    public void fillStep(String scenarioName, String countryName, String postPayload, String response) {
//        addTestStep("Create New customer", "<p style=\"font-weight: bold; font-size: 15px;\">" + scenarioName + " - " + countryName + "</p>" + "<p style=\"font-weight: bold;\">Post:</p><pre>" + JsonUtility.getPrettyJsonText(postPayload)+ "</pre><p style=\"font-weight: bold;\">Post(pretty):</p>" + buildJsonInPrettyFormat(postPayload) + "<br><p style=\"font-weight: bold;\">Response: </p>" + response, "Pass");
        addTestStep("Create New customer", "<p style=\"font-weight: bold; font-size: 15px;\">" + scenarioName + " - " + countryName + "</p>" + "<p style=\"font-weight: bold;\">Post:</p><pre>" + postPayload +"<p style=\"font-weight: bold;\">Response: </p>" + response, "Pass");
    }


    public String buildJsonInPrettyFormat(String jsonString) {
        String htmlPart =
                "<script>\n" +
                        " (function() {\n" +
                        "        var element = document.getElementById(\"json2\");\n" +
                        "        var obj = JSON.parse(element.innerText);\n" +
                        "        element.innerHTML = JSON.stringify(obj, undefined, 2);\n" +
                        "    })();\n" +
                        "const d = new Date();\n" +
                        "document.getElementById(\"demo\").innerHTML = d;\n" +
                        "var data =" + jsonString + ";\n" +
                        "document.getElementById(\"json\").innerHTML = JSON.stringify(data, undefined, 2);\n" +
                        "</script>\n" +
                        "<pre id=\"json\"></pre>\n"+
                        "<pre id=\"json2\">" + jsonString + "</pr>" +
        "<p id=\"demo\"></p>";


        return htmlPart;
    }
}
