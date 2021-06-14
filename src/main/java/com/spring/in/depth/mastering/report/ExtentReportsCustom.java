package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.gherkin.GherkinDialectProvider;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.model.SystemAttribute;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class ExtentReportsCustom extends ExtentObservableCustom {

    /**
     * Attach a {@link ExtentReporter} reporter, allowing it to access all started tests, nodes and logs
     *
     * <p>
     * Available reporter types are:
     * </p>
     *
     * <ul>
     *  <li>ExtentHtmlReporter provided by artifactId "extent-html-formatter"</li>
     *  <li>ExtentEmailReporter (pro-only) provided by artifactId "extent-email-formatter"</li>
     *  <li>KlovReporter provided by artifactId "extent-klov-reporter"</li>
     *  <li>ConsoleLogger</li>
     * </ul>
     *
     * @param reporter {@link ExtentReporter} reporter
     */
    public void attachReporter(ExtentReporterCustom... reporter) {
        Arrays.stream(reporter).forEach(this :: register);
    }

    /**
     * Returns a list of started reporters
     *
     * @return A list of {@link ExtentReporter}
     */
    public List<ExtentReporterCustom> getStartedReporters() {
        return getReporterCollection();
    }

    /**
     * Creates a BDD-style test with description representing one of the {@link IGherkinFormatterModel}
     * classes such as:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.But}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * extent.createTest(Feature.class, "feature", "description");
     * extent.createTest(Scenario.class, "scenario", "description");
     * extent.createTest(Given.class, "given", "description");
     * </pre>
     *
     * @param type        A {@link IGherkinFormatterModel} type
     * @param testName    Name of test
     * @param description A short description of the test
     * @return {@link ExtentTest} object
     */
    public synchronized ExtentTestCustom createTest(Class<? extends IGherkinFormatterModel> type, String testName, String description) {
        ExtentTestCustom t = new ExtentTestCustom(this, type, testName, description);
        applyCommonTestSettings(t);

        saveTest(t.getModel());

        return t;
    }

    /**
     * Creates a BDD-style test representing one of the {@link IGherkinFormatterModel} classes such as:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.But}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * extent.createTest(Feature.class, "feature");
     * extent.createTest(Scenario.class, "scenario");
     * extent.createTest(Given.class, "given");
     * </pre>
     *
     * @param type     A {@link IGherkinFormatterModel} type
     * @param testName Name of test
     * @return {@link ExtentTest} object
     */
    public synchronized ExtentTestCustom createTest(Class<? extends IGherkinFormatterModel> type, String testName) {
        return createTest(type, testName, null);
    }

    /**
     * Creates a BDD-style test with description using name of the Gherkin model such as:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.But}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * extent.createTest(new GherkinKeyword("Feature"), "feature", "description");
     * extent.createTest(new GherkinKeyword("Scenario"), "scenario", "description");
     * extent.createTest(new GherkinKeyword("Given"), "given", "description");
     * </pre>
     *
     * @param gherkinKeyword Name of the {@link GherkinKeyword}
     * @param testName       Name of test
     * @param description    A short description of the test
     * @return {@link ExtentTest} object
     */
    public synchronized ExtentTestCustom createTest(GherkinKeywordCustom gherkinKeyword, String testName, String description) {
        Class<? extends IGherkinFormatterModel> clazz = gherkinKeyword.getKeyword().getClass();
        return createTest(clazz, testName, description);
    }

    /**
     * Creates a BDD-style test using name of the Gherkin model such as:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.But}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * extent.createTest(new GherkinKeyword("Feature"), "feature");
     * extent.createTest(new GherkinKeyword("Scenario"), "scenario");
     * extent.createTest(new GherkinKeyword("Given"), "given");
     * </pre>
     *
     * @param gherkinKeyword Name of the {@link GherkinKeyword}
     * @param testName       Name of test
     * @return {@link ExtentTest} object
     */
    public synchronized ExtentTestCustom createTest(GherkinKeywordCustom gherkinKeyword, String testName) {
        return createTest(gherkinKeyword, testName, null);
    }

    /**
     * Creates a test with description
     *
     * @param testName    Name of test
     * @param description A short test description
     * @return {@link ExtentTest} object
     */
    public synchronized ExtentTestCustom createTest(String testName, String description) {
        ExtentTestCustom t = new ExtentTestCustom(this, testName, description);
        applyCommonTestSettings(t);

        saveTest(t.getModel());

        return t;
    }

    /**
     * Creates a test
     *
     * @param testName Name of test
     * @return {@link ExtentTest} object
     */
    public synchronized ExtentTestCustom createTest(String testName) {
        return createTest(testName, null);
    }

    private synchronized void applyCommonTestSettings(ExtentTestCustom extentTest) {
        extentTest.setUseManualConfiguration(getAllowManualConfig());
    }

    /**
     * Removes a test
     *
     * @param test {@link ExtentTest} object
     */
    public synchronized void removeTest(ExtentTestCustom test) {
        super.removeTest(test.getModel());
    }

    /**
     * Writes test information from the started reporters to their output view
     *
     * <ul>
     *  <li>extent-html-formatter: flush output to HTML file</li>
     *  <li>extent-klov-reporter: updates MongoDB collections</li>
     *  <li>extent-email-formatter (pro-only): creates or appends to an HTML file</li>
     *  <li>ConsoleLogger: no action taken</li>
     * </ul>
     */
    @Override
    public synchronized void flush() {
        super.flush();
    }

    /**
     * Adds any applicable system information to all started reporters
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * extent.setSystemInfo("HostName", "AventStack-PC");
     * </pre>
     *
     * @param k Name of system variable
     * @param v Value of system variable
     */
    public void setSystemInfo(String k, String v) {
        SystemAttribute sa = new SystemAttribute(k, v);
        super.setSystemInfo(sa);
    }

    /**
     * Adds logs from test framework tools to the test-runner logs view (if available in the reporter)
     *
     * <p>
     * TestNG usage example:
     * </p>
     *
     * <pre>
     * extent.setTestRunnerOutput(Reporter.getOutput());
     * </pre>
     *
     * @param log Log string from the test runner frameworks such as TestNG or JUnit
     */
    public void setTestRunnerOutput(List<String> log) {
        log.forEach(this :: setTestRunnerLogs);
    }

    /**
     * Adds logs from test framework tools to the test-runner logs view (if available in the reporter)
     *
     * <p>
     * TestNG usage example:
     * </p>
     *
     * <pre>
     * for (String s : Reporter.getOutput()) {
     *   extent.setTestRunnerOutput(s);
     * }
     * </pre>
     *
     * @param log Log string from the test runner frameworks such as TestNG or JUnit
     */
    public void setTestRunnerOutput(String log) {
        setTestRunnerLogs(log);
    }

    /**
     * Use this setting when building post-execution reports, such as from TestNG IReporter.
     * This setting allows setting test with your own time-stamps. With this enabled, Extent
     * does not use time-stamps for tests at the time they were created.
     *
     * <p>
     * If this setting is enabled and time-stamps are not specified explicitly, the time-stamps
     * of test creation are used.
     *
     * @param useManualConfig Set to true if building reports at the end of execution with manual configuration
     */
    public void setReportUsesManualConfiguration(boolean useManualConfig) {
        setAllowManualConfig(useManualConfig);
    }

    /**
     * Type of AnalysisStrategy for the reporter. Not all reporters support this setting.
     *
     * <p>
     * There are 2 types of strategies available:
     *
     * <ul>
     *  <li>TEST: Shows analysis at the test and step level</li>
     *  <li>SUITE: Shows analysis at the suite, test and step level</li>
     * </ul>
     *
     * @param strategy {@link AnalysisStrategy} determines the type of analysis (dashboard)
     *                 created for the reporter. Not all reporters will support this setting.
     */
    @Override
    public void setAnalysisStrategy(AnalysisStrategyCustom strategy) {
        super.setAnalysisStrategy(strategy);
    }

    /**
     * Provides common report configurations
     *
     * @return an instance of {@link ReportConfigurator}
     */
    public ReportConfigurator config() {
        return ReportConfigurator.getInstance();
    }

    /**
     * Allows setting the target language for Gherkin keywords.
     *
     * <p>
     * Default setting is "en"
     *
     * @param language A valid dialect from
     *                 <a href="https://github.com/cucumber/cucumber/blob/master/gherkin/gherkin-languages.json">gherkin-languages.json</a>
     * @throws UnsupportedEncodingException Thrown if the language is one of the supported language from
     *                                      <a href="https://github.com/cucumber/cucumber/blob/master/gherkin/gherkin-languages.json">gherkin-languages.json</a>
     */
    public void setGherkinDialect(String language) throws UnsupportedEncodingException {
        GherkinDialectProvider.setLanguage(language);
    }

    /**
     * Returns an instance of {@link ReportStatusStats} with counts of tests executed
     * by their status (pass, fail, skip etc)
     *
     * @return an instance of {@link ReportStatusStats}
     */
    @Override
    public ReportStatusStatsCustom getStats() {
        return super.getStats();
    }

}
