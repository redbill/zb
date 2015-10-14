/**  
 * @Title:  AppGroupService.java
 * @Package cn.com.hugedata.web.fsm.task.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月24日 下午7:47:05
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.com.hugedata.web.fsm.task.service;

import java.util.List;

import cn.com.hugedata.web.fsm.task.model.AppGroup;
import cn.com.hugedata.web.fsm.task.model.AppUserGroup;

/**
 * @ClassName: AppGroupService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月24日 下午7:47:05
 *
 */
public interface AppGroupService
{

    /**
     * @Title: getMyUserGroupByGroupName
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param checkSameName
     * @return
     * @throws
     */
    AppGroup getMyUserGroupByGroupName(AppUserGroup checkSameName);

    /**
     * @Title: save
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param appGroup
     * @throws
     */
    int save(AppGroup appGroup);

    /**
     * @Title: getMyUserGroups
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param appUserGroup
     * @return
     * @throws
     */
    List<AppGroup> getMyUserGroups(AppUserGroup appUserGroup);

    /**
     * @Title: removeById
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param groupId
     * @throws
     */
    void removeById(Integer groupId);

}
