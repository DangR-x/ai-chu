package com.aichu.service.api;

import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.dao.autogeneration.object.AcUserAnchorDO;
import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.service.dto.*;

import java.util.List;

/**
 * @ClassName AcUserService
 * @Description 用户信息Service
 * @Author Melon
 * @Date 2019/7/20 14:40
 * @Version 1.0.0
 **/
public interface AcUserService {

    /***
     * @Author Melon
     * @Description 根据用户电话查询用户信息
     * @Date 15:22 2019/12/26
     * @Param [phone]
     * @Return com.aichu.dao.autogeneration.object.AcUserDO
     **/
    AcUserDO selectAcUserByPhone(String phone) throws Exception;

    /***
     * @Author Melon
     * @Description 根据用户账号信息创建账号
     * @Date 15:26 2019/7/22
     * @Param [acUserDO]
     * @Return java.lang.Boolean
     **/
    Boolean insertAcUserWithAccount(AcUserDO acUserDO) throws Exception;

    /***
     * @Author Melon
     * @Description 用户登录补充信息资料
     * @Date 17:39 2019/12/26
     * @Param [userCompleteInformationDTO, userId]
     * @Return java.lang.Boolean
     **/
    Boolean userCompleteInformation(UserCompleteInformationDTO userCompleteInformationDTO, Integer userId) throws Exception;

    /***
     * @Author Melon
     * @Description 用户个人主页信息资料
     * @Date 16:09 2019/12/27
     * @Param [aimUserAcId, userId]
     * @Return com.aichu.service.dto.PersonalHomePageDTO
     **/
    PersonalHomePageDTO personalHomePage(String aimUserAcId, Integer userId) throws Exception;

    /***
     * @Author Melon
     * @Description 用户关注与取消关注
     * @Date 9:47 2019/12/31
     * @Param [aimUserId, actionType, userId]
     * @Return java.lang.Boolean
     **/
    Boolean userLikeAction(Integer aimUserId, Integer actionType, Integer userId) throws Exception;

    /***
     * @Author Melon
     * @Description 用户关注人列表信息-分页
     * @Date 22:05 2020/2/20
     * @Param [userId, basePageOrder]
     * @Return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.UserLikeDTO>>
     **/
    BaseResponse<List<UserLikeDTO>> userLikeList(Integer userId, BasePageOrder basePageOrder) throws Exception;

    /***
     * @Author Melon
     * @Description 用户修改基础个人信息资料
     * @Date 11:13 2019/12/31
     * @Param [userBasicsInformationDTO, userId]
     * @Return java.lang.Boolean
     **/
    Boolean updateBasicsInformation(UserBasicsInformationDTO userBasicsInformationDTO, Integer userId) throws Exception;

    /***
     * @Author Melon
     * @Description 用户个人钱包信息
     * @Date 16:50 2019/12/31
     * @Param [userId]
     * @Return com.aichu.service.dto.UserWalletDTO
     **/
    UserWalletDTO userWallet(Integer userId) throws Exception;

    /***
     * @Author Melon
     * @Description 用户个人主页信息资料修改
     * @Date 11:07 2020/1/2
     * @Param [personalHomePageUpdateDTO, userId]
     * @Return java.lang.Boolean
     **/
    Boolean personalHomePageUpdate(PersonalHomePageUpdateDTO personalHomePageUpdateDTO, Integer userId) throws Exception;

    /**
     * @Description 后台用户列表查询
     * @Param BackUserQueryDTO
     * @Return BaseResponse<List < AcBackUserDTO>>
     * @Author yuan.shuai
     * @Date 2019/11/4
     * @Version 1.0.0
     */
    BaseResponse<List<AcBackUserDTO>> getBackUserList(BackUserQueryDTO queryDTO) throws Exception;

    /**
     * @Description 后台用户联系人列表查询
     * @Author yuan.shuai
     * @Date 2019/12/9 14:43
     * @Param AcUserContactBackQueryDTO
     * @Return BaseResponse<List < AcUserContactBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcUserContactBackDTO>> getUserContactBackList(AcUserContactBackQueryDTO backQueryDTO) throws Exception;

    /**
     * @Description 后台用户第三方资料查询
     * @Author yuan.shuai
     * @Date 2019/12/9 14:43
     * @Param userId
     * @Return List<AcUserOauthDTO>
     * @Version 1.0.0
     **/
    List<AcUserOauthDTO> getUserOauthBackList(Integer userId) throws Exception;

