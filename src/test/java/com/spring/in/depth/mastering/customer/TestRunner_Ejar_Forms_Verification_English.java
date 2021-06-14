package com.spring.in.depth.mastering.customer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * this is the cucumber running initiator, which generate reports for each feature
 *
 * @author e.mubarak@iyelo.com
 */
@RunWith(JUnit4.class)

public class TestRunner_Ejar_Forms_Verification_English {

    @BeforeClass
    public static void testRunnerBeforeClass() throws IOException {
       new Customer_ApiTestScenarios().CreateCustomer();
    }

    @AfterClass
    public static void testRunnerAfterClass() throws IOException {

    }
}
