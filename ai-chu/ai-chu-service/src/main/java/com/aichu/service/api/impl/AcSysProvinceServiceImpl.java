package com.aichu.service.api.impl;

import com.aichu.dao.autogeneration.mapper.AcSysAreaMapper;
import com.aichu.dao.autogeneration.mapper.AcSysCityMapper;
import com.aichu.dao.autogeneration.mapper.AcSysProvinceMapper;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.service.api.AcSysProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WzSysProvinceServiceImpl
 * @Description 省市区地理信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/23 11:40
 * @Version 1.0.0
 **/
@Service
public class AcSysProvinceServiceImpl implements AcSysProvinceService {

    private Logger logger = LoggerFactory.getLogger(AcSysProvinceServiceImpl.class);

    @Autowired
    private AcSysProvinceMapper acSysProvinceMapper;

    @Autowired
    private AcSysCityMapper acSysCityMapper;

    @Autowired
    private AcSysAreaMapper acSysAreaMapper;

    @Override
    public List<Map<String, Object>> geographyInfoMap() throws Exception {
        logger.info("-----------省市区地理信息列表-------Start");

        //信息参数组装List
        List<Map<String, Object>> provinceList = new ArrayList<>();

        //省份信息
        AcSysProvinceExample acSysProvinceExample = new AcSysProvinceExample();
        acSysProvinceExample.setOrderByClause("id");
        List<AcSysProvinceDO> acSysProvinceDOList = acSysProvinceMapper.selectByExample(acSysProvinceExample);

        //城市信息
        AcSysCityExample acSysCityExample = new AcSysCityExample();
        acSysCityExample.setOrderByClause("id");
        List<AcSysCityDO> acSysCityDOList = acSysCityMapper.selectByExample(acSysCityExample);

        //省份信息
        AcSysAreaExample acSysAreaExample = new AcSysAreaExample();
        acSysAreaExample.setOrderByClause("id");
        List<AcSysAreaDO> acSysAreaDOList = acSysAreaMapper.selectByExample(acSysAreaExample);

        //组装参数信息
        acSysProvinceDOList.stream().forEach( acSysProvinceDO -> {
            Map<String, Object> provinceMap = new HashMap<>();
            provinceMap.put("provinceId", acSysProvinceDO.getId());
            provinceMap.put("provinceName", acSysProvinceDO.getName());
            List<Map<String, Object>> cityList = new ArrayList<>();
            acSysCityDOList.stream().forEach(acSysCityDO -> {
                Map<String, Object> cityMap = new HashMap<>();
                if (acSysCityDO.getProvinceId().equals(acSysProvinceDO.getId())){
                    cityMap.put("cityId", acSysCityDO.getId());
                    cityMap.put("cityName", acSysCityDO.getName());
                    List<Map<String, Object>> areaList = new ArrayList<>();
                    acSysAreaDOList.stream().forEach(acSysAreaDO -> {
                        Map<String, Object> areaMap = new HashMap<>();
                        if (acSysAreaDO.getCityId().equals(acSysCityDO.getId())){
                            areaMap.put("areaId", acSysAreaDO.getId());
                            areaMap.put("areaName", acSysAreaDO.getName());
                            areaList.add(areaMap);
                        }
                    });
                    cityMap.put("childAreaList",areaList);
                    cityList.add(cityMap);
                }
            });
            provinceMap.put("childCityList", cityList);
            provinceList.add(provinceMap);
        });

        logger.info("-----------省市区地理信息列表-------End");
        return provinceList;
    }
}
