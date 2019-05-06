<%--
  Created by IntelliJ IDEA.
  User: LDK
  Date: 2019/4/28
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Title</title>
  </head>
  <body>
  This is index page.
  <br />
  <form action="student" method="post">
    <input type="submit" value="分页跳转" />
  </form>
  </body>
</html>
