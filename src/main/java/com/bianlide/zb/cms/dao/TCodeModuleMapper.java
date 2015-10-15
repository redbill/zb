package com.bianlide.zb.cms.dao;

import com.bianlide.zb.cms.model.TCodeModule;

public interface TCodeModuleMapper {
    int insert(TCodeModule record);

    int insertSelective(TCodeModule record);
}