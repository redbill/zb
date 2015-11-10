/**  
 * @Title:  FileUploadController.java
 * @Package com.bianlide.zb.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年10月17日 下午3:48:10
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bianlide.zb.price.model.FileUpload;
import com.bianlide.zb.price.service.PriceFileUploadService;

/**
 * @ClassName: FileUploadController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年10月17日 下午3:48:10
 *
 */
@Controller
public class FileUploadController
{
    @Value("${fileUpload.excelUploadPath}")
    private String excelUploadPath;

    public void setExcelUploadPath(String excelUploadPath)
    {
        this.excelUploadPath = excelUploadPath;
    }

    private PriceFileUploadService priceFileUploadService;

    public void setPriceFileUploadService(
            PriceFileUploadService priceFileUploadService)
    {
        this.priceFileUploadService = priceFileUploadService;
    }

    @RequestMapping(value = "mgr/uploadPriceFileForm", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file)
    {

        if (!file.isEmpty())
        {
            try
            {
                SaveFileFromInputStream(file.getInputStream(),
                        this.excelUploadPath);
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "uploadSuccess";
        }

        return "uploadFailure";
    }

    /**
     * 保存文件
     * 
     * @param stream
     * @param path
     * @param filename
     * @throws IOException
     */
    public void SaveFileFromInputStream(InputStream stream, String path)
            throws IOException
    {
        FileUpload fu = new FileUpload();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateStr = sdf.format(date);
        File tempFile = File.createTempFile(dateStr, ".xlsx", new File(path));
        FileOutputStream fs = new FileOutputStream(tempFile);
        byte[] buffer = new byte[1024 * 1024];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread = stream.read(buffer)) != -1)
        {
            bytesum += byteread;
            fs.write(buffer, 0, byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
        fu.setFileName(tempFile.getName());
        fu.setUploadTime(date);
        this.priceFileUploadService.insertFileUploadRecord(fu);
    }
}
