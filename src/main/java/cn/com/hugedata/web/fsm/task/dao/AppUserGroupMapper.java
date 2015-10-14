package cn.com.hugedata.web.fsm.task.dao;

import cn.com.hugedata.web.fsm.task.model.AppUserGroup;

public interface AppUserGroupMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(AppUserGroup record);

    int insertSelective(AppUserGroup record);

    AppUserGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppUserGroup record);

    int updateByPrimaryKey(AppUserGroup record);

    /**
     * @Title: getMyUserGroupByGroupId
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param userGroup
     * @return
     * @throws
     */
    AppUserGroup getMyUserGroupByGroupId(AppUserGroup userGroup);

}