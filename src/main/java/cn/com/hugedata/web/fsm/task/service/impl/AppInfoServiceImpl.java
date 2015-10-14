package cn.com.hugedata.web.fsm.task.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.hugedata.web.fsm.task.dao.AppInfoMapper;
import cn.com.hugedata.web.fsm.task.model.AppInfo;
import cn.com.hugedata.web.fsm.task.service.AppInfoService;
import cn.com.hugedata.web.fsm.user.model.UserInfo;

@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService
{
    @Resource
    private AppInfoMapper appInfoMapper;

    public void setAppInfoMapper(AppInfoMapper appInfoMapper)
    {
        this.appInfoMapper = appInfoMapper;
    }

    public List<AppInfo> getMyAppLists(UserInfo myInfo)
    {
        // TODO Auto-generated method stub
        return this.appInfoMapper.getMyAppLists(myInfo);
    }

    /*
     * (非 Javadoc) <p>Title: getById</p> <p>Description: </p>
     * 
     * @param valueOf
     * 
     * @return
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppInfoService#getById(java.lang
     * .Integer)
     */
    public AppInfo getById(Integer valueOf)
    {
        // TODO Auto-generated method stub
        return this.appInfoMapper.selectByPrimaryKey(valueOf);
    }

}
