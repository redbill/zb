<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>


<!--主体-->
<div class="warp">
    <div class="warp_bg">
        <div class="main nobg" id="arc-content">
            <!-- 文章内容  -->
        </div>
</div>
</div>
       
<script>
	var aid = '<%=request.getParameter("aid")%>';
	
	commonAjax(basePath + "getArticleList", "", "POST", function(result){
		if(result.isOK === "true"){
			var res = result.jsonData,
				len = res.length;
			var content = "";
			console.log(res);
			
			for(var i = 0; i < len; i++){
				if(res[i].id === +aid){
					content = res[i].content;
					break;
				}
			}
			$("#arc-content").html();
			$("#arc-content").html(content);
		}
	})
</script>