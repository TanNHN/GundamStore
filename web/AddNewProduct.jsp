<%-- 
    Document   : AddNewProduct
    Created on : Nov 18, 2019, 1:36:01 PM
    Author     : Tan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new product Page</title>
    </head>
    <body>
        <form action="MainController">
            Product ID: <input type="text" name="txtID"><br>
            Product Name: <input type="text" name="txtName"><br>
            Product price: <input type="text" name="txtPrice"><br>
            Product Quantity: <input type="text" name="txtQuantity"><br>
            Image: <input type="text" name="txtPhoto" ><br>
            (Copy your image to folder GundamStore\web\img then type img/(*image name*))<br>    
            <input type="submit" name="btnAction" value="AddProduct"><br>
            <a href="ProductPage.jsp">Back to product page</a>
            
        </form>
    </body>
</html>
