package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AcUserUnderlingQueryRequest
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/24
 * @Version 1.0.0
 */
public class AcUserUnderlingQueryRequest extends BasePageOrder {

    @ApiModelProperty(name="userId",value="用户ID",required = true,hidden=false)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
