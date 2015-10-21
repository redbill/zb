<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>
<!--主体-->
<div class="warp">
    <div class="warp_bg">
        <div class="main">
            <div class="index_box">
                <div class="rol rol_1">
                    <p>彩钻定制服务
                        <br><a href="diy.asp" title="详细点击">详细点击</a></p>
                </div>
                <div class="rol rol_2">
                    <div id="slides">
                        <div class="slides_container" id="slides_container">
                            <div>
                                <h1>Fancy Purplish Pink   5.38ct</h1>
                                <p style="borfder:solid 1px red"><a href="" title="Fancy Purplish Pink   5.38ct"><img src="http://www.be-moneta.com/upfile/indexpic/2014011115423684029.png"  /></a></p>
                          </div>
                          
                            <div>
                                <h1>Fancy Intense Yellow    12.08ct</h1>
                                <p style="borfder:solid 1px red"><a href="" title="Fancy Intense Yellow    12.08ct"><img src="http://www.be-moneta.com/upfile/indexpic/2014011115424985897.png"  /></a></p>
                          </div>
                          
                            <div>
                                <h1>Fancy Intense Pink 5.18ct</h1>
                                <p style="borfder:solid 1px red"><a href="" title="Fancy Intense Pink 5.18ct"><img src="http://www.be-moneta.com/upfile/indexpic/2014011314075124354.jpg"  /></a></p>
                          </div>
                        </div>
                    </div>
                </div>

                <div class="rol rol_3">
                    <div class="hd"><a href="#" title="NEWS:大事记">NEWS:大事记</a></div>
                    <ul class="list" id="index-activity">
                        <!-- <li><a href="">2015年2月14日东方新天地店重装开幕</a></li> -->
                    </ul>
                </div>
                <div class="rol rol_4">
                    <div class="pic">
                        <a href=""><img src="<%=paths%>include/images/pic01.jpg" width="149" height="164"></a>
                        <p>1990年，MONETA品牌的创始人，30岁的FEANCIS IBERT（佛郎西斯.伊贝尔特）发现自己正面临着人生中的一次抉择。不久后，由家族世代经营的钻石切割厂就要由他来继承，但这位成长于珠宝世家的、眼光高远的年轻人早已洞悉了高端珠宝行业的发展前景，他已经不满足于单纯地为客户加工钻石。在他的心里，正酝酿着一次家族企业的彻底变革。为了考察各地的市场，更准确地把握瞬息万变的珠宝潮流，伊贝尔特开始了游历欧洲的旅程。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
$(function(){
	$('#slides').slides({
		preload: true,
		generateNextPrev: true
	});
});
</script>
