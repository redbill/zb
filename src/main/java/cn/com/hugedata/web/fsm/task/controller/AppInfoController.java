package cn.com.hugedata.web.fsm.task.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bianlide.zb.common.controller.LoginController;

import cn.com.hugedata.web.fsm.task.model.AppInfo;
import cn.com.hugedata.web.fsm.task.service.AppInfoService;
import cn.com.hugedata.web.fsm.user.model.UserInfo;

/**
 * @author Samuel
 *
 */
@Controller
@RequestMapping ({"/user{userId}" })
public class AppInfoController {
	
	private static Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	private AppInfoService appInfoService;
	
	
	
	public void setAppInfoService(AppInfoService appInfoService) {
		this.appInfoService = appInfoService;
	}



	@RequestMapping ({"/apps" })
	 public ModelAndView getMyAppLists(HttpServletRequest request,
	            HttpServletResponse response)
	    {
	         
	        PrintWriter pw = null;
	        
	            try
	            {
	            	HttpSession s = request.getSession();
	            	UserInfo myInfo = (UserInfo)s.getAttribute("UserInfo");
	            	List<AppInfo> list = this.appInfoService.getMyAppLists(myInfo);

	                response.setContentType("application/json;charset=utf-8");
	                pw = response.getWriter();
	                pw.write(JSON.toJSONString(list));
	                pw.flush();
	                return null;
	            }
	            catch (Exception e)
	            {
	                logger.error("getMyAppLists error : " + e.getMessage());
	                return null;
	            }
	            finally
	            {
	                pw.close();
	            }
	        
	    }
}
