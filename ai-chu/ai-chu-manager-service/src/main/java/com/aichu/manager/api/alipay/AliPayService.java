package com.aichu.manager.api.alipay;

import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.common.util.sign.AcSignUtils;
import com.aichu.dao.autogeneration.mapper.*;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.manager.config.AliPayConfig;
import com.aichu.manager.enums.OrderStatusEnum;
import com.aichu.manager.enums.PreferentialCardTypeEnum;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyAliService
 * @Description Ali授权信息Service
 * @Author Melon
 * @Date 2019/7/22 17:31
 * @Version 1.0.0
 **/

@Service
public class AliPayService {

	private Logger logger = LoggerFactory.getLogger(AliPayService.class);

	private com.egzosn.pay.ali.api.AliPayService aliPayService = null;

	@Autowired
	private AliPayConfig aliPayConfig;

	@Autowired
	private AcUserMapper acUserMapper;

	@Autowired
	private AcOrderBaseMapper acOrderBaseMapper;

	@Autowired
	private AcOrderPayRecordMapper acOrderPayRecordMapper;

	@Autowired
	private AcUserPreferentialCardMapper acUserPreferentialCardMapper;

	@Autowired
	private AcSysChargeConfigMapper acSysChargeConfigMapper;

	@Autowired
	private AcPreferentialCardMapper acPreferentialCardMapper;

