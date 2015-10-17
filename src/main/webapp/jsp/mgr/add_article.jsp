<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>
<div class="row-fluid">
    <div class="portlet-body form">
        <div class="tab-content">
            <div class="tab-pane active" id="portlet_tab1">
                <!-- BEGIN FORM-->
                <form action="#" class="form-horizontal">
                    <div class="control-group">
                        <label class="control-label">标题：</label>
                        <div class="controls">
                            <input type="text" placeholder="文章标题" class="m-wrap">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    
                    <div class="control-group">
                        <label class="control-label">模块：</label>
                        <div class="controls">
                            <select class="m-wrap" tabindex="1">
                                <option value="Cate1">品牌</option>
                                <option value="Cate2">产品</option>
                                <option value="Cate3">活动</option>
                                <option value="Cate4">客服</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">文章内容：</label>
                        <div class="controls">
                            <script id="container" name="content" type="text/plain">这里写你的初始化内容</script>
                        </div>
                    </div>
                    <div class="form-actions">
						<button type="submit" class="btn blue"><i class="icon-ok"></i> 保存</button>
					</div>
                </form>
                <!-- END FORM-->
            </div>
        </div>
    </div>
</div>
		<script type="text/javascript" src="<%=paths%>/include/components/ueditor/ueditor.config.js"></script>  
        <!-- 编辑器源码文件 -->  
        <script type="text/javascript" src="<%=paths%>/include/components/ueditor/ueditor.all.js"></script>  
        <!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->  
        <script type="text/javascript" src="<%=paths%>/include/components/ueditor/lang/zh-cn/zh-cn.js"></script>  
        <script type="text/javascript">  
            var editor = UE.getEditor('container')  
        </script>  