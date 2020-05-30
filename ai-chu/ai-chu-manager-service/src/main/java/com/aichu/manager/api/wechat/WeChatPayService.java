package com.aichu.manager.api.wechat;

import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.common.util.sign.AcSignUtils;
import com.aichu.dao.autogeneration.mapper.*;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.manager.config.WeChatPayConfig;
import com.aichu.manager.dto.WxPayAppOrderResultDTO;
import com.aichu.manager.enums.*;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @ClassName WeChatPayService
 * @Description 微信支付信息Service
 * @Author Melon
 * @Date 2019/8/29 18:37
 * @Version 1.0.0
 **/
@Service
public class WeChatPayService {

    private Logger logger = LoggerFactory.getLogger(WeChatPayService.class);

    private WxPayService wxPayService = null;

    @Autowired
    private WeChatPayConfig weChatPayConfig;

    @Autowired
    private AcUserMapper acUserMapper;

    @Autowired
    private AcUserOauthMapper acUserOauthMapper;

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

    @PostConstruct
    public void init() {

        WxPayConfig wxPayConfig = new WxPayConfig();
        // 初始化微信支付配置
        wxPayConfig.setAppId(weChatPayConfig.getWxAppId());
        wxPayConfig.setMchId(weChatPayConfig.getWxMchId());
        wxPayConfig.setMchKey(weChatPayConfig.getWxMchKey());
        wxPayConfig.setNotifyUrl(weChatPayConfig.getWxNormalNotifyUrl());
        wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(wxPayConfig);
    }

    /***
     * @Author Melon
     * @Description 获取微信支付回调信息数据
     * @Date 19:58 2019/9/2
     * @Param [notityXml]
     * @Return com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult
     **/
    private WxPayOrderNotifyResult wxNotify(String notityXml) throws Exception {
        return wxPayService.parseOrderNotifyResult(notityXml);
    }
    
    /***
     * @Author Melon
     * @Description 微信统一下单支付
     * @Date 20:00 2019/9/2
     * @Param [userOpenId, tradeOrderNo, orderId, orderSubject, goodsDesc, goodsCode, totalFee, spbillCreateIp]
     * @Return com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult
     **/
    private WxPayAppOrderResult unifiedOrder(String tradeOrderNo, Integer orderId, String orderSubject, String goodsDesc, String goodsCode,
                                             Integer totalFee, String spbillCreateIp) throws Exception {
        WxPayUnifiedOrderRequest perPayRequest = WxPayUnifiedOrderRequest.newBuilder()
                .outTradeNo(tradeOrderNo).attach(String.valueOf(orderId)).totalFee(totalFee).body(orderSubject)
                .tradeType(WxPayConstants.TradeType.APP).spbillCreateIp(spbillCreateIp)
                .detail(goodsDesc).productId(goodsCode).build();
        WxPayAppOrderResult result = wxPayService.createOrder(perPayRequest);
        return result;
    }

    /***
     * @Author Melon
     * @Description 微信APP普通订单下单支付
     * @Date 18:21 2020/1/11
     * @Param [userId, consumeType, totalFee, preferentialCardType, spbillCreateIp]
     * @Return java.lang.String
     **/
    @Transactional
    public WxPayAppOrderResultDTO createWxAppNormalOrder(Integer userId, Integer consumeType, Integer aimGoodsId, Integer preferentialCardType, String spbillCreateIp) throws Exception {

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

        try {
            //支付金额
            Integer totalFeeTest = 1;
//
//            AcUserOauthExample acUserOauthExample = new AcUserOauthExample();
//            acUserOauthExample.createCriteria()
//                    .andUserIdEqualTo(userId)
//                    .andOauthTypeEqualTo(UserOauthTypeEnum.USER_OAUTH_TYPE_WX.getCode())
//                    .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
//            List<AcUserOauthDO> acUserOauthDOList = acUserOauthMapper.selectByExample(acUserOauthExample);
//            if (Utils.isEmpty(acUserOauthDOList)){
//                throw new BusinessException(ResultCodeEnum.USER_HAS_NOT_BIND_WX_ERROR.getCode(), ResultCodeEnum.USER_HAS_NOT_BIND_WX_ERROR.getMessage());
//            }

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
            acOrderBaseDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_WX.getCode());
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
            acOrderPayRecordDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_WX.getCode());
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

