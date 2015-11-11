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
<embed src="<%=paths%>SimpleGifts-SaraDonaldson.mp3"  width="0" height="0"/>
