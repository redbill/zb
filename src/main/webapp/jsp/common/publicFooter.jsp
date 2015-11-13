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
            <li><a href="" title="关于1002">关于1002</a></li>
            <li><a href="" title="联系我们">联系我们</a></li>
            <li><a href="" title="招贤纳士">招贤纳士</a></li>
            <li><a href="http://weibo.com/5686386872/profile?topnav=1&wvr=6" target="_blank">微博</a>
                 <a href="" target="_blank" class="l"><img src="<%=paths%>include/images/weibo.png" style="vertical-align: middle;"></a> 
            </li>
            <li><a href="" title="声明" target="_blank">声明</a></li>
           
			 <%
	if(userInfo != null ){
		%>
		
		  <li><a href="" title="退出" onclick="loginOut();return false">退出</a></li>
		<%
		
	}else{
	    %>
		 
		  <li><a href="<%=paths%>jsp/public/login.jsp" title="登录" target="_self">登录</a></li>
		 
		 <%
	}
%>

           
        </ul>
        <p>Tel:+86-025-86798805</p>
        <p>1002 @ 2015 | 地址：南京市中山东路300号长发中心A栋12楼C座 </p>
    </div>

      <script>
    	function loginOut(){
    		$.ajax({
				url: "<%=paths%>loginOut",
				data: {},
				dataType:"json",
				type:"post", //默认GET
				success: function(res){
					window.location.href = "<%=paths%>index";
				},
				error: function(res) {
					window.location.href = "<%=paths%>index";
                 }
			})
    	}
    </script>