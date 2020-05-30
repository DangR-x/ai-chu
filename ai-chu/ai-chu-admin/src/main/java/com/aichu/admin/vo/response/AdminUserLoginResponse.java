package com.aichu.admin.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName AdminUserLoginResponse
 * @Author yuan.shuai
 * @Description 用户登录响应
 * @Date 2019/11/31
 * @Version 1.0.0
 */
@ApiModel("登录响应实体")
public class AdminUserLoginResponse {

    @ApiModelProperty(value = "登录token")
    private String token;

    @ApiModelProperty(value = "权限模块")
    private List<Integer> moduleList;

    @ApiModelProperty(value = "用户账号")
    private String userName;

    @ApiModelProperty(value = "用户昵称")
    private String aliasName;

    @ApiModelProperty(value = "管理员类型")
    private Integer type;

    @ApiModelProperty(value = "角色集合")
    private List<String> roleList;

    @ApiModelProperty(value = "操作权限")
    private List<String> permissionList;

    @ApiModelProperty(value = "用户头像")
    private String headImg;

    @ApiModelProperty(value = "登录SessionId")
    private String sessionId;

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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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
