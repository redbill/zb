package cn.com.hugedata.web.fsm.task.service;

import java.util.List;

import cn.com.hugedata.web.fsm.task.model.AppInfo;
import cn.com.hugedata.web.fsm.user.model.UserInfo;

public interface AppInfoService
{

    List<AppInfo> getMyAppLists(UserInfo myInfo);

    /**
     * @Title: getById
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param valueOf
     * @return
     * @throws
     */
    AppInfo getById(Integer valueOf);

}
