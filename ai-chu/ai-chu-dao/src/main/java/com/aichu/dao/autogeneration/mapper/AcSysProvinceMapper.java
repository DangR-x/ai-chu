package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysProvinceDO;
import com.aichu.dao.autogeneration.object.AcSysProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysProvinceMapper {
    long countByExample(AcSysProvinceExample example);

    int deleteByExample(AcSysProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysProvinceDO record);

    int insertSelective(AcSysProvinceDO record);

    List<AcSysProvinceDO> selectByExampleWithRowbounds(AcSysProvinceExample example, RowBounds rowBounds);

    List<AcSysProvinceDO> selectByExample(AcSysProvinceExample example);

    AcSysProvinceDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysProvinceDO record, @Param("example") AcSysProvinceExample example);

    int updateByExample(@Param("record") AcSysProvinceDO record, @Param("example") AcSysProvinceExample example);

    int updateByPrimaryKeySelective(AcSysProvinceDO record);

    int updateByPrimaryKey(AcSysProvinceDO record);
}