package com.gree.auth.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 260152(AWU) on 2018/11/12 13:45.
 */
public class HttpUtils {
    /**
     * 发送 get 请求
     *
     * @param url    接口地址
     * @param params 请求参数
     * @return
     */
    public static String doGet(String url, Map<String, String> headList, JSONObject params) {

        HttpGet httpGet = null;
        if (org.apache.commons.lang3.StringUtils.isBlank(url)) {
            return "url cannot not be null";
        }
        try {
            List<NameValuePair> paramStr = JsonUtils.getParams(params);
            if (paramStr.size() > 0) {
                String str = EntityUtils.toString(new UrlEncodedFormEntity(paramStr, "UTF-8"));
                httpGet = new HttpGet(url + "?" + str);
            } else {
                httpGet = new HttpGet(url);
            }

            HttpClient httpClient = HttpClients.createDefault();
            //设置超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(50000)
                    .setConnectTimeout(50000)
                    .setSocketTimeout(50000).build();
            if (headList != null && headList.size() > 0) {
                Set<Map.Entry<String, String>> entries = headList.entrySet();
                for (Map.Entry<String, String> entry : entries) {//性能较好
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
            httpGet.setConfig(requestConfig);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = httpResponse.getEntity();
                return EntityUtils.toString(entity);
            } else {
                return "http_error" + httpResponse.getStatusLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "http_error" + e.toString();
        } finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
        }
    }

    public static String doPost(String url, Map<String, String> headList, JSONObject params) {
        HttpPost httpPost = null;
        if (StringUtils.isBlank(url)) {
            return "url cannot not be blank";
        }
        try {
            if (params != null && params.size() > 0) {
                StringEntity stringEntity = new StringEntity(params.toString(), "utf-8");
                httpPost = new HttpPost(url);
                httpPost.setEntity(stringEntity);
            } else {
                httpPost = new HttpPost(url);
            }
            HttpClient httpClient = HttpClients.createDefault();
            //设置超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(50000)
                    .setConnectTimeout(50000)
                    .setSocketTimeout(50000).build();
            if (headList != null && headList.size() > 0) {
                Set<String> strings = headList.keySet();
                for (String string : strings) {
                    httpPost.addHeader(string, headList.get(string));
                }
            }
            httpPost.setConfig(requestConfig);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = httpResponse.getEntity();
                return EntityUtils.toString(entity);
            } else {
                return "http_error" + httpResponse.getStatusLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "http_error" + e.toString();
        } finally {
            if (httpPost != null) {
                httpPost.releaseConnection();
            }
        }
    }
}
