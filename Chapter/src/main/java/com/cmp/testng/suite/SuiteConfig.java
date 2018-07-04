package com.cmp.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void BeforSuite(){
        System.out.println("BeforSuite运行了...");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite运行了...");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest运行了");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest运行了");
    }
}
