package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.request.UserCommentScoreRequest;
import com.aichu.app.vo.request.UserCompleteInformationRequest;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcUserScoreService;
import com.aichu.service.api.AcUserService;
import com.aichu.service.dto.UserCommentScoreDTO;
import com.aichu.service.dto.UserCompleteInformationDTO;
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

import javax.validation.Valid;


/**
 * @ClassName CommentController
 * @Description 爱触用户评论信息Controller
 * @Author Melon
 * @Date 2019/7/22 18:04
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/comment")
@Api(value = "爱触用户评论信息Controller", tags = "爱触用户评论信息接口")
public class CommentController {

    @Autowired
    private AcUserScoreService acUserScoreService;

    /***
     * @Author Melon
     * @Description 用户评论主播信息
     * @Date 9:57 2019/12/31
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/anchor/score", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户评论主播信息", notes = "用户评论主播信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> anchorCommentScore(@RequestBody(required = true) @Valid Request<UserCommentScoreRequest> request,
                                                  @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acUserScoreService.anchorCommentScore(BeanUtil.copy(request.getData(), UserCommentScoreDTO.class), acUserRequestDao.getId()));
    }
}
