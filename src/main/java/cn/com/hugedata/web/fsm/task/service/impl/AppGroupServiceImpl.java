/**  
 * @Title:  AppGroupServiceImpl.java
 * @Package cn.com.hugedata.web.fsm.task.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月24日 下午7:57:52
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.com.hugedata.web.fsm.task.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.hugedata.web.fsm.task.dao.AppGroupMapper;
import cn.com.hugedata.web.fsm.task.model.AppGroup;
import cn.com.hugedata.web.fsm.task.model.AppUserGroup;
import cn.com.hugedata.web.fsm.task.service.AppGroupService;

/**
 * @ClassName: AppGroupServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月24日 下午7:57:52
 *
 */
@Service("appGroupService")
public class AppGroupServiceImpl implements AppGroupService
{
    @Resource
    private AppGroupMapper appGroupMapper;

    public void setAppGroupMapper(AppGroupMapper appGroupMapper)
    {
        this.appGroupMapper = appGroupMapper;
    }

    /*
     * (非 Javadoc) <p>Title: getMyUserGroupByGroupName</p> <p>Description: </p>
     * 
     * @param checkSameName
     * 
     * @return
     * 
     * @see cn.com.hugedata.web.fsm.task.service.AppGroupService#
     * getMyUserGroupByGroupName
     * (cn.com.hugedata.web.fsm.task.model.AppUserGroup)
     */
    public AppGroup getMyUserGroupByGroupName(AppUserGroup userGroup)
    {
        List<AppGroup> groups = appGroupMapper.getMyUserGroups(userGroup);
        if (groups != null && groups.size() > 0)
        {
            for (AppGroup group : groups)
            {
                if (group != null && group.getGroupName() != null)
                {
                    if (group
                            .getGroupName()
                            .trim()
                            .equals(userGroup.getGroupName() == null ? ""
                                    : userGroup.getGroupName()))
                    {
                        return group;
                    }
                }
            }
        }
        return null;
    }

    /*
     * (非 Javadoc) <p>Title: save</p> <p>Description: </p>
     * 
     * @param appGroup
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppGroupService#save(cn.com.hugedata
     * .web.fsm.task.model.AppGroup)
     */
    public int save(AppGroup appGroup)
    {
        // TODO Auto-generated method stub
        return appGroupMapper.insert(appGroup);
    }

    public List<AppGroup> getMyUserGroups(AppUserGroup appUserGroup)
    {
        // TODO Auto-generated method stub
        return appGroupMapper.getMyUserGroups(appUserGroup);
    }

    /*
     * (非 Javadoc) <p>Title: removeById</p> <p>Description: </p>
     * 
     * @param groupId
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppGroupService#removeById(java.
     * lang.Integer)
     */
    public void removeById(Integer groupId)
    {
        // TODO Auto-generated method stub
        this.appGroupMapper.deleteByPrimaryKey(groupId);
    }

}
