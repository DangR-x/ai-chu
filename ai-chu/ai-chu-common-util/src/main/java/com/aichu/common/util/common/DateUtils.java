package com.aichu.common.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName DateUtils
 * @Description 时间工具Utils
 * @Author Melon
 * @Date 2019/7/23 10:23
 * @Version 1.0.0
 **/
public class DateUtils {

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public static String format(Date date) {
        long delta = new Date().getTime() - date.getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            //return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
            return "刚刚";
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 30L * ONE_DAY) {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
        if (delta < 12L * 4L * ONE_WEEK) {
            long months = toMonths(delta);
            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
        } else {
            long years = toYears(delta);
            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }

    /**
     * @Description 处理特殊时间格式 "2019.10.9"
     * @Param String
     * @Return Date
     * @Author yuan.shuai
     * @Date  2019/10/11
     * @Version 1.0.0
     */
    public static Date specialProcessingTime(String date) throws Exception{
        if (Objects.isNull(date) || Objects.equals(date,"")){
            return null;
        }
        SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date.indexOf(".")>= 0){
            String dates = date.replace(".","-")+" 00:00:00";
            return dateSimpleDateFormat.parse(dates);
        } else {
            return dateSimpleDateFormat.parse(date);
        }
    }

    /**
     * @Description 字符时间类型转换为Date类型
     * @Param  chars
     * @Return Date
     * @Author yuan.shuai
     * @Date  2019/8/14
     * @Version 1.0.0
     */
    public static Date stringToDate(String chars) throws Exception{
        if (Objects.equals(chars,"") || Objects.isNull(chars)){
            return null;
        }
        Date date = null;
        Boolean bool = Boolean.FALSE;
        // 处理后端 时间为2016-08-15T16:00:00.000Z格式的时间
        if (chars.contains("Z")){
            bool = Boolean.TRUE;
        }
        if (bool || chars.contains("T")){
            chars = chars.replace("Z", " UTC");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            date = simpleDateFormat.parse(chars);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if (bool){
                cal.add(Calendar.HOUR, 8);// 北京东八区，去掉Z后需要+8小时
            }
            date = cal.getTime();
        }else{
            if (chars.length() < 11){ // 处理时间格式为 2019-09-17 这种没有时分秒的时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = simpleDateFormat.parse(chars);
            }else{
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = simpleDateFormat.parse(chars);
            }
        }
        return date;
    }

    /**
     * @Description 格式化时间
     * @Param chars
     * @Return String
     * @Author yuan.shuai
     * @Date  2019/8/15
     * @Version 1.0.0
     */
    public static String formatDate(String chars) throws Exception{
        if (Objects.equals(chars,"") || Objects.isNull(chars)){
            return null;
        }
        Date date = DateUtils.stringToDate(chars);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = simpleDateFormat.format(date);
        return string;
    }

    /**
     * @Description 时间格式转换成String类型
     * @Param Date
     * @Return String
     * @Author yuan.shuai
     * @Date  2019/9/19
     * @Version 1.0.0
     */
    public static String formatDateToString(Date date) throws Exception{
        if (Objects.isNull(date)){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * @Description 时间戳转换成Date类型
     * @Param String
     * @Return Date
     * @Author yuan.shuai
     * @Date  2019/10/8
     * @Version 1.0.0
     */
    public static Date formatDateToLong(String date) throws Exception{
        if (Objects.isNull(date) || Objects.equals(date,"")){
            return null;
        }
        return new Date(Long.parseLong(date));
    }

    /***
     * @Author Melon
     * @Description 计算目标日期的后一天
     * @Date 1:06 2020/2/22
     * @Param [aimDays]
     * @Return java.lang.String
     **/
    public static String nextDayByAimDate(String aimDays) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(aimDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }
}


