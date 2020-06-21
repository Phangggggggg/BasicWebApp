<%--
  Created by IntelliJ IDEA.
  User: phang
  Date: 21/6/2020 AD
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<h1>Edit name</h1>
<form action="/edit" method="post">
    <label for="editName"><b>Name you want to edit</b></label>
    <input type="text" placeholder="Enter Edited Name" name="editName" required>
    <button type="submit" name="edit">Confirm</button>
    <br>
</form>

<%--    <label for="username"><b>Username</b></label>--%>
<%--        <input type="text" placeholder="Enter Username" name="username" required>--%>
<%--    <br>--%>
<body>

</body>
</html>
