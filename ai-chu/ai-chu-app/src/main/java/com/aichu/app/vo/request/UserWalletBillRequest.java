package com.aichu.app.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserWalletBillRequest
 * @Description 用户账单请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52s
 * @Version 1.0.0
 **/
public class UserWalletBillRequest extends BasePageOrder {

    @ApiModelProperty(name="chooseDate",value="日期选择（年-月）",required=false,hidden=false)
    private String chooseDate;

    public String getChooseDate() {
        return chooseDate;
    }

    public void setChooseDate(String chooseDate) {
        this.chooseDate = chooseDate;
    }
}
