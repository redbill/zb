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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

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
public class PriceFileUploadServiceImpl implements PriceFileUploadService
{

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
    public List getPriceDatas(Map sm)
    {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = null;
        try
        {
            JSONObject sco = (JSONObject) sm.get("sco");
            Integer pageSize = (Integer) sm.get("pageSize");
            Integer pageNo = (Integer) sm.get("pageNo");

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
                    sql.append("and nai != 1 and ka != 1 ");
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
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
        return list;
    }
}
