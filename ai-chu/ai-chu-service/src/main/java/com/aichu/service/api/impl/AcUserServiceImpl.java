package com.aichu.service.api.impl;

import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.DateUtils;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.*;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.dao.workstation.mapper.AcPreferentialCardDaoMapper;
import com.aichu.dao.workstation.mapper.AcUserDaoMapper;
import com.aichu.dao.workstation.mapper.AcUserSignRecordDaoMapper;
import com.aichu.dao.workstation.object.*;
import com.aichu.manager.api.im.message.WangYiYunCloudMessageService;
import com.aichu.manager.api.im.user.WangYiYunCloudUserService;
import com.aichu.manager.enums.*;
import com.aichu.service.api.AcUserService;
import com.aichu.service.dto.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName WzUserServiceImpl
 * @Description 用户信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/20 14:45
 * @Version 1.0.0
 **/
@Service
public class AcUserServiceImpl implements AcUserService {

    private Logger logger = LoggerFactory.getLogger(AcUserServiceImpl.class);

    @Autowired
    private AcUserMapper acUserMapper;

    @Autowired
    private AcUserDaoMapper acUserDaoMapper;

    @Autowired
    private AcUserAttentionMapper acUserAttentionMapper;

    @Autowired
    private AcUserPreferentialCardMapper acUserPreferentialCardMapper;

    @Autowired
    private AcPreferentialCardMapper acPreferentialCardMapper;

    @Autowired
    private AcPreferentialCardDaoMapper acPreferentialCardDaoMapper;

    @Autowired
    private AcUserPhotoAlbumMapper acUserPhotoAlbumMapper;

    @Autowired
    private AcUserSignRecordMapper acUserSignRecordMapper;

    @Autowired
    private AcUserSignRecordDaoMapper acUserSignRecordDaoMapper;

    @Autowired
    private AcUserPhoneRecordMapper acUserPhoneRecordMapper;

    @Autowired
    private WangYiYunCloudUserService wangYiYunCloudUserService;

    @Autowired
    private WangYiYunCloudMessageService wangYiYunCloudMessageService;

    @Autowired
    private AcUserAnchorMapper acUserAnchorMapper;

    @Override
    public AcUserDO selectAcUserByPhone(String phone) throws Exception {
        logger.info("-----------根据用户电话查询用户信息-------Start");

        AcUserDO acUserDO = acUserDaoMapper.selectAcUserByPhone(phone);

        logger.info("-----------根据用户电话查询用户信息-------End");
        return acUserDO;
    }

    @Override
    public Boolean insertAcUserWithAccount(AcUserDO acUserDO) throws Exception {
        logger.info("-----------根据用户账号信息创建账号-------Start");

        Integer resultUser = acUserMapper.insertSelective(acUserDO);
        if(resultUser == 0){
            throw new BusinessException(ResultCodeEnum.CREATE_USER_ERROR.code(), ResultCodeEnum.CREATE_USER_ERROR.message());
        }

        logger.info("-----------根据用户账号信息创建账号-------End");
        return true;
    }

    @Override
    public Boolean userCompleteInformation(UserCompleteInformationDTO userCompleteInformationDTO, Integer userId) throws Exception {
        logger.info("-----------用户登录补充信息资料-------Start00: userCompleteInformationDTO:--{}, userId:--{}", userCompleteInformationDTO, userId);

        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        if(acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        //补充信息
        acUserDO.setSex(userCompleteInformationDTO.getUserSex());
        acUserDO.setNickName(userCompleteInformationDTO.getUserName());
        acUserDO.setBirthDate(userCompleteInformationDTO.getUserBirth());
        acUserDO.setProvinceId(userCompleteInformationDTO.getProvinceId());
        acUserDO.setCityId(userCompleteInformationDTO.getCityId());
        acUserDO.setAreaId(userCompleteInformationDTO.getAreaId());
        if (userCompleteInformationDTO.getLongitude() != null){
            acUserDO.setLongitude(userCompleteInformationDTO.getLongitude());
        }
        if (userCompleteInformationDTO.getLatitude() != null){
            acUserDO.setLatitude(userCompleteInformationDTO.getLatitude());
        }
        Integer result = acUserMapper.updateByPrimaryKeySelective(acUserDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        wangYiYunCloudUserService.wangYiYunCloudUpdateUserInfo(acUserDO.getAcUid(),
                acUserDO.getNickName(), acUserDO.getHeadImg());

        logger.info("-----------用户登录补充信息资料-------End");
        return true;
    }

    @Override
    public PersonalHomePageDTO personalHomePage(String aimUserAcId, Integer userId) throws Exception {
        logger.info("-----------用户个人主页信息资料-------Start: aimUserAcId:--{}, userId:--{}", aimUserAcId, userId);

        PersonalHomePageDTO personalHomePageDTO = BeanUtil.copy(acUserDaoMapper.personalHomePage(aimUserAcId, userId), PersonalHomePageDTO.class);

        logger.info("-----------用户个人主页信息资料-------End");
        return personalHomePageDTO;
    }

    @Override
    public Boolean userLikeAction(Integer aimUserId, Integer actionType, Integer userId) throws Exception {
        logger.info("-----------用户关注与取消关注-------Start: aimUserId:--{}, actionType:--{},userId:--{}", aimUserId, actionType, userId);

        AcUserAttentionExample acUserAttentionExample = new AcUserAttentionExample();
        acUserAttentionExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andAttentionIdEqualTo(aimUserId);
        List<AcUserAttentionDO> acUserAttentionDOList = acUserAttentionMapper.selectByExample(acUserAttentionExample);
        if (actionType.equals(UserAttentionTypeEnum.USER_ATTENTION_TYPE_FALSE.getCode())){
            if (!Utils.isEmpty(acUserAttentionDOList)){
                acUserAttentionDOList.get(0).setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());;
                Integer result = acUserAttentionMapper.updateByPrimaryKeySelective(acUserAttentionDOList.get(0));
                if (result == 0){
                    throw new BusinessException(ResultCodeEnum.AIM_USER_CANCEL_LIKE_FILED.code(), ResultCodeEnum.AIM_USER_CANCEL_LIKE_FILED.message());
                }
            }else {
                throw new BusinessException(ResultCodeEnum.AIM_USER_HAS_NOT_LIKE.code(), ResultCodeEnum.AIM_USER_HAS_NOT_LIKE.message());
            }
        }else {
            if (!Utils.isEmpty(acUserAttentionDOList)){
                acUserAttentionDOList.get(0).setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());;
                Integer result = acUserAttentionMapper.updateByPrimaryKeySelective(acUserAttentionDOList.get(0));
                if (result == 0){
                    throw new BusinessException(ResultCodeEnum.AIM_USER_CANCEL_LIKE_FILED.code(), ResultCodeEnum.AIM_USER_CANCEL_LIKE_FILED.message());
                }
            }else {
                AcUserAttentionDO acUserAttentionDO = new AcUserAttentionDO();
                acUserAttentionDO.setUserId(userId);
                acUserAttentionDO.setAttentionId(aimUserId);
                Integer result = acUserAttentionMapper.insertSelective(acUserAttentionDO);
                if (result == 0){
                    throw new BusinessException(ResultCodeEnum.AIM_USER_LIKE_FILED.code(), ResultCodeEnum.AIM_USER_LIKE_FILED.message());
                }
            }
            AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
            AcUserDO aimAcUserDO = acUserMapper.selectByPrimaryKey(aimUserId);
            wangYiYunCloudMessageService.wangYiYunCloudSendCommonMessage(aimAcUserDO.getAcUid(), acUserDO.getAcUid());
        }

        logger.info("-----------用户关注与取消关注-------End");
        return true;
    }

