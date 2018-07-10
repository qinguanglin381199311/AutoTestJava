package com.cmp.server;


import com.cmp.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的POST请求")
@RequestMapping("/v1")
public class MyPostMethod {

    //这个变量是用来装我们cookie信息的
    private static Cookie cookie;

    //用户登录成功获取到cookies，然后再访问其他接口获取列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登陆成功后，成功获取cookies信息", httpMethod = "POST")
    public String myPostMethod(HttpServletResponse response,
                               @RequestParam(value = "userName", required = true) String userName,
                               @RequestParam(value = "passWord", required = true) String passWord) {
        if (userName.equals("qgl") && passWord.equals("123456")) {
            this.cookie = new Cookie("login", "true");
            response.addCookie(this.cookie);
            System.out.println(cookie);
            return "恭喜您，登陆成功";
        }
        return "用户名或密码错误";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation(value = "需要cookie信息才能查询商品列表的POST接口", httpMethod = "POST")
    public String getUserList(HttpServletRequest requeest,
                              @RequestBody() User u) {
        //获取cookies
        Cookie[] cookies = requeest.getCookies();
        //验证cookies是否合法
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                    && u.getUserName().equals("qgl")
                    && u.getPassWord().equals("123456")
                    ) {
                User user = new User();
                user.setName("覃光临");
                user.setAge("26");
                user.setSex("man");
                user.setUserName("qgl");
                return user.toString();

            }
        }
        return "参数不合法";


    }
}
