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
            <li class="mainlevel"><a href="" title="HOME">首页</a></li>
            <li class="mainlevel">走进品牌
                <ul class="sub_nav_03">
                    <span class="Triangle_con"></span>
                    <li class="first"><a href="" title="事业展望">Company 事业展望</a></li>
                    <li class="item"><a href="" title="品牌故事">Brand Story 品牌故事</a></li>
                    <li class="item"><a href="" title="签约设计师">Designers 签约设计师</a></li>
                    <li class="item"><a href="" title="彩钻文化">Culture 彩钻文化</a></li>
                    <li class="last"><a href="" title="彩钻拍卖纪录">Auction 彩钻拍卖纪录</a></li>
                </ul>
            </li>
            <li class="mainlevel">系列产品
                <ul class="sub_nav_03">
                    <span class="Triangle_con"></span>
                    <li class="first"><a href="">Transforever传世经典</a></li>
                    <li class="item"><a href="">Super Star 10ct Diamond巨星</a></li>
                    <li class="item"><a href="">Flower whispers自然花语</a></li>
                    <li class="item"><a href="">Princess魅力公主</a></li>
                    <li class="item"><a href="">Scarlet Macaw金刚鹦鹉</a></li>
                    <li class="item"><a href="">Emerald翠湖春晓</a></li>
                    <li class="item"><a href="">Butterfly蝶梦奇缘</a></li>
                    <li class="item"><a href="">True Love挚爱</a></li>
                    <li class="item"><a href="">Rainbow Music彩虹乐章</a></li>
                    <li class="item"><a href="">Angel Eyes天使之眸</a></li>
                    <li class="item"><a href="">Hyacinth风信子</a></li>
                    <li class="item"><a href="">Rose Love瑰丽之爱</a></li>
                    <li class="item"><a href="">Psychedelic Seas迷幻海洋</a></li>
                    <li class="item"><a href="">Rainbow Dream彩虹迷梦</a></li>
                    <li class="item"><a href="">Queen Red Tourmaline女王</a></li>
                    <li class="item"><a href="">Blue Sea深海湛蓝</a></li>
                </ul>
            </li>
            <li class="mainlevel ml50">客户服务
                <ul class="sub_nav_03">
                    <span class="Triangle_con"></span>
                    <li><a href="" title="珠宝定制流程">process 珠宝定制流程</a></li>
                    <li><a href="">VIP Service 客户服务</a></li>
                    <!--
                        <li><a href="save.asp">国际拍卖实例</a></li>-->
                    <li><a href="">Reservation 预约咨询</a></li>
                </ul>
            </li>
        </ul>
        <ul class="sub_r">
            <li class="mainlevel"><a href="">活动资讯</a>
                <ul class="sub_nav_04">
                    <span class="Triangle_con"></span>
                    <li><a href="" title="MONETA大事记">MONETA大事记</a></li>
                    <li><a href="" title="活动资讯">News 活动资讯</a></li>
                    <li><a href="" title="门店动态">Shop  门店动态</a></li>
                </ul>
            </li>
            <li class="mainlevel"><a href="" title="门店信息">门店信息</a></li>
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