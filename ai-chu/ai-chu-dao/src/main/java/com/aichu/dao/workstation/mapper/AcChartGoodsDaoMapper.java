package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcChartGoodsDao;
import com.aichu.dao.workstation.object.AcChartGoodsRecordsDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 10:29
 **/
public interface AcChartGoodsDaoMapper {

    /**
     * @Description 后台商品列表查询
     * @Author yuan.shuai
     * @Date 2020/2/17 10:30
     * @Param name，isPutaway
     * @Return List<AcChartGoodsDao>
     * @Version 1.0.0
     **/
    List<AcChartGoodsDao> getChartGoodsList(@Param("name") String name,
                                            @Param("isPutaway") Integer isPutaway);

    /**
     * @Description 后台商品购买记录查询
     * @Author yuan.shuai
     * @Date 2020/2/17 11:38
     * @Param name
     * @Return List<AcChartGoodsRecordsDao>
     * @Version 1.0.0
     **/
    List<AcChartGoodsRecordsDao> getChartGoodsRecordList(@Param("name") String name);
}
