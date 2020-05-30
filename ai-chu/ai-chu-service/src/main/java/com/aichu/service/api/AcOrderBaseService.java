package com.aichu.service.api;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.*;

import java.util.List;

/**
 * @ClassName AcOrderBaseService
 * @Description 爱触订单信息Service
 * @Author Melon
 * @Date 2019/9/18 19:08
 * @Version 1.0.0
 **/
public interface AcOrderBaseService {

    /***
     * @Author Melon
     * @Description 聊天通话计费检查
     * @Date 9:28 2020/1/10
     * @Param [aimUserAccId, userId]
     * @Return com.aichu.service.dto.UserChartCheckDTO
     **/
    UserChartCheckDTO userChartCheck(String aimUserAccId, Integer userId) throws Exception;

    /***
     * @Author Melon
     * @Description 用户余额统一下单支付
     * @Date 16:23 2020/1/10
     * @Param [userUndefineBalancePayDTO, userId]
     * @Return java.lang.Boolean
     **/
    Boolean userUndefineBalancePay(UserUndefineBalancePayDTO userUndefineBalancePayDTO, Integer userId) throws Exception;
    
    /**
     * @Description 余额提现--提现申请
     * @Author Melon
     * @Date 2020/2/27 17:50
     * @Param [balanceWithDrawDTO, userId] 
     * @return java.lang.Boolean 
     **/
    Boolean applyBalanceWithDraw(BalanceWithDrawDTO balanceWithDrawDTO, Integer userId) throws Exception;
    
    /***
     * @Author Melon
     * @Description 用户账单明细--分页
     * @Date 19:19 2020/1/10
     * @Param [userWalletBillReqDTO, userId]
     * @Return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.UserWalletBillDTO>>
     **/
    BaseResponse<List<UserWalletBillDTO>> userWalletBill(UserWalletBillReqDTO userWalletBillReqDTO, Integer userId) throws Exception;

    /**
     * @Description 后台订单列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 15:44
     * @Param AcOrderBaseQueryDTO
     * @Return BaseResponse<List<AcOrderBaseBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcOrderBaseBackDTO>> getOrderBaseBackList(AcOrderBaseQueryDTO queryDTO) throws Exception;

    /**
     * @Description 后台退款列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 15:44
     * @Param AcOrderBaseRefundQueryDTO
     * @Return BaseResponse<List<AcOrderBaseRefundBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcOrderBaseRefundBackDTO>> getOrderBaseRefundBackList(AcOrderBaseRefundQueryDTO queryDTO) throws Exception;

    /**
     * @Description 后台提现订单列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 15:44
     * @Param AcOrderWithdrawQueryDTO
     * @Return BaseResponse<List<AcOrderWithdrawBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcOrderWithdrawBackDTO>> getOrderWithdrawBackList(AcOrderWithdrawQueryDTO queryDTO) throws Exception;

    /**
     * @Description 后台退款处理
     * @Author yuan.shuai
     * @Date 2020/2/17 17:29
     * @Param AcOrderAuditDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean auditOrderRefund(AcOrderAuditDTO auditDTO) throws Exception;

    /**
     * @Description 后台提现处理
     * @Author yuan.shuai
     * @Date 2020/2/17 17:29
     * @Param AcOrderAuditDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean auditOrderWithdraw(AcOrderAuditDTO auditDTO) throws Exception;
}
