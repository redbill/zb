package com.bianlide.zb.cms.service;

import java.util.List;

import com.bianlide.zb.cms.model.TJewContent;

public interface CmsService {

    public List<TJewContent> getArticleList(TJewContent content);
    
    public void saveOrUpdate(TJewContent content);
    
    public TJewContent getContentById(int id);
    
    public void delContentById(int id);
    
    public void updateMenuData();
}
