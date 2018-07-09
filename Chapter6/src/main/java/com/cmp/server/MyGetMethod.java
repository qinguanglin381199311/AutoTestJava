package com.cmp.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
/**
 * @RestController，
 * 一般是使用在类上的，它表示的意思其实就是结合了@Controller和@ResponseBody两个注解，*/
@Api //swagger的搞法

public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value="通过这个方法可以获得cookies",httpMethod="GET")
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类
        return "恭喜您qgl，获得cookies成功";
    }

    /**
     * 要求客户端携带cookies信息来访问
     * 这是一个需要携带cookies信息的get请求方法
     */

    @RequestMapping(value = "/startup/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value="这是一个需要携带cookies信息的get请求方法",httpMethod="GET")
    public String getWithCookies(HttpServletRequest request) {
        System.out.println("cookies=" + request.getCookies());
        Cookie[] cookies = request.getCookies();
        System.out.println("cookie=" + cookies);
        if (Objects.isNull(cookies)) {
            return "您必须携带cookies信息才能访问";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "恭喜您，我是一个带有cookies信息的get请求";
            }

        }

        return "您必须携带cookies信息才能访问!!!";
    }


    /**
     * 这是一个携带参数才能访问的的get请求
     * 第一种实现方式 url:key=value&key=value
     * 模拟获取商品列表
     */
    @ApiOperation(value="这是一个携带参数才能访问的的get请求---获取商品列表",httpMethod="GET")
    @RequestMapping(value = "/startup/with/param", method = RequestMethod.GET)
    public Map<String, Integer> getMerchant(@RequestParam Integer start,
                                            @RequestParam Integer end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("百丽鞋子", 400);
        map.put("意尔康皮鞋", 888);
        map.put("塔塔鞋子", 122);

        return map;


    }


    /**
     * 第二种方式：需要携带参数访问的get请求
     * url:ip:port/startup/with/param/10/20
     */
    @ApiOperation(value="这是一个携带参数才能访问的的get请求---获取商品列表（忽略参数名，可以直接传参数的方式）",httpMethod="GET")
    @RequestMapping("/startup/get/with/param/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("百丽鞋子", 400);
        map.put("意尔康皮鞋", 888);
        map.put("塔塔鞋子", 122);
        return map;
    }
}
