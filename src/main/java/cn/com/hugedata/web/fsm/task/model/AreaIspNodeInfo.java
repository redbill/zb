package cn.com.hugedata.web.fsm.task.model;

public class AreaIspNodeInfo
{
    private String areaCode;
    private String areaName;
    private String ispName;
    private String ispCode;
    private String selectedNum;
    private String maxAvaNum;

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getIspCode()
    {
        return ispCode;
    }

    public void setIspCode(String ispCode)
    {
        this.ispCode = ispCode;
    }

    public String getSelectedNum()
    {
        return selectedNum;
    }

    public void setSelectedNum(String selectedNum)
    {
        this.selectedNum = selectedNum;
    }

    public String getMaxAvaNum()
    {
        return maxAvaNum;
    }

    public void setMaxAvaNum(String maxAvaNum)
    {
        this.maxAvaNum = maxAvaNum;
    }

    public AreaIspNodeInfo(String areaCode, String ispCode, String selectedNum,
            String maxAvaNum)
    {
        super();
        this.areaCode = areaCode;
        this.ispCode = ispCode;
        this.selectedNum = selectedNum;
        this.maxAvaNum = maxAvaNum;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getIspName()
    {
        return ispName;
    }

    public void setIspName(String ispName)
    {
        this.ispName = ispName;
    }

    public AreaIspNodeInfo(String areaCode, String areaName, String ispName,
            String ispCode, String selectedNum, String maxAvaNum)
    {
        super();
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.ispName = ispName;
        this.ispCode = ispCode;
        this.selectedNum = selectedNum;
        this.maxAvaNum = maxAvaNum;
    }

    public AreaIspNodeInfo()
    {
        // TODO Auto-generated constructor stub
    }

}
