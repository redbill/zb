<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><tiles:insertAttribute name="title"/></title>
    <link href="<%=paths%>include/stylesheets/publicStyle.css" rel="stylesheet" type="text/css">
    <script src="<%=paths%>include/javascripts/jquery-1.js"></script>
    <script src="<%=paths%>include/javascripts/slides.js"></script>
    <script language="javascript" type="text/javascript" src="<%=paths%>include/javascripts/menu.js"></script>
    <script>
    $(function() {
        $('#slides').slides({
            preload: true,
            generateNextPrev: true
        });
    });
    </script>
</head>

<body>


<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="main"/>
<tiles:insertAttribute name="footer"/>

</body>
</html>