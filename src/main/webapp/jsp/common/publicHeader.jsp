<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>
<%
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
            <li class="mainlevel"><a href="http://www.be-moneta.com/main.asp" title="HOME">首页</a></li>
            <li class="mainlevel">走进品牌2
                <ul class="sub_nav_03">
                    <span class="Triangle_con"></span>
                    <li class="first"><a href="http://www.be-moneta.com/about.asp" title="事业展望">Company 事业展望</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/home.asp" title="品牌故事">Brand Story 品牌故事</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/designer.asp" title="签约设计师">Designers 签约设计师</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/culture.asp" title="彩钻文化">Culture 彩钻文化</a></li>
                    <li class="last"><a href="http://www.be-moneta.com/paimai.asp?companyInfoId=16" title="彩钻拍卖纪录">Auction 彩钻拍卖纪录</a></li>
                </ul>
            </li>
            <li class="mainlevel">系列产品
                <ul class="sub_nav_03">
                    <span class="Triangle_con"></span>
                    <li class="first"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=34">Transforever传世经典</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=44">Super Star 10ct Diamond巨星</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=37">Flower whispers自然花语</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=33">Princess魅力公主</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=43">Scarlet Macaw金刚鹦鹉</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=46">Emerald翠湖春晓</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=45">Butterfly蝶梦奇缘</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=31">True Love挚爱</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=36">Rainbow Music彩虹乐章</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=53">Angel Eyes天使之眸</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=47">Hyacinth风信子</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=48">Rose Love瑰丽之爱</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=49">Psychedelic Seas迷幻海洋</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=50">Rainbow Dream彩虹迷梦</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=51">Queen Red Tourmaline女王</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=52">Blue Sea深海湛蓝</a></li>
                    <li class="item"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=55">Gorgeous love晶彩之爱</a></li>
                    <li class="last"><a href="http://www.be-moneta.com/productList_index.asp?productClassId=54">Teddy Bear泰迪熊新品</a></li>
                    <!--
                        <li><a href="p-3.html" title="分类一">分类一</a></li>
                        <li><a href="p-4.html" title="分类二">分类二</a></li>
                        <li><a href="p-1.html" title="大师系列 还有个P-2.html">大师系列</a></li>-->
                </ul>
            </li>
            <li class="mainlevel ml50">客户服务
                <ul class="sub_nav_03">
                    <span class="Triangle_con"></span>
                    <li><a href="http://www.be-moneta.com/diy.asp" title="珠宝定制流程">process 珠宝定制流程</a></li>
                    <li><a href="http://www.be-moneta.com/vip.asp">VIP Service 客户服务</a></li>
                    <!--
                        <li><a href="save.asp">国际拍卖实例</a></li>-->
                    <li><a href="http://www.be-moneta.com/cpbook.asp">Reservation 预约咨询</a></li>
                </ul>
            </li>
        </ul>
        <ul class="sub_r">
            <li class="mainlevel"><a href="http://www.be-moneta.com/news.asp">活动资讯</a>
                <ul class="sub_nav_04">
                    <span class="Triangle_con"></span>
                    <li><a href="http://www.be-moneta.com/year.asp" title="MONETA大事记">MONETA大事记</a></li>
                    <li><a href="http://www.be-moneta.com/news.asp" title="活动资讯">News 活动资讯</a></li>
                    <li><a href="http://www.be-moneta.com/news.asp" title="门店动态">Shop  门店动态</a></li>
                </ul>
            </li>
            <li class="mainlevel"><a href="http://www.be-moneta.com/address.asp" title="门店信息">门店信息</a></li>
            <li class="mainlevel">联系我们
                <ul class="sub_nav_05">
                    <span class="Triangle_con"></span>
                    <li><a href="http://www.be-moneta.com/contactus.asp?companyInfoId=29">Us 联系我们</a></li>
                    <li><a href="http://www.be-moneta.com/contactus.asp?companyInfoId=10">Partners 寻找伙伴</a></li>
                    <li><a href="http://www.be-moneta.com/book.asp">Feedback 反馈信息</a></li>
                </ul>
            </li>
        </ul>
    </div>