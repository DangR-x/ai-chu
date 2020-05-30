package com.aichu.service.dto;

/**
 * @ClassName UserUndefineBalancePayDTO
 * @Description 用户统一余额支付请求数据模型DTO
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserUndefineBalancePayDTO {

    private Integer payType;

    private String aimUserAccId;

    private Integer chartTime;

    private Integer chartCost;

    private Integer goodsId;

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
