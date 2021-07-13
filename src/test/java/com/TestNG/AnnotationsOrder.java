package com.TestNG;

import org.testng.annotations.*;

public class AnnotationsOrder {

    @BeforeSuite
    public void SuiteSetup(){
        System.out.println("Suite Setup DONE");
    }

    @BeforeTest
    public void testSetup(){
        System.out.println("Test Setup DONE");
    }
    @BeforeClass
    public void classSetup(){
        System.out.println("Class Setup DONE");
    }
    @BeforeMethod
    public void methodSetup(){
        System.out.println("Method Setup DONE");
    }
    @Test
    public void TC_001(){
        System.out.println("Hello World");
    }
    @Test
    public void TC_002(){
        System.out.println("Hello Bangladesh");
    }
    @AfterMethod
    public void methodExecute(){
        System.out.println("After Method DONE");
    }

    @AfterClass
    public void classExecute(){
        System.out.println("After Class DONE");
    }
    @AfterTest
    public void testExecute(){
        System.out.println("Test DONE");
    }

    @AfterSuite
    public void suiteExecute(){
        System.out.println("Suite DONE");
    }

}
