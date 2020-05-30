package com.aichu.service.dto;

/**
 * @ClassName AcUserAttentionBackDTO
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/31
 * @Version 1.0.0
 */
public class AcUserAttentionBackDTO {

    /** 主键ID */
    private Integer id;

    /** 系统内部Uid */
    private String acUid;

    /** 昵称 */
    private String nickName;

    /** 手机号 */
    private String phone;

    /** 出生年月日 */
    private String birthday;

    /** 性别（0-男，1-女） */
    private Integer sex;

    private Integer isFreeze;

    /** 创建时间 */
    private String createTime;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAcUid() {
        return acUid;
    }

    public void setAcUid(String acUid) {
        this.acUid = acUid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
