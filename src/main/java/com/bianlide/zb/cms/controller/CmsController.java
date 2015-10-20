package com.bianlide.zb.cms.controller;

import java.io.PrintWriter;
import java.util.Date;
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
	@RequestMapping({ "getArticleList" })
	public ModelAndView getArticleList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json;charset=utf-8");
		String msg = "";
		String isOK = "true";
		PrintWriter pw = response.getWriter();
		JsonResultVO jsonRes = new JsonResultVO();
		// String title = request.getParameter("title");//标题（模糊匹配）
		 String codeModule = request.getParameter("codeModule");//模块
		// if(codeModule==null || "".equals(codeModule)){
		// codeModule="1000";
		// }
		 TJewContent content = new TJewContent();
		 if(codeModule!=null && !"".equals(codeModule)){
			 content.setCodeModule(codeModule);
		 }
		try {
			List<TJewContent> articleList = cmsService.getArticleList(content);

			jsonRes.setJsonData(articleList);
		} catch (Exception e) {
			isOK = "false";
			msg = "获取文章列表异常";
			logger.error("CmsController.getArticleList error", e);
			e.printStackTrace();
		}
		jsonRes.setIsOK(isOK);
		jsonRes.setMsg(msg);
		pw.write(JSON.toJSONString(jsonRes));
		return null;
	}

	/**
	 * 添加(编辑)文章.
	 * 
	 * @Title: addOrEditArticle
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Sophie
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws
	 */
	@RequestMapping({ "addOrEditArticle" })
	public ModelAndView addOrEditArticle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json;charset=utf-8");
		String msg = "";
		String isOK = "true";
		PrintWriter pw = response.getWriter();
		JsonResultVO jsonRes = new JsonResultVO();
		String idStr = request.getParameter("id");
		String title = request.getParameter("title");// 标题（模糊匹配）
		String codeModule = request.getParameter("codeModule");// 模块
		String content = request.getParameter("content");// 编辑内容
		String preImg=request.getParameter("preImg");// 预览图，用于产品模块
		

		content = content.replaceAll("&lt;", "<");
		content = content.replaceAll("&gt;", ">");
		content = content.replaceAll("\n", "");
		content = content.replaceAll("&amp;", "&");
		content = content.replaceAll("&quot;", "\"");
		content = content.replaceAll("&nbsp;", " ");
		content = content.replaceAll("&copy;", "");

		TJewContent jewContent = new TJewContent();
		if(idStr!=null && !"".equals(idStr)){
			jewContent.setId(Integer.parseInt(idStr));
		}
		jewContent.setTitle(title);
		jewContent.setContent(content);
		jewContent.setCreateTime(new Date());
		jewContent.setCodeModule(codeModule);
		
		if(preImg!=null && !"".equals(preImg)){
			jewContent.setPreImg(preImg);
		}
		
		try {
			//新增或添加
			cmsService.saveOrUpdate(jewContent);

		} catch (Exception e) {
			isOK = "false";
			msg = "添加或修改文章报错";
			logger.error("CmsController.addOrEditArticle error", e);
			e.printStackTrace();
		}
		jsonRes.setIsOK(isOK);
		jsonRes.setMsg(msg);
		pw.write(JSON.toJSONString(jsonRes));
		return null;
	}
	
	/**
	 * 删除文章.
	 * 
	 * @Title: addOrEditArticle
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Sophie
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws
	 */
	@RequestMapping({ "delArticle" })
	public ModelAndView delArticle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json;charset=utf-8");
		String msg = "";
		String isOK = "true";
		PrintWriter pw = response.getWriter();
		JsonResultVO jsonRes = new JsonResultVO();
		String idStr = request.getParameter("id");
		Integer id=null;
		if(idStr!=null && !"".equals(idStr)){
			id=Integer.parseInt(idStr);
			try {
				//删除文章
				cmsService.delContentById(id);
				//获得最新列表
				 TJewContent content = new TJewContent();
				List<TJewContent> articleList = cmsService.getArticleList(content);
				jsonRes.setJsonData(articleList);
			} catch (Exception e) {
				isOK = "false";
				msg = "删除文章列表异常";
				logger.error("CmsController.delArticle error", e);
				e.printStackTrace();
			}
		}else{
			isOK = "false";
			msg="删除文章时缺少参数";
		}
		
		jsonRes.setIsOK(isOK);
		jsonRes.setMsg(msg);
		pw.write(JSON.toJSONString(jsonRes));
		return null;
	}
	
	/**
	 * 根据id获取文章内容.
	 * 
	 * @Title: getArticleById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Sophie
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws
	 */
	@RequestMapping(
    { "getArticleById" })
    public ModelAndView getArticleById(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
		PrintWriter pw = null;
		String isOK="true";
		String msg="";
        response.setContentType("application/json;charset=utf-8");
        pw = response.getWriter();
        JsonResultVO jsonRes = new JsonResultVO();
		String idStr = request.getParameter("id");
		
		
		try {
			if(idStr!=null && !"".equals(idStr)){
				int id=Integer.parseInt(idStr);
				TJewContent content= cmsService.getContentById(id);
				jsonRes.setJsonData(content);
			}

		} catch (Exception e) {
			isOK = "false";
			msg = "进入文章编辑页出错";
			logger.error("CmsController.getArticleById error", e);
			e.printStackTrace();
		}
		jsonRes.setIsOK(isOK);
		jsonRes.setMsg(msg);
		pw.write(JSON.toJSONString(jsonRes));
        return null;
    }
}
