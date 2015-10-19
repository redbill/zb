<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>

 
	<div class="footer">

		<div class="footer-inner">

			2015 &copy; 1002.

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>

	</div>
	<!-- 模态框 -->
<div id="tip-pop" class="modal hide fade in" style="display: none; ">
	<div class="modal-header">
		<a class="close" data-dismiss="modal"></a>
		<h3>提示消息</h3>
	</div>
	<div class="modal-body">
		<h4>是否删除当前文章？</h4>
	</div>
	<div class="modal-footer">
		<a href="javascript:;" class="btn btn-success" id="delete-yes">是</a>
		<a href="javascript:;" class="btn" data-dismiss="modal">否</a>
	</div>
</div>