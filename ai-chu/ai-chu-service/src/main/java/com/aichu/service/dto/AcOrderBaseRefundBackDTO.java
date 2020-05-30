package com.aichu.service.dto;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 15:03
 **/
public class AcOrderBaseRefundBackDTO {

    /** 主键ID */
    private Integer id;

    /** 用户手机号*/
    private String userPhone;

    /** 订单编号*/
    private String orderNo;

    /** 退款金额（单位：分） */
    private Integer refundAmount;

    /** 退款原因 */
    private String refundReason;

    /** 退款状态（0-退款中，1-已拒绝，2-已通过, 3-退款失败） */
    private Integer refundStatus;

    /** 处理时间 */
    private String dealTime;

    /** 创建时间 */
    private String createTime;

    private Integer consumeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }
}
