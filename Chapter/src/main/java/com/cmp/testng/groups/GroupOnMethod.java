package com.cmp.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups="server")
    public void test1(){
        System.out.println("这是服务端组的测试方法1111111111");
    }

    @Test(groups="server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2222222222");
    }

    @Test(groups="client")
    public void test3(){
        System.out.println("这是客户端的测试方法3333333333333");
    }

    @Test(groups="client")
    public void test4(){
        System.out.println("这是客户端的测试方法4444444444444444444");
    }

    @BeforeGroups("server")
    public void beforeGroups(){
        System.out.println("这是服务端组运行之前的方法");
    }


    @AfterGroups("client")
    public void afterGroups(){
        System.out.println("这是客户端组运行之后的方法");
    }

}
