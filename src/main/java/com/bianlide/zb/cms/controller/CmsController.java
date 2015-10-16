package com.bianlide.zb.cms.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bianlide.zb.cms.model.TJewContent;
import com.bianlide.zb.cms.service.CmsService;
import com.bianlide.zb.common.controller.LoginController;
import com.bianlide.zb.common.vo.JsonResultVO;


@RestController  
public class CmsController {
	
	private CmsService cmsService;

    private static Logger logger = LoggerFactory
            .getLogger(LoginController.class);
    
    
	
	public CmsService getCmsService() {
		return cmsService;
	}



	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}



	/**
     * 获取内容列表.
     * 
     * @Title: getArticleList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author Sophie
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @throws
     */
	 @RequestMapping(
	 { "getArticleList" })
    public ModelAndView getArticleList(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

		response.setContentType("application/json;charset=utf-8");
        String msg = "";
        String isOK = "true";
        PrintWriter pw = response.getWriter();
        JsonResultVO jsonRes = new JsonResultVO();
//        String title = request.getParameter("title");//标题（模糊匹配）
//        String codeModule = request.getParameter("codeModule");//模块
//        if(codeModule==null || "".equals(codeModule)){
//        	codeModule="1000";
//        }
        try
        {
        	List<TJewContent> articleList=cmsService.getArticleList();
        	
        	jsonRes.setJsonData(articleList);
        }
        catch (Exception e)
        {
        	isOK="false";
        	msg="获取文章列表异常";
            logger.error(
                    "CmsController.getArticleList error", e);
            e.printStackTrace();
        }
        jsonRes.setIsOK(isOK);
        jsonRes.setMsg(msg);
        pw.write(JSON.toJSONString(jsonRes));
        return null;
    }
}


