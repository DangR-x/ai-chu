package com.aichu.common.util.common;

/**
 * @ClassName SensitiveUtil
 * @Author yuan.shuai
 * @Description 文本敏感代码校验工具类
 * @Date 2019/9/12
 * @Version 1.0.0
 */
public class SensitiveUtil {

    private static String[] sesitive = {"function","method","<script","return","javascript"};

    public static Boolean verifyString(String str) throws Exception{
        String newStr = str.toLowerCase();
        Boolean bool = Boolean.TRUE;
        for (String val: sesitive){
            if (newStr.contains(val)){
                bool = Boolean.FALSE;
                break;
            }
        }
        return bool;
    }

}
