package com.aichu.service.api.impl;

import com.aichu.common.util.common.BeanUtil;
import com.aichu.dao.workstation.mapper.AcAdminModuleDaoMapper;
import com.aichu.dao.workstation.object.MenuCascadeListDao;
import com.aichu.service.api.MenuService;
import com.aichu.service.dto.MenuListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Author yuan.shuai
 * @Description
 * @Date 2019/8/1
 * @Version 1.0.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private AcAdminModuleDaoMapper acAdminModuleDaoMapper;

    @Override
    public List<MenuListDTO> getMenuCascadeList() throws Exception {
        logger.info("--------------查询级联菜单-----------Start");
        List<MenuCascadeListDao> list = acAdminModuleDaoMapper.getMenuCascadeList();
        logger.info("--------------查询级联菜单-----------End");
        return BeanUtil.copy(list,MenuListDTO.class);
    }
}
