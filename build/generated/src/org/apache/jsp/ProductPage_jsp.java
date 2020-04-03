package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import DAO.ProductDAO;
import dto.ProductDTO;

public final class ProductPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Product Page</title>\n");
      out.write("\n");
      out.write("        <link href=\"CSS/Css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <header>\n");
      out.write("\n");
      out.write("                <div class=\"info\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <a href=\"mainpage.jsp\"><img src=\"img/banner.jpg\" width=\"1280\" height=\"230\"></a></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <form action=\"MainController\">\n");
      out.write("\n");
      out.write("                        <input type=\"text\" name=\"txtSearchItem\" value=\"rg\"/>\n");
      out.write("\n");
      out.write("                        <input type=\"submit\" name=\"btnAction\" value=\"SearchItem\">\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\t\n");
      out.write("\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <nav>\n");
      out.write("                <a href=\"mainpage.jsp\"> Home </a>\n");
      out.write("                <a href=\"About.jsp\"> About </a>\n");
      out.write("                <a href=\"ProductPage.jsp\"> Product </a>\n");
      out.write("                <a href=\"News.jsp\"> News </a>\n");
      out.write("                <a href=\"Contact.jsp\"> Contact </a>\n");
      out.write("                ");
 if (session.getAttribute("ACCOUNTNAME") == null) {
                
      out.write("\n");
      out.write("                <a href=\"login.jsp\">Login</a>  \n");
      out.write("                ");
} else {
      out.write("\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <a class=\"dropbtn\" href=\"MainController?btnAction=UserProfile\">");
      out.print( session.getAttribute("ACCOUNTNAME"));
      out.write("'s Profile ↓\n");
      out.write("                        <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    ");

                        if (session.getAttribute("ROLE").equals("User")) {
                    
      out.write("\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"MainController?btnAction=UserProfile\">View Profile</a>\n");
      out.write("                        <a href=\"Cart.jsp\">View Cart</a>\n");
      out.write("                        <a href=\"UserOrder.jsp\">View Order</a>\n");
      out.write("                        <a href=\"MainController?btnAction=LogOut\">LogOut</a>\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
                        if (session.getAttribute("ROLE").equals("AD")) {
      out.write("\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"MainController?btnAction=UserProfile\">View Profile</a>\n");
      out.write("                        <a href=\"MainController?btnAction=LogOut\">LogOut</a>\n");
      out.write("                        <a href=\"MainController?btnAction=Search\">Search</a>\n");
      out.write("                        <a href=\"ViewAllCusOrder.jsp\">View Order</a>\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>  \n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </nav>\n");
      out.write("            <article class=\"contenthome\">\t\n");
      out.write("                ");

                    if (session.getAttribute("ROLE") == null || !session.getAttribute("ROLE").equals("AD")) {
                
      out.write("\n");
      out.write("                <form action=\"btnAction\">\n");
      out.write("                    ");
 ProductDAO dao = new ProductDAO();
                        List<ProductDTO> list = dao.getAllProduct();
                        if (list != null) {
                            for (ProductDTO p : list) {
                                if (p.getQuantity() != 0) {

                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"sp\">\n");
      out.write("                        <img src=\"");
      out.print(p.getPhoto());
      out.write("\"/>\n");
      out.write("                        <p class=\"name\">");
      out.print(p.getName());
      out.write("</p>\n");
      out.write("                        <p class=\"price\">Price: ");
      out.print(p.getPrice());
      out.write("$ </p>\n");
      out.write("                        <a href=\"MainController?btnAction=AddToCart&ProductID=");
      out.print(p.getId());
      out.write("\"><input type=\"button\" value=\"Add to Cart\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </form>\n");
      out.write("                ");
} else { 
      out.write("\n");
      out.write("                No Product\n");
      out.write("                ");
 }
                } else if (session.getAttribute("ROLE").equals("AD")) {
                
      out.write("\n");
      out.write("                <form action=\"MainController\">\n");
      out.write("                    <br><center><a href=\"MainController?btnAction=AddNewProduct\"><input type=\"button\" value=\"Add a Product\"></a></h3> </center>\n");
      out.write("                            ");
 ProductDAO dao = new ProductDAO();
                                List<ProductDTO> list = dao.getAllProduct();
                                if (list != null) {
                                    for (ProductDTO p : list) {
                            
      out.write("\n");
      out.write("                    <div class=\"sp\">\n");
      out.write("                        <input type=\"hidden\" name=\"txtID\" value=\"");
      out.print( p.getId());
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"txtPhoto\" value=\"");
      out.print(p.getPhoto());
      out.write("\"><img src=\"");
      out.print(p.getPhoto());
      out.write("\"/>\n");
      out.write("                        <input type=\"text\" name=\"txtName\" value=\"");
      out.print(p.getName());
      out.write("\">\n");
      out.write("                        <p class=\"price\">Price:<input type=\"text\" name=\"txtPrice\" value=\"");
      out.print(p.getPrice());
      out.write("\">$</p>\n");
      out.write("                        Quantity:   <input type=\"text\" name=\"txtQuantity\" value=\"");
      out.print( p.getQuantity());
      out.write("\">\n");
      out.write("                        <input type=\"submit\" name=\"btnAction\" value=\"Edit\">\n");
      out.write("                        <a href=\"MainController?btnAction=DeleteProduct&txtID=");
      out.print( p.getId());
      out.write("\"><input type=\"button\" value=\"Delete\" >    </a>\n");
      out.write("                    </div>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </form>\n");
      out.write("                ");
} else { 
      out.write("\n");
      out.write("                No Product\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </article>\n");
      out.write("\n");
      out.write("            <aside> \n");
      out.write("                <h2>Daily </h2>\n");
      out.write("                <div class=\"newinfo\">\n");
      out.write("                    <img src=\"img/mg-zgmf-x10a-freedom-gundam-ver-2-0-pa_1-min_800x.jpg\" width=\"80\" height=\"70\"/>\n");
      out.write("                    <p>MG-zgmf Freedom Gundam Ver 2 has arrived, purchase it quick to get 20% coupon <br></p>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"newinfo\">\n");
      out.write("                    <img src=\"img/mg_justice_gundam_1_large.jpg\" width=\"80\" height=\"70\"/>\n");
      out.write("                    <p>MG Justic Gundam will arrive shop in September 2019 </p>\t\n");
      out.write("                </div>\n");
      out.write("                <h2>Information </h2>\n");
      out.write("                <div class=\"newinfo\">\n");
      out.write("                    <img src=\"img/abc.jpg\" width=\"260\"/>\n");
      out.write("                    <img src=\"img/navin.jpg\" width=\"260\"/>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </aside>\n");
      out.write("\n");
      out.write("            <footer>\n");
      out.write("                <div class=\"footer_left\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li>Address 1: 2Nguyen Thai Son ward 4, Go Vap</li>\n");
      out.write("                        <li>Phone: 0123456</li>\n");
      out.write("                        <li>Guilde to buy Online</li>\n");
      out.write("                        <li>Guilde to buy installment</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer_center\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li>Address 2:Nguyen Thai ward 1, Go Cong</li>\n");
      out.write("                        <li>Phone: 012387654</li>\n");
      out.write("                        <li>Warranty policy</li>\n");
      out.write("                        <li>Setup software for free</li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer_right\">\n");
      out.write("                    <img src=\"img/phone.png\" width=\"32\" height=\"32\"/>\n");
      out.write("                    <img src=\"img/Facebook-icon.png\" width=\"32\" height=\"32\"/>\n");
      out.write("                    <img src=\"img/patreon-1-436862.png\" width=\"32\" height=\"32\"/>\n");
      out.write("                    <img src=\"img/1_picto-tweeter.png\" width=\"32\" height=\"32\"/>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("\n");
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
