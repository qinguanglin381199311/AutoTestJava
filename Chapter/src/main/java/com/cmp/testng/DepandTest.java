package com.cmp.testng;

import org.testng.annotations.Test;

public class DepandTest {

    /**
     * 依赖测试
     * 2018-07-03 23:51:52
     * */
    @Test
    public void test1(){
        System.out.println("test1 run1");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
