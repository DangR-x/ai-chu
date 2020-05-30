package com.aichu.service.dto;

/**
 * @ClassName BalanceWithDrawRequest
 * @Description 余额提现请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class BalanceWithDrawDTO {

    private String accountName;

    private String account;

    private Integer withDrawType;

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
