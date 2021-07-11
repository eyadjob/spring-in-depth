package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.model.ExceptionInfo;
import com.aventstack.extentreports.model.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExceptionTestContextCustom
        implements Serializable {

    private static final long serialVersionUID = -2516200535748363722L;

    private ExceptionInfo exceptionInfo;
    private List<TestCustom> testList = new ArrayList<>();

    public ExceptionTestContextCustom(ExceptionInfo exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public void setTest(TestCustom test) {
        testList.add(test);
    }

    public List<TestCustom> getTestList() {
        return testList;
    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }

}
