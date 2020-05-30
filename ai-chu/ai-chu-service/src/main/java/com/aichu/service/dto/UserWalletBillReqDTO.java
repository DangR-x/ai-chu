package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName UserWalletBillReqDTO
 * @Description 用户账单请求数据模型DTO
 * @Author Melon
 * @Date 2019/7/19 10:52s
 * @Version 1.0.0
 **/
public class UserWalletBillReqDTO extends BasePageOrder {

    private String chooseDate;

    public String getChooseDate() {
        return chooseDate;
    }

    public void setChooseDate(String chooseDate) {
        this.chooseDate = chooseDate;
    }
}
