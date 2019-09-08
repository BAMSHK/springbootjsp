<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxh
  Date: 2019/9/8 0008
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
<div align="center">

</div>
<div style="width: 500px;margin: 20px auto;text-align: center">
    <table align="center" border="1" cellpadding="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editStudent?id=${c.id}">编辑</a></td>
                <td><a href="deleteStduent?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <a href="?start=1">[首页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末页]</a>
    </div>
    <form action="/addStudent" method="post">
        number:<input name="name"><br>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
