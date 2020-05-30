package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserBasicsInformationRequest
 * @Description 用户修改基础资料数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserBasicsInformationRequest {

    @ApiModelProperty(name="userHead",value="用户头像",required=true,hidden=false)
    @NotBlank(message="用户头像不可为空")
    private String userHead;

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

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }
}
