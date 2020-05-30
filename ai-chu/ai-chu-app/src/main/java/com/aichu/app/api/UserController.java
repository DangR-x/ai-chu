package com.aichu.app.api;

import com.aichu.app.vo.request.*;
import com.aichu.app.vo.response.*;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;


/**
 * @ClassName UserController
 * @Description 爱触用户个人中心接口
 * @Author Melon
 * @Date 2019/7/22 18:04
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/user")
@Api(value = "爱触用户Controller", tags = "爱触用户个人中心接口")
public class UserController {

    @Autowired
    private AcUserService acUserService;

    /***
     * @Author Melon
     * @Description 用户登录补充信息资料
     * @Date 17:41 2019/12/26
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/complete/information", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户登录补充信息资料", notes = "用户登录补充信息资料", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> completeInformation(@RequestBody(required = true) @Valid Request<UserCompleteInformationRequest> request,
                                                  @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserService.userCompleteInformation(BeanUtil.copy(request.getData(), UserCompleteInformationDTO.class), acUserRequestDao.getId()));
    }

    /***
     * @Author Melon
     * @Description 用户个人主页信息资料
     * @Date 16:08 2019/12/27
     * @Param [aimAcId, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.PersonalHomePageResponse>
     **/
    @RequestMapping(value = "/personal/home/page/{aimUserAcId}", method = RequestMethod.GET)
    @ApiOperation(value = "用户个人主页信息资料", notes = "用户个人主页信息资料", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization",required = true,paramType = "header"),
            @ApiImplicitParam(name="aimUserAcId", dataType = "String", value = "目标用户AcID", required = true)
    })
    public ApiResult<PersonalHomePageResponse> personalHomePage(@PathVariable("aimUserAcId") String aimUserAcId,
                                                                @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserService.personalHomePage(aimUserAcId, acUserRequestDao.getId()), PersonalHomePageResponse.class));
    }

    /***
     * @Author Melon
     * @Description 用户关注与取消关注
     * @Date 18:20 2019/12/27
     * @Param [aimUserId, actionType, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/like/{aimUserId}/{actionType}", method = RequestMethod.PUT)
    @ApiOperation(value = "用户关注与取消关注", notes = "用户关注与取消关注", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization",required = true,paramType = "header"),
            @ApiImplicitParam(name="aimUserId", dataType = "Integer", value = "目标用户ID", required = true),
            @ApiImplicitParam(name="actionType", dataType = "Integer", value = "操作类型（0-取消，1-关注）", required = true)
    })
    public ApiResult<Boolean> userLikeAction(@PathVariable("aimUserId") Integer aimUserId,
                                             @PathVariable("actionType") Integer actionType,
                                             @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserService.userLikeAction(aimUserId, actionType, acUserRequestDao.getId()));
    }

    /***
     * @Author Melon
     * @Description 用户关注人列表信息-分页
     * @Date 22:02 2020/2/20
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.app.vo.response.UserLikeResponse>>>
     **/
    @RequestMapping(value = "/like", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户关注人列表信息-分页", notes = "用户关注人列表信息-分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<BaseResponse<List<UserLikeResponse>>> userLikeList(@RequestBody(required = true) Request<BasePageOrder> request,
                                                                        @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        BaseResponse<List<UserLikeDTO>> userLikeDTOList = acUserService.userLikeList(acUserRequestDao.getId(), request.getData());
        return ApiResult.success(new BaseResponse<>(userLikeDTOList.getCount(), BeanUtil.copy(userLikeDTOList.getData(), UserLikeResponse.class)));
    }

    /**
     * @Description 用户关注人在线列表信息-分页
     * @Author Melon
     * @Date 2020/3/3 11:01
     * @Param [request, acUserRequestDao] 
     * @return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.app.vo.response.UserLikeResponse>>> 
     **/
    @RequestMapping(value = "/online/like", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户关注人在线列表信息-分页", notes = "用户关注人在线列表信息-分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<BaseResponse<List<UserLikeResponse>>> userOnlineLikeList(@RequestBody(required = true) Request<BasePageOrder> request,
                                                                        @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        BaseResponse<List<UserLikeDTO>> userLikeDTOList = acUserService.userLikeList(acUserRequestDao.getId(), request.getData());
        return ApiResult.success(new BaseResponse<>(userLikeDTOList.getCount(), BeanUtil.copy(userLikeDTOList.getData(), UserLikeResponse.class)));
    }
    
    /***
     * @Author Melon
     * @Description 用户修改基础个人信息资料
     * @Date 10:48 2019/12/31
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/basics/information", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户修改基础个人信息资料", notes = "用户修改基础个人信息资料", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> updateBasicsInformation(@RequestBody(required = true) @Valid Request<UserBasicsInformationRequest> request,
                                                      @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserService.updateBasicsInformation(BeanUtil.copy(request.getData(), UserBasicsInformationDTO.class), acUserRequestDao.getId()));
    }

    /***
     * @Author Melon
     * @Description 用户个人钱包信息
     * @Date 14:47 2019/12/31
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.UserWalletResponse>
     **/
    @RequestMapping(value = "/wallet", method = RequestMethod.GET)
    @ApiOperation(value = "用户个人钱包信息", notes = "用户个人钱包信息", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<UserWalletResponse> userWallet(@ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserService.userWallet(acUserRequestDao.getId()), UserWalletResponse.class));
    }

    /***
     * @Author Melon
     * @Description 用户个人主页信息资料修改
     * @Date 11:05 2020/1/2
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/personal/home/page", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户个人主页信息资料修改", notes = "用户个人主页信息资料修改", httpMethod = "PUT", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> personalHomePageUpdate(@RequestBody(required = true) @Valid Request<PersonalHomePageUpdateRequest> request,
                                                     @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserService.personalHomePageUpdate(BeanUtil.copy(request.getData(), PersonalHomePageUpdateDTO.class), acUserRequestDao.getId()));
    }

    /**
     * @Description 用户已签到天数
     * @Author Melon
     * @Date 2020/2/29 15:44
     * @Param [acUserRequestDao] 
     * @return com.aichu.common.util.api.ApiResult<java.lang.Integer> 
     **/
    @RequestMapping(value = "/sign/days", method = RequestMethod.GET)
    @ApiOperation(value = "用户已签到天数", notes = "用户已签到天数", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Integer> userSignDays(@ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserService.userSignDays(acUserRequestDao.getId()));
    }

    /***
     * @Author Melon
     * @Description 用户每日签到
     * @Date 17:07 2020/1/7
     * @Param [coin, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/sign/in/{coin}", method = RequestMethod.PUT)
    @ApiOperation(value = "用户每日签到", notes = "用户每日签到", httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> userEveryDaySignIn(@PathVariable("coin") Integer coin, @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserService.userEveryDaySignIn(acUserRequestDao.getId(), coin));
    }

    /***
     * @Author Melon
     * @Description 用户魅力榜--分页
     * @Date 16:42 2020/1/9
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.UserCharmRankResponse>
     **/
    @RequestMapping(value = "/charm/rank", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户魅力榜--分页", notes = "用户魅力榜--分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<UserCharmRankResponse> userCharmRankList(@RequestBody(required = true) Request<UserRankListRequest> request,
                                                              @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        UserCharmRankResponse userCharmRankResponse = new UserCharmRankResponse();
        BaseResponse<List<UserRecordListInfoDTO>> userRecordListInfoDTOList = acUserService.userCharmRankList(acUserRequestDao.getId(), BeanUtil.copy(request.getData(), UserRankListReqDTO.class));
        Integer totalReceiveCoin = acUserService.userTotalReceiveCoin(acUserRequestDao.getId(), request.getData().getTimeType());
        userCharmRankResponse.setTotalReceive(totalReceiveCoin);
        userCharmRankResponse.setUserRecordListInfoDTOList(new BaseResponse<>(userRecordListInfoDTOList.getCount(),BeanUtil.copy(userRecordListInfoDTOList.getData(), UserRecordListInfoDTO.class)));
        return ApiResult.success(userCharmRankResponse);
    }

    /***
     * @Author Melon
     * @Description 用户富豪榜--分页
     * @Date 16:42 2020/1/9
     * @Param [acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/rich/rank", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户富豪榜--分页", notes = "用户富豪榜--分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<UserRichRankResponse> userRichRankList(@RequestBody(required = true) Request<UserRankListRequest> request,
                                                            @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        UserRichRankResponse userRichRankResponse = new UserRichRankResponse();
        BaseResponse<List<UserRecordListInfoDTO>> userRecordListInfoDTOList = acUserService.userRichRankList(acUserRequestDao.getId(), BeanUtil.copy(request.getData(), UserRankListReqDTO.class));
        Integer totalCostCoin = acUserService.userTotalCostCoin(acUserRequestDao.getId(), request.getData().getTimeType());
        userRichRankResponse.setTotalCostCoin(totalCostCoin);
        userRichRankResponse.setUserRecordListInfoDTOList(new BaseResponse<>(userRecordListInfoDTOList.getCount(),BeanUtil.copy(userRecordListInfoDTOList.getData(), UserRecordListInfoDTO.class)));
        return ApiResult.success(userRichRankResponse);
    }


    /***
     * @Author Melon
     * @Description 用户添加视频通话记录
     * @Date 16:45 2019/8/27
     * @Param [request, wzUserRequestDao]
     * @Return com.wenzu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/video", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户添加视频通话记录", notes = "用户添加视频通话记录", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> videoRecordAdd(@RequestBody(required = true) Request<VideoRecordRequest> request,
                                             @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserService.videoRecordAdd(acUserRequestDao.getId(), request.getData().getTelUserAcUid(), request.getData().getTelTime()));
    }

    /***
     * @Author Melon
     * @Description 用户视频通话记录列表信息-分页
     * @Date 12:55 2020/2/21
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.app.vo.response.UserVideoRecordResponse>>>
     **/
    @RequestMapping(value = "/video/record", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户视频通话记录列表信息-分页", notes = "用户视频通话记录列表信息-分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<BaseResponse<List<UserVideoRecordResponse>>> userVideoRecord(@RequestBody(required = true) Request<BasePageOrder> request,
                                                                                  @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        BaseResponse<List<UserVideoRecordDTO>> userVideoRecordDTOList = acUserService.userVideoRecord(acUserRequestDao.getId(), request.getData());
        return ApiResult.success(new BaseResponse<>(userVideoRecordDTOList.getCount(), BeanUtil.copy(userVideoRecordDTOList.getData(), UserVideoRecordResponse.class)));
    }

    /***
     * @Author Melon
     * @Description 用户消息信息-分页
     * @Date 14:51 2020/2/21
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.app.vo.response.UserMessageResponse>>>
     **/
    @RequestMapping(value = "/message/record", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户消息信息-分页", notes = "用户消息信息-分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<BaseResponse<List<UserMessageResponse>>> userMessageList(@RequestBody(required = true) Request<BasePageOrder> request,
                                                                           @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        BaseResponse<List<UserMessageDTO>> userMessageDTOList = acUserService.userMessageList(acUserRequestDao.getId(), request.getData());
        return ApiResult.success(new BaseResponse<>(userMessageDTOList.getCount(), BeanUtil.copy(userMessageDTOList.getData(), UserMessageResponse.class)));
    }

}

