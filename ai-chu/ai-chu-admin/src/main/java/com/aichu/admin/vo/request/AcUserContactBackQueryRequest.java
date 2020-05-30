package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AcUserContactBackQueryRequest
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/9
 * @Version 1.0.0
 */
public class AcUserContactBackQueryRequest extends BasePageOrder {

    @ApiModelProperty(name="userId",value="用户Id",hidden=false)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
