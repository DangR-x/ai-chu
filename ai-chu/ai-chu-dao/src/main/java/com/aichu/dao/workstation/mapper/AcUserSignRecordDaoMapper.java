package com.aichu.dao.workstation.mapper;

import com.aichu.dao.autogeneration.object.AcUserSignRecordDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @ClassName AcUserSignRecordDaoMapper
 * @Description 爱触用户签到信息DaoMapper
 * @Author Melon
 * @Date 2019/9/18 21:04
 * @Version 1.0.0
 **/
public interface AcUserSignRecordDaoMapper {
    
    /***
     * @Author Melon
     * @Description 查询用户优惠卡签到信息
     * @Date 11:13 2020/1/14
     * @Param [userId]
     * @Return java.util.List<com.aichu.dao.autogeneration.object.AcUserSignRecordDO>
     **/
    List<AcUserSignRecordDO> signRecordByPreferentialCard(@Param("userId") Integer userId, @Param("createTime") Date createTime);
    
    /***
     * @Author Melon
     * @Description 用户今日是否已经签到
     * @Date 1:39 2020/2/22
     * @Param [userId]
     * @Return com.aichu.dao.autogeneration.object.AcUserSignRecordDO
     **/
    AcUserSignRecordDO userIsSignToDay(@Param("userId") Integer userId);
}
