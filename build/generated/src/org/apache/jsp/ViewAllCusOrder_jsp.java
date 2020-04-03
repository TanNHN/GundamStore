package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.ProductDTO;
import DAO.ProductDAO;
import dto.OrderDetailDTO;
import java.util.ArrayList;
import DAO.OrderDetailDAO;
import dto.OrderDTO;
import java.util.List;
import DAO.OrderDAO;
import DAO.UserDAO;

public final class ViewAllCusOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View Customer Order Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1> All Customer's Order </h1>\n");
      out.write("\n");
      out.write("        ");

            OrderDetailDAO orderdetaildao = new OrderDetailDAO();
            OrderDAO orderdao = new OrderDAO();
            List<OrderDTO> orderList = orderdao.viewAllCusOrder();
            ProductDTO product = null;
            ProductDAO productdao = new ProductDAO();
            if (orderList != null) {
                for (int i = 0; i < orderList.size(); i++) {
        
      out.write("\n");
      out.write("        OrderID: ");
      out.print( orderList.get(i).getOrderID());
      out.write("<br>\n");
      out.write("        Order Date: ");
      out.print( orderList.get(i).getOrderDate());
      out.write("<br>\n");
      out.write("        UserID: ");
      out.print( orderList.get(i).getUserID());
      out.write("<br>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>No.</th>\n");
      out.write("                    <th>Product ID</th>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    List<OrderDetailDTO> orderDetailList = orderdetaildao.getOrderDetail(orderList.get(i).getOrderID());
                    int count = 1;
                    for (int j = 0; j < orderDetailList.size(); j++) {
                        product = productdao.getProductDetail(orderDetailList.get(j).getProductID());
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( count++);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getName());
      out.write("</td>\n");
      out.write("                    <td><img src=\"");
      out.print( product.getPhoto());
      out.write("\" width=\"200\" height=\"150\"></td>\n");
      out.write("                    <td>");
      out.print( orderDetailList.get(j).getQuantity() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( product.getPrice());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <a href=\"mainpage.jsp\">Back to MainPage</a>\n");
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
