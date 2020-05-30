package com.aichu.manager.constant;

/**
 * @ClassName AliConstant
 * @Description Ali支付常量参数信息
 * @Author Melon
 * @Date 2019/8/30 18:07
 * @Version 1.1.0
 **/
public class AliConstant {

    //服务对应的名称，常量值为com.alipay.account.auth
    public static final String API_NAME = "com.alipay.account.auth";

    //调用来源方的标识，常量值为mc
    public static final String MC = "mc";

    //标识授权类型，取值范围：AUTHACCOUNT代表授权；LOGIN代表登录
    public static final String AUTH_TYPE = "AUTHACCOUNT";

    //调用业务的类型，常量值为openservice
    public static final String BIZ_TYPE = "openservice";

    //接口名称，常量值为alipay.open.auth.sdk.code.get
    public static final String METHOD = "alipay.open.auth.sdk.code.get";

    //产品码，常量值为APP_FAST_LOGIN
    public static final String PRODUCT_ID = "APP_FAST_LOGIN";

    //授权范围，常量值为kuaijie
    public static final String SCOPE = "kuaijie";

    //商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
    public static final String SIGN_TYPE = "RSA2";
}
