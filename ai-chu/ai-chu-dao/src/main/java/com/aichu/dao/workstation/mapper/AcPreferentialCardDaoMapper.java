package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcPreferentialCardBackDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @ClassName AcPreferentialCardDaoMapper
 * @Description 系统优惠卡信息Mapper
 * @Author Melon
 * @Date 2019/7/24 11:56
 * @Version 1.0.0
 **/
public interface AcPreferentialCardDaoMapper {
        
    /***
     * @Author Melon
     * @Description 查询用户签到次数
     * @Date 16:16 2019/12/31
     * @Param [userId, creatTime]
     * @Return java.lang.Integer
     **/
    Integer userSignTotalTimes(@Param("userId") Integer userId, @Param("createTime") String createTime);

    /**
     * @Description 后台优惠卡列表
     * @Author yuan.shuai
     * @Date 2020/2/17 18:34
     * @Param name
     * @Return List<AcPreferentialCardBackDao>
     * @Version 1.0.0
     **/
    List<AcPreferentialCardBackDao> getPreferentialCarList(@Param("name") String name);
}