/**  
 * @Title:  AppUserGroupService.java
 * @Package cn.com.hugedata.web.fsm.task.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月25日 上午9:59:09
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.com.hugedata.web.fsm.task.service;

import cn.com.hugedata.web.fsm.task.model.AppUserGroup;

/**
 * @ClassName: AppUserGroupService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月25日 上午9:59:09
 *
 */
public interface AppUserGroupService
{

    /**
     * @Title: save
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param appUserGroup
     * @throws
     */
    int save(AppUserGroup appUserGroup);

    /**
     * @Title: getMyUserGroupByGroupId
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param userGroup
     * @return
     * @throws
     */
    AppUserGroup getMyUserGroupByGroupId(AppUserGroup userGroup);

    /**
     * @Title: removeById
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param id
     * @throws
     */
    void removeById(Integer id);

}
