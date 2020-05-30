package com.aichu.admin.api;

import com.aichu.admin.vo.request.AcOrderAuditReuqest;
import com.aichu.admin.vo.request.AcOrderBaseQueryRequest;
import com.aichu.admin.vo.request.AcOrderBaseRefundQueryRequest;
import com.aichu.admin.vo.request.AcOrderWithdrawQueryRequest;
import com.aichu.admin.vo.response.AcOrderBaseBackResponse;
import com.aichu.admin.vo.response.AcOrderBaseRefundBackResponse;
import com.aichu.admin.vo.response.AcOrderWithdrawBackResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcOrderBaseService;
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
 * @create: 2020-02-17 16:01
 **/
@RestController
@RequestMapping(value = "/order/manager/")
@Api(value = "订单管理",tags = "订单管理接口")
public class AcOrderBaseController {

    @Autowired
    private AcOrderBaseService orderBaseService;

    /**
     * @Description 后台订单列表查询
     * @Author yuan.shuai
     * @Date 2020/02/17 15:24
     * @Param AcOrderBaseQueryRequest
     * @Return ApiResult<BaseResponse<List<AcOrderBaseBackResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台订单列表查询",notes = "后台订单列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcOrderBaseBackResponse>>> getOrderBaseList(@RequestBody(required = true) @Valid Request<AcOrderBaseQueryRequest> request) throws Exception{
        BaseResponse<List<AcOrderBaseBackDTO>> responseService = orderBaseService.getOrderBaseBackList(BeanUtil.copy(request.getData(), AcOrderBaseQueryDTO.class));
        BaseResponse<List<AcOrderBaseBackResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcOrderBaseBackResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台退款订单列表查询
     * @Author yuan.shuai
     * @Date 2020/02/17 15:24
     * @Param AcOrderBaseRefundQueryRequest
     * @Return ApiResult<BaseResponse<List<AcOrderBaseRefundBackResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/refund/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台退款订单列表查询",notes = "后台退款订单列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcOrderBaseRefundBackResponse>>> getOrderBaseRefundList(@RequestBody(required = true) @Valid Request<AcOrderBaseRefundQueryRequest> request) throws Exception{
        BaseResponse<List<AcOrderBaseRefundBackDTO>> responseService = orderBaseService.getOrderBaseRefundBackList(BeanUtil.copy(request.getData(), AcOrderBaseRefundQueryDTO.class));
        BaseResponse<List<AcOrderBaseRefundBackResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcOrderBaseRefundBackResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台提现订单列表查询
     * @Author yuan.shuai
     * @Date 2020/02/17 15:24
     * @Param AcOrderWithdrawQueryRequest
     * @Return ApiResult<BaseResponse<List<AcOrderWithdrawBackResponse>>>
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/query/withdraw/list", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台提现订单列表查询",notes = "后台提现订单列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcOrderWithdrawBackResponse>>> getOrderWithdrawList(@RequestBody(required = true) @Valid Request<AcOrderWithdrawQueryRequest> request) throws Exception{
        BaseResponse<List<AcOrderWithdrawBackDTO>> responseService = orderBaseService.getOrderWithdrawBackList(BeanUtil.copy(request.getData(), AcOrderWithdrawQueryDTO.class));
        BaseResponse<List<AcOrderWithdrawBackResponse>> response = new BaseResponse<>(responseService.getCount(), BeanUtil.copy(responseService.getData(),AcOrderWithdrawBackResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台退款处理
     * @Author yuan.shuai
     * @Date 2020/2/17 17:27
     * @Param AcOrderAuditReuqest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/audit/refund", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台退款处理",notes = "后台退款处理",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> auditOrderRefund(@RequestBody(required = true) @Valid Request<AcOrderAuditReuqest> request) throws Exception{
        return ApiResult.success(orderBaseService.auditOrderRefund(BeanUtil.copy(request.getData(),AcOrderAuditDTO.class)));
    }

    /**
     * @Description 后台提现处理
     * @Author yuan.shuai
     * @Date 2020/2/17 17:27
     * @Param AcOrderAuditReuqest
     * @Return Boolean
     * @Version 1.0.0
     **/
    @RequestMapping(value = "/audit/withdraw", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台提现处理",notes = "后台提现处理",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> auditOrderWithdraw(@RequestBody(required = true) @Valid Request<AcOrderAuditReuqest> request) throws Exception{
        return ApiResult.success(orderBaseService.auditOrderWithdraw(BeanUtil.copy(request.getData(),AcOrderAuditDTO.class)));
    }
}
