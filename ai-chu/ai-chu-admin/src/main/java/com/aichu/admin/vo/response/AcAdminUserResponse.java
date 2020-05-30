package com.aichu.admin.vo.response;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2019/10/31
 */
public class AcAdminUserResponse {
    /** 管理员用户表ID */
    private Integer id;

    /** 用户账号 */
    private String userName;

    /** 密码 */
    private String password;

    /** 昵称别名 */
    private String aliasName;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 管理员类型（0-管理员，1-开发商，2-商户）*/
    private Integer type;

    /** 创建时间 */
    private String createTime;

    private String headImg;

    private String roleNameList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(String roleNameList) {
        this.roleNameList = roleNameList;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}