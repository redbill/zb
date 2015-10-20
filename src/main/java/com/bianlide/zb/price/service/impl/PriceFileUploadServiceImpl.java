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

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public List<PriceData> getPriceDatas()
    {
        // TODO Auto-generated method stub
        return this.priceDataMapper.getPriceDatas();
    }

}
