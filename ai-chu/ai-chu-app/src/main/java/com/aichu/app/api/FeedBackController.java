package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.request.UserFeedBackRequest;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.service.api.AcSysFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @ClassName FeedBackController
 * @Description 爱触系统意见反馈相关信息接口
 * @Author Melon
 * @Date 2019/7/22 18:07
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/feedback")
@Api(value = "爱触意见反馈Controller", tags = "爱触系统意见反馈相关信息接口")
public class FeedBackController {

    @Autowired
    private AcSysFeedbackService acSysFeedbackService;

    /***
     * @Author Melon
     * @Description 用户意见反馈
     * @Date 19:02 2019/9/18
     * @Param [request]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户意见反馈,投诉", notes = "用户意见反馈,投诉", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> userFeedback(@RequestBody(required = true) Request<UserFeedBackRequest> request,
                                           @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acSysFeedbackService.userFeedback(request.getData().getFeedBackType(), request.getData().getFeedBackContent(),
                request.getData().getFeedBackContentImg(), acUserRequestDao.getId()));
    }
}
