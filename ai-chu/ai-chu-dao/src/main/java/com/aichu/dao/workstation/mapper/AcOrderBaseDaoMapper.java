package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcOrderBaseBackDao;
import com.aichu.dao.workstation.object.AcOrderBaseRefundBackDao;
import com.aichu.dao.workstation.object.AcOrderWithdrawBackDao;
import com.aichu.dao.workstation.object.UserWalletBillDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcOrderBaseDaoMapper
 * @Description 用户订单基础信息Mapper
 * @Author Melon
 * @Date 2019/7/24 11:56
 * @Version 1.0.0
 **/
public interface AcOrderBaseDaoMapper {

    /***
     * @Author Melon
     * @Description 用户账单明细--分页
     * @Date 16:42 2020/1/10
     * @Param [chooseDate, userId]
     * @Return java.util.List<com.aichu.dao.workstation.object.UserWalletBillDao>
     **/
    List<UserWalletBillDao> userWalletBill(@Param("chooseDate") String chooseDate, @Param("userId") Integer userId);

    /**
     * @Description 后台订单列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 14:25
     * @Param name，consumeType，preferentialCardType，payUse
     * @Return List<AcOrderBaseBackDao>
     * @Version 1.0.0
     **/
    List<AcOrderBaseBackDao> getOrderBaseList(@Param("name") String name,
                                              @Param("consumeType") Integer consumeType,
                                              @Param("preferentialCardType") Integer preferentialCardType,
                                              @Param("payUse") Integer payUse,
                                              @Param("startCreateTime") String startCreateTime,
                                              @Param("endCreateTime") String endCreateTime);

    /**
     * @Description 后台退款列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 15:06
     * @Param name，refundStatus
     * @Return List<AcOrderBaseRefundBackDao>
     * @Version 1.0.0
     **/
    List<AcOrderBaseRefundBackDao> getOrderBaseRefundList(@Param("name") String name,
                                                          @Param("refundStatus") Integer refundStatus,
                                                          @Param("consumeType") Integer consumeType,
                                                          @Param("startCreateTime") String startCreateTime,
                                                          @Param("endCreateTime") String endCreateTime);

    /**
     * @Description 后台提现列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 15:32
     * @Param name，withDrawStatus
     * @Return List<AcOrderWithdrawBackDao>
     * @Version 1.0.0
     **/
    List<AcOrderWithdrawBackDao> getOrderWithdrawList(@Param("name") String name,
                                                      @Param("withDrawStatus") Integer withDrawStatus,
                                                      @Param("startCreateTime") String startCreateTime,
                                                      @Param("endCreateTime") String endCreateTime);
}