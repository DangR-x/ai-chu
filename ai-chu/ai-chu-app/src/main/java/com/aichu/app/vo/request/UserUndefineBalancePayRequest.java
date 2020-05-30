package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName UserUndefineBalancePayRequest
 * @Description 用户统一余额支付请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserUndefineBalancePayRequest {

    @ApiModelProperty(name="payType",value="支付类型（0-聊天，1-打赏）",required=true,hidden=false)
    @NotNull(message="支付类型不可为空")
    private Integer payType;

    @ApiModelProperty(name="AimUserAccId",value="目标用户AccId",required=true,hidden=false)
    @NotNull(message="目标用户AccId不可为空")
    private String aimUserAccId;

    @ApiModelProperty(name="chartTime",value="通话时长（单位：秒）",required=false,hidden=false)
    private Integer chartTime;

    @ApiModelProperty(name="chartCost",value="聊天费用（单位：金币/分钟）----支付类型为 0 时必传",required=false,hidden=false)
    private Integer chartCost;

    @ApiModelProperty(name="goodsId",value="商品ID ----支付类型为 1 时必传",required=false,hidden=false)
    private Integer goodsId;

    @ApiModelProperty(name="goodsNum",value="商品数量 ----支付类型为 1 时必传",required=false,hidden=false)
    private Integer goodsNum;

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getAimUserAccId() {
        return aimUserAccId;
    }

    public void setAimUserAccId(String aimUserAccId) {
        this.aimUserAccId = aimUserAccId;
    }

    public Integer getChartTime() {
        return chartTime;
    }

    public void setChartTime(Integer chartTime) {
        this.chartTime = chartTime;
    }

    public Integer getChartCost() {
        return chartCost;
    }

    public void setChartCost(Integer chartCost) {
        this.chartCost = chartCost;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
