package com.spring.in.depth.mastering.report;


import com.aventstack.extentreports.model.TestAttribute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TestAttributeTestContextProviderCustom<T extends TestAttribute> {

    private final List<TestAttributeTestContextCustom<T>> testAttrCollection;

    public TestAttributeTestContextProviderCustom() {
        testAttrCollection = new ArrayList<>();
    }

    public void setAttributeContext(T attr, TestCustom test) {
        Optional<TestAttributeTestContextCustom<T>> testOptionalTestContext = testAttrCollection
                .stream()
                .filter(x -> x.getName().equals(attr.getName()))
                .findFirst();

        if (testOptionalTestContext.isPresent()) {
            List<TestCustom> testList = testOptionalTestContext.get().getTestList();

            boolean b = testList
                    .stream()
                    .anyMatch(t -> t.getID() == test.getID());

            if (!b) {
                testOptionalTestContext.get().setTest(test);
            }
            testOptionalTestContext.get().refreshTestStatusCounts();
        } else {
            TestAttributeTestContextCustom<T> testAttrContext = new TestAttributeTestContextCustom<>(attr);
            testAttrContext.setTest(test);
            testAttrCollection.add(testAttrContext);
        }
    }

    public void removeTest(TestCustom test) {
        Iterator<TestAttributeTestContextCustom<T>> iter = testAttrCollection.iterator();
        while (iter.hasNext()) {
            TestAttributeTestContextCustom<T> context = iter.next();
            TestRemoverCustom.remove(context.getTestList(), test);
            if (context.isEmpty()) {
                iter.remove();
            }
        }
    }

    public List<TestAttributeTestContextCustom<T>> getTestAttributeTestContextList() {
        return testAttrCollection;
    }

}
