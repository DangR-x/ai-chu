package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName VideoRecordRequest
 * @Description 用户视频通话记录添加请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class VideoRecordRequest {

    @ApiModelProperty(name="telUserAcUid",value="拨打用户AcUiD",required=true,hidden=false)
    @NotNull(message="拨打用户ID不能为空")
    private String telUserAcUid;

    @ApiModelProperty(name="telTime",value="通话时长",required=true,hidden=false)
    @NotBlank(message="通话时长不能为空")
    private String telTime;

    public String getTelUserAcUid() {
        return telUserAcUid;
    }

    public void setTelUserAcUid(String telUserAcUid) {
        this.telUserAcUid = telUserAcUid;
    }

    public String getTelTime() {
        return telTime;
    }

    public void setTelTime(String telTime) {
        this.telTime = telTime;
    }
}
