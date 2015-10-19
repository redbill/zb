<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%
String path = request.getContextPath();
String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
if (request.getServerPort() != 80) {
    paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
}

%>
<div class="row-fluid">
    <div class="span12">
        <div class="portlet box blue">
                    <div class="portlet-body">
                <table class="table table-striped table-hover table-bordered" id="">
					<thead>
                        <tr colspan="2">
                            <th>文章筛选</th>
                        </tr>
                    </thead>
                    <tbody>
	                    <tr id="filter_col1" data-column="0">
					        <td style="text-align: right;">标题：</td>
					        <td align="center"><input type="text" class="column_filter" id="col0_filter"></td>
					    </tr>
					    <tr id="filter_col2" data-column="1">
					        <td style="text-align: right;">文章类别：</td>
					        <td align="center">
						        <select class="column_filter" id="col1_filter">
						        	<option>选择栏目</option>
							        <option>产品</option>
							        <option>品牌</option>
							        <option>活动</option>
							        <option>客服</option>
							      </select>
					        </td>
					    </tr>
                    </tbody> 
                </table>
            </div>
            <div class="portlet-body">
                <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
                    <thead>
                        <tr>
                            <th>文章标题</th>
                            <th>文章类别</th>
                            <th>发布时间</th>
                            <th>删除/修改</th>
                        </tr>
                    </thead>
                    <tbody class="arc-lists-tbody">
                        <!-- <tr class="">
                            <td>标题1</td>
                            <td>Alex Nilson</td>
                            <td>1234</td>
                            <td><a class="" href="javascript:;">修改</a> | <a class="delete" href="javascript:;">删除</a></td>
                        </tr>
                        <tr class="">
                            <td>标题2</td>
                            <td>Lisa Wong</td>
                            <td>434</td><td><a class="" href="javascript:;">修改</a> | <a class="delete" href="javascript:;">删除</a></td>
                        </tr>
                        <tr class="">
                            <td>标题3</td>
                            <td>Nick Roberts</td>
                            <td>232</td>
                            <td><a class="" href="javascript:;">修改</a> | <a class="delete" href="javascript:;">删除</a></td>
                        </tr>
                        <tr class="">
                            <td>标题4</td>
                            <td>Sergio Jackson</td>
                            <td>132</td>
                            <td><a class="" href="javascript:;">修改</a> | <a class="delete" href="javascript:;">删除</a></td>
                        </tr>-->
                    </tbody> 
                </table>
            </div>

        </div>
    </div>
</div>
</div>
</div>
</div>




<script src="<%=paths%>include/javascripts/modules.js"></script>
<script>
	modules.getArticleLists();
	modules.editArticleBtn();
	modules.deleteArticle();
</script>
