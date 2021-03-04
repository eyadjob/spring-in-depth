package com.spring.in.depth.mastering.customer;



import com.spring.in.depth.mastering.MasteringApplication;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@PowerMockIgnore(value = {"javax.management.*", "javax.net.ssl.*", "javax.crypto.*"})
@ContextConfiguration(classes = {MasteringApplication.class})
//@PrepareForTest(DateFormatUtility.class)
public class Customer_ApiTest {



}
