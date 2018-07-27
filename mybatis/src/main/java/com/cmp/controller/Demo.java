package com.cmp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Log4j
@RestController
@RequestMapping("v1")
@Api(value = "v1", description = "这我是第一个版本的demo")
public class Demo {

    @Autowired //起动机加载，也就是说启动这个类，当前方法就被加载了
    private SqlSessionTemplate template;

    @RequestMapping(value="/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCounts");
    }



}
