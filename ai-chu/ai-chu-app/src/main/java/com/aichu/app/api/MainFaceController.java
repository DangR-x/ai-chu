package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.request.MainFacelRequest;
import com.aichu.app.vo.response.MainFaceAnchorFindResponse;
import com.aichu.app.vo.response.MainFaceRecommendResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcUserService;
import com.aichu.service.dto.MainFaceRecommendDTO;
import com.aichu.service.dto.MainFacelDTO;
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
 * @ClassName MainFaceController
 * @Description 爱触首页推荐信息Controller
 * @Author Melon
 * @Date 2019/7/22 18:07
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/main/face")
@Api(value = "爱触首页推荐信息Controller", tags = "爱触首页推荐信息相关接口")
public class MainFaceController {

    @Autowired
    private AcUserService acUserService;

    /***
     * @Author Melon
     * @Description 爱触首页推荐信息-分页
     * @Date 16:55 2020/2/17
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.app.vo.response.MainFaceRecommendResponse>>>
     **/
    @RequestMapping(value = "/recommend", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "爱触首页推荐信息-分页", notes = "爱触首页推荐信息-分页", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<BaseResponse<List<MainFaceRecommendResponse>>> mainFaceRecommend(@RequestBody(required = true) Request<MainFacelRequest> request,
                                                                        @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        BaseResponse<List<MainFaceRecommendDTO>> mainFaceRecommendDTOList = acUserService.mainFaceRecommend(acUserRequestDao.getId(), BeanUtil.copy(request.getData(),
                MainFacelDTO.class));
        return ApiResult.success(new BaseResponse<>(mainFaceRecommendDTOList.getCount(), BeanUtil.copy(mainFaceRecommendDTOList.getData(), MainFaceRecommendResponse.class)));
    }

    /**
     * @Description 首页查找主播用户信息
     * @Author Melon
     * @Date 2020/3/3 15:48
     * @Param [keyWord]
     * @return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.MainFaceAnchorFindResponse>
     **/
    @RequestMapping(value = "/anchor/find/{keyWord}", method = RequestMethod.GET)
    @ApiOperation(value = "首页查找主播用户信息", notes = "首页查找主播用户信息", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<List<MainFaceAnchorFindResponse>> mainFaceAnchorFindByKeyWord(@PathVariable("keyWord") String keyWord) throws Exception{
        return ApiResult.success(BeanUtil.copy(acUserService.mainFaceAnchorFindByKeyWord(keyWord), MainFaceAnchorFindResponse.class));
    }
}
