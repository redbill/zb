package com.bianlide.zb.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.bianlide.zb.common.model.UserAccount;

public class UserSessionFilter implements Filter
{

    /** 需要排除（不拦截）的URL */
    private List<String> nofilterUrlList = new ArrayList<String>();

    /** 需要排除（不拦截）的URL的正则表达式 */
    private Pattern[] nofilterUrlPatterns;

    /** 检查不通过时，转发的URL */
    private String sendRedirect;

    private String normalUserAccessUrl;

    public void destroy()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException
    {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String url = request.getServletPath();
        // 登录页面或者用户已经登录
        if (nofilterUrlList.contains(url) || isMatch(url)
                || this.CurrentUserIsLogin(request))
        {
            chain.doFilter(req, res);
        }
        else
        {
            String toPagePrefix = request.getContextPath() + sendRedirect
                    + "?redirect=";
            // 对url进行编码
            url = java.net.URLEncoder.encode(
                    request.getContextPath()
                            + url
                            + (request.getQueryString() == null ? "" : "?"
                                    + request.getQueryString()), "UTF-8");
            ;

            response.sendRedirect(toPagePrefix + url);
            return;

        }
    }

    public boolean isMatch(String url)
    {
        if (nofilterUrlPatterns == null || nofilterUrlPatterns.length == 0)
        {
            return false;//
        }
        boolean isMatch = false;
        for (Pattern pattern : nofilterUrlPatterns)
        {
            isMatch = pattern.matcher(url).matches();
            if (isMatch)
            {
                return true;
            }
        }

        return isMatch;
    }

    public static boolean CurrentUserIsLogin(HttpServletRequest request)
    {
        // 取session
        UserAccount userInfo = (UserAccount) request.getSession().getAttribute(
                "userAccount");
        // 只有admin才能访问后台
        if (userInfo != null && userInfo.getUserName().trim().equals("admin"))
        {
            return true;
        }
        else if (userInfo != null
                && (request.getRequestURI().endsWith("priceList") || request
                        .getRequestURI().endsWith("getPriceDatas")))
        {// 报价访问连接普通员工也可访问
            return true;
        }
        else
        {
            return false;
        }
    }

    public void init(FilterConfig cfg) throws ServletException
    {
        String nofilterUrlText = cfg.getInitParameter("nofilterUrl");
        String normalUserAccessUrl = cfg
                .getInitParameter("normalUserAccessUrl");
        if (!StringUtils.isBlank(normalUserAccessUrl))
        {
            this.normalUserAccessUrl = normalUserAccessUrl;
        }
        if (!StringUtils.isBlank(nofilterUrlText))
        {
            nofilterUrlList = Arrays.asList(nofilterUrlText.split("[,]"));
        }

        // 表达式
        String nofilterUrlRegex = cfg.getInitParameter("nofilterUrlRegex");
        if (!StringUtils.isBlank(nofilterUrlRegex))
        {
            List<String> list = Arrays.asList(nofilterUrlRegex.split("[,]"));
            nofilterUrlPatterns = new Pattern[list.size()];
            for (int i = 0; i < list.size(); i++)
            {
                nofilterUrlPatterns[i] = Pattern.compile(list.get(i));
            }
        }

        sendRedirect = cfg.getInitParameter("sendRedirect");
    }
}
