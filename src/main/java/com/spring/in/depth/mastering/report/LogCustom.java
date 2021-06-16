package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.*;
import com.spring.in.depth.mastering.report.implinterface.RunResultCustom;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class LogCustom
        implements RunResultCustom, Serializable, BasicMongoReportElement {

    private static final long serialVersionUID = 1594512136869286425L;

    private AbstractStructureCustom<ScreenCapture> screenCaptureContext;
    private AbstractStructureCustom<Screencast> screencastContext;
    private ExtentTestCustom parent;
    private TestCustom parentModel;
    private Markup markup;
    private Date timestamp = Calendar.getInstance().getTime();
    private StatusCustom logStatus;
    private String stepName;
    private String details;
    private int sequence;
    private ObjectId objectId;
    private ExceptionInfo exceptionInfo;

    public LogCustom(TestCustom test) {
        this.parentModel = test;
    }

    public LogCustom(ExtentTestCustom test) {
        this.parent = test;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public StatusCustom getStatus() {
        return logStatus;
    }

    public void setStatus(StatusCustom logStatus) {
        this.logStatus = logStatus;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Markup getMarkup() {
        return markup;
    }

    public void setMarkup(Markup markup) {
        this.markup = markup;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setScreenCapture(ScreenCapture screenCapture) {
        if (screenCaptureContext == null) {
            screenCaptureContext = new AbstractStructureCustom<>();
        }
        screenCaptureContext.add(screenCapture);
        screenCapture.setTestObjectId(getParent().getModel().getObjectId());
    }

    public AbstractStructureCustom<ScreenCapture> getScreenCaptureContext() {
        return screenCaptureContext;
    }

    public boolean hasScreenCapture() {
        return screenCaptureContext != null
                && screenCaptureContext.size() > 0;
    }

    public void setScreencast(Screencast screencast) {
        if (screencastContext == null) {
            screencastContext = new AbstractStructureCustom<>();
        }
        screencastContext.add(screencast);
    }

    public AbstractStructureCustom<Screencast> getScreencastContext() {
        return screencastContext;
    }

    public boolean hasScreencast() {
        return screencastContext != null
                && screencastContext.size() > 0;
    }

    public ExtentTestCustom getParent() {
        return parent;
    }

    public TestCustom getParentModel() {
        return parent == null
                ? parentModel
                : parent.getModel();
    }

    @Override
    public ObjectId getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(ObjectId id) {
        objectId = id;
    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(ExceptionInfo exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    @Override
    public String toString() {
        return "[log] " +
                " {timestamp: " + getTimestamp() + "," +
                " status: " + getStatus() + "," +
                " details: " + getDetails() +
                " }";
    }

}