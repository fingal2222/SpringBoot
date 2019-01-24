package com.example.springboothelloworld.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class HttpUtil {

    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(10000).setConnectTimeout(7000).build();

    public  String request(String token, String url, Map<String,Object> maps) throws  Exception    {
        String result = "";
        System.out.println("请求地址："+url);
        RequestBuilder requestBuilder = RequestBuilder.post().setUri(url);//get方式，post类似
        requestBuilder.setConfig(requestConfig);
        requestBuilder.addHeader("Authorization", token);
        Set<String> keys=maps.keySet();
        for (String key:keys)
        {
            requestBuilder.addParameter(key,maps.get(key).toString());
        }
        HttpUriRequest req = requestBuilder.build();
        CloseableHttpClient client = SSLClientUtils.createSSLInsecureClient();
        CloseableHttpResponse resp = client.execute(req);
        int statusCode = resp.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("HTTP响应错误，statusCode:" + statusCode);
        }
        result = EntityUtils.toString(resp.getEntity());

        return  result;
    }
}
