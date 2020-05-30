package com.aichu.service.api.impl;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.common.util.sign.AcSignUtils;
import com.aichu.dao.autogeneration.mapper.*;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.dao.workstation.mapper.AcOrderBaseDaoMapper;
import com.aichu.dao.workstation.mapper.AcSysSystemConfigDaoMapper;
import com.aichu.dao.workstation.object.AcOrderBaseBackDao;
import com.aichu.dao.workstation.object.AcOrderBaseRefundBackDao;
import com.aichu.dao.workstation.object.AcOrderWithdrawBackDao;
import com.aichu.dao.workstation.object.UserWalletBillDao;
import com.aichu.manager.api.alipay.AliRefundService;
import com.aichu.manager.enums.*;
import com.aichu.service.api.AcOrderBaseService;
import com.aichu.service.api.AcSysSystemConfigService;
import com.aichu.service.dto.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.egzosn.pay.ali.api.AliPayService;
import com.egzosn.pay.ali.bean.AliTransferType;
import com.egzosn.pay.common.bean.TransferOrder;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName AcOrderBaseServiceImpl
 * @Description 爱触订单信息ServiceImpl
 * @Author Melon
 * @Date 2019/9/18 19:09
 * @Version 1.0.0
 **/
@Service
public class AcOrderBaseServiceImpl implements AcOrderBaseService {

    private Logger logger = LoggerFactory.getLogger(AcOrderBaseServiceImpl.class);

    @Autowired
    private AliRefundService aliRefundService;

    @Autowired
    private AcOrderBaseMapper acOrderBaseMapper;

    @Autowired
    private AcOrderBaseDaoMapper acOrderBaseDaoMapper;

    @Autowired
    private AcOrderPayRecordMapper acOrderPayRecordMapper;

    @Autowired
    private AcChartGoodsMapper acChartGoodsMapper;

    @Autowired
    private AcUserOauthMapper acUserOauthMapper;

    @Autowired
    private AcChartGoodsRecordMapper acChartGoodsRecordMapper;

    @Autowired
    private AcUserMapper acUserMapper;

    @Autowired
    private AcUserAnchorMapper acUserAnchorMapper;

    @Autowired
    private AcSysAgentConfigMapper acSysAgentConfigMapper;

    @Autowired
    private AcSysSystemConfigService acSysSystemConfigService;

    @Autowired
    private AcOrderRefundRecordMapper acOrderRefundRecordMapper;

    @Autowired
    private AcOrderWithdrawMapper acOrderWithdrawMapper;

    @Autowired
    private AcSysSystemConfigDaoMapper acSysSystemConfigDaoMapper;

