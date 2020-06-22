<%@ page import="authentication.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>

<%
    List<User> allUser = (List<User>) request.getAttribute("allUser");
%>
<html>
<head>
    <title>List Page</title>
</head>
<body>
<p>
    ${cantDelete}
    ${canDelete}
    ${repeated}

</p>
    <center>
        <h2> User list </h2>
        <table bordercolor="black" border="1px solid black" width="400px">
            <thead>
                <tr bgcolor="#FFD700">
                    <th>No.</th>
                    <th>Name</th>
                    <th>Username</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <% for(int i=0; i<allUser.size(); i++) {%>
                    <tr align="center">
                        <td><%=(i+1)%></td>
                        <td><%=allUser.get(i).getName()%></td>
                        <td><%=allUser.get(i).getUserName()%></td>
                        <td>
                            <form action= "/listpage" method="post">
                                <button type="submit" name="delete" value=<%=allUser.get(i).getUserName()%> style="background-color:#F5F5DC">Delete
                                </button>
                            </form>
                        </td>
                        <td> <form action= "/listpage" method="post">
                            <button type="submit" name="edit" value=<%=allUser.get(i).getUserName()%> style="background-color:#F5F5DC">Edit
                            </button>
                        </form></td>
                    </tr>
                <%}%>
            </tbody>
        </table>


        <br><br><br>
    </center>
    <br>
    <center>
    <h3> Add User </h3>
    <form action= "/listpage" method="post">
        <button type="submit" name="addUser">Add User
        </button>
    </form>
    </center>
</body>
</html>
