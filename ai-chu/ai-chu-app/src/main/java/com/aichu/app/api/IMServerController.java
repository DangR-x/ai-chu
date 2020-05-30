package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.response.UserBlackListInfoResponse;
import com.aichu.app.vo.response.WangYiYunTokenResponse;
import com.aichu.app.vo.response.WangYiYunUserInfoResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.manager.api.im.user.WangYiYunCloudUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * @ClassName IMServerController
 * @Description 网易云即时通讯Controller
 * @Author Melon
 * @Date 2019/7/22 18:04
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/im")
@Api(value = "网易云即时通讯Controller", tags = "网易云即时通讯信息接口")
public class IMServerController {

    @Autowired
    private WangYiYunCloudUserService wangYiYunCloudUserService;

    /***
     * @Author Melon
     * @Description 获取网易云用户Token信息
     * @Date 17:31 2020/1/4
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.WangYiYunTokenResponse>
     **/
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    @ApiOperation(value = "获取网易云用户注册Token信息", notes = "获取网易云用户注册Token信息", httpMethod = "GET")
    @ApiImplicitParam(name = "Authorization",required = true,paramType = "header")
    public ApiResult<WangYiYunTokenResponse> wangYiYunCloudUserRegister(@ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(BeanUtil.copy(wangYiYunCloudUserService.wangYiYunCloudUserRegister(acUserRequestDao.getId(), acUserRequestDao.getAcUid(),
                acUserRequestDao.getNickName(), acUserRequestDao.getHeadImg()), WangYiYunTokenResponse.class));
    }

    /***
     * @Author Melon
     * @Description 获取网易云用户资料信息
     * @Date 17:25 2020/1/4
     * @Param [aimAcId]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.WangYiYunUserInfoResponse>
     **/
    @RequestMapping(value = "/user/info/{aimAcId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取网易云用户资料信息", notes = "获取网易云用户资料信息", httpMethod = "GET")
    @ApiImplicitParam(name = "Authorization",required = true,paramType = "header")
    public ApiResult<WangYiYunUserInfoResponse> wangYiYunCloudUserInfo(@PathVariable("aimAcId") String aimAcId) throws Exception{
        return ApiResult.success(BeanUtil.copy(wangYiYunCloudUserService.wangYiYunCloudUserInfo(aimAcId), WangYiYunUserInfoResponse.class));
    }
    
    /***
     * @Author Melon
     * @Description 更新网易云用户资料信息
     * @Date 18:06 2020/1/4
     * @Param [userName, userHead, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/user/update/{userName}/{userHead}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新网易云用户资料信息", notes = "更新网易云用户资料信息", httpMethod = "PUT")
    @ApiImplicitParam(name = "Authorization",required = true,paramType = "header")
    public ApiResult<Boolean> wangYiYunCloudUpdateUserInfo(@PathVariable("userName") String userName,
                                                           @PathVariable("userHead") String userHead,
                                                           @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(wangYiYunCloudUserService.wangYiYunCloudUpdateUserInfo(acUserRequestDao.getAcUid(),
                userName, userHead));
    }

    /***
     * @Author Melon
     * @Description 获取用户黑名单列表
     * @Date 11:09 2020/1/6
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.util.List<com.aichu.app.vo.response.UserBlackListInfoResponse>>
     **/
    @RequestMapping(value = "/user/blacklist", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户黑名单列表", notes = "获取用户黑名单列表", httpMethod = "GET")
    @ApiImplicitParam(name = "Authorization",required = true,paramType = "header")
    public ApiResult<List<UserBlackListInfoResponse>> wangYiYunCloudUserBlackListInfo(@ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(BeanUtil.copy(wangYiYunCloudUserService.wangYiYunCloudUserBlackListInfo(acUserRequestDao.getAcUid()), UserBlackListInfoResponse.class));
    }

    /***
     * @Author Melon
     * @Description 用户添加黑名单
     * @Date 11:14 2020/1/6
     * @Param [aimAcId, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/user/blacklist/add/{aimAcId}", method = RequestMethod.PUT)
    @ApiOperation(value = "用户添加黑名单", notes = "用户添加黑名单", httpMethod = "PUT")
    @ApiImplicitParam(name = "Authorization",required = true,paramType = "header")
    public ApiResult<Boolean> wangYiYunCloudUserAddBlackList(@PathVariable("aimAcId") String aimAcId,
                                                             @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(wangYiYunCloudUserService.wangYiYunCloudUserAddBlackList(aimAcId, acUserRequestDao.getAcUid()));
    }
    
    /***
     * @Author Melon
     * @Description 用户移除黑名单
     * @Date 11:15 2020/1/6
     * @Param [aimAcId, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/user/blacklist/remove/{aimAcId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "用户移除黑名单", notes = "用户移除黑名单", httpMethod = "DELETE")
    @ApiImplicitParam(name = "Authorization",required = true,paramType = "header")
    public ApiResult<Boolean> wangYiYunCloudUserRemoveBlackList(@PathVariable("aimAcId") String aimAcId,
                                                                @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(wangYiYunCloudUserService.wangYiYunCloudUserRemoveBlackList(aimAcId, acUserRequestDao.getAcUid()));
    }
}
