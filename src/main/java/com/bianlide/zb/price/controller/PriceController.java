/**  
 * @Title:  FileUploadController.java
 * @Package com.bianlide.zb.price.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年10月19日 下午1:46:39
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.price.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bianlide.zb.common.vo.JsonResultVO;
import com.bianlide.zb.price.model.FileUpload;
import com.bianlide.zb.price.service.PriceFileUploadService;

/**
 * @ClassName: FileUploadController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年10月19日 下午1:46:39
 *
 */
@Controller
public class PriceController
{
    @Value("${fileUpload.excelUploadPath}")
    private String excelUploadPat;

    private static Logger logger = LoggerFactory
            .getLogger(PriceController.class);

    private PriceFileUploadService priceFileUploadService;

    public void setPriceFileUploadService(
            PriceFileUploadService priceFileUploadService)
    {
        this.priceFileUploadService = priceFileUploadService;
    }

    @RequestMapping(
    { "mgr/upLoadPriceFile" })
    public String upLoadPriceFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "upLoadPriceFile";
    }

    @RequestMapping(
    { "mgr/importPriceData" })
    public String importPriceData(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        FileUpload fu = this.priceFileUploadService.getLastFileUpload();
        request.setAttribute("lastFileUpload", fu);
        return "importPriceData";
    }

    @RequestMapping(
    { "mgr/updatePriceData" })
    public String updatePriceData(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "updatePriceData";
    }

    @RequestMapping(
    { "mgr/importFileToDB" })
    public String importFileToDB(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        PrintWriter pw = null;
        response.setContentType("application/json;charset=utf-8");
        String fileName = request.getParameter("lastFileName");
        pw = response.getWriter();
        JsonResultVO jsonRes = new JsonResultVO();
        try
        {

            //
            this.priceFileUploadService.importFileToDB(fileName);
            jsonRes.setIsOKToTrue();
            pw.write(JSON.toJSONString(jsonRes));
            pw.flush();
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("importFileToDB error : " + e.getMessage());
            jsonRes.setMsg(e.getMessage());
            pw.write(JSON.toJSONString(jsonRes));
            pw.flush();
            return null;
        }
        finally
        {
            pw.close();
        }
    }

    @RequestMapping(
    { "mgr/getPriceDatas" })
    public String getPriceDatas(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        PrintWriter pw = null;
        response.setContentType("application/json;charset=utf-8");
        pw = response.getWriter();
        JsonResultVO jsonRes = new JsonResultVO();
        String searchCondition = request.getParameter("searchCondition");
        // 一页显示条数
        String pageSizeStr = request.getParameter("pageSize");
        // 页码
        String pageNoStr = request.getParameter("page");
        // 页码
        String gotoPageNoStr = request.getParameter("pageNo");

        int pageSize = 0;
        int pageNo = 0;

        if (pageSizeStr != null && !"".equals(pageSizeStr))
        {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        if (pageNoStr != null && !"".equals(pageNoStr))
        {
            pageNo = Integer.parseInt(pageNoStr);
        }

        if (gotoPageNoStr != null && !"".equals(gotoPageNoStr))
        {
            pageNo = Integer.parseInt(gotoPageNoStr);
        }

        try
        {
            JSONObject sco = null;
            if (searchCondition != null && !"".equals(searchCondition))
            {
                searchCondition = URLDecoder.decode(searchCondition, "UTF-8");
                sco = JSONObject.parseObject(searchCondition);
            }

            Map sm = new HashMap();
            sm.put("sco", sco);
            sm.put("pageSize", pageSize);
            sm.put("pageNo", pageNo);

            //
            Map result = this.priceFileUploadService.getPriceDatasPage(sm);

            pw.write(JSON.toJSONString(result));
            pw.flush();
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("getPriceDatas error : " + e.getMessage());
            jsonRes.setMsg(e.getMessage());
            pw.write(JSON.toJSONString(jsonRes));
            pw.flush();
            return null;
        }
        finally
        {
            pw.close();
        }
    }

    public static void main(String[] varg)
    {
        System.out.println(BigDecimal.valueOf(Double.valueOf("3.232323E4"))
                .toPlainString());

    }
}