            //发起支付
            WxPayAppOrderResult result = unifiedOrder(acOrderBaseDO.getOrderNo(), acOrderBaseDO.getId(),
                    consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ? "在线充值支付" : "购买优惠卡",
                    consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ? "在线充值支付操作信息" : "购买优惠卡操作信息",
                    consumeType == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode() ? "ZF-ZXCZ" : "ZF-GMYHK", totalFeeTest, spbillCreateIp);

            WxPayAppOrderResultDTO wxPayAppOrderResultDTO = new WxPayAppOrderResultDTO();
            wxPayAppOrderResultDTO.setAppid(result.getAppId());
            wxPayAppOrderResultDTO.setNoncestr(result.getNonceStr());
            wxPayAppOrderResultDTO.setPackageX(result.getPackageValue());
            wxPayAppOrderResultDTO.setPartnerid(result.getPartnerId());
            wxPayAppOrderResultDTO.setPrepayid(result.getPrepayId());
            wxPayAppOrderResultDTO.setSign(result.getSign());
            wxPayAppOrderResultDTO.setTimestamp(result.getTimeStamp());

            return wxPayAppOrderResultDTO;
        } catch (WxPayException e) {
            throw new BusinessException(ResultCodeEnum.CREATE_PAY_ERROR.getCode(), ResultCodeEnum.CREATE_PAY_ERROR.getMessage());
        }
    }

    /***
     * @Author Melon
     * @Description 微信APP普通订单支付回调
     * @Date 19:57 2019/9/2
     * @Param [notityXml]
     * @Return java.lang.String
     **/
    @Transactional
    public String wxAppNormalOrderCallBack(String notityXml) {
        try {
            WxPayOrderNotifyResult wxResult = this.wxNotify(notityXml);
            String orderId = wxResult.getAttach();
            String transactionId =  wxResult.getTransactionId();

            //修改支付订单
            AcOrderBaseExample acOrderBaseExample = new AcOrderBaseExample();
            acOrderBaseExample.createCriteria()
                    .andIdEqualTo(Integer.parseInt(orderId));
            AcOrderBaseDO acOrderBaseDO =  acOrderBaseMapper.selectByExample(acOrderBaseExample).get(0);
            acOrderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
            acOrderBaseDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            Integer resultOrder = acOrderBaseMapper.updateByPrimaryKeySelective(acOrderBaseDO);
            if (resultOrder == 0){
                throw new BusinessException(ResultCodeEnum.AC_UPDATE_ORDER_BASE_FAILED.getCode(), ResultCodeEnum.AC_UPDATE_ORDER_BASE_FAILED.getMessage());
            }

            //查询支付流水记录
            AcOrderPayRecordExample acOrderPayRecordExample = new AcOrderPayRecordExample();
            acOrderPayRecordExample.createCriteria()
                    .andOrderIdEqualTo(Integer.parseInt(orderId))
                    .andOrderTypeEqualTo(OrderStatusEnum.ORDER_STATUS_TYPE_NORMAL.getCode());
            AcOrderPayRecordDO acOrderPayRecordDO = acOrderPayRecordMapper.selectByExample(acOrderPayRecordExample).get(0);
            acOrderPayRecordDO.setOutTradeNo(transactionId);
            acOrderPayRecordDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
            acOrderPayRecordDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            Integer resultRecord = acOrderPayRecordMapper.updateByPrimaryKeySelective(acOrderPayRecordDO);
            if (resultRecord == 0){
                throw new BusinessException(ResultCodeEnum.AC_UPDATE_ORDER_PAY_RECORD_FAILED.getCode(), ResultCodeEnum.AC_UPDATE_ORDER_PAY_RECORD_FAILED.getMessage());
            }

            if (acOrderBaseDO.getConsumeType() == OrderStatusEnum.ORDER_CONSUME_TYPE_RECHARGE.getCode()){
                //增加用户余额
                AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(acOrderBaseDO.getUserId());
                acUserDO.setCoin( acUserDO.getCoin() + acOrderBaseDO.getOrderCoin());
                Integer resultAcUser = acUserMapper.updateByPrimaryKeySelective(acUserDO);
                if (resultAcUser == 0){
                    throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
                }
            }else {
                AcUserPreferentialCardExample acUserPreferentialCardExample = new AcUserPreferentialCardExample();
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
            return WxPayNotifyResponse.success("处理成功!");
        } catch (Exception e) {
            e.printStackTrace();
            /*resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            logger.info("-------FAIL------resXml:" + resXml);*/
            return WxPayNotifyResponse.fail(e.getMessage());
        }
    }
}
