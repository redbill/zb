/**  
 * @Title:  AppMonitoringPointTaskMapService.java
 * @Package cn.com.hugedata.web.fsm.task.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月25日 下午7:48:24
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.com.hugedata.web.fsm.task.service;

import java.util.List;

import cn.com.hugedata.web.fsm.task.model.AppMonitoringPointTaskMap;

/**
 * @ClassName: AppMonitoringPointTaskMapService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月25日 下午7:48:24
 *
 */
public interface AppMonitoringPointTaskMapService
{

    /**
     * @Title: insertPointTaskMapList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param listMap
     * @throws
     */
    void insertPointTaskMapList(List<AppMonitoringPointTaskMap> listMap);

}
