package com.cmp.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    /**
     * 超时测试
     * 2018-07-04 01:32:24
     * timeout单位为毫秒值3000=3s*/
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 3000)
    public void testFail() throws InterruptedException {
        Thread.sleep(4000);
    }
}
