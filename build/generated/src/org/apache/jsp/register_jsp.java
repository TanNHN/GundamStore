package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Sign Up Form by Colorlib</title>\n");
      out.write("\n");
      out.write("        <!-- Font Icon -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/material-icon/css/material-design-iconic-font.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Main css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"colorlib-regform-9/css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"main\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"signup-content\">\n");
      out.write("                    <form action=\"MainController\" method=\"POST\" id=\"signup-form\" class=\"signup-form\">\n");
      out.write("                        <h2>Sign up </h2>\n");
      out.write("                        <p class=\"desc\">Join us<span>“Gundam plastic Builder”</span></p>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-input\" name=\"txtAccountName\" id=\"name\" placeholder=\"Account Name\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-input\" name=\"txtUserName\" id=\"email\" placeholder=\"Real Name\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"password\" class=\"form-input\" name=\"txtPassword\" id=\"password\" placeholder=\"Password\"/>\n");
      out.write("                            <span toggle=\"#password\" class=\"zmdi zmdi-eye field-icon toggle-password\"></span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"checkbox\" name=\"agree-term\" id=\"agree-term\" class=\"agree-term\" />\n");
      out.write("                            <label for=\"agree-term\" class=\"label-agree-term\"><span><span></span></span>I agree all statements in  <a href=\"#\" class=\"term-service\">Terms of service</a></label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"submit\" name=\"btnAction\" id=\"submit\" class=\"form-submit submit\" value=\"Sign up\"/>\n");
      out.write("                            <a href=\"login.jsp\" class=\"submit-link submit\">Sign in</a><br>\n");
      out.write("                            <br><center><a href=\"mainpage.jsp\"><font size=\"20\" color=\"white\"> <u>Back to main page</u> </font></a> </center> \n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- JS -->\n");
      out.write("        <script src=\"colorlib-regform-9/vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"colorlib-regform-9/js/main.js\"></script>\n");
      out.write("    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->\n");
      out.write("</html>");
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
