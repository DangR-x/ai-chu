package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName AdminUserAddOrUpdateRequest
 * @Author yuan.shuai
 * @Description 管理员新增或修改信息
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class AdminUserAddOrUpdateRequest {
    /** 管理员用户表ID */
    @ApiModelProperty(name = "id", value = "管理员ID", hidden = false)
    private Integer id;

    /** 用户账号 */
    @ApiModelProperty(name = "userName", value = "用户账号",required = true, hidden = false)
    @NotBlank(message = "用户账号不能为空")
    private String userName;

    /** 密码 */
    @ApiModelProperty(name = "passWord", value = "密码",required = true, hidden = false)
    @NotBlank(message = "密码不能为空")
    private String passWord;

    /** 昵称别名 */
    @ApiModelProperty(name = "aliasName", value = "昵称别名",required = true, hidden = false)
    @NotBlank(message = "昵称别名不能为空")
    private String aliasName;

    @ApiModelProperty(name = "roleIdList", value = "角色ID集合", hidden = false)
    private List<Integer> roleIdList;

    @ApiModelProperty(name = "headImg", value = "管理员头像", hidden = false)
    private String headImg;

    /** 管理员类型（0-管理员，1-开发商，2-商户）*/
    @ApiModelProperty(name = "type",value = "管理员类型",hidden = false)
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
