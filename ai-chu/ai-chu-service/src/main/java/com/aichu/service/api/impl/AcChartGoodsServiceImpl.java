package com.aichu.service.api.impl;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcChartGoodsMapper;
import com.aichu.dao.autogeneration.object.AcChartGoodsDO;
import com.aichu.dao.autogeneration.object.AcChartGoodsExample;
import com.aichu.dao.workstation.mapper.AcChartGoodsDaoMapper;
import com.aichu.dao.workstation.object.AcChartGoodsDao;
import com.aichu.dao.workstation.object.AcChartGoodsRecordsDao;
import com.aichu.dao.autogeneration.mapper.AcPreferentialCardMapper;
import com.aichu.dao.autogeneration.mapper.AcSysChargeConfigMapper;
import com.aichu.dao.autogeneration.object.*;
import com.aichu.manager.enums.ChartGoodsStatusEnum;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcChartGoodsService;
import com.aichu.service.dto.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.aichu.service.dto.ChargeConfigDTO;
import com.aichu.service.dto.PreferentialCardDTO;
import com.aichu.service.dto.UserChartGoodsListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AcChartGoodsServiceImpl
 * @Description 爱触商品信息ServiceImpl
 * @Author Melon
 * @Date 2019/9/18 19:09
 * @Version 1.0.0
 **/
@Service
public class AcChartGoodsServiceImpl implements AcChartGoodsService {

    private Logger logger = LoggerFactory.getLogger(AcChartGoodsServiceImpl.class);

    @Autowired
    private AcChartGoodsMapper acChartGoodsMapper;

    @Autowired
    private AcChartGoodsDaoMapper chartGoodsDaoMapper;

    @Autowired
    private AcPreferentialCardMapper acPreferentialCardMapper;

    @Autowired
    private AcSysChargeConfigMapper acSysChargeConfigMapper;

    @Override
    public List<UserChartGoodsListDTO> cloudChartGoodsList() throws Exception {
        logger.info("--------------聊天商品信息-----------Start-- ");

        List<UserChartGoodsListDTO> userChartGoodsListDTOList = new ArrayList<>();
        AcChartGoodsExample acChartGoodsExample = new AcChartGoodsExample();
        acChartGoodsExample.createCriteria()
                .andIsPutawayEqualTo(ChartGoodsStatusEnum.CHART_GOODS_STATUS_IS_PUTAWAY_TRUE.getCode())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcChartGoodsDO> acChartGoodsDOList = acChartGoodsMapper.selectByExample(acChartGoodsExample);
        acChartGoodsDOList.stream().forEach( acChartGoodsDO -> {
            UserChartGoodsListDTO userChartGoodsListDTO = new UserChartGoodsListDTO();
            userChartGoodsListDTO.setGoodsId(acChartGoodsDO.getId());
            userChartGoodsListDTO.setGoodsName(acChartGoodsDO.getGoodsName());
            userChartGoodsListDTO.setGoodsImage(acChartGoodsDO.getGoodsImage());
            userChartGoodsListDTO.setGoodsMoney(acChartGoodsDO.getGoodsMoney());
            userChartGoodsListDTO.setFunctionDes(acChartGoodsDO.getFunctionDes());
            userChartGoodsListDTOList.add(userChartGoodsListDTO);
        });

        logger.info("--------------聊天商品信息----------End");
        return userChartGoodsListDTOList;
    }

    @Override
    public BaseResponse<List<AcChartGoodsDTO>> getChartGoodsListBack(AcChartGoodsQuqeryDTO queryDTO) throws Exception {
        logger.info("--------------后台商品信息列表查询-----------Start-- ");
        Page<AcChartGoodsDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcChartGoodsDao> list = chartGoodsDaoMapper.getChartGoodsList(queryDTO.getName(),queryDTO.getIsPutaway());
        logger.info("--------------后台商品信息列表查询-----------End-- ");
        return BaseResponse.create(pages.getTotal(), BeanUtil.copy(list,AcChartGoodsDTO.class));
    }

