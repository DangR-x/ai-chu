package com.aichu.app.vo.response;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.UserRecordListInfoDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName UserCharmRankResponse
 * @Description 用户富豪排行榜响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserRichRankResponse {

  @ApiModelProperty(name = "totalCostCoin", value = "我消费的金币")
  private Integer totalCostCoin;

  @ApiModelProperty(name = "userRecordListInfoDTOList", value = "用户排行榜信息")
  private BaseResponse<List<UserRecordListInfoDTO>> userRecordListInfoDTOList;

  public Integer getTotalCostCoin() {
    return totalCostCoin;
  }

  public void setTotalCostCoin(Integer totalCostCoin) {
    this.totalCostCoin = totalCostCoin;
  }

  public BaseResponse<List<UserRecordListInfoDTO>> getUserRecordListInfoDTOList() {
    return userRecordListInfoDTOList;
  }

  public void setUserRecordListInfoDTOList(BaseResponse<List<UserRecordListInfoDTO>> userRecordListInfoDTOList) {
    this.userRecordListInfoDTOList = userRecordListInfoDTOList;
  }
}
