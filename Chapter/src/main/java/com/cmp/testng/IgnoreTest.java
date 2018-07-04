package com.cmp.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    /**
     * 忽略测试
     * 2018-07-03 23:56:01
     * */
    @Test
    public void ignore1(){
        System.out.println("ignore1  运行了...");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2  运行了...");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3  运行了...");
    }
}
