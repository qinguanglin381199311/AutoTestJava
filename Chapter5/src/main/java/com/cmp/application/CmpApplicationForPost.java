package com.cmp.application;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class CmpApplicationForPost {

    private ResourceBundle bundle;
    private String uri, url;
    private CookieStore store;


    @BeforeMethod
    public void beforeMethod() {
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");


    }

    @Test
    public void getMethodCookie() throws IOException {
        String result;
        uri = bundle.getString("cookies.uri");
        String testUrl = this.url + this.uri;
        System.out.println(testUrl);
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println("result="+result+"cookies="+client.getCookieStore());

        // 获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            System.out.println("11");
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name=" + name + "  , cooke value=" + value);
        }
    }

    @Test(dependsOnMethods = {"getMethodCookie"})
    public void myMethodPost() throws IOException {
        //拼接uri 和 url
        this.uri = this.bundle.getString("test.url");
        this.url = this.bundle.getString("cookies.url.post");
        String testUrl = uri + url;
        System.out.println(testUrl);
        //new client 对象
        DefaultHttpClient client = new DefaultHttpClient();

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name", "qgl");
        param.put("age", "26");
        System.out.println("param="+param);
        System.out.println("cookie="+this.store);

        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testUrl);
        //设置请求头信息，设置header
        //post.setHeader("content-type", "application/json");
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        //StringEntity entity = new StringEntity(param.toString(), "utf-8");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookie信息
        client.setCookieStore(this.store);
        //执行post语句，返回HttpResponse对象
        HttpResponse response = client.execute(post);
        System.out.println("response="+response.getStatusLine());
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        //System.out.println("result="+result);
        //处理结果,判断返回结果是否符合预期
        //将返回结果的字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
        System.out.println("resultJson="+resultJson);
        //获取结果值
        String name = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
        //判断返回的结果值
        Assert.assertEquals("success", name);
        Assert.assertEquals("1", status);
    }
}
