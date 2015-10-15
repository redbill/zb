package com.bianlide.zb.cms.dao;

import com.bianlide.zb.cms.model.TJewContent;

public interface TJewContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TJewContent record);

    int insertSelective(TJewContent record);

    TJewContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TJewContent record);

    int updateByPrimaryKeyWithBLOBs(TJewContent record);

    int updateByPrimaryKey(TJewContent record);
}