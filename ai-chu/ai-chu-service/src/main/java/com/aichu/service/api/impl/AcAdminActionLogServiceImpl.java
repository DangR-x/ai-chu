package com.aichu.service.api.impl;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcAdminActionLogMapper;
import com.aichu.dao.autogeneration.object.AcAdminActionLogDO;
import com.aichu.dao.workstation.mapper.AcAdminActionLogDaoMapper;
import com.aichu.dao.workstation.object.AcAdminActionLogDao;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcAdminActionLogService;
import com.aichu.service.dto.AcAdminActionLogDTO;
import com.aichu.service.dto.AcAdminActionLogListDTO;
import com.aichu.service.dto.AcAdminActionLogQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName YjzhAdminActionLogServiceImpl
 * @Author yuan.shuai
 * @Description
 * @Date 2019/11/9
 * @Version 1.1.0
 */
@Service
public class AcAdminActionLogServiceImpl implements AcAdminActionLogService {

    private Logger logger = LoggerFactory.getLogger(AcAdminActionLogServiceImpl.class);

    @Autowired
    private AcAdminActionLogDaoMapper acAdminActionLogDaoMapper;

    @Autowired
    private AcAdminActionLogMapper acAdminActionLogMapper;

    @Override
    public Boolean addAdminActionLog(AcAdminActionLogDTO acAdminActionLogDTO) throws Exception {
        logger.info("--------------新增后台操作日志记录-----------Start");
        if (Objects.isNull(acAdminActionLogDTO)){
            logger.info("新增操作日志记录数据为空，系统异常");
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(),ResultCodeEnum.PARAM_ERROR.message());
        }
        AcAdminActionLogDO adminActionLogDO = new AcAdminActionLogDO();
        adminActionLogDO.setActionIp(acAdminActionLogDTO.getActionIp());
        adminActionLogDO.setActionLog(acAdminActionLogDTO.getActionLog());
        adminActionLogDO.setActionModel(acAdminActionLogDTO.getActionModel());
        adminActionLogDO.setAdminUserId(acAdminActionLogDTO.getAdminUserId());
        adminActionLogDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        adminActionLogDO.setCreateTime(new Date());
        Integer reulst = acAdminActionLogMapper.insertSelective(adminActionLogDO);
        if (reulst == 0){
            logger.info("新增操作日志记录失败，系统异常");
            throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(),ResultCodeEnum.ADD_DATA_ERROR.message());
        }
        logger.info("--------------新增后台操作日志记录-----------End");
        return true;
    }

    @Override
    public BaseResponse<List<AcAdminActionLogListDTO>> getAdminActionLogList(AcAdminActionLogQueryDTO queryDTO) throws Exception {
        logger.info("--------------后台操作日志记录列表查询-----------Start");
        Page<AcAdminActionLogDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcAdminActionLogDao> list = acAdminActionLogDaoMapper.getAdminActionLogList(queryDTO.getName(),queryDTO.getAdminUserId());
        logger.info("--------------后台操作日志记录列表查询-----------End");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(list,AcAdminActionLogListDTO.class));
    }
}
