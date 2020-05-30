package com.aichu.dao.workstation.object;

/**
 * @ClassName UserRecordListInfoDTO
 * @Author yuan.shuai
 * @Description 用户排行榜DTO
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class UserRecordListInfoDao {

    private Integer userId;

    private String userAccId;

    private String userName;

    private String userHeadImg;

    private String userSignature;

    private Integer totalCostCoin;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccId() {
        return userAccId;
    }

    public void setUserAccId(String userAccId) {
        this.userAccId = userAccId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public Integer getTotalCostCoin() {
        return totalCostCoin;
    }

    public void setTotalCostCoin(Integer totalCostCoin) {
        this.totalCostCoin = totalCostCoin;
    }
}
