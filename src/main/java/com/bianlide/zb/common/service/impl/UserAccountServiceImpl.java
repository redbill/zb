/**  
 * @Title:  UserAccountServiceImpl.java
 * @Package com.bianlide.zb.common.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年10月15日 下午4:32:21
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.common.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bianlide.zb.common.dao.UserAccountMapper;
import com.bianlide.zb.common.model.UserAccount;
import com.bianlide.zb.common.service.UserAccountService;

/**
 * @ClassName: UserAccountServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年10月15日 下午4:32:21
 *
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService
{

    @Resource
    private UserAccountMapper userAccountMapper;

    /*
     * (非 Javadoc) <p>Title: loginAccount</p> <p>Description: </p>
     * 
     * @param userName
     * 
     * @param password
     * 
     * @return
     * 
     * @see
     * com.bianlide.zb.common.service.UserAccountService#loginAccount(java.lang
     * .String, java.lang.String)
     */
    public UserAccount loginAccount(String userName, String password)
    {
        // TODO Auto-generated method stub
        return this.userAccountMapper.selectByPrimaryKey(userName);
    }

}
