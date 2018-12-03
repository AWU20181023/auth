package com.gree.auth.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 260152(AWU) on 2018/12/3 16:26.
 */
public class DateUtils {
    private DateUtils() {
    }


    /**
     * @author 260152
     * @date 2018/6/29 9:55
     * 获取date时间的hour小时之前
     */

    public static Date getBeforeTimeByHour(Date date, Double hour) {
        return getTimeBeforeOrAfterByHour(date, -hour);
    }

    /**
     * @author 260152
     * @date 2018/6/29 9:56
     * 获取date时间的hour小时之后
     */

    public static Date getAfterTimeByHour(Date date, Double hour) {
        return getTimeBeforeOrAfterByHour(date, hour);
    }

    /**
     * @author 260152
     * @date 2018/7/14 8:32
     * @function 格式化日期
     * 按传入的格式对日期进行格式化
     */
    public static Date parseDate(String dateStr, String format) throws Exception {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException("解析时间格式异常");
        }
        return date;
    }

    /**
     * @author 260152
     * @date 2018/7/14 8:32
     * @function 格式化日期
     * 按传入的格式对日期进行格式化
     */
    public static Date parseDate(Date dateStr, String format) throws Exception {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateFormat.format(dateStr));
        } catch (Exception e) {
            throw new RuntimeException("解析时间格式异常");
        }
        return date;
    }

    /**
     * @author 260152
     * @date 2018/6/25 17:19
     * 根据当前时间获取hour前后的日期
     * hour为正值是为后，负值时为前
     */
    private static Date getTimeBeforeOrAfterByHour(Date date, Double hour) {
        return new Date(date.getTime() + (long) (hour * 60 * 60 * 1000));
    }

}
