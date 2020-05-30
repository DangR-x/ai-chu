package com.aichu.admin.api;


import com.aichu.admin.config.OperationLog;
import com.aichu.admin.vo.request.*;
import com.aichu.admin.vo.response.*;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.service.api.AcAdminUserService;
import com.aichu.service.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
 * @ClassName AcAdminUserController
 * @Author yuan.shuai
 * @Description 管理员登录和管理员信息管理
 * @Date 2019/11/4
 * @Version 1.0.0
 */
@RestController
@RequestMapping(value = "/admin/user/")
@Api(value = "管理员登录/管理",tags = "管理员登录/管理接口")
public class AcAdminUserController {
    private Logger logger = LoggerFactory.getLogger(AcAdminUserController.class);

    @Autowired
    private AcAdminUserService acAdminUserService;

    /**
     * @Description 后台用户登录
     * @Param BackLoginRequest
     * @Return AdminUserLoginResponse
     * @Author yuan.shuai
     * @Date  2019/7/24
     * @Version 1.0.0
     */
    @OperationLog("后台用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户登录",notes = "后台用户登录",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<AdminUserLoginResponse> login(@RequestBody(required = true) @Valid Request<BackLoginRequest> params) throws Exception{
        try {
            logger.info("=====================执行登录=====================");
            String username = params.getData().getUserName();
            String password = params.getData().getPassword();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            logger.info("验证成功");
            AdminUserLoginResponse response = BeanUtil.copy(acAdminUserService.adminUserLogin(BeanUtil.copy(params.getData(), BackLoginDTO.class)), AdminUserLoginResponse.class);
            response.setSessionId(subject.getSession().getId().toString());
            return ApiResult.success(response);
        } catch (Exception e) {
            e.printStackTrace();
            String ex = e.getClass().getName();
            Integer errorCode = null;
            if (ex != null) {
                if (AuthenticationException.class.getName().equals(ex)){
                    errorCode = ResultCodeEnum.getByMessage(e.getCause().getMessage()).code();
                } else if (BusinessException.class.getName().equals(ex)){
                    errorCode = ResultCodeEnum.getByMessage(e.getMessage()).code();
                } else {
                    errorCode = ResultCodeEnum.SYSTEM_UNKNOWN_ERROR.code();
                }
            }
            return ApiResult.error(errorCode, ResultCodeEnum.getMsgByCode(errorCode));
        }
    }

    /**
     * @Description 后台用户修改密码
     * @Param  AdminUserUpdatePwdRequest
     * @Return  ApiResult
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    @OperationLog("后台用户修改密码")
    @RequestMapping(value = "updatePwd", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户修改密码",notes = "后台用户修改密码",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult updateAdminUserPwd(@RequestBody(required = true) @Valid Request<AdminUserUpdatePwdRequest> params) throws Exception{
        acAdminUserService.updateAdminUserPwd(BeanUtil.copy(params.getData(), AdminUserUpdatePwdDTO.class));
        return ApiResult.success();
    }

    /**
     * @Description 后台用户修改昵称
     * @Param aliasName
     * @Return  ApiResult<Boolean>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    @OperationLog("后台用户修改昵称")
    @RequestMapping(value = "updateAliasName", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台用户修改昵称",notes = "后台用户修改昵称",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> updateAdminUserAliasName(@RequestBody(required = true) @Valid Request<String> params) throws Exception{
        return ApiResult.success(acAdminUserService.updateAdminUserAliasName(params.getData()));
    }

    /**
     * @Description 管理员列表查询
     * @Param AdminUserQueryRequest
     * @Return ApiResult<BaseResponse<List<AdminUserResponse>>>
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    @RequestMapping(value = "getAdminUserList", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "管理员列表查询",notes = "管理员列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AdminUserResponse>>> getAdminUserList(@RequestBody(required = true) @Valid Request<AdminUserQueryRequest> params) throws Exception{
        BaseResponse<List<AdminUserDTO>> oldAdmin = acAdminUserService.getAdminUserList(BeanUtil.copy(params.getData(), AdminUserQueryDTO.class));
        BaseResponse<List<AdminUserResponse>> list = new BaseResponse<>(oldAdmin.getCount(),BeanUtil.copy(oldAdmin.getData(),AdminUserResponse.class));
        return ApiResult.success(list);
    }

    /**
     * @Description 管理员新增修改
     * @Param  AdminUserAddOrUpdateRequest
     * @Return  Boolean
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    @OperationLog("管理员新增/修改")
    @RequestMapping(value = "addOrUpdateAdminUser", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "管理员新增/修改",notes = "管理员新增/修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdateAdminUser(@RequestBody(required = true) @Valid Request<AdminUserAddOrUpdateRequest> params) throws Exception{
        return ApiResult.success(acAdminUserService.addOrUpdateAdminUser(BeanUtil.copy(params.getData(), AdminUserAddOrUpdateDTO.class)));
    }

    /**
     * @Description 管理员删除
     * @Param Integer
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    @OperationLog("管理员删除")
    @RequestMapping(value = "deleteAdminUser", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "管理员删除",notes = "管理员删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteAdminUser(@RequestBody(required = true) @Valid Request<Integer> params) throws Exception{
        return ApiResult.success(acAdminUserService.deleteAdminUser(params.getData()));
    }

    /**
     * @Description 查询管理员信息（查看详情）
     * @Param ID (管理员ID)
     * @Return ApiResult<ViewAdminUserResponse>
     * @Author yuan.shuai
     * @Date  2019/7/31
     * @Version 1.0.0
     */
    @RequestMapping(value = "query/view/detail", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "查询管理员信息（查看详情）",notes = "查询管理员信息（查看详情）",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<ViewAdminUserResponse> getViewAdminUserDetail(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(BeanUtil.copy(acAdminUserService.getViewAdminUserBackDetail(request.getData()),ViewAdminUserResponse.class));
    }

    /**
     * @Description 查询管理员信息（编辑）
     * @Param ID (管理员ID)
     * @Return ApiResult<EditorAdminUserResponse>
     * @Author yuan.shuai
     * @Date  2019/12/17
     * @Version 1.0.0
     */
    @RequestMapping(value = "query/editor/detail", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "查询管理员信息（编辑）",notes = "查询管理员信息（编辑）",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<EditorAdminUserResponse> getEditorAdminUserDetail(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(BeanUtil.copy(acAdminUserService.getEitorAdminUserBackDetail(request.getData()),EditorAdminUserResponse.class));
    }

    /**
     * @Description 查询个人管理员信息（编辑）
     * @Author yuan.shuai
     * @Date 2019/12/25 11:35
     * @Param userName
     * @Return
     * @Version 1.0.0
     **/
    @RequestMapping(value = "query/info/editor/detail", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "查询个人管理员信息（编辑）",notes = "查询个人管理员信息（编辑）",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<AcAdminUserResponse> getAdminUserDetailToUserName(@RequestBody(required = true) @Valid Request<String> request) throws Exception{
        return ApiResult.success(BeanUtil.copy(acAdminUserService.getAdminUserToUserName(request.getData()),AcAdminUserResponse.class));
    }

    /**
     * @Description 管理员修改头像
     * @Author yuan.shuai
     * @Date 2019/12/25 11:45
     * @Param AdminUserHeadImgUpdateRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "update/headImg", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "管理员修改头像",notes = "管理员修改头像",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> updateAdminUserHeadImg(@RequestBody(required = true) @Valid Request<AdminUserHeadImgUpdateRequest> request) throws Exception{
        return ApiResult.success(acAdminUserService.updateAdminUserHeadImg(BeanUtil.copy(request.getData(),AdminUserHeadImgUpdateDTO.class)));
    }
}
