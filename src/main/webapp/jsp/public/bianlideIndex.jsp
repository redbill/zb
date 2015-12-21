<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
%>

<!DOCTYPE html>
<html>
  <body>
    <div id="preview"> </div>
    <script src="<script src="<%=paths%>include/components/markdown-js-0.5.0/lib/markdown.js""></script>
    <script>
      
          $("#preview").innerHTML = markdown.toHTML("便利得——让我们更“富有”!
        		  ======================



        			  ##网站产生的背景
        			  网站的背景是……





        			  ##如何解决这个背景问题
        			  我们如何通过这个网站解决问题……







        			                ——钱庆照20151221首发");
       
    </script>
  </body>
</html>