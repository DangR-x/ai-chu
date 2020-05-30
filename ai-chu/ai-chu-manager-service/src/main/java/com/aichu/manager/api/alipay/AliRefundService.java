package com.aichu.manager.api.alipay;

import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.*;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.manager.api.alipay.comm.PayDao;
import com.aichu.manager.config.AliRefundConfig;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.manager.enums.UserOauthTypeEnum;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransToaccountTransferModel;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.egzosn.pay.ali.api.AliPayConfigStorage;
import com.egzosn.pay.ali.api.AliPayService;
import com.egzosn.pay.common.http.HttpConfigStorage;
import com.egzosn.pay.common.util.sign.SignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @ClassName AliRefundService
 * @Description 支付宝退款操作信息Service
 * @Author Melon
 * @Date 2019/9/19 19:46
 * @Version 1.0.0
 **/
@Service
public class AliRefundService {

	private static Logger logger = LoggerFactory.getLogger(AliRefundService.class);

	private AliPayService aliRefundService = null;

	@Autowired
	private AliRefundConfig aliRefundConfig;

	@Autowired
	private AcOrderBaseMapper acOrderBaseMapper;

	@Autowired
	private AcOrderPayRecordMapper acOrderPayRecordMapper;

	@Autowired
	private AcOrderRefundRecordMapper acOrderRefundRecordMapper;

	@Autowired
	private AcUserMapper acUserMapper;

	@Autowired
	private AcUserOauthMapper acUserOauthMapper;

	@Autowired
	private AcOrderWithdrawMapper acOrderWithdrawMapper;

