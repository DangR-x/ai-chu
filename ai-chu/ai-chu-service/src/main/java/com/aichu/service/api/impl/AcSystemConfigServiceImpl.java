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
import com.aichu.dao.workstation.mapper.AcSysConfigDaoMapper;
import com.aichu.dao.workstation.mapper.AcSysSystemConfigDaoMapper;
import com.aichu.dao.workstation.object.*;
import com.aichu.manager.api.push.JPushClientUtil;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.manager.enums.UserStatusTypeEnum;
import com.aichu.service.api.AcSystemConfigService;
import com.aichu.service.dto.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName AcSystemConfigServiceImpl
 * @Description 用户信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/20 14:45
 * @Version 1.0.0
 **/
@Service
public class AcSystemConfigServiceImpl implements AcSystemConfigService {

    private Logger logger = LoggerFactory.getLogger(AcSystemConfigServiceImpl.class);

    @Autowired
    private AcSysConfigDaoMapper acSysConfigDaoMapper;

    @Autowired
    private AcSysConfigMapper acSysConfigMapper;

    @Autowired
    private AcPreferentialCardDaoMapper acPreferentialCardDaoMapper;

    @Autowired
    private AcPreferentialCardMapper acPreferentialCardMapper;

    @Autowired
    private AcSysAgentConfigMapper acSysAgentConfigMapper;

    @Autowired
    private AcSysChargeConfigMapper acSysChargeConfigMapper;

    @Autowired
    private AcSysSystemConfigDaoMapper sysSystemConfigDaoMapper;

    @Autowired
    private AcSysMessageMapper sysMessageMapper;

    @Autowired
    private AcUserMessageReadMapper acUserMessageReadMapper;

    @Autowired
    private AcUserDeviceMapper userDeviceMapper;

    @Autowired
    private AcSysAppVersionMapper appVersionMapper;

    @Autowired
    private AcUserMapper acUserMapper;

