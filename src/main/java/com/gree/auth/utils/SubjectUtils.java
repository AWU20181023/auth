package com.gree.auth.utils;

import com.gree.auth.constant.ConstantEum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by 260152(AWU) on 2018/10/27 14:01.
 */
public class SubjectUtils {
    private SubjectUtils() {
    }

    private static Map<String, Map<Long, String>> tokenMap = new LinkedHashMap<>();
    private static long timeout = 1000 * 60 * 30;  //默认30分钟

    public static String getEmail(String token) {
        String[] execToken = execToken(token);
        if (execToken != null) {
            return execToken[0];
        } else return null;
    }

    public static String getUsername(String token) {
        String[] execToken = execToken(token);
        if (execToken != null) {
            return execToken[1];
        } else return null;
    }

    public static String login(HttpServletResponse response, HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        return getAuthString(response, username, email);
    }

    public static String login(HttpServletResponse response, String email, String username) {
        return getAuthString(response, username, email);
    }

    public static void logout(HttpServletResponse response, HttpServletRequest request) {
        //从map中清除
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        tokenMap.remove(email + ConstantEum.DELIMITER.getString() + username);
        Integer authMethod = AuthMethodUtils.getAuthMethod();
        if (ConstantEum.USE_COOKIE.getInteger().equals(authMethod)) {
            CookieUtils.deleteCookie(request, response, ConstantEum.LOGIN_TOKEN.getString());
        }
    }

    public static void logout(HttpServletResponse response, HttpServletRequest request, String email, String username) {
        //从map中清除
        tokenMap.remove(email + ConstantEum.DELIMITER.getString() + username);
        Integer authMethod = AuthMethodUtils.getAuthMethod();
        if (ConstantEum.USE_COOKIE.getInteger().equals(authMethod)) {
            CookieUtils.deleteCookie(request, response, ConstantEum.LOGIN_TOKEN.getString());
        }
    }

    private static String getAuthString(HttpServletResponse response, String username, String email) {
        String randomString = SubjectUtils.getRandomString();
        Integer authMethod = AuthMethodUtils.getAuthMethod();
        if (ConstantEum.USE_COOKIE.getInteger().equals(authMethod)) {
            CookieUtils.addCookie(response, ConstantEum.LOGIN_TOKEN.getString(), randomString,
                    ConfigUtils.getLocalhost(), 3600, false);
            //保存到map中进行管理
            execMap(email, username, randomString);
            return null;
        } else {
            execMap(email, username, randomString);
            return randomString;
        }
    }

    private static void execMap(String email, String username, String randomString) {
        //保存到map中进行管理
        Map<Long, String> map = new LinkedHashMap<>();
        map.put(new Date().getTime(), randomString);
        tokenMap.put(email + ConstantEum.DELIMITER.getString() + username, map);
    }

    /**
     * NO_LOGIN("0"),
     * TOKEN_TIMEOUT("1"),
     * LOGINING("2")
     */
    public static String isLogin(String token) {
        if (token != null) {
            if (isExist(token)) {
                if (isTimeout(token)) {
                    return ConstantEum.TOKEN_TIMEOUT.getString();
                }
                if (isLogging(token)) {
                    return ConstantEum.LOGINING.getString();
                }
            } else return ConstantEum.NO_LOGIN.getString();
        }
        return ConstantEum.NO_LOGIN.getString();
    }

    private static boolean isLogging(String token) {
        if (isExist(token)) {
            if (!isTimeout(token)) {
                refreshToken(token);  //刷新，防止过期
                return true;
            }
        }
        return false;
    }

    private static boolean isTimeout(String token) {
        if (token != null) {
            if (tokenMap != null && tokenMap.size() > 0) {
                Set<Map.Entry<String, Map<Long, String>>> entries = tokenMap.entrySet();
                if (entries.size() > 0) {
                    for (Map.Entry<String, Map<Long, String>> entry : entries) {
                        Map<Long, String> value = entry.getValue();
                        if (value.size() > 0) {
                            Set<Map.Entry<Long, String>> entries1 = value.entrySet();
                            if (entries1.size() > 0) {
                                for (Map.Entry<Long, String> longStringEntry : entries1) {
                                    String value1 = longStringEntry.getValue();
                                    if (token.equals(value1)) {
                                        Long key = longStringEntry.getKey();
                                        if (new Date().getTime() - key <= timeout) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static void refreshToken(String token) {
        if (token != null) {
            if (isExist(token)) {
                Map<Long, String> map = tokenMap.get(getEmail(token) + ConstantEum.DELIMITER.getString() + getUsername(token));
                map.put(new Date().getTime(), token);
            }
        }
    }

    private static boolean isExist(String token) {
        boolean flag = false;
        if (token != null) {
            if (tokenMap != null && tokenMap.size() > 0) {
                Set<Map.Entry<String, Map<Long, String>>> entries = tokenMap.entrySet();
                if (entries.size() > 0) {
                    for (Map.Entry<String, Map<Long, String>> entry : entries) {
                        Map<Long, String> value = entry.getValue();
                        if (!flag && value.containsValue(token)) {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    private static String[] execToken(String token) {
        if (token != null) {
            if (tokenMap != null && tokenMap.size() > 0) {
                Set<Map.Entry<String, Map<Long, String>>> entries = tokenMap.entrySet();
                if (entries.size() > 0) {
                    for (Map.Entry<String, Map<Long, String>> entry : entries) {
                        Map<Long, String> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            Set<Map.Entry<Long, String>> entries1 = value.entrySet();
                            if (entries1.size() > 0) {
                                for (Map.Entry<Long, String> longStringEntry : entries1) {
                                    if (token.equals(longStringEntry.getValue())) {
                                        return entry.getKey().split(ConstantEum.DELIMITER.getString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String getRandomString() {
        return (UUID.randomUUID().toString() + UUID.randomUUID().toString()).replace("-", "");
    }

    /**
     * todo 清除失效的token
     */
    public static void clearTimeoutToken() {
        if (tokenMap != null) {
            List<String> tokenList = new LinkedList<>();
            long currentTimeStamp = DateUtils.getBeforeTimeByHour(new Date(), 24D).getTime();
            // 清除小于currentTimeStamp的token
            tokenMap.forEach((k, v) -> v.forEach((k2, v2) -> {
                if (k2 < currentTimeStamp) {
                    tokenList.add(k);
                }
            }));
            if (tokenList.size() > 0) {
                tokenList.forEach(tokenMap::remove);
            }
        }
    }
}
