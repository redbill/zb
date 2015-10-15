<%@ page language="java" import="java.util.*,cn.com.hugedata.web.fsm.user.model.UserInfo" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>
<div class="header navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="brand" href="index.html">
            <!--    <img src="<%=paths%>include/theme/media/image/logo.png" alt="logo" />
-->
                </a>
            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                <img src="<%=paths%>include/theme/media/image/menu-toggler.png" alt="" />
                </a>
            <ul class="nav pull-right">
                <li class="dropdown user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img alt="" src="<%=paths%>include/theme/media/image/avatar1_small.jpg" />
                        <span class="username">Bob</span>
                        <i class="icon-angle-down"></i>
                        </a>
                    <ul class="dropdown-menu">
                        <li><a href="login.html"><i class="icon-key"></i> 退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
