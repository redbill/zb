/**  
 * @Title:  JsonResultVO.java
 * @Package com.hugedata.mam.portal.common.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author qianqingzhao
 * @date  2015-6-15 上午10:07:05
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.bianlide.zb.common.vo;

/**
 * @ClassName: JsonResultVO
 * @Description: 前台ajax请求处理结果，统一使用该VO的json 字符串返回给前台。
 * @author qianqingzhao
 * @date 2015-6-15 上午10:07:05
 * 
 */
public class JsonResultVO
{
    String isOK = "false";
    String msg = "";
    Object jsonData = null;

    public String getIsOK()
    {
        return isOK;
    }

    public void setIsOK(String isOK)
    {
        this.isOK = isOK;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getJsonData()
    {
        return jsonData;
    }

    public void setJsonData(Object jsonData)
    {
        this.jsonData = jsonData;
    }

    public void setIsOKToTrue()
    {
        this.isOK = "true";
    }

    public void setIsOKToFalse()
    {
        this.isOK = "false";
    }

}
