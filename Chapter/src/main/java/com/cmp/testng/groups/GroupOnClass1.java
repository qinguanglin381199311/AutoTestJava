package com.cmp.testng.groups;

import org.testng.annotations.Test;
/**
 * 分组测试
 * 2018-07-04 00:00:08
 * */
@Test(groups="stu")
public class GroupOnClass1 {
    public void stu1(){
        System.out.println("GroupsOnClass1中的stu111111111运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass2中的stu222222222运行");
    }
}
