<%@ page language="java" import="java.util.*,com.bianlide.zb.price.model.FileUpload,java.text.SimpleDateFormat" pageEncoding="UTF-8"%>

<%
FileUpload fu = (FileUpload) request.getAttribute(
        "lastFileUpload");
String lastFileName = fu.getFileName();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH mm ss");
String lastFileUpTime = sdf.format(fu.getUploadTime());

    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>


  				<div class="row-fluid">

					<div class="span12">

						最近一次文件上传时间<%=lastFileUpTime%>
						
						<button type="submit" class="btn blue start" onclick="importFile()">

									<i class="icon-upload icon-white"></i>

									<span>开始导入数据库</span>

									</button>

					</div>

				</div>
				
		 <script>
    	function importFile(){
    		$.ajax({
				url: "<%=paths%>mgr/importFileToDB",
				data: {lastFileName : "<%=lastFileName%>"},
				dataType:"json",
				type:"post", //默认GET
				success: function(res){
					 console.log(res);
					 if(res.isOK == "false"){
						 alert(res.msg);
					 }else{
						 alert("数据已成功导入数据库");
					 }
				},
				error: function(res) {
					 
                }
			})
    	}
    </script>		