package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import dto.UserDTO;
import DAO.UserDAO;
import DAO.OrderDAO;
import dto.ProductDTO;
import DAO.ProductDAO;
import DAO.OrderDetailDAO;
import dto.OrderDetailDTO;
import java.util.List;
import dto.OrderDTO;

public final class UserOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Order Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Your Order</h2>\n");
      out.write("        ");
 UserDTO user = null;
            float total = 0;
            OrderDetailDAO orderDetaildao = new OrderDetailDAO();
            OrderDAO orderdao = new OrderDAO();
            UserDAO userdao = new UserDAO();
            List<OrderDetailDTO> orderDetailList = new ArrayList<>();
//            ProductDAO productdao = new ProductDAO();
//            OrderDetailDAO orderDetaildao = new OrderDetailDAO();
            user = userdao.getUserInfo(Integer.parseInt(session.getAttribute("USERID").toString()));
            List<OrderDTO> order = (List<OrderDTO>) orderdao.getUserOrder(user.getUserID());
            ProductDAO productdao = new ProductDAO();
            ProductDTO productDetail = null;
            int count = 1;
            if (order != null) {
                for (int i = 0; i < order.size(); i++) {
        
      out.write("\n");
      out.write("        Ordered from ID: ");
      out.print( user.getUserID());
      out.write(" <br>\n");
      out.write("        Name: ");
      out.print( user.getUserName());
      out.write("<br>\n");
      out.write("        OrderID: ");
      out.print( order.get(i).getOrderID());
      out.write("<br>\n");
      out.write("        Date: ");
      out.print( order.get(i).getOrderDate());
      out.write("<br>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>No</th>\n");
      out.write("                    <th>Product ID</th>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Photo</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");


                    orderDetailList = orderDetaildao.getOrderDetail(order.get(i).getOrderID());
                    if (orderDetailList != null) {
                        for (int j = 0; j < orderDetailList.size(); j++) {
                            productDetail = productdao.getProductDetail(orderDetailList.get(j).getProductID());
                            if (productDetail != null) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(count++);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( productDetail.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( productDetail.getName());
      out.write("</td>\n");
      out.write("                    <td><img src=\"");
      out.print( productDetail.getPhoto());
      out.write("\" width=\"200\" height=\"150\"></td>\n");
      out.write("                    <td>");
      out.print( orderDetailList.get(j).getQuantity());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( productDetail.getPrice());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    total += orderDetailList.get(j).getQuantity() * productDetail.getPrice();
                
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <h1> <font color=\"red\">Total:    ");
      out.print( total);
      out.write("$</font></h1>\n");
      out.write("        ");
} else { 
      out.write("\n");
      out.write("        You have no Order\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        <a href=\"mainpage.jsp\">Main Page</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
