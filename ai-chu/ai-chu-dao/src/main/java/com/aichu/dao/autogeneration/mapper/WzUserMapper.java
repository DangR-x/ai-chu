package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.WzUserDO;
import com.aichu.dao.autogeneration.object.WzUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/11/23
 */
public interface WzUserMapper {
    long countByExample(WzUserExample example);

    int deleteByExample(WzUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WzUserDO record);

    int insertSelective(WzUserDO record);

    List<WzUserDO> selectByExampleWithRowbounds(WzUserExample example, RowBounds rowBounds);

    List<WzUserDO> selectByExample(WzUserExample example);

    WzUserDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WzUserDO record, @Param("example") WzUserExample example);

    int updateByExample(@Param("record") WzUserDO record, @Param("example") WzUserExample example);

    int updateByPrimaryKeySelective(WzUserDO record);

    int updateByPrimaryKey(WzUserDO record);
}