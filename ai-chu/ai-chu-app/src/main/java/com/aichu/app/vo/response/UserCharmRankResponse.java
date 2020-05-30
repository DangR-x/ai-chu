package com.aichu.app.vo.response;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.UserRecordListInfoDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName UserCharmRankResponse
 * @Description 用户魅力排行榜响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserCharmRankResponse {

  @ApiModelProperty(name = "totalReceiveCoin", value = "我收到的魅力值")
  private Integer totalReceive;

  @ApiModelProperty(name = "userRecordListInfoDTOList", value = "用户排行榜信息")
  private BaseResponse<List<UserRecordListInfoDTO>> userRecordListInfoDTOList;

  public Integer getTotalReceive() {
    return totalReceive;
  }

  public void setTotalReceive(Integer totalReceive) {
    this.totalReceive = totalReceive;
  }

  public BaseResponse<List<UserRecordListInfoDTO>> getUserRecordListInfoDTOList() {
    return userRecordListInfoDTOList;
  }

  public void setUserRecordListInfoDTOList(BaseResponse<List<UserRecordListInfoDTO>> userRecordListInfoDTOList) {
    this.userRecordListInfoDTOList = userRecordListInfoDTOList;
  }
}
