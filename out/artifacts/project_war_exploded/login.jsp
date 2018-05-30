<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 21.05.2018
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form name="logf" action="loginForm" method="post">
    <label for="u_login">Login : </label><input type="text" placeholder="login" name="u_login" id="u_login">
    </br>
    <label for="password"> Password :</label> <input type="password" placeholder="password" name="password" minlength="8" id="password">
    </br>
    <label for="logf">Save login and password</label><input type="checkbox" name="save"  id="logf"/>
    <input type="submit" value="Login">
</form>
</body>
</html>
