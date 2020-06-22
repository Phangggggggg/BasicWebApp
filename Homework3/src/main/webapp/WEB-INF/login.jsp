<%--
  Created by IntelliJ IDEA.
  User: phang
  Date: 17/6/2020 AD
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
    </head>
    <body>
    <h1>
        Login
    </h1>
        <p>
            ${error}
        </p>
        <p>
        <form action="/login" method="post">
            <label for="username"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" required>
            <br>
            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" required>
            <br>
            <br>
            <button type="submit" name="login">Login</button>
        </form>
        </p>
    </body>
</html>
