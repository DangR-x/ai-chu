package com.aichu.dao.workstation.mapper;

import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.dao.workstation.object.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcUserDaoMapper
 * @Description 系统用户信息Mapper
 * @Author Melon
 * @Date 2019/7/24 11:56
 * @Version 1.0.0
 **/
public interface AcUserDaoMapper {

    /***
     * @Author Melon
     * @Description 根据用户电话查询用户信息
     * @Date 15:18 2019/12/26
     * @Param [phone]
     * @Return com.aichu.dao.autogeneration.object.AcUserDO
     **/
    AcUserDO selectAcUserByPhone(@Param("phone") String phone);

    /***
     * @Author Melon
     * @Description 根据用户关键词查询用户信息
     * @Date 18:13 2020/1/2
     * @Param [keyWord]
     * @Return com.aichu.dao.autogeneration.object.AcUserDO
     **/
    AcUserDO selectAcUserByKeyWord(@Param("keyWord") String keyWord);

    /***
     * @Author Melon
     * @Description 用户个人主页信息资料
     * @Date 16:22 2019/12/27
     * @Param [aimUserId, userId]
     * @Return com.aichu.dao.workstation.object.PersonalHomePageDao
     **/
    PersonalHomePageDao personalHomePage(@Param("aimUserAcId") String aimUserAcId, @Param("userId") Integer userId);
    
    /***
     * @Author Melon
     * @Description 用户关注人列表信息-分页
     * @Date 22:10 2020/2/20
     * @Param [userId]
     * @Return java.util.List<com.aichu.dao.workstation.object.UserLikeDao>
     **/
    List<UserLikeDao> userLikeList(@Param("userId") Integer userId);

    /**
     * @Description 后台获取用户列表
     * @Param name, level, isFreeze
     * @Return List<AcBackUserDao>
     * @Author yuan.shuai
     * @Date 2019/11/4
     * @Version 1.0.0
     */
    List<AcBackUserDao> getUserBackList(@Param("name") String name,
                                        @Param("level") Integer level,
                                        @Param("isFreeze") Integer isFreeze);

    /**
     * @Description 后台查询用户详情
     * @Author yuan.shuai
     * @Date 2019/12/31 10:32
     * @Param id
     * @Return AcBackUserDao
     * @Version 1.0.0
     **/
    AcBackUserDao getUserBackDetail(@Param("id") Integer id);

    /**
     * @Description 后台用户第三方资料查询
     * @Author yuan.shuai
     * @Date 2019/12/9 10:51
     * @Param userId
     * @Return java.util.List<AcUserOauthDao>
     * @Version 1.0.0
     **/
    List<AcUserOauthDao> getUserOauthList(@Param("userId") Integer userId);

    /**
     * @Description 后台查询下级用户信息
     * @Author yuan.shuai
     * @Date 2019/12/24 22:24
     * @Param userId
     * @Return com.util.List<AcUserUnderlingBackDao>
     * @Version 1.0.0
     **/
    List<AcUserUnderlingBackDao> getUserUnderlingBackList(@Param("userId") Integer userId);

    /**
     * @Description 后台用户关注人列表
     * @Author yuan.shuai
     * @Date 2019/12/31 14:00
     * @Param userId
     * @Return java.util.List<AcUserAttentionBackDao>
     * @Version 1.0.0
     **/
    List<AcUserAttentionBackDao> getUserAttentitionBackList(@Param("userId") Integer userId);

    /**
     * @Description 后台用户代理主播列表
     * @Author yuan.shuai
     * @Date 2020/2/17 18:21
     * @Param userId
     * @Return List<AcUserAttentionBackDao>
     * @Version 1.0.0
     **/
    List<AcUserAttentionBackDao> getUserAnchorBackList(@Param("userId") Integer userId);

    /**
     * @Description 后台用户签到记录列表
     * @Author yuan.shuai
     * @Date 2020/2/17 20:46
     * @Param userId
     * @Return List<AcUserSignRecordBackDao>
     * @Version 1.0.0
     **/
    List<AcUserSignRecordBackDao> getUserSignRecordBackList(@Param("userId") Integer userId);

    /**
     * @Description 后台用户被关注列表
     * @Author yuan.shuai
     * @Date 2019/12/31 14:00
     * @Param
     * @Return
     * @Version 1.0.0
     **/
    List<AcUserAttentionBackDao> getUserPassiveAttentitionBackList(@Param("userId") Integer userId);
    
