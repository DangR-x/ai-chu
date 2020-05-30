package com.aichu.app.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName UserRankListRequest
 * @Description 用户魅力,富豪排行榜请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserRankListRequest extends BasePageOrder {

    @ApiModelProperty(name="timeType",value="时间赛选类型（0-日榜，1-周榜，2-月榜）",required=true,hidden=false)
    @NotNull(message="时间赛选类型不可为空")
    private Integer timeType;

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }
}
