package cn.com.hugedata.web.fsm.task.dao;

import java.util.List;

import cn.com.hugedata.web.fsm.task.model.AppGroup;
import cn.com.hugedata.web.fsm.task.model.AppUserGroup;

public interface AppGroupMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(AppGroup record);

    int insertSelective(AppGroup record);

    AppGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppGroup record);

    int updateByPrimaryKey(AppGroup record);

    /**
     * @Title: getMyUserGroups
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param userGroup
     * @return
     * @throws
     */
    List<AppGroup> getMyUserGroups(AppUserGroup userGroup);
}