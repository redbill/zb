package com.bianlide.zb.price.dao;

import java.util.List;

import com.bianlide.zb.price.model.PriceData;
import com.bianlide.zb.price.model.PriceDataKey;

public interface PriceDataMapper
{
    int deleteByPrimaryKey(PriceDataKey key);

    int insert(PriceData record);

    int insertSelective(PriceData record);

    PriceData selectByPrimaryKey(PriceDataKey key);

    int updateByPrimaryKeySelective(PriceData record);

    int updateByPrimaryKey(PriceData record);

    /**
     * @Title: deleteOldPriceData
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @return
     * @throws
     */
    int deleteOldPriceData();

    /**
     * @Title: getPriceDatas
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @return
     * @throws
     */
    List<PriceData> getPriceDatas();
}