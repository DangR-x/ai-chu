package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName AliBalanceWithDrawRequest
 * @Description 阿里余额提现请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class AliBalanceWithDrawRequest {

    @ApiModelProperty(name="amount",value="提现金额",required=true,hidden=false)
    @NotNull(message="提现金额不能为空")
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
