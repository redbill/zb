<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>
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
    <title>1002 | 登录</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="<%=paths%>include/theme/media/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/style-metro.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/style.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/style-responsive.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="<%=paths%>include/theme/media/css/uniform.default.css" rel="stylesheet" type="text/css" />
    <link href="<%=paths%>include/theme/media/css/login.css" rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" href="<%=paths%>include/theme/media/image/favicon.ico" />
    <script>
    var paths = "<%=paths%>";
    </script>
</head>

<body class="login">
    <div class="logo"></div>
    <!-- BEGIN LOGIN -->
    <div class="content">
        <!-- BEGIN LOGIN FORM -->
        <form class="form-vertical login-form" action="">
            <h3 class="form-title">登录</h3>
            <div class="alert alert-error hide">
                <button class="close" data-dismiss="alert"></button>
                <span>请输入正确的用户名和密码</span>
            </div>
            <div class="control-group">
                <label class="control-label visible-ie8 visible-ie9">用户名</label>
                <div class="controls">
                    <div class="input-icon left">
                        <i class="icon-user"></i>
                        <input class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="username" />
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label visible-ie8 visible-ie9">密码</label>
                <div class="controls">
                    <div class="input-icon left">
                        <i class="icon-lock"></i>
                        <input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password" />
                    </div>
                </div>
            </div>
            <div class="form-actions">
<!--                 <label class="checkbox">
                    <input type="checkbox" name="remember" value="1" /> 下次自动登录
                </label> -->
                <button type="submit" class="btn green pull-right" id="login-btn">
                    登录 <i class="m-icon-swapright m-icon-white"></i>
                </button>
            </div>
        </form>
    </div>
    <!-- BEGIN COPYRIGHT -->
    <div class="copyright">
        2015 &copy; 1002.
    </div>
    <!-- END COPYRIGHT -->
    <!-- BEGIN CORE PLUGINS -->
    <script src="<%=paths%>include/theme/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
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
    <!-- END CORE PLUGINS -->
    <script src="<%=paths%>include/theme/media/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/app.js" type="text/javascript"></script>
    <script src="<%=paths%>include/theme/media/js/login.js" type="text/javascript"></script>
    <script>
    jQuery(document).ready(function() {
        App.init();

        Login.init();

    });
    </script>
</body>
</html>
