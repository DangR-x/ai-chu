package com.aichu.service.api;


import com.aichu.service.dto.AcUtilIdAndNameDTO;

import java.util.List;

/**
 * @ClassName AcUtilService
 * @Author yuan.shuai
 * @Description 业务工具类Service
 * @Date 2019/12/16
 * @Version 1.0.0
 */
public interface AcUtilService {

    /**
     * @Description 省列表数据查询
     * @Author yuan.shuai
     * @Date 2019/12/16 18:38
     * @Return java.util.List<AcUtilIdAndNameDTO>
     * @Version 1.0.0
     **/
    List<AcUtilIdAndNameDTO> getProvinceList() throws Exception;

}
