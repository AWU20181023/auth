package com.gree.auth.utils;

import com.gree.auth.constant.ConstantEum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 260152(AWU) on 2018/12/3 15:24.
 */
@Component
public class AuthUtils {

    private AuthUtils() {
    }

    private static String authMethod;
    private static Map<String, Integer> authMap = new LinkedHashMap<>();

    @Value("${auth.method}")
    public void setAuthMethod(String authMethod) {
        AuthUtils.authMethod = authMethod;
    }

    public static Integer getAuthMethod() {
        Integer integer = authMap.get(ConstantEum.AUTH_METHOD.getString());
        if (integer != null) {
            return integer;
        } else {
            if ("token".equals(authMethod)) {
                authMap.put(ConstantEum.AUTH_METHOD.getString(), ConstantEum.USE_TOKEN.getInteger());
                return ConstantEum.USE_TOKEN.getInteger();
            } else {
                // 默认使用cookie方式
                authMap.put(ConstantEum.AUTH_METHOD.getString(), ConstantEum.USE_COOKIE.getInteger());
                return ConstantEum.USE_COOKIE.getInteger();
            }
        }
    }
}
