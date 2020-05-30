package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcAdminUserDO;
import com.aichu.dao.autogeneration.object.AcAdminUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcAdminUserMapper {
    long countByExample(AcAdminUserExample example);

    int deleteByExample(AcAdminUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAdminUserDO record);

    int insertSelective(AcAdminUserDO record);

    List<AcAdminUserDO> selectByExampleWithRowbounds(AcAdminUserExample example, RowBounds rowBounds);

    List<AcAdminUserDO> selectByExample(AcAdminUserExample example);

    AcAdminUserDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAdminUserDO record, @Param("example") AcAdminUserExample example);

    int updateByExample(@Param("record") AcAdminUserDO record, @Param("example") AcAdminUserExample example);

    int updateByPrimaryKeySelective(AcAdminUserDO record);

    int updateByPrimaryKey(AcAdminUserDO record);
}