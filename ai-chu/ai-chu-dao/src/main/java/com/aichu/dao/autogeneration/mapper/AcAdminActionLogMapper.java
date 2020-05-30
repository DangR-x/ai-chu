package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcAdminActionLogDO;
import com.aichu.dao.autogeneration.object.AcAdminActionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcAdminActionLogMapper {
    long countByExample(AcAdminActionLogExample example);

    int deleteByExample(AcAdminActionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAdminActionLogDO record);

    int insertSelective(AcAdminActionLogDO record);

    List<AcAdminActionLogDO> selectByExampleWithRowbounds(AcAdminActionLogExample example, RowBounds rowBounds);

    List<AcAdminActionLogDO> selectByExample(AcAdminActionLogExample example);

    AcAdminActionLogDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAdminActionLogDO record, @Param("example") AcAdminActionLogExample example);

    int updateByExample(@Param("record") AcAdminActionLogDO record, @Param("example") AcAdminActionLogExample example);

    int updateByPrimaryKeySelective(AcAdminActionLogDO record);

    int updateByPrimaryKey(AcAdminActionLogDO record);
}