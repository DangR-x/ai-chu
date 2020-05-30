package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysAgentConfigDO;
import com.aichu.dao.autogeneration.object.AcSysAgentConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysAgentConfigMapper {
    long countByExample(AcSysAgentConfigExample example);

    int deleteByExample(AcSysAgentConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysAgentConfigDO record);

    int insertSelective(AcSysAgentConfigDO record);

    List<AcSysAgentConfigDO> selectByExampleWithRowbounds(AcSysAgentConfigExample example, RowBounds rowBounds);

    List<AcSysAgentConfigDO> selectByExample(AcSysAgentConfigExample example);

    AcSysAgentConfigDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysAgentConfigDO record, @Param("example") AcSysAgentConfigExample example);

    int updateByExample(@Param("record") AcSysAgentConfigDO record, @Param("example") AcSysAgentConfigExample example);

    int updateByPrimaryKeySelective(AcSysAgentConfigDO record);

    int updateByPrimaryKey(AcSysAgentConfigDO record);
}