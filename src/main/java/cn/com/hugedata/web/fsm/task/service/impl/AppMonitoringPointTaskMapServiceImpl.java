/**  
 * @Title:  AppMonitoringPointTaskMapServiceImpl.java
 * @Package cn.com.hugedata.web.fsm.task.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月25日 下午7:48:57
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

import cn.com.hugedata.web.fsm.task.dao.AppMonitoringPointTaskMapMapper;
import cn.com.hugedata.web.fsm.task.model.AppMonitoringPointTaskMap;
import cn.com.hugedata.web.fsm.task.service.AppMonitoringPointTaskMapService;

/**
 * @ClassName: AppMonitoringPointTaskMapServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月25日 下午7:48:57
 *
 */
@Service("appMonitoringPointTaskMapService")
public class AppMonitoringPointTaskMapServiceImpl implements
        AppMonitoringPointTaskMapService
{
    @Resource
    private AppMonitoringPointTaskMapMapper appMonitoringPointTaskMapMapper;

    public void setAppMonitoringPointTaskMapMapper(
            AppMonitoringPointTaskMapMapper appMonitoringPointTaskMapMapper)
    {
        this.appMonitoringPointTaskMapMapper = appMonitoringPointTaskMapMapper;
    }

    /*
     * (非 Javadoc) <p>Title: insertPointTaskMapList</p> <p>Description: </p>
     * 
     * @param listMap
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppMonitoringPointTaskMapService
     * #insertPointTaskMapList(java.util.List)
     */
    public void insertPointTaskMapList(
            List<AppMonitoringPointTaskMap> pointTaskMapList)
    {
        // TODO Auto-generated method stub
        if (null != pointTaskMapList && 0 != pointTaskMapList.size())
        {
            for (AppMonitoringPointTaskMap entity : pointTaskMapList)
            {
                appMonitoringPointTaskMapMapper.insert(entity);
            }
        }

    }

}
