package cn.com.hugedata.web.fsm.task.model;

import java.util.List;

public class AppGroup
{
    private Integer id;

    private String nodeId;

    private String groupName;

    private Integer groupType;

    private List<AreaIspNodeInfo> nodes;

    public List<AreaIspNodeInfo> getNodes()
    {
        return nodes;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNodeId()
    {
        return nodeId;
    }

    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getGroupType()
    {
        return groupType;
    }

    public void setGroupType(Integer groupType)
    {
        this.groupType = groupType;
    }

    /**
     * @Title: setNodes
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author QianQingzhao
     * @param nodes
     * @throws
     */
    public void setNodes(List<AreaIspNodeInfo> nodes)
    {
        this.nodes = nodes;
    }
}