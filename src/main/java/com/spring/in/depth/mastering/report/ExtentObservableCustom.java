package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.*;
import com.aventstack.extentreports.reporter.BasicFileReporter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ExtentObservableCustom implements ReportServiceCustom {

    /**
     * The current AnalysisStrategy for the run session. This decides the technique used
     * to count the test status at differing levels. For example, for a BDD style report,
     * the levels to be calculated are Feature, Scenario and Step (3 levels). For a generic,
     * non-BDD style report, levels can be dynamic. For a non-BDD style report, levels typically
     * consist of:
     *
     * <p>
     * 1 level: Test<br>
     * Test<br>
     * - Event
     *
     * <p>
     * 2 levels: Test & node<br>
     * Test<br>- Node<br>-- Event
     *
     * <p>
     * 2 levels: Test, the leaf-node<br>
     * Test<br>- Node<br>-- Leaf Node<br>--- Event
     */
    private AnalysisStrategyCustom strategy = AnalysisStrategyCustom.TEST;

    /**
     * Use this setting when building post-execution reports, such as from TestNG IReporter.
     * This setting allows setting test with your own variables and prevent update by Extent.
     * As of today, with this enabled, Extent does not use time-stamps for tests at the time
     * they were created
     */
    private boolean usesManualConfiguration = false;

    /**
     * The status of the entire report or build
     */
    private StatusCustom reportStatus = StatusCustom.PASS;

    /**
     * Time the report or build was started
     */
    private Date reportStartDate = Calendar.getInstance().getTime();

    /**
     * Time the report or build ended. This value is updated everytime <code>flush</code>
     * is called
     */
    private Date reportEndDate;

    /**
     * A collection of tests arranged by category
     */
    private final TestAttributeTestContextProviderCustom<Category> categoryContext = new TestAttributeTestContextProviderCustom<>();

    /**
     * A collection of tests arranged by author
     */
    private final TestAttributeTestContextProviderCustom<Author> authorContext = new TestAttributeTestContextProviderCustom<>();

    /**
     * A collection of tests arranged by author
     */
    private final TestAttributeTestContextProviderCustom<Device> deviceContext = new TestAttributeTestContextProviderCustom<>();


    /**
     * A collection of tests arranged by exception
     */
    private final ExceptionTestContextImplCustom exceptionContextBuilder = new ExceptionTestContextImplCustom();

    /**
     * A context of all system or environment variables
     */
    private final SystemAttributeContext systemAttributeContext = new SystemAttributeContext();

    /**
     * A list of all {@link ExtentReporter} reporters started by the <code>attachReporter</code>
     * method
     */
    private final List<ExtentReporterCustom> reporterList = new ArrayList<>();

    /**
     * Any logs added by to the test runner can be added to Extent
     *
     * <p>
     * TestNG Example:
     *
     * <p>
     * Setting logs with TestNG:
     *
     * <pre>Reporter.log("hello world")</pre>
     *
     * <p>
     * Informing Extent of any logs added:
     * <pre>
     * for (String s : Reporter.getOutput()) {
     *       extent.setTestRunnerOutput(s);
     * }
     * </pre>
     */
    private final List<String> testRunnerLogs = new ArrayList<>();

    /**
     * A list of all tests created
     */
    private final List<TestCustom> testList = new ArrayList<>();

    /**
     * Instance of {@link ReportStatusStats}
     */
    private ReportStatusStatsCustom stats = new ReportStatusStatsCustom(strategy);

    /**
     * A unique list of status tests are marked with
     *
     * <p>
     * Consider a report having 10 tests:
     *
     * <ol>
     * 	<li>Test1: PASS</li>
     * 	<li>Test2: PASS</li>
     * 	<li>Test3: PASS</li>
     * 	<li>Test4: SKIP</li>
     * 	<li>Test5: SKIP</li>
     * 	<li>Test6: FAIL</li>
     * 	<li>Test7: PASS</li>
     * 	<li>Test8: PASS</li>
     * 	<li>Test9: FAIL</li>
     * 	<li>Test10: PASS</li>
     * </ol>
     *
     * <p>
     * Distinct list of contained status:
     *
     * <ol>
     * <li>PASS</li>
     * <li>SKIP</li>
     * <li>FAIL</li>
     * </ol>
     */
    private final List<StatusCustom> statusList = new ArrayList<>();

    /**
     * Contains status as keys, which are translated over to <code>statusList</code>
     */
    private final Map<StatusCustom, Boolean> statusMap = new EnumMap<>(StatusCustom.class);

    protected ExtentObservableCustom() {
    }

    /**
     * Subscribe the reporter to receive updates when making calls to the API
     *
     * @param reporter {@link ExtentReporter} reporter
     */
    protected void register(ExtentReporterCustom reporter) {
        reporterList.add(reporter);
        reporter.start();
    }

    /**
     * Unsubscribe the reporter. Calling unsubscribe will call the <code>stop</code> method
     * and also remove the reporter from the list of started reporters
     *
     * @param reporter {@link ExtentReporter} reporter to unsubscribe
     */
    protected void deregister(ExtentReporter reporter) {
        reporter.stop();
        reporterList.remove(reporter);
    }

    /**
     * Retrieve a list of all started reporters
     *
     * @return a list of {@link ExtentReporter} objects
     */
    protected List<ExtentReporterCustom> getReporterCollection() {
        return reporterList;
    }

    /**
     * Saves the started test and notifies all started reporters
     *
     * @param test a {@link Test} object
     */
    protected synchronized void saveTest(TestCustom test) {
        testList.add(test);
        reporterList.forEach(x -> x.onTestStarted(test));
    }

    /**
     * Removes the test and notifies all started reporters
     *
     * @param test a {@link Test} object
     */
    protected synchronized void removeTest(TestCustom test) {
        removeTestTestList(test);
        removeTestTestAttributeContext(test);
        reporterList.forEach(x -> x.onTestRemoved(test));
    }

    /**
     * Removes a test from test list
     *
     * @param test a {@link Test} object
     */
    private void removeTestTestList(TestCustom test) {
        TestRemoverCustom.remove(testList, test);
        refreshReportEntities();
    }

    /**
     * Removes test from test list of each context
     *
     * @param test a {@link Test} object
     */
    private void removeTestTestAttributeContext(TestCustom test) {
        if (test.hasCategory()) {
            categoryContext.removeTest(test);
        }
        if (test.hasAuthor()) {
            authorContext.removeTest(test);
        }
        if (test.hasDevice()) {
            deviceContext.removeTest(test);
        }
    }

    /**
     * Refreshes report entities such as {@link ReportStatusStats} and list of distinct {@link Status}
     */
    private void refreshReportEntities() {
        refreshReportStats();
        refreshStatusList();
    }

    /**
     * Refresh and notify all reports of {@link ReportStatusStats}
     */
    private void refreshReportStats() {
        stats.refresh(testList);
    }

    /**
     * Refresh and notify all reports of distinct status assigned to tests
     */
    private void refreshStatusList() {
        statusMap.clear();
        statusList.clear();
        refreshStatusList(testList);
        statusMap.forEach((k, v) -> statusList.add(k));
    }

    /**
     * Refreshes distinct status list
     *
     * @param list a list of started {@link Test}
     */
    private void refreshStatusList(List<TestCustom> list) {
        if (list == null || list.isEmpty())
            return;

        list.stream()
                .map(TestCustom :: getStatus)
                .distinct()
                .collect(Collectors.toList())
                .forEach(x -> statusMap.put(x, false));

        list.forEach(x -> refreshStatusList(x.getNodeContext().getAll()));
    }

    /**
     * Notify reporters of the added node
     *
     * @param node a {@link Test} node
     */
    synchronized void addNode(TestCustom node) {
        reporterList.forEach(x -> x.onNodeStarted(node));
    }

    /**
     * Notifies reporters with information of added {@link Log}
     *
     * @param test {@link Test} to which the event is added
     * @param log  {@link Log}
     */
    synchronized void addLog(TestCustom test, LogCustom log) {
        collectRunInfo();
        reporterList.forEach(x -> x.onLogAdded(test, log));
    }

    /**
     * Notifies reporters with information of added {@link Category}
     *
     * @param test     {@link Test} to which the Category is added
     * @param category {@link Category}
     */
    synchronized void assignCategory(TestCustom test, Category category) {
        reporterList.forEach(x -> x.onCategoryAssigned(test, category));
    }

    /**
     * Notifies reporters with information of added {@link Author}
     *
     * @param test   {@link Test} to which the Author is added
     * @param author {@link Author}
     */
    synchronized void assignAuthor(TestCustom test, Author author) {
        reporterList.forEach(x -> x.onAuthorAssigned(test, author));
    }

    /**
     * Notifies reporters with information of added {@link Author}
     *
     * @param test   {@link Test} to which the Device is added
     * @param device {@link Device}
     */
    synchronized void assignDevice(TestCustom test, Device device) {
        reporterList.forEach(x -> x.onDeviceAssigned(test, device));
    }

    /**
     * Notifies reporters with information of added {@link ScreenCapture}
     *
     * @param test          {@link Test} to which the ScreenCapture is added
     * @param screenCapture {@link ScreenCapture}
     * @throws IOException thrown if the {@link ScreenCapture} is not found
     */
    synchronized void addScreenCapture(TestCustom test, ScreenCapture screenCapture) throws IOException {
        for (ExtentReporterCustom r : reporterList) {
            r.onScreenCaptureAdded(test, screenCapture);
        }
    }

    /**
     * Notifies reporters with information of added {@link ScreenCapture}
     *
     * @param screenCapture {@link ScreenCapture}
     * @throws IOException thrown if the {@link ScreenCapture} is not found
     */
    synchronized void addScreenCapture(LogCustom log, ScreenCapture screenCapture) throws IOException {
        for (ExtentReporterCustom r : reporterList) {
            r.onScreenCaptureAdded(log, screenCapture);
        }
    }

    /**
     * Notifies reporters with information of added {@link Screencast}
     *
     * @param test       {@link Test} to which the ScreenCast is added
     * @param screencast {@link Screencast}
     * @throws IOException thrown if the {@link Screencast} is not found
     */
    synchronized void addScreencast(TestCustom test, Screencast screencast) throws IOException {
        for (ExtentReporterCustom r : reporterList) {
            r.onScreencastAdded(test, screencast);
        }
    }

    /**
     * Returns the context of author with the list of tests for each
     *
     * @return a {@link TestAttributeTestContextProvider} object
     */
    protected TestAttributeTestContextProviderCustom<Author> getAuthorContextInfo() {
        return authorContext;
    }

    /**
     * Updates the status of the report or build
     *
     * @param status a {@link Status}
     */
    private void updateReportStatus(StatusCustom status) {
        int statusIndex = StatusCustom.getStatusHierarchy().indexOf(status);
        int reportStatusIndex = StatusCustom.getStatusHierarchy().indexOf(reportStatus);

        reportStatus = statusIndex < reportStatusIndex
                ? status
                : reportStatus;
    }

    /**
     * Ends the test
     *
     * @param test a {@link Test} object
     */
    private void endTest(TestCustom test) {
        test.end();
        updateReportStatus(test.getStatus());
    }

    /**
     * Collects and updates all run information and notifies all reporters. Depending upon the
     * type of reporter, additional events can occur such as:
     *
     * <ul>
     * 	<li>A file written to disk (eg. case of {@link BasicFileReporter}</li>
     * 	<li>A database being updated (eg. case of KlovReporter)</li>
     * </ul>
     */
    protected synchronized void flush() {
        collectRunInfo();
        notifyReporters();
    }

    /**
     * Collects run information from all tests for assigned {@link Category}, {@link Author},
     * Exception, Nodes. This also ends and updates all internal test information and
     * refreshes {@link ReportStatusStats} and the distinct list of {@link Status}
     */
    private synchronized void collectRunInfo() {
        if (testList == null || testList.isEmpty())
            return;

        reportEndDate = Calendar.getInstance().getTime();

        refreshReportEntities();

        for (TestCustom test : testList) {
            endTest(test);
            test.setUseManualConfiguration(getAllowManualConfig());
            if (test.hasCategory()) {
                test.getCategoryContext().getAll()
                        .forEach(x -> categoryContext.setAttributeContext((Category) x, test));
            }
            if (test.hasAuthor()) {
                test.getAuthorContext().getAll()
                        .forEach(x -> authorContext.setAttributeContext((Author) x, test));
            }
            if (test.hasDevice()) {
                test.getDeviceContext().getAll()
                        .forEach(x -> deviceContext.setAttributeContext((Device) x, test));
            }
            if (test.hasException()) {
                test.getExceptionInfoList()
                        .forEach(x -> exceptionContextBuilder.setExceptionContext(x, test));
            }
            if (test.hasChildren()) {
                for (TestCustom node : test.getNodeContext().getAll()) {
                    copyNodeAttributeAndRunTimeInfoToAttributeContexts(node);
                    node.setUseManualConfiguration(getAllowManualConfig());
                }
            }
        }

        updateReportStartTimeForManualConfigurationSetting();
    }

    /**
     * In case where manual configuration is used, calculate the correct timestamps based upon
     * the timestamps assigned to tests
     */
    private void updateReportStartTimeForManualConfigurationSetting() {
        if (getAllowManualConfig() && !testList.isEmpty()) {
            Date minDate = testList.stream()
                    .map(t -> t.getStartTime())
                    .min(Date :: compareTo)
                    .get();
            Date maxDate = testList.stream()
                    .map(t -> t.getEndTime())
                    .max(Date :: compareTo)
                    .get();
            reportStartDate = reportStartDate.getTime() > minDate.getTime() ? minDate : reportStartDate;
            reportEndDate = reportEndDate.getTime() < maxDate.getTime() ? maxDate : reportEndDate;
        }
    }

    /**
     * Traverse all nodes and refresh {@link Category}, {@link Author}, Exception and Node context
     * information
     *
     * @param node a {@link Test} node
     */
    private void copyNodeAttributeAndRunTimeInfoToAttributeContexts(TestCustom node) {
        if (node.hasCategory()) {
            node.getCategoryContext().getAll()
                    .forEach(x -> categoryContext.setAttributeContext((Category) x, node));
        }
        if (node.hasAuthor()) {
            node.getAuthorContext().getAll()
                    .forEach(x -> authorContext.setAttributeContext((Author) x, node));
        }
        if (node.hasDevice()) {
            node.getDeviceContext().getAll()
                    .forEach(x -> deviceContext.setAttributeContext((Device) x, node));
        }
        if (node.hasException()) {
            node.getExceptionInfoList()
                    .forEach(x -> exceptionContextBuilder.setExceptionContext(x, node));
        }
        if (node.hasChildren()) {
            node.getNodeContext().getAll()
                    .forEach(this :: copyNodeAttributeAndRunTimeInfoToAttributeContexts);
        }
    }

    /**
     * Notify all reporters with complete run information
     */
    private synchronized void notifyReporters() {
        if (!testList.isEmpty() && testList.get(0).isBehaviorDrivenType()) {
            strategy = AnalysisStrategyCustom.BDD;
        }
        ReportAggregatesCustom reportAggregates = new ReportAggregatesCustom()
                .setAuthorContext(authorContext)
                .setCategoryContext(categoryContext)
                .setDeviceContext(deviceContext)
                .setExceptionContext(exceptionContextBuilder)
                .setReportStatusStats(stats)
                .setStatusList(statusList)
                .setSystemAttributeContext(systemAttributeContext)
                .setTestList(testList)
                .setTestRunnerLogs(testRunnerLogs)
                .setStartTime(reportStartDate)
                .setEndTime(reportEndDate)
                .build();
        reporterList.forEach(x -> x.setAnalysisStrategy(strategy));
        reporterList.forEach(x -> x.flush(reportAggregates));
    }

    /**
     * Ends logging, stops and clears the list of reporters
     */
    protected void end() {
        flush();
        reporterList.forEach(ExtentReporterCustom :: stop);
        reporterList.clear();
    }

    /**
     * Add a system attribute
     *
     * @param sa a {@link SystemAttribute} object
     */
    protected void setSystemInfo(SystemAttribute sa) {
        systemAttributeContext.setSystemAttribute(sa);
    }

    /**
     * Add a test runner log
     *
     * @param log a log event
     */
    protected void setTestRunnerLogs(String log) {
        testRunnerLogs.add(log);
    }

    /**
     * Updates the {@link AnalysisStrategy}
     *
     * @param strategy a {@link AnalysisStrategy} object
     */
    protected void setAnalysisStrategy(AnalysisStrategyCustom strategy) {
        this.strategy = strategy;
        stats = new ReportStatusStatsCustom(strategy);
    }

    /**
     * Returns the current value of using manual configuration for test time-stamps
     *
     * @return setting for manual configuration
     */
    protected boolean getAllowManualConfig() {
        return usesManualConfiguration;
    }

    /**
     * Setting to allow user driven configuration for test time-stamps
     *
     * @param useManualConfig setting for manual configuration
     */
    protected void setAllowManualConfig(boolean useManualConfig) {
        this.usesManualConfiguration = useManualConfig;
    }

    /**
     * Return the {@link ReportStatusStats} object
     *
     * @return a {@link ReportStatusStats} object
     */
    protected ReportStatusStatsCustom getStats() {
        return stats;
    }

}
