package com.aichu.admin.vo.response;

/**
 * @ClassName AcUserAttentionResponse
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/31
 * @Version 1.0.0
 */
public class AcUserAttentionResponse {

    private Integer id;

    private String nickName;

    private String phone;

    private Integer sex;

    private Integer isFreeze;

    private String createTime;

    private String attentionCreateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAttentionCreateTime() {
        return attentionCreateTime;
    }

    public void setAttentionCreateTime(String attentionCreateTime) {
        this.attentionCreateTime = attentionCreateTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
