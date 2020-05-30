package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcOrderWithdrawDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 订单ID */
    private Integer orderId;

    /** 提现单据号（第三方返回） */
    private String withDrawOutTradeNo;

    /** 提现描述 */
    private String withDrawDes;

    /** 提现金额 */
    private Integer withDrawMoney;

    /** 提现状态（0-提现中，1-已拒绝，2-提现成功, 3-提现失败） */
    private Integer withDrawStatus;

    /** 账户姓名 */
    private String withDrawNickName;

    /** 账户信息 */
    private String withDrawAccount;

    /** 提现类型（0-微信，1-支付宝） */
    private Integer withDrawType;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getWithDrawNickName() {
        return withDrawNickName;
    }

    public void setWithDrawNickName(String withDrawNickName) {
        this.withDrawNickName = withDrawNickName;
    }

    public String getWithDrawAccount() {
        return withDrawAccount;
    }

    public void setWithDrawAccount(String withDrawAccount) {
        this.withDrawAccount = withDrawAccount;
    }

    public Integer getWithDrawType() {
        return withDrawType;
    }

    public void setWithDrawType(Integer withDrawType) {
        this.withDrawType = withDrawType;
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
        sb.append(", orderId=").append(orderId);
        sb.append(", withDrawOutTradeNo=").append(withDrawOutTradeNo);
        sb.append(", withDrawDes=").append(withDrawDes);
        sb.append(", withDrawMoney=").append(withDrawMoney);
        sb.append(", withDrawStatus=").append(withDrawStatus);
        sb.append(", withDrawNickName=").append(withDrawNickName);
        sb.append(", withDrawAccount=").append(withDrawAccount);
        sb.append(", withDrawType=").append(withDrawType);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}