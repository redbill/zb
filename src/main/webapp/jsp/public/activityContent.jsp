<%@ page language="java" import="java.util.*,com.bianlide.zb.common.model.UserAccount,com.bianlide.zb.cms.model.TJewContent" pageEncoding="UTF-8"%>
<%
UserAccount userInfo = (UserAccount) request.getSession().getAttribute(
        "userAccount");
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
    
    String  aid =request.getParameter("aid");
    List<TJewContent> activityList =   (List<TJewContent>)request.getServletContext().getAttribute("activityList");
    
    StringBuilder contentStr = new StringBuilder();
    if(activityList != null && activityList.size()>0){
        for(TJewContent a:activityList){
            if(String.valueOf(a.getId()).equals(aid)){
                contentStr.append(a.getContent());
            }
        }
    }
    

%>
<!--主体-->
<div class="warp">
    <div class="warp_bg">
        <div class="main nobg" id="arc-content">
           <%=contentStr.toString()%>
        </div>
</div>
</div>
       

       
