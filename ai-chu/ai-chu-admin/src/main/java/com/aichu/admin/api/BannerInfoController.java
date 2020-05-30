package com.aichu.admin.api;

import com.aichu.admin.config.OperationLog;
import com.aichu.admin.vo.request.AcSysBannerAddOrUpdateRequest;
import com.aichu.admin.vo.request.AcSysBannerQueryRequest;
import com.aichu.admin.vo.response.AcSysBannerResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcSystemBannerService;
import com.aichu.service.dto.AcSysBannerBackDTO;
import com.aichu.service.dto.AcSysBannerBackQueryDTO;
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

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName BannerInfoController
 * @Author yuan.shuai
 * @Description 系统Banner管理Controller
 * @Date 2019/8/26
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/banner/manager/")
@Api(value = "Banner管理",tags = "Banner管理接口")
public class BannerInfoController {

    @Autowired
    private AcSystemBannerService acSystemBannerService;

    /**
     * @Description 后台系统Banner管理列表查询
     * @Param YjzhSysBannerQueryRequest
     * @Return ApiResult<BaseResponse<List<YjzhSysBannerResponse>>>
     * @Author yuan.shuai
     * @Date  2019/8/26
     * @Version 1.0.0
     */
    @RequestMapping(value = "queryBannerList", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统Banner管理列表查询",notes = "后台系统Banner管理列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcSysBannerResponse>>> queryBankList(@RequestBody(required = true) @Valid Request<AcSysBannerQueryRequest> request) throws Exception{
        BaseResponse<List<AcSysBannerBackDTO>> responseService = acSystemBannerService.getBannerBackList(BeanUtil.copy(request.getData(), AcSysBannerBackQueryDTO.class));
        BaseResponse<List<AcSysBannerResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcSysBannerResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台系统Banner管理新增/修改
     * @Param YjzhSysBannerAddOrUpdateRequest
     * @Return ApiResult<Boolean>
     * @Author yuan.shuai
     * @Date  2019/8/26
     * @Version 1.0.0
     */
    @OperationLog("Banner新增/修改")
    @RequestMapping(value = "addOrUpdateBanner", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统Banner管理新增/修改",notes = "后台系统Banner管理新增/修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdateBanner(@RequestBody(required = true) @Valid Request<AcSysBannerAddOrUpdateRequest> request) throws Exception{

        return ApiResult.success(acSystemBannerService.addOrUpdateBannerBack(BeanUtil.copy(request.getData(),AcSysBannerBackDTO.class)));
    }

    /**
     * @Description 后台系统Banner管理删除
     * @Param id
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/8/26
     * @Version 1.0.0
     */
    @OperationLog("Banner删除")
    @RequestMapping(value = "deleteBanner", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统Banner管理删除",notes = "后台系统Banner管理删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteBanner(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{

        return ApiResult.success(acSystemBannerService.deleteBannerBack(request.getData()));
    }

}
