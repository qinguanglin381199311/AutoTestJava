package com.cmp.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    /**
     * 通过对象来参数化
     * 2018-07-04 00:25:58
     */
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name:" + name + ";  age=" + age);

    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] obj = new Object[][]{
                {"qgl", 26},
                {"zhangsan", 30},
                {"lisi", 40}
        };
        return obj;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("test1 method name=" + name + ";age=" + age);

    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test2 method name=" + name + ";age=" + age);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method) {
        System.out.println("method："+method);
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"qgl", 22},
                    {"zhangsan", 33},
                    {"lisi", 44}
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"wanger", 55},
                    {"mazi", 66}

            };
        }
        return result;


    }
}
