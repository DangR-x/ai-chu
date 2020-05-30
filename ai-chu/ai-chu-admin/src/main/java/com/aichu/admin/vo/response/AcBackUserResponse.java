package com.aichu.admin.vo.response;

import java.util.List;

/**
 * @ClassName AcBackUserResponse
 * @Author yuan.shuai
 * @Description
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class AcBackUserResponse {
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

    /** 身高值（单位：cm） */
    private String heightLabelName;

    /** 体重值（单位：kg） */
    private String weightLabelName;

    /** 职业名称 */
    private String occupationLabelName;

    /** 星座名称 */
    private String constellationLabelName;

    private String address;

    /** 印象标签ID字符串 */
    private List<String> impressionLabels;

    /** 个性签名 */
    private String signature;

    /** 代理等级*/
    private Integer agentLevel;

    /** 是否是代理商户 */
    private Integer isAgency;

    /** 是否是主播 */
    private Integer isAnchor;

    /** 是否存在黑名單（0-否，1-是） */
    private Integer isBlackList;

    /** 是否冻结（0-否，1-是） */
    private Integer isFreeze;

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

    public Integer getIsBlackList() {
        return isBlackList;
    }

    public void setIsBlackList(Integer isBlackList) {
        this.isBlackList = isBlackList;
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

    public String getHeightLabelName() {
        return heightLabelName;
    }

    public void setHeightLabelName(String heightLabelName) {
        this.heightLabelName = heightLabelName;
    }

    public String getWeightLabelName() {
        return weightLabelName;
    }

    public void setWeightLabelName(String weightLabelName) {
        this.weightLabelName = weightLabelName;
    }

    public String getOccupationLabelName() {
        return occupationLabelName;
    }

    public void setOccupationLabelName(String occupationLabelName) {
        this.occupationLabelName = occupationLabelName;
    }

    public String getConstellationLabelName() {
        return constellationLabelName;
    }

    public void setConstellationLabelName(String constellationLabelName) {
        this.constellationLabelName = constellationLabelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getImpressionLabels() {
        return impressionLabels;
    }

    public void setImpressionLabels(List<String> impressionLabels) {
        this.impressionLabels = impressionLabels;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getIsAnchor() {
        return isAnchor;
    }

    public void setIsAnchor(Integer isAnchor) {
        this.isAnchor = isAnchor;
    }
}
