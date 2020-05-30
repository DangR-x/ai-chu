package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName BackUserQueryRequest
 * @Author yuan.shuai
 * @Description 后台用户列查询
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class BackUserQueryRequest extends BasePageOrder {

    /**关键词*/
    @ApiModelProperty(name = "name", value = "关键词",hidden = false)
    private String name;

    @ApiModelProperty(name = "level", value = "代理等级",hidden = false)
    private Integer level;

    @ApiModelProperty(name = "isFreeze", value = "是否冻结（0-否，1-是）",hidden = false)
    private Integer isFreeze;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }
}
