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
	
	public List<TJewContent> getArticleList(TJewContent content) {
		return this.jewContentMapper.getAticleList(content);
	}

	public void saveOrUpdate(TJewContent content) {
		// TODO Auto-generated method stub
		if(content.getId()!=null){//编辑
			jewContentMapper.updateByPrimaryKeySelective(content);
		}else{//新增
			jewContentMapper.insertSelective(content);
		}
	}

	public TJewContent getContentById(int id) {
		return jewContentMapper.selectByPrimaryKey(id);
	}

	public void delContentById(int id) {
		jewContentMapper.deleteByPrimaryKey(id);
	}

}
