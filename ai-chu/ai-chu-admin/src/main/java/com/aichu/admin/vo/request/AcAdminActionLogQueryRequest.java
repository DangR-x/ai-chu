package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName WzAdminActionLogQueryRequest
 * @Author yuan.shuai
 * @Description 操作日志检索DTO
 * @Date 2019/11/9
 * @Version 1.1.0
 */
public class AcAdminActionLogQueryRequest extends BasePageOrder {

    @ApiModelProperty(name = "name", value = "关键词",hidden = false)
    private String name;

    @ApiModelProperty(name = "adminUserId", value = "管理员ID",hidden = false)
    private Integer adminUserId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }
}
