/**  
 * @Title:  PriceFileUploadServiceImpl.java
 * @Package com.bianlide.zb.price.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年10月19日 下午12:49:26
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.price.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bianlide.zb.price.dao.FileUploadMapper;
import com.bianlide.zb.price.dao.PriceDataMapper;
import com.bianlide.zb.price.model.FileUpload;
import com.bianlide.zb.price.model.PriceData;
import com.bianlide.zb.price.service.PriceFileUploadService;

/**
 * @ClassName: PriceFileUploadServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年10月19日 下午12:49:26
 *
 */
@Service("priceFileUploadService")
@Transactional
public class PriceFileUploadServiceImpl implements PriceFileUploadService
{
    @Value("${fileUpload.excelUploadPath}")
    private String excelUploadPat;

    @Resource
    private FileUploadMapper fileUploadMapper;

    @Resource
    private PriceDataMapper priceDataMapper;

    private BasicDataSource dataSource;

    public void setDataSource(BasicDataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    /*
     * (非 Javadoc) <p>Title: insertFileUploadRecord</p> <p>Description: </p>
     * 
     * @param fileUploadRecord
     * 
     * @return
     * 
     * @see
     * com.bianlide.zb.price.service.PriceFileUploadService#insertFileUploadRecord
     * (com.bianlide.zb.price.model.FileUpload)
     */
    public int insertFileUploadRecord(FileUpload fileUploadRecord)
    {
        // TODO Auto-generated method stub
        return this.fileUploadMapper.insertSelective(fileUploadRecord);
    }

    /*
     * (非 Javadoc) <p>Title: getLastFileUpload</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see
     * com.bianlide.zb.price.service.PriceFileUploadService#getLastFileUpload()
     */
    public FileUpload getLastFileUpload()
    {
        // TODO Auto-generated method stub
        return this.fileUploadMapper.getLastFileUpload();
    }

    /*
     * (非 Javadoc) <p>Title: insertPriceData</p> <p>Description: </p>
     * 
     * @param pd
     * 
     * @return
     * 
     * @see
     * com.bianlide.zb.price.service.PriceFileUploadService#insertPriceData(
     * com.bianlide.zb.price.model.PriceData)
     */
    public int insertPriceData(PriceData pd)
    {
        // TODO Auto-generated method stub
        return this.priceDataMapper.insertSelective(pd);
    }

    /*
     * (非 Javadoc) <p>Title: deleteOldPriceData</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see
     * com.bianlide.zb.price.service.PriceFileUploadService#deleteOldPriceData()
     */
    public int deleteOldPriceData()
    {
        // TODO Auto-generated method stub
        return this.priceDataMapper.deleteOldPriceData();
    }

    /*
     * (非 Javadoc) <p>Title: getPriceDatas</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see com.bianlide.zb.price.service.PriceFileUploadService#getPriceDatas()
     */
    public List<PriceData> getPriceDatas()
    {
        // TODO Auto-generated method stub
        return this.priceDataMapper.getPriceDatas();
    }

    /*
     * (非 Javadoc) <p>Title: getPriceDatas</p> <p>Description: </p>
     * 
     * @param sm
     * 
     * @return
     * 
     * @see
     * com.bianlide.zb.price.service.PriceFileUploadService#getPriceDatas(java
     * .util.Map)
     */
    @Override
    public Map getPriceDatasPage(Map sm)
    {
        // TODO Auto-generated method stub
        JSONObject sco = (JSONObject) sm.get("sco");
        Integer pageSize = (Integer) sm.get("pageSize");
        Integer pageNo = (Integer) sm.get("pageNo");
        Map resultMap = new HashMap();
        resultMap.put("isOK", "false");
        resultMap.put("jsonData", null);
        resultMap.put("total", 0);
        resultMap.put("pageNo", pageNo);
        resultMap.put("pageSize", pageSize);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = null;
        try
        {

            conn = dataSource.getConnection();

            list = new ArrayList();

            Statement stmt = conn.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("select * from price_data where 1 = 1 ");
            if (sco != null)
            {
                JSONArray shapeArray = sco.getJSONArray("shapeCondition");
                if (shapeArray != null && shapeArray.size() > 0)
                {

                    sql.append("and shape in(");
                    for (int i = 0; i < shapeArray.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'").append(shapeArray.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'").append(shapeArray.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

                // bigThanWeight
                String bigerStr = sco.getString("bigThanWeight");
                if (bigerStr != null && !"".equals(bigerStr.trim()))
                {
                    sql.append(" and carat >= ").append(bigerStr);
                }

                // smallThanWeight
                String smallThanWeight = sco.getString("smallThanWeight");
                if (smallThanWeight != null
                        && !"".equals(smallThanWeight.trim()))
                {
                    sql.append(" and carat <= ").append(smallThanWeight);
                }

                JSONArray colorCondition = sco.getJSONArray("colorCondition");
                if (colorCondition != null && colorCondition.size() > 0)
                {

                    sql.append("and color in(");
                    for (int i = 0; i < colorCondition.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'").append(colorCondition.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'")
                                    .append(colorCondition.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

                JSONArray cutCondition = sco.getJSONArray("cutCondition");
                if (cutCondition != null && cutCondition.size() > 0)
                {

                    sql.append("and cut in(");
                    for (int i = 0; i < cutCondition.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'").append(cutCondition.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'").append(cutCondition.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

                JSONArray clarityCondition = sco
                        .getJSONArray("clarityCondition");
                if (clarityCondition != null && clarityCondition.size() > 0)
                {

                    sql.append("and clarity in(");
                    for (int i = 0; i < clarityCondition.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'")
                                    .append(clarityCondition.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'")
                                    .append(clarityCondition.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

                JSONArray polishCondition = sco.getJSONArray("polishCondition");
                if (polishCondition != null && polishCondition.size() > 0)
                {

                    sql.append("and polish in(");
                    for (int i = 0; i < polishCondition.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'")
                                    .append(polishCondition.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'")
                                    .append(polishCondition.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

                boolean withoutNK = sco.getBooleanValue("withoutNK");
                if (withoutNK)
                {
                    sql.append("and nai IS NULL and ka IS NULL ");
                }

                JSONArray certCondition = sco.getJSONArray("certCondition");
                if (certCondition != null && certCondition.size() > 0)
                {

                    sql.append("and cert in(");
                    for (int i = 0; i < certCondition.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'").append(certCondition.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'").append(certCondition.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

                JSONArray symmetryCondition = sco
                        .getJSONArray("symmetryCondition");
                if (symmetryCondition != null && symmetryCondition.size() > 0)
                {

                    sql.append("and semmetry in(");
                    for (int i = 0; i < symmetryCondition.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'")
                                    .append(symmetryCondition.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'")
                                    .append(symmetryCondition.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

                String price = sco.getString("price");
                if (price != null && !"".equals(price.trim()))
                {
                    sql.append(" and price = ").append(price);
                }

                JSONArray fluorCondition = sco.getJSONArray("fluorCondition");
                if (fluorCondition != null && fluorCondition.size() > 0)
                {

                    sql.append("and fluor in(");
                    for (int i = 0; i < fluorCondition.size(); i++)
                    {
                        if (i == 0)
                        {
                            sql.append("'").append(fluorCondition.getString(i))
                                    .append("'");
                        }
                        else
                        {
                            sql.append(",'")
                                    .append(fluorCondition.getString(i))
                                    .append("'");
                        }
                    }

                    sql.append(")");
                }

            }

            System.out.println(sql.toString());
            StringBuilder countSql = new StringBuilder();
            countSql.append("select count(*) from (").append(sql)
                    .append(") a ");
            rs = stmt.executeQuery(countSql.toString());
            int count = 0;
            while (rs.next())
            {
                count = rs.getInt(1);
            }
            System.out.println(count);
            rs.close();
            stmt.close();
            stmt = conn.createStatement();
            // searchCondition.sortbyweight =
            // $("#sortbyweight").attr("data-order");
            // searchCondition.sortbyprice =
            // $("#sortbyprice").attr("data-order");

            String sortbyweight = sco.getString("sortbyweight");
            if (sortbyweight != null && "1".equals(sortbyweight.trim()))
            {
                sql.append(" order by carat desc, ");
            }
            else
            {
                sql.append(" order by carat asc, ");
            }

            String sortbyprice = sco.getString("sortbyprice");
            if (sortbyprice != null && "1".equals(sortbyprice.trim()))
            {
                sql.append("  price desc ");
            }
            else
            {
                sql.append("  price asc ");
            }

            sql.append(" LIMIT ").append((pageNo - 1) * pageSize).append(",")
                    .append(pageSize);
            rs = stmt.executeQuery(sql.toString());

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            while (rs.next())
            {

                Map map = new HashMap();

                for (int i = 1; i <= columnCount; i++)
                {

                    map.put(md.getColumnName(i), rs.getObject(i));

                }

                list.add(map);

            }

            resultMap.put("isOK", "true");
            resultMap.put("jsonData", list);
            resultMap.put("total", count);
            resultMap.put("pageNo", pageNo);
            resultMap.put("pageSize", pageSize);

        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resultMap.put("isOK", "false");
            resultMap.put("jsonData", null);
            resultMap.put("msg", e.getMessage());
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return resultMap;
    }

    @Override
    public Map importFileToDB(String fileName) throws Exception
    {
        if (fileName == null || "".equals(fileName))
        {
            throw new Exception("导入数据文件名为空");
        }

        // 导入数据前删除以前数据
        int deleteCode = deleteOldPriceData();
        // 读取文件

        InputStream is = new FileInputStream(excelUploadPat + File.separator
                + fileName);
        SXSSFWorkbook xssfWorkbook = new SXSSFWorkbook(new XSSFWorkbook(is),
                1500);
        Sheet xssfSheet = xssfWorkbook.getSheetAt(0);
        List<PriceData> pdList = new ArrayList<PriceData>();
        // Read the Row
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++)
        {
            Row xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null)
            {
                PriceData pd = new PriceData();
                pd.setFileName(fileName);
                pd.setRowNum(rowNum);
                pd.setCreateTime(new Date());
                pd.setStatus("1");// 新插入状态

                Cell shapeCell = xssfRow.getCell(0, Row.CREATE_NULL_AS_BLANK);
                if (shapeCell != null)
                {
                    pd.setShape(getValue(shapeCell));
                }
                xssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                Cell naiCell = xssfRow.getCell(1, Row.CREATE_NULL_AS_BLANK);
                if (naiCell != null)
                {
                    String naiStr = naiCell.getStringCellValue();
                    if (naiStr != null && "1".equals(naiStr.trim()))
                    {
                        pd.setNai("1");
                    }
                }
                xssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                Cell kaCell = xssfRow.getCell(2, Row.CREATE_NULL_AS_BLANK);
                if (kaCell != null)
                {
                    String kaStr = kaCell.getStringCellValue();
                    if (kaStr != null && "1".equals(kaStr.trim()))
                    {
                        pd.setKa("1");
                    }
                }
                Cell caratCell = xssfRow.getCell(3, Row.CREATE_NULL_AS_BLANK);
                if (caratCell != null)
                {
                    String caratStr = getValue(caratCell);
                    if (!checkDecimals(caratStr, ""))
                    {
                        throw new Exception("第" + rowNum
                                + "行第4列的数据格式有问题,请修正并重新上传文件！");
                    }
                    pd.setCarat(BigDecimal.valueOf(Double.valueOf(caratStr)));
                }
                Cell colorCell = xssfRow.getCell(4, Row.CREATE_NULL_AS_BLANK);
                if (colorCell != null)
                {
                    pd.setColor(getValue(colorCell));
                }
                Cell clarityCell = xssfRow.getCell(5, Row.CREATE_NULL_AS_BLANK);
                if (clarityCell != null)
                {
                    pd.setClarity(getValue(clarityCell));
                }
                Cell cutCell = xssfRow.getCell(6, Row.CREATE_NULL_AS_BLANK);
                if (cutCell != null)
                {
                    pd.setCut(getValue(cutCell));
                }
                Cell polishCell = xssfRow.getCell(7, Row.CREATE_NULL_AS_BLANK);
                if (polishCell != null)
                {
                    pd.setPolish(getValue(polishCell));
                }
                Cell semmetryCell = xssfRow
                        .getCell(8, Row.CREATE_NULL_AS_BLANK);
                if (semmetryCell != null)
                {
                    pd.setSemmetry(getValue(semmetryCell));
                }
                Cell fluorCell = xssfRow.getCell(9, Row.CREATE_NULL_AS_BLANK);
                if (fluorCell != null)
                {
                    pd.setFluor(getValue(fluorCell));
                }
                Cell xinJianCell = xssfRow
                        .getCell(10, Row.CREATE_NULL_AS_BLANK);
                if (xinJianCell != null)
                {
                    pd.setXinJian(getValue(xinJianCell));
                }
                Cell zhiJingCell = xssfRow
                        .getCell(11, Row.CREATE_NULL_AS_BLANK);
                if (zhiJingCell != null)
                {
                    pd.setZhiJing(getValue(zhiJingCell));
                }
                Cell depthCell = xssfRow.getCell(12, Row.CREATE_NULL_AS_BLANK);
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

                Cell taiMianCell = xssfRow
                        .getCell(13, Row.CREATE_NULL_AS_BLANK);
                if (taiMianCell != null)
                {
                    String taiMianStr = getValue(taiMianCell);

                    if (!checkDecimals(taiMianStr, "0+"))
                    {
                        throw new Exception("第" + rowNum
                                + "行第14列的数据格式有问题,请修正并重新上传文件！");
                    }
                    pd.setTaiMian(BigDecimal.valueOf(Double.valueOf(taiMianStr)));
                }

                Cell cetNoCell = xssfRow.getCell(14, Row.CREATE_NULL_AS_BLANK);
                if (cetNoCell != null)
                {
                    pd.setCertNo(getValue(cetNoCell));
                }
                Cell cerCell = xssfRow.getCell(15, Row.CREATE_NULL_AS_BLANK);
                if (cerCell != null)
                {
                    pd.setCert(getValue(cerCell));
                }
                Cell priceCell = xssfRow.getCell(16, Row.CREATE_NULL_AS_BLANK);
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
                if (pdList.size() == 1000)
                {
                    // 批量插入
                    insertBatch(pdList);
                    pdList.clear();
                }

            }
        }
        if (pdList.size() != 0)
        {
            // 批量插入
            insertBatch(pdList);
        }

        return null;
    }

    @Override
    public Map importFileToDBSAX(String fileName) throws Exception
    {
        if (fileName == null || "".equals(fileName))
        {
            throw new Exception("导入数据文件名为空");
        }

        // 导入数据前删除以前数据
        int deleteCode = deleteOldPriceData();
        // 读取文件

        
         

        List<String[]> list = XLSXCovertCSVReader.readerExcel(excelUploadPat
                + File.separator + fileName, "", 17);
        for (String[] record : list)
        {
            for (String cell : record)
            {
               cell.split("")
            }
            System.out.println();
        }

        Sheet xssfSheet = xssfWorkbook.getSheetAt(0);
        List<PriceData> pdList = new ArrayList<PriceData>();
        // Read the Row
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++)
        {
            Row xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null)
            {
                PriceData pd = new PriceData();
                pd.setFileName(fileName);
                pd.setRowNum(rowNum);
                pd.setCreateTime(new Date());
                pd.setStatus("1");// 新插入状态

                Cell shapeCell = xssfRow.getCell(0, Row.CREATE_NULL_AS_BLANK);
                if (shapeCell != null)
                {
                    pd.setShape(getValue(shapeCell));
                }
                xssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                Cell naiCell = xssfRow.getCell(1, Row.CREATE_NULL_AS_BLANK);
                if (naiCell != null)
                {
                    String naiStr = naiCell.getStringCellValue();
                    if (naiStr != null && "1".equals(naiStr.trim()))
                    {
                        pd.setNai("1");
                    }
                }
                xssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                Cell kaCell = xssfRow.getCell(2, Row.CREATE_NULL_AS_BLANK);
                if (kaCell != null)
                {
                    String kaStr = kaCell.getStringCellValue();
                    if (kaStr != null && "1".equals(kaStr.trim()))
                    {
                        pd.setKa("1");
                    }
                }
                Cell caratCell = xssfRow.getCell(3, Row.CREATE_NULL_AS_BLANK);
                if (caratCell != null)
                {
                    String caratStr = getValue(caratCell);
                    if (!checkDecimals(caratStr, ""))
                    {
                        throw new Exception("第" + rowNum
                                + "行第4列的数据格式有问题,请修正并重新上传文件！");
                    }
                    pd.setCarat(BigDecimal.valueOf(Double.valueOf(caratStr)));
                }
                Cell colorCell = xssfRow.getCell(4, Row.CREATE_NULL_AS_BLANK);
                if (colorCell != null)
                {
                    pd.setColor(getValue(colorCell));
                }
                Cell clarityCell = xssfRow.getCell(5, Row.CREATE_NULL_AS_BLANK);
                if (clarityCell != null)
                {
                    pd.setClarity(getValue(clarityCell));
                }
                Cell cutCell = xssfRow.getCell(6, Row.CREATE_NULL_AS_BLANK);
                if (cutCell != null)
                {
                    pd.setCut(getValue(cutCell));
                }
                Cell polishCell = xssfRow.getCell(7, Row.CREATE_NULL_AS_BLANK);
                if (polishCell != null)
                {
                    pd.setPolish(getValue(polishCell));
                }
                Cell semmetryCell = xssfRow
                        .getCell(8, Row.CREATE_NULL_AS_BLANK);
                if (semmetryCell != null)
                {
                    pd.setSemmetry(getValue(semmetryCell));
                }
                Cell fluorCell = xssfRow.getCell(9, Row.CREATE_NULL_AS_BLANK);
                if (fluorCell != null)
                {
                    pd.setFluor(getValue(fluorCell));
                }
                Cell xinJianCell = xssfRow
                        .getCell(10, Row.CREATE_NULL_AS_BLANK);
                if (xinJianCell != null)
                {
                    pd.setXinJian(getValue(xinJianCell));
                }
                Cell zhiJingCell = xssfRow
                        .getCell(11, Row.CREATE_NULL_AS_BLANK);
                if (zhiJingCell != null)
                {
                    pd.setZhiJing(getValue(zhiJingCell));
                }
                Cell depthCell = xssfRow.getCell(12, Row.CREATE_NULL_AS_BLANK);
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

                Cell taiMianCell = xssfRow
                        .getCell(13, Row.CREATE_NULL_AS_BLANK);
                if (taiMianCell != null)
                {
                    String taiMianStr = getValue(taiMianCell);

                    if (!checkDecimals(taiMianStr, "0+"))
                    {
                        throw new Exception("第" + rowNum
                                + "行第14列的数据格式有问题,请修正并重新上传文件！");
                    }
                    pd.setTaiMian(BigDecimal.valueOf(Double.valueOf(taiMianStr)));
                }

                Cell cetNoCell = xssfRow.getCell(14, Row.CREATE_NULL_AS_BLANK);
                if (cetNoCell != null)
                {
                    pd.setCertNo(getValue(cetNoCell));
                }
                Cell cerCell = xssfRow.getCell(15, Row.CREATE_NULL_AS_BLANK);
                if (cerCell != null)
                {
                    pd.setCert(getValue(cerCell));
                }
                Cell priceCell = xssfRow.getCell(16, Row.CREATE_NULL_AS_BLANK);
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
                if (pdList.size() == 1000)
                {
                    // 批量插入
                    insertBatch(pdList);
                    pdList.clear();
                }

            }
        }
        if (pdList.size() != 0)
        {
            // 批量插入
            insertBatch(pdList);
        }

        return null;
    }

    public void insertBatch(List<PriceData> pdList) throws Exception
    {
        String sql = "  insert into price_data (file_name, row_num, create_time, shape, nai, ka, carat, color, clarity, cut,  polish, semmetry, fluor, xin_jian, zhi_jing, depth, tai_mian, cert_no, cert,  price, status, delete_time ) values (?, ?, ?, ?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        // 从池中获取连接
        Connection conn = this.dataSource.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (PriceData pd : pdList)
        {
            pstmt.setString(1, pd.getFileName());
            pstmt.setInt(2, pd.getRowNum());
            pstmt.setDate(3, new java.sql.Date(pd.getCreateTime().getTime()));
            pstmt.setString(4, pd.getShape());
            pstmt.setString(5, pd.getNai());
            pstmt.setString(6, pd.getKa());
            pstmt.setBigDecimal(7, pd.getCarat());
            pstmt.setString(8, pd.getColor());
            pstmt.setString(9, pd.getClarity());
            pstmt.setString(10, pd.getCut());
            pstmt.setString(11, pd.getPolish());
            pstmt.setString(12, pd.getSemmetry());
            pstmt.setString(13, pd.getFluor());
            pstmt.setString(14, pd.getXinJian());
            pstmt.setString(15, pd.getZhiJing());
            pstmt.setBigDecimal(16, pd.getDepth());
            pstmt.setBigDecimal(17, pd.getTaiMian());
            pstmt.setString(18, pd.getCertNo());
            pstmt.setString(19, pd.getCert());
            pstmt.setInt(20, pd.getPrice());
            pstmt.setString(21, pd.getStatus());
            pstmt.setDate(22, (java.sql.Date) pd.getDeleteTime());
            // 加入批处理
            pstmt.addBatch();
        }
        pstmt.executeBatch(); // 执行批处理
        conn.commit();
        // pstmt.clearBatch(); //清理批处理
        try
        {
            pstmt.close();
            conn.close();
        }
        catch (Exception e)
        {

        }
        finally
        {
            if (!pstmt.isClosed())
            {
                pstmt.close();
            }

            if (!conn.isClosed())
            {
                conn.close();
            }
        }

    }

    private String getValue(Cell xssfRow)
    {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN)
        {
            return String.valueOf(xssfRow.getBooleanCellValue());
        }
        else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC)
        {

            return BigDecimal.valueOf(xssfRow.getNumericCellValue())
                    .toPlainString();
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

}
