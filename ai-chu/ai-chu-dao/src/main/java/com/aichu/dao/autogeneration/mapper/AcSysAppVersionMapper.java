package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysAppVersionDO;
import com.aichu.dao.autogeneration.object.AcSysAppVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysAppVersionMapper {
    long countByExample(AcSysAppVersionExample example);

    int deleteByExample(AcSysAppVersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysAppVersionDO record);

    int insertSelective(AcSysAppVersionDO record);

    List<AcSysAppVersionDO> selectByExampleWithRowbounds(AcSysAppVersionExample example, RowBounds rowBounds);

    List<AcSysAppVersionDO> selectByExample(AcSysAppVersionExample example);

    AcSysAppVersionDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysAppVersionDO record, @Param("example") AcSysAppVersionExample example);

    int updateByExample(@Param("record") AcSysAppVersionDO record, @Param("example") AcSysAppVersionExample example);

    int updateByPrimaryKeySelective(AcSysAppVersionDO record);

    int updateByPrimaryKey(AcSysAppVersionDO record);
}