package com.aichu.service.api.impl;

import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcSysAppVersionMapper;
import com.aichu.dao.autogeneration.object.AcSysAppVersionDO;
import com.aichu.dao.autogeneration.object.AcSysAppVersionExample;
import com.aichu.dao.autogeneration.object.AcSysConfigDO;
import com.aichu.dao.workstation.mapper.AcSysSystemConfigDaoMapper;
import com.aichu.manager.enums.AppTypeEnum;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.SysConfigEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcSysSystemConfigService;
import com.aichu.service.dto.AppVersionInfoDTO;
import com.aichu.service.dto.CustomerInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AcSysSystemConfigServiceImpl
 * @Description 爱触意见反馈信息ServiceImlpl
 * @Author Melon
 * @Date 2019/9/18 19:09
 * @Version 1.0.0
 **/
@Service
public class AcSysSystemConfigServiceImpl implements AcSysSystemConfigService {

    private Logger logger = LoggerFactory.getLogger(AcSysSystemConfigServiceImpl.class);

    @Autowired
    private AcSysSystemConfigDaoMapper acSysSystemConfigDaoMapper;

    @Autowired
    private AcSysAppVersionMapper acSysAppVersionMapper;

    @Override
    public String systemPolicy(Integer policyType, Integer userId) throws Exception {
        logger.info("--------------爱触协议信息-----------Start: policyType:--{}", policyType);

        AcSysConfigDO acSysConfigDO = acSysSystemConfigDaoMapper.systemPolicy(policyType);

        if (policyType == SysConfigEnum.SYS_SYSTEM_CONFIG_KEY_GENERALIZE_LINK.getTag()){
            return acSysConfigDO.getValue() + "?id=" + userId;
        }

        logger.info("--------------爱触协议信息-----------End");
        return acSysConfigDO.getValue();
    }

    @Override
    public CustomerInfoDTO customerInfo() throws Exception {
        logger.info("--------------客服联系信息-----------Start");

        AcSysConfigDO acSysConfigDO = acSysSystemConfigDaoMapper.systemPolicy(7);

        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        customerInfoDTO.setKeys(acSysConfigDO.getKeys());
        customerInfoDTO.setKeyName(acSysConfigDO.getKeyName());
        customerInfoDTO.setKeyValue(acSysConfigDO.getValue());
        customerInfoDTO.setKeyComment(acSysConfigDO.getComment());

        logger.info("--------------客服联系信息-----------End");
        return customerInfoDTO;
    }

    @Override
    public AppVersionInfoDTO customerAppVersion(Integer appType, Integer version) throws Exception {
        logger.info("--------------APP版本查验-----------Start: appType:--{}, version:--{}", appType, version);

        AppVersionInfoDTO appVersionInfoDTO = new AppVersionInfoDTO();

        AcSysAppVersionExample acSysAppVersionExample = new AcSysAppVersionExample();
        acSysAppVersionExample.createCriteria()
                .andTypeEqualTo(appType)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcSysAppVersionDO> acSysAppVersionDOList = acSysAppVersionMapper.selectByExample(acSysAppVersionExample);
        if (Utils.isEmpty(acSysAppVersionDOList)){
            throw new BusinessException(ResultCodeEnum.AC_APP_VERSION_NOT_EXIST.code(), ResultCodeEnum.AC_APP_VERSION_NOT_EXIST.message());
        }

        if (acSysAppVersionDOList.get(0).getInVersion() > version){
            appVersionInfoDTO.setIsUpdate(1);
        }else {
            appVersionInfoDTO.setIsUpdate(0);
        }
        appVersionInfoDTO.setIsCompelUpdate(acSysAppVersionDOList.get(0).getIsCompelUpdate());
        appVersionInfoDTO.setLoadUrl(acSysAppVersionDOList.get(0).getVersionUrl());

        logger.info("--------------APP版本查验-----------End");
        return appVersionInfoDTO;
    }
}
