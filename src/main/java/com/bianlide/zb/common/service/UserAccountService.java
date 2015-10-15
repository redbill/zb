/**  
 * @Title:  UserAccountService.java
 * @Package com.bianlide.zb.common.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年10月15日 下午4:22:53
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.common.service;

import com.bianlide.zb.common.model.UserAccount;

/**
 * @ClassName: UserAccountService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年10月15日 下午4:22:53
 *
 */

public interface UserAccountService
{

    /**
     * @Title: loginAccount
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param userName
     * @param password
     * @return
     * @throws
     */
    UserAccount loginAccount(String userName, String password);

}
