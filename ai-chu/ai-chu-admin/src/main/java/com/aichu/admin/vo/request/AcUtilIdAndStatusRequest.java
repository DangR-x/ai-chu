package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @program: ai-chu
 * @description 通用修改状态Request
 * @author: Yuan.shuai
 * @create: 2020-02-18 14:47
 **/
public class AcUtilIdAndStatusRequest {

    @ApiModelProperty(name = "id", value = "主键ID",required = true,hidden = false)
    @NotNull(message = "主键ID不能为空")
    private Integer id;

    @ApiModelProperty(name = "status", value = "处理状态",required = true,hidden = false)
    @NotNull(message = "处理状态不能为空")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
