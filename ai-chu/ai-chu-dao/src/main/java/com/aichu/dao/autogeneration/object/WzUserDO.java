package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2019/11/23
 */
public class WzUserDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 问祖系统内部Uid */
    private String wzUid;

    /** 姓氏 */
    private String firstName;

    /** 名称 */
    private String lastName;

    /** 昵称 */
    private String nickName;

    /** 头像 */
    private String headImg;

    /** 亲圈封面图 */
    private String coverFamily;

    /** 社会圈封面图 */
    private String coverSociety;

    /** 身份证号 */
    private String idCard;

    /** 手机号 */
    private String phone;

    /** 登录密码 */
    private String passWord;

    /** 出生年月日(阳历) */
    private String birthday;

    /** 过世年月日(阳历) */
    private String deathday;

    /** 过世日期标准（0-阳历，1-农历） */
    private Integer deathCriterion;

    /** 过世年月日(农历) */
    private String deathdayLunar;

    /** 出生年月日(农历) */
    private String birthdayLunar;

    /** 出生日期标准（0-阳历，1-农历） */
    private Integer birthCriterion;

    /** 排行 */
    private Integer number;

    /** 性别（0-男，1-女） */
    private Integer sex;

    /** 行业 */
    private String business;

    /** 职业 */
    private String occupation;

    /** 毕业院校 */
    private String school;

    /** 个性签名 */
    private String signature;

    /** 余额（单位：分） */
    private Integer amount;

    /** 积分 */
    private Integer score;

    /** 家族族系ID */
    private Integer familyTreeId;

    /** 家族家庭ID（问祖内部家庭维系识别码） */
    private String familyHouseId;

    /** 生源地（省） */
    private Integer exProvinceId;

    /** 生源地（市） */
    private Integer exCityId;

    /** 生源地（区） */
    private Integer exAreaId;

    /** 生源地（详细地址） */
    private String exAddress;

    /** 现住址（省） */
    private Integer nowProvinceId;

    /** 现住址（市） */
    private Integer nowCityId;

    /** 现住址（区） */
    private Integer nowAreaId;

    /** 现住址（详细地址） */
    private String nowAddress;

    /** 经度 */
    private Double longitude;

    /** 纬度 */
    private Double latitude;

    /** 操作人用户ID */
    private Integer actionUserId;

    /** 是否注册用户（0-否，1-是） */
    private Integer isRegister;

    /** 是否新用户（0-否，1-是) */
    private Integer isNewUser;

    /** 是否健在（0-否，1-是) */
    private Integer isAlive;

    /** 是否冻结（0-否，1-是) */
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

    public String getWzUid() {
        return wzUid;
    }

    public void setWzUid(String wzUid) {
        this.wzUid = wzUid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCoverFamily() {
        return coverFamily;
    }

    public void setCoverFamily(String coverFamily) {
        this.coverFamily = coverFamily;
    }

    public String getCoverSociety() {
        return coverSociety;
    }

    public void setCoverSociety(String coverSociety) {
        this.coverSociety = coverSociety;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public Integer getDeathCriterion() {
        return deathCriterion;
    }

    public void setDeathCriterion(Integer deathCriterion) {
        this.deathCriterion = deathCriterion;
    }

    public String getDeathdayLunar() {
        return deathdayLunar;
    }

    public void setDeathdayLunar(String deathdayLunar) {
        this.deathdayLunar = deathdayLunar;
    }

    public String getBirthdayLunar() {
        return birthdayLunar;
    }

    public void setBirthdayLunar(String birthdayLunar) {
        this.birthdayLunar = birthdayLunar;
    }

    public Integer getBirthCriterion() {
        return birthCriterion;
    }

    public void setBirthCriterion(Integer birthCriterion) {
        this.birthCriterion = birthCriterion;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getFamilyTreeId() {
        return familyTreeId;
    }

    public void setFamilyTreeId(Integer familyTreeId) {
        this.familyTreeId = familyTreeId;
    }

    public String getFamilyHouseId() {
        return familyHouseId;
    }

    public void setFamilyHouseId(String familyHouseId) {
        this.familyHouseId = familyHouseId;
    }

    public Integer getExProvinceId() {
        return exProvinceId;
    }

    public void setExProvinceId(Integer exProvinceId) {
        this.exProvinceId = exProvinceId;
    }

    public Integer getExCityId() {
        return exCityId;
    }

    public void setExCityId(Integer exCityId) {
        this.exCityId = exCityId;
    }

    public Integer getExAreaId() {
        return exAreaId;
    }

    public void setExAreaId(Integer exAreaId) {
        this.exAreaId = exAreaId;
    }

    public String getExAddress() {
        return exAddress;
    }

    public void setExAddress(String exAddress) {
        this.exAddress = exAddress;
    }

    public Integer getNowProvinceId() {
        return nowProvinceId;
    }

    public void setNowProvinceId(Integer nowProvinceId) {
        this.nowProvinceId = nowProvinceId;
    }

    public Integer getNowCityId() {
        return nowCityId;
    }

    public void setNowCityId(Integer nowCityId) {
        this.nowCityId = nowCityId;
    }

    public Integer getNowAreaId() {
        return nowAreaId;
    }

    public void setNowAreaId(Integer nowAreaId) {
        this.nowAreaId = nowAreaId;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
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

    public Integer getActionUserId() {
        return actionUserId;
    }

    public void setActionUserId(Integer actionUserId) {
        this.actionUserId = actionUserId;
    }

    public Integer getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(Integer isRegister) {
        this.isRegister = isRegister;
    }

    public Integer getIsNewUser() {
        return isNewUser;
    }

    public void setIsNewUser(Integer isNewUser) {
        this.isNewUser = isNewUser;
    }

    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
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
        sb.append(", wzUid=").append(wzUid);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", nickName=").append(nickName);
        sb.append(", headImg=").append(headImg);
        sb.append(", coverFamily=").append(coverFamily);
        sb.append(", coverSociety=").append(coverSociety);
        sb.append(", idCard=").append(idCard);
        sb.append(", phone=").append(phone);
        sb.append(", passWord=").append(passWord);
        sb.append(", birthday=").append(birthday);
        sb.append(", deathday=").append(deathday);
        sb.append(", deathCriterion=").append(deathCriterion);
        sb.append(", deathdayLunar=").append(deathdayLunar);
        sb.append(", birthdayLunar=").append(birthdayLunar);
        sb.append(", birthCriterion=").append(birthCriterion);
        sb.append(", number=").append(number);
        sb.append(", sex=").append(sex);
        sb.append(", business=").append(business);
        sb.append(", occupation=").append(occupation);
        sb.append(", school=").append(school);
        sb.append(", signature=").append(signature);
        sb.append(", amount=").append(amount);
        sb.append(", score=").append(score);
        sb.append(", familyTreeId=").append(familyTreeId);
        sb.append(", familyHouseId=").append(familyHouseId);
        sb.append(", exProvinceId=").append(exProvinceId);
        sb.append(", exCityId=").append(exCityId);
        sb.append(", exAreaId=").append(exAreaId);
        sb.append(", exAddress=").append(exAddress);
        sb.append(", nowProvinceId=").append(nowProvinceId);
        sb.append(", nowCityId=").append(nowCityId);
        sb.append(", nowAreaId=").append(nowAreaId);
        sb.append(", nowAddress=").append(nowAddress);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", actionUserId=").append(actionUserId);
        sb.append(", isRegister=").append(isRegister);
        sb.append(", isNewUser=").append(isNewUser);
        sb.append(", isAlive=").append(isAlive);
        sb.append(", isFreeze=").append(isFreeze);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}