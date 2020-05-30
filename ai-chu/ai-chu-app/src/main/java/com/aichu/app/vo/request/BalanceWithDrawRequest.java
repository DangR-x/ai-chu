package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName BalanceWithDrawRequest
 * @Description 余额提现请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class BalanceWithDrawRequest {

    @ApiModelProperty(name="accountName",value="账户姓名",required=true,hidden=false)
    @NotNull(message="账户姓名不能为空")
    private String accountName;

    @ApiModelProperty(name="account",value="账户",required=true,hidden=false)
    @NotNull(message="账户不能为空")
    private String account;

    @ApiModelProperty(name="withDrawType",value="提现类型（0-微信，1-支付宝）",required=true,hidden=false)
    @NotNull(message="提现类型不能为空")
    private Integer withDrawType;

    @ApiModelProperty(name="amount",value="提现金额(单位：分)",required=true,hidden=false)
    @NotNull(message="提现金额不能为空")
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getWithDrawType() {
        return withDrawType;
    }

    public void setWithDrawType(Integer withDrawType) {
        this.withDrawType = withDrawType;
    }
}
