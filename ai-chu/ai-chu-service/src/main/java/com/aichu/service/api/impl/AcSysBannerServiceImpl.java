package com.aichu.service.api.impl;

import com.aichu.common.util.common.Utils;
import com.aichu.dao.autogeneration.mapper.AcSysBannerMapper;
import com.aichu.dao.autogeneration.object.AcSysBannerDO;
import com.aichu.dao.autogeneration.object.AcSysBannerExample;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcSysBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AcSysBannerServiceImpl
 * @Description 系统Banner信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/23 11:40
 * @Version 1.0.0
 **/
@Service
public class AcSysBannerServiceImpl implements AcSysBannerService {

    private Logger logger = LoggerFactory.getLogger(AcSysBannerServiceImpl.class);

    @Autowired
    private AcSysBannerMapper acSysBannerMapper;

    @Override
    public List<String> systemBannerDictInfoList(Integer bannerType) throws Exception {
        logger.info("-----------系统Banner字典信息-------Start：bannerType：--{}", bannerType);

        List<String> bannerList = new ArrayList<>();

        AcSysBannerExample acSysBannerExample = new AcSysBannerExample();
        acSysBannerExample.createCriteria()
                .andBannerTypeEqualTo(bannerType)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcSysBannerDO> acSysBannerDOList = acSysBannerMapper.selectByExample(acSysBannerExample);
        if (!Utils.isEmpty(acSysBannerDOList)){
            acSysBannerDOList.stream().forEach( acSysBannerDO -> {
                bannerList.add(acSysBannerDO.getBannerUrl());
            });
        }

        logger.info("-----------系统Banner字典信息-------End");
        return bannerList;
    }
}
