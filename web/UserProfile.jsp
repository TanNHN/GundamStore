<%-- 
    Document   : UserInfo
    Created on : Oct 20, 2019, 12:27:52 PM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>My Profile</title>
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

        <article class="about">

            UserID: <%= session.getAttribute("ID")%><br>
            UserName: <%= session.getAttribute("NAME")%><br>
            AccountName: <%= session.getAttribute("ACCOUNTNAME")%><br>
            ROLE: <%= session.getAttribute("ROLE")%>
            <%
                if (session.getAttribute("ROLE").equals("AD")) {
            %>
            <br>(AdminOnly) <a href="search.jsp">SeeUserList</a>

            <%}%>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script>
                $(document).ready(function () {
                    $("#flip").click(function () {
                        $("#panel").slideToggle("slow");
                    });
                });
            </script>
            <style> 
                #panel, #flip {
                    padding: 5px;
                    text-align: center;
                    background-color: #e5eecc;
                    border: solid 1px #c3c3c3;
                }

                #panel {
                    padding: 50px;
                    display: none;
                }
            </style>
        </head>
        <body>

            <div id="flip">* YOUR PASSWORD *</div>
            <div id="panel"><%= session.getAttribute("PASSWORD")%></div>

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
