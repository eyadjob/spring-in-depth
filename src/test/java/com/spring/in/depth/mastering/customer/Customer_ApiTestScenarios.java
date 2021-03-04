package com.spring.in.depth.mastering.customer;



import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.spring.in.depth.mastering.MasteringApplication;
import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.AllPostApiService;
import com.spring.in.depth.mastering.test.TestScenarios;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Listeners;


//@RunWith(PowerMockRunner.class)
//@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
//@PowerMockIgnore(value = { "javax.net.ssl.*", "javax.crypto.*"})
//@ContextConfiguration(classes = {MasteringApplication.class})
////@PrepareForTest(DateFormatUtility.class)
//@Listeners(ExtentITestListenerClassAdapter.class)
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = MasteringApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
//@PropertySource("classpath:application.properties")
public class Customer_ApiTestScenarios {


    @InjectMocks
    private TestScenarios testScenarios;

    @Mock
    AllPostApiService postApiService;

    @Mock
    AllGetApiServices getApiServices;

    @Test
    public void CreateCustomer() {
        testScenarios.test("Saudi");

    }

}
