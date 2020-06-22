<%--
  Created by IntelliJ IDEA.
  User: phang
  Date: 17/6/2020 AD
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration </title>
</head>
<body>
<p>
    ${repeated}
</p>
<p>
<h1>Register</h1>
<form action="/register" form method="post">
    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>
    <br>
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
    <br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br>
    <br>
    <button type="submit" name="register">register</button>
</form>
</p>
</body>
</html>