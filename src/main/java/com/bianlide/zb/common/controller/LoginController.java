package com.bianlide.zb.common.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.hugedata.util.ValidationUtil;
import cn.com.hugedata.web.fsm.common.service.LoginService;
import cn.com.hugedata.web.fsm.common.service.SignUpRequestBean;
import cn.com.hugedata.web.fsm.user.model.UserInfo;

import com.alibaba.fastjson.JSON;
import com.bianlide.zb.cms.service.CmsService;
import com.bianlide.zb.common.model.UserAccount;
import com.bianlide.zb.common.service.UserAccountService;
import com.bianlide.zb.common.vo.JsonResultVO;

@Controller
public class LoginController
{

    private LoginService loginService;

    private UserAccountService userAccountService;

	private static Logger logger = LoggerFactory
			.getLogger(LoginController.class);

    public void setLoginService(LoginService loginService)
    {
        this.loginService = loginService;
    }

    public void setUserAccountService(UserAccountService userAccountService)
    {
        this.userAccountService = userAccountService;
    }

    @RequestMapping(
    { "login" })
    public String nationPerfWaterf(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "login";
    }

    @RequestMapping(
    { "index" })
    public String index(HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        return "index";
    }

    @RequestMapping(
    { "category" })
    public String category(HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        return "category";
    }
    
    @RequestMapping(
    { "mgr/index" })
    public String mgrIndex(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "mgrIndex";
    }

    @RequestMapping(
    { "mgr/priceList" })
    public String priceList(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "priceList";
    }

    @RequestMapping(
    { "mgr/addArticle" })
    public String addArticle(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "addArticle";
    }

    @RequestMapping(
    { "mgr/articleList" })
    public String articleList(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "articleList";
    }

