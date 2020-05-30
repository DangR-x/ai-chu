package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysMessageDO;
import com.aichu.dao.autogeneration.object.AcSysMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysMessageMapper {
    long countByExample(AcSysMessageExample example);

    int deleteByExample(AcSysMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysMessageDO record);

    int insertSelective(AcSysMessageDO record);

    List<AcSysMessageDO> selectByExampleWithBLOBsWithRowbounds(AcSysMessageExample example, RowBounds rowBounds);

    List<AcSysMessageDO> selectByExampleWithBLOBs(AcSysMessageExample example);

    List<AcSysMessageDO> selectByExampleWithRowbounds(AcSysMessageExample example, RowBounds rowBounds);

    List<AcSysMessageDO> selectByExample(AcSysMessageExample example);

    AcSysMessageDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysMessageDO record, @Param("example") AcSysMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") AcSysMessageDO record, @Param("example") AcSysMessageExample example);

    int updateByExample(@Param("record") AcSysMessageDO record, @Param("example") AcSysMessageExample example);

    int updateByPrimaryKeySelective(AcSysMessageDO record);

    int updateByPrimaryKeyWithBLOBs(AcSysMessageDO record);

    int updateByPrimaryKey(AcSysMessageDO record);
}