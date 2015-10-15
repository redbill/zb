package com.bianlide.zb.common.vo;

public class ResultVO implements java.io.Serializable
{
    boolean ok;
    String errorCode;
    String errorMsg;
    Object resObj;

    public void setOk(boolean isOK)
    {
        this.ok = isOK;
    }

    public boolean isOk()
    {
        return ok;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public Object getResObj()
    {
        return resObj;
    }

    public void setResObj(Object resObj)
    {
        this.resObj = resObj;
    }

    public ResultVO(boolean isOK, String errorCode, String errorMsg)
    {
        super();
        this.ok = isOK;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ResultVO(boolean isOK, String errorCode, String errorMsg,
            Object resObj)
    {
        super();
        this.ok = isOK;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.resObj = resObj;
    }

    public ResultVO()
    {
        // TODO Auto-generated constructor stub
    }

}
