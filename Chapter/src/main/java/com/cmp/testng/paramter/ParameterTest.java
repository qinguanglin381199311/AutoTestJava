package com.cmp.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    /**
     * 参数测试
     * 2018-07-04 00:16:06
     * */

    @Test
    @Parameters({"name", "age"})
    public void paramTest1(String name, int age) {
        System.out.println("name="+name+" age="+age);

    }
}
