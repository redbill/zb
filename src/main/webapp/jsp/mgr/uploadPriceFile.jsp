<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>

  				<div class="row-fluid">

					<div class="span12">

        <form method="post" action="<%=paths%>mgr/uploadPriceFileForm" enctype="multipart/form-data">
            <input type="text" name="name"/>
            <input type="file" name="file"/>
            <input type="submit"/>
        </form>

					</div>

				</div>