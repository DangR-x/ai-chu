package com.aichu.admin.vo.response;

/**
 * @ClassName LabelResponse
 * @Author yuan.shuai
 * @Description 系统标签库响应体
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class LabelResponse {

    /** 主键ID */
    private Integer id;

    /** 标签名称 */
    private String name;

    /** 标签操作信息*/
    private String actionDesc;

    /** 标签详情操作信息*/
    private String actionDetailDesc;

    /** 标签Code */
    private String code;

    /** 标签类型(0-身高，1-体重标签，2-职业标签，3-星座标签，4-印象标签，5-评论标签，6-签到金币) */
    private Integer type;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private String createTime;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
