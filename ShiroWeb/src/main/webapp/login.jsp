<%--
  Created by IntelliJ IDEA.
  User: com.pxc
  Date: 2017/10/23
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/userLogin.do" method="post">
    用户名:<input type="text" id="username" name="username" />
    密码：<input type="password" id="password" name="password" />
    <button type="submit" value="提交">提交</button>
</form>

</body>
</html>
