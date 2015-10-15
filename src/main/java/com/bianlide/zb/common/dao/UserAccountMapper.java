package com.bianlide.zb.common.dao;

import com.bianlide.zb.common.model.UserAccount;

public interface UserAccountMapper {
    int deleteByPrimaryKey(String userName);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(String userName);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}