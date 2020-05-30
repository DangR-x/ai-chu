package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcPreferentialCardDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 优惠卡名称 */
    private String cardName;

    /** 优惠卡原价（单位：分） */
    private Integer cardOriginalPrice;

    /** 优惠卡现价（单位：分） */
    private Integer cardSalePrice;

    /** 优惠卡描述 */
    private String cardDetail;

    /** 每天领取金币数值 */
    private Integer everyDayFreeCoin;

    /** 总共可领取金币数值 */
    private Integer totalFreeCoin;

    /** 可签到次数 */
    private Integer signTime;

    /** 优惠卡类型（0-周卡，1-月卡） */
    private Integer cardType;

    /** 优惠卡已卖出数量 */
    private Integer cardSaleNum;

    /** 优惠卡总数量 */
    private Integer cardtTotalNum;

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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardOriginalPrice() {
        return cardOriginalPrice;
    }

    public void setCardOriginalPrice(Integer cardOriginalPrice) {
        this.cardOriginalPrice = cardOriginalPrice;
    }

    public Integer getCardSalePrice() {
        return cardSalePrice;
    }

    public void setCardSalePrice(Integer cardSalePrice) {
        this.cardSalePrice = cardSalePrice;
    }

    public String getCardDetail() {
        return cardDetail;
    }

    public void setCardDetail(String cardDetail) {
        this.cardDetail = cardDetail;
    }

    public Integer getEveryDayFreeCoin() {
        return everyDayFreeCoin;
    }

    public void setEveryDayFreeCoin(Integer everyDayFreeCoin) {
        this.everyDayFreeCoin = everyDayFreeCoin;
    }

    public Integer getTotalFreeCoin() {
        return totalFreeCoin;
    }

    public void setTotalFreeCoin(Integer totalFreeCoin) {
        this.totalFreeCoin = totalFreeCoin;
    }

    public Integer getSignTime() {
        return signTime;
    }

    public void setSignTime(Integer signTime) {
        this.signTime = signTime;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getCardSaleNum() {
        return cardSaleNum;
    }

    public void setCardSaleNum(Integer cardSaleNum) {
        this.cardSaleNum = cardSaleNum;
    }

    public Integer getCardtTotalNum() {
        return cardtTotalNum;
    }

    public void setCardtTotalNum(Integer cardtTotalNum) {
        this.cardtTotalNum = cardtTotalNum;
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
        sb.append(", cardName=").append(cardName);
        sb.append(", cardOriginalPrice=").append(cardOriginalPrice);
        sb.append(", cardSalePrice=").append(cardSalePrice);
        sb.append(", cardDetail=").append(cardDetail);
        sb.append(", everyDayFreeCoin=").append(everyDayFreeCoin);
        sb.append(", totalFreeCoin=").append(totalFreeCoin);
        sb.append(", signTime=").append(signTime);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardSaleNum=").append(cardSaleNum);
        sb.append(", cardtTotalNum=").append(cardtTotalNum);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}