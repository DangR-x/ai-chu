package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcAdminActionLogDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcAdminActionLogDaoMapper
 * @Author yuan.shuai
 * @Description
 * @Date 2019/11/9
 * @Version 1.1.0
 */
public interface AcAdminActionLogDaoMapper {

    /**
     * @Description 操作日志记录列表查询
     * @Param name,adminUserId
     * @Return List<AcAdminActionLogDao>
     * @Author yuan.shuai
     * @Date  2019/11/9
     * @Version 1.1.0
     */
    List<AcAdminActionLogDao> getAdminActionLogList(@Param("name") String name,
                                                    @Param("adminUserId") Integer adminUserId);
}
