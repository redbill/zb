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
    List<TJewContent> productList =   (List<TJewContent>)request.getServletContext().getAttribute("productList");
    
    StringBuilder contentStr = new StringBuilder();
    if(productList != null && productList.size()>0){
        for(TJewContent a:productList){
            if(String.valueOf(a.getId()).equals(aid)){
                contentStr.append("<div class=\"index_box home_box\"><div class=\"rol6\"><a href=\"productDetail?aid=").append(a.getId()).append("\"><img src=\"").append(paths).append("uploadImg/").append(a.getPreImg()).append("\" width=\"1000\" height=\"485\"></a></div></div>");
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
       
