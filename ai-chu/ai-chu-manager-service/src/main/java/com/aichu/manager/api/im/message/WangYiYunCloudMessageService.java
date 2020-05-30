package com.aichu.manager.api.im.message;

import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcUserMapper;
import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.dao.autogeneration.object.AcUserExample;
import com.aichu.manager.api.im.builder.CheckSumBuilder;
import com.aichu.manager.api.im.config.WangYiYunCloudHttpConfig;
import com.aichu.manager.config.WangYiYunCloudConfig;
import com.aichu.manager.constant.WangYiYunCloudConstant;
import com.aichu.manager.enums.MessageTypeEnum;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.manager.enums.UserBlackListTypeEnum;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName WangYiYunCloudMessageService
 * @Description 网易云消息信息Service
 * @Author Melon
 * @Date 2019/7/19 11:03
 * @Version 1.0.0
 **/
@Service
public class WangYiYunCloudMessageService {

    private Logger logger = LoggerFactory.getLogger(WangYiYunCloudMessageService.class);

    @Autowired
    private WangYiYunCloudConfig wangYiYunCloudConfig;

    private static String appKey = null;

    private static String appSecret = null;

    private static String nonce = null;

    private static String curTime = null;

    private static String checkSum = null;

    @Autowired
    private AcUserMapper acUserMapper;

    @PostConstruct
    public void init() {

        //初始化网易云参数信息
        appKey = wangYiYunCloudConfig.getAppKey();
        appSecret = wangYiYunCloudConfig.getAppSecret();
        nonce = "12345";
    }

    /***
     * @Author Melon
     * @Description 用户发送普通消息
     * API 文档: https://api.netease.im/nimserver/msg/sendMsg.action HTTP/1.1
     * @Date 18:01 2020/1/4
     * @Param [acUid]
     * @Return java.lang.Boolean
     **/
    public Boolean wangYiYunCloudSendCommonMessage(String aimAcId, String acUid) throws Exception{
        logger.info("----用户发送普通消息---Start--- :aimAcId - {}, acUid - {}", aimAcId, acUid);

        //查询用户信息
        AcUserExample acUserExample = new AcUserExample();
        acUserExample.createCriteria()
                .andAcUidEqualTo(acUid)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserDO> acUserDOList = acUserMapper.selectByExample(acUserExample);
        if (Utils.isEmpty(acUserDOList)){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        //初始化Http请求
        curTime = String.valueOf((new Date()).getTime() / 1000L);
        checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = WangYiYunCloudHttpConfig.WangYiYunCloudHttpInit(WangYiYunCloudConstant.WANG_YI_YUN_COMMON_URL, appKey, nonce, curTime, checkSum);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("from", Strings.toLowerCase(acUid)));
        nvps.add(new BasicNameValuePair("ope", String.valueOf(MessageTypeEnum.MESSAGE_TYPE_USER.getCode())));
        nvps.add(new BasicNameValuePair("to", Strings.toLowerCase(aimAcId)));
        nvps.add(new BasicNameValuePair("type", String.valueOf(MessageTypeEnum.MESSAGE_CONTENT_TYPE_TEXT.getCode())));
        nvps.add(new BasicNameValuePair("body", "{\"msg\":\""+ acUserDOList.get(0).getNickName() + "已经关注了你！" + "\"}"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject responseJsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        if (!responseJsonObject.getString("code").equals("200")){
            throw new BusinessException(ResultCodeEnum.AIM_USER_MESSAGE_PUSH_FILED.code(), ResultCodeEnum.AIM_USER_MESSAGE_PUSH_FILED.message());
        }

        logger.info("----用户发送普通消息---End--- :result - {}", response.toString());
        return true;
    }
}
