package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcUserPhoneRecordDO;
import com.aichu.dao.autogeneration.object.AcUserPhoneRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcUserPhoneRecordMapper {
    long countByExample(AcUserPhoneRecordExample example);

    int deleteByExample(AcUserPhoneRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcUserPhoneRecordDO record);

    int insertSelective(AcUserPhoneRecordDO record);

    List<AcUserPhoneRecordDO> selectByExampleWithRowbounds(AcUserPhoneRecordExample example, RowBounds rowBounds);

    List<AcUserPhoneRecordDO> selectByExample(AcUserPhoneRecordExample example);

    AcUserPhoneRecordDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcUserPhoneRecordDO record, @Param("example") AcUserPhoneRecordExample example);

    int updateByExample(@Param("record") AcUserPhoneRecordDO record, @Param("example") AcUserPhoneRecordExample example);

    int updateByPrimaryKeySelective(AcUserPhoneRecordDO record);

    int updateByPrimaryKey(AcUserPhoneRecordDO record);
}