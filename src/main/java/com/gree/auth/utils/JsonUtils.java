package com.gree.auth.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by 260152(AWU) on 2018/11/12 13:43.
 */
public class JsonUtils {
    /**
     * 判断字符串 是否为 json 对象
     *
     * @param result
     * @return
     */
    public static boolean isJsonObject(String result) {
        try {

            JSONObject.toJSONString(result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 将json对象转成 请求的参数格式
     *
     * @param jsonObject
     * @return
     */
    public static List<NameValuePair> getParams(JSONObject jsonObject) {
        List<NameValuePair> pairs = new ArrayList<>();
        if (jsonObject != null) {
            Set<String> keySet = jsonObject.keySet();
            for (String key : keySet) {
                String value = (String) jsonObject.get(key);
                pairs.add(new BasicNameValuePair(key, value));
            }
        }
        return pairs;
    }

    /**
     * 默认的 {@code JSON} 日期/时间字段的格式化模式。
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private JsonUtils() {
    }
}
