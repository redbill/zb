/**  
 * @Title:  UserNodeGroupController.java
 * @Package cn.com.hugedata.web.fsm.task.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author QianQingzhao
 * @date  2015年8月24日 下午7:01:47
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.com.hugedata.web.fsm.task.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.hugedata.web.fsm.common.vo.JsonResultVO;
import cn.com.hugedata.web.fsm.task.model.AppGroup;
import cn.com.hugedata.web.fsm.task.model.AppUserGroup;
import cn.com.hugedata.web.fsm.task.model.AreaIspNodeInfo;
import cn.com.hugedata.web.fsm.task.service.AppGroupService;
import cn.com.hugedata.web.fsm.task.service.AppUserGroupService;
import cn.com.hugedata.web.fsm.user.model.UserInfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: UserNodeGroupController
 * @Description: 用户节点组控制类
 * @author QianQingzhao
 * @date 2015年8月24日 下午7:01:47
 *
 */
@Controller
@RequestMapping("/user{userId}")
public class UserNodeGroupController
{
    private static Logger logger = LoggerFactory
            .getLogger(UserNodeGroupController.class);
    private AppGroupService appGroupService;

    private AppUserGroupService appUserGroupService;

    public void setAppUserGroupService(AppUserGroupService appUserGroupService)
    {
        this.appUserGroupService = appUserGroupService;
    }

    public void setAppGroupService(AppGroupService appGroupService)
    {
        this.appGroupService = appGroupService;
    }

    @RequestMapping(value = "/userNodeGroups", params = "action=new")
    public String addNewUserGroup(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        JsonResultVO result = new JsonResultVO();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        try
        {
            String newUserGroupName = request.getParameter("userGroupName");
            if (newUserGroupName == null || "".equals(newUserGroupName.trim()))
            {
                throw new Exception("用户节点组名称为空");
            }
            String selectedDatas = request.getParameter("selectedDatas");
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
                    "UserInfo");
            // 判断是否有重名用户组
            AppUserGroup checkSameName = new AppUserGroup();
            checkSameName.setGroupName(newUserGroupName);
            checkSameName.setUserId(userInfo.getId());
            if (appGroupService.getMyUserGroupByGroupName(checkSameName) != null)
            {
                throw new Exception("用户节点组名称重名");
            }

            String[] selectedNode = selectedDatas.split(",");
            StringBuilder nodeString = new StringBuilder();
            for (int i = 0; i < selectedNode.length; i++)
            {// "1-11-3702" 个数 运营商
             // 城市

                // "1_1_3702_11" 个数 最大个数 城市 运营商
                if (selectedNode[i].trim().length() > 1)
                {
                    nodeString.append(selectedNode[i].split("_")[2])
                            .append(selectedNode[i].split("_")[3])
                            .append(selectedNode[i].split("_")[0]).append("|");
                }

            }

            AppGroup appGroup = new AppGroup();
            appGroup.setGroupName(newUserGroupName);
            appGroup.setNodeId(nodeString.toString());
            appGroupService.save(appGroup);

            AppUserGroup appUserGroup = new AppUserGroup();
            appUserGroup.setGroupId(appGroup.getId());
            appUserGroup.setUserId(userInfo.getId());
            appUserGroupService.save(appUserGroup);

            result.setIsOK("true");
            pw.println(JSONObject.toJSONString(result));
            pw.close();

            return null;
        }
        catch (Exception e)
        {
            result.setIsOK("false");
            result.setMsg(e.getMessage());
            logger.info(e.getMessage());
            pw.println(JSONObject.toJSONString(result));
            pw.close();
        }

        return null;
    }

    @RequestMapping(value = "/userNodeGroups")
    public String getMyUserGroups(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        JsonResultVO res = new JsonResultVO();
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
                "UserInfo");
        AppUserGroup appUserGroup = new AppUserGroup();
        appUserGroup.setUserId(userInfo.getId());
        response.setContentType("application/json;charset=utf-8");//
        PrintWriter pw = response.getWriter();
        List<AppGroup> appGroupInfos = null;
        try
        {

            try
            {
                appGroupInfos = appGroupService.getMyUserGroups(appUserGroup);
            }
            catch (Exception e)
            {
                throw new Exception("获取用户节点组数据异常");
            }

            if (appGroupInfos != null && appGroupInfos.size() > 0)
            {
                for (AppGroup appGroup : appGroupInfos)
                {
                    String nodeIds = appGroup.getNodeId();
                    if (nodeIds != null && nodeIds.trim().length() > 1)
                    {
                        String[] nodeArr = nodeIds.trim().split("\\|");
                        if (nodeArr != null && nodeArr.length > 0)
                        {
                            List<AreaIspNodeInfo> nodes = new ArrayList<AreaIspNodeInfo>();
                            for (String nodeStr : nodeArr)
                            {
                                if (!"".equals(nodeStr.trim()))
                                {
                                    String areaCode = nodeStr.substring(0, 4);
                                    String ispCode = nodeStr.substring(4, 6);
                                    String selectedNum = nodeStr.substring(6);
                                    ResourceBundle rbcity = ResourceBundle
                                            .getBundle("isp.provincecity");// 绑定资源文件
                                    ResourceBundle rbISP = ResourceBundle
                                            .getBundle("isp.isp");// 绑定资源文件
                                    String cityname1 = rbcity
                                            .getString(areaCode);// 获取城市名称
                                    String cityname = cityname1.substring(0,
                                            cityname1.indexOf("市"));
                                    String ispName = rbISP.getString(ispCode);// 获取运营商名称
                                    if (ispName.indexOf("中国") > -1
                                            && ispName.length() == 4)
                                    {
                                        ispName = ispName.substring(2, 4);
                                    }
                                    AreaIspNodeInfo curNode = new AreaIspNodeInfo();
                                    curNode.setAreaCode(areaCode);
                                    curNode.setIspCode(ispCode);
                                    curNode.setAreaName(cityname);
                                    curNode.setIspName(ispName);
                                    curNode.setSelectedNum(selectedNum);
                                    nodes.add(curNode);
                                }

                            }
                            appGroup.setNodes(nodes);

                        }
                    }
                }
            }

        }
        catch (Exception e)
        {
            res.setMsg(e.getMessage());
            pw.println(JSONArray.toJSONString(res));
            return null;
        }
        res.setIsOK("true");
        res.setJsonData(appGroupInfos);
        pw.println(JSONArray.toJSONString(res));
        return null;
    }

    @RequestMapping(value = "/delUserGroup")
    public String delUserGroup(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        JsonResultVO result = new JsonResultVO();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        try
        {
            String groupId = request.getParameter("groupId");
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
                    "UserInfo");
            AppUserGroup userGroup = new AppUserGroup();
            userGroup.setUserId(userInfo.getId());
            userGroup.setGroupId(Integer.valueOf(groupId));
            userGroup = this.appUserGroupService
                    .getMyUserGroupByGroupId(userGroup);
            if (userGroup != null)
            {
                this.appUserGroupService.removeById(userGroup.getId());
                this.appGroupService.removeById(userGroup.getGroupId());
            }
            result.setIsOK("true");

            pw.println(JSONObject.toJSONString(result));
            pw.close();

            return null;
        }
        catch (Exception e)
        {
            result.setIsOK("false");
            result.setMsg(e.getMessage());
            pw.println(JSONObject.toJSONString(result));
            pw.close();
        }

        return null;
    }

}
