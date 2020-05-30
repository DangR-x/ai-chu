package com.aichu.service.api;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.service.dto.AcAdminActionLogDTO;
import com.aichu.service.dto.AcAdminActionLogListDTO;
import com.aichu.service.dto.AcAdminActionLogQueryDTO;

import java.util.List;

/**
 * @ClassName WzAdminActionLogService
 * @Author yuan.shuai
 * @Description 后台操作日志Service
 * @Date 2019/11/9
 * @Version 1.1.0
 */
public interface AcAdminActionLogService {

    /**
     * @Description 新增操作日志
     * @Param WzAdminActionLogDTO
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/11/9
     * @Version 1.1.0
     */
    Boolean addAdminActionLog(AcAdminActionLogDTO wzAdminActionLogDTO) throws Exception;

    /**
     * @Description 操作日志列表查询
     * @Param WzAdminActionLogQueryDTO
     * @Return java.util.List<WzAdminActionLogListDTO>
     * @Author yuan.shuai
     * @Date  2019/11/9
     * @Version 1.1.0
     */
    BaseResponse<List<AcAdminActionLogListDTO>> getAdminActionLogList(AcAdminActionLogQueryDTO queryDTO) throws Exception;
}
