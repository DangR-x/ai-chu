package com.aichu.manager.api.im.config;

import org.apache.http.client.methods.HttpPost;

/**
 * @ClassName WangYiYunCloudHttpConfig
 * @Description 网易云Http请求信息初始化Config
 * @Author Melon
 * @Date 2020/1/4 17:39
 * @Version 1.1.0
 **/
public class WangYiYunCloudHttpConfig {
    
    /***
     * @Author Melon
     * @Description 网易云Http请求信息初始化
     * @Date 17:43 2020/1/4
     * @Param [actionUrl, appKey, nonce, curTime, checkSum]
     * @Return org.apache.http.client.methods.HttpPost
     **/
    public static HttpPost WangYiYunCloudHttpInit(String actionUrl, String appKey, String nonce, String curTime, String checkSum){
        //初始化请求
        HttpPost httpPost = new HttpPost(actionUrl);
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        return httpPost;
    }
}
