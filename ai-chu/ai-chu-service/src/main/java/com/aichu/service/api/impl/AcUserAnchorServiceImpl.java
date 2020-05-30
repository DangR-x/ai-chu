package com.aichu.service.api.impl;

import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcOrderBaseMapper;
import com.aichu.dao.autogeneration.mapper.AcUserAnchorMapper;
import com.aichu.dao.autogeneration.mapper.AcUserMapper;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.dao.workstation.mapper.AcUserAnchorDaoMapper;
import com.aichu.dao.workstation.mapper.AcUserDaoMapper;
import com.aichu.dao.workstation.object.UserAgencyNextUserDao;
import com.aichu.dao.workstation.object.UserLikeDao;
import com.aichu.manager.enums.*;
import com.aichu.service.api.AcSysSystemConfigService;
import com.aichu.service.api.AcUserAnchorService;
import com.aichu.service.dto.AgencyAnchorCenterDTO;
import com.aichu.service.dto.AgencyAnchorDTO;
import com.aichu.service.dto.UserAgencyNextUserDTO;
import com.aichu.service.dto.UserLikeDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AcUserAnchorServiceImpl
 * @Description 用户代理主播信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/23 11:40
 * @Version 1.0.0
 **/
@Service
public class AcUserAnchorServiceImpl implements AcUserAnchorService {

    private Logger logger = LoggerFactory.getLogger(AcUserAnchorServiceImpl.class);

    @Autowired
    private AcUserAnchorMapper acUserAnchorMapper;

    @Autowired
    private AcUserAnchorDaoMapper acUserAnchorDaoMapper;

    @Autowired
    private AcOrderBaseMapper acOrderBaseMapper;

    @Autowired
    private AcSysSystemConfigService acSysSystemConfigService;

    @Autowired
    private AcUserMapper acUserMapper;

    @Autowired
    private AcUserDaoMapper acUserDaoMapper;

    @Override
    public String agencyApply(Integer userId) throws Exception {
        logger.info("-----------申请成为代理用户信息-------Start：userId：--{}", userId);

        //查询用户充值流水信息
        final Integer[] totalAmount = {0};
        AcOrderBaseExample acOrderBaseExample = new AcOrderBaseExample();
        acOrderBaseExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andPayUseEqualTo(OrderStatusEnum.ORDER_STATUS_PAY_USE_CHARGE.getCode())
                .andPayStatusEqualTo(OrderStatusEnum.ORDER_STATUS_PAY_STATUS_HAS_PAYMENT.getCode())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcOrderBaseDO> acOrderBaseDOList = acOrderBaseMapper.selectByExample(acOrderBaseExample);
        if (!Utils.isEmpty(acOrderBaseDOList)){
            acOrderBaseDOList.stream().forEach( acOrderBaseDO -> {
                totalAmount[0] += acOrderBaseDO.getOrderAmount();
            });
        }

        //查詢成为代理所需费用
        Integer agencyChargeRules = Integer.parseInt(acSysSystemConfigService.systemPolicy(SysConfigEnum.SYS_SYSTEM_CONFIG_KEY_AGENCY_CHARGE_RULES.getTag(), userId));
        if (totalAmount[0] < agencyChargeRules){
            throw new BusinessException(ResultCodeEnum.AGENCY_BECOME_MUST_CHARGE_ENOUGH.code(), ResultCodeEnum.AGENCY_BECOME_MUST_CHARGE_ENOUGH.message());
        }

        logger.info("-----------申请成为代理用户信息-------End");
        return acSysSystemConfigService.systemPolicy(SysConfigEnum.SYS_SYSTEM_CONFIG_KEY_CUSTOMER_SERVER_WE_CHAT.getTag(), userId);
    }

    @Override
    public List<AgencyAnchorDTO> agencyAnchors(Integer userId) throws Exception {
        logger.info("-----------代理用户在线用户信息-------Start：userId：--{}", userId);

        List<AgencyAnchorDTO> agencyAnchorDTOList = new ArrayList<>();

        AcUserAnchorExample acUserAnchorExample = new AcUserAnchorExample();
        acUserAnchorExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserAnchorDO> acUserAnchorDOList = acUserAnchorMapper.selectByExample(acUserAnchorExample);
        if (!Utils.isEmpty(acUserAnchorDOList)){
            acUserAnchorDOList.stream().forEach( acUserAnchorDO -> {
                AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
                if (acUserDO == null){
                    throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
                }
                AgencyAnchorDTO agencyAnchorDTO = new AgencyAnchorDTO();
                agencyAnchorDTO.setUserId(acUserDO.getId());
                agencyAnchorDTO.setUserAcId(acUserDO.getAcUid());
                agencyAnchorDTO.setUserName(acUserDO.getNickName());
                agencyAnchorDTO.setUserHead(acUserDO.getHeadImg());
                agencyAnchorDTO.setUserSignature(acUserDO.getSignature());
                agencyAnchorDTOList.add(agencyAnchorDTO);
            });
        }

        logger.info("-----------代理用户在线用户信息-------End");
        return agencyAnchorDTOList;
    }

