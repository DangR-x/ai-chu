package com.aichu.admin.vo.response;

/**
 * @ClassName AcUserContactBackResponse
 * @Author yuan.shuai
 * @Description 用户联系人
 * @Date 2019/12/9
 * @Version 1.0.0
 */
public class AcUserContactBackResponse {

    /** 联系人类型（0-亲属联系人，1-紧急联系人，2-工作联系人）*/
    private Integer contactType;

    /** 公司名称*/
    private String companyName;

    /** 公司联系人*/
    private String companyPhone;

    /** 联系人名称*/
    private String contactName;

    /** 联系人关系*/
    private String contactRealation;

    /** 联系人号码*/
    private String contactPhone;

    /** 创建时间*/
    private String createTime;

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactRealation() {
        return contactRealation;
    }

    public void setContactRealation(String contactRealation) {
        this.contactRealation = contactRealation;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
