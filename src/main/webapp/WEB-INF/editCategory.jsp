<%--
  Created by IntelliJ IDEA.
  User: zxh
  Date: 2019/9/8 0008
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑页面</title>
</head>
<body>
    <div style="margin:0px auto;width:500px">
        <form action="/updateCategory" method="post">
            name:<input name="name" value="${c.name}"><br>
            <input name="id" type="hidden" value="${c.id}">
            <button type="submit" >提交</button>
        </form>
    </div>
</body>
</html>
