package com.cmp.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClass3 {
    public void teacher1() {
        System.out.println("GroupOnClass3中的teacher1运行111111运行");
    }

    public void teacher2(){
        System.out.println("GroupOnClass3中的teacher2运行222222运行");
    }
}
