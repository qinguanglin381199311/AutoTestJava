package com.cmp.testng;


import org.testng.annotations.*;

public class BaseAnnotation {

    @Test
    public void testCase1() {
        System.out.println("这是测试Case1");
    }

    @Test
    public void testCase2() {
        System.out.println("这是测试Case2");
    }

    @BeforeMethod
    public void testMethod1() {
        System.out.println("这是提前运行的方法...");
    }

    @AfterMethod
    public void testMethod2() {
        System.out.println("这是最后运行的方法...");

    }

    @BeforeClass
    public void testBeforeClass() {
        System.out.println("这是在类运行之前的类");
    }

    @AfterClass
    public void afterBeforeClass() {
        System.out.println("这是在类运行之后的类..");
    }

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("BeforeSuite套件测试");
    }

    @AfterSuite
    public void testAfterBeforeSuite() {
        System.out.println("AfterSuite套件测试");
    }
}
