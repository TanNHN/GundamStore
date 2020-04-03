<%-- 
    Document   : ProductPage
    Created on : Oct 20, 2019, 2:22:41 PM
    Author     : Tan
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="dto.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Product Page</title>

        <link href="CSS/Css.css" rel="stylesheet" type="text/css"/>
        <style>

        </style>
    </head>

    <body>

        <div class="container">

            <header>

                <div class="info">
                    <div class="logo">
                        <a href="mainpage.jsp"><img src="img/banner.jpg" width="1280" height="230"></a></div>


                    <form action="MainController">

                        <input type="text" name="txtSearchItem"/>

                        <input type="submit" name="btnAction" value="SearchItem">

                    </form>


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
            <article class="contenthome">	
                <%
                    if (session.getAttribute("ROLE") == null || !session.getAttribute("ROLE").equals("AD")) {
                %>
                <form action="btnAction">
                    <% ProductDAO dao = new ProductDAO();
                        List<ProductDTO> list = dao.getAllProduct();
                        if (list != null) {
                            for (ProductDTO p : list) {
                                if (p.getQuantity() != 0) {

                    %>

                    <div class="sp">
                        <img src="<%=p.getPhoto()%>"/>
                        <p class="name"><%=p.getName()%></p>
                        <p class="price">Price: <%=p.getPrice()%>$ </p>
                        <a href="MainController?btnAction=AddToCart&ProductID=<%=p.getId()%>"><input type="button" value="Add to Cart"></a>
                    </div>
                    <% } %>
                    <%}%>
                </form>
                <%} else { %>
                No Product
                <% }
                } else if (session.getAttribute("ROLE").equals("AD")) {
                %>
                <form action="MainController">
                    <br><center><a href="MainController?btnAction=AddNewProduct"><input type="button" value="Add a Product"></a></h3> </center>
                            <% ProductDAO dao = new ProductDAO();
                                List<ProductDTO> list = dao.getAllProduct();
                                if (list != null) {
                                    for (ProductDTO p : list) {
                            %>
                    <div class="sp">
                        <input type="hidden" name="txtID" value="<%= p.getId()%>">
                        <input type="hidden" name="txtPhoto" value="<%=p.getPhoto()%>"><img src="<%=p.getPhoto()%>"/>
                        <input type="text" name="txtName" value="<%=p.getName()%>">
                        <p class="price">Price:<input type="text" name="txtPrice" value="<%=p.getPrice()%>">$</p>
                        Quantity:   <input type="text" name="txtQuantity" value="<%= p.getQuantity()%>">
                        <input type="submit" name="btnAction" value="Edit">
                        <a href="MainController?btnAction=DeleteProduct&txtID=<%= p.getId()%>"><input type="button" value="Delete" >    </a>
                    </div>
                    <% } %>
                </form>
                <%} else { %>
                No Product
                <% } %>
                <% }%>



            </article>

            <aside> 
                <h2>Daily </h2>
                <div class="newinfo">
                    <img src="img/mg-zgmf-x10a-freedom-gundam-ver-2-0-pa_1-min_800x.jpg" width="80" height="70"/>
                    <p>MG-zgmf Freedom Gundam Ver 2 has arrived, purchase it quick to get 20% coupon <br></p>
                </div>

                <div class="newinfo">
                    <img src="img/mg_justice_gundam_1_large.jpg" width="80" height="70"/>
                    <p>MG Justic Gundam will arrive shop in September 2019 </p>	
                </div>
                <h2>Information </h2>
                <div class="newinfo">
                    <img src="img/abc.jpg" width="260"/>
                    <img src="img/navin.jpg" width="260"/>
                </div>


            </aside>

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
        </div>

    </body>
</html>
