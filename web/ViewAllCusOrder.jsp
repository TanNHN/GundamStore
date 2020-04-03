<%-- 
    Document   : ViewCusOrder
    Created on : Nov 11, 2019, 10:30:52 AM
    Author     : Tan
--%>

<%@page import="dto.ProductDTO"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="dto.OrderDetailDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.OrderDetailDAO"%>
<%@page import="dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.OrderDAO"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
    <html>
        <head>
            <meta charset="utf-8">
            <link rel="stylesheet" type="text/css" href="CSS/Css.css">
        </head>

        <body>

            <div class="container">

                <header>
                    <div class="container">
                        <div class="info">
                            <div class="logo"><a href="mainpage.jsp"><img src="img/banner.jpg" width="1280" height="230"></a></div>
                            <div class="search">
                                <form>
                                    <input type="text" name="search"/>
                                    <div class="iconsearch">
                                        <a href="ProductPage.jsp"><img src="img/698627-icon-111-search-512.png" width="30"/></a>
                                    </div>
                                </form>
                            </div>	
                        </div>	
                    </div>
                </header>

                <nav>
                    <a href="mainpage.jsp"> Home </a>
                    <a href="About.jsp"> About </a>
                    <a href="ProductPage.jsp"> Product </a>
                    <a href="News.jsp"> News </a>
                    <a href="Contact.jsp"> Contact </a>
                    <% if (session.getAttribute("ACCOUNTNAME") == null) {
                    %>
                    <a href="login.jsp">Login</a>  
                    <%} else {%>
                    <div class="dropdown">
                        <a class="dropbtn" href="MainController?btnAction=UserProfile"><%= session.getAttribute("ACCOUNTNAME")%>'s Profile ↓
                            <i class="fa fa-caret-down"></i>
                        </a>
                        <%
                            if (session.getAttribute("ROLE").equals("User")) {
                        %>
                        <div class="dropdown-content">
                            <a href="MainController?btnAction=UserProfile">View Profile</a>
                            <a href="Cart.jsp">View Cart</a>
                            <a href="UserOrder.jsp">View Order</a>
                            <a href="MainController?btnAction=LogOut">LogOut</a>
                        </div>
                        <%}
                            if (session.getAttribute("ROLE").equals("AD")) {%>
                        <div class="dropdown-content">
                            <a href="MainController?btnAction=UserProfile">View Profile</a>
                            <a href="MainController?btnAction=LogOut">LogOut</a>
                            <a href="MainController?btnAction=Search">Search</a>
                            <a href="ViewAllCusOrder.jsp">View Order</a>
                        </div>
                        <%}%>
                    </div>  
                    <%}%>
                </nav>
            </head>
            <article class="about">
                <h1> All Customer's Order </h1>

                <%
                    float total = 0;
                    OrderDetailDAO orderdetaildao = new OrderDetailDAO();
                    OrderDAO orderdao = new OrderDAO();
                    List<OrderDTO> orderList = orderdao.viewAllCusOrder();
                    ProductDTO product = null;
                    ProductDAO productdao = new ProductDAO();
                    if (orderList != null) {
                        for (int i = 0; i < orderList.size(); i++) {
                %>
                OrderID: <%= orderList.get(i).getOrderID()%><br>
                Order Date: <%= orderList.get(i).getOrderDate()%><br>
                UserID: <%= orderList.get(i).getUserID()%><br>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Image</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<OrderDetailDTO> orderDetailList = orderdetaildao.getOrderDetail(orderList.get(i).getOrderID());
                            int count = 1;
                            for (int j = 0; j < orderDetailList.size(); j++) {
                                product = productdao.getProductDetail(orderDetailList.get(j).getProductID());
                        %>
                        <tr>
                            <td><%= count++%></td>
                            <td><%= product.getId()%></td>
                            <td><%= product.getName()%></td>
                            <td><img src="<%= product.getPhoto()%>" width="200" height="150"></td>
                            <td><%= orderDetailList.get(j).getQuantity()%></td>
                            <td><%= product.getPrice()%></td>
                        </tr>
                        <%
                            total += orderDetailList.get(j).getQuantity() * product.getPrice();
                        %>
                        <%}%>
                    </tbody>
                </table>
                <h1><font color = "red">Total: <%= total%></font></h1>
                    <%total = 0;%>
                ---------------------------------------------------------------------------------------------------------------------------------<br>
                <%}%>
                <%}%>
            </article>>
    </body>
    <a href="mainpage.jsp">Back to MainPage</a>
</html>
