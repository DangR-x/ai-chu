package com.aichu.common.util.common;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
/**
 * HttpClient连接池工具类
 * @author admin
 *
 */
public class HttpClientPool {
	private static Log log = LogFactory.getLog("HttpClientPool");
	/** 全局连接池对象 */
    private static final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();    
    /**
     * 静态代码块配置连接池信息
     */
    static {        
        // 设置最大连接数
        connManager.setMaxTotal(1500);
        // 设置每个连接的路由数
        connManager.setDefaultMaxPerRoute(500);
        
    }
    
    /**
     * 获取Http客户端连接对象
     * @return Http客户端连接对象
     */
    public static CloseableHttpClient getHttpClient() {
        // 创建Http请求配置参数
        RequestConfig requestConfig = RequestConfig.custom()
            // 获取连接超时时间
            .setConnectionRequestTimeout(Constants.CONNECTION_REQUEST_TIMEOUT)
            // 请求超时时间
            .setConnectTimeout(Constants.CONNECT_TIMEOUT)
            // 响应超时时间
            .setSocketTimeout(Constants.SOCKET_TIMEOUT)
            .build(); 
        /**
         *  超时重试机制为了防止超时不生效而设置
         *  如果直接放回false,不重试
         *  这里会根据情况进行判断是否重试
         */
        HttpRequestRetryHandler retry = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
            	// 如果已经重试了3次，就放弃
            	if (executionCount >= 3) {
                    return false;
                }
            	//如果服务器丢掉了连接，那么就重试
                if (exception instanceof NoHttpResponseException) {
                    return true;
                }
                //不要重试SSL握手异常
                if (exception instanceof SSLHandshakeException) {
                    return false;
                }
               //超时
                if (exception instanceof InterruptedIOException) {
                    return true;
                }
                //目标服务器不可达
                if (exception instanceof UnknownHostException) {
                    return false;
                }
                //连接被拒绝
                if (exception instanceof ConnectTimeoutException) {
                    return false;
                }
               //ssl握手异常
                if (exception instanceof SSLException) {
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };       
        // 创建httpClient
        return HttpClients.custom()
                // 把请求相关的超时信息设置到连接客户端
                .setDefaultRequestConfig(requestConfig)
                // 把请求重试设置到连接客户端
                .setRetryHandler(retry)
                // 配置连接池管理对象
                .setConnectionManager(connManager)
                .build();
    }
    /**
     * post请求
     * @param url
     * @param nvps
     * @return
     */
    public static String httpPost(String url, List <NameValuePair> nvps) {
        String msg = "";       
        // 获取客户端连接对象
        CloseableHttpClient httpClient = getHttpClient();
        // 创建GET请求对象
        HttpPost httpPost = new HttpPost(url);       
        CloseableHttpResponse response = null;       
        try {
        	//设置编码格式是UTF-8
        	UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
        	httpPost.setEntity(formEntity);
            // 执行请求
            response = httpClient.execute(httpPost);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 获取响应信息
            msg = EntityUtils.toString(entity, "UTF-8");            
            
        } catch (Exception e) {
            log.info("协议错误:"+e.getMessage());
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException e) {
                	log.info("释放连接错误:"+e.getMessage());
                }
            }
        }       
        return msg;
    }
    
    /**
     * GET请求 
     * @param url 请求地址
     * @return
     */
    public static String httpGet(String url) {
        String msg = "";       
        // 获取客户端连接对象
        CloseableHttpClient httpClient = getHttpClient();
        // 创建GET请求对象
        HttpGet httpGet = new HttpGet(url);       
        CloseableHttpResponse response = null;       
        try {
            // 执行请求
            response = httpClient.execute(httpGet);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 获取响应信息
            msg = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            log.info("异常错误:"+e.getMessage());
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException e) {
                	log.info("释放连接错误:"+e.getMessage());
                    e.printStackTrace();
                }
            }
        }       
        return msg;
    }
    
    
    /**
     * http post请求
     * application/json
     * */
    @SuppressWarnings("unchecked")
    public static String doXLMapPostAppJson(String url, Map<String,String> params) {
    
        String responseMsg = "";
        // 1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setContentCharset("UTF-8");
//		String url = "http://jfb.yeion.com/test.do";
        // 2.构造PostMethod的实例
        PostMethod postMethod = new PostMethod(url);
        // 3.把参数值放入到PostMethod对象中
        RequestEntity entity = null;
    
        try {
            entity = new StringRequestEntity(JSON.toJSONString(params),"application/x-www-form-urlencoded","UTF-8");
            postMethod.setRequestEntity(entity);
            postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
            // 4.执行postMethod,调用http接口
            httpClient.executeMethod(postMethod);// 200
            // 5.读取内容
            responseMsg = postMethod.getResponseBodyAsString().trim();
            // 6.处理返回的内容
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7.释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    
    }
    
}
