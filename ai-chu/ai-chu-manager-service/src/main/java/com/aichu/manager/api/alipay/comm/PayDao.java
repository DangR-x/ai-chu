package com.aichu.manager.api.alipay.comm;

public class PayDao {
    /**
     * 微信支付统一下单URL
     */
    public static final String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 支付宝url
     */
    public static final String SERVER_URL = "https://openapi.alipay.com/gateway.do";

    /**
     * 提现url
     */
    public static final String WITHDRAW_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

    /**
     * 支付订单查询
     */
    public static final String ORDER_PAY_QUERY = "https://api.mch.weixin.qq.com/pay/orderquery";

    /**
     * 加密方式
     */
    public static final  String SIGN_TYPE = "RSA2";
    /**
     * 返回格式，仅支持JSON
     */
    public static final  String FORMAT = "JSON";
    /**
     * 编码格式
     */
    public static final  String CHARSET = "UTF-8";

}
