package com.aichu.service.api.impl;

import com.aichu.common.util.common.BeanUtil;
import com.aichu.dao.autogeneration.mapper.AcSysProvinceMapper;
import com.aichu.dao.autogeneration.object.AcSysProvinceDO;
import com.aichu.dao.autogeneration.object.AcSysProvinceExample;
import com.aichu.service.api.AcUtilService;
import com.aichu.service.dto.AcUtilIdAndNameDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName YjzhUtilServiceImpl
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/16
 * @Version 1.0.0
 */
@Service
public class AcUtilServiceImpl implements AcUtilService {

    private Logger logger = LoggerFactory.getLogger(AcUtilServiceImpl.class);

    @Autowired
    private AcSysProvinceMapper sysProvinceMapper;

    @Override
    public List<AcUtilIdAndNameDTO> getProvinceList() throws Exception {
        logger.info("-----------查询省列表------Start");
        AcSysProvinceExample sysProvinceExample = new AcSysProvinceExample();
        List<AcSysProvinceDO> list = sysProvinceMapper.selectByExample(sysProvinceExample);
        logger.info("-----------查询省列表------End");
        return BeanUtil.copy(list,AcUtilIdAndNameDTO.class);
    }
}
