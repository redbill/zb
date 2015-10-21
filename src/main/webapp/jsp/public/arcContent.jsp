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
	var cat = parseInt('<%=request.getParameter("cat")%>', 10) ? parseInt('<%=request.getParameter("cat")%>', 10) : false;
	commonAjax(basePath + "getArticleList", "", "POST", function(result){
		
		if(result.isOK === "true"){
			var res = result.jsonData,
				len = res.length;
			var content = "";
			var imgStr = "";

			for(var i = 0; i < len; i++){
				if(cat == 1001) {
					imgStr +='<div class="index_box home_box">' +
					    '<div class="rol6">' +
					        '<a href="arcContent?aid='+ res[i].id +'"><img src="'+ basePath +'uploadImg/'+ res[i].preImg  +'" width="1000" height="485"></a>' +
					    '</div>' +
					'</div>';
				}
				
				if(res[i].id === +aid){
					content = res[i].content;
					break;
				}
				
			}

			if(!!cat) {
				$("#arc-content").html(imgStr);
			} else {
				$("#arc-content").html(content);
			}
			
		}
	})
</script>