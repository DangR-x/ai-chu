package com.aichu.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhangyujie
 * @create 2019/3/27
 */
@ApiModel("登录响应实体")
public class AdminUserLoginDTO {

    @ApiModelProperty(value = "登录token")
    private String token;

    @ApiModelProperty(value = "权限模块")
    private List<Integer> moduleList;

    @ApiModelProperty(value = "用户账号")
    private String userName;

    @ApiModelProperty(value = "用户昵称")
    private String aliasName;

    @ApiModelProperty(value = "用户类型")
    private Integer type;

    @ApiModelProperty(value = "用户头像")
    private String headImg;

    @ApiModelProperty(value = "角色集合")
    private List<String> roleList;

    @ApiModelProperty(value = "操作权限")
    private List<String> permissionList;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Integer> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Integer> moduleList) {
        this.moduleList = moduleList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
