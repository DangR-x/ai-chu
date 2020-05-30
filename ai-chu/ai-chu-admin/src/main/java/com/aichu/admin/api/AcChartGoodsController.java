package com.aichu.admin.api;

import com.aichu.admin.vo.request.AcChartGoodsQuqeryRequest;
import com.aichu.admin.vo.request.AcChartGoodsRequest;
import com.aichu.admin.vo.request.AcQueryOnlyNameRequest;
import com.aichu.admin.vo.request.AcUtilIdAndStatusRequest;
import com.aichu.admin.vo.response.AcChartGoodsRecordsResponse;
import com.aichu.admin.vo.response.AcChartGoodsResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcChartGoodsService;
import com.aichu.service.dto.*;
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
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 10:57
 **/
@RestController
@RequestMapping(value = "/goods/manager/")
@Api(value = "商品管理",tags = "商品管理接口")
public class AcChartGoodsController {

    @Autowired
    private AcChartGoodsService goodsService;

    /**
     * @Description 后台商品列表查询
     * @Author yuan.shuai
     * @Date 2020/02/17 15:24
     * @Param AcChartGoodsQuqeryRequest
     * @Return ApiResult<BaseResponse<List<AcChartGoodsResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台商品列表查询",notes = "后台商品列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcChartGoodsResponse>>> getGoodsList(@RequestBody(required = true) @Valid Request<AcChartGoodsQuqeryRequest> request) throws Exception{
        BaseResponse<List<AcChartGoodsDTO>> responseService = goodsService.getChartGoodsListBack(BeanUtil.copy(request.getData(), AcChartGoodsQuqeryDTO.class));
        BaseResponse<List<AcChartGoodsResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcChartGoodsResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description  后台商品新增修改
     * @Author yuan.shuai
     * @Date 2020/2/17 11:08
     * @Param AcChartGoodsRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/update", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台商品新增修改",notes = "后台商品新增修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> addOrUpdateChartGoods(@RequestBody(required = true) @Valid Request<AcChartGoodsRequest> request) throws Exception{
        return ApiResult.success(goodsService.addOrUpdateChartGoodsBack(BeanUtil.copy(request.getData(),AcChartGoodsDTO.class)));
    }

    /**
     * @Description 后台商品删除
     * @Author yuan.shuai
     * @Date 2020/2/17 11:08
     * @Param id
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/delete", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台商品删除",notes = "后台商品删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteChartGoods(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(goodsService.deleteChartGoodsBack(request.getData()));
    }

    /**
     * @Description 后台商品销售记录列表
     * @Author yuan.shuai
     * @Date 2020/2/17 11:46
     * @Param AcQueryOnlyNameRequest
     * @Return BaseResponse<List<AcChartGoodsRecordsResponse>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/sell/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台商品销售记录列表",notes = "后台商品销售记录列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcChartGoodsRecordsResponse>>> getGoodsSellList(@RequestBody(required = true) @Valid Request<AcQueryOnlyNameRequest> request) throws Exception{
        BaseResponse<List<AcChartGoodsRecordsDTO>> responseService = goodsService.getChartGoodsRecordList(BeanUtil.copy(request.getData(), AcQueryOnlyNameDTO.class));
        BaseResponse<List<AcChartGoodsRecordsResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcChartGoodsRecordsResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台商品上架/下架
     * @Author yuan.shuai
     * @Date 2020/2/18 14:53
     * @Param AcUtilIdAndStatusRequest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/update/putaway", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台商品上架/下架",notes = "后台商品上架/下架",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> putawayGoodsBack(@RequestBody(required = true) @Valid Request<AcUtilIdAndStatusRequest> request) throws Exception{
        return ApiResult.success(goodsService.putawayGoodsBack(BeanUtil.copy(request.getData(), AcUtilIdAndStatusDTO.class)));
    }
}
