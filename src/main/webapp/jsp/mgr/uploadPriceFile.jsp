<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>

  				<div class="row-fluid">

					<div class="span12">

						<h1>Please upload a file</h1>
        <form method="post" action="mgr/uploadPriceFileForm" enctype="multipart/form-data">
            <input type="text" name="name"/>
            <input type="file" name="file"/>
            <input type="submit"/>
        </form>

					</div>

				</div>