package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName AcUserAttentionQueryRequest
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/31
 * @Version 1.0.0
 */
public class AcUserAttentionQueryRequest extends BasePageOrder {

    @ApiModelProperty(name="userId",value="用户ID",required = true,hidden=false)
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
