package com.aichu.service.dto;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 15:30
 **/
public class AcOrderWithdrawBackDTO {

    /** 主键ID */
    private Integer id;

    /** 用户手机号*/
    private String userPhone;

    /** 订单编号*/
    private String orderNo;

    /** 提现单据号（第三方返回） */
    private String withDrawOutTradeNo;

    /** 提现描述 */
    private String withDrawDes;

    /** 提现金额 */
    private Integer withDrawMoney;

    /** 提现状态（0-提现中，1-已拒绝，2-提现成功, 3-提现失败） */
    private Integer withDrawStatus;

    /** 提现类型（0-微信，1-支付宝） */
    private Integer withDrawType;

    /** 创建时间 */
    private String createTime;

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

    public String getWithDrawOutTradeNo() {
        return withDrawOutTradeNo;
    }

    public void setWithDrawOutTradeNo(String withDrawOutTradeNo) {
        this.withDrawOutTradeNo = withDrawOutTradeNo;
    }

    public String getWithDrawDes() {
        return withDrawDes;
    }

    public void setWithDrawDes(String withDrawDes) {
        this.withDrawDes = withDrawDes;
    }

    public Integer getWithDrawMoney() {
        return withDrawMoney;
    }

    public void setWithDrawMoney(Integer withDrawMoney) {
        this.withDrawMoney = withDrawMoney;
    }

    public Integer getWithDrawStatus() {
        return withDrawStatus;
    }

    public void setWithDrawStatus(Integer withDrawStatus) {
        this.withDrawStatus = withDrawStatus;
    }

    public Integer getWithDrawType() {
        return withDrawType;
    }

    public void setWithDrawType(Integer withDrawType) {
        this.withDrawType = withDrawType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
