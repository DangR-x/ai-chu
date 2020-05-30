package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.request.BalanceWithDrawRequest;
import com.aichu.app.vo.request.UserUndefineBalancePayRequest;
import com.aichu.app.vo.request.UserWalletBillRequest;
import com.aichu.app.vo.response.UserChartCheckResponse;
import com.aichu.app.vo.response.UserWalletInfoResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.manager.enums.SysConfigEnum;
import com.aichu.service.api.AcOrderBaseService;
import com.aichu.service.api.AcSysSystemConfigService;
import com.aichu.service.dto.BalanceWithDrawDTO;
import com.aichu.service.dto.UserUndefineBalancePayDTO;
import com.aichu.service.dto.UserWalletBillDTO;
import com.aichu.service.dto.UserWalletBillReqDTO;
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
 * @ClassName OrderController
 * @Description 爱触订单信息Controller
 * @Author Melon
 * @Date 2019/7/22 18:07
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/order")
@Api(value = "爱触订单信息Controller", tags = "爱触订单信息相关接口")
public class OrderController {

    @Autowired
    private AcOrderBaseService acOrderBaseService;

    @Autowired
    private AcSysSystemConfigService acSysSystemConfigService;

    /***
     * @Author Melon
     * @Description 聊天通话计费检查
     * @Date 9:19 2020/1/10
     * @Param [aimUserAccId, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.app.vo.response.UserChartCheckResponse>
     **/
    @RequestMapping(value = "/chart/check/{aimUserAccId}", method = RequestMethod.GET)
    @ApiOperation(value = "聊天通话计费检查", notes = "聊天通话计费检查", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<UserChartCheckResponse> userChartCheck(@PathVariable("aimUserAccId") String aimUserAccId,
                                                            @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(BeanUtil.copy(acOrderBaseService.userChartCheck(aimUserAccId, acUserRequestDao.getId()), UserChartCheckResponse.class));
    }

    /***
     * @Author Melon
     * @Description 用户余额统一下单支付
     * @Date 11:22 2020/1/10
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/undefine/balance/pay", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户余额统一下单支付", notes = "用户余额统一下单支付", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> userUndefineBalancePay(@RequestBody(required = true) Request<UserUndefineBalancePayRequest> request,
                                                     @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        return ApiResult.success(acOrderBaseService.userUndefineBalancePay(BeanUtil.copy(request.getData(), UserUndefineBalancePayDTO.class), acUserRequestDao.getId()));
    }

    /***
     * @Author Melon
     * @Description 用户账单明细
     * @Date 16:31 2020/1/10
     * @Param [request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.app.vo.response.UserWalletBillResponse>>>
     **/
    @RequestMapping(value = "/wallet/bill", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户账单明细", notes = "用户账单明细", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<UserWalletInfoResponse> userWalletBill(@RequestBody(required = true) Request<UserWalletBillRequest> request,
                                                            @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception{
        UserWalletInfoResponse userWalletInfoResponse = new UserWalletInfoResponse();
        BaseResponse<List<UserWalletBillDTO>> userWalletBillDTOList = acOrderBaseService.userWalletBill(BeanUtil.copy(request.getData(),
                UserWalletBillReqDTO.class), acUserRequestDao.getId());
        String keyValue = acSysSystemConfigService.systemPolicy(SysConfigEnum.SYS_SYSTEM_CONFIG_KEY_CHARGE_RATE.getTag(), acUserRequestDao.getId());
        userWalletInfoResponse.setUserCoin(acUserRequestDao.getCoin());
        userWalletInfoResponse.setUserMoney(acUserRequestDao.getCoin() / Integer.parseInt(keyValue) * 100);
        userWalletInfoResponse.setUserWalletBillDTOList(new BaseResponse<>(userWalletBillDTOList.getCount(),BeanUtil.copy(userWalletBillDTOList.getData(), UserWalletBillDTO.class)));
        return ApiResult.success(userWalletInfoResponse);
    }
    
    /**
     * @Description 余额提现--提现申请
     * @Author Melon
     * @Date 2020/2/27 17:43
     * @Param [request, wzUserRequestDao] 
     * @return com.aichu.common.util.api.ApiResult<java.lang.Boolean> 
     **/
    @RequestMapping(value = "/apply/balance/withdraw", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "余额提现--提现申请", notes = "阿里余额提现--提现申请", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> applyBalanceWithDraw(@RequestBody(required = true) Request<BalanceWithDrawRequest> request,
                                                   @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception {
        return ApiResult.success(acOrderBaseService.applyBalanceWithDraw(BeanUtil.copy(request.getData(), BalanceWithDrawDTO.class), acUserRequestDao.getId()));
    }
}