    @Override
    public UserChartCheckDTO userChartCheck(String aimUserAccId, Integer userId) throws Exception {
        logger.info("--------------聊天通话计费检查-----------Start-- aimUserAccId:--{}, userId:--{}", aimUserAccId, userId);

        UserChartCheckDTO userChartCheckDTO = new UserChartCheckDTO();
        //查询目标用户金币
        AcUserExample aimAcUserExample = new AcUserExample();
        aimAcUserExample.createCriteria()
                .andAcUidEqualTo(aimUserAccId)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserDO> aimAcUserDOList = acUserMapper.selectByExample(aimAcUserExample);
        if (Utils.isEmpty(aimAcUserDOList)){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        //当前用户信息
        AcUserDO currUserDO = acUserMapper.selectByPrimaryKey(userId);

        //查询聊天报警提醒时间
        Integer chartWarnTime = Integer.parseInt(acSysSystemConfigService.systemPolicy(SysConfigEnum.SYS_SYSTEM_CONFIG_KEY_CHART_WARN_TIME.getTag(), userId));
        userChartCheckDTO.setChartCost(aimAcUserDOList.get(0).getChartCost());
        userChartCheckDTO.setUserAmount(currUserDO.getCoin());
        userChartCheckDTO.setWarmChartTime(chartWarnTime);
        if (aimAcUserDOList.get(0).getChartCost() != 0){
            Double canChartTime = Math.floor(currUserDO.getCoin() / aimAcUserDOList.get(0).getChartCost());
            userChartCheckDTO.setCanChartTime(canChartTime.intValue());
        }else {
            userChartCheckDTO.setCanChartTime(999999999);
        }
        //调用支付宝提现接口
        logger.info("--------------聊天通话计费检查----------End");
        return userChartCheckDTO;
    }

    @Override
    @Transactional
    public Boolean userUndefineBalancePay(UserUndefineBalancePayDTO userUndefineBalancePayDTO, Integer userId) throws Exception {
        logger.info("--------------用户余额统一下单支付-----------Start-- userUndefineBalancePayDTO:--{}, userId:--{}", userUndefineBalancePayDTO, userId);

        Integer orderAmount = 0;
        AcUserDO currAcUserDO = acUserMapper.selectByPrimaryKey(userId);
        //查询目标用户ID
        AcUserExample aimAcUserExample = new AcUserExample();
        aimAcUserExample.createCriteria()
                .andAcUidEqualTo(userUndefineBalancePayDTO.getAimUserAccId())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserDO> aimAcUserDOList = acUserMapper.selectByExample(aimAcUserExample);
        if (Utils.isEmpty(aimAcUserDOList)){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        //生成订单基础信息
        AcOrderBaseDO acOrderBaseDO = new AcOrderBaseDO();
        acOrderBaseDO.setUserId(userId);
        acOrderBaseDO.setOrderNo(AcSignUtils.systemAcOrderNo());
        acOrderBaseDO.setPayUse(OrderStatusEnum.ORDER_STATUS_PAY_USE_COST.getCode());
        acOrderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
        acOrderBaseDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_BALANCE.getCode());
        acOrderBaseDO.setReceiveUserId(aimAcUserDOList.get(0).getId());

        //聊天支付
        if (userUndefineBalancePayDTO.getPayType().equals(OrderStatusEnum.ORDER_SOURCE_PAY_WAY_CHART.getCode())){
            orderAmount = aimAcUserDOList.get(0).getChartCost() * (userUndefineBalancePayDTO.getChartTime() < 60 ? 1 : new BigDecimal(userUndefineBalancePayDTO.getChartTime()).divide(new BigDecimal(60)).setScale( 0, BigDecimal.ROUND_UP )).intValue();
            if (currAcUserDO.getCoin() < orderAmount){
                throw new BusinessException(ResultCodeEnum.USER_COIN_NOT_ENOUGH.code(), ResultCodeEnum.USER_COIN_NOT_ENOUGH.message());
            }
            acOrderBaseDO.setOrderAmount(orderAmount);
            acOrderBaseDO.setOrderCoin(orderAmount);
            acOrderBaseDO.setConsumeType(OrderStatusEnum.ORDER_CONSUME_TYPE_LIVE_PAY.getCode());
            Integer resultOrder = acOrderBaseMapper.insertSelective(acOrderBaseDO);
            if (resultOrder == 0){
                throw new BusinessException(ResultCodeEnum.USER_ORDER_BASE_CREATE_ERROR.code(), ResultCodeEnum.USER_ORDER_BASE_CREATE_ERROR.message());
            }
        //打赏
        }else {
            //查看商品信息
            AcChartGoodsDO acChartGoodsDO = acChartGoodsMapper.selectByPrimaryKey(userUndefineBalancePayDTO.getGoodsId());
            if (acChartGoodsDO == null){
                throw new BusinessException(ResultCodeEnum.USER_CHART_GOODS_NOT_EXIST.code(), ResultCodeEnum.USER_CHART_GOODS_NOT_EXIST.message());
            }
            orderAmount = acChartGoodsDO.getGoodsMoney() * userUndefineBalancePayDTO.getGoodsNum();
            if (currAcUserDO.getCoin() < (orderAmount + aimAcUserDOList.get(0).getChartCost() * (userUndefineBalancePayDTO.getChartTime() < 60 ? 1 : new BigDecimal(userUndefineBalancePayDTO.getChartTime()).divide(new BigDecimal(60)).setScale( 0, BigDecimal.ROUND_UP )).intValue())){
                throw new BusinessException(ResultCodeEnum.USER_COIN_NOT_ENOUGH.code(), ResultCodeEnum.USER_COIN_NOT_ENOUGH.message());
            }
            acOrderBaseDO.setOrderAmount(orderAmount);
            acOrderBaseDO.setOrderCoin(orderAmount);
            acOrderBaseDO.setConsumeType(OrderStatusEnum.ORDER_CONSUME_TYPE_LIVE_REWARD.getCode());

            Integer resultOrder = acOrderBaseMapper.insertSelective(acOrderBaseDO);
            if (resultOrder == 0){
                throw new BusinessException(ResultCodeEnum.USER_ORDER_BASE_CREATE_ERROR.code(), ResultCodeEnum.USER_ORDER_BASE_CREATE_ERROR.message());
            }

            //生产商品购买记录
            AcChartGoodsRecordDO acChartGoodsRecordDO = new AcChartGoodsRecordDO();
            acChartGoodsRecordDO.setUserId(userId);
            acChartGoodsRecordDO.setOrderId(acOrderBaseDO.getId());
            acChartGoodsRecordDO.setGoodsId(userUndefineBalancePayDTO.getGoodsId());
            acChartGoodsRecordDO.setGoodsNum(userUndefineBalancePayDTO.getGoodsNum());
            Integer resultGoods = acChartGoodsRecordMapper.insertSelective(acChartGoodsRecordDO);
            if (resultGoods == 0){
                throw new BusinessException(ResultCodeEnum.USER_CHART_GOODS_CREATE_ERROR.code(), ResultCodeEnum.USER_CHART_GOODS_CREATE_ERROR.message());
            }
        }

        //生成订单基础信息
        AcOrderPayRecordDO acOrderPayRecordDO = new AcOrderPayRecordDO();
        acOrderPayRecordDO.setOrderId(acOrderBaseDO.getId());
        acOrderPayRecordDO.setOrderAmount(acOrderBaseDO.getOrderAmount());
        acOrderPayRecordDO.setOrderCoin(acOrderBaseDO.getOrderCoin());
        acOrderPayRecordDO.setPayTradeNo(acOrderBaseDO.getOrderNo());
        acOrderPayRecordDO.setOrderType(OrderStatusEnum.ORDER_STATUS_TYPE_NORMAL.getCode());
        acOrderPayRecordDO.setConsumeType(acOrderBaseDO.getConsumeType());
        acOrderPayRecordDO.setPayUse(OrderStatusEnum.ORDER_STATUS_PAY_USE_COST.getCode());
        acOrderPayRecordDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_BALANCE.getCode());
        acOrderPayRecordDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
        acOrderPayRecordDO.setReceiveUserId(aimAcUserDOList.get(0).getId());
        Integer resultOrderPay = acOrderPayRecordMapper.insertSelective(acOrderPayRecordDO);
        if (resultOrderPay == 0){
            throw new BusinessException(ResultCodeEnum.USER_ORDER_PAY_RECORD_CREATE_ERROR.code(), ResultCodeEnum.USER_ORDER_PAY_RECORD_CREATE_ERROR.message());
        }

        //查询主播上级代理用户信息
        Integer totalOrderAmount = orderAmount;
        AcUserAnchorExample acUserAnchorExample = new AcUserAnchorExample();
        acUserAnchorExample.createCriteria()
                .andAnchorUserIdEqualTo(aimAcUserDOList.get(0).getId())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserAnchorDO> acUserAnchorDOList = acUserAnchorMapper.selectByExample(acUserAnchorExample);
        if (!Utils.isEmpty(acUserAnchorDOList)){
            acUserAnchorDOList.stream().forEach( acUserAnchorDO -> {
                //查询用户代理级别对应的比例提成分红
                AcUserDO agencyUserDO = acUserMapper.selectByPrimaryKey(acUserAnchorDO.getUserId());
                if (agencyUserDO == null){
                    throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
                }
                if (agencyUserDO.getAgentLevel() != 0){
                    AcSysAgentConfigExample acSysAgentConfigExample = new AcSysAgentConfigExample();
                    acSysAgentConfigExample.createCriteria()
                            .andLevelEqualTo(agencyUserDO.getAgentLevel())
                            .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
                    List<AcSysAgentConfigDO> acSysAgentConfigExampleList = acSysAgentConfigMapper.selectByExample(acSysAgentConfigExample);
                    if (Utils.isEmpty(acSysAgentConfigExampleList)){
                        throw new BusinessException(ResultCodeEnum.USER_AGENCY_LEVEL_NOT_EXIST.code(), ResultCodeEnum.USER_AGENCY_LEVEL_NOT_EXIST.message());
                    }

                    AcOrderBaseDO agencyAcOrderBaseDO = new AcOrderBaseDO();
                    agencyAcOrderBaseDO.setUserId(acUserAnchorDO.getUserId());
                    agencyAcOrderBaseDO.setOrderNo(AcSignUtils.systemAcOrderNo());
                    agencyAcOrderBaseDO.setPayUse(OrderStatusEnum.ORDER_STATUS_PAY_USE_CHARGE.getCode());
                    agencyAcOrderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
                    agencyAcOrderBaseDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_BALANCE.getCode());
                    agencyAcOrderBaseDO.setOrderAmount(totalOrderAmount * (acSysAgentConfigExampleList.get(0).getDeductRate() / 100));
                    agencyAcOrderBaseDO.setOrderCoin(totalOrderAmount * (acSysAgentConfigExampleList.get(0).getDeductRate() / 100));
                    agencyAcOrderBaseDO.setConsumeType(OrderStatusEnum.ORDER_CONSUME_TYPE_AGENCY_INCOME.getCode());
                    Integer resultAgencyOrder = acOrderBaseMapper.insertSelective(agencyAcOrderBaseDO);
                    if (resultAgencyOrder == 0){
                        throw new BusinessException(ResultCodeEnum.USER_ORDER_BASE_CREATE_ERROR.code(), ResultCodeEnum.USER_ORDER_BASE_CREATE_ERROR.message());
                    }

                    AcOrderPayRecordDO agencyAcOrderPayRecordDO = new AcOrderPayRecordDO();
                    agencyAcOrderPayRecordDO.setOrderId(agencyAcOrderBaseDO.getId());
                    agencyAcOrderPayRecordDO.setOrderAmount(agencyAcOrderBaseDO.getOrderAmount());
                    agencyAcOrderPayRecordDO.setOrderCoin(agencyAcOrderBaseDO.getOrderCoin());
                    agencyAcOrderPayRecordDO.setPayTradeNo(agencyAcOrderBaseDO.getOrderNo());
                    agencyAcOrderPayRecordDO.setOrderType(OrderStatusEnum.ORDER_STATUS_TYPE_NORMAL.getCode());
                    agencyAcOrderPayRecordDO.setConsumeType(acOrderBaseDO.getConsumeType());
                    agencyAcOrderPayRecordDO.setPayUse(OrderStatusEnum.ORDER_STATUS_PAY_USE_CHARGE.getCode());
                    agencyAcOrderPayRecordDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_BALANCE.getCode());
                    agencyAcOrderPayRecordDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode());
                    Integer resultAgencyOrderPay = acOrderPayRecordMapper.insertSelective(agencyAcOrderPayRecordDO);
                    if (resultAgencyOrderPay == 0){
                        throw new BusinessException(ResultCodeEnum.USER_ORDER_PAY_RECORD_CREATE_ERROR.code(), ResultCodeEnum.USER_ORDER_PAY_RECORD_CREATE_ERROR.message());
                    }

                    //增加代理账户余额
                    agencyUserDO.setCoin(agencyUserDO.getCoin() + totalOrderAmount * (acSysAgentConfigExampleList.get(0).getDeductRate() / 100));
                    Integer resultUser = acUserMapper.updateByPrimaryKeySelective(agencyUserDO);
                    if (resultUser == 0){
                        throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
                    }
                }
            });
        }

        //增加直播用户余额
        Integer anchorDeductRate = Integer.parseInt(acSysSystemConfigService.systemPolicy(SysConfigEnum.SYS_SYSTEM_CONFIG_KEY_ANCHOR_DEDUCT_RATE.getTag(), userId));
        AcUserDO liveUser =  aimAcUserDOList.get(0);
        liveUser.setCoin(aimAcUserDOList.get(0).getCoin() + totalOrderAmount * (anchorDeductRate / 100));
        Integer resultAimUser = acUserMapper.updateByPrimaryKeySelective(liveUser);
        if (resultAimUser == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        //扣除用户余额
        currAcUserDO.setCoin(currAcUserDO.getCoin() - totalOrderAmount);
        Integer resultCurrUser = acUserMapper.updateByPrimaryKeySelective(currAcUserDO);
        if (resultCurrUser == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        logger.info("--------------用户余额统一下单支付----------End");
        return true;
    }

    @Override
    public Boolean applyBalanceWithDraw(BalanceWithDrawDTO balanceWithDrawDTO, Integer userId) throws Exception {
        logger.info("--------------余额提现--提现申请-----------Start-- balanceWithDrawDTO:--{}, userId:--{}", balanceWithDrawDTO, userId);

        //查询充值比例
        AcSysConfigDO acSysConfigDO = acSysSystemConfigDaoMapper.systemPolicy(SysConfigEnum.SYS_SYSTEM_CONFIG_KEY_CHARGE_RATE.getTag());

        //查询余额是否充足
        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        if (acUserDO.getCoin() / Integer.parseInt(acSysConfigDO.getValue()) < balanceWithDrawDTO.getAmount() / 100){
            throw new BusinessException(ResultCodeEnum.AC_USER_AMOUNT_HAS_NOT_ENOUGH.code(), ResultCodeEnum.AC_USER_AMOUNT_HAS_NOT_ENOUGH.message());
        }

        //生成订单记录
        AcOrderBaseDO acOrderBaseDO = new AcOrderBaseDO();
        acOrderBaseDO.setUserId(userId);
        acOrderBaseDO.setOrderNo(AcSignUtils.systemAcOrderNo());
        acOrderBaseDO.setOrderCoin(balanceWithDrawDTO.getAmount() / 100  * Integer.parseInt(acSysConfigDO.getValue()));
        acOrderBaseDO.setOrderAmount(balanceWithDrawDTO.getAmount());
        acOrderBaseDO.setConsumeType(OrderStatusEnum.ORDER_CONSUME_TYPE_WITHDRAW.getCode());
        acOrderBaseDO.setPayUse(OrderStatusEnum.ORDER_STATUS_PAY_USE_WITHDRAW.getCode());
        acOrderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_REFUND_ING.getCode());
        acOrderBaseDO.setPayType(OrderStatusEnum.ORDER_STATUS_PAY_WAY_BALANCE.getCode());
        Integer resultOrder = acOrderBaseMapper.insertSelective(acOrderBaseDO);
        if (resultOrder == 0){
            throw new BusinessException(ResultCodeEnum.AC_CREATE_ORDER_BASE_FAILED.code(), ResultCodeEnum.AC_CREATE_ORDER_BASE_FAILED.message());
        }

        //生成提现记录信息
        AcOrderWithdrawDO acOrderWithdrawDO = new AcOrderWithdrawDO();
        acOrderWithdrawDO.setOrderId(acOrderBaseDO.getId());
        acOrderWithdrawDO.setWithDrawDes("账户余额提现");
        acOrderWithdrawDO.setWithDrawMoney(balanceWithDrawDTO.getAmount());
        acOrderWithdrawDO.setWithDrawNickName(balanceWithDrawDTO.getAccountName());
        acOrderWithdrawDO.setWithDrawAccount(balanceWithDrawDTO.getAccount());
        acOrderWithdrawDO.setWithDrawStatus(OrderStatusEnum.ORDER_STATUS_WITH_DRAW_ING.getCode());
        acOrderWithdrawDO.setWithDrawType(balanceWithDrawDTO.getWithDrawType());
        Integer resultWithdraw = acOrderWithdrawMapper.insertSelective(acOrderWithdrawDO);
        if (resultWithdraw == 0){
            throw new BusinessException(ResultCodeEnum.AC_CREATE_ORDER_WITH_DRAW_RECORD_FAILED.code(), ResultCodeEnum.AC_CREATE_ORDER_WITH_DRAW_RECORD_FAILED.message());
        }

        acUserDO.setCoin(acUserDO.getCoin() - balanceWithDrawDTO.getAmount() / 100 * Integer.parseInt(acSysConfigDO.getValue()));
        Integer result = acUserMapper.updateByPrimaryKeySelective(acUserDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        logger.info("--------------余额提现--提现申请----------End");
        return true;
    }

    @Override
    public BaseResponse<List<UserWalletBillDTO>> userWalletBill(UserWalletBillReqDTO userWalletBillReqDTO, Integer userId) throws Exception {
        logger.info("--------------用户账单明细--分页-----------Start-- userWalletBillReqDTO:--{}, userId:--{}", userWalletBillReqDTO, userId);

        Page<UserWalletBillDao> pages = PageHelper.startPage(userWalletBillReqDTO.getPageNum(), userWalletBillReqDTO.getPageSize());
        List<UserWalletBillDao> userWalletBillDaoList = acOrderBaseDaoMapper.userWalletBill(userWalletBillReqDTO.getChooseDate(), userId);

        logger.info("--------------用户账单明细--分页----------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(userWalletBillDaoList, UserWalletBillDTO.class));
    }

    @Override
    public BaseResponse<List<AcOrderBaseBackDTO>> getOrderBaseBackList(AcOrderBaseQueryDTO queryDTO) throws Exception {
        logger.info("--------------后台订单列表查询----------Start");
        Page<AcOrderBaseBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcOrderBaseBackDao> list = acOrderBaseDaoMapper.getOrderBaseList(queryDTO.getName(),queryDTO.getConsumeType(),
                queryDTO.getPreferentialCardType(),queryDTO.getPayUse(),queryDTO.getStartCreateTime(),queryDTO.getEndCreateTime());
        logger.info("--------------后台订单列表查询----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcOrderBaseBackDTO.class));
    }

    @Override
    public BaseResponse<List<AcOrderBaseRefundBackDTO>> getOrderBaseRefundBackList(AcOrderBaseRefundQueryDTO queryDTO) throws Exception {
        logger.info("--------------后台退款订单列表查询----------Start");
        Page<AcOrderBaseRefundBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcOrderBaseRefundBackDao> list = acOrderBaseDaoMapper.getOrderBaseRefundList(queryDTO.getName(),queryDTO.getRefundStatus(),
                queryDTO.getConsumeType(),queryDTO.getStartCreateTime(),queryDTO.getEndCreateTime());
        logger.info("--------------后台退款订单列表查询----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcOrderBaseRefundBackDTO.class));
    }

    @Override
    public BaseResponse<List<AcOrderWithdrawBackDTO>> getOrderWithdrawBackList(AcOrderWithdrawQueryDTO queryDTO) throws Exception {
        logger.info("--------------后台提现订单列表查询----------Start");
        Page<AcOrderWithdrawBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcOrderWithdrawBackDao> list = acOrderBaseDaoMapper.getOrderWithdrawList(queryDTO.getName(),queryDTO.getWithDrawStatus()
                ,queryDTO.getStartCreateTime(),queryDTO.getEndCreateTime());
        logger.info("--------------后台提现订单列表查询----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcOrderWithdrawBackDTO.class));
    }

    @Override
    @Transactional
    public Boolean auditOrderRefund(AcOrderAuditDTO auditDTO) throws Exception {
        logger.info("--------------后台退款处理----------Start");
        if (Utils.isEmpty(auditDTO)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcOrderRefundRecordDO recordDO = acOrderRefundRecordMapper.selectByPrimaryKey(auditDTO.getId());
        if (Utils.isEmpty(recordDO)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        AcOrderBaseDO orderBaseDO = acOrderBaseMapper.selectByPrimaryKey(recordDO.getOrderId());
        if (Utils.isEmpty(orderBaseDO)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        if (Objects.equals(auditDTO.getStatus(),OrderStatusEnum.ORDER_REFUND_STATUS_HAS_REFUSE.getCode())){ // 拒绝
            recordDO.setRefundStatus(OrderStatusEnum.ORDER_REFUND_STATUS_HAS_REFUSE.getCode());
            recordDO.setDealTime(new Date());
            orderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_REFUSE.getCode());
            Integer recordResult =  acOrderRefundRecordMapper.updateByPrimaryKeySelective(recordDO);
            Integer orderResult = acOrderBaseMapper.updateByPrimaryKeySelective(orderBaseDO);
            if (recordResult == 0 || orderResult == 0){
                throw new BusinessException(ResultCodeEnum.AC_ORDER_REFUND_RECORD_ERROR.code(), ResultCodeEnum.AC_ORDER_REFUND_RECORD_ERROR.message());
            }
        } else if (Objects.equals(auditDTO.getStatus(),OrderStatusEnum.ORDER_REFUND_STATUS_REFUND_AGREE.getCode())) { // 通过
            recordDO.setRefundStatus(OrderStatusEnum.ORDER_REFUND_STATUS_REFUND_AGREE.getCode());
            recordDO.setDealTime(new Date());
            orderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_REFUND.getCode());
            Integer recordResult =  acOrderRefundRecordMapper.updateByPrimaryKeySelective(recordDO);
            Integer orderResult = acOrderBaseMapper.updateByPrimaryKeySelective(orderBaseDO);
            if (recordResult == 0 || orderResult == 0){
                throw new BusinessException(ResultCodeEnum.AC_ORDER_REFUND_RECORD_ERROR.code(), ResultCodeEnum.AC_ORDER_REFUND_RECORD_ERROR.message());
            }
        } else {
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        logger.info("--------------后台退款处理----------End");
        return Boolean.TRUE;
    }

    @Override
    @Transactional
    public Boolean auditOrderWithdraw(AcOrderAuditDTO auditDTO) throws Exception {
        logger.info("--------------后台提现处理----------Start");
        if (Utils.isEmpty(auditDTO)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcOrderWithdrawDO withdrawDO = acOrderWithdrawMapper.selectByPrimaryKey(auditDTO.getId());
        if (Utils.isEmpty(withdrawDO)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        AcOrderBaseDO orderBaseDO = acOrderBaseMapper.selectByPrimaryKey(withdrawDO.getOrderId());
        if (Utils.isEmpty(orderBaseDO)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        if (Objects.equals(auditDTO.getStatus(),OrderStatusEnum.ORDER_REFUND_STATUS_HAS_REFUSE.getCode())){ // 拒绝
            withdrawDO.setWithDrawStatus(OrderStatusEnum.ORDER_STATUS_WITH_DRAW_REFUSE.getCode());
            orderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_REFUSE.getCode());
            Integer recordResult =  acOrderWithdrawMapper.updateByPrimaryKeySelective(withdrawDO);
            Integer orderResult = acOrderBaseMapper.updateByPrimaryKeySelective(orderBaseDO);
            if (recordResult == 0 || orderResult == 0){
                throw new BusinessException(ResultCodeEnum.AC_ORDER_WITHDRAW_ERROR.code(), ResultCodeEnum.AC_ORDER_WITHDRAW_ERROR.message());
            }
        } else if (Objects.equals(auditDTO.getStatus(),OrderStatusEnum.ORDER_REFUND_STATUS_REFUND_AGREE.getCode())) { // 通过
            withdrawDO.setWithDrawStatus(OrderStatusEnum.ORDER_STATUS_WITH_DRAW_SUCCESS.getCode());
            orderBaseDO.setPayStatus(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_SUCCESS.getCode());
            Integer recordResult =  acOrderWithdrawMapper.updateByPrimaryKeySelective(withdrawDO);
            Integer orderResult = acOrderBaseMapper.updateByPrimaryKeySelective(orderBaseDO);
            if (recordResult == 0 || orderResult == 0){
                throw new BusinessException(ResultCodeEnum.AC_ORDER_WITHDRAW_ERROR.code(), ResultCodeEnum.AC_ORDER_WITHDRAW_ERROR.message());
            }
            //支付宝操作
            aliRefundService.aliApplyBalanceWithDraw(withdrawDO.getWithDrawMoney(),orderBaseDO.getUserId(),orderBaseDO.getId());
            logger.info("支付宝申请提现--End--");
        } else {
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        logger.info("--------------后台提现处理----------End");
        return Boolean.TRUE;
    }
}
