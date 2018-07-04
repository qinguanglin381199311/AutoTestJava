package com.cmp.testng;

import org.testng.annotations.Test;

public class ExceptionTest {

    /**
     * 异常测试
     * 什么时候回用到异常测试
     * 在我们期望结果为某一个异常的时候
     * 比如：我们传入了某些不合法的参数，程序抛出了异常
     * 也就是说我的预期结果就是这个异常
     * 2018-07-03 23:51:58*/

    //这是一个异常结果会失败的测试

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){
        System.out.println("这是一个失败的结果的异常");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();

    }
}