    /***
     * @Author Melon
     * @Description 爱触首页推荐信息
     * @Date 15:04 2020/1/6
     * @Param [userId, longitude, latitude, mainFaceType]
     * @Return java.util.List<com.aichu.dao.workstation.object.MainFaceRecommendDao>
     **/
    List<MainFaceRecommendDao> mainFaceRecommend(@Param("userId") Integer userId,
                                                 @Param("longitude") Double longitude,
                                                 @Param("latitude") Double latitude,
                                                 @Param("mainFaceType") Integer mainFaceType);

    /**
     * @Description 首页查找主播用户信息
     * @Author Melon
     * @Date 2020/3/3 15:53
     * @Param [keyWord] 
     * @return com.aichu.dao.workstation.object.MainFaceAnchorFindDao 
     **/
    List<MainFaceAnchorFindDao> mainFaceAnchorFindByKeyWord(@Param("keyWord") String keyWord);

    /***
     * @Author Melon
     * @Description 用户魅力榜信息--分页
     * @Date 17:09 2020/1/9
     * @Param [userId, timeType]
     * @Return java.util.List<com.aichu.dao.workstation.object.UserRecordListInfoDao>
     **/
    List<UserRecordListInfoDao> userCharmRankList(@Param("userId") Integer userId, @Param("timeType") Integer timeType);

    /***
     * @Author Melon
     * @Description 用户魅力榜总魅力值
     * @Date 17:08 2020/1/9
     * @Param [userId, timeType]
     * @Return java.lang.Integer
     **/
    Integer userTotalReceiveCoin(@Param("userId") Integer userId, @Param("timeType") Integer timeType);

    /***
     * @Author Melon
     * @Description 用户富豪榜--分页
     * @Date 17:09 2020/1/9
     * @Param [userId, timeType]
     * @Return java.util.List<com.aichu.dao.workstation.object.UserRecordListInfoDao>
     **/
    List<UserRecordListInfoDao> userRichRankList(@Param("userId") Integer userId, @Param("timeType") Integer timeType);

    /***
     * @Author Melon
     * @Description 用户富豪榜我的消费
     * @Date 17:08 2020/1/9
     * @Param [userId, timeType]
     * @Return java.lang.Integer
     **/
    Integer userTotalCostCoin(@Param("userId") Integer userId, @Param("timeType") Integer timeType);

    /***
     * @Author Melon
     * @Description 用户视频通话记录列表信息--分页
     * @Date 13:07 2020/2/21
     * @Param [userId]
     * @Return java.util.List<com.aichu.dao.workstation.object.UserVideoRecordDao>
     **/
    List<UserVideoRecordDao> userVideoRecord(@Param("userId") Integer userId);
    
    /***
     * @Author Melon
     * @Description 用户消息信息-分页
     * @Date 14:59 2020/2/21
     * @Param [userId]
     * @Return java.util.List<com.aichu.dao.workstation.object.UserMessageDao>
     **/
    List<UserMessageDao> userMessageList(@Param("userId") Integer userId);

    /**
     * @Description 用户通话记录列表
     * @Author yuan.shuai
     * @Date 2020/2/22 21:09
     * @Param userId
     * @Return List<AcUserPhoneRecordBackDao>
     * @Version 1.0.0
     **/
    List<AcUserPhoneRecordBackDao> getUserPhoneRecordBackList(@Param("userId") Integer userId);
    /**
     * @Description 首页查询总注册人数
     * @Author hsw
     * @Date 2020/2/22 21:09
     * @Param userId
     * @Return List<AcUserPhoneRecordBackDao>
     * @Version 1.0.0
     **/
    Integer selectPeopleCount();
    /**
     * @Description 首页日活跃用户
     * @Author hsw
     * @Date 2020/3/12 21:09
     * @Param userId
     * @Return List<ActiveUserDao>
     * @Version 1.0.0
     **/
    List<ActiveUserDao> selectActiveCount();
    /**
     * @Description 首页日注册用户
     * @Author hsw
     * @Date 2020/3/12 21:09
     * @Param userId
     * @Return List<ActiveUserDao>
     * @Version 1.0.0
     **/
    List<ActiveUserDao> selectRegisterCount();
    /**
     * @Description 首页日消費統計
     * @Author hsw
     * @Date 2020/3/12 21:09
     * @Param userId
     * @Return List<ActiveUserDao>
     * @Version 1.0.0
     **/
    AgencyDataDao getConsumeCount();
    /**
     * @Description 首页日充值統計
     * @Author hsw
     * @Date 2020/3/12 21:09
     * @Param userId
     * @Return List<ActiveUserDao>
     * @Version 1.0.0
     **/
    String getRechargeCount();
}