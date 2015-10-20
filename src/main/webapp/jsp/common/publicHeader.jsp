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


 <!--头部和导航-->
    <div class="header"></div>
    <div class="menu">
        <ul class="sub_l">
            <li class="mainlevel"><a href="/" title="HOME">首页</a></li>
            <li class="mainlevel">走进品牌
                <ul class="sub_nav_03" id="brand-lists">
                    <span class="Triangle_con"></span>
                    <!-- <li class="first"><a href="" title="事业展望">Company 事业展望</a></li> -->
                </ul>
            </li>
            <li class="mainlevel">系列产品
                <ul class="sub_nav_03" id="product-lists">
                    <span class="Triangle_con"></span>
                    <!-- <li class="first"><a href="">Transforever传世经典</a></li> -->
                </ul>
            </li>
            <li class="mainlevel ml50">客户服务
                <ul class="sub_nav_03" id="service-lists">
                    <span class="Triangle_con"></span>
                    <!-- <li><a href="" title="珠宝定制流程">process 珠宝定制流程</a></li>
                    <li><a href="">VIP Service 客户服务</a></li>
                    <li><a href="">Reservation 预约咨询</a></li> -->
                </ul>
            </li>
        </ul>
        <ul class="sub_r">
            <li class="mainlevel"><a href="">活动资讯</a>
                <ul class="sub_nav_04" id="activity-lists">
                    <span class="Triangle_con"></span>
                   <!--  <li><a href="" title="MONETA大事记">MONETA大事记</a></li>
                    <li><a href="" title="活动资讯">News 活动资讯</a></li>
                    <li><a href="" title="门店动态">Shop  门店动态</a></li> -->
                </ul>
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
		
		  <li class="mainlevel"><a href="mgr/priceList" title="钻石报价">钻石报价</a></li>
		<%
			} 
	    %>
        </ul>
    </div>