    @Override
    public BaseResponse<List<UserLikeDTO>> userLikeList(Integer userId, BasePageOrder basePageOrder) throws Exception {
        logger.info("-----------用户关注人列表信息-分页-------Start: userId:--{}, basePageOrder:--{}", userId, basePageOrder);

        Page<UserLikeDao> pages = PageHelper.startPage(basePageOrder.getPageNum(), basePageOrder.getPageSize());
        List<UserLikeDao> userLikeDaoList = acUserDaoMapper.userLikeList(userId);

        logger.info("-----------用户关注人列表信息-分页-------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(userLikeDaoList, UserLikeDTO.class));
    }

    @Override
    public Boolean updateBasicsInformation(UserBasicsInformationDTO userBasicsInformationDTO, Integer userId) throws Exception {
        logger.info("-----------用户修改基础个人信息资料-------Start: userBasicsInformationDTO:--{}, userId:--{}", userBasicsInformationDTO, userId);

        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        if (acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        acUserDO.setHeadImg(userBasicsInformationDTO.getUserHead());
        acUserDO.setNickName(userBasicsInformationDTO.getUserName());
        acUserDO.setBirthDate(userBasicsInformationDTO.getUserBirth());
        acUserDO.setProvinceId(userBasicsInformationDTO.getProvinceId());
        acUserDO.setCityId(userBasicsInformationDTO.getCityId());
        acUserDO.setAreaId(userBasicsInformationDTO.getAreaId());
        Integer result = acUserMapper.updateByPrimaryKeySelective(acUserDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        wangYiYunCloudUserService.wangYiYunCloudUpdateUserInfo(acUserDO.getAcUid(),
                acUserDO.getNickName(), acUserDO.getHeadImg());

        logger.info("-----------用户修改基础个人信息资料-------End");
        return true;
    }

    @Override
    public UserWalletDTO userWallet(Integer userId) throws Exception {
        logger.info("-----------用户个人钱包信息-------Start: userId:--{}", userId);

        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        if (acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        UserWalletDTO userWalletDTO = new UserWalletDTO();
        userWalletDTO.setUserCoin(acUserDO.getCoin());
        //查询签到次数，以及月卡，周卡购买情况
        AcUserPreferentialCardExample acUserPreferentialCardExample = new AcUserPreferentialCardExample();
        acUserPreferentialCardExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserPreferentialCardDO> acUserPreferentialCardDOList = acUserPreferentialCardMapper.selectByExample(acUserPreferentialCardExample);
        if (Utils.isEmpty(acUserPreferentialCardDOList)){
            userWalletDTO.setUserWeekSignTime(0);
            userWalletDTO.setUserMouthSignTime(0);
            userWalletDTO.setHaveWeekCard(UserSignTypeEnum.USER_SIGN_TYPE_FALSE.getCode());
            userWalletDTO.setHaveMouthCard(UserSignTypeEnum.USER_SIGN_TYPE_FALSE.getCode());
        }else {
            userWalletDTO.setUserWeekSignTime(0);
            userWalletDTO.setUserMouthSignTime(0);
            userWalletDTO.setHaveWeekCard(UserSignTypeEnum.USER_SIGN_TYPE_FALSE.getCode());
            userWalletDTO.setHaveMouthCard(UserSignTypeEnum.USER_SIGN_TYPE_FALSE.getCode());
            acUserPreferentialCardDOList.stream().forEach( acUserPreferentialCardDO -> {

                AcPreferentialCardDO acPreferentialCardDO = acPreferentialCardMapper.selectByPrimaryKey(acUserPreferentialCardDO.getPreferentialCardId());
                if (acPreferentialCardDO == null){
                    throw new BusinessException(ResultCodeEnum.PREFERENTIAL_CARD_NOT_EXISTED.code(), ResultCodeEnum.PREFERENTIAL_CARD_NOT_EXISTED.message());
                }

                if (acPreferentialCardDO.getCardType().equals(PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK.getCode())){
                    userWalletDTO.setHaveWeekCard(UserSignTypeEnum.USER_SIGN_TYPE_TRUE.getCode());
                    //查询签到次数
                    Integer signTime = acPreferentialCardDaoMapper.userSignTotalTimes(userId, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(acPreferentialCardDO.getCreateTime()));
                    userWalletDTO.setUserWeekSignTime(signTime);
                }else {
                    userWalletDTO.setHaveMouthCard(UserSignTypeEnum.USER_SIGN_TYPE_TRUE.getCode());
                    //查询签到次数
                    Integer signTime = acPreferentialCardDaoMapper.userSignTotalTimes(userId, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(acPreferentialCardDO.getCreateTime()));
                    userWalletDTO.setUserMouthSignTime(signTime);
                }
            });
        }

        logger.info("-----------用户个人钱包信息-------End");
        return userWalletDTO;
    }

    @Override
    public Boolean personalHomePageUpdate(PersonalHomePageUpdateDTO personalHomePageUpdateDTO, Integer userId) throws Exception {
        logger.info("-----------用户个人主页信息资料修改-------Start: personalHomePageUpdateDTO:--{}, userId:--{}", personalHomePageUpdateDTO, userId);

        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        if (acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }
        if (personalHomePageUpdateDTO.getUserName() != null && !personalHomePageUpdateDTO.getUserName().equals("")){
            acUserDO.setNickName(personalHomePageUpdateDTO.getUserName());
        }
        if (personalHomePageUpdateDTO.getUserHead() != null && !personalHomePageUpdateDTO.getUserHead().equals("")){
            acUserDO.setHeadImg(personalHomePageUpdateDTO.getUserHead());
        }
        if (personalHomePageUpdateDTO.getUserSex() != null){
            acUserDO.setSex(personalHomePageUpdateDTO.getUserSex());
        }
        if (personalHomePageUpdateDTO.getUserBirthDate() != null && !personalHomePageUpdateDTO.getUserBirthDate().equals("")){
            acUserDO.setBirthDate(personalHomePageUpdateDTO.getUserBirthDate());
        }
        if (personalHomePageUpdateDTO.getUserHeight() != null){
            acUserDO.setHeightLabelId(personalHomePageUpdateDTO.getUserHeight());
        }
        if (personalHomePageUpdateDTO.getUserWeight() != null){
            acUserDO.setWeightLabelId(personalHomePageUpdateDTO.getUserWeight());
        }
        if (personalHomePageUpdateDTO.getUserWork() != null){
            acUserDO.setOccupationLabelId(personalHomePageUpdateDTO.getUserWork());
        }
        if (personalHomePageUpdateDTO.getUserConstellation() != null){
            acUserDO.setConstellationLabelId(personalHomePageUpdateDTO.getUserConstellation());
        }
        if (personalHomePageUpdateDTO.getProvinceId() != null){
            acUserDO.setProvinceId(personalHomePageUpdateDTO.getProvinceId());
        }
        if (personalHomePageUpdateDTO.getCityId() != null){
            acUserDO.setCityId(personalHomePageUpdateDTO.getCityId());
        }
        if (personalHomePageUpdateDTO.getAreaId() != null){
            acUserDO.setAreaId(personalHomePageUpdateDTO.getAreaId());
        }
        if (personalHomePageUpdateDTO.getUserChartCost() != null){
            acUserDO.setChartCost(personalHomePageUpdateDTO.getUserChartCost());
        }
        if (personalHomePageUpdateDTO.getUserSignature() != null && !personalHomePageUpdateDTO.getUserSignature().equals("")){
            acUserDO.setSignature(personalHomePageUpdateDTO.getUserSignature());
        }
        if (personalHomePageUpdateDTO.getUserImpressionStr() != null && !personalHomePageUpdateDTO.getUserImpressionStr().equals("")){
            acUserDO.setImpressionLabelId(personalHomePageUpdateDTO.getUserImpressionStr());
        }
        if (personalHomePageUpdateDTO.getUserPhotoAlbumStr() != null){

            //清除原有照片墙信息
            AcUserPhotoAlbumExample acUserPhotoAlbumExample = new AcUserPhotoAlbumExample();
            acUserPhotoAlbumExample.createCriteria()
                    .andUserIdEqualTo(userId)
                    .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            List<AcUserPhotoAlbumDO> acUserPhotoAlbumDOList = acUserPhotoAlbumMapper.selectByExample(acUserPhotoAlbumExample);
            if (!Utils.isEmpty(acUserPhotoAlbumDOList)){
                acUserPhotoAlbumDOList.stream().forEach( acUserPhotoAlbumDO -> {
                    acUserPhotoAlbumDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
                    Integer photoAlbumResult = acUserPhotoAlbumMapper.updateByPrimaryKeySelective(acUserPhotoAlbumDO);
                    if (photoAlbumResult == 0){
                        throw new BusinessException(ResultCodeEnum.USER_PHOTO_ALBUM_UPDATE_FILED.code(), ResultCodeEnum.USER_PHOTO_ALBUM_UPDATE_FILED.message());
                    }
                });
            }

            if (!"".equals(personalHomePageUpdateDTO.getUserPhotoAlbumStr())){
                //添加新的照片墙
                String[] userPhotoAlbumArr = personalHomePageUpdateDTO.getUserPhotoAlbumStr().split(",");
                for (int i = 0; i < userPhotoAlbumArr.length; i++) {
                    AcUserPhotoAlbumDO acUserPhotoAlbumDO = new AcUserPhotoAlbumDO();
                    acUserPhotoAlbumDO.setUserId(userId);
                    acUserPhotoAlbumDO.setFileUrl(userPhotoAlbumArr[i]);
                    Integer photoAlbumResult = acUserPhotoAlbumMapper.insertSelective(acUserPhotoAlbumDO);
                    if (photoAlbumResult == 0){
                        throw new BusinessException(ResultCodeEnum.USER_PHOTO_ALBUM_UPDATE_FILED.code(), ResultCodeEnum.USER_PHOTO_ALBUM_UPDATE_FILED.message());
                    }
                }
            }
        }

        Integer resultUser = acUserMapper.updateByPrimaryKeySelective(acUserDO);
        if (resultUser == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        wangYiYunCloudUserService.wangYiYunCloudUpdateUserInfo(acUserDO.getAcUid(),
                acUserDO.getNickName(), acUserDO.getHeadImg());

        logger.info("-----------用户个人主页信息资料修改-------End");
        return true;
    }


    @Override
    public BaseResponse<List<AcUserAttentionBackDTO>> getUserAttentitionBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception {
        logger.info("-----------后台用户关注用户列表-------Start");
        if (Objects.isNull(queryDTO.getUserId())){
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        Page<AcUserAttentionBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcUserAttentionBackDao> list = acUserDaoMapper.getUserAttentitionBackList(queryDTO.getUserId());
        logger.info("-----------后台用户关注用户列表-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcUserAttentionBackDTO.class));
    }

    @Override
    public BaseResponse<List<AcUserAttentionBackDTO>> getUserAnchorBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception {
        logger.info("-----------后台用户主播列表-------Start");
        if (Objects.isNull(queryDTO.getUserId())){
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        Page<AcUserAttentionBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcUserAttentionBackDao> list = acUserDaoMapper.getUserAnchorBackList(queryDTO.getUserId());
        logger.info("-----------后台用户主播列表-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcUserAttentionBackDTO.class));
    }

    @Override
    public BaseResponse<List<AcUserSignRecordBackDTO>> getUserSignRecordBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception {
        logger.info("-----------后台用户签到列表-------Start");
        if (Objects.isNull(queryDTO.getUserId())){
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        Page<AcUserSignRecordBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcUserSignRecordBackDao> list = acUserDaoMapper.getUserSignRecordBackList(queryDTO.getUserId());
        logger.info("-----------后台用户签到列表-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcUserSignRecordBackDTO.class));
    }

    @Override
    public BaseResponse<List<AcUserAttentionBackDTO>> getUserPassiveAttentitionBackList(AcUserAttentionBackQueryDTO queryDTO) throws Exception {
        logger.info("-----------后台用户被关注用户列表-------Start");
        if (Objects.isNull(queryDTO.getUserId())){
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        Page<AcUserAttentionBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcUserAttentionBackDao> list = acUserDaoMapper.getUserPassiveAttentitionBackList(queryDTO.getUserId());
        logger.info("-----------后台用户被关注用户列表-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcUserAttentionBackDTO.class));
    }

    @Override
    public AcBackUserDTO getUserBackDetail(Integer id) throws Exception {
        logger.info("-----------后台用户信息详情-------Start");
        if (Objects.isNull(id)){
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        AcBackUserDao backUserDao = acUserDaoMapper.getUserBackDetail(id);
        logger.info("-----------后台用户信息详情-------End");
        return BeanUtil.copy(backUserDao,AcBackUserDTO.class);
    }

    @Override
    public BaseResponse<List<MainFaceRecommendDTO>> mainFaceRecommend(Integer userId, MainFacelDTO mainFacelDTO) throws Exception {
        logger.info("-----------爱触首页推荐信息-------Start: userId:-->{}, mainFacelDTO:-->{}", userId, mainFacelDTO);

        Page<MainFaceRecommendDao> pages = PageHelper.startPage(mainFacelDTO.getPageNum(), mainFacelDTO.getPageSize());
        List<MainFaceRecommendDao> mainFaceRecommendDaoList = acUserDaoMapper.mainFaceRecommend(userId, mainFacelDTO.getLongitude(), mainFacelDTO.getLatitude(), mainFacelDTO.getMainFaceType());

        logger.info("-----------爱触首页推荐信息-------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(mainFaceRecommendDaoList, MainFaceRecommendDTO.class));
    }

    @Override
    public List<MainFaceAnchorFindDTO> mainFaceAnchorFindByKeyWord(String keyWord) throws Exception {
        logger.info("-----------首页查找主播用户信息-------Start: keyWord:-->{}", keyWord);

        List<MainFaceAnchorFindDTO> mainFaceAnchorFindDTOList = BeanUtil.copy(acUserDaoMapper.mainFaceAnchorFindByKeyWord(keyWord), MainFaceAnchorFindDTO.class);

        logger.info("-----------首页查找主播用户信息-------End");
        return mainFaceAnchorFindDTOList;
    }

    @Override
    public Boolean userEveryDaySignIn(Integer userId, Integer coin) throws Exception {
        logger.info("-----------用户每日签到-------Start: userId:-->{}, coin:-->{}", userId, coin);

        //查询用户今日是否已经签到
        Boolean tags  = userIsSignToDay(userId);
        if (tags){
            throw new BusinessException(ResultCodeEnum.AC_USER_HAS_SIGN_AND_NOT_REPEAT.code(), ResultCodeEnum.AC_USER_HAS_SIGN_AND_NOT_REPEAT.message());
        }

        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        if (acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        //优惠卡奖励金币金额
        final Integer[] weekPreferentialCardCoin = {0};
        final Integer[] mouthPreferentialCardCoin = {0};

        //查询用户周卡，月卡
        AcUserPreferentialCardExample acUserPreferentialCardExample = new AcUserPreferentialCardExample();
        acUserPreferentialCardExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserPreferentialCardDO> acUserPreferentialCardDOList = acUserPreferentialCardMapper.selectByExample(acUserPreferentialCardExample);
        if (!Utils.isEmpty(acUserPreferentialCardDOList)){
            acUserPreferentialCardDOList.stream().forEach( acUserPreferentialCardDO -> {
                AcPreferentialCardDO acPreferentialCardDO = acPreferentialCardMapper.selectByPrimaryKey(acUserPreferentialCardDO.getPreferentialCardId());
                if (acPreferentialCardDO == null){
                    throw new BusinessException(ResultCodeEnum.PREFERENTIAL_CARD_NOT_EXISTED.code(), ResultCodeEnum.PREFERENTIAL_CARD_NOT_EXISTED.getMessage());
                }

                if (acUserPreferentialCardDO.getCreateTime().getTime() < new Date().getTime()){
                    if (acPreferentialCardDO.getCardType().equals(PreferentialCardTypeEnum.PREFERENTIAL_CARD_TYPE_WEEK.getCode())){
                        weekPreferentialCardCoin[0] += acPreferentialCardDO.getEveryDayFreeCoin();
                    }else {
                        mouthPreferentialCardCoin[0] += acPreferentialCardDO.getEveryDayFreeCoin();
                    }
                }
            });
        }

        //用户签到金币领取记录
        AcUserSignRecordDO acUserSignRecordDO = new AcUserSignRecordDO();
        acUserSignRecordDO.setUserId(userId);
        acUserSignRecordDO.setCoin(coin);
        acUserSignRecordDO.setWeekCoin(weekPreferentialCardCoin[0]);
        acUserSignRecordDO.setMouthCoin(mouthPreferentialCardCoin[0]);
        Integer resultSignRecord = acUserSignRecordMapper.insertSelective(acUserSignRecordDO);
        if (resultSignRecord == 0){
            throw new BusinessException(ResultCodeEnum.USER_SIGN_RECORD_CREATE_ERROR.code(), ResultCodeEnum.USER_SIGN_RECORD_CREATE_ERROR.message());
        }

        //更新用户金币信息
        acUserDO.setCoin(acUserDO.getCoin() + coin + weekPreferentialCardCoin[0] + mouthPreferentialCardCoin[0]);
        Integer resultUser = acUserMapper.updateByPrimaryKeySelective(acUserDO);
        if (resultUser == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        logger.info("-----------用户每日签到-------End");
        return true;
    }

    @Override
    public BaseResponse<List<UserRecordListInfoDTO>> userCharmRankList(Integer userId, UserRankListReqDTO userRankListReqDTO) throws Exception {
        logger.info("-----------用户魅力榜信息--分页-------Start: userId:-->{}, userRankListReqDTO:-->{}", userId, userRankListReqDTO);

        Page<UserRecordListInfoDao> pages = PageHelper.startPage(userRankListReqDTO.getPageNum(), userRankListReqDTO.getPageSize());
        List<UserRecordListInfoDao> userRecordListInfoDaoList = acUserDaoMapper.userCharmRankList(userId, userRankListReqDTO.getTimeType());

        logger.info("-----------用户魅力榜信息--分页-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(userRecordListInfoDaoList, UserRecordListInfoDTO.class));
    }

    @Override
    public Integer userTotalReceiveCoin(Integer userId, Integer timeType) throws Exception {
        logger.info("-----------用户魅力榜总魅力值-------Start: userId:-->{}, timeType:-->{}", userId, timeType);

        Integer totalReceiveCoin = acUserDaoMapper.userTotalReceiveCoin(userId, timeType);

        logger.info("-----------用户魅力榜总魅力值-------End");
        return totalReceiveCoin;
    }

    @Override
    public BaseResponse<List<UserRecordListInfoDTO>> userRichRankList(Integer userId, UserRankListReqDTO userRankListReqDTO) throws Exception {
        logger.info("-----------用户富豪榜--分页-------Start: userId:-->{}, userRankListReqDTO:-->{}", userId, userRankListReqDTO);

        Page<UserRecordListInfoDao> pages = PageHelper.startPage(userRankListReqDTO.getPageNum(), userRankListReqDTO.getPageSize());
        List<UserRecordListInfoDao> userRecordListInfoDaoList = acUserDaoMapper.userRichRankList(userId, userRankListReqDTO.getTimeType());

        logger.info("-----------用户富豪榜--分页-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(userRecordListInfoDaoList, UserRecordListInfoDTO.class));
    }

    @Override
    public Boolean videoRecordAdd(Integer userId, String telUserAcUid, String telTime) throws Exception {
        logger.info("-----------用户添加视频通话记录-------Start-- userId:--{}, telUserAcUid:--{}, telTime:--{}", userId, telUserAcUid, telTime);

        //查询用户信息
        AcUserExample acUserExample = new AcUserExample();
        acUserExample.createCriteria()
                .andAcUidEqualTo(telUserAcUid)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserDO> acUserDOList = acUserMapper.selectByExample(acUserExample);
        if (Utils.isEmpty(acUserDOList)){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        //自己的通话记录
        AcUserPhoneRecordDO acUserPhoneRecordDO = new AcUserPhoneRecordDO();
        acUserPhoneRecordDO.setUserId(userId);
        acUserPhoneRecordDO.setTelUserId(acUserDOList.get(0).getId());
        acUserPhoneRecordDO.setTelTime(telTime);
        Integer resultUser = acUserPhoneRecordMapper.insertSelective(acUserPhoneRecordDO);
        if (resultUser == 0) {
            throw new BusinessException(ResultCodeEnum.USER_VIDEO_RECORD_ADD_ERROR.code(), ResultCodeEnum.USER_VIDEO_RECORD_ADD_ERROR.message());
        }

        //对方的通话记录
        AcUserPhoneRecordDO telAcUserPhoneRecordDO = new AcUserPhoneRecordDO();
        telAcUserPhoneRecordDO.setUserId(acUserDOList.get(0).getId());
        telAcUserPhoneRecordDO.setTelUserId(userId);
        telAcUserPhoneRecordDO.setTelTime(telTime);
        Integer resultTel = acUserPhoneRecordMapper.insertSelective(telAcUserPhoneRecordDO);
        if (resultTel == 0) {
            throw new BusinessException(ResultCodeEnum.USER_VIDEO_RECORD_ADD_ERROR.code(), ResultCodeEnum.USER_VIDEO_RECORD_ADD_ERROR.message());
        }

        logger.info("-----------用户添加视频通话记录-------End");
        return true;
    }

    @Override
    public BaseResponse<List<UserVideoRecordDTO>> userVideoRecord(Integer userId, BasePageOrder basePageOrder) throws Exception {
        logger.info("-----------用户视频通话记录列表信息-分页-------Start: userId:--{}, basePageOrder:--{}", userId, basePageOrder);

        Page<UserVideoRecordDao> pages = PageHelper.startPage(basePageOrder.getPageNum(), basePageOrder.getPageSize());
        List<UserVideoRecordDao> userVideoRecordDaoList = acUserDaoMapper.userVideoRecord(userId);
        userVideoRecordDaoList.stream().forEach( userVideoRecordDao ->{
            try {
                userVideoRecordDao.setTelCreateTime(DateUtils.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(userVideoRecordDao.getTelCreateTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        logger.info("-----------用户视频通话记录列表信息-分页-------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(userVideoRecordDaoList, UserVideoRecordDTO.class));
    }

    @Override
    public BaseResponse<List<UserMessageDTO>> userMessageList(Integer userId, BasePageOrder basePageOrder) throws Exception {
        logger.info("-----------用户消息信息-分页-------Start: userId:--{}, basePageOrder:--{}", userId, basePageOrder);

        Page<UserMessageDao> pages = PageHelper.startPage(basePageOrder.getPageNum(), basePageOrder.getPageSize());
        List<UserMessageDao> userMessageDaoList = acUserDaoMapper.userMessageList(userId);

        logger.info("-----------用户消息信息-分页-------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(userMessageDaoList, UserMessageDTO.class));
    }

    @Override
    public Integer userTotalCostCoin(Integer userId, Integer timeType) throws Exception {
        logger.info("-----------用户富豪榜我的消费-------Start: userId:-->{}, timeType:-->{}", userId, timeType);

        Integer totalReceiveCoin = acUserDaoMapper.userTotalCostCoin(userId, timeType);

        logger.info("-----------用户富豪榜我的消费-------End");
        return totalReceiveCoin;
    }

    @Override
    public Integer userSignDays(Integer userId) throws Exception {
        logger.info("-----------用户已签到天数-------Start: userId:-->{}", userId);

        Integer signDays = 0;
        AcUserSignRecordExample acUserSignRecordExample = new AcUserSignRecordExample();
        acUserSignRecordExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserSignRecordDO> acUserSignRecordDOList = acUserSignRecordMapper.selectByExample(acUserSignRecordExample);
        if (!Utils.isEmpty(acUserSignRecordDOList)){

            if (acUserSignRecordDOList.size() == 1){
                if (DateUtils.nextDayByAimDate(new SimpleDateFormat("yyyy-MM-dd").format(acUserSignRecordDOList.get(0).getCreateTime()))
                        .equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) || new SimpleDateFormat("yyyy-MM-dd").format(acUserSignRecordDOList.get(0).getCreateTime())
                        .equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))){
                    signDays = 1;
                }else {
                    signDays = 0;
                }
            }else {
                for (int i = 0; i < acUserSignRecordDOList.size() - 1; i++) {
                    String beforDate = new SimpleDateFormat("yyyy-MM-dd").format(acUserSignRecordDOList.get(i).getCreateTime());
                    String afterDate = new SimpleDateFormat("yyyy-MM-dd").format(acUserSignRecordDOList.get(i + 1).getCreateTime());
                    if (DateUtils.nextDayByAimDate(beforDate).equals(afterDate)){
                        signDays++;
                    }else {
                        signDays = 0;
                    }
                }

                String endBeforDate = new SimpleDateFormat("yyyy-MM-dd").format(acUserSignRecordDOList.get(acUserSignRecordDOList.size() - 1).getCreateTime());
                String endAfterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                if ((DateUtils.nextDayByAimDate(endBeforDate).equals(endAfterDate) || endBeforDate.equals(endAfterDate))
                        && acUserSignRecordDOList.get(acUserSignRecordDOList.size() - 1).getCreateTime().getTime() <= new Date().getTime()){
                    signDays++;
                }else {
                    signDays = 0;
                }

            }
        }

        Integer continuousDays = signDays % 7;
        logger.info("-----------用户已签到天数-------End");
        return continuousDays;
    }

    @Override
    public Boolean userIsSignToDay(Integer userId) throws Exception {
        logger.info("-----------用户今日是否已经签到-------Start: userId:-->{}", userId);

        Boolean flag = true;

        AcUserSignRecordDO acUserSignRecordDO = acUserSignRecordDaoMapper.userIsSignToDay(userId);
        if (acUserSignRecordDO == null){
            flag = false;
        }

        logger.info("-----------用户今日是否已经签到-------End");
        return flag;
    }

    @Override
    public void userSignCardTaskHandle() throws Exception {
        logger.info("-----------用户优惠卡签到信息定时任务-------Start");

        AcUserPreferentialCardExample acUserPreferentialCardExample = new AcUserPreferentialCardExample();
        acUserPreferentialCardExample.createCriteria()
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserPreferentialCardDO> acUserPreferentialCardDOList = acUserPreferentialCardMapper.selectByExample(acUserPreferentialCardExample);
        if (!Utils.isEmpty(acUserPreferentialCardDOList)){
            acUserPreferentialCardDOList.stream().forEach( acUserPreferentialCardDO -> {
                AcPreferentialCardDO acPreferentialCardDO = acPreferentialCardMapper.selectByPrimaryKey(acUserPreferentialCardDO.getPreferentialCardId());
                if (acPreferentialCardDO == null){
                    throw new BusinessException(ResultCodeEnum.PREFERENTIAL_CARD_NOT_EXISTED.code(), ResultCodeEnum.PREFERENTIAL_CARD_NOT_EXISTED.message());
                }
                //查询该优惠卡签到记录
                List<AcUserSignRecordDO> acUserSignRecordDOList = acUserSignRecordDaoMapper.signRecordByPreferentialCard(acUserPreferentialCardDO.getUserId(), acUserPreferentialCardDO.getCreateTime());
                //3.输出间隔天数
                long days = (new Date().getTime() - acUserPreferentialCardDO.getCreateTime().getTime()) / 24 / 60 / 60 / 1000;
                if (acUserSignRecordDOList.size() < days){
                    acUserPreferentialCardDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
                    Integer result = acUserPreferentialCardMapper.updateByPrimaryKeySelective(acUserPreferentialCardDO);
                    if (result == 0){
                        throw new BusinessException(ResultCodeEnum.AC_UPDATE_PREFERENTIAL_CARD_FAILED.code(), ResultCodeEnum.AC_UPDATE_PREFERENTIAL_CARD_FAILED.message());
                    }
                }
            });
        }

        logger.info("-----------用户优惠卡签到信息定时任务-------End");
    }

    @Override
    public BaseResponse<List<AcUserPhoneRecordBackDTO>> getUserPhoneRecordList(AcOnlyIdQueryDTO queryDTO) throws Exception {
        logger.info("-----------用户通话记录列表-------Start");
        Page<AcUserPhoneRecordBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcUserPhoneRecordBackDao> list = acUserDaoMapper.getUserPhoneRecordBackList(queryDTO.getId());
        logger.info("-----------用户通话记录列表-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcUserPhoneRecordBackDTO.class));
    }

    @Override
    public HomeStatementDataDTO getRegisterConut() {
        logger.info("-----------后台首页报表-------Start");
        HomeStatementDataDTO homeStatementDataDTO = new HomeStatementDataDTO();
        List<ActiveUserDao> activeUserList = acUserDaoMapper.selectActiveCount();
        homeStatementDataDTO.setActiveUserList(activeUserList);
        List<ActiveUserDao> registerUserList = acUserDaoMapper.selectRegisterCount();
        homeStatementDataDTO.setRegisterUserList(registerUserList);
        logger.info("-----------后台首页报表-------End");
        return homeStatementDataDTO;
    }

    @Override
    public AgencyDataDTO getConsumeCount() throws Exception {
        logger.info("-----------后台首页消费报表-------Start");
        AgencyDataDao agencyDataDao =acUserDaoMapper.getConsumeCount();
        if(Utils.isEmpty(agencyDataDao)){
            AgencyDataDao agencyDataDao1 = new AgencyDataDao();
            agencyDataDao1.setAgency("0");
            agencyDataDao1.setAnchor("0");
            logger.info("-----------后台首页消费报表-------End");
            return BeanUtil.copy(agencyDataDao1,AgencyDataDTO.class);
        }
        logger.info("-----------后台首页消费报表-------End");
        return BeanUtil.copy(agencyDataDao,AgencyDataDTO.class);
    }

    @Override
    public String getRechargeCount() throws Exception {
        logger.info("-----------后台首页充值报表-------Start");
        logger.info("-----------后台首页充值报表-------End");
        return acUserDaoMapper.getRechargeCount();
    }

    @Override
    public Boolean insertUserAnchor(AcUserAnchorDO acUserAnchorDO) throws Exception {
        logger.info("-----------用户代理信息插入-------Start");
        // 校验是否存在
        AcUserAnchorExample anchorExample = new AcUserAnchorExample();
        anchorExample.createCriteria()
                .andAnchorUserIdEqualTo(acUserAnchorDO.getAnchorUserId())
                .andUserIdEqualTo(acUserAnchorDO.getUserId())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserAnchorDO> list = acUserAnchorMapper.selectByExample(anchorExample);
        if (Utils.isEmpty(list)){
            Integer result = acUserAnchorMapper.insertSelective(acUserAnchorDO);
            if (result == 0){
                throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        }
        logger.info("-----------用户代理信息插入-------End");
        return Boolean.TRUE;
    }

    @Override
    public BaseResponse<List<AcBackUserDTO>> getBackUserList(BackUserQueryDTO queryDTO) throws Exception {
        logger.info("-----------后台用户列表查询-------Start");
        Page<AcBackUserDao> pages = PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<AcBackUserDao> list = acUserDaoMapper.getUserBackList(queryDTO.getName(), queryDTO.getLevel(), queryDTO.getIsFreeze());
        logger.info("-----------后台用户列表查询-------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(list, AcBackUserDTO.class));
    }

    @Override
    public BaseResponse<List<AcUserContactBackDTO>> getUserContactBackList(AcUserContactBackQueryDTO backQueryDTO) throws Exception {
        logger.info("-----------后台用户联系人列表查询-------Start");
        if (Objects.isNull(backQueryDTO.getUserId())) {
            logger.info("用户信息ID为空");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        //Page<AcUserContactBackDao> pages = PageHelper.startPage(backQueryDTO.getPageNum(), backQueryDTO.getPageSize());
        //List<YjzhUserContactBackDao> list = yjzhUserDaoMapper.getUserContactBackList(backQueryDTO.getUserId());
        logger.info("-----------后台用户联系人列表查询-------End");
        //return BaseResponse.create(pages.getTotal(), BeanUtil.copy(list, AcUserContactBackDTO.class));
        return null;
    }

    @Override
    public List<AcUserOauthDTO> getUserOauthBackList(Integer userId) throws Exception {
        logger.info("-----------后台用户第三方资料查询-------Start");
        if (Objects.isNull(userId)) {
            logger.info("用户信息ID为空");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        List<AcUserOauthDao> list = acUserDaoMapper.getUserOauthList(userId);
        logger.info("-----------后台用户第三方资料查询-------End");
        return BeanUtil.copy(list, AcUserOauthDTO.class);
    }

    @Override
    public Boolean frozenUser(AcUserFrozenDTO frozenDTO) throws Exception {
        logger.info("-----------后台用户冻结/解冻-------Start");
        if (Objects.isNull(frozenDTO)) {
            logger.info("用户冻结信息为空");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        AcUserDO userDO = acUserMapper.selectByPrimaryKey(frozenDTO.getUserId());
        if (Objects.isNull(userDO)) {
            logger.info("用户信息不存在");
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        userDO.setIsFreeze(frozenDTO.getIsFreeze());
        Integer result = acUserMapper.updateByPrimaryKeySelective(userDO);
        if (result == 0) {
            logger.info("用户状态修改失败");
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }
//        AcUserFreezeDO userFreezeDO = new YjzhUserFreezeDO();
//        userFreezeDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
//        userFreezeDO.setUserId(frozenDTO.getUserId());
//        userFreezeDO.setCreateTime(new Date());
//        userFreezeDO.setFreezeContent(frozenDTO.getFreezeContent());
//        userFreezeMapper.insertSelective(userFreezeDO);
        logger.info("-----------后台用户冻结/解冻-------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean setIsAnchor(AcUtilIdAndStatusDTO statusDTO) throws Exception {
        logger.info("-----------后台用户设置取消主播-------Start");
        if (Utils.isEmpty(statusDTO)) {
            logger.info("参数为空");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        AcUserDO userDO = acUserMapper.selectByPrimaryKey(statusDTO.getId());
        if (Utils.isEmpty(userDO)){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        userDO.setIsAnchor(statusDTO.getStatus());
        Integer result = acUserMapper.updateByPrimaryKeySelective(userDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("-----------后台用户设置取消主播-------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean setIsAgency(AcUtilIdAndStatusDTO statusDTO) throws Exception {
        logger.info("-----------后台用户设置取消代理-------Start");
        if (Utils.isEmpty(statusDTO)) {
            logger.info("参数为空");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        AcUserDO userDO = acUserMapper.selectByPrimaryKey(statusDTO.getId());
        if (Utils.isEmpty(userDO)){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        userDO.setIsAgency(statusDTO.getStatus());
        Integer result = acUserMapper.updateByPrimaryKeySelective(userDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("-----------后台用户设置取消代理-------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean setUserBlacklist(Integer id) throws Exception {
        logger.info("-----------后台用户添加黑名單-------Start");
        if (Utils.isEmpty(id)) {
            logger.info("参数为空");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(id);
        if(acUserDO.getIsBlackList().equals(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode())){
            acUserDO.setIsBlackList(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        }else {
            acUserDO.setIsBlackList(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        }
        Integer result = acUserMapper.updateByPrimaryKey(acUserDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("-----------后台用户添加黑名單-------End");
        return Boolean.TRUE;
    }

    @Override
    public Integer getPeopleCount() throws Exception {
        logger.info("-----------首页报表查询注册人数-------Start");
        Integer count = acUserDaoMapper.selectPeopleCount();
        logger.info("-----------首页报表查询注册人数-------End");
        return count;
    }

    @Override
    public Boolean updateUserPasswordBack(AcUpdateUserPasswordDTO userPasswordDTO) throws Exception {
        logger.info("-----------后台修改用户密码-------Start");

        logger.info("-----------后台修改用户密码-------Start");
        return Boolean.TRUE;
    }

    @Override
    public BaseResponse<List<AcUserUnderlingBackDTO>> getUserUnderlingListBack(AcUserUnderlingQueryDTO queryDTO) throws Exception {
        logger.info("-----------后台用户下级用户列表-------Start");
        if (Objects.isNull(queryDTO.getUserId())){
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        Page<AcUserUnderlingBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcUserUnderlingBackDao> list = acUserDaoMapper.getUserUnderlingBackList(queryDTO.getUserId());
        logger.info("-----------后台用户下级用户列表-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcUserUnderlingBackDTO.class));
    }
}