	/***
     * @Author Melon
     * @Description 阿里统一下单支付
     * @Date 18:23 2020/1/11
     * @Param [userId, consumeType, totalFee, preferentialCardType]
     * @Return java.lang.String
     **/
	@Transactional
	public String createAliAppNormalOrder(Integer userId, Integer consumeType, Integer aimGoodsId, Integer preferentialCardType) throws Exception {

		//商品金额
		Integer totalFee = 0;
		Integer totalCoin = 0;
		//查询目标商品价格
		if (consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode()){
			AcSysChargeConfigDO acSysChargeConfigDO = acSysChargeConfigMapper.selectByPrimaryKey(aimGoodsId);
			if (acSysChargeConfigDO == null){
				throw new BusinessException(ResultCodeEnum.PAY_GOODS_CONFIG_INFO_NOT_EXIST.code(), ResultCodeEnum.PAY_GOODS_CONFIG_INFO_NOT_EXIST.message());
			}
			totalFee = acSysChargeConfigDO.getChargeAmount();
			totalCoin = acSysChargeConfigDO.getChargeCoin();
		}else {
			AcPreferentialCardDO acPreferentialCardDO = acPreferentialCardMapper.selectByPrimaryKey(aimGoodsId);
			if (acPreferentialCardDO == null){
				throw new BusinessException(ResultCodeEnum.AC_PREFERENTIAL_CARD_INFO_NOT_EXIST.code(), ResultCodeEnum.AC_PREFERENTIAL_CARD_INFO_NOT_EXIST.message());
			}
			totalFee = acPreferentialCardDO.getCardSalePrice();
		}

		if (totalFee <= 0){
			throw new BusinessException(ResultCodeEnum.PAY_MONEY_NOT_LESS_ZERO.code(), ResultCodeEnum.PAY_MONEY_NOT_LESS_ZERO.message());
		}

		//构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        //设置网关地址
        certAlipayRequest.setServerUrl(aliPayConfig.getAliRequestURL());
        //设置应用Id
        certAlipayRequest.setAppId(aliPayConfig.getAliAppId());
        //设置应用私钥
        certAlipayRequest.setPrivateKey(aliPayConfig.getAliAppPrivateKey());
        //设置请求格式，固定值json
        certAlipayRequest.setFormat(aliPayConfig.getAliFormat());
        //设置字符集
        certAlipayRequest.setCharset(aliPayConfig.getAliCharset());
        //设置签名类型
        certAlipayRequest.setSignType(aliPayConfig.getAliSignType());

        //设置应用公钥证书路径
		//certAlipayRequest.setCertPath(ResourceUtils.getFile("classpath:certs/appCertPublicKey_2019082366355710.crt").getAbsolutePath());
		certAlipayRequest.setCertPath("/opt/866_aichu/certs/appCertPublicKey_2019082366355710.crt");
		//设置支付宝公钥证书路径
        //certAlipayRequest.setAlipayPublicCertPath(ResourceUtils.getFile("classpath:certs/alipayCertPublicKey_RSA2.crt").getAbsolutePath());
		certAlipayRequest.setAlipayPublicCertPath("/opt/866_aichu/certs/alipayCertPublicKey_RSA2.crt");
		//设置支付宝根证书路径
		//certAlipayRequest.setRootCertPath(ResourceUtils.getFile("classpath:certs/alipayRootCert.crt").getAbsolutePath());
		certAlipayRequest.setRootCertPath("/opt/866_aichu/certs/alipayRootCert.crt");
		//构造client
		AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

		//创建支付订单
		AcOrderBaseDO acOrderBaseDO = new AcOrderBaseDO();
		acOrderBaseDO.setUserId(userId);
		acOrderBaseDO.setOrderNo(AcSignUtils.systemAcOrderNo());
		acOrderBaseDO.setOrderAmount(totalFee);
		acOrderBaseDO.setOrderCoin(totalCoin);
		acOrderBaseDO.setConsumeType(consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ?
				OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() : OrderStatusEnum.ORDER_CONSUME_TYPE_PREFERENTIAL_CARD.getCode());
		acOrderBaseDO.setPayUse(consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ?
				OrderStatusEnum.ORDER_STATUS_PAY_USE_CHARGE.getCode() : OrderStatusEnum.ORDER_STATUS_PAY_USE_COST.getCode());
		acOrderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_NON_PAYMENT.getCode());
		acOrderBaseDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_ALI.getCode());
		if (preferentialCardType != null){
			acOrderBaseDO.setPreferentialCardType(preferentialCardType);
		}
		acOrderBaseDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
		Integer resultOrder = acOrderBaseMapper.insertSelective(acOrderBaseDO);
		if (resultOrder == 0){
			throw new BusinessException(ResultCodeEnum.AC_CREATE_ORDER_BASE_FAILED.getCode(), ResultCodeEnum.AC_CREATE_ORDER_BASE_FAILED.getMessage());
		}

		//创建支付记录
		AcOrderPayRecordDO acOrderPayRecordDO = new AcOrderPayRecordDO();
		acOrderPayRecordDO.setOrderId(acOrderBaseDO.getId());
		acOrderPayRecordDO.setOrderAmount(totalFee);
		acOrderPayRecordDO.setOrderCoin(totalCoin);
		acOrderPayRecordDO.setConsumeType(consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ?
				OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() : OrderStatusEnum.ORDER_CONSUME_TYPE_PREFERENTIAL_CARD.getCode());
		acOrderPayRecordDO.setPayTradeNo(acOrderBaseDO.getOrderNo());
		acOrderPayRecordDO.setOrderType(OrderStatusEnum.ORDER_STATUS_TYPE_NORMAL.getCode());
		acOrderPayRecordDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_NON_PAYMENT.getCode());
		acOrderPayRecordDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_ALI.getCode());
		acOrderPayRecordDO.setPayUse(consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ?
				OrderStatusEnum.ORDER_STATUS_PAY_USE_CHARGE.getCode() : OrderStatusEnum.ORDER_STATUS_PAY_USE_COST.getCode());
		if (preferentialCardType != null){
			acOrderBaseDO.setPreferentialCardType(preferentialCardType);
		}
		acOrderPayRecordDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
		Integer resultRecord = acOrderPayRecordMapper.insertSelective(acOrderPayRecordDO);
		if (resultRecord == 0){
			throw new BusinessException(ResultCodeEnum.AC_CREATE_ORDER_PAY_RECORD_FAILED.getCode(), ResultCodeEnum.AC_CREATE_ORDER_PAY_RECORD_FAILED.getMessage());
		}

		//购买月卡业务处理
		if (consumeType != OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode()){
			AcUserPreferentialCardExample acUserPreferentialCardExample = new AcUserPreferentialCardExample();
			acUserPreferentialCardExample.createCriteria()
					.andUserIdEqualTo(userId)
					.andPreferentialCardIdEqualTo(preferentialCardType == PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK.getCode()
							? PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK_KEY_DATABASE.getCode()
							: PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_MOUTH_KEY_DATABASE.getCode())
					.andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
			List<AcUserPreferentialCardDO> acUserPreferentialCardDOList = acUserPreferentialCardMapper.selectByExample(acUserPreferentialCardExample);
			if (!Utils.isEmpty(acUserPreferentialCardDOList)){
				throw new BusinessException(ResultCodeEnum.AC_USER_HAS_BEEN_BY_PREFERENTIAL_CARD.code(), ResultCodeEnum.AC_USER_HAS_BEEN_BY_PREFERENTIAL_CARD.message());
			}
			AcUserPreferentialCardDO acUserPreferentialCardDO = new AcUserPreferentialCardDO();
			acUserPreferentialCardDO.setUserId(userId);
			acUserPreferentialCardDO.setPreferentialCardId(preferentialCardType == PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK.getCode()
					? PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK_KEY_DATABASE.getCode()
					: PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_MOUTH_KEY_DATABASE.getCode());
			acUserPreferentialCardDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
			Integer resultCard = acUserPreferentialCardMapper.insertSelective(acUserPreferentialCardDO);
			if (resultCard == 0){
				throw new BusinessException(ResultCodeEnum.AC_BY_PREFERENTIAL_CARD_FAILED.code(), ResultCodeEnum.AC_BY_PREFERENTIAL_CARD_FAILED.message());
			}
		}

		model.setBody(consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ? "在线充值支付" : "购买优惠卡");
		model.setSubject(consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ? "在线充值支付操作信息" : "购买优惠卡操作信息");
		model.setOutTradeNo(acOrderBaseDO.getOrderNo());
		model.setTimeoutExpress("30m");
		model.setTotalAmount(new Double(0.01) + "");
		model.setPassbackParams("");
		//model.setProductCode(consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ? "ZF-ZXCZ" : "ZF-GMYHK");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl(aliPayConfig.getAliNormalNotifyUrl());
		try {
			//这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
			return response.getBody();
		} catch (AlipayApiException e) {
			throw new BusinessException(ResultCodeEnum.CREATE_PAY_ERROR.getCode(), ResultCodeEnum.CREATE_PAY_ERROR.getMessage());
		}
	}


	/***
	 * @Author Melon
	 * @Description 支付宝APP普通订单支付回调
	 * @Date 15:22 2019/9/12
	 * @Param [request]
	 * @Return java.lang.String
	 **/
	@Transactional
	public String aliAppNormalOrderCallBack(HttpServletRequest request) {
		try {
			//获取支付宝POST过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
			//boolean AlipaySignature.rsaCertCheckV1(Map<String, String> params, String publicKeyCertPath, String charset,String signType)
			boolean flag = AlipaySignature.rsaCertCheckV1(params, "/opt/866_aichu/certs/alipayCertPublicKey_RSA2.crt",
					aliPayConfig.getAliCharset(),aliPayConfig.getAliSignType());
			if (flag){
				logger.info("支付回调响应参数：--------cbRet----{}", params.toString());

				String payTradeNo = params.get("out_trade_no");
				String outTradeNo = params.get("trade_no");
				//查询支付流水记录
				AcOrderPayRecordExample acOrderPayRecordExample = new AcOrderPayRecordExample();
				acOrderPayRecordExample.createCriteria()
						.andPayTradeNoEqualTo(payTradeNo)
						.andOrderTypeEqualTo(OrderStatusEnum.ORDER_STATUS_TYPE_NORMAL.getCode());
				AcOrderPayRecordDO acOrderPayRecordDO = acOrderPayRecordMapper.selectByExample(acOrderPayRecordExample).get(0);

				//修改支付订单
				AcOrderBaseExample acOrderBaseExample = new AcOrderBaseExample();
				acOrderBaseExample.createCriteria()
						.andIdEqualTo(acOrderPayRecordDO.getOrderId());
				AcOrderBaseDO acOrderBaseDO =  acOrderBaseMapper.selectByExample(acOrderBaseExample).get(0);
				acOrderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
				acOrderBaseDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
				Integer resultOrder = acOrderBaseMapper.updateByPrimaryKeySelective(acOrderBaseDO);
				if (resultOrder == 0){
					throw new BusinessException(ResultCodeEnum.AC_UPDATE_ORDER_BASE_FAILED.getCode(), ResultCodeEnum.AC_UPDATE_ORDER_BASE_FAILED.getMessage());
				}

				//修改支付流水记录
				acOrderPayRecordDO.setOutTradeNo(outTradeNo);
				acOrderPayRecordDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
				acOrderPayRecordDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
				Integer resultRecord = acOrderPayRecordMapper.updateByPrimaryKeySelective(acOrderPayRecordDO);
				if (resultRecord == 0){
					throw new BusinessException(ResultCodeEnum.AC_UPDATE_ORDER_PAY_RECORD_FAILED.getCode(), ResultCodeEnum.AC_UPDATE_ORDER_PAY_RECORD_FAILED.getMessage());
				}

				if (acOrderBaseDO.getConsumeType() == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode()){
					//增加用户余额
					AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(acOrderBaseDO.getUserId());
					acUserDO.setCoin(acUserDO.getCoin() + acOrderBaseDO.getOrderCoin());
					Integer resultAcUser = acUserMapper.updateByPrimaryKeySelective(acUserDO);
					if (resultAcUser == 0){
						throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
					}
				}else {
					AcUserPreferentialCardExample acUserPreferentialCardExample = new AcUserPreferentialCardExample();
					acUserPreferentialCardExample.setOrderByClause("`create_time` DESC");
					acUserPreferentialCardExample.createCriteria()
							.andUserIdEqualTo(acOrderBaseDO.getUserId())
							.andPreferentialCardIdEqualTo(acOrderBaseDO.getPreferentialCardType() == PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK.getCode()
									? PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK_KEY_DATABASE.getCode()
									: PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_MOUTH_KEY_DATABASE.getCode());
					List<AcUserPreferentialCardDO> acUserPreferentialCardDOList = acUserPreferentialCardMapper.selectByExample(acUserPreferentialCardExample);
					if (!Utils.isEmpty(acUserPreferentialCardDOList)){
						acUserPreferentialCardDOList.get(0).setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
						Integer resultCard = acUserPreferentialCardMapper.updateByPrimaryKeySelective(acUserPreferentialCardDOList.get(0));
						if (resultCard == 0){
							throw new BusinessException(ResultCodeEnum.AC_UPDATE_PREFERENTIAL_CARD_FAILED.code(), ResultCodeEnum.AC_UPDATE_PREFERENTIAL_CARD_FAILED.message());
						}
						//增加优惠卡购买次数
						AcPreferentialCardDO acPreferentialCardDO = acPreferentialCardMapper.selectByPrimaryKey(acUserPreferentialCardDOList.get(0).getPreferentialCardId());
						if (acPreferentialCardDO == null){
							throw new BusinessException(ResultCodeEnum.AC_PREFERENTIAL_CARD_INFO_NOT_EXIST.code(), ResultCodeEnum.AC_PREFERENTIAL_CARD_INFO_NOT_EXIST.message());
						}
						acPreferentialCardDO.setCardSaleNum(acPreferentialCardDO.getCardSaleNum() + 1);
						Integer resultPreferentialCard = acPreferentialCardMapper.updateByPrimaryKeySelective(acPreferentialCardDO);
						if (resultPreferentialCard == 0){
							throw new BusinessException(ResultCodeEnum.AC_UPDATE_PREFERENTIAL_CARD_FAILED.code(), ResultCodeEnum.AC_UPDATE_PREFERENTIAL_CARD_FAILED.message());
						}
					}
				}
				//return aliPayService.getPayOutMessage("success", "成功").toMessage();
				return "success";
			} else {
//				return aliPayService.getPayOutMessage("fail", "失败").toMessage();
				return "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
			//return aliPayService.getPayOutMessage("fail", "失败").toMessage();
			return "failure";
		}
	}
}
