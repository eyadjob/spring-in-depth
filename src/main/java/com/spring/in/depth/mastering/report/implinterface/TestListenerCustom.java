package com.spring.in.depth.mastering.report.implinterface;

import com.aventstack.extentreports.model.*;
import com.spring.in.depth.mastering.report.LogCustom;
import com.spring.in.depth.mastering.report.TestCustom;

import java.io.IOException;

public interface TestListenerCustom {

    /**
     * Invoked when a test is started using <code>createTest()</code>
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     */
    void onTestStarted(TestCustom test);

    /**
     * Invoked when a test is removed using <code>removeTest()</code>
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     */
    void onTestRemoved(TestCustom test);

    /**
     * Invoked when a node is started using <code>createNode()</code>
     *
     * @param node {@link com.aventstack.extentreports.model.Test} object
     */
    void onNodeStarted(TestCustom node);

    /**
     * Invoked each time a log is added to any test/node
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     * @param log {@link com.aventstack.extentreports.model.Log} object
     */
    void onLogAdded(TestCustom test, LogCustom log);

    /**
     * Invoked each time a category is assigned to any test/node
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     * @param category {@link com.aventstack.extentreports.model.Category} object
     */
    void onCategoryAssigned(TestCustom test, Category category);

    /**
     * Invoked each time an author is assigned to any test/node
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     * @param author {@link com.aventstack.extentreports.model.Author} object
     */
    void onAuthorAssigned(TestCustom test, Author author);

    /**
     * Invoked each time a device is assigned to any test/node
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     * @param device {@link com.aventstack.extentreports.model.Device} object
     */
    void onDeviceAssigned(TestCustom test, Device device);

    /**
     * Invoked each time a screencapture is added to test
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     * @param screenCapture {@link com.aventstack.extentreports.model.ScreenCapture} object
     * @throws IOException Exception thrown if the media object is not found
     */
    void onScreenCaptureAdded(TestCustom test, ScreenCapture screenCapture) throws IOException;

    /**
     * Invoked each time a screencapture is added to log
     *
     * @param log {@link com.aventstack.extentreports.model.Log} object
     * @param screenCapture {@link com.aventstack.extentreports.model.ScreenCapture} object
     * @throws IOException Exception thrown if the media object is not found
     */
    void onScreenCaptureAdded(LogCustom log, ScreenCapture screenCapture) throws IOException;

    /**
     * Invoked each time a screencast is added
     *
     * @param test {@link com.aventstack.extentreports.model.Test} object
     * @param screencast {@link com.aventstack.extentreports.model.Screencast} object
     * @throws IOException Exception thrown if the media object is not found
     */
    void onScreencastAdded(TestCustom test, Screencast screencast) throws IOException;

}
