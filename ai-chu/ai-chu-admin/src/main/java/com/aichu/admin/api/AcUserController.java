package com.aichu.admin.api;

import com.aichu.admin.config.OperationLog;
import com.aichu.admin.vo.request.*;
import com.aichu.admin.vo.response.*;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcUserService;
import com.aichu.service.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName YjzhUserController
 * @Author yuan.shuai
 * @Description 会员管理
 * @Date 2019/12/7
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/user/manager")
@Api(value = "后台会员管理",tags = "后台会员管理接口")
public class AcUserController {

    @Autowired
    private AcUserService acUserService;

    /**
     * @Description 后台用户列表查询
     * @Author yuan.shuai
     * @Date 2019/12/9 15:24
     * @Param BackUserQueryRequest
     * @Return ApiResult<BaseResponse<List<YjzhBackUserResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户列表查询",notes = "后台用户列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcBackUserResponse>>> getUserBackList(@RequestBody(required = true) @Valid Request<BackUserQueryRequest> request) throws Exception{
        BaseResponse<List<AcBackUserDTO>> responseService = acUserService.getBackUserList(BeanUtil.copy(request.getData(), BackUserQueryDTO.class));
        BaseResponse<List<AcBackUserResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcBackUserResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户关注列表查询
     * @Author yuan.shuai
     * @Date 2019/12/9 15:42
     * @Param YjzhUserContactBackQueryRequest
     * @Return ApiResult<BaseResponse<List<YjzhUserContactBackResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/contact/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户关注列表查询",notes = "后台用户关注列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcUserContactBackResponse>>> getUserContactBackList(@RequestBody(required = true) @Valid Request<AcUserContactBackQueryRequest> request) throws Exception{
        BaseResponse<List<AcUserContactBackDTO>> responseService = acUserService.getUserContactBackList(BeanUtil.copy(request.getData(), AcUserContactBackQueryDTO.class));
        BaseResponse<List<AcUserContactBackResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcUserContactBackResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户第三方信息列表
     * @Author yuan.shuai
     * @Date 2019/12/9 15:54
     * @Param userId
     * @Return ApiResult<List<YjzhUserOauthResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/user/oauth/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "后台用户第三方信息列表",notes = "后台用户第三方信息列表",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<List<AcUserOauthResponse>> getUserOauthBackList(@PathVariable("userId") Integer userId) throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserService.getUserOauthBackList(userId),AcUserOauthResponse.class));
    }

    /**
     * @Description 后台用户冻结/解冻
     * @Author yuan.shuai
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @OperationLog("用户冻结/解冻")
    @RequestMapping(value = "/user/frozen", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户冻结/解冻",notes = "后台用户冻结/解冻",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> frozenUser(@RequestBody(required = true) @Valid Request<AcUserFrozenRequest> request) throws Exception{
        return ApiResult.success(acUserService.frozenUser(BeanUtil.copy(request.getData(), AcUserFrozenDTO.class)));
    }

    /**
     * @Description 后台用户密码修改
     * @Author yuan.shuai
     * @Date 2019/12/16 19:23
     * @Param YjzhUpdateUserPasswordRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @OperationLog("修改用户密码")
    @RequestMapping(value = "/user/update/password", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户密码修改",notes = "后台用户密码修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> updateUserPassword(@RequestBody(required = true) @Valid Request<AcUpdateUserPasswordRequest> request) throws Exception{
        return ApiResult.success(acUserService.updateUserPasswordBack(BeanUtil.copy(request.getData(),AcUpdateUserPasswordDTO.class)));
    }

    /**
     * @Description 后台用户下级用户信息列表
     * @Author yuan.shuai
     * @Date 2019/12/24 22:30
     * @Param YjzhUserUnderlingQueryRequest
     * @Return BaseResponse<List<YjzhUserUnderlingResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/underling/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户下级用户信息列表",notes = "后台用户下级用户信息列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcUserUnderlingResponse>>> getUserUnderlingList(@RequestBody(required = true) @Valid Request<AcUserUnderlingQueryRequest> request) throws Exception{
        BaseResponse<List<AcUserUnderlingBackDTO>> responseService = acUserService.getUserUnderlingListBack(BeanUtil.copy(request.getData(), AcUserUnderlingQueryDTO.class));
        BaseResponse<List<AcUserUnderlingResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcUserUnderlingResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户关注列表
     * @Author yuan.shuai
     * @Date 2019/12/31 14:14
     * @Param AcUserAttentionQueryRequest
     * @Return ApiResult<BaseResponse<List<AcUserUnderlingResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/attention/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户关注列表",notes = "后台用户关注列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcUserUnderlingResponse>>> getUserAttentitionBackList(@RequestBody(required = true) @Valid Request<AcUserAttentionQueryRequest> request) throws Exception{
        BaseResponse<List<AcUserAttentionBackDTO>> responseService = acUserService.getUserAttentitionBackList(BeanUtil.copy(request.getData(), AcUserAttentionBackQueryDTO.class));
        BaseResponse<List<AcUserUnderlingResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcUserUnderlingResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户代理主播列表
     * @Author yuan.shuai
     * @Date 2020/2/17 20:55
     * @Param AcUserAttentionQueryRequest
     * @Return BaseResponse<List<AcUserUnderlingResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/anchor/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户代理主播列表",notes = "后台用户代理主播列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcUserUnderlingResponse>>> getUserAnchorBackList(@RequestBody(required = true) @Valid Request<AcUserAttentionQueryRequest> request) throws Exception{
        BaseResponse<List<AcUserAttentionBackDTO>> responseService = acUserService.getUserAnchorBackList(BeanUtil.copy(request.getData(), AcUserAttentionBackQueryDTO.class));
        BaseResponse<List<AcUserUnderlingResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcUserUnderlingResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户签到列表
     * @Author yuan.shuai
     * @Date 2020/2/17 20:55
     * @Param AcUserAttentionQueryRequest
     * @Return BaseResponse<List<AcUserSignRecordResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/sign/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户签到列表",notes = "后台用户签到列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcUserSignRecordResponse>>> getUserSignRecordList(@RequestBody(required = true) @Valid Request<AcUserAttentionQueryRequest> request) throws Exception{
        BaseResponse<List<AcUserSignRecordBackDTO>> responseService = acUserService.getUserSignRecordBackList(BeanUtil.copy(request.getData(), AcUserAttentionBackQueryDTO.class));
        BaseResponse<List<AcUserSignRecordResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcUserSignRecordResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户被关注列表
     * @Author yuan.shuai
     * @Date 2019/12/31 14:14
     * @Param AcUserAttentionQueryRequest
     * @Return ApiResult<BaseResponse<List<AcUserAttentionResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/passive/attention/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户被关注列表",notes = "后台用户被关注列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcUserAttentionResponse>>> getUserPassiveAttentitionBackList(@RequestBody(required = true) @Valid Request<AcUserAttentionQueryRequest> request) throws Exception{
        BaseResponse<List<AcUserAttentionBackDTO>> responseService = acUserService.getUserPassiveAttentitionBackList(BeanUtil.copy(request.getData(), AcUserAttentionBackQueryDTO.class));
        BaseResponse<List<AcUserAttentionResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcUserAttentionResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户信息详情
     * @Author yuan.shuai
     * @Date 2019/12/31 15:05
     * @Param id
     * @Return AcBackUserResponse
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/detail", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户信息详情",notes = "后台用户信息详情",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<AcBackUserResponse> getUserBackDetail(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserService.getUserBackDetail(request.getData()),AcBackUserResponse.class));
    }

    /**
     * @Description 后台用户通话记录列表
     * @Author yuan.shuai
     * @Date 2020/2/22 21:47
     * @Param AcOnlyIdQueryReuqest
     * @Return BaseResponse<List<AcUserPhoneRecordResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/user/phone/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户通话记录列表",notes = "后台用户通话记录列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcUserPhoneRecordResponse>>> getUserPhoneRecordList(@RequestBody(required = true) @Valid Request<AcOnlyIdQueryReuqest> request) throws Exception{
        BaseResponse<List<AcUserPhoneRecordBackDTO>> responseService = acUserService.getUserPhoneRecordList(BeanUtil.copy(request.getData(), AcOnlyIdQueryDTO.class));
        BaseResponse<List<AcUserPhoneRecordResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcUserPhoneRecordResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户设置/取消主播
     * @Author yuan.shuai
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @OperationLog("用户设置/取消主播")
    @RequestMapping(value = "/user/anchor", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户设置/取消主播",notes = "后台用户设置/取消主播",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> setIsAnchor(@RequestBody(required = true) @Valid Request<AcUtilIdAndStatusRequest> request) throws Exception{
        return ApiResult.success(acUserService.setIsAnchor(BeanUtil.copy(request.getData(), AcUtilIdAndStatusDTO.class)));
    }

    /**
     * @Description 后台用户设置/取消主播
     * @Author yuan.shuai
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @OperationLog("用户设置/取消代理")
    @RequestMapping(value = "/user/agency", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户设置/取消代理",notes = "后台用户设置/取消代理",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> setIsAgency(@RequestBody(required = true) @Valid Request<AcUtilIdAndStatusRequest> request) throws Exception{
        return ApiResult.success(acUserService.setIsAgency(BeanUtil.copy(request.getData(), AcUtilIdAndStatusDTO.class)));
    }
    /**
     * @Description 后台用户设置/取消黑名單
     * @Author hsw
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @OperationLog("后台用户设置/取消黑名單")
    @RequestMapping(value = "user/join/blacklist", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户设置/取消黑名單",notes = "后台用户设置/取消黑名單",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> setIsBlackList(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(acUserService.setUserBlacklist(request.getData()));
    }
    /**
     * @Description 首頁报表-总注册人数
     * @Author hsw
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/user/people/count", method = RequestMethod.GET)
    @ApiOperation(value = "首頁报表-总注册人数",notes = "首頁报表-总注册人数", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Integer> getPeopleCount() throws Exception{
        return ApiResult.success(acUserService.getPeopleCount());
    }
    /**
     * @Description 首頁报表-日活跃数数、日注册数
     * @Author hsw
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/user/register/count", method = RequestMethod.GET)
    @ApiOperation(value = "首頁报表-日活跃数数、日注册数",notes = "首頁报表-日活跃数数、日注册数", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<HomeStatementDataResponse> getRegisterCount() throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserService.getRegisterConut(),HomeStatementDataResponse.class));
    }
    /**
     * @Description 当日主播提成金币、代理提成金币
     * @Author hsw
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/user/consume/count", method = RequestMethod.GET)
    @ApiOperation(value = "当日主播提成金币、代理提成金币",notes = "当日主播提成金币、代理提成金币", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<AgencyDataResponse> getConsumeCount() throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserService.getConsumeCount(),AgencyDataResponse.class));
    }
    /**
     * @Description 日充值金币
     * @Author hsw
     * @Date 2019/12/9 16:13
     * @Param YjzhUserFrozenRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/user/recharge/count", method = RequestMethod.GET)
    @ApiOperation(value = "日充值金币",notes = "日充值金币", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<String> getRechargeCount() throws Exception{
        return ApiResult.success(acUserService.getRechargeCount());
    }

}
