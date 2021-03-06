<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
        <%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8" />
    <title>
        <tiles:insertAttribute name="title" />
    </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="<%=paths%>include/theme/media/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/style-metro.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/style.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/style-responsive.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="<%=paths%>include/theme/media/css/uniform.default.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/my.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <link rel="shortcut icon" href="<%=paths%>include/theme/media/image/favicon.ico" />
    <script src="<%=paths%>include/theme/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/bootstrap.min.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="<%=paths%>include/theme/media/js/excanvas.min.js"></script>
    <script src="<%=paths%>include/theme/media/js/respond.min.js"></script>  
    <![endif]-->
    <script src="<%=paths%>include/theme/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/jquery.cookie.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/jquery.uniform.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/select2.min.js" type="text/javascript" ></script>
    <script src="<%=paths%>include/theme/media/js/jquery.dataTables.1.10.8.js" type="text/javascript" ></script>
    <script src="<%=paths%>include/theme/media/js/DT_bootstrap.js" type="text/javascript" ></script>
	<script src="<%=paths%>include/javascripts/moment.min.js" type="text/javascript" ></script>
    <%-- <script src="<%=paths%>include/theme/media/js/table-editable.js"></script>--%>
    <script src="<%=paths%>include/theme/media/js/app.js" type="text/javascript" ></script> 
    <script>
    var basePath = "<%=paths%>";
	    $(function() {
	         App.init(); 
	    });
    </script>
</head>

<body class="page-header-fixed">
    <!-- BEGIN HEADER -->
    <tiles:insertAttribute name="header" />
    <!-- END HEADER -->
    <!-- BEGIN CONTAINER -->
    <div class="page-container row-fluid">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar nav-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu">
                <li>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler hidden-phone"></div>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                </li>
                <li class="start ">
                    <a href="<%=paths%>index">
                        <i class="icon-home"></i>
                        <span class="title">前台首页</span>
                    </a>
                </li>
               
                <li class="">
                    <a href="<%=paths%>mgr/updatePriceData">
                        <i class="icon-cogs"></i>
                        <span class="title">报价管理</span>
                        <span class="selected"></span>
                        <span class="arrow open"></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="<%=paths%>mgr/upLoadPriceFile">
                            上传报价文件</a>
                        </li>
                        <li>
                            <a href="<%=paths%>mgr/importPriceData">
                            导入报价文件</a>
                        </li>
                    </ul>
                </li>
               
                
                <li class="">
                    <a href="javascript:;">
                        <i class="icon-briefcase"></i>
                        <span class="title">内容管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu" style="display: block;">
                        <li>
                            <a href="<%=paths%>mgr/articleList">
                                <i class="icon-cogs"></i> 文章列表</a>
                        </li>
                        <li>
                            <a href="<%=paths%>mgr/addArticle">
                                <i class="icon-time"></i> 添加文章
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="">
                    <a href="javascript:;">
                        <i class="icon-briefcase"></i>
                        <span class="title">账号管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu" style="display: block;">
                        <li>
                            <a href="<%=paths%>mgr/accountList">
                                <i class="icon-cogs"></i>账号列表</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
        <!-- END SIDEBAR -->
        
        <!-- BEGIN PAGE -->
        <div class="page-content">
            <div id="portlet-config" class="modal hide">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"></button>
                    <h3>portlet Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here will be a configuration form</p>
                </div>
            </div>
            <!-- BEGIN PAGE CONTAINER-->
            <div class="container-fluid">
                <!-- BEGIN PAGE HEADER-->
                <div class="row-fluid">
                    <div class="span12">
                        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                        <h3 class="page-title">
                            <tiles:insertAttribute name="page-title"/> <small><tiles:insertAttribute name="page-title-desc"/></small>
                        </h3>
                        <ul class="breadcrumb">
                            <li>
                                <i class="icon-home"></i>
                                <a href="index.html">Home</a>
                                <i class="icon-angle-right"></i>
                            </li>
                            <li>
                                <a href="#">Layouts</a>
                                <i class="icon-angle-right"></i>
                            </li>
                            <li><a href="#">Blank Page</a></li>
                        </ul>
                    </div>
                </div>
                <tiles:insertAttribute name="main" />
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer" />
</body>
</html>

