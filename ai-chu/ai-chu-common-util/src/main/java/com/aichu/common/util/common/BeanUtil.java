package com.aichu.common.util.common;

import org.springframework.beans.BeanUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName BeanUtil
 * @Description 对象属性复制工具类,采用javassit生成源代码实现属性复制.并能实现包装类型和基础类型之间的转换
 * @Author Melon
 * @Date 2019/7/22 18:24
 * @Version 1.0.0
 **/
public class BeanUtil extends BeanUtils {
    /**
     * 复制对象属性，属性名需一致
     *
     * @param from 源对象
     * @param to 目标对象
     */
    public static void copy(Object from, Object to) {
        BeanUtils.copyProperties(from, to);
    }

    /**
     * 复制对象属性
     *
     * @param from 源对象
     * @param to   目标对象类型
     * @param <T>
     * @return
     */
    public static <T> T copy(Object from, Class<T> to) {
        if (null == from) {
            return null;
        }
        try {
            T obj = to.newInstance();
            BeanUtils.copyProperties(from, obj);
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("BeanUtil.copy error:", e);
        }
    }

    /**
     * 复制对象属性
     *
     * @param fromList 源对象数组
     * @param to       目标对象类型
     * @param <T>
     * @return
     */
    public static <T> List<T> copy(List<?> fromList, Class<T> to) {
        if (null == fromList) {
            return null;
        }
        List<T> toList = new ArrayList<>();
        fromList.forEach(o -> {
            try {
                T obj = to.newInstance();
                toList.add(obj);
                BeanUtils.copyProperties(o, obj);
            } catch (Exception e) {
                throw new RuntimeException("BeanUtil.copy error:", e);
            }
        });
        return toList;
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass)
            throws Exception {
        if (map == null)
            return null;
        Object obj = beanClass.newInstance();
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;
    }

    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new org.apache.commons.beanutils.BeanMap(obj);
    }

    /**
     * @Description 解决生僻字插入数据库失败
     * @Param String
     * @Return String
     * @Author yuan.shuai
     * @Date  2019/9/15
     * @Version 1.0.0
     */
    public static String strToUtf8(String str){
        if (Objects.isNull(str) || Objects.equals(str,"")){
            return null;
        } else{
            try{
                StringBuffer sb = new StringBuffer();
                sb.append(str);
                String strString = new String(sb.toString().getBytes("UTF-8"));
                String aa = URLEncoder.encode(strString, "UTF-8");
                String xx = URLDecoder.decode(aa, "utf-8");
                return xx;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}