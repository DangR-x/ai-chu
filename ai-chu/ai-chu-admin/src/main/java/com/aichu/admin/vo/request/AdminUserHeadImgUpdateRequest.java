package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName AdminUserHeadImgUpdateRequest
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/25
 * @Version 1.0.0
 */
public class AdminUserHeadImgUpdateRequest {

    @ApiModelProperty(name = "id", value = "管理员ID",required = true, hidden = false)
    @NotNull(message = "管理员ID不能为空")
    private Integer id;

    @ApiModelProperty(name = "headImg", value = "管理员头像",required = true, hidden = false)
    @NotBlank(message = "管理员头像不能为空")
    private String headImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
