/**  
 * @Title:  PriceFileUploadService.java
 * @Package com.bianlide.zb.price.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年10月19日 下午12:48:26
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.price.service;

import java.util.List;
import java.util.Map;

import com.bianlide.zb.price.model.FileUpload;
import com.bianlide.zb.price.model.PriceData;

/**
 * @ClassName: PriceFileUploadService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年10月19日 下午12:48:26
 *
 */
public interface PriceFileUploadService
{

    public int insertFileUploadRecord(FileUpload fileUploadRecord);

    public FileUpload getLastFileUpload();

    public int insertPriceData(PriceData pd);

    /**
     * @Title: deleteOldPriceData
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @return
     * @throws
     */
    public int deleteOldPriceData();

    /**
     * @Title: getPriceDatas
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @return
     * @throws
     */
    public List<PriceData> getPriceDatas();

    /**
     * @Title: getPriceDatasPage
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param sm
     * @return
     * @throws
     */
    Map getPriceDatasPage(Map sm);

}
