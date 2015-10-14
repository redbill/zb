package cn.com.hugedata.web.fsm.task.dao;

import java.util.List;

import cn.com.hugedata.web.fsm.task.model.AppInfo;
import cn.com.hugedata.web.fsm.user.model.UserInfo;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

	List<AppInfo> getMyAppLists(UserInfo myInfo);
}