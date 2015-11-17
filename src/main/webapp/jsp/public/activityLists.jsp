<%@ page language="java" import="java.util.*,com.bianlide.zb.common.model.UserAccount,com.bianlide.zb.cms.model.TJewContent" pageEncoding="UTF-8"%>
<%
UserAccount userInfo = (UserAccount) request.getSession().getAttribute(
        "userAccount");
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
    
    List<TJewContent> activityList =   (List<TJewContent>)request.getServletContext().getAttribute("activityList");
    
    StringBuilder al = new StringBuilder();
    if(activityList != null && activityList.size()>0){
        int j=0;
        for(TJewContent a:activityList){
            if(j < 10){
          	  al.append("<li style=\"width:400px;text-align:left\"><a target=\"_blank\" href=\"").append(paths).append("activityArc?aid=").append(a.getId()).append("\" title=\"").append(a.getTitle()).append("\">").append(a.getTitle()).append("</a></li>");
       		  j = j+1;
            }
        }
    }
    
    System.out.println("al"+activityList.size());
    
    
   

%>

<!--主体-->
<div class="warp">
    <div class="warp_bg">
            <div class="index_box home_box activity clearfix" style="width:1000px; margin: 0 auto;">
            	<div class="rol_activity_left">
                    <div class="mt50 ct"><img src="<%=paths%>include/images/6.png" ></div>
           	  	</div>
           	  	
           	  	<div class="rol_activity_right">
                	<h1 class="ct"><img src="<%=paths%>include/images/-2.jpg" width="227" height="35" align="left"></h1>
                    <div class="mt50 ct">
                     <ul class="newslist" id="activityLists">
                     <%=al.toString()%>
                    <!-- 	 <li style="text-align:left;width:400px "><a href="" target="_blank" title="">2014年9月15MONETA高级珠宝..dd地对地导弹的沟通天涯头条他....</a></li>  -->
                    </ul>
                    </div>
           	  	</div>
        </div>
	</div>
</div>