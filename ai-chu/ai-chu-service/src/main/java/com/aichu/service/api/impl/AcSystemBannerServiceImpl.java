package com.aichu.service.api.impl;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcSysBannerMapper;
import com.aichu.dao.autogeneration.object.AcSysBannerDO;
import com.aichu.dao.autogeneration.object.AcSysBannerExample;
import com.aichu.dao.workstation.mapper.AcSysBannerDaoMapper;
import com.aichu.dao.workstation.object.AcSysBannerBackDao;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.SysBannerTypeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcSystemBannerService;
import com.aichu.service.dto.AcSysBannerBackDTO;
import com.aichu.service.dto.AcSysBannerBackQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName AcSystemBannerServiceImpl
 * @Description 用户信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/20 14:45
 * @Version 1.0.0
 **/
@Service
public class AcSystemBannerServiceImpl implements AcSystemBannerService {

    private Logger logger = LoggerFactory.getLogger(AcSystemBannerServiceImpl.class);

    @Autowired
    private AcSysBannerMapper acSysBannerMapper;

    @Autowired
    private AcSysBannerDaoMapper acSysBannerDaoMapper;

    @Override
    public List<String> systemBanner() throws Exception {
        logger.info("-----------系统信息Banner信息列表------Start");

        List<String> fileUrlList = new ArrayList<>();

        //获取系统信息Banner信息列表
        AcSysBannerExample acSysBannerExample = new AcSysBannerExample();
        acSysBannerExample.createCriteria()
                .andBannerTypeEqualTo(SysBannerTypeEnum.SYS_BANNER_TYPE_MAIN_FACE.getCode())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcSysBannerDO> nlSysBannerDOList = acSysBannerMapper.selectByExample(acSysBannerExample);
        if (!Utils.isEmpty(nlSysBannerDOList)){
            nlSysBannerDOList.stream().forEach( nlSysBannerDO -> {
                fileUrlList.add(nlSysBannerDO.getBannerUrl());
            });
        }

        logger.info("-----------系统信息Banner信息列表------End");
        return fileUrlList;
    }

    @Override
    public BaseResponse<List<AcSysBannerBackDTO>> getBannerBackList(AcSysBannerBackQueryDTO backQueryDTO) throws Exception {
        logger.info("-----------后台系统Banner管理列表查询-------Start");
        Page<AcSysBannerBackDao> pages = PageHelper.startPage(backQueryDTO.getPageNum(),backQueryDTO.getPageSize());
        List<AcSysBannerBackDao> list = acSysBannerDaoMapper.getBannerBackList(backQueryDTO.getName(),backQueryDTO.getType());
        logger.info("-----------后台系统Banner管理列表查询-------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(list,AcSysBannerBackDTO.class));
    }

    @Override
    @Transactional
    public Boolean addOrUpdateBannerBack(AcSysBannerBackDTO bannerBackDTO) throws Exception {
        logger.info("-----------后台系统Banner管理新增/修改-------Start");
        if (Objects.isNull(bannerBackDTO)){
            logger.info("后台系统Banner管理新增/修改信息为空，系统异常");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(),ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcSysBannerDO acSysBannerDO = new AcSysBannerDO();
        acSysBannerDO.setBannerUrl(bannerBackDTO.getBannerUrl());
        acSysBannerDO.setBannerType(bannerBackDTO.getBannerType());
        acSysBannerDO.setBannerTypeCode(bannerBackDTO.getBannerTypeCode());
        acSysBannerDO.setBannerDesc(bannerBackDTO.getBannerDesc());
        if (Objects.isNull(bannerBackDTO.getId())){ // 新增
            acSysBannerDO.setCreateTime(new Date());
            acSysBannerDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            Integer result = acSysBannerMapper.insertSelective(acSysBannerDO);
            if ( result == 0 ){
                logger.info("后台系统Banner管理新增失败，系统异常");
                throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(),ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else { // 修改
            acSysBannerDO.setId(bannerBackDTO.getId());
            Integer result = acSysBannerMapper.updateByPrimaryKeySelective(acSysBannerDO);
            if ( result == 0 ){
                logger.info("后台系统Banner管理修改失败，系统异常");
                throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("-----------后台系统Banner管理新增/修改-------End");
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteBannerBack(Integer id) throws Exception {
        logger.info("-----------后台系统Banner管理删除-------Start");
        if (Objects.isNull(id)){
            logger.info("后台系统Banner管理删除信息ID为空，系统异常");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(),ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcSysBannerDO acSysBannerDO = new AcSysBannerDO();
        acSysBannerDO.setId(id);
        acSysBannerDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acSysBannerMapper.updateByPrimaryKeySelective(acSysBannerDO);
        if ( result == 0 ){
            logger.info("后台系统Banner管理删除失败，系统异常");
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(),ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("-----------后台系统Banner管理删除-------End");
        return true;
    }
}
