package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.response.AppVersionInfoResponse;
import com.aichu.app.vo.response.ChargeConfigResponse;
import com.aichu.app.vo.response.CustomerInfoResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcSysSystemConfigService;
import com.aichu.service.dto.AcSysSystemConfigDTO;
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

import java.util.List;


/**
 * @ClassName SystemConfigController
 * @Description 爱触系统配置信息Controller
 * @Author Melon
 * @Date 2019/7/22 18:07
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/system")
@Api(value = "爱触系统配置信息Controller", tags = "爱触系统配置信息相关接口")
public class SystemConfigController {

    @Autowired
    private AcSysSystemConfigService acSysSystemConfigService;

    /***
     * @Author Melon
     * @Description 爱触协议信息
     * @Date 20:31 2019/10/8
     * @Param []
     * @Return com.aichu.common.util.api.ApiResult<java.lang.String>
     **/
    @RequestMapping(value = "/policy/{policyType}", method = RequestMethod.GET)
    @ApiOperation(value = "爱触系统配置信息", notes = "爱触系统配置信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization",required = true,paramType = "header"),
            @ApiImplicitParam(name="policyType", dataType = "Integer", value = "配置信息(0-隐私政策协议，1-用户协议，2-充值协议，9-推广链接)", required = true)
    })
    public ApiResult<String> systemPrivacyPolicy(@PathVariable("policyType") Integer policyType, @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acSysSystemConfigService.systemPolicy(policyType, acUserRequestDao.getId()));
    }

    /***
     * @Author Melon
     * @Description 客服联系信息
     * @Date 16:15 2020/2/21
     * @Param []
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.CustomerInfoResponse>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/customer/info", method = RequestMethod.GET)
    @ApiOperation(value = "客服联系信息", notes = "客服联系信息", httpMethod = "GET")
    public ApiResult<CustomerInfoResponse> customerInfo() throws Exception{
        return ApiResult.success(BeanUtil.copy(acSysSystemConfigService.customerInfo(), CustomerInfoResponse.class));
    }

    /**
     * @Description APP版本查验--appType(0-安卓，1-IOS)
     * @Author Melon
     * @Date 2020/3/3 18:38
     * @Param [appType, version]
     * @return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.AppVersionInfoResponse>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/app/version/{appType}/{version}", method = RequestMethod.GET)
    @ApiOperation(value = "APP版本查验", notes = "APP版本查验", httpMethod = "GET")
    public ApiResult<AppVersionInfoResponse> customerAppVersion(@PathVariable("appType") Integer appType,
                                                                @PathVariable("version") Integer version) throws Exception{
        return ApiResult.success(BeanUtil.copy(acSysSystemConfigService.customerAppVersion(appType, version), AppVersionInfoResponse.class));
    }
}
