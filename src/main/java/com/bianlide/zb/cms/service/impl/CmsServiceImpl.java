package com.bianlide.zb.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bianlide.zb.cms.dao.TJewContentMapper;
import com.bianlide.zb.cms.model.TJewContent;
import com.bianlide.zb.cms.service.CmsService;

@Service("cmsService")
public class CmsServiceImpl implements CmsService{

	@Resource
    private TJewContentMapper jewContentMapper;
	
	public List<TJewContent> getArticleList() {
		return this.jewContentMapper.getAticleList();
	}

}
