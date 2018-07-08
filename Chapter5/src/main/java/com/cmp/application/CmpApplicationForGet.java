package com.cmp.application;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class CmpApplicationForGet {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;


    @BeforeMethod
    public void beforeApplication() {
        bundle = ResourceBundle.getBundle("application");
        //System.out.println(bundle);
        url = bundle.getString("test.url");
        System.out.println(this.url);
    }

    @Test
    public void getApplicationPro() throws IOException {
        String result;
        String uri = bundle.getString("cookies.uri");
        String testUrl = this.url + uri;
        System.out.println(testUrl);
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println("result="+result+";cookies="+client.getCookieStore());

        // 获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        System.out.println("cookieList="+cookieList.toString());
        System.out.println("cookieListLength="+cookieList.size());
        for (Cookie cookie : cookieList) {
            System.out.println("11");
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name=" + name + "  , cooke value=" + value);
        }

    }


    @Test(dependsOnMethods = {"getApplicationPro"})
    public void getCookieInfo() throws IOException {
        String result;
        this.url = this.bundle.getString("test.url");
        //System.out.println(url);
        String uri = this.bundle.getString("test.get.with.cookies");
        //System.out.println(uri);
        String testUrl = url + uri;
        System.out.println(testUrl);
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //      设置cookie信息
        System.out.println("store="+store);
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        int status = response.getStatusLine().getStatusCode();
        System.out.println("status="+status);
        if(status==200){
            result = EntityUtils.toString(response.getEntity());
            System.out.println("result="+result);
        }else{
            System.out.println("请求失败，啥都没");
        }



    }
}
