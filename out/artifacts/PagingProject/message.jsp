<%@ page import="bean.Student" %>
<%@ page import="bean.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: LDK
  Date: 2019/5/6
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>
        .trtd{
            color:red;
        }
    </style>
</head>
<body>
This is message page. <br />分页页面。 <br /><br />
<table>
    <tr>
        <td class="trtd">编号</td>
        <td class="trtd">姓名</td>
        <td class="trtd">年龄</td>
        <td class="trtd">性别</td>
        <td class="trtd">成绩</td>
        <td class="trtd">住址</td>
    </tr>
    <c:forEach items="${pb.beanList }" var="student">
        <tr>
            <td>${student.id }</td>
            <td>${student.name }</td>
            <td>${student.age }</td>
            <td>${student.gender }</td>
            <td>${student.grade }</td>
            <td>${student.address }</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/tab.jsp"%>
</body>
</html>
