<%--
  Created by IntelliJ IDEA.
  User: pxc
  Date: 2017/10/31
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="/addUser.do" method="post">
        用户名:<input type="text" id="username" name="username" /><br>
        密码：<input type="password" id="password" name="password" /><br>
        备注<input type="text" id="remark" name="remark" /><br>
        <button type="submit" value="提交">提交</button>
    </form>
</head>
<body>

</body>
</html>