    @Override
    public Boolean agencyAnchorFindByKeyWord(String keyWord, Integer userId) throws Exception {
        logger.info("-----------代理用户添加主播用户信息-------Start：keyWord：--{}, userId：--{}", keyWord, userId);

        AcUserDO acUserDO = acUserDaoMapper.selectAcUserByKeyWord(keyWord);
        if (acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        AcUserAnchorExample acUserAnchorExample = new AcUserAnchorExample();
        acUserAnchorExample.createCriteria()
                .andAnchorUserIdEqualTo(acUserDO.getId())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserAnchorDO> acUserAnchorDOList = acUserAnchorMapper.selectByExample(acUserAnchorExample);
        if (!Utils.isEmpty(acUserAnchorDOList)){
            // 当该用户是次用户分享注册的
            if (acUserAnchorDOList.get(0).getUserId().equals(userId) && acUserDO.getIsAnchor().equals(UserAnchorTypeEnum.USER_ANCHORE_TYPE_TRUE.getCode())){
                throw new BusinessException(ResultCodeEnum.AGENCY_ANCHOR_IS_EXIST.code(), ResultCodeEnum.AGENCY_ANCHOR_IS_EXIST.message());
            } else {
                throw new BusinessException(ResultCodeEnum.AGENCY_ANCHOR_HAS_BEAN_BIND.code(), ResultCodeEnum.AGENCY_ANCHOR_HAS_BEAN_BIND.message());
            }
        }
        if (Utils.isEmpty(acUserAnchorDOList)) {
            AcUserAnchorDO acUserAnchorDO = new AcUserAnchorDO();
            acUserAnchorDO.setUserId(userId);
            acUserAnchorDO.setAnchorUserId(acUserDO.getId());
            Integer result = acUserAnchorMapper.insertSelective(acUserAnchorDO);
            if (result == 0){
                throw new BusinessException(ResultCodeEnum.AGENCY_ANCHOR_ADD_ERROR.code(), ResultCodeEnum.AGENCY_ANCHOR_ADD_ERROR.message());
            }
        }
        acUserDO.setIsAnchor(UserAnchorTypeEnum.USER_ANCHORE_TYPE_TRUE.getCode());
        Integer setResult = acUserMapper.updateByPrimaryKeySelective(acUserDO);
        if (setResult == 0){
            throw new BusinessException(ResultCodeEnum.AGENCY_ANCHOR_ADD_ERROR.code(), ResultCodeEnum.AGENCY_ANCHOR_ADD_ERROR.message());
        }
        logger.info("-----------代理用户添加主播用户信息-------End");
        return true;
    }

    @Override
    public Boolean agencyAnchorRemove(Integer aimUserId, Integer userId) throws Exception {
        logger.info("-----------代理用户移除主播用户信息-------Start：aimUserId：--{}, userId：--{}", aimUserId, userId);

        AcUserAnchorExample acUserAnchorExample = new AcUserAnchorExample();
        acUserAnchorExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andAnchorUserIdEqualTo(aimUserId)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserAnchorDO> acUserAnchorDOList = acUserAnchorMapper.selectByExample(acUserAnchorExample);
        if (Utils.isEmpty(acUserAnchorDOList)){
            throw new BusinessException(ResultCodeEnum.AGENCY_ANCHOR_USER_NOT_EXISTED.code(), ResultCodeEnum.AGENCY_ANCHOR_USER_NOT_EXISTED.message());
        }

        acUserAnchorDOList.get(0).setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acUserAnchorMapper.updateByPrimaryKeySelective(acUserAnchorDOList.get(0));
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.AGENCY_ANCHOR_REMOVE_FILED.code(), ResultCodeEnum.AGENCY_ANCHOR_REMOVE_FILED.message());
        }

        logger.info("-----------代理用户移除主播用户信息-------End");
        return true;
    }

    @Override
    public AgencyAnchorCenterDTO agencyAnchorCenter(Integer userId) throws Exception {
        logger.info("-----------代理用户代理中心信息-------Start：userId：--{}", userId);

        AgencyAnchorCenterDTO agencyAnchorCenterDTO = BeanUtil.copy(acUserAnchorDaoMapper.agencyAnchorCenter(userId), AgencyAnchorCenterDTO.class);

        logger.info("-----------代理用户代理中心信息-------End");
        return agencyAnchorCenterDTO;
    }

    @Override
    public BaseResponse<List<UserAgencyNextUserDTO>> userAgencyNextUserList(Integer userId, BasePageOrder basePageOrder) throws Exception {
        logger.info("-----------用户代理下级用戶列表信息-分页-------Start: userId:--{}, basePageOrder:--{}", userId, basePageOrder);

        Page<UserAgencyNextUserDao> pages = PageHelper.startPage(basePageOrder.getPageNum(), basePageOrder.getPageSize());
        List<UserAgencyNextUserDao> userAgencyNextUserDaoList = acUserAnchorDaoMapper.userAgencyNextUserList(userId);

        logger.info("-----------用户代理下级用戶列表信息-分页-------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(userAgencyNextUserDaoList, UserAgencyNextUserDTO.class));
    }
}
