package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.response.AgencyAnchorCenterResponse;
import com.aichu.app.vo.response.AgencyAnchorResponse;
import com.aichu.app.vo.response.UserAgencyNextUserResponse;
import com.aichu.app.vo.response.UserLikeResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcUserAnchorService;
import com.aichu.service.dto.UserAgencyNextUserDTO;
import com.aichu.service.dto.UserLikeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * @ClassName AgencyController
 * @Description 爱触代理用户信息Controller
 * @Author Melon
 * @Date 2019/7/22 18:04
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/agency")
@Api(value = "爱触代理用户信息Controller", tags = "爱触代理用户信息接口")
public class AgencyController {

    @Autowired
    private AcUserAnchorService acUserAnchorService;

    /***
     * @Author Melon
     * @Description 申请成为代理用户信息
     * @Date 16:44 2020/1/2
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.String>
     **/
    @RequestMapping(value = "/apply", method = RequestMethod.PUT)
    @ApiOperation(value = "申请成为代理用户信息", notes = "申请成为代理用户信息", httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<String> agencyApply(@ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserAnchorService.agencyApply(acUserRequestDao.getId()));
    }

    /***
     * @Author Melon
     * @Description 代理用户在线用户信息
     * @Date 17:44 2020/1/2
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.AgencyAnchorResponse>
     **/
    @RequestMapping(value = "/anchors", method = RequestMethod.GET)
    @ApiOperation(value = "代理用户在线用户信息", notes = "代理用户在线用户信息", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<List<AgencyAnchorResponse>> agencyAnchors(@ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserAnchorService.agencyAnchors(acUserRequestDao.getId()), AgencyAnchorResponse.class));
    }

    /***
     * @Author Melon
     * @Description 代理用户添加主播用户信息
     * @Date 17:57 2020/1/2
     * @Param [keyWord, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/anchor/find/{keyWord}", method = RequestMethod.GET)
    @ApiOperation(value = "代理用户添加主播用户信息", notes = "代理用户添加主播用户信息", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> agencyAnchorFindByKeyWord(@PathVariable("keyWord") String keyWord,
                                                        @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserAnchorService.agencyAnchorFindByKeyWord(keyWord, acUserRequestDao.getId()));
    }
    
    /***
     * @Author Melon
     * @Description 代理用户移除主播用户信息
     * @Date 18:00 2020/1/2
     * @Param [aimUserId, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/anchor/remove/{aimUserId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "代理用户移除主播用户信息", notes = "代理用户移除主播用户信息", httpMethod = "DELETE")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> agencyAnchorRemove(@PathVariable("aimUserId") Integer aimUserId,
                                                 @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserAnchorService.agencyAnchorRemove(aimUserId, acUserRequestDao.getId()));
    }
    
    /***
     * @Author Melon
     * @Description 代理用户代理中心信息
     * @Date 18:56 2020/1/2
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.AgencyAnchorCenterResponse>
     **/
    @RequestMapping(value = "/anchor/center", method = RequestMethod.GET)
    @ApiOperation(value = "代理用户代理中心信息", notes = "代理用户代理中心信息", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<AgencyAnchorCenterResponse> agencyAnchorCenter(@ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserAnchorService.agencyAnchorCenter(acUserRequestDao.getId()), AgencyAnchorCenterResponse.class));
    }

    /**
     * @Description 用户代理下级用戶列表信息-分页
     * @Author Melon
     * @Date 2020/3/11 17:20
     * @Param [request, acUserRequestDao] 
     * @return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.app.vo.response.UserAgencyNextUserResponse>>> 
     **/
    @RequestMapping(value = "/anchor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户代理下级用戶列表信息-分页", notes = "用户代理下级用戶列表信息-分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<BaseResponse<List<UserAgencyNextUserResponse>>> userAgencyNextUserList(@RequestBody(required = true) Request<BasePageOrder> request,
                                                                                            @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        BaseResponse<List<UserAgencyNextUserDTO>> userAgencyNextUserList = acUserAnchorService.userAgencyNextUserList(acUserRequestDao.getId(), request.getData());
        return ApiResult.success(new BaseResponse<>(userAgencyNextUserList.getCount(), BeanUtil.copy(userAgencyNextUserList.getData(), UserAgencyNextUserResponse.class)));
    }
}
