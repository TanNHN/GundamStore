<%-- 
    Document   : Contact
    Created on : Oct 20, 2019, 2:22:14 PM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Contract</title>
        <link rel="stylesheet" href="CSS/Css.css"/>
    </head>

    <body>
        <header>
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
                            <a href="MainController?btnAction=LogOut">LogOut</a>
                        </div>
                        <%}
                            if (session.getAttribute("ROLE").equals("AD")) {%>
                        <div class="dropdown-content">
                            <a href="MainController?btnAction=UserProfile">View Profile</a>
                            <a href="MainController?btnAction=LogOut">LogOut</a>
                            <a href="MainController?btnAction=Search">Search</a>
                        </div>
                        <%}%>

                    </div>  
                    <%}%>
                </nav>

                <article class="contentcontact">
                    <div class="contactleft">
                        <h2>Please register by filling in the form</h2>
                        <center>
                            <form action="#" method="post" name="register">
                                <table>
                                    <tr>
                                        <td>First name</td>
                                        <td><input type="text" name="firstname"/></td>
                                    </tr>
                                    <tr>
                                        <td>Last Name</td>
                                        <td><input type="text" name="lastname"/></td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                        <td><input type="email" name="email"/></td>
                                    </tr>
                                    <tr>
                                        <td>Address</td>
                                        <td><input type="text" name="Adress"/></td>
                                    </tr>
                                    <tr>
                                        <td>Date</td>
                                        <td><input type="text" name="date"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="text-align: center; padding-top: 20px;">
                                            <input type="submit" value="Order" class="btn"/>
                                            <input type="Reset" value="Cancel" class="btn"/>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </center>
                    </div>
                    <div class="contactright">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1003449.6851376573!2d106.13464179657574!3d10.755639069850973!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529292e8d3dd1%3A0xf15f5aad773c112b!2zSOG7kyBDaMOtIE1pbmgsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1551347438974" width="550" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>
                    </div>
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


