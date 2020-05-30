package com.aichu.admin.vo.response;

/**
 * @ClassName AcUserOauthResponse
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/9
 * @Version 1.0.0
 */
public class AcUserOauthResponse {

    /** 主键ID */
    private Integer id;

    /** 用户ID */
    private String userName;

    /** 微信OpenId */
    private String openId;

    /** 微信UnionId */
    private String unionId;

    /** 支付宝Code */
    private String aliCode;

    /** Apple授权的用户唯一标识*/
    private String appleUserId;

    /** 昵称 */
    private String nickName;

    /** 头像 */
    private String headImg;

    /** 渠道：(0-微信，1-支付宝，2-Apple) */
    private Integer oauthType;

    /** 创建时间 */
    private String createTime;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getAliCode() {
        return aliCode;
    }

    public void setAliCode(String aliCode) {
        this.aliCode = aliCode;
    }

    public String getAppleUserId() {
        return appleUserId;
    }

    public void setAppleUserId(String appleUserId) {
        this.appleUserId = appleUserId;
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

    public Integer getOauthType() {
        return oauthType;
    }

    public void setOauthType(Integer oauthType) {
        this.oauthType = oauthType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