    /**
     * @Description 后台用户冻结/解冻
     * @Author yuan.shuai
     * @Date 2019/12/9 16:16
     * @Param AcUserFrozenDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean frozenUser(AcUserFrozenDTO frozenDTO) throws Exception;

    /**
     * @Description  后台用户设置/取消主播
     * @Author Yuan.shuai
     * @Date 2020/3/5 15:24
     * @Param [statusDTO]
     * @return java.lang.Boolean
     **/
    Boolean setIsAnchor(AcUtilIdAndStatusDTO statusDTO) throws Exception;

    /**
     * @Description  后台用户设置/取消代理
     * @Author Yuan.shuai
     * @Date 2020/3/5 15:24
     * @Param [statusDTO]
     * @return java.lang.Boolean
     **/
    Boolean setIsAgency(AcUtilIdAndStatusDTO statusDTO) throws Exception;

    /**
     * @Description  后台用户黑名单
     * @Author hsw
     * @Date 2020/3/5 15:24
     * @Param [statusDTO]
     * @return java.lang.Boolean
     **/
    Boolean setUserBlacklist(Integer id) throws Exception;

    /**
     * @Description  后台用户总注册人数
     * @Author hsw
     * @Date 2020/3/5 15:24
     * @Param [statusDTO]
     * @return java.lang.Boolean
     **/
    Integer getPeopleCount() throws Exception;
    /**
     * @Description 后台修改会员用户密码
     * @Author yuan.shuai
     * @Date 2019/12/16 19:15
     * @Param AcUpdateUserPasswordDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean updateUserPasswordBack(AcUpdateUserPasswordDTO userPasswordDTO) throws Exception;

    /**
     * @Description 后台用户下级用户列表
     * @Author yuan.shuai
     * @Date 2019/12/24 22:09
     * @Param YjzhUserUnderlingQueryDTO
     * @Return BaseResponse<List<AcUserUnderlingBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcUserUnderlingBackDTO>> getUserUnderlingListBack(AcUserUnderlingQueryDTO queryDTO) throws Exception;


    /**
     * @Description 后台用户关注列表
     * @Author yuan.shuai
     * @Date 2019/12/31 14:05
     * @Param AcUserAttentionBackQueryDTO
     * @Return BaseResponse<List<AcUserAttentionBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcUserAttentionBackDTO>> getUserAttentitionBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception;

    /**
     * @Description 用户代理主播列表
     * @Author yuan.shuai
     * @Date 2020/2/17 20:48
     * @Param  AcUserAttentionBackQueryDTO
     * @Return BaseResponse<List<AcUserAttentionBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcUserAttentionBackDTO>> getUserAnchorBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception;

    /**
     * @Description 用户签到记录列表
     * @Author yuan.shuai
     * @Date 2020/2/17 20:50
     * @Param AcUserAttentionBackQueryDTO
     * @Return BaseResponse<List<AcUserSignRecordBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcUserSignRecordBackDTO>> getUserSignRecordBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception;

    /**
     * @Description 后台用户被关注列表
     * @Author yuan.shuai
     * @Date 2019/12/31 14:05
     * @Param AcUserAttentionBackQueryDTO
     * @Return BaseResponse<List<AcUserAttentionBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcUserAttentionBackDTO>> getUserPassiveAttentitionBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception;

    /**
     * @Description 后台用户信息详情
     * @Author yuan.shuai
     * @Date 2019/12/31 15:01
     * @Param id
     * @Return AcBackUserDTO
     * @Version 1.0.0
     **/
    AcBackUserDTO getUserBackDetail(Integer id) throws Exception;

    /***
     * @Author Melon
     * @Description 爱触首页推荐信息
     * @Date 16:54 2020/2/17
     * @Param [userId, mainFacelDTO]
     * @Return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.MainFaceRecommendDTO>>
     **/
    BaseResponse<List<MainFaceRecommendDTO>> mainFaceRecommend(Integer userId, MainFacelDTO mainFacelDTO) throws Exception;

    /**
     * @Description 首页查找主播用户信息
     * @Author Melon
     * @Date 2020/3/3 15:49
     * @Param [keyWord] 
     * @return com.aichu.service.dto.MainFaceAnchorFindDTO 
     **/
    List<MainFaceAnchorFindDTO> mainFaceAnchorFindByKeyWord(String keyWord) throws Exception;

    /***
     * @Author Melon
     * @Description 用户每日签到
     * @Date 17:08 2020/1/7
     * @Param [userId]
     * @Return java.lang.Boolean
     **/
    Boolean userEveryDaySignIn(Integer userId, Integer coin) throws Exception;

    /***
     * @Author Melon
     * @Description 用户魅力榜信息--分页
     * @Date 16:58 2020/1/9
     * @Param [userId, userRankListReqDTO]
     * @Return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.UserRecordListInfoDTO>>
     **/
    BaseResponse<List<UserRecordListInfoDTO>> userCharmRankList(Integer userId, UserRankListReqDTO userRankListReqDTO) throws Exception;

