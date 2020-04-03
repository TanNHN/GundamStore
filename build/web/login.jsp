<%-- 
    Document   : login
    Created on : Oct 19, 2019, 1:46:30 AM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Login Screen</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">

        <script>
            window.console = window.console || function (t) {};
            window.open = function () {
                console.log('window.open is disabled.');
            };
            window.print = function () {
                console.log('window.print is disabled.');
            };
            if (false) {
                window.ontouchstart = function () {};
            }
        </script>

    </head>

    <body>

        <div class="wrapper">
            <div class="container">
                <h1>Welcome to GundamStore</h1>

                <form action="MainController">
                    <input type="text" name="txtUserName" placeholder="Username" />
                    <input type="password" name="txtPassword" placeholder="Password" />
                    <input type="submit" name="btnAction" value="Login">
                    <h3>or</h3>
                    <a href="register.jsp"><input type="button" value="Register"></a>
                    <a href="mainpage.jsp"><font color='white'><u>Back to main page</u></font></a>
                </form>

            </div>

            <!--- for more background effect, just  delete this comment line, thank you
            
            <ul class="bg-bubbles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
            
            -->
        </div>

        <script src='js/jquery.js'></script>
        <script>
            if (document.location.search.match(/type=embed/gi)) {
                window.parent.postMessage('resize', "*");
            }
        </script>

        <script src="js/timeout.js"></script>
        <script>
            $('#login-button').click(function (event) {
                event.preventDefault();
                $('form').fadeOut(800);
                $('.wrapper').addClass('form-success');
            });

        </script>

    </body>

</html>

