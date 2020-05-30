package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName UserRankListRequest
 * @Description 用户魅力/富豪排行榜请求数据模型DTO
 * @Author Melon
 * @Date 2019/7/19 10:52s
 * @Version 1.0.0
 **/
public class UserRankListReqDTO extends BasePageOrder {

    private Integer timeType;

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }
}
