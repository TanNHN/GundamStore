<%-- 
    Document   : Cart
    Created on : Oct 31, 2019, 10:25:53 PM
    Author     : Tan
--%>


<%@page import="dto.CartDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <html>
    <head>
        <meta charset="utf-8">
        <title>About Us</title>
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
            <article class="about">
                
        <%
            int count = 1;
            List<CartDTO> cart = (List<CartDTO>) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Available</th>
                    <th>Price</th>
                    <th>Quantity</th>

                    <th></th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController" method="POST">
                <%
                    float total = 0;
                    for (CartDTO c : cart) {

                %>
                <tr>
                    <td><%=count++%></td>
                    <td><input type="hidden" name="txtID" value="<%=c.getProduct().getId()%>"><%=c.getProduct().getId()%></td>
                    <td><%=c.getProduct().getName()%></td>
                    <td><img src="<%=c.getProduct().getPhoto()%>" width="200" height="150"></td>
                    <td><%=c.getProduct().getQuantity()%></td>
                    <td><%=c.getProduct().getPrice()%>$</td>
                    <td><input type="number" name="txtQuanity" value="<%=c.getQuantity()%>" max="<%=c.getProduct().getQuantity()%>" min = "1" ></td>
                    <td>Delete</td>

                </tr>
                <%
                    total += c.getQuantity() * c.getProduct().getPrice();
                    }
                %>
                <h2>Total: <%= total %></h2>
                <input type="submit" name="btnAction" value="Order"> 
            </form>
        </tbody>
    </table>

    <%} else {%>
    <h1>Your cart is empty</h1>

    <%}%>
    <h3><a href="ProductPage.jsp">Back to see more Product</a></h3>
    </article>
     <footer>
                <div class="footer_left">
                    <ul>
                        <li>Address 1: 2Nguyen Thai Son ward 4, Go Vap</li>
                        <li>Phone: 0123456</li>
                        <li>Guilde to buy Online</li>
                        <li>Guilde to buy installment</li>
                    </ul>
                </div>
                <div class="footer_center">
                    <ul>
                        <li>Address 2:Nguyen Thai ward 1, Go Cong</li>
                        <li>Phone: 012387654</li>
                        <li>Warranty policy</li>
                        <li>Setup software for free</li>
                    </ul>

                </div>
                <div class="footer_right">
                    <img src="img/phone.png" width="32" height="32"/>
                    <img src="img/Facebook-icon.png" width="32" height="32"/>
                    <img src="img/patreon-1-436862.png" width="32" height="32"/>
                    <img src="img/1_picto-tweeter.png" width="32" height="32"/>
                </div>
            </footer>
    </body>
</html>
</body>
</html>
