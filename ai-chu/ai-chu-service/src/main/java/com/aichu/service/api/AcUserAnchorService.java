package com.aichu.service.api;

import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.AgencyAnchorCenterDTO;
import com.aichu.service.dto.AgencyAnchorDTO;
import com.aichu.service.dto.UserAgencyNextUserDTO;
import com.aichu.service.dto.UserLikeDTO;

import java.util.List;

/**
 * @ClassName AcUserAnchorService
 * @Description 用户代理主播信息Service
 * @Author Melon
 * @Date 2019/7/23 11:41
 * @Version 1.0.0
 **/
public interface AcUserAnchorService {

    /***
     * @Author Melon
     * @Description 申请成为代理用户信息
     * @Date 16:47 2020/1/2
     * @Param [userId]
     * @Return java.lang.String
     **/
    String agencyApply(Integer userId) throws Exception;

    /***
     * @Author Melon
     * @Description 代理用户在线用户信息
     * @Date 17:45 2020/1/2
     * @Param [userId]
     * @Return com.aichu.service.dto.AgencyAnchorDTO
     **/
    List<AgencyAnchorDTO> agencyAnchors(Integer userId) throws Exception;
    
    /***
     * @Author Melon
     * @Description 代理用户添加主播用户信息
     * @Date 18:03 2020/1/2
     * @Param [keyWord, userId]
     * @Return java.lang.Boolean
     **/
    Boolean agencyAnchorFindByKeyWord(String keyWord, Integer userId) throws Exception;
    
    /***
     * @Author Melon
     * @Description 代理用户移除主播用户信息
     * @Date 18:00 2020/1/2
     * @Param [aimUserId, userId]
     * @Return java.lang.Boolean
     **/
    Boolean agencyAnchorRemove(Integer aimUserId, Integer userId) throws Exception;
    
    /***
     * @Author Melon
     * @Description 代理用户代理中心信息
     * @Date 19:07 2020/1/2
     * @Param [userId]
     * @Return com.aichu.service.dto.AgencyAnchorCenterDTO
     **/
    AgencyAnchorCenterDTO agencyAnchorCenter(Integer userId) throws Exception;

    /**
     * @Description 用户代理下级用戶列表信息-分页
     * @Author Melon
     * @Date 2020/3/11 17:21
     * @Param [userId, basePageOrder] 
     * @return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.UserAgencyNextUserDTO>> 
     **/
    BaseResponse<List<UserAgencyNextUserDTO>> userAgencyNextUserList(Integer userId, BasePageOrder basePageOrder) throws Exception;
}
