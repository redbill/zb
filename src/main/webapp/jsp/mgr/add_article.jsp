<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
        <%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
%>
<script src="<%=paths%>include/javascripts/ajaxupload.js"></script> 
<script>
	var id = parseInt('<%=request.getParameter("id")%>', 10);
</script>
<div class="row-fluid">
    <div class="portlet-body form">
        <div class="tab-content">
            <div class="tab-pane active" id="portlet_tab1">
                <!-- BEGIN FORM-->
                <form class="form-horizontal" id="add_article_form">
                    <div class="control-group">
                        <label class="control-label">标题：</label>
                        <div class="controls">
                            <input type="text" placeholder="文章标题" class="m-wrap" name="title" value="">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    
                    <div class="control-group">
                        <label class="control-label">模块：</label>
                        <div class="controls">
                            <select class="m-wrap" tabindex="1" id="cat-select">
                                <option value="1000">品牌</option>
                                <option value="1001">产品</option>
                                <option value="1002">活动</option>
                                <option value="1003">客服</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="control-group" id="img-up" style="display: none;">
                        <label class="control-label">图片上传：</label>
                        <div class="controls">
                            <span class="file" style="position: relative">
                            	<span class="txt" style="display: inline-block;width: 92px;height: 30px;line-height: 30px;color: #555;background-color: #e2e4ea;border: 1px solid #cbcbcb;text-align: center;padding: 0;">浏览图片</span>
								<input id="uploadImg" data-url="" name="uploadImg" type="file" style="position: absolute;top: 0;right: 0;width: 92px;height: 30px;z-index: 2;opacity: 0;cursor: pointer;"/>
							</span>
							 <input type="hidden" name="hidFileID" id="hidFileID" value="" />
							<span class="feedback hide" id="uploadImgTips">正在上传中</span>
							<p class="tip" style="color: #999;font-size: 12px;">图片大小不能超过500K，支持jpg、jpeg、gif、png、bmp格式</p>
                        </div>
                    </div>
                    
					
                    <div class="control-group">
                        <label class="control-label">文章内容：</label>
                        <div class="controls">
                            <script id="container" name="content" style="width:800px; height:400px;" type="text/plain"></script>
                        </div>
                    </div>
                    
                    <div class="form-actions">
						<input type="button" class="btn black" id="sava_arcticle" value="保存" />
					</div>
                </form>
                <!-- END FORM-->
            </div>
        </div>
    </div>
</div>
		<script type="text/javascript" src="<%=paths%>include/components/ueditor/ueditor.config.js"></script>  
        <!-- 编辑器源码文件 -->  
        <script type="text/javascript" src="<%=paths%>include/components/ueditor/ueditor.all.js"></script>  
        <!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->  
        <script type="text/javascript" src="<%=paths%>include/components/ueditor/lang/zh-cn/zh-cn.js"></script>  
        <script src="<%=paths%>include/javascripts/modules.js"></script>
        <script type="text/javascript">  
            var editor = UE.getEditor('container');
            

    		$(function() {
    			modules.imgUploadShowOrHide();
    			modules.editArticleContent();
    			modules.addArticleByAjax();
    			
    			//图片上传
    			if($("#uploadImg").length>0){
    				new AjaxUpload("#uploadImg",{//上传图片 	
    					action: basePath + "upload?codeModule=1001&nameModule=product",
    					autoSubmit:true,
    					type:"POST",
    					name:"file",
    					onSubmit:function(filepic, extension){
    						if (extension && /^(jpg|jpeg|gif|png|bmp|JPEG|JPG|GIF|PNG|BMP)$/.test(extension)){
    				 	      	$("#uploadImgTips").html('<span class="loading">文件正在上传...</span>').show();
    					 	}else{
    							$("#uploadImgTips").text("格式错误！").show();
    							return false;
    						}
    					},
    					onComplete:function(filename,files,issuccess){
    						var res = JSON.parse(files);
    						$("#uploadImgTips").text(res.msg).show();
    						$("#hidFileID").attr('data-img',filename);
    					}
    				});
    			}
    		})
        </script>