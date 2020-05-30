package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AgencyAnchorCenterDao;
import com.aichu.dao.workstation.object.UserAgencyNextUserDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcUserAnchorDaoMapper
 * @Description 爱触用户代理主播信息DaoMapper
 * @Author Melon
 * @Date 2019/9/18 21:04
 * @Version 1.0.0
 **/
public interface AcUserAnchorDaoMapper {
    
    /***
     * @Author Melon
     * @Description 代理用户代理中心信息
     * @Date 19:03 2020/1/2
     * @Param [userId]
     * @Return com.aichu.dao.workstation.object.AgencyAnchorCenterDao
     **/
    AgencyAnchorCenterDao agencyAnchorCenter(@Param("userId") Integer userId);

    /**
     * @Description 用户代理下级用戶列表信息-分页
     * @Author Melon
     * @Date 2020/3/11 17:24
     * @Param [userId] 
     * @return java.util.List<com.aichu.dao.workstation.object.UserAgencyNextUserDao> 
     **/
    List<UserAgencyNextUserDao> userAgencyNextUserList(@Param("userId") Integer userId);
}
