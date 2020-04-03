<%-- 
    Document   : search
    Created on : Oct 19, 2019, 3:31:00 PM
    Author     : Tan
--%>

<%@page import="dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome <%= session.getAttribute("ACCOUNTNAME")%></h1>
        <form action="MainController">
            Search: <input type="text" name="txtSearch" value="<%= session.getAttribute("SEARCHVALUE")%>">
            <input type="submit" name="btnAction" value="Search">
            <input type="submit" name="btnAction" value="LogOut">
        </form>
        <a href="mainpage.jsp"> Go back to Main Page </a>
        <%
            List<UserDTO> list = (List<UserDTO>) session.getAttribute("LISTMEMBER");
            int count = 0;
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>UserName</th>
                    <th>Account Name</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Order</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserDTO elem : list) {


                %>

                <tr>
            <form action="MainController">
                <td><%=++count%> </td>
                <td><input type="hidden" name="txtID" value="<%=elem.getUserID()%>"><%=elem.getUserID()%></td>
                <td><input type="text" name="txtUserName" value="<%=elem.getUserName()%>"></td>
                <td><input type="hidden" name="txtAccountName" value="<%=elem.getAccountName()%>"> <%=elem.getAccountName()%></td>
                <td><input type="text" name="txtPassword" value="<%=elem.getAccountPassword()%>"></td>
                <td><input type="text" name="txtRole" value="<%=elem.getRole()%>"></td>
                <td><input type="submit" name="btnAction" value="Update"> </td>
                
                    <%
                        if (elem.getRole().equals("User")) {
                    %>
                    <td><input type="submit" name="btnAction" value="ViewOrder"> </td>
                    <td><input type="submit" name="btnAction" value="Delete"></td>
                    <%                        }
                    %>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>


    <%}%>
</body>
</html>