    @RequestMapping(
    { "mgr/upLoadPriceFile" })
    public String upLoadPriceFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "upLoadPriceFile";
    }

    @RequestMapping(
    { "mgr/importPriceData" })
    public String importPriceData(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "importPriceData";
    }

    @RequestMapping(
    { "mgr/updatePriceData" })
    public String updatePriceData(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        return "updatePriceData";
    }

    @RequestMapping(
    { "loginOut" })
    public String loginOut(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {

        PrintWriter pw = null;
        response.setContentType("application/json;charset=utf-8");
        pw = response.getWriter();
        JsonResultVO jsonRes = new JsonResultVO();
        try
        {
            jsonRes.setIsOKToTrue();
            request.getSession().setAttribute("userAccount", null);

            pw.write(JSON.toJSONString(jsonRes));
            pw.flush();
            return null;
        }
        catch (Exception e)
        {
            logger.error("loginOut error : " + e.getMessage());
            jsonRes.setMsg(e.getMessage());
            pw.write(JSON.toJSONString(jsonRes));
            pw.flush();
            return null;
        }
        finally
        {
            pw.close();
        }
    }

    @RequestMapping(
    { "loginAccount" })
    public String loginAccount(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        PrintWriter pw = null;
        response.setContentType("application/json;charset=utf-8");
        pw = response.getWriter();
        JsonResultVO jsonRes = new JsonResultVO();
        try
        {
            if (userName == null || password == null)
            {
                throw new Exception("用户名或密码为空");

            }

            // 去数据库做校验
            UserAccount userAccount = this.userAccountService.loginAccount(
                    userName, password);

            //
            if (userAccount == null)
            {
                throw new Exception("用户名不存在");
            }
            else
            {
                if (!userAccount.getPassword().trim().equals(password.trim()))
                {
                    throw new Exception("密码不正确");
                }
                jsonRes.setIsOKToTrue();
                request.getSession().setAttribute("userAccount", userAccount);
            }

            pw.write(JSON.toJSONString(jsonRes));
            pw.flush();
            return null;
        }
        catch (Exception e)
        {
            logger.error("loginAccount error : " + e.getMessage());
            jsonRes.setMsg(e.getMessage());
            pw.write(JSON.toJSONString(jsonRes));
            pw.flush();
            return null;
        }
        finally
        {
            pw.close();
        }
    }

    @RequestMapping(
    { "loginByEmail" })
    public String loginByEmail(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        response.setContentType("application/json;charset=utf-8");//
        // 将相应的类型设为json和html都可以
        SignUpRequestBean signUpRequestBean = SignInEmail(request);
        String msgString = "";
        String defRedirectUrlStr = "";
        if (null == signUpRequestBean)
        {
            msgString = "登录失败：内部错误。";// userinfo.signup.FailInterError
                                     // "登录失败：内部错误。"
        }
        else if (!signUpRequestBean.isOK())
        {
            msgString = signUpRequestBean.getMsg();
        }
        else
        {
            // 登录成功
            UserInfo userInfo = signUpRequestBean.getUserInfo();
            // 登录成功后设置默认跳转页面链接 added by qqz 0806
            StringBuilder defRedirectUrlSB = new StringBuilder("user");
            defRedirectUrlSB.append(userInfo.getId());
            defRedirectUrlStr = defRedirectUrlSB.toString();

            if (null == userInfo)
            {// 神呐应该不会运行到这里，否则，这不科学啊
             // msgString =
             // LocaleConfig.getLocale().getString(
             // "userinfo.signup.failUnscientific");//
             // userinfo.signup.failUnscientific
             // // "登录失败：这不科学啊。"
            }
            else
            {
                // 保存用户到数据库、
                try
                {
                    // userInfo.setLoginstatus(0);
                    // userInfoManager.update(userInfo);
                    // 将用户信息保存到session

                    request.getSession().setAttribute("UserInfo", userInfo);
                    request.getSession().setAttribute("UserId",
                            userInfo.getId());
                    /*
                     * // 将用户套餐信息以及套餐单项保存到session中 List<TuserOrderInfoNew>
                     * tuserOrderInfoNewList = new
                     * ArrayList<TuserOrderInfoNew>(); tuserOrderInfoNewList =
                     * tuserOrderInfoManager
                     * .getUserPackageItemsByUserId(userInfo.getId());
                     * UserPackageItem userPackageItem = new UserPackageItem();
                     * userPackageItem.setUserId(tuserOrderInfoNewList.get(0)
                     * .getUserId());
                     * userPackageItem.setProductId(tuserOrderInfoNewList.get(0)
                     * .getProductId());
                     * 
                     * userPackageItem.setPackageName(tuserOrderInfoNewList.get(0
                     * ) .getPackageName());
                     * userPackageItem.setPackageId(tuserOrderInfoNewList.get(0)
                     * .getPackageId());
                     * userPackageItem.setBeginTime(tuserOrderInfoNewList.get(0)
                     * .getBeginTime());
                     * userPackageItem.setBeginTimeString(DateUtil
                     * .getDateString(
                     * tuserOrderInfoNewList.get(0).getBeginTime(),
                     * "yyyy-MM-dd HH:mm:ss"));
                     * userPackageItem.setEndTime(tuserOrderInfoNewList.get(0)
                     * .getEndTime());
                     * userPackageItem.setEndTimeString(DateUtil.getDateString(
                     * tuserOrderInfoNewList.get(0).getEndTime(),
                     * "yyyy-MM-dd HH:mm:ss"));
                     * userPackageItem.setFeeBill(tuserOrderInfoNewList.get(0)
                     * .getFeeBill());
                     * userPackageItem.setFeeDesc(tuserOrderInfoNewList.get(0)
                     * .getFeeDesc());
                     * userPackageItem.setFee(tuserOrderInfoNewList.get(0)
                     * .getFee());
                     * userPackageItem.setPackageType(tuserOrderInfoNewList
                     * .get(0) .getPackageType()); CollatorComparator comparator
                     * = new CollatorComparator(); TreeMap<String,
                     * PackageItemValue> map = new TreeMap<String,
                     * PackageItemValue>( comparator); String treeKeyString =
                     * new String();
                     * 
                     * for (int i = 0; i < tuserOrderInfoNewList.size(); i++) {
                     * 
                     * PackageItemValue packageItemValue = new
                     * PackageItemValue();
                     * packageItemValue.setItemId(tuserOrderInfoNewList.get(i)
                     * .getItemId());
                     * packageItemValue.setItemName(tuserOrderInfoNewList.get(
                     * i).getItemName());
                     * packageItemValue.setPackageId(tuserOrderInfoNewList
                     * .get(i).getPackageId());
                     * packageItemValue.setItemValue(tuserOrderInfoNewList
                     * .get(i).getItemValue());
                     * packageItemValue.setItemDesc(tuserOrderInfoNewList.get(
                     * i).getItemDesc());
                     * packageItemValue.setFee(tuserOrderInfoNewList.get(i)
                     * .getItemfee());
                     * packageItemValue.setFeeDesc(tuserOrderInfoNewList
                     * .get(i).getItemDesc());
                     * map.put(tuserOrderInfoNewList.get(i).getItemId(),
                     * packageItemValue); }
                     * userPackageItem.setPackageItemValueMap(map);
                     * request.getSession().setAttribute("userPackageItem",
                     * userPackageItem);// 将用户套餐信息存到session中 userPackageItem =
                     * (UserPackageItem) request.getSession()
                     * .getAttribute("userPackageItem");
                     */
                    // ServletContext ContextA = request.getSession()
                    // .getServletContext();
                    // ContextA.setAttribute("session", request.getSession());
                    // if (userPackageItem == null)
                    // {

                    // }
                    // 登录成功后，删除登录出错次数及登录时是否需要使用验证码
                    request.getSession().removeAttribute("nowLoginErrorCount");
                    request.getSession().removeAttribute(
                            "isNeedLoginVerificationCode");

                    try
                    {
                        // qqz UserLoginLogs userLoginLogs = new
                        // UserLoginLogs();
                        //
                        // ClientInformationBean clientInformationBean =
                        // ClientInformation
                        // .getClientInformation(request);
                        // userLoginLogs.setDescription("进行了登录的操作");
                        // userLoginLogs
                        // .setSignInIp(clientInformationBean.getIp());
                        // userLoginLogs.setOperationSystem(clientInformationBean
                        // .getOs());
                        // userLoginLogs.setWebBrowser(clientInformationBean
                        // .getBrowser());
                        // Calendar cal = Calendar.getInstance();//
                        // 使用默认时区和语言环境获得一个日历。
                        // userLoginLogs.setSignInTime(cal.getTime());
                        // userLoginLogs.setUserid(userInfo.getId());
                        //
                        // userLoginLogs.setMemo("1");// 记录登录方式0手机登录 1 邮箱登录
                        // userLoginLogs.setFrom("1");// 记录登录入口0 xmf登录、 1
                        // hugedata
                        // // 登录
                        // userLoginLogs.setClient("0");// 记录登录客户端类型 0 浏览器 1
                        // pc客户端
                        // // 2 android客户端
                        //
                        // // 是否vip的操作
                        // if (userInfo.getVip() != null
                        // && userInfo.getVip().intValue() == 1)
                        // {
                        // userLoginLogs.setVip("1");
                        // }
                        // userLoginLogs.setType("0");//
                        // 日志类型，0登录，1注销登出，2修改资料，3忘记密码重设密码，4任务操作
                        // userLoginLogs
                        // .setCityCode(ClientInformation
                        // .getCityCodeByIp(clientInformationBean
                        // .getIp()));
                        // userLoginLogsManager.save(userLoginLogs);
                        // SendCodeForVip.sendEmailAndTel(userInfo,
                        // userLoginLogs);
                    }
                    catch (Exception e)
                    {
                        logger.error("写入用户操作日志时出错：" + e.getMessage());
                    }

                }
                catch (Exception e)
                {
                    msgString = "登录失败：内部错误。";// userinfo.signup.FailInterError
                                             // "登录失败：内部错误。"
                    logger.debug("登录用户并将用户信息保存到数据库时出错：" + e.toString());
                }

            }

        }

        // 将数据返回
        PrintWriter pw = response.getWriter();
        pw.println("{\"isOK\":\"" + signUpRequestBean.isOK() + "\",\"msg\":\""
                + msgString + "\",\"defRedirectUrlStr\":\"" + defRedirectUrlStr
                + "\"}");
        return null;
    }

    private SignUpRequestBean SignInEmail(HttpServletRequest request)
    {
        SignUpRequestBean signUpRequestBean = new SignUpRequestBean();
        signUpRequestBean.setOK(false);
        signUpRequestBean.setUserInfo(null);
        signUpRequestBean.setMsg("");
        boolean verify = false;
        int MAX_LOGIN_ERROR_COUNT = 3;// 最大允许登录出错的次数，超过这个数字，则必须使用验证码登录
        // 参数定义
        Calendar cal = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endDate = sdf.format(cal.getTime());// 当前日期 //
        String verificationCode = (String) request.getSession().getAttribute(
                "verificationCode");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String verificationCodeInRequest = request
                .getParameter("verificationCode");
        String memo = request.getParameter("memo");// 如果为Email注册
        String login_status = request.getParameter("status").toString();
        if (memo != null && !memo.equals("") && memo.equals("1"))
        {

            // ////////////////////////////开始验证验证码是否正确////////////////////////////
            // 如果未生成验证码，则认为用户登录的途径不对

            Object object = request.getSession().getAttribute(
                    "isNeedLoginVerificationCode");
            if (null != object)
            {
                // 有该session
                Boolean bIsNeedLoginVerificationCode = (Boolean) object;
                if (bIsNeedLoginVerificationCode)
                {
                    // 需要进行验证码验证
                    if ((null == verificationCode)
                            || ("".equals(verificationCode)))
                    {
                        signUpRequestBean.setOK(false);
                        signUpRequestBean.setMsg("验证码不能为空");// userinfo.signin.VCode
                                                            // "验证码不能为空"
                        return signUpRequestBean;
                    }
                    if ((null == verificationCodeInRequest)
                            || ("".equals(verificationCodeInRequest))
                            || ("验证码".equals(verificationCodeInRequest)))
                    {
                        signUpRequestBean.setOK(false);
                        signUpRequestBean.setMsg("验证码不能为空");// userinfo.signin.VCode
                                                            // "验证码不能为空"
                        return signUpRequestBean;
                    }
                    if (!verificationCode.equals(verificationCodeInRequest))
                    {
                        signUpRequestBean.setOK(false);
                        signUpRequestBean.setMsg("请填写正确的验证码");// userinfo.signin.codeerror
                                                              // "请填写正确的验证码")
                        return signUpRequestBean;
                    }
                    else
                    {
                        verify = true;
                    }
                }
            }

            // ////////////////////////////验证码验证完毕////////////////////////////

            // ////////////////////////////开始验证email是否正确////////////////////////////
            // 验证email格式是否正确
            if ((null == email) || ("".equals(email)))
            {
                signUpRequestBean.setOK(false);
                signUpRequestBean.setMsg("请填写邮箱地址");// userinfo.signinemail.emailnull
                                                    // "请填写邮箱地址"
                return signUpRequestBean;
            }
            else
            {
                if (email.length() > 50)
                {
                    signUpRequestBean.setOK(false);
                    signUpRequestBean.setMsg("邮箱地址超过50个字符");// userinfo.signinemail.emaillengtherror
                                                            // "邮箱长度超过50个字符"
                    return signUpRequestBean;
                }
                else if (!ValidationUtil.isEmail(email))
                {
                    signUpRequestBean.setOK(false);
                    signUpRequestBean.setMsg("请填写正确的邮箱地址");// userinfo.signinemail.eamilerror
                                                           // "请填写正确的邮箱地址"
                    return signUpRequestBean;
                }
            }

            // ////////////////////////////email验证完毕////////////////////////////

            // ////////////////////////////开始验证密码是否正确////////////////////////////
            // 验证密码格式是否正确（是否为空）

            if ((null == password) || ("".equals(password)))
            {
                signUpRequestBean.setOK(false);
                signUpRequestBean.setMsg("请填写密码");// userinfo.signinemail.passwordnull
                                                  // "请填写密码"
                return signUpRequestBean;
            }
        }
        else
        {
            signUpRequestBean.setOK(false);
            signUpRequestBean.setMsg("请从邮箱账号登录窗口进入");// userinfo.signinemail.loginerror
                                                     // "请从邮箱账号登录窗口进入"
            return signUpRequestBean;
        }
        // ////////////////////////////密码验证完毕////////////////////////////

        // ////////////////////////////开始生成用户实体////////////////////////////
        // 验证用户名和密码
        UserInfo userInfoTmp = new UserInfo();
        userInfoTmp.setEmail(email);
        // userInfoTmp.setMobilephoneNumber(email);
        userInfoTmp.setPassword(password);
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        userInfos = loginService.signin(userInfoTmp);
        if ((null != userInfos) && (0 < userInfos.size()))
        {
            UserInfo userInfo = userInfos.get(0);
            // // 取出是否已登陆字段（login_status）
            // if (userInfo.getLoginstatus() == null)
            // {
            // userInfo.setLoginstatus(0);
            // }
            // if (userInfo.getLoginstatus() == -1)
            // {
            // if (login_status.equals("1"))
            // {// 强制退出
            // request.getSession().removeAttribute("UserInfo");
            // signUpRequestBean.setMsg("");
            // signUpRequestBean.setOK(true);
            // userInfo.setLastSignInIp(ClientInformation
            // .getClientIpAddr(request));// 填写注册时的IP
            // userInfo.setLastSignInTime(cal.getTime());
            // userInfo.setLoginstatus(1);
            // signUpRequestBean.setUserInfo(userInfo);
            //
            // }
            // else
            // {
            // signUpRequestBean.setMsg("false,"
            // + LocaleConfig.getLocale()
            // .getString("login.repeat"));
            // signUpRequestBean.setOK(false);
            // }
            // }
            // else
            // {
            signUpRequestBean.setMsg("");
            signUpRequestBean.setOK(true);
            // userInfo.setLastSignInIp(ClientInformation
            // .getClientIpAddr(request));// 填写注册时的IP
            // userInfo.setLastSignInTime(cal.getTime());
            // userInfo.setLoginstatus(0);
            signUpRequestBean.setUserInfo(userInfo);
            // }

            return signUpRequestBean;
        }
        else
        {
            signUpRequestBean.setOK(false);
            signUpRequestBean.setMsg("邮箱或密码不正确");// userinfo.signinemail.logineamilerror
                                                 // "邮箱或密码不正确"
            Integer nowLoginErrorCount = 0;
            Object obj = request.getSession()
                    .getAttribute("nowLoginErrorCount");
            if (null != obj)
            {
                nowLoginErrorCount = (Integer) obj;
            }
            if (nowLoginErrorCount >= MAX_LOGIN_ERROR_COUNT)
            {
                // 如果达到了最大允许登录出错的次数，则必须使用验证码
                request.getSession().setAttribute(
                        "isNeedLoginVerificationCode", true);
                if (verify)
                {
                    signUpRequestBean.setMsg("邮箱或密码不正确");// 邮箱或密码不正确
                }
                else
                {
                    signUpRequestBean.setMsg("错误次数过多，为了账户安全，请输入验证码！");// userinfo.signinemail.errortoomany
                                                                      // "错误次数过多，为了账户安全，请输入验证码！"
                }
            }

            // 更新密码出错的次数
            nowLoginErrorCount++;
            request.getSession().setAttribute("nowLoginErrorCount",
                    nowLoginErrorCount);
            return signUpRequestBean;
        }

        // ////////////////////////////用户实体生成完毕////////////////////////////

    }
}
