package cn.com.hugedata.web.fsm.common.service;

import cn.com.hugedata.web.fsm.user.model.UserInfo;


/**
 * @ClassName: SignUpRequestBean
 * @Description: 注册和登录时使用此类进行交换信息
 * @author Dangzhang
 * @date 2013-3-20 下午2:22:02
 * 
 */
public class SignUpRequestBean
{
    /* 注册成功后的UserInfo实体 */
    private UserInfo userInfo;
    /* 注册失败，错误信息 */
    private String msg;
    /* 是否注册成功 */
    private boolean isOK;
    /* 登录状态 */
    private int loginStatus;

    /**
     * @return userInfo
     */
    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    /**
     * @param userInfo
     *            要设置的 userInfo
     */
    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }

    /**
     * @return msg
     */
    public String getMsg()
    {
        return msg;
    }

    /**
     * @param msg
     *            要设置的 msg
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    /**
     * @return isOK
     */
    public boolean isOK()
    {
        return isOK;
    }

    /**
     * @param isOK
     *            要设置的 isOK
     */
    public void setOK(boolean isOK)
    {
        this.isOK = isOK;
    }

    /**
     * @return loginStatus
     */
    public int getLoginStatus()
    {
        return loginStatus;
    }

    /**
     * @param loginStatus
     *            要设置的 loginStatus
     */
    public void setLoginStatus(int loginStatus)
    {
        this.loginStatus = loginStatus;
    }

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 带所有参数的构造函数
     * 
     * @author Dangzhang
     * @param userInfo
     * @param msg
     * @param isOK
     */
    public SignUpRequestBean(UserInfo userInfo, String msg, boolean isOK)
    {
        super();
        this.userInfo = userInfo;
        this.msg = msg;
        this.isOK = isOK;
    }

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 无参构造函数
     */
    public SignUpRequestBean()
    {

    }

    /*
     * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "SignUpRequestBean [userInfo=" + userInfo + ", msg=" + msg
                + ", isOK=" + isOK + "]";
    }

}
