/**  
 * @Title:  AppTaskInfoServiceImpl.java
 * @Package cn.com.hugedata.web.fsm.task.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月25日 下午5:19:13
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

import cn.com.hugedata.web.fsm.common.vo.ResultVO;
import cn.com.hugedata.web.fsm.task.dao.AppTaskInfoMapper;
import cn.com.hugedata.web.fsm.task.model.AppTaskInfo;
import cn.com.hugedata.web.fsm.task.service.AppTaskInfoService;

/**
 * @ClassName: AppTaskInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianQingzhao
 * @date 2015年8月25日 下午5:19:13
 *
 */
@Service("appTaskInfoService")
public class AppTaskInfoServiceImpl implements AppTaskInfoService
{
    @Resource
    private AppTaskInfoMapper appTaskInfoMapper;

    public void setAppTaskInfoMapper(AppTaskInfoMapper appTaskInfoMapper)
    {
        this.appTaskInfoMapper = appTaskInfoMapper;
    }

    /*
     * (非 Javadoc) <p>Title: getMySameNameTask</p> <p>Description: </p>
     * 
     * @param taskinfo
     * 
     * @return
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppTaskInfoService#getMySameNameTask
     * (cn.com.hugedata.web.fsm.task.model.AppTaskInfo)
     */
    public List<AppTaskInfo> getMySameNameTask(AppTaskInfo taskinfo)
    {
        // TODO Auto-generated method stub
        return this.appTaskInfoMapper.getMySameNameTask(taskinfo);
    }

    /*
     * (非 Javadoc) <p>Title: addAppTask</p> <p>Description: </p>
     * 
     * @param taskinfo
     * 
     * @return
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppTaskInfoService#addAppTask(cn
     * .com.hugedata.web.fsm.task.model.AppTaskInfo)
     */
    public int addAppTask(AppTaskInfo taskinfo)
    {
        // TODO Auto-generated method stub
        return this.appTaskInfoMapper.insertSelective(taskinfo);
    }

    /*
     * (非 Javadoc) <p>Title: update</p> <p>Description: </p>
     * 
     * @param taskinfo
     * 
     * @return
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppTaskInfoService#update(cn.com
     * .hugedata.web.fsm.task.model.AppTaskInfo)
     */
    public int update(AppTaskInfo taskinfo)
    {
        // TODO Auto-generated method stub
        return this.appTaskInfoMapper.updateByPrimaryKeySelective(taskinfo);
    }

    /*
     * (非 Javadoc) <p>Title: getMyTaskList</p> <p>Description: </p>
     * 
     * @param taskCondition
     * 
     * @return
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppTaskInfoService#getMyTaskList
     * (cn.com.hugedata.web.fsm.task.model.AppTaskInfo)
     */
    public ResultVO getMyTaskList(AppTaskInfo taskCondition)
    {
        List<AppTaskInfo> myTaskList = appTaskInfoMapper
                .getMyTaskList(taskCondition);
        ResultVO res = new ResultVO();
        res.setOk(true);
        res.setResObj(myTaskList);
        return res;
    }

    /*
     * (非 Javadoc) <p>Title: getTaskInfoByUserId</p> <p>Description: </p>
     * 
     * @param userId
     * 
     * @return
     * 
     * @see
     * cn.com.hugedata.web.fsm.task.service.AppTaskInfoService#getTaskInfoByUserId
     * (int)
     */
    public List<AppTaskInfo> getTaskInfoByUserId(int userId)
    {
        return appTaskInfoMapper.getTaskInfoByUserId(userId);
    }

}
