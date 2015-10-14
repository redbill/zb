package cn.com.hugedata.web.fsm.task.dao;

import cn.com.hugedata.web.fsm.task.model.AppMonitoringPointTaskMap;

public interface AppMonitoringPointTaskMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppMonitoringPointTaskMap record);

    int insertSelective(AppMonitoringPointTaskMap record);

    AppMonitoringPointTaskMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppMonitoringPointTaskMap record);

    int updateByPrimaryKey(AppMonitoringPointTaskMap record);
}