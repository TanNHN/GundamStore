package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Login Screen</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/style.css\">\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            window.console = window.console || function (t) {};\n");
      out.write("            window.open = function () {\n");
      out.write("                console.log('window.open is disabled.');\n");
      out.write("            };\n");
      out.write("            window.print = function () {\n");
      out.write("                console.log('window.print is disabled.');\n");
      out.write("            };\n");
      out.write("            if (false) {\n");
      out.write("                window.ontouchstart = function () {};\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1>Welcome to GundamStore</h1>\n");
      out.write("\n");
      out.write("                <form action=\"MainController\">\n");
      out.write("                    <input type=\"text\" name=\"txtUserName\" placeholder=\"Username\" />\n");
      out.write("                    <input type=\"password\" name=\"txtPassword\" placeholder=\"Password\" />\n");
      out.write("                    <input type=\"submit\" name=\"btnAction\" value=\"Login\">\n");
      out.write("                    <h3>or</h3>\n");
      out.write("                    <a href=\"register.jsp\"><input type=\"button\" value=\"Register\"></a>\n");
      out.write("                    <a href=\"mainpage.jsp\"><font color='white'><u>Back to main page</u></font></a>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--- for more background effect, just  delete this comment line, thank you\n");
      out.write("            \n");
      out.write("            <ul class=\"bg-bubbles\">\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("                    <li></li>\n");
      out.write("            </ul>\n");
      out.write("            \n");
      out.write("            -->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src='js/jquery.js'></script>\n");
      out.write("        <script>\n");
      out.write("            if (document.location.search.match(/type=embed/gi)) {\n");
      out.write("                window.parent.postMessage('resize', \"*\");\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <script src=\"js/timeout.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $('#login-button').click(function (event) {\n");
      out.write("                event.preventDefault();\n");
      out.write("                $('form').fadeOut(800);\n");
      out.write("                $('.wrapper').addClass('form-success');\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
