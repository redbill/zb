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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.bianlide.zb.common.vo.JsonResultVO;
import com.bianlide.zb.price.model.FileUpload;
import com.bianlide.zb.price.model.PriceData;
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
            if (fileName == null || "".equals(fileName))
            {
                throw new Exception("导入数据文件名为空");
            }

            // 读取文件

            InputStream is = new FileInputStream(excelUploadPat
                    + File.separator + fileName);
            HSSFWorkbook xssfWorkbook = new HSSFWorkbook(is);
            HSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            List<PriceData> pdList = new ArrayList<PriceData>();
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++)
            {
                HSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null)
                {
                    PriceData pd = new PriceData();
                    pd.setFileName(fileName);
                    pd.setRowNum(rowNum);
                    pd.setCreateTime(new Date());
                    pd.setStatus("1");// 新插入状态

                    HSSFCell shapeCell = xssfRow.getCell(0,
                            Row.CREATE_NULL_AS_BLANK);
                    if (shapeCell != null)
                    {
                        pd.setShape(getValue(shapeCell));
                    }
                    HSSFCell naiCell = xssfRow.getCell(1,
                            Row.CREATE_NULL_AS_BLANK);
                    if (naiCell != null)
                    {
                        pd.setNai(getValue(naiCell));
                    }
                    HSSFCell kaCell = xssfRow.getCell(2,
                            Row.CREATE_NULL_AS_BLANK);
                    if (kaCell != null)
                    {
                        pd.setKa(getValue(kaCell));
                    }
                    HSSFCell caratCell = xssfRow.getCell(3,
                            Row.CREATE_NULL_AS_BLANK);
                    if (caratCell != null)
                    {
                        String caratStr = getValue(caratCell);
                        if (!checkDecimals(caratStr, "0+"))
                        {
                            throw new Exception("第" + rowNum
                                    + "行第4列的数据格式有问题,请修正并重新上传文件！");
                        }
                        pd.setCarat(BigDecimal.valueOf(Double.valueOf(caratStr)));
                    }
                    HSSFCell colorCell = xssfRow.getCell(4,
                            Row.CREATE_NULL_AS_BLANK);
                    if (colorCell != null)
                    {
                        pd.setColor(getValue(colorCell));
                    }
                    HSSFCell clarityCell = xssfRow.getCell(5,
                            Row.CREATE_NULL_AS_BLANK);
                    if (clarityCell != null)
                    {
                        pd.setClarity(getValue(clarityCell));
                    }
                    HSSFCell cutCell = xssfRow.getCell(6,
                            Row.CREATE_NULL_AS_BLANK);
                    if (cutCell != null)
                    {
                        pd.setCut(getValue(cutCell));
                    }
                    HSSFCell polishCell = xssfRow.getCell(7,
                            Row.CREATE_NULL_AS_BLANK);
                    if (polishCell != null)
                    {
                        pd.setPolish(getValue(polishCell));
                    }
                    HSSFCell semmetryCell = xssfRow.getCell(8,
                            Row.CREATE_NULL_AS_BLANK);
                    if (semmetryCell != null)
                    {
                        pd.setSemmetry(getValue(semmetryCell));
                    }
                    HSSFCell fluorCell = xssfRow.getCell(9,
                            Row.CREATE_NULL_AS_BLANK);
                    if (fluorCell != null)
                    {
                        pd.setFluor(getValue(fluorCell));
                    }
                    HSSFCell xinJianCell = xssfRow.getCell(10,
                            Row.CREATE_NULL_AS_BLANK);
                    if (xinJianCell != null)
                    {
                        pd.setXinJian(getValue(xinJianCell));
                    }
                    HSSFCell zhiJingCell = xssfRow.getCell(11,
                            Row.CREATE_NULL_AS_BLANK);
                    if (zhiJingCell != null)
                    {
                        String zhiJingStr = getValue(zhiJingCell);

                        if (!checkDecimals(zhiJingStr, "0+"))
                        {
                            throw new Exception("第" + rowNum
                                    + "行第12列的数据格式有问题,请修正并重新上传文件！");
                        }
                        pd.setZhiJing(BigDecimal.valueOf(Double
                                .valueOf(zhiJingStr)));
                    }
                    HSSFCell depthCell = xssfRow.getCell(12,
                            Row.CREATE_NULL_AS_BLANK);
                    if (depthCell != null)
                    {
                        String depthStr = getValue(depthCell);

                        if (!checkDecimals(depthStr, "0+"))
                        {
                            throw new Exception("第" + rowNum
                                    + "行第13列的数据格式有问题,请修正并重新上传文件！");
                        }
                        pd.setDepth(BigDecimal.valueOf(Double.valueOf(depthStr)));
                    }

                    HSSFCell taiMianCell = xssfRow.getCell(13,
                            Row.CREATE_NULL_AS_BLANK);
                    if (taiMianCell != null)
                    {
                        String taiMianStr = getValue(taiMianCell);

                        if (!checkDecimals(taiMianStr, "0+"))
                        {
                            throw new Exception("第" + rowNum
                                    + "行第14列的数据格式有问题,请修正并重新上传文件！");
                        }
                        pd.setTaiMian(BigDecimal.valueOf(Double
                                .valueOf(taiMianStr)));
                    }

                    HSSFCell cetNoCell = xssfRow.getCell(14,
                            Row.CREATE_NULL_AS_BLANK);
                    if (cetNoCell != null)
                    {
                        pd.setCertNo(getValue(cetNoCell));
                    }
                    HSSFCell cerCell = xssfRow.getCell(15,
                            Row.CREATE_NULL_AS_BLANK);
                    if (cerCell != null)
                    {
                        pd.setCert(getValue(cerCell));
                    }
                    HSSFCell priceCell = xssfRow.getCell(16,
                            Row.CREATE_NULL_AS_BLANK);
                    if (priceCell != null)
                    {
                        String priceStr = getValue(priceCell);

                        if (!checkDecimals(priceStr, "0+"))
                        {
                            throw new Exception("第" + rowNum
                                    + "行第17列的数据格式有问题,请修正并重新上传文件！");
                        }
                        Double pricedb = Double.valueOf(priceStr);
                        pd.setPrice(pricedb.intValue());
                    }
                    pdList.add(pd);
                }
            }
            if (pdList.size() == 0)
            {
                throw new Exception("数据文件为空，请检查并重新上传文件!");

            }
            // 导入数据前删除以前数据
            int deleteCode = this.priceFileUploadService.deleteOldPriceData();
            // 导入数据库
            for (int i = 0; i < pdList.size(); i++)
            {
                this.priceFileUploadService.insertPriceData(pdList.get(i));
            }
            //

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
        try
        {

            List<PriceData> priceList = this.priceFileUploadService
                    .getPriceDatas();
            jsonRes.setIsOKToTrue();
            jsonRes.setJsonData(priceList);
            pw.write(JSON.toJSONString(jsonRes));
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

    private String getValue(HSSFCell xssfRow)
    {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN)
        {
            return String.valueOf(xssfRow.getBooleanCellValue());
        }
        else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC)
        {
            return String.valueOf(xssfRow.getNumericCellValue());
        }
        else
        {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    /**
     * 检查浮点数
     * 
     * @param num
     * @param type
     *            "0+":非负浮点数 "+":正浮点数 "-0":非正浮点数 "-":负浮点数 "":浮点数
     * @return
     */
    private static boolean checkDecimals(String num, String type)
    {
        // String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        // return Pattern.matches(regex, decimals);
        String eL = "";
        if (type.equals("0+"))
            eL = "^\\d+(\\.\\d+)?$";// 非负浮点数
        else if (type.equals("+"))
            eL = "^((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*))$";// 正浮点数
        else if (type.equals("-0"))
            eL = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";// 非正浮点数
        else if (type.equals("-"))
            eL = "^(-((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*)))$";// 负浮点数
        else
            eL = "^(-?\\d+)(\\.\\d+)?$";// 浮点数
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(num);
        boolean b = m.matches();
        return b;
    }

    public static boolean checkDigit(String digit)
    {
        String regex = "^\\d+$";
        return Pattern.matches(regex, digit);
    }

    public static void main(String[] varg)
    {
        System.out.println(checkDigit("0"));
    }

}
