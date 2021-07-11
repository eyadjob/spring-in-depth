package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.model.TestAttribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestAttributeTestContextCustom<T extends TestAttribute>
        implements Serializable {

    private static final long serialVersionUID = 2595632998970711190L;

    private T testAttribute;
    private List<TestCustom> testList = new ArrayList<>();
    private int passed = 0;
    private int failed = 0;
    private int skip = 0;
    private int others = 0;

    public TestAttributeTestContextCustom(T testAttribute) {
        this.testAttribute = testAttribute;
    }

    public void setTest(TestCustom test) {
        updateTestStatusCounts(test);
        testList.add(test);
    }

    private void updateTestStatusCounts(TestCustom test) {
        passed += test.getStatus() == StatusCustom.PASS ? 1 : 0;
        failed += test.getStatus() == StatusCustom.FAIL || test.getStatus() == StatusCustom.FATAL ? 1 : 0;
        skip += test.getStatus() == StatusCustom.SKIP ? 1 : 0;
        others += test.getStatus() != StatusCustom.PASS
                && test.getStatus() != StatusCustom.FATAL
                && test.getStatus() != StatusCustom.FAIL
                && test.getStatus() != StatusCustom.SKIP? 1 : 0;
    }

    public void refreshTestStatusCounts() {
        passed = 0;
        failed = 0;
        skip = 0;
        others = 0;
        testList.forEach(this::updateTestStatusCounts);
    }

    public List<TestCustom> getTestList() {
        return testList;
    }

    public String getName() {
        return testAttribute.getName();
    }

    public int getPassed() {
        return passed;
    }

    public int getFailed() {
        return failed;
    }

    public int getSkipped() {
        return skip;
    }

    public int getOthers() {
        return others;
    }

    public int size() {
        return testList == null ? 0 : testList.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T getAttribute() {
        return testAttribute;
    }
}
