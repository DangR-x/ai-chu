package com.aichu.manager.api.sms;

import com.aichu.common.util.common.HttpClientUtils;
import com.aichu.manager.config.YueFanSmsConfig;
import com.aichu.manager.dao.SmsCodeCacheDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName YueFanSmsService
 * @Description 悦凡短信验证码Service
 * @Author Melon
 * @Date 2019/7/19 13:44
 * @Version 1.0.0
 **/
@Service
public class YueFanSmsService {

    private static Logger logger = LoggerFactory.getLogger(YueFanSmsService.class);

    @Autowired
    private YueFanSmsConfig yueFanSmsConfig;

    @Autowired
    private SmsCodeCacheDao authCodeDao;

    /***
     * @Author Melon
     * @Description 悦凡短信-单发短信
     * @Date 15:15 2020/1/4
     * @Param [content, phone]
     * @Return boolean
     **/
    public boolean sendSingleSms(String phone){
        logger.info("-----悦凡短信发送-----Start");

        //清空redis缓存验证码
        authCodeDao.deleteAuthCodeCache(phone);
        //验证码
        String authCode = authCodeDao.getAuthCode(phone, 6, yueFanSmsConfig.getYueFanSmsVerifCodeTime().longValue());
        logger.info("--验证码-sevice--authCode-{}", authCode);

        Map<String, String> params = new HashMap<>();
        params.put("account", yueFanSmsConfig.getYueFanSmsAccount());
        params.put("password", yueFanSmsConfig.getYueFanSmsPassWord());
        params.put("smsType", yueFanSmsConfig.getYueFanSmsType());
        params.put("message", "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<MtMessage>\n" +
                "<content>" + yueFanSmsConfig.getYueFanSmsSign() + "你的短信验证码为：" + authCode + "，"
                + yueFanSmsConfig.getYueFanSmsVerifCodeTime() + "分钟内有效，如非本人请忽略！</content>\n" +
                "<subCode>5250</subCode>\n" +
                "<phoneNumber>" + phone + "</phoneNumber>\n" +
                "</MtMessage>");

        String requestResult = null;
        try {
            requestResult = HttpClientUtils.xmlByHttpPost("http://sms.easyct.net:8001/http/submitSms", HttpClientUtils.buildQueryString(params));
            int startIndex = requestResult.indexOf("<subStat>");
            int endIndex = requestResult.indexOf("</subStat>");
            String subStat = requestResult.substring(startIndex + "<subStat>".length(), endIndex);
            if ("r:000".equals(subStat)) {
                logger.info("发送短信成功，[phone:[" + phone + "],authCode:[" + authCode + "]]");
                return true;
            } else {
                logger.error("发送短信失败，[phone:[" + phone + "],authCode:[" + authCode + "],response:[" + requestResult + "]]");
                return false;
            }
        } catch (Exception e) {
            logger.error("发送短信失败，[phone:[" + phone + "],authCode:[" + authCode + "],response:[" + requestResult + "]]", e);
            return false;
        }
    }

    /**
     * @MethodName: getAuthCode
     * @Author: Melon
     * @Date: 2019-1-10 10:46
     * @Param: phone
     * @return: String
     * @Version: V1.1.0
     * @Description: 根据手机号获取验证码
     **/
    public String getAuthCode(String phone) {
        return authCodeDao.getAuthCode(phone);
    }
}
