<%-- 
    Document   : mainpage
    Created on : Oct 19, 2019, 12:52:54 AM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Main Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/Css.css">
        <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
        <script src="js/jssor.slider-22.2.8.mini.js" type="text/javascript"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {

                var jssor_1_SlideshowTransitions = [
                    {$Duration: 1200, $Opacity: 2}
                ];

                var jssor_1_options = {
                    $AutoPlay: true,
                    $SlideshowOptions: {
                        $Class: $JssorSlideshowRunner$,
                        $Transitions: jssor_1_SlideshowTransitions,
                        $TransitionsOrder: 1
                    },
                    $ArrowNavigatorOptions: {
                        $Class: $JssorArrowNavigator$
                    },
                    $BulletNavigatorOptions: {
                        $Class: $JssorBulletNavigator$
                    }
                };

                var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

                /*responsive code begin*/
                /*you can remove responsive code if you don't want the slider scales while window resizing*/
                function ScaleSlider() {
                    var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
                    if (refSize) {
                        refSize = Math.min(refSize, 1280);
                        jssor_1_slider.$ScaleWidth(refSize);
                    } else {
                        window.setTimeout(ScaleSlider, 30);
                    }
                }
                ScaleSlider();
                $(window).bind("load", ScaleSlider);
                $(window).bind("resize", ScaleSlider);
                $(window).bind("orientationchange", ScaleSlider);
                /*responsive code end*/
            });
        </script>
        <style>
            /* jssor slider bullet navigator skin 05 css */
            /*
            .jssorb05 div           (normal)
            .jssorb05 div:hover     (normal mouseover)
            .jssorb05 .av           (active)
            .jssorb05 .av:hover     (active mouseover)
            .jssorb05 .dn           (mousedown)
            */
            .jssorb05 {
                position: absolute;
            }
            .jssorb05 div, .jssorb05 div:hover, .jssorb05 .av {
                position: absolute;
                /* size of bullet elment */
                width: 16px;
                height: 16px;
                background: url('img/b05.png') no-repeat;
                overflow: hidden;
                cursor: pointer;
            }
            .jssorb05 div { background-position: -7px -7px; }
            .jssorb05 div:hover, .jssorb05 .av:hover { background-position: -37px -7px; }
            .jssorb05 .av { background-position: -67px -7px; }
            .jssorb05 .dn, .jssorb05 .dn:hover { background-position: -97px -7px; }

            /* jssor slider arrow navigator skin 12 css */
            /*
            .jssora12l                  (normal)
            .jssora12r                  (normal)
            .jssora12l:hover            (normal mouseover)
            .jssora12r:hover            (normal mouseover)
            .jssora12l.jssora12ldn      (mousedown)
            .jssora12r.jssora12rdn      (mousedown)
            */
            .jssora12l, .jssora12r {
                display: block;
                position: absolute;
                /* size of arrow element */
                width: 30px;
                height: 46px;
                cursor: pointer;
                background: url('img/a12.png') no-repeat;
                overflow: hidden;
            }
            .jssora12l { background-position: -16px -37px; }
            .jssora12r { background-position: -75px -37px; }
            .jssora12l:hover { background-position: -136px -37px; }
            .jssora12r:hover { background-position: -195px -37px; }
            .jssora12l.jssora12ldn { background-position: -256px -37px; }
            .jssora12r.jssora12rdn { background-position: -315px -37px; }
        </style>
    </head>
    <body>
        <div class="container">
            <header>

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
            <article class="fontpage">
                <div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:1280px;height:250px;overflow:hidden;visibility:hidden;">
                    <!-- Loading Screen -->
                    <div data-u="loading" style="position:absolute;top:0px;left:0px;background-color:rgba(0,0,0,0.7);">
                        <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
                        <div style="position:absolute;display:block;background:url('img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
                    </div>

                    <!-- Hiệu chỉnh độ rộng và độ cao cho các ảnh trong slideshow-->
                    <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:1280px;height:250px;overflow:hidden;">
                        <div>
                            <img data-u="image" src="img/GLimited_Banner_GUNPLA_2016 V5b.png" />
                        </div>
                        <div>
                            <img data-u="image" src="img/sl2.jpg" />
                        </div>
                        <div>
                            <img data-u="image" src="img/sl3.jpg" />
                        </div>
                        <div>
                            <img data-u="image" src="img/GUNDAM_CROSSWAR_BANNER_2.jpg" />
                        </div>
                    </div>
                    <!-- Bullet Navigator -->
                    <div data-u="navigator" class="jssorb05" style="bottom:16px;right:16px;" data-autocenter="1">
                        <!-- bullet navigator item prototype -->
                        <div data-u="prototype" style="width:16px;height:16px;"></div>
                    </div>
                    <!-- Arrow Navigator -->
                    <span data-u="arrowleft" class="jssora12l" style="top:0px;left:0px;width:30px;height:46px;" data-autocenter="2"></span>
                    <span data-u="arrowright" class="jssora12r" style="top:0px;right:0px;width:30px;height:46px;" data-autocenter="2"></span>
                </div>
                <h1>Top 5 models of 2019</h1>
                <center>
                    <div class="divrank">
                        <center>
                            <div class="model"><center>
                                    <img src="img/gr1.jpg"/>
                                </center>
                                <p class="namer">Shinanju MG 1/100 </p>
                                <div class="rank">
                                    <img src="img/rank1.png"/>
                                </div>
                            </div><div class="model"><center>
                                    <img src="img/gr2.jpg"/>
                                </center>
                                <p class="namer">RX-78GP</p>
                                <div class="rank">
                                    <img src="img/rank2.png"/>
                                </div>
                            </div>
                            <div class="model"><center>
                                    <img src="img/gr3.jpg"/>
                                </center>
                                <p class="namer">RX-0 Unicorn</p>

                                <div class="rank">
                                    <img src="img/rank3.png"/>
                                </div>
                            </div>
                            <div class="model"><center>
                                    <img src="img/gr4.jpg"/>
                                </center>
                                <p class="namer">Metal Build Eva 01</p>
                                <div class="rank">
                                    <img src="img/rank4.png"/>
                                </div>
                            </div>
                            <div class="model"><center>
                                    <img src="img/gr5.jpg"/>
                                </center>
                                <p class="namer">FAM Stylet</p>
                                <div class="rank">
                                    <img src="img/rank5.png"/>
                                </div>
                            </div>
                        </center>
                    </div>
                    <h2>Available at Shop</h2>
                    <img src="img/CIMG3760_resize.JPG" width="700" height="525"/>
                    <img src="img/shop-sinanju-rg.jpg"/>
                </center>
                <center><h2>Coming soon</h2></center>
                <div class="spc">
                    <img src="img/moongundam01-133x133.jpg">
                    <p class="name">Moon Gundam</p>
                    <p class="price">Price: N/A</p>
                </div>
                <div class="spc">
                    <img src="img/tvBarbatosDD-133x133.jpg">
                    <p class="name">Gundam Barbatos</p>
                    <p class="price">Price: N/A</p>
                </div>
                <div class="spc">
                    <img src="img/uni.jpg">
                    <p class="name">FAM Stylet</p>
                    <p class="price">Price: N/A</p>
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
    </body>
</div>
</html>

