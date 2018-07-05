package com.cmp.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;

public class CmpHttpClientTest {

    @Test
    public void testHttpClient() throws IOException {
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

    }
}
