package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/01/13
 */
public class AcPreferentialCardRequest{

    /** 主键ID */
    @ApiModelProperty(name = "id", value = "主键ID ",hidden = false)
    private Integer id;

    /** 优惠卡名称 */
    @ApiModelProperty(name = "cardName", value = "优惠卡名称",required = true,hidden = false)
    @NotBlank(message = "优惠卡名称不能为空")
    private String cardName;

    /** 优惠卡原价（单位：分） */
    @ApiModelProperty(name = "cardOriginalPrice", value = "优惠卡原价（单位：分）",required = true,hidden = false)
    @NotNull(message = "优惠卡原价不能为空")
    private Integer cardOriginalPrice;

    /** 优惠卡现价（单位：分） */
    @ApiModelProperty(name = "cardSalePrice", value = "优惠卡现价（单位：分）",required = true,hidden = false)
    @NotNull(message = "优惠卡现价不能为空")
    private Integer cardSalePrice;

    /** 优惠卡描述 */
    @ApiModelProperty(name = "cardDetail", value = "优惠卡描述",required = true,hidden = false)
    @NotBlank(message = "优惠卡描述不能为空")
    private String cardDetail;

    /** 每天领取金币数值 */
    @ApiModelProperty(name = "everyDayFreeCoin", value = "每天领取金币数值",required = true,hidden = false)
    @NotNull(message = "每天领取金币数值不能为空")
    private Integer everyDayFreeCoin;

    /** 总共可领取金币数值 */
    @ApiModelProperty(name = "totalFreeCoin", value = "总共可领取金币数值",required = true,hidden = false)
    @NotNull(message = "总共可领取金币数值不能为空")
    private Integer totalFreeCoin;

    /** 可签到次数 */
    @ApiModelProperty(name = "signTime", value = "可签到次数 ",required = true,hidden = false)
    @NotNull(message = "可签到次数不能为空")
    private Integer signTime;

    /** 优惠卡类型（0-周卡，1-月卡） */
    @ApiModelProperty(name = "cardType", value = "优惠卡类型（0-周卡，1-月卡） ",required = true,hidden = false)
    @NotNull(message = "优惠卡类型不能为空")
    private Integer cardType;

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

}