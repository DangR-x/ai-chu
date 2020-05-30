package com.aichu.service.dto;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 14:20
 **/
public class AcOrderBaseBackDTO {

    /** 主键ID */
    private Integer id;

    /** 用户ID */
    private Integer userId;

    /** 用户手机号*/
    private String userPhone;

    /** 订单编号 */
    private String orderNo;

    /** 订单金额（单位：金币） */
    private Integer orderAmount;

    /** 消费类型（0-充值，1-提现，2-优惠卡，3-直播打赏，4-直播付费, 5-代理提成） */
    private Integer consumeType;

    /** 交易类别（0-消费，1-充值，2-提现） */
    private Integer payUse;

    /** 订单状态（0-未支付，1-已支付，2，已取消，3-未退款，4-退款中，5-已退款，6-已拒绝，7-已完成） */
    private Integer payStatus;

    /** 支付方式（0-余额，1-微信，2-支付宝） */
    private Integer payType;

    /** 优惠卡类型（0-周卡，1-月卡） */
    private Integer preferentialCardType;

    /** 创建时间 */
    private String createTime;

    /** 支付编号*/
    private String payTradeNo;

    /** 第三方流水号*/
    private String outTradNo;

    /** 订单状态*/
    private Integer orderType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }

    public Integer getPayUse() {
        return payUse;
    }

    public void setPayUse(Integer payUse) {
        this.payUse = payUse;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPreferentialCardType() {
        return preferentialCardType;
    }

    public void setPreferentialCardType(Integer preferentialCardType) {
        this.preferentialCardType = preferentialCardType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTradeNo() {
        return payTradeNo;
    }

    public void setPayTradeNo(String payTradeNo) {
        this.payTradeNo = payTradeNo;
    }

    public String getOutTradNo() {
        return outTradNo;
    }

    public void setOutTradNo(String outTradNo) {
        this.outTradNo = outTradNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
