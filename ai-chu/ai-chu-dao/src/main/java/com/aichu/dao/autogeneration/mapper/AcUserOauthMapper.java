package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserOauthDO;
import com.aichu.dao.autogeneration.object.AcUserOauthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserOauthMapper {
    long countByExample(AcUserOauthExample example);

    int deleteByExample(AcUserOauthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserOauthDO record);

    int insertSelective(AcUserOauthDO record);

    List<AcUserOauthDO> selectByExampleWithRowbounds(AcUserOauthExample example, RowBounds rowBounds);

    List<AcUserOauthDO> selectByExample(AcUserOauthExample example);

    AcUserOauthDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserOauthDO record, @Param("example") AcUserOauthExample example);

    int updateByExample(@Param("record") AcUserOauthDO record, @Param("example") AcUserOauthExample example);

    int updateByPrimaryKeySelective(AcUserOauthDO record);

    int updateByPrimaryKey(AcUserOauthDO record);
}