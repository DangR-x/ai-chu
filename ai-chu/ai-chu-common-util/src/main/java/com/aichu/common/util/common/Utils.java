package com.aichu.common.util.common;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName Utils
 * @Description Utils工具类
 * @Author Melon
 * @Date 2019/7/20 14:35
 * @Version 1.0.0
 **/
public class Utils {

    /**
     * 是否为空
     *
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String) {
            String instance = (String)obj;
            if (instance.trim().length() <= 0 || "null".equalsIgnoreCase(instance)) {
                return true;
            }
        } else if (obj instanceof Integer) {
            Integer instance = (Integer)obj;
            if (instance < 0) {
                return true;
            }
        } else if (obj instanceof List<?>) {
            List<?> instance = (List<?>)obj;
            if (instance.size() <= 0) {
                return true;
            }
        } else if (obj instanceof Map<?, ?>) {
            Map<?, ?> instance = (Map<?, ?>)obj;
            if (instance.size() <= 0) {
                return true;
            }
        } else if (obj instanceof Object[]) {
            Object[] instance = (Object[])obj;
            if (instance.length <= 0) {
                return true;
            }
        } else if (obj instanceof Long) {
            Long instance = (Long)obj;
            if (instance < 0) {
                return true;
            }
        }
        return false;
    }

    public static void isEmptyThrow(String... values) throws Exception {
        for(String value: values) {
            boolean b = isEmpty(value);
            if(b) {
                throw new Exception("参数错误");
            }
        }
    }

    /**
     * @Description 首字母小写
     * @Param value
     * @Return String
     * @Author yuan.shuai
     * @Date  2019/8/30
     * @Version 1.0.0
     */
    public static String toLowerCaseFirstOne(String value) throws Exception{
        if (Objects.nonNull(value) && !Objects.equals(value,"")){
            char[] chars = value.toCharArray();
            chars[0] += 32;
            return String.valueOf(chars);
        }
        return null;
    }

    public static boolean notEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
