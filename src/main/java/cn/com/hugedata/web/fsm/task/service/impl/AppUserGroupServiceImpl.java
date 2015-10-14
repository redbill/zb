/**  
 * @Title:  AppUserGroupServiceImpl.java
 * @Package cn.com.hugedata.web.fsm.task.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月25日 上午10:04:32
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.com.hugedata.web.fsm.task.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.hugedata.web.fsm.task.dao.AppUserGroupMapper;
import cn.com.hugedata.web.fsm.task.model.AppUserGroup;
import cn.com.hugedata.web.fsm.task.service.AppUserGroupService;

/**
 * @ClassName: AppUserGroupServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月25日 上午10:04:32
 *
 */
@Service("appUserGroupService")
public class AppUserGroupServiceImpl implements AppUserGroupService
{

    @Resource
    private AppUserGroupMapper appUserGroupMapper;

    public void setAppUserGroupMapper(AppUserGroupMapper appUserGroupMapper)
    {
        this.appUserGroupMapper = appUserGroupMapper;
    }

    /*
     * (非 Javadoc) <p>Title: save</p> <p>Description: </p>
     * 
     * @param appUserGroup
     * 
     * @return
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppUserGroupService#save(cn.com.
     * hugedata.web.fsm.task.model.AppUserGroup)
     */
    public int save(AppUserGroup appUserGroup)
    {
        // TODO Auto-generated method stub
        return this.appUserGroupMapper.insert(appUserGroup);
    }

    /*
     * (非 Javadoc) <p>Title: getMyUserGroupByGroupId</p> <p>Description: </p>
     * 
     * @param userGroup
     * 
     * @return
     * 
     * @see cn.com.hugedata.web.fsm.task.service.AppUserGroupService#
     * getMyUserGroupByGroupId(cn.com.hugedata.web.fsm.task.model.AppUserGroup)
     */
    public AppUserGroup getMyUserGroupByGroupId(AppUserGroup userGroup)
    {
        // TODO Auto-generated method stub
        return this.appUserGroupMapper.getMyUserGroupByGroupId(userGroup);
    }

    /*
     * (非 Javadoc) <p>Title: removeById</p> <p>Description: </p>
     * 
     * @param id
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppUserGroupService#removeById(java
     * .lang.Integer)
     */
    public void removeById(Integer id)
    {
        // TODO Auto-generated method stub
        this.appUserGroupMapper.deleteByPrimaryKey(id);
    }

}
