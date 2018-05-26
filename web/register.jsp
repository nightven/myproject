<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 21.05.2018
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="registerForm" method="post">
    Login: <input type="text" name="u_login" >
    </br>
    Name: <input type="text" name="u_name">
    </br>
    Last name: <input type="text" name="last_name">
    </br>
    Email: <input type="email" name="email">
    </br>
    Date of Birth: <input type="date" name="u_dob">
    </br>
    Password: <input type="password" name="password">
    </br>
    Confirm password: <input type="password" name="conf_password">
    </br>
    <input type="submit" value="Register">

</form>
</body>
</html>
