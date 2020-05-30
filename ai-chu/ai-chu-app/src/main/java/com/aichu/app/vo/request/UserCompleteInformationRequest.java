package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserCompleteInformationRequest
 * @Description 用户完善资料数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserCompleteInformationRequest {

    @ApiModelProperty(name="userSex",value="用户性别（0-男，1-女）",required=true,hidden=false)
    @NotNull(message="用户性别不可为空")
    private Integer userSex;

    @ApiModelProperty(name="userName",value="用户昵称",required=true,hidden=false)
    @NotBlank(message="用户昵称不可为空")
    private String userName;

    @ApiModelProperty(name="userBirth",value="用户生日(年-月-日)",required=true,hidden=false)
    @NotBlank(message="用户生日不可为空")
    private String userBirth;

    @ApiModelProperty(name="provinceId",value="省份ID",required=true,hidden=false)
    @NotNull(message="省份ID不可为空")
    private Integer provinceId;

    @ApiModelProperty(name="cityId",value="城市ID",required=true,hidden=false)
    @NotNull(message="城市ID不可为空")
    private Integer cityId;

    @ApiModelProperty(name="areaId",value="区域ID",required=true,hidden=false)
    @NotNull(message="区域ID不可为空")
    private Integer areaId;

    @ApiModelProperty(name="longitude",value="经度",required=false,hidden=false)
    @NotNull(message="经度不可为空")
    private Double longitude;

    @ApiModelProperty(name="latitude",value="纬度",required=false,hidden=false)
    @NotNull(message="纬度不可为空")
    private Double latitude;

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

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
}
