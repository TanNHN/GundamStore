<%-- 
    Document   : News
    Created on : Oct 20, 2019, 2:23:12 PM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>News</title>
        <link rel="stylesheet" type="text/css" href="CSS/Css.css">
        <style>

        </style>
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
            <article class="contentnew">

                <div class="new">
                    <img src="img/thum.jpg" align="left"/>			
                    <h2>"Monthly Hobby Japan April 2019 Issue" Released Today!</h2>
                    <p>Models, stop 2019, don't let them move, and how to enjoy character kits!</p>
                </div>
                <div class="new">
                    <img src="img/300.jpg" align="left"/>
                    <h2>
                        Yoshikazu Yasuhiko-Drawn Illustration for 200th Issue! "Monthly Gundam Ace April 2019 Issue" Released Today!</h2>
                    <p>Serial code to read the first issue & 200th memorial book included!</p>
                </div>
                <div class="new">
                    <img src="img/300x300.jpg" align="left"/>
                    <h2>"Narrative Gundam B-Packs" Appears! "FW GUNDAM CONVERGE ♯14" Released Today!</h2>
                    <p>"Gundam F90" and other 6 other variations appear!</p>
                </div>


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