    @Override
    public Boolean addOrUpdateChartGoodsBack(AcChartGoodsDTO updateDto) throws Exception {
        logger.info("--------------后台商品信息新增修改-----------Start-- ");
        if (Utils.isEmpty(updateDto)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcChartGoodsDO goodsDO = new AcChartGoodsDO();
        goodsDO.setGoodsName(updateDto.getGoodsName());
        goodsDO.setGoodsMoney(updateDto.getGoodsMoney());
        goodsDO.setGoodsImage(updateDto.getGoodsImage());
        goodsDO.setFunctionDes(updateDto.getFunctionDes());
        goodsDO.setIsPutaway(updateDto.getIsPutaway());
        if (Utils.isEmpty(updateDto.getId())){ // 新增
            goodsDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            goodsDO.setCreateTime(new Date());
            Integer result = acChartGoodsMapper.insertSelective(goodsDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        } else { // 修改
            goodsDO.setId(updateDto.getId());
            Integer result = acChartGoodsMapper.updateByPrimaryKeySelective(goodsDO);
            if (result == 0){
                throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("--------------后台商品信息新增修改-----------End-- ");
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteChartGoodsBack(Integer id) throws Exception {
        logger.info("--------------后台商品信息删除-----------Start-- ");
        if (Utils.isEmpty(id)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcChartGoodsDO goodsDO = acChartGoodsMapper.selectByPrimaryKey(id);
        if (Utils.isEmpty(goodsDO)){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        goodsDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acChartGoodsMapper.updateByPrimaryKeySelective(goodsDO);
        if (result == 0){
            throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台商品信息删除-----------End-- ");
        return Boolean.TRUE;
    }

    @Override
    public BaseResponse<List<AcChartGoodsRecordsDTO>> getChartGoodsRecordList(AcQueryOnlyNameDTO queryDTO) throws Exception {
        logger.info("--------------后台商品销售记录列表查询-----------Start-- ");
        Page<AcChartGoodsRecordsDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcChartGoodsRecordsDao> list = chartGoodsDaoMapper.getChartGoodsRecordList(queryDTO.getName());
        logger.info("--------------后台商品销售记录列表查询-----------End-- ");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AcChartGoodsRecordsDTO.class));
    }

    @Override
    public Boolean putawayGoodsBack(AcUtilIdAndStatusDTO updateDTO) throws Exception {
        logger.info("--------------后台商品上架下架-----------Start-- ");
        if (Utils.isEmpty(updateDTO)){
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(), ResultCodeEnum.PARAM_ERROR.message());
        }
        AcChartGoodsDO chartGoodsDO = acChartGoodsMapper.selectByPrimaryKey(updateDTO.getId());
        if (Utils.isEmpty(chartGoodsDO)){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        chartGoodsDO.setIsPutaway(updateDTO.getStatus());
        Integer result = acChartGoodsMapper.updateByPrimaryKeySelective(chartGoodsDO);
        if (result == 0){
            throw  new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("--------------后台商品上架下架-----------End-- ");
        return Boolean.TRUE;
    }

    @Override
    public List<PreferentialCardDTO> preferentialCard() throws Exception {
        logger.info("--------------优惠卡信息-----------Start-- ");

        List<PreferentialCardDTO> preferentialCardDTOList = new ArrayList<>();
        AcPreferentialCardExample acPreferentialCardExample = new AcPreferentialCardExample();
        acPreferentialCardExample.createCriteria()
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcPreferentialCardDO> acPreferentialCardDOList = acPreferentialCardMapper.selectByExample(acPreferentialCardExample);
        acPreferentialCardDOList.stream().forEach( acPreferentialCardDO -> {
            PreferentialCardDTO preferentialCardDTO = new PreferentialCardDTO();
            preferentialCardDTO.setCardId(acPreferentialCardDO.getId());
            preferentialCardDTO.setCardName(acPreferentialCardDO.getCardName());
            preferentialCardDTO.setCardOriginalPrice(acPreferentialCardDO.getCardOriginalPrice());
            preferentialCardDTO.setCardSalePrice(acPreferentialCardDO.getCardSalePrice());
            preferentialCardDTO.setCardDetail(acPreferentialCardDO.getCardDetail());
            preferentialCardDTO.setEveryDayFreeCoin(acPreferentialCardDO.getEveryDayFreeCoin());
            preferentialCardDTO.setTotalFreeCoin(acPreferentialCardDO.getTotalFreeCoin());
            preferentialCardDTO.setSignTime(acPreferentialCardDO.getSignTime());
            preferentialCardDTO.setCardType(acPreferentialCardDO.getCardType());
            preferentialCardDTO.setCardSaleNum(acPreferentialCardDO.getCardSaleNum());
            preferentialCardDTO.setCardTotalNum(acPreferentialCardDO.getCardtTotalNum());
            preferentialCardDTOList.add(preferentialCardDTO);
        });

        logger.info("--------------优惠卡信息----------End");
        return preferentialCardDTOList;
    }

    @Override
    public List<ChargeConfigDTO> chargeConfig() throws Exception {
        logger.info("--------------优惠卡信息-----------Start-- ");

        List<ChargeConfigDTO> chargeConfigDTOList = new ArrayList<>();
        AcSysChargeConfigExample acSysChargeConfigExample = new AcSysChargeConfigExample();
        acSysChargeConfigExample.createCriteria()
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcSysChargeConfigDO> acSysChargeConfigDOList = acSysChargeConfigMapper.selectByExample(acSysChargeConfigExample);
        acSysChargeConfigDOList.stream().forEach( acSysChargeConfigDO -> {
            ChargeConfigDTO chargeConfigDTO = new ChargeConfigDTO();
            chargeConfigDTO.setChargeId(acSysChargeConfigDO.getId());
            chargeConfigDTO.setChargeAmount(acSysChargeConfigDO.getChargeAmount());
            chargeConfigDTO.setChargeCoin(acSysChargeConfigDO.getChargeCoin());
            chargeConfigDTOList.add(chargeConfigDTO);
        });

        logger.info("--------------优惠卡信息----------End");
        return chargeConfigDTOList;
    }
}
