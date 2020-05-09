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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/28ba37fb35.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            .my-5{\n");
      out.write("                margin-top: 7rem!important;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                /* The image used */\n");
      out.write("                background-image: url(\"image/body_backgrounf.jpg\");\n");
      out.write("                min-height: 100%;\n");
      out.write("                /* Center and scale the image nicely */\n");
      out.write("                background-position: center;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            .divider-text {\n");
      out.write("                position: relative;\n");
      out.write("                text-align: center;\n");
      out.write("                margin-top: 15px;\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("            }\n");
      out.write("            .divider-text span {\n");
      out.write("                padding: 7px;\n");
      out.write("                font-size: 12px;\n");
      out.write("                position: relative;   \n");
      out.write("                z-index: 2;\n");
      out.write("            }\n");
      out.write("            .divider-text:after {\n");
      out.write("                content: \"\";\n");
      out.write("                position: absolute;\n");
      out.write("                width: 100%;\n");
      out.write("                border-bottom: 1px solid #ddd;\n");
      out.write("                top: 55%;\n");
      out.write("                left: 0;\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("  <div class=\"container\">\n");
      out.write("      <div class=\"row\" >\n");
      out.write("      <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\n");
      out.write("        <div class=\"card card-signin my-5\">\n");
      out.write("          <div class=\"card-body\">\n");
      out.write("            <h5 class=\"card-title text-center\">Login</h5>\n");
      out.write("                <p class=\"divider-text\">\n");
      out.write("                    <span class=\"bg-light\"><i class=\"fab fa-tumblr-square fa-5x\"></i></span>\n");
      out.write("                </p>\n");
      out.write("                <form class=\"form-signin\" action=\"MainController\" method=\"POST\">\n");
      out.write("                <div class=\"form-label-group\">\n");
      out.write("                    <input type=\"text\" id=\"inputEmail\" class=\"form-control\" placeholder=\"UserID\" name=\"txtUserId\"  autofocus/><br/>\n");
      out.write("                    <font color=\"red\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.userIdError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                    </font>\n");
      out.write("                </div>\n");
      out.write("                    <br/>\n");
      out.write("\n");
      out.write("                <div class=\"form-label-group\">\n");
      out.write("                    <input type=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" name=\"txtPassword\"/><br/>\n");
      out.write("                    <font color=\"red\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.passwordError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                    </font>\n");
      out.write("                </div>\n");
      out.write("                    <br/>\n");
      out.write("\n");
      out.write("                <div class=\"custom-control custom-checkbox mb-3\">\n");
      out.write("                  <input type=\"checkbox\" class=\"custom-control-input\" id=\"customCheck1\" />\n");
      out.write("                  <label class=\"custom-control-label\" for=\"customCheck1\">Remember password</label>\n");
      out.write("                </div>\n");
      out.write("                    <button class=\"btn btn-lg btn-primary btn-block text-uppercase\" type=\"submit\" name=\"action\" value=\"Login\">Login</button>\n");
      out.write("                <hr class=\"my-4\">\n");
      out.write("                <p class=\"text-center\">Don't have account? <a href=\"Register.jsp\">Register</a> </p>     \n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
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
