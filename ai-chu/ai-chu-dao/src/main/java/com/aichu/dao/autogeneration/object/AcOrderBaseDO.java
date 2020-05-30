package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcOrderBaseDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 用户ID */
    private Integer userId;

    /** 订单编号 */
    private String orderNo;

    /** 订单金额（单位：分） */
    private Integer orderAmount;

    /** 订单金币（单位：金币） */
    private Integer orderCoin;

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

    /** 收款人用户ID */
    private Integer receiveUserId;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private Date createTime;

    private static final long serialVersionUID = 1L;

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

    public Integer getOrderCoin() {
        return orderCoin;
    }

    public void setOrderCoin(Integer orderCoin) {
        this.orderCoin = orderCoin;
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

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", orderCoin=").append(orderCoin);
        sb.append(", consumeType=").append(consumeType);
        sb.append(", payUse=").append(payUse);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payType=").append(payType);
        sb.append(", preferentialCardType=").append(preferentialCardType);
        sb.append(", receiveUserId=").append(receiveUserId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}