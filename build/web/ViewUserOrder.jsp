<%-- 
    Document   : ViewUserOrder
    Created on : Nov 11, 2019, 12:48:15 PM
    Author     : Tan
--%>

<%@page import="DAO.ProductDAO"%>
<%@page import="dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.OrderDetailDTO"%>
<%@page import="DAO.OrderDetailDAO"%>
<%@page import="dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View User Order Page</title>
    </head>
    <body>
        <%
            float total = 0;
            ProductDAO productdao = new ProductDAO();
            OrderDetailDAO orderDetaildao = new OrderDetailDAO();
            List<OrderDetailDTO> orderDetailList = new ArrayList<>();
            ProductDTO product = null;
            List<OrderDTO> orderList = (List<OrderDTO>) session.getAttribute("USERORDER");
        %>
        <form action="MainController">
            <%
                if (orderList != null) {
                    for (int i = 0; i < orderList.size(); i++) {
                        orderDetailList = orderDetaildao.getOrderDetail(orderList.get(i).getOrderID());
            %>
            Order ID: <%= orderList.get(i).getOrderID()%>
            Order Date: <%= orderList.get(i).getOrderDate()%>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Image</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (int j = 0; j < orderDetailList.size(); j++) {
                            product = productdao.getProductDetail(orderDetailList.get(j).getProductID());
                    %>
                    <tr>
                        <td><%= count++%></td>
                        <td><%= product.getId()%></td>
                        <td><%= product.getName()%></td>
                        <td><img src="<%=product.getPhoto()%>" width="250" height="200"></td>
                        <td><%= orderDetailList.get(j).getQuantity()%></td>
                        <td><%= product.getPrice()%></td>
                    </tr>
                    <%
                        total += orderDetailList.get(j).getQuantity() * product.getPrice();
                    %>
                    <%}%>
                </tbody>
            </table>

                    <a href="MainController?btnAction=Deliver&orderID=<%= orderList.get(i).getOrderID()%>"><input type="button"value="Deliver"></a> <br>
                <%}%>
                <%} else {%>
            This user has no Order
            <%}%>

            <h2> <input type="hidden" name="txtTotal" value="<%= total%>"> <font color="red">Total: <%= total%> </font></h2>
        </form>
        <a href="search.jsp">Back to Search Page</a>
    </body>
</html>
