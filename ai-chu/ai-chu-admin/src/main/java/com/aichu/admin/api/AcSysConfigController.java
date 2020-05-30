package com.aichu.admin.api;

import com.aichu.admin.config.OperationLog;
import com.aichu.admin.vo.request.*;
import com.aichu.admin.vo.response.*;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcSystemConfigService;
import com.aichu.service.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName YjzhSysSystemConfigController
 * @Author yuan.shuai
 * @Description 后台系统配置Controller
 * @Date 2019/9/19
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/config/manager/")
@Api(value = "后台系统配置管理",tags = "后台系统配置管理接口")
public class AcSysConfigController {

    private Logger logger = LoggerFactory.getLogger(AcSysConfigController.class);

    @Autowired
    private AcSystemConfigService yjzhSystemConfigService;

    /**
     * @Description 后台系统配置列表查询
     * @Param AcSysSystemConfigQueryRequest
     * @Return ApiResult<BaseResponse<List<AcSysSystemConfigResponse>>>
     * @Author yuan.shuai
     * @Date  2019/9/19
     * @Version 1.0.0
     */
    @RequestMapping(value = "querySystemConfigList", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统配置列表查询",notes = "后台系统配置列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcSysSystemConfigResponse>>> querySystemConfigList(@RequestBody(required = true) @Valid Request<AcSysSystemConfigQueryRequest> request) throws Exception{
        BaseResponse<List<AcSysSystemConfigDTO>> responseService = yjzhSystemConfigService.getSystemConfigBackList(BeanUtil.copy(request.getData(), AcSysSystemConfigQueryDTO.class));
        BaseResponse<List<AcSysSystemConfigResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcSysSystemConfigResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台系统配置删除
     * @Param id
     * @Return ApiResult<Boolean>
     * @Author yuan.shuai
     * @Date  2019/9/19
     * @Version 1.0.0
     */
    @OperationLog("系统配置删除")
    @RequestMapping(value = "deleteSystemConfig", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统配置删除",notes = "后台系统配置删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteSystemConfig(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.deleteSystemConfig(request.getData()));
    }

    /**
     * @Description 后台系统配置新增/修改
     * @Param AcSysSystemConfigRequest
     * @Return ApiResult<Boolean>
     * @Author yuan.shuai
     * @Date  2019/9/19
     * @Version 1.0.0
     */
    @OperationLog("系统配置新增/修改")
    @RequestMapping(value = "addOrUpdateSystemConfig", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统配置新增/修改",notes = "后台系统配置新增/修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdateSystemConfig(@RequestBody(required = true) @Valid Request<AcSysSystemConfigRequest> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.addOrUpdateSystemConfig(BeanUtil.copy(request.getData(), AcSysSystemConfigDTO.class)));
    }

    /**
     * @Description 后台优惠卡列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 20:35
     * @Param AcQueryOnlyNameRequest
     * @Return BaseResponse<List<AcPreferentialCardResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "query/preferential/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台优惠卡列表查询",notes = "后台优惠卡列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcPreferentialCardResponse>>> getPreferentialCardList(@RequestBody(required = true) @Valid Request<AcQueryOnlyNameRequest> request) throws Exception{
        BaseResponse<List<AcPreferentialCardBackDTO>> responseService = yjzhSystemConfigService.getPreferentialCardBackList(BeanUtil.copy(request.getData(), AcQueryOnlyNameDTO.class));
        BaseResponse<List<AcPreferentialCardResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcPreferentialCardResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台用户代理主播提成配置列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 20:35
     * @Param AcSysAgentConfigQueryRequest
     * @Return BaseResponse<List<AcSysAgentConfigResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "query/agent/config/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户代理主播提成配置列表查询",notes = "后台用户代理主播提成配置列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcSysAgentConfigResponse>>> getSysAgentConfigList(@RequestBody(required = true) @Valid Request<AcSysAgentConfigQueryRequest> request) throws Exception{
        BaseResponse<List<AcSysAgentConfigBackDTO>> responseService = yjzhSystemConfigService.getSysAgentConfigBackList(BeanUtil.copy(request.getData(), AcSysAgentConfigQueryDTO.class));
        BaseResponse<List<AcSysAgentConfigResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcSysAgentConfigResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台优惠卡新增/修改
     * @Author yuan.shuai
     * @Date 2020/2/17 20:34
     * @Param AcPreferentialCardRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "update/preferential", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台优惠卡新增/修改",notes = "后台优惠卡新增/修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdatePreferentialCard(@RequestBody(required = true) @Valid Request<AcPreferentialCardRequest> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.addOrUpdatePreferentialCardBack(BeanUtil.copy(request.getData(), AcPreferentialCardBackDTO.class)));
    }

    /**
     * @Description 后台优惠卡删除
     * @Author yuan.shuai
     * @Date 2020/2/17 20:34
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "delete/preferential", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台优惠卡删除",notes = "后台优惠卡删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deletePreferentialCard(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.deletePreferentialCardBack(request.getData()));
    }

    /**
     * @Description  后台用户代理主播提成配置卡新增/修改
     * @Author yuan.shuai
     * @Date 2020/2/17 20:34
     * @Param AcSysAgentConfigRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "update/agent/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户代理主播提成配置卡新增/修改",notes = "后台用户代理主播提成配置卡新增/修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdateSysAgentConfig(@RequestBody(required = true) @Valid Request<AcSysAgentConfigRequest> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.addOrUpdateSysAgentConfigBack(BeanUtil.copy(request.getData(), AcSysAgentConfigBackDTO.class)));
    }

    /**
     * @Description 后台用户代理主播提成配置卡新增删除
     * @Author yuan.shuai
     * @Date 2020/2/17 20:34
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "delete/agent/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户代理主播提成配置卡新增删除",notes = "后台用户代理主播提成配置卡新增删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteSysAgentConfig(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.deleteSysAgentConfigBack(request.getData()));
    }

    /**
     * @Description 后台用户代理主播等级下拉列表
     * @Author yuan.shuai
     * @Date 2020/2/18 11:46
     * @Return List<AcUtilIdAndNameResponse>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "query/agent/select/list", method = RequestMethod.GET)
    @ApiOperation(value = "后台用户代理主播等级下拉列表",notes = "后台用户代理主播等级下拉列表",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<List<AcUtilIdAndNameResponse>> getSysAgentConfigSelect() throws Exception{
        return ApiResult.success(BeanUtil.copy(yjzhSystemConfigService.getSysAgentConfigSelectList(),AcUtilIdAndNameResponse.class));
    }

    /**
     * @Description 后台充值配置列表
     * @Author yuan.shuai
     * @Date 2020/2/19 22:02
     * @Param BasePageOrder
     * @Return BaseResponse<List<AcSysChargeConfigResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "query/charge/config/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台充值配置列表",notes = "后台充值配置列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcSysChargeConfigResponse>>> getSysChargeConfigList(@RequestBody(required = true) @Valid Request<BasePageOrder> request) throws Exception{
        BaseResponse<List<AcSysChargeConfigDTO>> responseService = yjzhSystemConfigService.getSysChargeBackList(request.getData());
        BaseResponse<List<AcSysChargeConfigResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcSysChargeConfigResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台充值配置删除
     * @Author yuan.shuai
     * @Date 2020/2/19 22:02
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "delete/charge/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台充值配置删除",notes = "后台充值配置删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteSysChargeConfig(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.deleteSysChargeBack(request.getData()));
    }

    /**
     * @Description 后台充值配置新增修改
     * @Author yuan.shuai
     * @Date 2020/2/19 22:02
     * @Param AcSysChargeConfigRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "update/charge/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台充值配置新增修改",notes = "后台充值配置新增修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdateSysChargeConfig(@RequestBody(required = true) @Valid Request<AcSysChargeConfigRequest> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.addOrUpdateSysChargeBack(BeanUtil.copy(request.getData(),AcSysChargeConfigDTO.class)));
    }

    /**
     * @Description 后台系统消息列表
     * @Author yuan.shuai
     * @Date 2020/2/22 20:53
     * @Param AcQueryOnlyNameRequest
     * @Return BaseResponse<List<AcSysMessageResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "query/message/config/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统消息列表",notes = "后台系统消息列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcSysMessageResponse>>> getSysMessageList(@RequestBody(required = true) @Valid Request<AcQueryOnlyNameRequest> request) throws Exception{
        BaseResponse<List<AcSysMessageBackDTO>> responseService = yjzhSystemConfigService.getSysMessageBackList(BeanUtil.copy(request.getData(),AcQueryOnlyNameDTO.class));
        BaseResponse<List<AcSysMessageResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcSysMessageResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台系统消息新增修改
     * @Author yuan.shuai
     * @Date 2020/2/22 20:53
     * @Param AcSysMessageRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "update/message/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统消息新增修改",notes = "后台系统消息新增修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdateSysMessage(@RequestBody(required = true) @Valid Request<AcSysMessageRequest> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.addOrUpdateSysMessageBack(BeanUtil.copy(request.getData(),AcSysMessageBackDTO.class)));
    }

    /**
     * @Description 后台系统消息删除
     * @Author yuan.shuai
     * @Date 2020/2/22 20:54
     * @Param id
     * @Return Boolean
     * @Version 1.0.0delete
     **/
    @RequestMapping(value = "delete/message/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统消息删除",notes = "后台系统消息删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteSysMessage(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.deleteSysMessageBack(request.getData()));
    }

    /**
     * @Description 系统消息推送
     * @Author Yuan.shuai
     * @Date 2020/3/4 10:57
     * @Param [request]
     * @return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "push/message/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统消息推送",notes = "后台系统消息推送",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> pushSysMessage(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.pushSysMessageBack(request.getData()));
    }

    /**
     * @Description 后台版本管理列表
     * @Author Yuan.shuai
     * @Date 2020/3/4 16:37
     * @Param [request]
     * @return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.admin.vo.response.AcSysAppVersionResponse>>>
     **/
    @RequestMapping(value = "query/version/config/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台版本管理列表",notes = "后台版本管理列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcSysAppVersionResponse>>> getSysVersionList(@RequestBody(required = true) @Valid Request<AcSysAppVersionQueryRequest> request) throws Exception{
        BaseResponse<List<AcSysAppVersionBackDTO>> responseService = yjzhSystemConfigService.getAppVersionBackList(BeanUtil.copy(request.getData(),AcSysAppVersionBackQueryDTO.class));
        BaseResponse<List<AcSysAppVersionResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcSysAppVersionResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description //后台版本管理新增修改
     * @Author Yuan.shuai
     * @Date 2020/3/4 16:40
     * @Param [request]
     * @return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "update/version/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台版本管理新增修改",notes = "后台版本管理新增修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> updateSysVersion(@RequestBody(required = true) @Valid Request<AcSysAppVersionRequest> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.addOrUpdateAppVersionBack(BeanUtil.copy(request.getData(),AcSysAppVersionBackDTO.class)));
    }

    /**
     * @Description //后台版本管理删除
     * @Author Yuan.shuai
     * @Date 2020/3/4 16:41
     * @Param [request]
     * @return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "delete/version/config", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台版本管理删除",notes = "后台版本管理删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteSysVersion(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(yjzhSystemConfigService.deleteAppVersionBack(request.getData()));
    }
}
