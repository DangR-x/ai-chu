package com.aichu.dao.autogeneration.mapper;

import com.aichu.dao.autogeneration.object.AcSysFeedbackDO;
import com.aichu.dao.autogeneration.object.AcSysFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public interface AcSysFeedbackMapper {
    long countByExample(AcSysFeedbackExample example);

    int deleteByExample(AcSysFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcSysFeedbackDO record);

    int insertSelective(AcSysFeedbackDO record);

    List<AcSysFeedbackDO> selectByExampleWithRowbounds(AcSysFeedbackExample example, RowBounds rowBounds);

    List<AcSysFeedbackDO> selectByExample(AcSysFeedbackExample example);

    AcSysFeedbackDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcSysFeedbackDO record, @Param("example") AcSysFeedbackExample example);

    int updateByExample(@Param("record") AcSysFeedbackDO record, @Param("example") AcSysFeedbackExample example);

    int updateByPrimaryKeySelective(AcSysFeedbackDO record);

    int updateByPrimaryKey(AcSysFeedbackDO record);
}