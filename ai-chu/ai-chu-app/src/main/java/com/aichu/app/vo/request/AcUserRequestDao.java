package com.aichu.app.vo.request;

import java.util.Date;

/**
 * @ClassName WzUserRequest
 * @Description 问祖用户实体请求Request
 * @Author Melon
 * @Date 2019/7/29 11:38
 * @Version 1.0.0
 **/
public class AcUserRequestDao {

    /** 主键ID */
    private Integer id;

    /** 爱触内部UID */
    private String acUid;

    /** 昵称 */
    private String nickName;

    /** 头像 */
    private String headImg;

    /** 手机号 */
    private String phone;

    /** 性别（0-男，1-女） */
    private Integer sex;

    /** 金币 */
    private Integer coin;

    /** 聊天费用（单位：分钟） */
    private Integer chartCost;

    /** 出生日期 */
    private String birthDate;

    /** 身高ID（单位：cm） */
    private Integer heightLabelId;

    /** 体重ID（单位：kg） */
    private Integer weightLabelId;

    /** 职业ID */
    private Integer occupationLabelId;

    /** 星座ID */
    private Integer constellationLabelId;

    /** 现住址（省） */
    private Integer provinceId;

    /** 现住址（市） */
    private Integer cityId;

    /** 现住址（区） */
    private Integer areaId;

    /** 现住址（详细地址） */
    private String address;

    /** 印象标签ID */
    private Integer impressionLabelId;

    /** 个性签名 */
    private String signature;

    /** 邀请用户ID */
    private Integer leaderId;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcUid() {
        return acUid;
    }

    public void setAcUid(String acUid) {
        this.acUid = acUid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getChartCost() {
        return chartCost;
    }

    public void setChartCost(Integer chartCost) {
        this.chartCost = chartCost;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getHeightLabelId() {
        return heightLabelId;
    }

    public void setHeightLabelId(Integer heightLabelId) {
        this.heightLabelId = heightLabelId;
    }

    public Integer getWeightLabelId() {
        return weightLabelId;
    }

    public void setWeightLabelId(Integer weightLabelId) {
        this.weightLabelId = weightLabelId;
    }

    public Integer getOccupationLabelId() {
        return occupationLabelId;
    }

    public void setOccupationLabelId(Integer occupationLabelId) {
        this.occupationLabelId = occupationLabelId;
    }

    public Integer getConstellationLabelId() {
        return constellationLabelId;
    }

    public void setConstellationLabelId(Integer constellationLabelId) {
        this.constellationLabelId = constellationLabelId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getImpressionLabelId() {
        return impressionLabelId;
    }

    public void setImpressionLabelId(Integer impressionLabelId) {
        this.impressionLabelId = impressionLabelId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}