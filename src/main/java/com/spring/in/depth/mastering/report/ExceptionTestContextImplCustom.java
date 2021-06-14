package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.model.ExceptionInfo;
import com.aventstack.extentreports.model.ExceptionTestContext;
import com.aventstack.extentreports.model.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExceptionTestContextImplCustom {
    private List<ExceptionTestContextCustom> exTestContextList;

    public ExceptionTestContextImplCustom() {
        exTestContextList = new ArrayList<>();
    }

    public void setExceptionContext(ExceptionInfo ei, TestCustom test) {
        Optional<ExceptionTestContextCustom> exOptionalTestContext = exTestContextList
                .stream()
                .filter(x -> x.getExceptionInfo().getExceptionName().equals(ei.getExceptionName()))
                .findFirst();

        if (exOptionalTestContext.isPresent()) {
            List<TestCustom> testList = exOptionalTestContext.get().getTestList();

            boolean b = testList.stream()
                    .anyMatch(t -> t.getID() == test.getID());

            if (!b) {
                exOptionalTestContext.get().setTest(test);
            }
        }
        else {
            ExceptionTestContextCustom exTestContext = new ExceptionTestContextCustom(ei);
            exTestContext.setTest(test);
            exTestContextList.add(exTestContext);
        }
    }

    public List<ExceptionTestContextCustom> getExceptionTestContextList() {
        return exTestContextList;
    }
}
