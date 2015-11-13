<%@ page language="java" import="java.util.*,com.bianlide.zb.common.model.UserAccount,com.bianlide.zb.cms.model.TJewContent" pageEncoding="UTF-8"%>
<%
UserAccount userInfo = (UserAccount) request.getSession().getAttribute(
        "userAccount");
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
    
    List<TJewContent> productList =   (List<TJewContent>)request.getServletContext().getAttribute("productList");
    
    StringBuilder pl = new StringBuilder();
    if(productList != null && productList.size()>0){
        int i=0;
        for(TJewContent a:productList){
            if(a.getHomeImg()!=null && i<3){//最多3图
           		 pl.append(" <a href=\"").append(paths).append("productArc?aid=").append(a.getId()).append("&cat=").append(a.getCodeModule()).append("\" title=\"").append(a.getTitle()).append("\">").append("<img src=\"").append(paths).append("uploadImg/").append(a.getHomeImg()).append("\"  width=\"216\" height=\"180\"  />").append("</a>");
            	i = i+1;
            }
        }
    }
    
    
    
    
   

%>
<!--主体-->
<div class="warp">
    <div class="warp_bg">
        <div class="main nobg">
        <div style="height:140px">
	            <div>
	    				<div style="position: relative; top: 150px; left: 270px; width: 431px; overflow: hidden; float: left; text-align: left;" id="Text">
	        
	    		</div>
  		  </div>
  		  </div>
    
    <div style=" text-align:center; height:500px;">
    <div style=" width:800px; margin:0 auto;">
        <div id="coin-slider">
         <%=pl.toString()%>
          <!--   <img src="pic/5.png" width="216" height="180">
            <img src="pic/4.png" width="216" height="180">
            <img src="pic/6.png" width="216" height="180">  -->
        </div>
    </div>
    <a href="<%=paths%>index" target="_blank"><img src="<%=paths%>include/images/enter.gif" style="margin-top:50px;"></a>
    
    <div style="height:260px">
    
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
<embed src="<%=paths%>SimpleGifts-SaraDonaldson.mp3"  width="0" height="0"/>
