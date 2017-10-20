package com.yuxin.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class D1 {
    public static void main(String[] args) throws Exception {
        d2();
    }

    public static String d1() throws Exception {
        String res;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://admintest.quandashi.cn");
        CloseableHttpResponse response = client.execute(get);
        res = outPut(response);
        return res;
    }

    public static String d2() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        List<NameValuePair> naveList = new ArrayList<NameValuePair>();
        naveList.add(new BasicNameValuePair("adminAccount", "yangzengxun"));
        naveList.add(new BasicNameValuePair("adminPwd", "yangzengxun"));
        HttpPost post = new HttpPost("http://admintest.quandashi.cn/index/dologin");
        post.setEntity(new UrlEncodedFormEntity(naveList));
        CloseableHttpResponse response = client.execute(post);
        String res = outPut(response);
        return res;
    }

    public static String outPut(CloseableHttpResponse response) throws Exception {
        String res = "";
        try {
            HttpEntity entity = response.getEntity();
            res = EntityUtils.toString(entity);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return res;
    }
}
