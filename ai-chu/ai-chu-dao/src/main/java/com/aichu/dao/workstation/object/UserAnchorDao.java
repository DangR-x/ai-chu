package com.aichu.dao.workstation.object;

/**
 * @ClassName UserAnchorDao
 * @Description 用户主播信息资料
 * @Author Melon
 * @Date 2020/1/2 18:54
 * @Version 1.0.0
 **/
public class UserAnchorDao {

    private Integer userId;

    private String userAcId;

    private String userName;

    private Integer todayDeductCoin;

    private Integer totalDeductCoin;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAcId() {
        return userAcId;
    }

    public void setUserAcId(String userAcId) {
        this.userAcId = userAcId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTodayDeductCoin() {
        return todayDeductCoin;
    }

    public void setTodayDeductCoin(Integer todayDeductCoin) {
        this.todayDeductCoin = todayDeductCoin;
    }

    public Integer getTotalDeductCoin() {
        return totalDeductCoin;
    }

    public void setTotalDeductCoin(Integer totalDeductCoin) {
        this.totalDeductCoin = totalDeductCoin;
    }
}
