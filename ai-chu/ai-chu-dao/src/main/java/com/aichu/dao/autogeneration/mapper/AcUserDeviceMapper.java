package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserDeviceDO;
import com.aichu.dao.autogeneration.object.AcUserDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserDeviceMapper {
    long countByExample(AcUserDeviceExample example);

    int deleteByExample(AcUserDeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserDeviceDO record);

    int insertSelective(AcUserDeviceDO record);

    List<AcUserDeviceDO> selectByExampleWithRowbounds(AcUserDeviceExample example, RowBounds rowBounds);

    List<AcUserDeviceDO> selectByExample(AcUserDeviceExample example);

    AcUserDeviceDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserDeviceDO record, @Param("example") AcUserDeviceExample example);

    int updateByExample(@Param("record") AcUserDeviceDO record, @Param("example") AcUserDeviceExample example);

    int updateByPrimaryKeySelective(AcUserDeviceDO record);

    int updateByPrimaryKey(AcUserDeviceDO record);
}