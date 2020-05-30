package com.aichu.app.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName MainFacelRequest
 * @Description 首页信息请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52s
 * @Version 1.0.0
 **/
public class MainFacelRequest extends BasePageOrder {

    @ApiModelProperty(name="longitude",value="经度",required=true,hidden=false)
    private Double longitude;

    @ApiModelProperty(name="latitude",value="纬度",required=true,hidden=false)
    private Double latitude;

    @ApiModelProperty(name="mainFaceType",value="筛选类型（0-关注，1-推荐）",required=true,hidden=false)
    private Integer mainFaceType;

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

    public Integer getMainFaceType() {
        return mainFaceType;
    }

    public void setMainFaceType(Integer mainFaceType) {
        this.mainFaceType = mainFaceType;
    }
}
