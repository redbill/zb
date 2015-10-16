<%@ page language="java" import="java.util.*,com.bianlide.zb.common.model.UserAccount" pageEncoding="UTF-8"%>
<%
UserAccount userInfo = (UserAccount) request.getSession().getAttribute(
        "userAccount");
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>

  <!--底部-->
    <div class="footer">
        <ul class="list" style="width:550px;">
            <li><a href="http://www.be-moneta.com/about.asp" title="关于Moneta">关于Moneta</a></li>
            <li><a href="http://www.be-moneta.com/contactus.asp?companyInfoId=29" title="联系我们">联系我们</a></li>
            <li><a href="http://www.be-moneta.com/contactus.asp?companyInfoId=10" title="招贤纳士">招贤纳士</a></li>
            <li><a href="http://weibo.com/2180015055" target="_blank" class="l">微博</a>
                <a href="http://weibo.com/2180015055" target="_blank" class="l"><img src="<%=paths%>include/images/weibo.png" style="vertical-align: middle;"></a>
            </li>
            <li><a href="http://www.be-moneta.com/companyinfo.asp?companyInfoId=36" title="声明" target="_blank">声明</a></li>
           
			 <%
	if(userInfo != null ){
		%>
		
		  <li><a href="" title="退出" onclick="loginOut();return false">退出</a></li>
		<%
		
	}else{
	    %>
		 
		  <li><a href="<%=paths%>jsp/public/login.jsp" title="登录" target="_blank">登录</a></li>
		 
		 <%
	}
%>

           
        </ul>
        <p>Tel:+86- 400-610-5880</p>
        <p>京ICP备15000958号-1 |Moneta 中国 Copyright @ 2011 MONETA .All right reserved Design by <a href="http://www.mindjoy.cn/" target="_blank">MINDJOY</a>
        </p>
    </div>
