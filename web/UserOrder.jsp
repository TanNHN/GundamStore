<%-- 
    Document   : UserOrder
    Created on : Nov 4, 2019, 2:41:02 PM
    Author     : Tan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.UserDTO"%>
<%@page import="DAO.UserDAO"%>
<%@page import="DAO.OrderDAO"%>
<%@page import="dto.ProductDTO"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="DAO.OrderDetailDAO"%>
<%@page import="dto.OrderDetailDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.OrderDTO"%>
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
            <body>
                <article class="about">
                    <h2>Your Order</h2>
                    <% UserDTO user = null;
                        float total = 0;
                        OrderDetailDAO orderDetaildao = new OrderDetailDAO();
                        OrderDAO orderdao = new OrderDAO();
                        UserDAO userdao = new UserDAO();
                        List<OrderDetailDTO> orderDetailList = new ArrayList<>();
                        //            ProductDAO productdao = new ProductDAO();
                        //            OrderDetailDAO orderDetaildao = new OrderDetailDAO();
                        user = userdao.getUserInfo(Integer.parseInt(session.getAttribute("USERID").toString()));
                        List<OrderDTO> order = (List<OrderDTO>) orderdao.getUserOrder(user.getUserID());
                        ProductDAO productdao = new ProductDAO();
                        ProductDTO productDetail = null;
                        int count = 1;
                        if (order != null) {
                            for (int i = 0; i < order.size(); i++) {
                    %>
                    Ordered from ID: <%= user.getUserID()%> <br>
                    Name: <%= user.getUserName()%><br>
                    OrderID: <%= order.get(i).getOrderID()%><br>
                    Date: <%= order.get(i).getOrderDate()%><br>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Photo</th>
                                <th>Quantity</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%

                                orderDetailList = orderDetaildao.getOrderDetail(order.get(i).getOrderID());
                                if (orderDetailList != null) {
                                    for (int j = 0; j < orderDetailList.size(); j++) {
                                        productDetail = productdao.getProductDetail(orderDetailList.get(j).getProductID());
                                        if (productDetail != null) {
                            %>
                            <tr>
                                <td><%=count++%></td>
                                <td><%= productDetail.getId()%></td>
                                <td><%= productDetail.getName()%></td>
                                <td><img src="<%= productDetail.getPhoto()%>" width="200" height="150"></td>
                                <td><%= orderDetailList.get(j).getQuantity()%></td>
                                <td><%= productDetail.getPrice()%></td>
                            </tr>
                            <%
                                total += orderDetailList.get(j).getQuantity() * productDetail.getPrice();
                            %>
                            <%}%>
                            <%}%>
                            <%}%>
                        </tbody>
                    </table>
                    <%}%>
                    <h1> <font color="red">Total:    <%= total%>$</font></h1>
                        <%} else { %>
                    You have no Order
                    <%}%>

                    <a href="mainpage.jsp">Main Page</a>
                </article>
            </body>
</html>
