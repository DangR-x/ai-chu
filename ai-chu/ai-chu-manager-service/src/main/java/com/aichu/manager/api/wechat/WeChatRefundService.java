package com.aichu.manager.api.wechat;

import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcOrderBaseMapper;
import com.aichu.dao.autogeneration.mapper.AcOrderPayRecordMapper;
import com.aichu.dao.autogeneration.mapper.AcOrderRefundRecordMapper;
import com.aichu.dao.autogeneration.mapper.AcUserMapper;
import com.aichu.dao.autogeneration.object.AcOrderBaseDO;
import com.aichu.dao.autogeneration.object.AcOrderRefundRecordDO;
import com.aichu.dao.autogeneration.object.AcOrderRefundRecordExample;
import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.manager.config.WeChatPayConfig;
import com.aichu.manager.enums.OrderStatusEnum;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @ClassName WeChatRefundService
 * @Description WeChat退款操作信息Service
 * @Author Melon
 * @Date 2019/9/19 19:46
 * @Version 1.0.0
 **/
@Service
public class WeChatRefundService {

	private static Logger logger = LoggerFactory.getLogger(WeChatRefundService.class);

	private WxPayService wxPayService = null;

	@Autowired
	private WeChatPayConfig weChatPayConfig;

	@Autowired
	private AcOrderBaseMapper acOrderBaseMapper;

	@Autowired
	private AcOrderPayRecordMapper acOrderPayRecordMapper;

	@Autowired
	private AcOrderRefundRecordMapper acOrderRefundRecordMapper;

	@Autowired
	private AcUserMapper acUserMapper;
	@PostConstruct
	public void init() {
		WxPayConfig wxPayConfig = new WxPayConfig();
		// 初始化微信支付配置
		wxPayConfig.setAppId(weChatPayConfig.getWxAppId());
		wxPayConfig.setMchId(weChatPayConfig.getWxMchId());
		wxPayConfig.setMchKey(weChatPayConfig.getWxMchKey());
		wxPayConfig.setNotifyUrl(weChatPayConfig.getWxNormalNotifyUrl());
		wxPayConfig.setKeyPath("classpath:certs/apiclient_cert.p12");
		wxPayService = new WxPayServiceImpl();
		wxPayService.setConfig(wxPayConfig);
	}

	/***
	 * @Author Melon
	 * @Description 微信申请提现
	 * @Date 17:43 2019/9/26
	 * @Param [amount, userId]
	 * @Return java.lang.String
	 **/
	public Boolean wxOrderWithDraw(Integer amount, Integer userId) {
		logger.info("微信申请提现--Start-- amount:--{}, userId--{}", amount, userId);

		//查询余额是否充足
		AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
		if (acUserDO.getCoin() < amount){
			throw new BusinessException(ResultCodeEnum.USER_COIN_NOT_ENOUGH.code(), ResultCodeEnum.USER_COIN_NOT_ENOUGH.message());
		}
		

		logger.info("微信申请提现--End--");
		return true;
	}
}
