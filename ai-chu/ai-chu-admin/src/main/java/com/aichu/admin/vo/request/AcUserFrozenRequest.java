package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AcUserFrozenRequest
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/9
 * @Version 1.0.0
 */
public class AcUserFrozenRequest {

    @ApiModelProperty(name="userId",value="用户Id",required = true,hidden=false)
    private Integer userId;

    @ApiModelProperty(name="isFreeze",value="用户状态（0-解冻，1-冻结）",required = true,hidden=false)
    private Integer isFreeze;

    @ApiModelProperty(name="freezeContent",value="冻结理由",hidden=false)
    private String freezeContent;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }

    public String getFreezeContent() {
        return freezeContent;
    }

    public void setFreezeContent(String freezeContent) {
        this.freezeContent = freezeContent;
    }
}
