package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName LabelDetailRequest
 * @Author yuan.shuai
 * @Description 系统标签库修改
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class LabelDetailRequest {

    /** 主键ID */
    @ApiModelProperty(name="id",value="系统标签ID",hidden=false)
    private Integer id;

    /** 标签LOGO */
    @ApiModelProperty(name="name",value="标签LOGO",hidden=false)
    private String logo;

    /** 标签名称 */
    @ApiModelProperty(name="name",value="系统标签名称",required=true,hidden=false)
    @NotBlank(message = "标签名称不能为空")
    private String name;

    @ApiModelProperty(name="actionDesc",value="标签操作信息",required=true,hidden=false)
    @NotBlank(message = "标签操作信息不能为空")
    private String actionDesc;

    /** 标签详情操作信息*/
    @ApiModelProperty(name="actionDetailDesc",value="标签详情操作信息",required=true,hidden=false)
    @NotBlank(message = "标签详情操作信息不能为空")
    private String actionDetailDesc;

    /** 标签Code */
    @ApiModelProperty(name="code",value="系统标签Code",required=true,hidden=false)
    @NotBlank(message = "标签Code不能为空")
    private String code;

    /** 是否热门（0-否，1-是） */
    @ApiModelProperty(name="isHot",value="是否热门（0-否，1-是）",hidden=false)
    private Integer isHot;

    /** 标签类型(0-项目标签，1-服务特权，2-项目性质) */
    @ApiModelProperty(name="type",value="标签类型(0-项目标签，1-服务特权，2-项目性质)",required=true,hidden=false)
    @NotNull(message = "标签类型不能为空")
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public String getActionDetailDesc() {
        return actionDetailDesc;
    }

    public void setActionDetailDesc(String actionDetailDesc) {
        this.actionDetailDesc = actionDetailDesc;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
