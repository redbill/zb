<%@ page language="java" import="java.util.*,com.bianlide.zb.common.model.UserAccount,com.bianlide.zb.cms.model.TJewContent" pageEncoding="UTF-8"%>
<%
UserAccount userInfo = (UserAccount) request.getSession().getAttribute(
        "userAccount");
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
    
    List<TJewContent> brandList =   (List<TJewContent>)request.getServletContext().getAttribute("brandList");
    List<TJewContent> activityList =   (List<TJewContent>)request.getServletContext().getAttribute("activityList");
    List<TJewContent> serviceList =   (List<TJewContent>)request.getServletContext().getAttribute("serviceList");
    List<TJewContent> productList =   (List<TJewContent>)request.getServletContext().getAttribute("productList");
    
    StringBuilder bl = new StringBuilder();
    if(brandList != null && brandList.size()>0){
        for(TJewContent a:brandList){
            bl.append("<li class=\"item\"><a href=\"").append(paths).append("brandArc?aid=").append(a.getId()).append("\" title=\"").append(a.getTitle()).append("\">").append(a.getTitle()).append("</a></li>");
        }
    }
    
    StringBuilder pl = new StringBuilder();
    if(productList != null && productList.size()>0){
        for(TJewContent a:productList){
            pl.append("<li class=\"item\"><a href=\"").append(paths).append("productArc?aid=").append(a.getId()).append("&cat=").append(a.getCodeModule()).append("\" title=\"").append(a.getTitle()).append("\">").append(a.getTitle()).append("</a></li>");
        }
    }
    
    StringBuilder sl = new StringBuilder();
    if(serviceList != null && serviceList.size()>0){
        for(TJewContent a:serviceList){
            sl.append("<li class=\"item\"><a href=\"").append(paths).append("serviceArc?aid=").append(a.getId()).append("\" title=\"").append(a.getTitle()).append("\">").append(a.getTitle()).append("</a></li>");
        }
    }
    
    
   

%>


 <!--头部和导航-->
    <div class="header"></div>
    <div class="menu">
        <ul class="sub_l">
            <li class="mainlevel"><a href="<%=paths%>index" title="HOME">首页</a></li>
            <li class="mainlevel">走进品牌
                <ul class="sub_nav_03" id="brand-lists">
                    <span class="Triangle_con"></span>
                    <!-- <li class="first"><a href="" title="事业展望">Company 事业展望</a></li> -->
                    <%=bl.toString()%>
                </ul>
            </li>
            <li class="mainlevel">系列产品
                <ul class="sub_nav_03" id="product-lists">
                    <span class="Triangle_con"></span>
                     <%=pl.toString()%>
                    <!-- <li class="first"><a href="">Transforever传世经典</a></li> -->
                </ul>
            </li>
            <li class="mainlevel ml50">客户服务
                <ul class="sub_nav_03" id="service-lists">
                    <span class="Triangle_con"></span>
                    <%=sl.toString()%>
                    <!-- <li><a href="" title="珠宝定制流程">process 珠宝定制流程</a></li>
                    <li><a href="">VIP Service 客户服务</a></li>
                    <li><a href="">Reservation 预约咨询</a></li> -->
                </ul>
            </li>
        </ul>
        <ul class="sub_r">
            <li class="mainlevel"><a href="<%=paths%>activityLists">活动资讯</a>
            </li>
            <li class="mainlevel">联系我们
                <ul class="sub_nav_05">
                    <span class="Triangle_con"></span>
                    <li><a href="">Us 联系我们</a></li>
                    <li><a href="">Partners 寻找伙伴</a></li>
                    <li><a href="">Feedback 反馈信息</a></li>
                </ul>
            </li>
    <%
	if(userInfo != null ){
		%>
		
		  <li class="mainlevel"><a href="<%=paths%>mgr/priceList" title="钻石报价">钻石报价</a></li>
		<%
			} 
	    %>
        </ul>
    </div>