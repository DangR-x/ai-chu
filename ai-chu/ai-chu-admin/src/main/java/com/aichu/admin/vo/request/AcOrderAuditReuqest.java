package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 17:21
 **/
public class AcOrderAuditReuqest {

    @ApiModelProperty(name = "id", value = "订单ID",required = true,hidden = false)
    @NotNull(message = "订单ID不能为空")
    private Integer id;

    @ApiModelProperty(name = "status", value = "处理状态（1-拒绝，2-通过）",required = true,hidden = false)
    @NotNull(message = "处理状态不能为空")
    private Integer status;

    @ApiModelProperty(name = "comment", value = "处理意见",hidden = false)
    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
