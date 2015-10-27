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
            <div class="index_box home_box activity clearfix" style="width:1000px; margin: 0 auto;">
            	<div class="rol rol_1">
                	<h1 class="ct"><img src="<%=paths%>include/images/-2.jpg" width="227" height="35"></h1>
                    <div class="mt50 ct"><img src="<%=paths%>include/images/p3-2.jpg" width="197" height="285"></div>
           	  	</div>
                <div class="rol rol_2">
                	<div class="mt50">
                    <h2>品牌活动</h2>
                    <ul class="newslist" id="activityLists">
                    	<!-- <li><a href="" target="_blank" title="">2014年9月15MONETA高级珠宝......</a></li> -->
                    </ul>
                    </div>
                </div>
                <div class="rol rol_3">
                	<div class="mt50">
                	<h2>明星佩戴&amp;媒体宣传</h2>
                    <ul class="newslist">
                        
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    	<li><a href="" target="_blank" title=""></a></li>
                    	
                    </ul>
                    </div>
                </div>
                <div class="rol rol_4">
                	<!-- <div class="mt50">
                	<h2>门店动态</h2>
                    <ul class="newslist">
                    	<li><a href="newsInfo.asp?newsId=187" target="_blank" title="2015年2月14日东方新天地店重装开幕">2015年2月14日东方新天地店重......</a></li>
                        </ul>
                    </div> -->
      		</div>
        </div>
	</div>
</div>