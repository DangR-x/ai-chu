package com.aichu.common.util.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CommonUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYmmddhh");
    private static final Random RANDOM = new Random();
    private static final char[] NUMBERS = "0123456789".toCharArray();

    /**
     * 生成 length位的数字字符串
     *
     * @param length
     * @return
     */
    public static String get(int length) {
        if (length < 1) {
            return "";
        }
        char[] buffer = new char[length];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = NUMBERS[RANDOM.nextInt(10)];

        }
        return new String(buffer);
    }

    /**
     * 获取文件类型
     *
     * @param s
     * @return
     */
    public static String getExtName(String s) {
        int i = s.lastIndexOf('.');
        int leg = s.length();
        return (i > 0 ? (i + 1) == leg ? " " : s.substring(i, s.length()) : " ");
    }

    /**
     * 获取文件前缀
     *
     * @param s
     * @return
     */
    public static String getPrefixName(String s) {
        int i = s.lastIndexOf('.');
        int leg = s.length();
        return (i > 0 ? (i + 1) == leg ? " " : s.substring(0, i) : " ");
    }

    /**
     *
     * @param list
     * @return
     */
    public static Object[] listToArray(List<Object> list) {
        Object[] objects = new Object[list.size()];
        if (list.size() > 0) {
            int i = 0;
            for (Object o : list) {
                objects[i++] = o;
            }
        }
        return objects;
    }

    /**
     *
     * 生成id
     *
     * @return
     */
    public static String getId(int length) {
        return simpleDateFormat.format(new Date()) + get(length);
    }

    /**
     * 通过名称获取cookies
     *
     * @return
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
        String cookieValue = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
