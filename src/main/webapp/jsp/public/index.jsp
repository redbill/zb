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
    List<TJewContent> productList =   (List<TJewContent>)request.getServletContext().getAttribute("productList");
    
    StringBuilder pl = new StringBuilder();
    if(productList != null && productList.size()>0){
        int i=0;
        for(TJewContent a:productList){
            if(a.getSmallImg()!=null && i<5){//最多5图
           		 pl.append(" <div><h1>").append(a.getTitle()).append("</h1><p style=\"borfder:solid 1px red\"><a href=\"").append(paths).append("productArc?aid=").append(a.getId()).append("&cat=").append(a.getCodeModule()).append("\" title=\"").append(a.getTitle()).append("\">").append("<img src=\"").append(paths).append("uploadImg/").append(a.getSmallImg()).append("\"  />").append("</a></p></div>");
            	i = i+1;
            }
        }
    }
    
    StringBuilder al = new StringBuilder();
    if(activityList != null && activityList.size()>0){
        int j=0;
        for(TJewContent a:activityList){
            if(j < 5){
          	  al.append("<li class=\"item\"><a target=\"_blank\" href=\"").append(paths).append("activityArc?aid=").append(a.getId()).append("\" title=\"").append(a.getTitle()).append("\">").append(a.getTitle()).append("</a></li>");
       		  j = j+1;
            }
        }
    }
    
    
   

%>
<!--主体-->
<div class="warp">
    <div class="warp_bg">
        <div class="main">
            <div class="index_box">
                <div class="rol rol_1 abs">
                    <p>彩钻定制服务
                        <br><a href="<%=paths%>serviceArc?aid=87" target="_blank" title="详细点击">详细点击</a></p>
                </div>
                <div class="rol rol_2 abs">
                    <div id="slides">
                        <div class="slides_container" id="slides_container">
                         <%=pl.toString()%>
                         
                          <!--   <div>
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
                          </div>  -->
                        </div>
                    </div>
                </div>

                <div class="rol rol_3 abs">
                    <div class="hd"><a href="#" title="NEWS:新闻与活动">NEWS:新闻与活动</a></div>
                    <ul class="list" id="index-activity">
                        <!-- <li><a href="">2015年2月14日东方新天地店重装开幕</a></li> -->
                    	<%=al.toString()%>
                    </ul>
                </div>
                <div class="rol rol_4 abs">
                    <div class="pic">
                    
                        <a href="<%=paths%>brandArc?aid=88" target="_blank"><img src="<%=paths%>include/images/pic01.jpg" width="149" height="164"></a>
                        <p>2014年，1002品牌的创始人，30岁的朱兴基发现自己正面临着人生中的一次抉择。不久后，由家族世代经营的钻石切割厂就要由他来继承，但这位成长于珠宝世家的、眼光高远的年轻人早已洞悉了高端珠宝行业的发展前景，他已经不满足于单纯地为客户加工钻石。在他的心里，正酝酿着一次家族企业的彻底变革。为了考察各地的市场，更准确地把握瞬息万变的珠宝潮流，伊贝尔特开始了游历欧洲的旅程。</p>
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
<!-- <embed src="<%=paths%>SimpleGifts-SaraDonaldson.mp3"  hidden="true"  autostart="true" loop="-1" />  -->
<audio src="<%=paths%>SimpleGifts-SaraDonaldson.mp3" id="audio1" hidden="true" autoplay="true" loop="true"></audio>

