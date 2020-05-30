package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName MainFacelDTO
 * @Description 首页信息请求数据模型DTO
 * @Author Melon
 * @Date 2019/7/19 10:52s
 * @Version 1.0.0
 **/
public class MainFacelDTO extends BasePageOrder {

    private Double longitude;

    private Double latitude;

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
