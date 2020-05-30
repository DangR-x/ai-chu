package com.aichu.common.util.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.reflections.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

/**
  * @ProjectName:    Tangor
  * @Package:        com.tangor.util.utils
  * @ClassName:      HttpClientUtils
  * @Description:    HttpClientUtils
  * @Author:         Melon
  * @CreateDate:    2019-3-27 16:41
  * @Version:       V1.1.0
 */
public class HttpClientUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class); // 日志记录

    private static RequestConfig requestConfig = null;

    static {
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
    }

    
    /**
     * @MethodName: httpPost
     * @Author: Melon
     * @Date: 2019-3-27 16:42 
     * @Param: [url, jsonParam, headers]
     * @return: JSONObject
     * @Version: V1.1.0       
     * @Description: httpPost请求
     **/
    public static JSONObject httpPost(String url, JSONObject jsonParam, Header... headers) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);

        // 设置请求头
        if (!Utils.isEmpty(headers)) {
            for (Header header : headers) {
                httpPost.addHeader(header);
            }
        }

        try {
            if (null != jsonParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            logger.info("HttpClient___ActionUrl______:" + url);
            logger.info("HttpClient___ClientPost______:" + httpPost);
            logger.info("HttpClient___ClientPostUrl______:" + httpPost.getURI());
            logger.info("HttpClient___ClientPostEntity______:" + httpPost.getEntity());
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * @MethodName: httpPost
     * @Author: Melon
     * @Date: 2019-3-27 16:42 
     * @Param: [url, strParam, headers]
     * @return: JSONObject
     * @Version: V1.1.0       
     * @Description: httpPost
     **/
    public static JSONObject httpPost(String url, String strParam, Header... headers) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        // 设置请求头
        if (!Utils.isEmpty(headers)) {
            for (Header header : headers) {
                httpPost.addHeader(header);
            }
        }

        try {
            if (null != strParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            logger.info("HttpClient___ActionUrl______:" + url);
            logger.info("HttpClient___ClientPost______:" + httpPost);
            logger.info("HttpClient___ClientPostUrl______:" + httpPost.getURI());
            logger.info("HttpClient___ClientPostEntity______:" + httpPost.getEntity());
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }
    
    /***
     * @Author Melon
     * @Description xmlByHttpPost
     * @Date 15:29 2020/1/4
     * @Param [url, strParam, headers]
     * @Return java.lang.String
     **/
    public static String xmlByHttpPost(String url, String strParam, Header... headers) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String jsonStr = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        // 设置请求头
        if (!Utils.isEmpty(headers)) {
            for (Header header : headers) {
                httpPost.addHeader(header);
            }
        }

        try {
            if (null != strParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            logger.info("HttpClient___ActionUrl______:" + url);
            logger.info("HttpClient___ClientPost______:" + httpPost);
            logger.info("HttpClient___ClientPostUrl______:" + httpPost.getURI());
            logger.info("HttpClient___ClientPostEntity______:" + httpPost.getEntity());
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    jsonStr = EntityUtils.toString(result.getEntity(), "utf-8");
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonStr;
    }

    /**
     * @MethodName: httpGet
     * @Author: Melon
     * @Date: 2019-3-27 16:43 
     * @Param: [url, header]
     * @return: JSONObject
     * @Version: V1.1.0       
     * @Description: httpGet
     **/
    public static JSONObject httpGet(String url, Header header) {
        // get请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送get请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        // 设置请求头
        if (header != null) {
            httpGet.setHeader(header);
        }

        try {
            CloseableHttpResponse response = client.execute(httpGet);
            logger.info("HttpClient___ActionUrl______:" + url);
            logger.info("HttpClient___ClientGet______:" + httpGet);
            logger.info("HttpClient___ClientGetUrl______:" + httpGet.getURI());

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");
                // 把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(strResult);
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        } finally {
            httpGet.releaseConnection();
        }
        return jsonResult;
    }

    /***
     * @Author Melon
     * @Description 数据格式转换
     * @Date 15:03 2020/1/4
     * @Param [params]
     * @Return java.lang.String
     **/
    public static String buildQueryString(Map<String, String> params) {
        String str = "";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            str += (entry.getKey() + "=" + entry.getValue() + "&");
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }
}