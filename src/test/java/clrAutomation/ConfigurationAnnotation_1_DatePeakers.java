package clrAutomation;

import org.testng.annotations.*;

public class ConfigurationAnnotation_1_DatePeakers {
    @Test
    public void test1_BootStrapDatePiker(){
        System.out.println("     (5) Test Method 1: BootStrap trying");
    }

    @Test
    public void test2_JQuery(){
        System.out.println("     (5) Test Method 2: JQuery trying");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("    (4) Execute Before Each Test Methode");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("    (4) Execute After Each Test Methode \n");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("   (3) Execute Before Class: 1");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("   (3) Execute After Class: 1");
    }
}