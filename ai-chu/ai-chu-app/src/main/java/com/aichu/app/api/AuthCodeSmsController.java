package com.aichu.app.api;

import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.manager.api.sms.YueFanSmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName AuthCodeSmsController
 * @Description 爱触短信信息发送接口
 * @Author Melon
 * @Date 2019/7/22 18:07
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/sms")
@Api(value = "爱触短信Controller", tags = "爱触短信信息发送接口")
public class AuthCodeSmsController {

    @Autowired
    private YueFanSmsService yueFanSmsService;

    /***
     * @Author Melon
     * @Description 发送短信验证码-单发
     * @Date 15:46 2019/7/20
     * @Param [phone]
     * @Return ResultResponse<Boolean>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/send/single", method = RequestMethod.GET)
    @ApiOperation(value = "发送短信验证码-单发", notes = "发送短信验证码-单发", httpMethod = "GET")
    public ApiResult<Boolean> sendAuthCode(@RequestParam("phone") String phone) throws Exception{
        return ApiResult.success(yueFanSmsService.sendSingleSms(phone));
    }
}
