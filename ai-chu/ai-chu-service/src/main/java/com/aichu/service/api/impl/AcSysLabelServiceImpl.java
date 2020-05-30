package com.aichu.service.api.impl;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcSysLabelMapper;
import com.aichu.dao.autogeneration.object.AcSysLabelDO;
import com.aichu.dao.autogeneration.object.AcSysLabelExample;
import com.aichu.dao.workstation.mapper.AcSysLabelDaoMapper;
import com.aichu.dao.workstation.object.AcLabelQueryDao;
import com.aichu.dao.workstation.object.AcSysLabelDao;
import com.aichu.dao.workstation.object.AcSysLabelSelectDao;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcSysLabelService;
import com.aichu.service.dto.AcLabelQeuryDTO;
import com.aichu.service.dto.AcSysLabelDTO;
import com.aichu.service.dto.AcSysLabelSelectDTO;
import com.aichu.service.dto.LabelDictDTO;
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
 * @ClassName AcSysBannerServiceImpl
 * @Description 系统表情信息ServiceImpl
 * @Author Melon
 * @Date 2019/7/23 11:40
 * @Version 1.0.0
 **/
@Service
public class AcSysLabelServiceImpl implements AcSysLabelService {

    private Logger logger = LoggerFactory.getLogger(AcSysLabelServiceImpl.class);

    @Autowired
    private AcSysLabelMapper acSysLabelMapper;

    @Autowired
    private AcSysLabelDaoMapper acSysLabelDaoMapper;

    @Override
    public List<LabelDictDTO> labelDictList(Integer labelType) throws Exception {
        logger.info("-----------标签字典信息列表-------Start：labelType：--{}", labelType);

        List<LabelDictDTO> labelDictDTOList = new ArrayList<>();

        AcSysLabelExample acSysLabelExample = new AcSysLabelExample();
        acSysLabelExample.createCriteria()
                .andTypeEqualTo(labelType)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcSysLabelDO> acSysLabelDOList = acSysLabelMapper.selectByExample(acSysLabelExample);
        if (!Utils.isEmpty(acSysLabelDOList)){
            acSysLabelDOList.stream().forEach( acSysLabelDO -> {
                LabelDictDTO labelDictDTO = new LabelDictDTO();
                labelDictDTO.setLabelId(acSysLabelDO.getId());
                labelDictDTO.setLabelName(acSysLabelDO.getName());
                labelDictDTO.setLabelCode(acSysLabelDO.getCode());
                labelDictDTO.setLabelType(acSysLabelDO.getType());
                labelDictDTOList.add(labelDictDTO);
            });
        }

        logger.info("-----------标签字典信息列表-------End");
        return labelDictDTOList;
    }

    @Override
    public List<AcSysLabelSelectDTO> getLabelSelectList() throws Exception {
        logger.info("-----------后台活动标签库（下拉框）------Start");
        List<AcSysLabelSelectDao> list = acSysLabelDaoMapper.getLabelSelectList();
        logger.info("-----------后台活动标签库（下拉框）------End");
        return BeanUtil.copy(list, AcSysLabelSelectDTO.class);
    }

    @Override
    public BaseResponse<List<AcSysLabelDTO>> getLableBackList(AcLabelQeuryDTO qeuryDTO) throws Exception {
        logger.info("-----------后台活动标签库列表------Start");
        Page<AcSysLabelDao> pages = PageHelper.startPage(qeuryDTO.getPageNum(), qeuryDTO.getPageSize());
        List<AcSysLabelDao> list = acSysLabelDaoMapper.getLabelBackList(BeanUtil.copy(qeuryDTO, AcLabelQueryDao.class));
        logger.info("-----------后台活动标签库列表------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(list, AcSysLabelDTO.class));
    }

    @Override
    @Transactional
    public Boolean deleteLabel(Integer id) throws Exception {
        logger.info("-----------后台活动标签库删除------Start");
        if (Objects.isNull(id)) {
            logger.info("后台活动标签库删除ID为空，系统异常");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcSysLabelDO acSysLabelDO = new AcSysLabelDO();
        acSysLabelDO.setId(id);
        acSysLabelDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acSysLabelMapper.updateByPrimaryKeySelective(acSysLabelDO);
        if (result == 0) {
            logger.info("后台活动标签库删除失败，系统异常");
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("-----------后台活动标签库删除------End");
        return true;
    }

    @Override
    @Transactional
    public Boolean updateOrAddLabelDetail(AcSysLabelDTO acSysLabelDTO) throws Exception {
        logger.info("-----------后台活动标签库修改详情------Start");
        if (Objects.isNull(acSysLabelDTO)) {
            logger.info("后台活动标签库信息为空，系统异常");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcSysLabelDO acSysLabelDO = new AcSysLabelDO();
        acSysLabelDO.setCode(acSysLabelDTO.getCode());
        acSysLabelDO.setActionDesc(acSysLabelDTO.getActionDesc());
        acSysLabelDO.setName(acSysLabelDTO.getName());
        acSysLabelDO.setType(acSysLabelDTO.getType());
        acSysLabelDO.setActionDetailDesc(acSysLabelDTO.getActionDetailDesc());
        if (Objects.isNull(acSysLabelDTO.getId())) {
            acSysLabelDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            acSysLabelDO.setCreateTime(new Date());
            Integer result = acSysLabelMapper.insertSelective(acSysLabelDO);
            if (result == 0) {
                logger.info("后台活动标签库新增失败，系统异常");
                throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else {
            acSysLabelDO.setId(acSysLabelDTO.getId());
            Integer result = acSysLabelMapper.updateByPrimaryKeySelective(acSysLabelDO);
            if (result == 0) {
                logger.info("后台活动标签库修改失败，系统异常");
                throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("-----------后台活动标签库修改详情------End");
        return true;
    }
}
