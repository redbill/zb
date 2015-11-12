package com.bianlide.zb.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bianlide.zb.cms.dao.TJewContentMapper;
import com.bianlide.zb.cms.model.TJewContent;
import com.bianlide.zb.cms.service.CmsService;

@Service("cmsService")
public class CmsServiceImpl implements CmsService
{

    @Resource
    private TJewContentMapper jewContentMapper;

    public List<TJewContent> getArticleList(TJewContent content)
    {
        return this.jewContentMapper.getAticleList(content);
    }

    public void saveOrUpdate(TJewContent content)
    {
        // TODO Auto-generated method stub
        if (content.getId() != null)
        {// 编辑
            jewContentMapper.updateByPrimaryKeySelective(content);
        }
        else
        {// 新增
            jewContentMapper.insertSelective(content);
        }

        this.updateMenuData();
    }

    public TJewContent getContentById(int id)
    {
        return jewContentMapper.selectByPrimaryKey(id);
    }

    public void delContentById(int id)
    {
        jewContentMapper.deleteByPrimaryKey(id);
    }

    /*
     * (非 Javadoc) <p>Title: updateMenuData</p> <p>Description: </p>
     * 
     * @see com.bianlide.zb.cms.service.CmsService#updateMenuData()
     */
    @Override
    public void updateMenuData()
    {

        WebApplicationContext webApplicationContext = ContextLoader
                .getCurrentWebApplicationContext();
        ServletContext sc = webApplicationContext.getServletContext();
        // TODO Auto-generated method stub
        TJewContent brand = new TJewContent();
        brand.setCodeModule("1000");
        List<TJewContent> brandList = this.getArticleList(brand);
        sc.setAttribute("brandList", brandList);

        TJewContent activity = new TJewContent();
        activity.setCodeModule("1002");
        List<TJewContent> activityList = this.getArticleList(activity);
        sc.setAttribute("activityList", activityList);

        TJewContent service = new TJewContent();
        service.setCodeModule("1003");
        List<TJewContent> serviceList = this.getArticleList(service);
        sc.setAttribute("serviceList", serviceList);

        TJewContent product = new TJewContent();
        product.setCodeModule("1001");
        List<TJewContent> productList = this.getArticleList(product);
        sc.setAttribute("productList", productList);
    }

}
