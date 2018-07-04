package com.cmp.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThradOnAnnotion {
    /**
     * 多线程
     * 2018-07-04 01:02:16
     * */
    @Test(invocationCount = 10, threadPoolSize = 3)
    public void test() {
        System.out.println(1);
        System.out.printf("Thread Id :%s%n",Thread.currentThread().getId());
    }
}
