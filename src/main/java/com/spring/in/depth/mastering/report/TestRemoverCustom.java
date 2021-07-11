package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.model.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TestRemoverCustom {

    /**
     * Helper for removing test recursively. This flag determines when to break
     * out of recursion
     */
    private static boolean removed = false;

    private TestRemoverCustom() { }

    /**
     * Remove a test using its unique ID from a list
     *
     * @param testList a list of {@link Test}
     * @param test {@link Test} to be removed
     */
    public static void remove(List<TestCustom> testList, TestCustom test) {
        removed = false;
        findAndRemoveTest(testList, test);
    }

    /**
     * Recursively traverses all tests, nodes upto the last leaf to find and remove
     * the specified test
     *
     * @param list a list of {@link Test}
     * @param test {@link Test} to be removed
     */
    private static void findAndRemoveTest(List<TestCustom> list, TestCustom test) {
        List<TestCustom> filteredTestList = list
                .stream()
                .filter(x -> x.getID() == test.getID())
                .collect(Collectors.toList());

        if (filteredTestList.size() == 1) {
            removeTest(list, filteredTestList.get(0));
            removed = true;
            return;
        }

        for (TestCustom t : list) {
            if (removed) {
                return;
            }
            findAndRemoveTest(t.getNodeContext().getAll(), test);
        }
    }

    /**
     * Removes the test from a given list of tests
     *
     * @param list a list of {@link Test}
     * @param test {@link Test} to be removed
     */
    private static void removeTest(List<TestCustom> list, TestCustom test) {
        list.remove(test);
    }

}
