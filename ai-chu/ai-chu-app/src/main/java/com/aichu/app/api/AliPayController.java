package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.request.AliBalanceWithDrawRequest;
import com.aichu.app.vo.request.AliPayCreateOrderRequest;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.manager.api.alipay.AliPayService;
import com.aichu.manager.api.alipay.AliRefundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;

/**
 * @ClassName AliPayController
 * @Description 阿里支付信息Controller
 * @Author Melon
 * @Date 2019/9/2 11:50
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/ali")
@Api(value = "阿里支付信息Controller", tags = "阿里支付信息相关接口")
public class AliPayController {

	private Logger logger = LoggerFactory.getLogger(AliPayController.class);

	@Autowired
	private AliPayService aliPayService;

	@Autowired
	private AliRefundService aliRefundService;
	/***
	 * @Author Melon
	 * @Description 阿里统一下单支付
	 * @Date 11:46 2020/1/11
	 * @Param [request, acUserRequestDao]
	 * @Return com.aichu.common.util.api.ApiResult<java.lang.String>
	 **/
	@RequestMapping(value = "pay/app/normal/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "阿里统一下单支付", notes = "统一下单支付", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
	public ApiResult<String> aliAppNormalOrder(@RequestBody(required = true) Request<AliPayCreateOrderRequest> request,
											   @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception {
		return ApiResult.success(aliPayService.createAliAppNormalOrder(acUserRequestDao.getId(), request.getData().getConsumeType(), request.getData().getAimGoodsId(),
				request.getData().getPreferentialCardType()));
	}

	/***
	 * @Author Melon
	 * @Description 阿里支付通知回调
	 * @Date 11:51 2019/9/2
	 * @Param [request, response]
	 * @Return java.lang.String
	 **/
	@IgnoreAuthorization
	@RequestMapping(value = "pay/app/normal/order/callback", method = RequestMethod.POST)
	@ApiOperation(value = "阿里支付通知回调", notes = "阿里支付通知回调", httpMethod = "POST")
	public String aliPayNotify(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("Ali支付通知回调----Start----");

		String result = aliPayService.aliAppNormalOrderCallBack(request);
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		out.write(result.getBytes());
		out.flush();
		out.close();

		logger.info("Ali支付通知回调--End--" + "----------result: " + result);
		return result;
	}
}
