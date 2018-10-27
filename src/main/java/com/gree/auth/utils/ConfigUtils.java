package com.gree.auth.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by 260152(AWU) on 2018/10/27 17:29.
 */
public class ConfigUtils {
    private ConfigUtils() {
    }

    public static String getLocalhost() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            return "localhost";
        }
    }
}
