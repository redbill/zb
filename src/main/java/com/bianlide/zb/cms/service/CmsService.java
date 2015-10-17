package com.bianlide.zb.cms.service;

import java.util.List;

import com.bianlide.zb.cms.model.TJewContent;

public interface CmsService {

	public List<TJewContent> getArticleList();
	
	public void saveOrUpdate(TJewContent content);
}
