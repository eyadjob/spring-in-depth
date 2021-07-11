package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.*;
import com.aventstack.extentreports.utils.StringUtil;
import com.spring.in.depth.mastering.report.implinterface.RunResultCustom;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class ExtentTestCustom implements IAddsMedia<ExtentTestCustom>, RunResultCustom, Serializable {


    /**
     * Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
     *
     * <p>
     * The below log types will all be logged with <code>Status.PASS</code>:
     * </p>
     *
     * <pre>
     * test.log(Status.PASS, "details");
     * test.pass("details");
     * test.pass(MarkupHelper.createCodeBlock(code));
     * </pre>
     *
     * <p>
     * A few notes:
     * </p>
     *
     * <ul>
     * 	<li>Tests started with the <code>createTest</code> method are parent-level, always level 0</li>
     * 	<li>Tests started with the <code>createNode</code> method are children, always level 1 and greater</li>
     * </ul>
     */


    private static final long serialVersionUID = 9199820968410788862L;

    /**
     * An instance of {@link ExtentReports} to which this {@link ExtentTestCustom} belongs
     */
    private final transient ExtentReportsCustom extent;

    /**
     * Internal model
     */
    private final TestCustom test;

    /**
     * Creates a BDD style parent test representing one of the {@link IGherkinFormatterModel}
     * classes. This method would ideally be used for creating the parent, ie {@link Feature ).
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * extent.createTest(Feature.class, "Feature Name", "Description");
     * </pre>
     *
     * @param extent      An {@link ExtentReports} object
     * @param type        A {@link IGherkinFormatterModel} type
     * @param testName    Test name
     * @param description Test description
     */
    ExtentTestCustom(ExtentReportsCustom extent, Class<? extends IGherkinFormatterModel> type, String testName, String description) {
        if (testName == null || testName.isEmpty())
            throw new IllegalArgumentException("testName cannot be null or empty");

        this.extent = extent;

        test = new TestCustom();
        test.setName(testName.trim());
        test.setDescription(description == null ? "" : description.trim());

        if (type != null) {
            test.setBehaviorDrivenType(type);
        }
    }

    /**
     * Create a test with description
     *
     * @param extent      An {@link ExtentReports} object
     * @param testName    Test name
     * @param description Test description
     */
    public ExtentTestCustom(ExtentReportsCustom extent, String testName, String description) {
        this(extent, null, testName, description);
    }

    /**
     * Creates a BDD-style node with description representing one of the {@link IGherkinFormatterModel}
     * classes:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * test.createNode(Scenario.class, "bddNode", "description");
     * </pre>
     *
     * @param type        A {@link IGherkinFormatterModel} type
     * @param name        Name of node
     * @param description A short description
     * @return {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom createNode(Class<? extends IGherkinFormatterModel> type, String name, String description) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("nodeName cannot be null or empty");

        ExtentTestCustom t;
        if (type == null) {
            t = new ExtentTestCustom(extent, name, description);
        } else {
            t = new ExtentTestCustom(extent, type, name, description);
        }

        applyCommonNodeSettings(t);
        addNodeToReport(t);
        return t;
    }

    /**
     * Creates a node with description
     *
     * @param name        Name of node
     * @param description A short description
     * @return {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom createNode(String name, String description) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("nodeName cannot be null or empty");

        ExtentTestCustom t = new ExtentTestCustom(extent, name, description);
        applyCommonNodeSettings(t);
        addNodeToReport(t);
        return t;
    }

    /**
     * Creates a BDD-style node representing one of the {@link IGherkinFormatterModel} classes such as:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * test.createNode(Scenario.class, "bddNode");
     * </pre>
     *
     * @param type A {@link IGherkinFormatterModel} type
     * @param name Name of node
     * @return {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom createNode(Class<? extends IGherkinFormatterModel> type, String name) {
        return createNode(type, name, null);
    }

    /**
     * Creates a BDD-style node with description using name of the Gherkin model such as:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * test.createNode(new GherkinKeyword("Scenario"), "bddTest", "description");
     * </pre>
     *
     * @param gherkinKeyword Name of the {@link GherkinKeyword}
     * @param name           Name of node
     * @param description    A short description
     * @return {@link ExtentTestCustom}
     */
    public synchronized ExtentTestCustom createNode(GherkinKeywordCustom gherkinKeyword, String name, String description) {
        Class<? extends IGherkinFormatterModel> clazz = gherkinKeyword.getKeyword().getClass();
        return createNode(clazz, name, description);
    }

    /**
     * Creates a BDD-style node using name of the Gherkin model such as:
     *
     * <ul>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Feature}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Background}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Scenario}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Given}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.When}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.Then}</li>
     *  <li>{@link com.aventstack.extentreports.gherkin.model.And}</li>
     * </ul>
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * test.createNode(new GherkinKeyword("Scenario"), "bddTest");
     * </pre>
     *
     * @param gherkinKeyword Name of the {@link GherkinKeyword}
     * @param name           Name of node
     * @return {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom createNode(GherkinKeywordCustom gherkinKeyword, String name) {
        return createNode(gherkinKeyword, name, null);
    }

    /**
     * Creates a node
     *
     * @param name Name of node
     * @return {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom createNode(String name) {
        return createNode(name, null);
    }

    private void applyCommonNodeSettings(ExtentTestCustom extentTest) {
        extentTest.getModel().setLevel(test.getLevel() + 1);
        extentTest.getModel().setParent(getModel());
        test.getNodeContext().add(extentTest.getModel());
    }

    private void addNodeToReport(ExtentTestCustom extentNode) {
        extent.addNode(extentNode.getModel());
    }

    /**
     * Logs an event with {@link Status}, details and a media object: {@link Screencast} or
     * {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * test.log(Status.FAIL, "details", MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param status   {@link Status}
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom log(StatusCustom status, String details, MediaEntityModelProvider provider) {
        LogCustom evt = createLog(status, details);
        addMedia(evt, provider);
        return addLog(evt);
    }

    private synchronized void addMedia(LogCustom evt, MediaEntityModelProvider provider) {
        if (provider != null) {
            Class<? extends Media> clazz = provider.getMedia().getClass();

            if (clazz.equals(ScreenCapture.class)) {
                ScreenCapture sc = (ScreenCapture) provider.getMedia();
                evt.setScreenCapture(sc);
            } else {
                evt.setScreencast((Screencast) provider.getMedia());
            }
        }
    }

    /**
     * Logs an event with {@link Status} and details
     *
     * @param status  {@link Status}
     * @param details Details
     * @return An {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom log(StatusCustom status, String details) {
        return log(status, details, null);
    }

    /**
     * Logs an event with {@link Status} and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param status {@link Status}
     * @param markup {@link Markup}
     * @return An {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom log(StatusCustom status, Markup markup) {
        String details = markup.getMarkup();
        return log(status, details);
    }

    private synchronized ExtentTestCustom addLog(LogCustom evt) {
        test.getLogContext().add(evt);
        test.end();

        extent.addLog(test, evt);

        if (evt.hasScreenCapture()) {
            try {
                extent.addScreenCapture(evt, evt.getScreenCaptureContext().getLast());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this;
    }

    private LogCustom createLog(StatusCustom status) {
        LogCustom evt = new LogCustom(this);
        evt.setStatus(status);
        evt.setSequence(test.getLogContext().getAll().size() + 1);
        return evt;
    }

    private LogCustom createLog(StatusCustom status, String details) {
        LogCustom evt = createLog(status);
        evt.setDetails(details == null ? "" : details.trim());
        return evt;
    }

    /**
     * Logs an event with {@link Status}, an exception and a media object: {@link Screencast} or
     * {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.log(Status.FAIL, exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param status   {@link Status}
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom log(StatusCustom status, Throwable t, MediaEntityModelProvider provider) {
        ExceptionInfo exInfo = new ExceptionInfo(t);
        getModel().setExceptionInfo(exInfo);
        LogCustom evt = createLog(status);
        evt.setExceptionInfo(exInfo);
        addMedia(evt, provider);
        return addLog(evt);
    }

    /**
     * Logs an event with {@link Status} and exception
     *
     * @param status {@link Status}
     * @param t      {@link Throwable}
     * @return An {@link ExtentTestCustom} object
     */
    public synchronized ExtentTestCustom log(StatusCustom status, Throwable t) {
        return log(status, t, null);
    }

    /**
     * Logs an <code>Status.INFO</code> event with details and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * test.info("details", MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom info(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.INFO, details, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.INFO</code> with details
     *
     * @param details Details
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom info(String details) {
        return info(details, null);
    }

    /**
     * Logs an <code>Status.INFO</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.info(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom info(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.INFO, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.INFO</code> and exception
     *
     * @param t {@link Throwable}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom info(Throwable t) {
        return info(t, null);
    }

    /**
     * Logs an event with <code>Status.INFO</code> and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom info(Markup m) {
        log(StatusCustom.INFO, m);
        return this;
    }

    /**
     * Logs an <code>Status.PASS</code> event with details and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom pass(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.PASS, details, provider);
        return this;
    }

    /**
     * Logs an event <code>Status.PASS</code> with details
     *
     * @param details Details
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom pass(String details) {
        return pass(details, null);
    }

    /**
     * Logs an <code>Status.PASS</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.pass(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom pass(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.PASS, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.PASS</code> and exception
     *
     * @param t {@link Throwable}
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom pass(Throwable t) {
        return pass(t, null);
    }

    /**
     * Logs an event with <code>Status.PASS</code> and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom pass(Markup m) {
        log(StatusCustom.PASS, m);
        return this;
    }

    /**
     * Logs an <code>Status.FAIL</code> event with details and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fail(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.FAIL, details, provider);
        return this;
    }

    /**
     * Logs an event <code>Status.FAIL</code> with details
     *
     * @param details Details
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fail(String details) {
        return fail(details, null);
    }

    /**
     * Logs an <code>Status.FAIL</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.fail(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fail(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.FAIL, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.FAIL</code> and exception
     *
     * @param t {@link Throwable}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fail(Throwable t) {
        return fail(t, null);
    }

    /**
     * Logs an event with <code>Status.FAIL</code> and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fail(Markup m) {
        log(StatusCustom.FAIL, m);
        return this;
    }

    /**
     * Logs an <code>Status.DATAL</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fatal(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.FATAL, details, provider);
        return this;
    }

    /**
     * Logs an event <code>Status.FATAL</code> with details
     *
     * @param details Details
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fatal(String details) {
        log(StatusCustom.FATAL, details);
        return this;
    }

    /**
     * Logs an <code>Status.FATAL</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.fatal(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fatal(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.FATAL, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.FATAL</code> and exception
     *
     * @param t {@link Throwable}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fatal(Throwable t) {
        log(StatusCustom.FATAL, t);
        return this;
    }

    /**
     * Logs an event with <code>Status.FATAL</code> and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom fatal(Markup m) {
        log(StatusCustom.FATAL, m);
        return this;
    }

    /**
     * Logs an <code>Status.WARNING</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom warning(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.WARNING, details, provider);
        return this;
    }

    /**
     * Logs an event <code>Status.WARNING</code> with details
     *
     * @param details Details
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom warning(String details) {
        return warning(details, null);
    }

    /**
     * Logs an <code>Status.WARNING</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.warning(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom warning(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.WARNING, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.WARNING</code> and exception
     *
     * @param t {@link Throwable}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom warning(Throwable t) {
        return warning(t, null);
    }

    /**
     * Logs an event with <code>Status.WARNING</code> and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom warning(Markup m) {
        log(StatusCustom.WARNING, m);
        return this;
    }

    /**
     * Logs an <code>Status.ERROR</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom error(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.ERROR, details, provider);
        return this;
    }

    /**
     * Logs an event <code>Status.ERROR</code> with details
     *
     * @param details Details
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom error(String details) {
        return error(details, null);
    }

    /**
     * Logs an <code>Status.ERROR</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.error(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom error(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.ERROR, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.ERROR</code> and exception
     *
     * @param t {@link Throwable}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom error(Throwable t) {
        return error(t, null);
    }

    /**
     * Logs an event with <code>Status.ERROR</code> and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom error(Markup m) {
        log(StatusCustom.ERROR, m);
        return this;
    }

    /**
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom skip(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.SKIP, details, provider);
        return this;
    }

    /**
     * Logs an event <code>Status.SKIP</code> with details
     *
     * @param details Details
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom skip(String details) {
        return skip(details, null);
    }

    /**
     * Logs an <code>Status.SKIP</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.skip(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom skip(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.SKIP, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.SKIP</code> and exception
     *
     * @param t {@link Throwable}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom skip(Throwable t) {
        return skip(t, null);
    }

    /**
     * Logs an event with <code>Status.SKIP</code> and custom {@link Markup} such as:
     *
     * <ul>
     * 	<li>Code block</li>
     * 	<li>Label</li>
     * 	<li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom skip(Markup m) {
        log(StatusCustom.SKIP, m);
        return this;
    }

    /**
     * Logs an <code>Status.DEBUG</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * @param details  Details
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom debug(String details, MediaEntityModelProvider provider) {
        log(StatusCustom.DEBUG, details, provider);
        return this;
    }

    /**
     * Logs an event <code>Status.DEBUG</code> with details
     *
     * @param details Details
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom debug(String details) {
        return debug(details, null);
    }

    /**
     * Logs an <code>Status.DEBUG</code> event with an exception and a media object:
     * {@link Screencast} or {@link ScreenCapture}
     *
     * <p>
     * Example:
     * </p>
     *
     * <pre>
     * Exception exception = new NullPointerException();
     * test.debug(exception, MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
     * </pre>
     *
     * @param t        {@link Throwable}
     * @param provider A {@link MediaEntityModelProvider} object
     * @return An {@link ExtentTestCustom} object
     */
    public ExtentTestCustom debug(Throwable t, MediaEntityModelProvider provider) {
        log(StatusCustom.DEBUG, t, provider);
        return this;
    }

    /**
     * Logs an event with <code>Status.SKIP</code> and exception
     *
     * @param t {@link Throwable}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom debug(Throwable t) {
        return debug(t, null);
    }

    /**
     * Logs an event with <code>StatusCustom.DEBUG</code> and custom {@link Markup} such as:
     *
     * <ul>
     *  <li>Code block</li>
     *  <li>Label</li>
     *  <li>Table</li>
     * </ul>
     *
     * @param m {@link Markup}
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom debug(Markup m) {
        log(StatusCustom.DEBUG, m);
        return this;
    }

    /**
     * Assigns a category or group
     *
     * @param category Category name
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom assignCategory(String... category) {
        if (category == null)
            return this;

        Arrays.stream(category)
                .filter(StringUtil :: isNotNullOrEmpty)
                .forEach(c -> {
                            Category objCategory = new Category(c.replace(" ", ""));
                            test.setCategory(objCategory);
                            extent.assignCategory(test, objCategory);
                        }
                );
        return this;
    }

    /**
     * Assigns an author
     *
     * @param author Author name
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom assignAuthor(String... author) {
        Arrays.stream(author)
                .filter(StringUtil :: isNotNullOrEmpty)
                .forEach(x -> {
                            Author a = new Author(x.replace(" ", ""));
                            test.setAuthor(a);
                            extent.assignAuthor(test, a);
                        }
                );
        return this;
    }

    /**
     * Assign a device
     *
     * @param device Device name
     * @return {@link ExtentTestCustom} object
     */
    public ExtentTestCustom assignDevice(String... device) {
        Arrays.stream(device)
                .filter(StringUtil :: isNotNullOrEmpty)
                .forEach(x -> {
                            Device d = new Device(x.replace(" ", ""));
                            test.setDevice(d);
                            extent.assignDevice(test, d);
                        }
                );
        return this;
    }

    @Override
    public ExtentTestCustom addScreenCaptureFromPath(String imagePath, String title) throws IOException {
        if (imagePath == null || imagePath.isEmpty())
            throw new IllegalArgumentException("imagePath cannot be null or empty");

        ScreenCapture screenCapture = new ScreenCapture();
        screenCapture.setPath(imagePath);
        if (title != null) {
            screenCapture.setName(title);
        }
        screenCapture.setMediaType(MediaType.IMG);
        if (test.getObjectId() != null) {
            screenCapture.setTestObjectId(test.getObjectId());
        }
        extent.addScreenCapture(test, screenCapture);
        return addScreenCapture(screenCapture);
    }

    private ExtentTestCustom addScreenCapture(ScreenCapture screenCapture) {
        test.setScreenCapture(screenCapture);
        if (test.getObjectId() != null) {
            int sequence = test.getScreenCaptureList().size();
            screenCapture.setTestObjectId(test.getObjectId());
            screenCapture.setSequence(sequence);
        }
        return this;
    }

    @Override
    public ExtentTestCustom addScreenCaptureFromPath(String imagePath) throws IOException {
        return addScreenCaptureFromPath(imagePath, null);
    }

    @Override
    public ExtentTestCustom addScreenCaptureFromBase64String(String s, String title) {
        ScreenCapture screenCapture = new ScreenCapture();
        screenCapture.setBase64String(s);
        screenCapture.setName(title);
        screenCapture.setMediaType(MediaType.IMG);

        if (test.getObjectId() != null)
            screenCapture.setTestObjectId(test.getObjectId());

        try {
            extent.addScreenCapture(test, screenCapture);
        } catch (IOException e) {
        }

        return addScreenCapture(screenCapture);
    }

    @Override
    public ExtentTestCustom addScreenCaptureFromBase64String(String s) {
        return addScreenCaptureFromBase64String(s, null);
    }

    @Override
    public ExtentTestCustom addScreencastFromPath(String screencastPath) throws IOException {
        Screencast screencast = new Screencast();
        screencast.setPath(screencastPath);
        screencast.setMediaType(MediaType.VID);
        test.setScreencast(screencast);
        if (test.getObjectId() != null) {
            int sequence = test.getScreencastList().size();
            screencast.setTestObjectId(test.getObjectId());
            screencast.setSequence(sequence);
        }
        extent.addScreencast(test, screencast);
        return this;
    }

    /**
     * Provides the current run status of the test or node
     *
     * @return {@link Status}
     */
    public StatusCustom getStatus() {
        return getModel().getStatus();
    }

    /**
     * Returns the underlying test which controls the internal model
     *
     * @return {@link Test} object
     */
    public TestCustom getModel() {
        return test;
    }

    /**
     * Returns the {@link ExtentReports} instance associated with this test
     *
     * @return the {@link ExtentReports} instance associated with this test
     */
    public ExtentReportsCustom getExtent() {
        return extent;
    }

    void setUseManualConfiguration(Boolean b) {
        getModel().setUseManualConfiguration(b);
    }

}