	@PostConstruct
	public void init() {

		//Ali退款初始化参数信息
		AliPayConfigStorage aliPayConfigStorage = new AliPayConfigStorage();
		aliPayConfigStorage.setPid(this.aliRefundConfig.getAliPid());
		aliPayConfigStorage.setAppid(this.aliRefundConfig.getAliAppId());
		aliPayConfigStorage.setKeyPublic(this.aliRefundConfig.getAliAppPublicKey());
		aliPayConfigStorage.setKeyPrivate(this.aliRefundConfig.getAliAppPrivateKey());
		//aliPayConfigStorage.setNotifyUrl(this.aliPayConfig.getAliNormalNotifyUrl());
		aliPayConfigStorage.setSeller(this.aliRefundConfig.getAliSeller());
		aliPayConfigStorage.setSignType(SignUtils.RSA2.name());
		aliPayConfigStorage.setInputCharset("utf-8");

		// 是否为测试账号，沙箱环境
		aliPayConfigStorage.setTest(false);

		// 请求连接池配置
		HttpConfigStorage httpConfigStorage = new HttpConfigStorage();

		// 最大连接数
		httpConfigStorage.setMaxTotal(20);

		// 默认的每个路由的最大连接数
		httpConfigStorage.setDefaultMaxPerRoute(10);
		aliRefundService = new AliPayService(aliPayConfigStorage, httpConfigStorage);
	}

//	/***
//	 * @Author Melon
//	 * @Description 支付宝订单退款
//	 * @Date 15:55 2019/9/26
//	 * @Param [outTradeNum, orderId, totalFee, refundFee]
//	 * @Return java.lang.String
//	 **/
//	public String orderRefundByAli(String outTradeNum, Integer orderId, Integer totalFee, Integer refundFee) throws WxPayException {
//		logger.info("AliPay_aliRefund: Enter AliRefund Method..............");
//
//		RefundOrder refundOrder = new RefundOrder();
//		refundOrder.setRefundNo(AcSignUtils.systemAcOrderNo());
//		refundOrder.setTradeNo(outTradeNum);
//		refundOrder.setOutTradeNo(String.valueOf(orderId));
//		refundOrder.setRefundAmount(new BigDecimal( String.valueOf( (double)refundFee / 100.00)));
//		refundOrder.setTotalAmount(new BigDecimal( String.valueOf( (double)totalFee / 100.00)));
//		Map<String, Object> refundInfo = aliRefundService.refund(refundOrder);
//		Object response = refundInfo.get("alipay_trade_refund_response");
//
//		JSONObject jsonObject = JSONObject.parseObject(response.toString());
//		if (!"10000".equals(jsonObject.get("code").toString())){
//			throw new BusinessException(ResultCodeEnum.ALI_REFUND_RECORD_ERR.getCode(), ResultCodeEnum.ALI_REFUND_RECORD_ERR.getMessage());
//		}
//		//修改回调信息
//		try {
//			updateOrderRecordInfoByRefundSuccess(orderId);
//			return "信息回调处理成功!" + orderId;
//		} catch (Exception e){
//			return "信息回调处理失败!" + e.getStackTrace();
//		}
//	}
//
//	/***
//	 * @Author Melon
//	 * @Description 退款成功相关修改操作
//	 * @Date 15:53 2019/9/26
//	 * @Param [orderId]
//	 * @Return void
//	 **/
//	public void updateOrderRecordInfoByRefundSuccess(Integer orderId) throws Exception{
//
//		//查询订单信息获取订单状态信息
//		AcOrderBaseDO acOrderBaseDO = acOrderBaseMapper.selectByPrimaryKey(orderId);
//		//修改订单为退款状态
//		acOrderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_REFUND.getCode());
//		Integer resultOrder = acOrderBaseMapper.updateByPrimaryKeySelective(acOrderBaseDO);
//		if (resultOrder == 0){
//			throw new BusinessException(ResultCodeEnum.YJZH_UPDATE_ORDER_BASE_FAILED.code(), ResultCodeEnum.YJZH_UPDATE_ORDER_BASE_FAILED.message());
//		}
//
//		//修改订单支付记录
//		AcOrderPayRecordExample acOrderPayRecordExample = new AcOrderPayRecordExample();
//		acOrderPayRecordExample.createCriteria()
//				.andOrderIdEqualTo(acOrderBaseDO.getId())
//				.andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
//		AcOrderPayRecordDO acOrderPayRecordDO = acOrderPayRecordMapper.selectByExample(acOrderPayRecordExample).get(0);
//		acOrderPayRecordDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_REFUND.getCode());
//		acOrderPayRecordMapper.updateByPrimaryKeySelective(acOrderPayRecordDO);
//
//		//修改退款记录为成功
//		AcOrderRefundRecordExample acOrderRefundRecordExample = new AcOrderRefundRecordExample();
//		acOrderRefundRecordExample.createCriteria()
//				.andOrderIdEqualTo(orderId);
//		AcOrderRefundRecordDO acOrderRefundRecordDO = acOrderRefundRecordMapper.selectByExample(acOrderRefundRecordExample).get(0);
//		acOrderRefundRecordDO.setRefundStatus(OrderStatusEnum.ORDER_REFUND_STATUS_REFUND_AGREE.getCode());
//		acOrderRefundRecordDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
//		Integer resultRefund = acOrderRefundRecordMapper.updateByPrimaryKey(acOrderRefundRecordDO);
//		if (resultRefund == 0){
//			throw new BusinessException(ResultCodeEnum.YJZH_ORDER_REFUND_RECORD_FAILED.code(), ResultCodeEnum.YJZH_ORDER_REFUND_RECORD_FAILED.message());
//		}
//	}
	//后台用户提现管理
	@Transactional
	public Boolean aliApplyBalanceWithDraw(Integer amount, Integer userId,Integer orderId) {
		logger.info("支付宝申请提现--提现申请--Start-- amount:--{}, userId:--{}", amount, userId);
		if ( amount< 10){
			throw new BusinessException(ResultCodeEnum.AC_WITHDRAW_MONEY_NOT_LESS_ONE_COIN.code(), ResultCodeEnum.AC_WITHDRAW_MONEY_NOT_LESS_ONE_COIN.message());
		}

		//查询余额是否充足
		AcUserDO ycUserDO = acUserMapper.selectByPrimaryKey(userId);
		if (ycUserDO.getCoin() < amount){
			throw new BusinessException(ResultCodeEnum.USER_COIN_NOT_ENOUGH.code(), ResultCodeEnum.USER_COIN_NOT_ENOUGH.message());
		}
		//查询用户是否绑定支付宝信息
		AcUserOauthExample acUserOauthExample = new AcUserOauthExample();
		acUserOauthExample.createCriteria()
				.andUserIdEqualTo(userId)
				.andOauthTypeEqualTo(UserOauthTypeEnum.USER_OAUTH_TYPE_ALI.getCode())
				.andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
		List<AcUserOauthDO> acUserOauthDOList = acUserOauthMapper.selectByExample(acUserOauthExample);
		if (Utils.isEmpty(acUserOauthDOList)){
			throw new BusinessException(ResultCodeEnum.USER_HAS_NOT_BIND_WX_ERROR.getCode(), ResultCodeEnum.USER_HAS_NOT_BIND_WX_ERROR.getMessage());
		}
		//查询订单信息
		AcOrderBaseDO acOrderBaseDO = acOrderBaseMapper.selectByPrimaryKey(orderId);
		if (acOrderBaseDO == null){
			throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
		}
		AcOrderWithdrawExample acOrderWithdrawExample = new AcOrderWithdrawExample();
		acOrderWithdrawExample.createCriteria()
				.andOrderIdEqualTo(orderId)
//				.andWithDrawStatusEqualTo(OrderStatusEnum.ORDER_STATUS_WITH_DRAW_ING.getCode())
				.andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
		List<AcOrderWithdrawDO> acOrderWithdrawDOS = acOrderWithdrawMapper.selectByExample(acOrderWithdrawExample);
		if (acOrderWithdrawDOS.size()<1){
			throw new BusinessException(ResultCodeEnum.ORDER_WITHDRAW_RECORD_NOT_EXIST.code(), ResultCodeEnum.ORDER_WITHDRAW_RECORD_NOT_EXIST.message());
		}
		AcOrderWithdrawDO acOrderWithdrawDO = acOrderWithdrawDOS.get(0);
		//扣除余额
		ycUserDO.setCoin(ycUserDO.getCoin() - amount);
		Integer result = acUserMapper.updateByPrimaryKeySelective(ycUserDO);
		if (result == 0){
			throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
		}
		//支付宝提现
		AlipayClient alipayClient = new DefaultAlipayClient(PayDao.SERVER_URL, aliRefundConfig.getAliAppId(),
				aliRefundConfig.getAliAppPrivateKey(), PayDao.FORMAT, PayDao.CHARSET, aliRefundConfig.getAliAppPublicKey(), PayDao.SIGN_TYPE);
		AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
		AlipayFundTransToaccountTransferModel model = new AlipayFundTransToaccountTransferModel();
		model.setOutBizNo(acOrderBaseDO.getOrderNo());
		model.setPayeeType("ALIPAY_USERID");
		model.setPayeeAccount(acUserOauthDOList.get(0).getOauthUserId());
		double a =(double)acOrderWithdrawDO.getWithDrawMoney()/100;
		model.setAmount(String.valueOf(a));
		model.setPayerShowName("爱触官方");
		model.setRemark("金币提现");
		request.setBizModel(model);
		AlipayFundTransToaccountTransferResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		if (response.isSuccess() && response.getCode().equals("10000")) {
			logger.info("支付宝申请提现--提现申请--End-- amount:--{}, userId:--{}", amount, userId);
			return true;
		} else {
			logger.info("支付宝申请提现--提现失败--End-- amount:--{}, userId:--{}", amount, userId);
			throw new BusinessException(ResultCodeEnum.AC_ORDER_WITHDRAW_ERROR.code(), ResultCodeEnum.AC_ORDER_WITHDRAW_ERROR.message());
		}
	}

}
