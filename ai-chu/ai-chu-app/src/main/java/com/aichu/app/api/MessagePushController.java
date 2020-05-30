package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.service.api.AcUserDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @ClassName MessagePushController
 * @Description 爱触消息推送信息Controller
 * @Author Melon
 * @Date 2019/7/22 18:07
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/push")
@Api(value = "爱触消息推送信息Controller", tags = "爱触消息推送信息相关接口")
public class MessagePushController {

    @Autowired
    private AcUserDeviceService acUserDeviceService;

    /***
     * @Author Melon
     * @Description 消息推送绑定设备信息
     * @Date 20:31 2019/10/8
     * @Param []
     * @Return com.aichu.common.util.api.ApiResult<java.lang.String>
     **/
    @RequestMapping(value = "/device/bind/{deviceNo}/{deviceType}", method = RequestMethod.GET)
    @ApiOperation(value = "消息推送绑定设备信息", notes = "消息推送绑定设备信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization",required = true,paramType = "header"),
            @ApiImplicitParam(name="deviceNo", dataType = "String", value = "设备编号", required = true),
            @ApiImplicitParam(name="deviceType", dataType = "Integer", value = "设备类型（0-Android，1-IOS）", required = true)
    })
    public ApiResult<Boolean> deviceBindDeviceNo(@PathVariable("deviceNo") String deviceNo,
                                                 @PathVariable("deviceType") Integer deviceType,
                                                 @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserDeviceService.deviceBindDeviceNo(deviceNo, deviceType, acUserRequestDao.getId()));
    }
}
