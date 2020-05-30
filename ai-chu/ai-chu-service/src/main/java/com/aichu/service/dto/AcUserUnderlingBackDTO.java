package com.aichu.service.dto;

/**
 * @ClassName AcUserUnderlingBackDTO
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/24
 * @Version 1.0.0
 */
public class AcUserUnderlingBackDTO {

    /** 主键ID */
    private Integer id;

    /** 亿家智慧系统内部Uid */
    private String yjzhUid;

    /** 昵称 */
    private String nickName;

    /** 手机号 */
    private String phone;

    /** 出生年月日 */
    private String birthday;

    /** 性别（0-男，1-女） */
    private Integer sex;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 下级人数*/
    private Integer underlingCount;

    /** 创建时间 */
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYjzhUid() {
        return yjzhUid;
    }

    public void setYjzhUid(String yjzhUid) {
        this.yjzhUid = yjzhUid;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getUnderlingCount() {
        return underlingCount;
    }

    public void setUnderlingCount(Integer underlingCount) {
        this.underlingCount = underlingCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
