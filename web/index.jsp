<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>$Title$</title>
  </head>
  <body>
    <form action="login" method="post">
      <input type="text" name="account" value="" placeholder="用户名/手机号/邮箱"><br>
      <input type="password" name="upass" value="" placeholder="请输入密码"><br>
      <button type="submit">登录</button>
      ${requestScope.msg}
    </form>
  </body>
</html>
