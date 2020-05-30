package com.aichu.service.api.impl;

import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcUserDeviceMapper;
import com.aichu.dao.autogeneration.object.AcUserDeviceDO;
import com.aichu.dao.autogeneration.object.AcUserDeviceExample;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcUserDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AcUserDeviceServiceImpl
 * @Description 即时通讯设备信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/20 14:45
 * @Version 1.0.0
 **/
@Service
public class AcUserDeviceServiceImpl implements AcUserDeviceService {

    private Logger logger = LoggerFactory.getLogger(AcUserDeviceServiceImpl.class);

    @Autowired
    private AcUserDeviceMapper acUserDeviceMapper;

    @Override
    public Boolean deviceBindDeviceNo(String deviceNo, Integer deviceType, Integer userId) throws Exception {
        logger.info("--------------消息推送绑定设备信息-----------Start: deviceNo:--{},deviceType:--{},userId:--{}", deviceNo, deviceType, userId);

        AcUserDeviceExample acUserDeviceExample = new AcUserDeviceExample();
        acUserDeviceExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserDeviceDO> acUserDeviceDOList = acUserDeviceMapper.selectByExample(acUserDeviceExample);
        if (Utils.isEmpty(acUserDeviceDOList)){
            AcUserDeviceDO acUserDeviceDO = new AcUserDeviceDO();
            acUserDeviceDO.setUserId(userId);
            acUserDeviceDO.setDeviceNo(deviceNo);
            acUserDeviceDO.setDeviceType(deviceType);
            Integer result = acUserDeviceMapper.insertSelective(acUserDeviceDO);
            if (result == 0){
                throw new BusinessException(ResultCodeEnum.USER_DEVICE_BIND_ERROR.code(), ResultCodeEnum.USER_DEVICE_BIND_ERROR.message());
            }
        }else {
            if (!acUserDeviceDOList.get(0).getDeviceNo().equals(deviceNo)){
                acUserDeviceDOList.get(0).setDeviceNo(deviceNo);
                acUserDeviceDOList.get(0).setDeviceType(deviceType);
                Integer result = acUserDeviceMapper.updateByPrimaryKeySelective(acUserDeviceDOList.get(0));
                if (result == 0){
                    throw new BusinessException(ResultCodeEnum.USER_DEVICE_BIND_UPDATE_ERROR.code(), ResultCodeEnum.USER_DEVICE_BIND_UPDATE_ERROR.message());
                }
            }
        }

        logger.info("--------------消息推送绑定设备信息-----------End");
        return true;
    }
}
