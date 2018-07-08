package com.cmp.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class CmpHttpClientTest {

    @Test
    public void testHttpClient() throws IOException {
        String result;
        String url = "http://www.baidu.com";
        HttpGet get = new HttpGet(url);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);




    }
}
