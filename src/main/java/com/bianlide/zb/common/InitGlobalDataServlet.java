/**  
 * @Title:  InitGlobalDataServlet.java
 * @Package com.bianlide.zb.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年11月12日 下午3:14:23
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bianlide.zb.cms.service.CmsService;

/**
 * @ClassName: InitGlobalDataServlet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年11月12日 下午3:14:23
 *
 */
public class InitGlobalDataServlet extends HttpServlet
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        // TODO Auto-generated method stub
        super.init(config);

        WebApplicationContext webApplicationContext = ContextLoader
                .getCurrentWebApplicationContext();
        CmsService cmsService = (CmsService) webApplicationContext
                .getBean("cmsService");
        cmsService.updateMenuData();

    }

}
