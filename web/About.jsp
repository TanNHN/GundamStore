<%-- 
    Document   : About
    Created on : Oct 20, 2019, 2:24:02 PM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
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
                        <a href="MainController?btnAction=ViewCart">View Cart</a>
                        <a href="MainController?btnAction=LogOut">LogOut</a>
                    </div>
                    <%} else {%>
                    <div class="dropdown-content">
                        <a href="MainController?btnAction=UserProfile">View Profile</a>
                        <a href="MainController?btnAction=LogOut">LogOut</a>
                        <a href="MainController?btnAction=Search">Search</a>
                        <%}%>
                    </div>
                </div>  
                <%}%>
            </nav>
            <article class="about">
                <h3>What is Gundam? </h3>
                <center>
                    <img src="img/c60375cdc94ae4c5297e21eef7c87567.jpg" width="1000"/>
                </center>
                <p>Gundam models are model kits depicting the vehicles and characters of the fictional Gundam multiverse by Bandai. These kits have become popular among mecha anime fans and model enthusiasts in Japan and in other nearby Asian countries since the 1980s. Gundam modeling spread in the 1990s with North America and Europe being exposed to Gundam through television, video and manga. Gundam models, as well as the hobby of assembling and painting them, is known in Japan as Gunpla (ガンプラ Ganpura), a portmanteau of "Gundam plastic model", plastic being the most common material for the retail kits.</p>
                <h3>Scale and grade</h3>
                <img src="img/shop_gundam_sd_grande.png"/>
                <img src="img/shop_gundam_hg_grande.png"/>
                <img src="img/shop_gundam_rg_grande.png"/>
                <img src="img/shop_gundam_mg_grande.png"/>
                <h3>Shop's gundam collection</h3>
                <center>
                    <img src="img/gundam-kits-collection (4).jpg" width="1161" height="777"/>
                    <img src="img/a3c7851ac2324f3ddafa682e9075c77db3352f7f.jpg"/>
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/Te-O4RJiJLo" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </center>


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

