package com.aichu.app.api;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.app.vo.request.WxPayCreateOrderRequest;
import com.aichu.app.vo.response.WxPayAppOrderResultResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.CurrentUser;
import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.manager.api.wechat.WeChatAuthService;
import com.aichu.manager.api.wechat.WeChatPayService;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;

/**
 * @ClassName WxPayController
 * @Description 微信支付信息Controller
 * @Author Melon
 * @Date 2019/9/2 11:43
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/wx")
@Api(value = "微信支付信息Controller", tags = "微信支付信息相关接口", protocols = "1")
public class WxPayController {

    private Logger logger = LoggerFactory.getLogger(WxPayController.class);

    @Autowired
    private WeChatPayService weChatPayService;

    @Autowired
    private WeChatAuthService weChatAuthService;


    /***
     * @Author Melon
     * @Description 微信用户信息授权
     * @Date 14:25 2019/9/9
     * @Param [authCode, wzUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<java.lang.Boolean>
     **/
    @RequestMapping(value = "/auth/{authCode}", method = RequestMethod.PUT)
    @ApiOperation(value = "微信用户信息授权", notes = "微信用户信息授权", httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<Boolean> wzUserAuth(@PathVariable("authCode") String authCode,
                                         @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception {
        return ApiResult.success(weChatAuthService.wzUserAuth(acUserRequestDao.getId(), authCode));
    }

    /***
     * @Author Melon
     * @Description 统一下单支付
     * @Date 18:15 2020/1/13
     * @Param [httpRequest, request, acUserRequestDao]
     * @Return com.aichu.common.util.api.ApiResult<com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult>
     **/
    /**
     * @Description //TODO
     * @Author Melon
     * @Date 2020/2/27 16:24
     * @Param [httpRequest, request, acUserRequestDao] 
     * @return com.aichu.common.util.api.ApiResult<com.github.binarywang.wxpay.bean.order.WxPayAppOrderResultResponse>
     **/
    @RequestMapping(value = "/pay/wxAppNormalOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "统一下单支付", notes = "统一下单支付", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization",required = true,paramType = "header")})
    public ApiResult<WxPayAppOrderResultResponse> wxAppNormalOrder(HttpServletRequest httpRequest,
                                                                   @RequestBody(required = true) Request<WxPayCreateOrderRequest> request,
                                                                   @ApiIgnore @CurrentUser AcUserRequestDao acUserRequestDao) throws Exception {
        return ApiResult.success(BeanUtil.copy(weChatPayService.createWxAppNormalOrder(acUserRequestDao.getId(), request.getData().getConsumeType(),
                request.getData().getAimGoodsId(), request.getData().getPreferentialCardType(), httpRequest.getRemoteAddr()), WxPayAppOrderResultResponse.class));
    }

    /***
     * @Author Melon
     * @Description 微信支付通知回调
     * @Date 11:45 2019/9/2
     * @Param [request, response]
     * @Return void
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "pay/app/normal/order/callback")
    @ApiOperation(value = "微信支付通知回调", notes = "微信支付通知回调", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public void wxAppNormalOrderCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("微信支付通知回调--Start--");

        String xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
        String resXml = weChatPayService.wxAppNormalOrderCallBack(xmlResult);
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();

        logger.info("微信支付通知回调--End--" + "----------resXml: " + resXml);
    }
}
