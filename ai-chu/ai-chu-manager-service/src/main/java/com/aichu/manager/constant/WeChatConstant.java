package com.aichu.manager.constant;

/**
 * @ClassName WeChatConstant
 * @Description 微信支付配置常量参数
 * @Author Melon
 * @Date 2019/8/30 18:07
 * @Version 1.1.0
 **/
public class WeChatConstant {

    //通过code获取access_token: https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
    public static final String CODE_BY_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    //刷新或续期access_token使用: https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
    public static final String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    //检验授权凭证（access_token）是否有效: https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
    public static final String CHECK_ACCESS_TOKEN_IS_VALID_URL = "https://api.weixin.qq.com/sns/auth";

    //获取用户个人信息（UnionID机制）: https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
}