    @Override
    public BaseResponse<List<AcSysSystemConfigDTO>> getSystemConfigBackList(AcSysSystemConfigQueryDTO queryDTO) throws Exception {
        logger.info("--------------后台系统配置信息列表查询-----------Start");
        Page<AcSysConfigDao> pages = PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<AcSysConfigDao> list = acSysConfigDaoMapper.getSystemConfigList(queryDTO.getName(), queryDTO.getType(), queryDTO.getSource());
        logger.info("--------------后台系统配置信息列表查询-----------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(list, AcSysSystemConfigDTO.class));
    }

    @Override
    public Boolean deleteSystemConfig(Integer id) throws Exception {
        logger.info("--------------后台系统配置信息删除-----------Start");
        if (Objects.isNull(id)) {
            logger.info("后台系统配置信息删除ID为空，系统异常");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcSysConfigDO configDO = new AcSysConfigDO();
        configDO.setId(id);
        configDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acSysConfigMapper.updateByPrimaryKeySelective(configDO);
        if (result == 0) {
            logger.info("后台系统配置信息删除失败，系统异常");
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台系统配置信息删除-----------End");
        return true;
    }

    @Override
    public Boolean addOrUpdateSystemConfig(AcSysSystemConfigDTO configDTO) throws Exception {
        logger.info("--------------后台系统配置信息新增/修改-----------Start");
        if (Objects.isNull(configDTO)) {
            logger.info("后台系统配置信息为空，系统异常");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcSysConfigDao configDao = BeanUtil.copy(configDTO, AcSysConfigDao.class);
        if (Objects.isNull(configDao.getId())) { // 新增
            configDao.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            configDao.setCreateTime(DateUtils.formatDateToString(new Date()));
            Integer result = acSysConfigDaoMapper.insertSystemConfig(configDao);
            if (result == 0) {
                logger.info("后台系统配置信息新增失败，系统异常");
                throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else { // 修改
            Integer result = acSysConfigDaoMapper.updateSystemConfig(configDao);
            if (result == 0) {
                logger.info("后台系统配置信息修改失败，系统异常");
                throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("--------------后台系统配置信息新增/修改-----------End");
        return true;
    }

    @Override
    public BaseResponse<List<AcPreferentialCardBackDTO>> getPreferentialCardBackList(AcQueryOnlyNameDTO queryDTO) throws Exception {
        logger.info("--------------后台优惠卡列表-----------Start");
        Page<AcPreferentialCardBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcPreferentialCardBackDao> list = acPreferentialCardDaoMapper.getPreferentialCarList(queryDTO.getName());
        logger.info("--------------后台优惠卡列表-----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcPreferentialCardBackDTO.class));
    }

    @Override
    public BaseResponse<List<AcSysAgentConfigBackDTO>> getSysAgentConfigBackList(AcSysAgentConfigQueryDTO queryDTO) throws Exception {
        logger.info("--------------后台用户代理主播提成比例设置列表-----------Start");
        Page<AcSysAgentConfigBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcSysAgentConfigBackDao> list = acSysConfigDaoMapper.getSysAgentConfigList(queryDTO.getLevel());
        logger.info("--------------后台用户代理主播提成比例设置列表-----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcSysAgentConfigBackDTO.class));
    }

    @Override
    public List<AcUtilIdAndNameDTO> getSysAgentConfigSelectList() throws Exception {
        logger.info("--------------后台用户代理主播等级下拉列表-----------Start");
        List<AcUtilIdAndNameDao> list = acSysConfigDaoMapper.getSysAgentConfigSelectList();
        logger.info("--------------后台用户代理主播等级下拉列表-----------End");
        return BeanUtil.copy(list,AcUtilIdAndNameDTO.class);
    }

    @Override
    public Boolean addOrUpdatePreferentialCardBack(AcPreferentialCardBackDTO backDTO) throws Exception {
        logger.info("--------------后台优惠卡新增修改-----------Start");
        if (Utils.isEmpty(backDTO)){
            throw  new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcPreferentialCardDO preferentialCardDO = new AcPreferentialCardDO();
        preferentialCardDO.setCardName(backDTO.getCardName());
        preferentialCardDO.setCardDetail(backDTO.getCardDetail());
        preferentialCardDO.setCardOriginalPrice(backDTO.getCardOriginalPrice());
        preferentialCardDO.setCardSalePrice(backDTO.getCardSalePrice());
        preferentialCardDO.setCardType(backDTO.getCardType());
        preferentialCardDO.setEveryDayFreeCoin(backDTO.getEveryDayFreeCoin());
        preferentialCardDO.setSignTime(backDTO.getSignTime());
        preferentialCardDO.setTotalFreeCoin(backDTO.getTotalFreeCoin());
        if (Objects.isNull(backDTO.getId())){ // 新增
            preferentialCardDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            preferentialCardDO.setCreateTime(new Date());
            Integer result = acPreferentialCardMapper.insertSelective(preferentialCardDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else {
            preferentialCardDO.setId(backDTO.getId());
            Integer result = acPreferentialCardMapper.updateByPrimaryKeySelective(preferentialCardDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("--------------后台优惠卡新增修改-----------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean deletePreferentialCardBack(Integer id) throws Exception {
        logger.info("--------------后台优惠卡删除-----------Start");
        if (Utils.isEmpty(id)){
            throw  new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcPreferentialCardDO preferentialCardDO = acPreferentialCardMapper.selectByPrimaryKey(id);
        if (Utils.isEmpty(preferentialCardDO)){
            throw  new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        preferentialCardDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acPreferentialCardMapper.updateByPrimaryKeySelective(preferentialCardDO);
        if (result == 0){
            throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台优惠卡删除-----------Endt");
        return Boolean.TRUE;
    }

    @Override
    public Boolean addOrUpdateSysAgentConfigBack(AcSysAgentConfigBackDTO backDTO) throws Exception {
        logger.info("--------------后台新增修改用户代理主播提成比例设置-----------Start");
        if (Utils.isEmpty(backDTO)){
            throw  new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysAgentConfigDO configDO = new AcSysAgentConfigDO();
        configDO.setLevel(backDTO.getLevel());
        configDO.setDeductRate(backDTO.getDeductRate());
        configDO.setMaxUserNum(backDTO.getMaxUserNum());
        configDO.setMinUserNum(backDTO.getMinUserNum());
        configDO.setRiseEarnings(backDTO.getRiseEarnings());
        if (Objects.isNull(backDTO.getId())){ // 新增
            configDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            configDO.setCreateTime(new Date());
            Integer result = acSysAgentConfigMapper.insertSelective(configDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else { // 修改
            configDO.setId(backDTO.getId());
            Integer result = acSysAgentConfigMapper.updateByPrimaryKeySelective(configDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("--------------后台新增修改用户代理主播提成比例设置-----------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteSysAgentConfigBack(Integer id) throws Exception {
        logger.info("--------------后台用户代理主播提成比例设置删除-----------Start");
        if (Utils.isEmpty(id)){
            throw  new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysAgentConfigDO configDO = acSysAgentConfigMapper.selectByPrimaryKey(id);
        if (Utils.isEmpty(configDO)){
            throw  new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        configDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acSysAgentConfigMapper.updateByPrimaryKeySelective(configDO);
        if (result == 0){
            throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台用户代理主播提成比例设置删除-----------End");
        return Boolean.TRUE;
    }

    @Override
    public BaseResponse<List<AcSysChargeConfigDTO>> getSysChargeBackList(BasePageOrder pageOrder) {
        logger.info("--------------后台充值比例列表-----------Start");
        Page<AcSysChargeConfigDao> pages = PageHelper.startPage(pageOrder.getPageNum(),pageOrder.getPageSize());
        List<AcSysChargeConfigDao> list = sysSystemConfigDaoMapper.getSysChargeConfigList();
        logger.info("--------------后台充值比例列表-----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcSysChargeConfigDTO.class));
    }

    @Override
    public Boolean addOrUpdateSysChargeBack(AcSysChargeConfigDTO configDTO) {
        logger.info("--------------后台充值比例新增修改-----------Start");
        if (Utils.isEmpty(configDTO)){
            throw  new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysChargeConfigDO sysChargeConfigDO = new AcSysChargeConfigDO();
        sysChargeConfigDO.setChargeAmount(configDTO.getChargeAmount());
        sysChargeConfigDO.setChargeCoin(configDTO.getChargeCoin());
        if (Utils.isEmpty(configDTO.getId())){ // 新增
            sysChargeConfigDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            sysChargeConfigDO.setCreateTime(new Date());
            Integer result = acSysChargeConfigMapper.insertSelective(sysChargeConfigDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else {
            sysChargeConfigDO.setId(configDTO.getId());
            Integer result = acSysChargeConfigMapper.updateByPrimaryKeySelective(sysChargeConfigDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("--------------后台充值比例新增修改-----------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteSysChargeBack(Integer id) {
        logger.info("--------------后台充值比例删除-----------Start");
        if (Utils.isEmpty(id)){
            throw  new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysChargeConfigDO configDO = acSysChargeConfigMapper.selectByPrimaryKey(id);
        if (Utils.isEmpty(configDO)){
            throw  new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        configDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acSysChargeConfigMapper.updateByPrimaryKeySelective(configDO);
        if (result == 0){
            throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台充值比例删除-----------End");
        return Boolean.TRUE;
    }

    @Override
    public BaseResponse<List<AcSysMessageBackDTO>> getSysMessageBackList(AcQueryOnlyNameDTO queryDTO) throws Exception {
        logger.info("--------------后台系统消息列表查询-----------Start");
        Page<AcSysMessageDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcSysMessageDao> list = acSysConfigDaoMapper.getSysMesageBackList(queryDTO.getName());
        logger.info("--------------后台系统消息列表查询-----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcSysMessageBackDTO.class));
    }

    @Override
    public Boolean addOrUpdateSysMessageBack(AcSysMessageBackDTO backDTO) throws Exception {
        logger.info("--------------后台系统消息新增修改-----------Start");
        if (Utils.isEmpty(backDTO)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysMessageDO messageDO = new AcSysMessageDO();
        messageDO.setMessageTitle(backDTO.getMessageTitle());
        messageDO.setMessageContent(backDTO.getMessageContent());
        messageDO.setMessageType(backDTO.getMessageType());
        if (Utils.isEmpty(backDTO.getId())){ // 新增
            messageDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            messageDO.setCreateTime(new Date());
            Integer result = sysMessageMapper.insertSelective(messageDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else { // 修改
            messageDO.setId(backDTO.getId());
            Integer result = sysMessageMapper.updateByPrimaryKeySelective(messageDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("--------------后台系统消息新增修改-----------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteSysMessageBack(Integer id) throws Exception {
        logger.info("--------------后台系统消息删除-----------Start");
        if (Utils.isEmpty(id)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysMessageDO messageDO = sysMessageMapper.selectByPrimaryKey(id);
        if (Utils.isEmpty(messageDO)){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        messageDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = sysMessageMapper.updateByPrimaryKeySelective(messageDO);
        if (result == 0){
            throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台系统消息删除-----------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean pushSysMessageBack(Integer id) throws Exception {
        logger.info("--------------后台系统消息推送-----------Start");
        if (Utils.isEmpty(id)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysMessageDO messageDO = sysMessageMapper.selectByPrimaryKey(id);
        if (Utils.isEmpty(messageDO)){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        // 获取用户设备信息
//        AcUserDeviceExample userDeviceExample = new AcUserDeviceExample();
//        userDeviceExample.createCriteria().andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
//        List<AcUserDeviceDO> list = userDeviceMapper.selectByExample(userDeviceExample);
//        if (Utils.isEmpty(list)){
//            throw new BusinessException(ResultCodeEnum.USER_DEVICE_NOT_EXIST.code(), ResultCodeEnum.USER_DEVICE_NOT_EXIST.message());
//        }
//        List<String> sendList = new ArrayList<>();
//        list.forEach(li->{
//            sendList.add(li.getDeviceNo());
//        });
        AcUserExample acUserExample = new AcUserExample();
        acUserExample.createCriteria()
                .andIsFreezeEqualTo(UserStatusTypeEnum.USER_STATUS_TYPE_NORMAL.getCode())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserDO> acUserExampleList = acUserMapper.selectByExample(acUserExample);
        acUserExampleList.forEach( acUserDO -> {
            AcUserMessageReadDO acUserMessageReadDO = new AcUserMessageReadDO();
            acUserMessageReadDO.setUserId(acUserDO.getId());
            acUserMessageReadDO.setMessageId(id);
            acUserMessageReadDO.setIsRead(0);
            Integer result =  acUserMessageReadMapper.insertSelective(acUserMessageReadDO);
            if (result == 0){
                throw new BusinessException(ResultCodeEnum.PUSH_MESSAGE_ERROR.code(), ResultCodeEnum.PUSH_MESSAGE_ERROR.message());
            }
        });

        Integer result = JPushClientUtil.sendToAll(messageDO.getMessageTitle(),messageDO.getMessageTitle(),messageDO.getMessageContent(),""
        );
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.PUSH_MESSAGE_ERROR.code(), ResultCodeEnum.PUSH_MESSAGE_ERROR.message());
        }
        logger.info("--------------后台系统消息推送-----------End");
        return Boolean.TRUE;
    }

    @Override
    public BaseResponse<List<AcSysAppVersionBackDTO>> getAppVersionBackList(AcSysAppVersionBackQueryDTO queryDTO) throws Exception {
        logger.info("--------------后台App版本管理列表-----------Start");
        Page<AcSysAppVersionBackDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcSysAppVersionBackDao> list = acSysConfigDaoMapper.getAppVersionBackList(queryDTO.getName(),queryDTO.getType());
        logger.info("--------------后台App版本管理列表-----------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcSysAppVersionBackDTO.class));
    }

    @Override
    public Boolean addOrUpdateAppVersionBack(AcSysAppVersionBackDTO addDTO) throws Exception {
        logger.info("--------------后台App版本管理新增修改-----------Start");
        if (Utils.isEmpty(addDTO)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysAppVersionDO appVersionDO = new AcSysAppVersionDO();
        appVersionDO.setAppName(addDTO.getAppName());
        appVersionDO.setInVersion(addDTO.getInVersion());
        appVersionDO.setVersion(addDTO.getVersion());
        appVersionDO.setVersionDesc(addDTO.getVersionDesc());
        appVersionDO.setVersionUrl(addDTO.getVersionUrl());
        appVersionDO.setType(addDTO.getType());
        appVersionDO.setIsCompelUpdate(addDTO.getIsCompelUpdate());
        if (Utils.isEmpty(addDTO.getId())){ // 新增
            appVersionDO.setCreateTime(new Date());
            appVersionDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            Integer result = appVersionMapper.insertSelective(appVersionDO);
            if (result == 0){
                throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else { // 修改
            appVersionDO.setId(addDTO.getId());
            Integer result = appVersionMapper.updateByPrimaryKeySelective(appVersionDO);
            if (result == 0){
                throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("--------------后台App版本管理新增修改-----------End");
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteAppVersionBack(Integer id) throws Exception {
        logger.info("--------------后台App版本管理删除-----------Start");
        if (Utils.isEmpty(id)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcSysAppVersionDO appVersionDO = appVersionMapper.selectByPrimaryKey(id);
        if (Utils.isEmpty(appVersionDO)){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        appVersionDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = appVersionMapper.updateByPrimaryKeySelective(appVersionDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台App版本管理删除-----------End");
        return Boolean.TRUE;
    }
}