    /***
     * @Author Melon
     * @Description 用户魅力榜总魅力值
     * @Date 17:00 2020/1/9
     * @Param [userId, timeType]
     * @Return java.lang.Integer
     **/
    Integer userTotalReceiveCoin(Integer userId, Integer timeType) throws Exception;


    /***
     * @Author Melon
     * @Description 用户富豪榜--分页
     * @Date 16:58 2020/1/9
     * @Param [userId, userRankListReqDTO]
     * @Return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.UserRecordListInfoDTO>>
     **/
    BaseResponse<List<UserRecordListInfoDTO>> userRichRankList(Integer userId, UserRankListReqDTO userRankListReqDTO) throws Exception;

    /***
     * @Author Melon
     * @Description 用户添加视频通话记录
     * @Date 12:45 2020/2/21
     * @Param [userId, telUserAcUid, telTime]
     * @Return java.lang.Boolean
     **/
    Boolean videoRecordAdd(Integer userId, String telUserAcUid, String telTime) throws Exception;
    
    /***
     * @Author Melon
     * @Description 用户视频通话记录列表信息-分页
     * @Date 12:59 2020/2/21
     * @Param [userId, basePageOrder]
     * @Return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.UserVideoRecordDTO>>
     **/
    BaseResponse<List<UserVideoRecordDTO>> userVideoRecord(Integer userId, BasePageOrder basePageOrder) throws Exception;
    
    /***
     * @Author Melon
     * @Description 用户消息信息-分页
     * @Date 14:51 2020/2/21
     * @Param [userId, basePageOrder]
     * @Return com.aichu.common.util.api.BaseResponse<java.util.List<com.aichu.service.dto.UserMessageDTO>>
     **/
    BaseResponse<List<UserMessageDTO>> userMessageList(Integer userId, BasePageOrder basePageOrder) throws Exception;

    /***
     * @Author Melon
     * @Description 用户富豪榜我的消费
     * @Date 17:00 2020/1/9
     * @Param [userId, timeType]
     * @Return java.lang.Integer
     **/
    Integer userTotalCostCoin(Integer userId, Integer timeType) throws Exception;

    /***
     * @Author Melon
     * @Description 用户已签到天数
     * @Date 23:57 2020/2/21
     * @Param [userId]
     * @Return java.lang.Integer
     **/
    Integer userSignDays(Integer userId) throws Exception;
    
    /***
     * @Author Melon
     * @Description 用户今日是否已经签到
     * @Date 1:29 2020/2/22
     * @Param [userId]
     * @Return java.lang.Boolean
     **/
    Boolean userIsSignToDay(Integer userId) throws Exception;


    /***
     * @Author Melon
     * @Description 用户优惠卡签到信息定时任务
     * @Date 10:27 2020/1/14
     * @Param []
     * @Return void
     **/
    void userSignCardTaskHandle() throws Exception;

    /**
     * @Description 后台用户通话记录
     * @Author yuan.shuai
     * @Date 2020/2/22 21:31
     * @Param AcOnlyIdQueryDTO
     * @Return BaseResponse<List<AcUserPhoneRecordBackDTO>>
     * @Version 1.0.0
     **/
    BaseResponse<List<AcUserPhoneRecordBackDTO>> getUserPhoneRecordList(AcOnlyIdQueryDTO queryDTO) throws Exception;
    /**
     * @Description 后台首页报表活跃注册用户
     * @Author hsw
     * @Date 2020/2/22 21:31
     * @Param AcOnlyIdQueryDTO
     * @Return BaseResponse<List<AcUserPhoneRecordBackDTO>>
     * @Version 1.0.0
     **/
    HomeStatementDataDTO getRegisterConut()throws Exception;
    /**
     * @Description 后台消费报表数据
     * @Author hsw
     * @Date 2020/2/22 21:31
     * @Param AcOnlyIdQueryDTO
     * @Return BaseResponse<List<AcUserPhoneRecordBackDTO>>
     * @Version 1.0.0
     **/
    AgencyDataDTO getConsumeCount()throws Exception;
    /**
     * @Description 后台充值报表数据
     * @Author hsw
     * @Date 2020/2/22 21:31
     * @Param AcOnlyIdQueryDTO
     * @Return BaseResponse<List<AcUserPhoneRecordBackDTO>>
     * @Version 1.0.0
     **/
    String getRechargeCount()throws Exception;

    /**
     * @Description 插入用户代理
     * @Author Yuan.shuai
     * @Date 2020/3/14 15:48
     * @Param [acUserAnchorDO]
     * @return java.lang.Boolean
     **/
    Boolean insertUserAnchor(AcUserAnchorDO acUserAnchorDO) throws Exception;
}
