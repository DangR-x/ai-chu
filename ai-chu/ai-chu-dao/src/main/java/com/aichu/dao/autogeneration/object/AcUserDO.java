package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcUserDO implements Serializable {
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

    /** IMToken */
    private String imToken;

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

    /** 经度 */
    private Double longitude;

    /** 纬度 */
    private Double latitude;

    /** 印象标签ID字符串 */
    private String impressionLabelId;

    /** 个性签名 */
    private String signature;

    /** 代理等级（0-7） */
    private Integer agentLevel;

    /** 是否是代理商户（0-否，1-是） */
    private Integer isAgency;

    /** 是否是主播（0-否，1-是） */
    private Integer isAnchor;

    /** 是否存在于黑名单(0-否，1-是) */
    private Integer isBlackList;

    /** 是否冻结（0-否，1-是） */
    private Integer isFreeze;

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

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getImpressionLabelId() {
        return impressionLabelId;
    }

    public void setImpressionLabelId(String impressionLabelId) {
        this.impressionLabelId = impressionLabelId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    public Integer getIsAgency() {
        return isAgency;
    }

    public void setIsAgency(Integer isAgency) {
        this.isAgency = isAgency;
    }

    public Integer getIsAnchor() {
        return isAnchor;
    }

    public void setIsAnchor(Integer isAnchor) {
        this.isAnchor = isAnchor;
    }

    public Integer getIsBlackList() {
        return isBlackList;
    }

    public void setIsBlackList(Integer isBlackList) {
        this.isBlackList = isBlackList;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", acUid=").append(acUid);
        sb.append(", nickName=").append(nickName);
        sb.append(", headImg=").append(headImg);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", coin=").append(coin);
        sb.append(", imToken=").append(imToken);
        sb.append(", chartCost=").append(chartCost);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", heightLabelId=").append(heightLabelId);
        sb.append(", weightLabelId=").append(weightLabelId);
        sb.append(", occupationLabelId=").append(occupationLabelId);
        sb.append(", constellationLabelId=").append(constellationLabelId);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", areaId=").append(areaId);
        sb.append(", address=").append(address);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", impressionLabelId=").append(impressionLabelId);
        sb.append(", signature=").append(signature);
        sb.append(", agentLevel=").append(agentLevel);
        sb.append(", isAgency=").append(isAgency);
        sb.append(", isAnchor=").append(isAnchor);
        sb.append(", isBlackList=").append(isBlackList);
        sb.append(", isFreeze=").append(isFreeze);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}