package cn.com.hugedata.web.fsm.task.dao;

import java.util.List;

import cn.com.hugedata.web.fsm.task.model.AppTaskInfo;

public interface AppTaskInfoMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(AppTaskInfo record);

    int insertSelective(AppTaskInfo record);

    AppTaskInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppTaskInfo record);

    int updateByPrimaryKey(AppTaskInfo record);

    /**
     * @Title: getMySameNameTask
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param taskinfo
     * @return
     * @throws
     */
    List<AppTaskInfo> getMySameNameTask(AppTaskInfo taskinfo);

    /**
     * @Title: getMyTaskList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param taskCondition
     * @return
     * @throws
     */
    List<AppTaskInfo> getMyTaskList(AppTaskInfo taskCondition);

    /**
     * @Title: getTaskInfoByUserId
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param userId
     * @return
     * @throws
     */
    List<AppTaskInfo> getTaskInfoByUserId(int userId);
}