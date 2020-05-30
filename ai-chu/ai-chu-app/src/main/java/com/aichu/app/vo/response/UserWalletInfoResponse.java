package com.aichu.app.vo.response;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.UserWalletBillDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName UserWalletInfoResponse
 * @Description 用户钱包信息响应response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserWalletInfoResponse {

  @ApiModelProperty(name = "userId", value = "用户金币")
  private Integer userCoin;

  @ApiModelProperty(name = "userMoney", value = "用户金额（单位：分）")
  private Integer userMoney;

  @ApiModelProperty(name = "userWalletBillDTOList", value = "账单记录")
  private BaseResponse<List<UserWalletBillDTO>> userWalletBillDTOList;

  public Integer getUserCoin() {
    return userCoin;
  }

  public void setUserCoin(Integer userCoin) {
    this.userCoin = userCoin;
  }

  public Integer getUserMoney() {
    return userMoney;
  }

  public void setUserMoney(Integer userMoney) {
    this.userMoney = userMoney;
  }

  public BaseResponse<List<UserWalletBillDTO>> getUserWalletBillDTOList() {
    return userWalletBillDTOList;
  }

  public void setUserWalletBillDTOList(BaseResponse<List<UserWalletBillDTO>> userWalletBillDTOList) {
    this.userWalletBillDTOList = userWalletBillDTOList;
  }
}
