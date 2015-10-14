/**  
 * @Title:  AppTaskInfoService.java
 * @Package cn.com.hugedata.web.fsm.task.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月25日 下午5:16:55
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

import cn.com.hugedata.web.fsm.common.vo.ResultVO;
import cn.com.hugedata.web.fsm.task.model.AppTaskInfo;

/**
 * @ClassName: AppTaskInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月25日 下午5:16:55
 *
 */
public interface AppTaskInfoService
{

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
     * @Title: addAppTask
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param taskinfo
     * @return
     * @throws
     */
    int addAppTask(AppTaskInfo taskinfo);

    /**
     * @Title: update
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param taskinfo
     * @throws
     */
    int update(AppTaskInfo taskinfo);

    /**
     * @Title: getMyTaskList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param taskCondition
     * @return
     * @throws
     */
    ResultVO getMyTaskList(AppTaskInfo taskCondition);

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
