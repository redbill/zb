package com.bianlide.zb.price.dao;

import com.bianlide.zb.price.model.FileUpload;

public interface FileUploadMapper
{
    int deleteByPrimaryKey(Integer fileId);

    int insert(FileUpload record);

    int insertSelective(FileUpload record);

    FileUpload selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(FileUpload record);

    int updateByPrimaryKey(FileUpload record);

    /**
     * @Title: getLastFileUpload
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @return
     * @throws
     */
    FileUpload getLastFileUpload();
}