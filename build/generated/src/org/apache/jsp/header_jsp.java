package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Catalogio</title>\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<link rel=\"stylesheet\" media=\"screen,projection\" type=\"text/css\" href=\"../css/main.css\" />\n");
      out.write("<!--[if lte IE 6]><link rel=\"stylesheet\" type=\"text/css\" href=\"css/main-msie.css\" /><![endif]-->\n");
      out.write("<link rel=\"stylesheet\" media=\"print\" type=\"text/css\" href=\"../css/print.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"../js/prototype.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../js/tabs.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../js/tooltip.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../js/showdetail.js\"></script>\n");
      out.write("<style>\n");
      out.write("    body{\n");
      out.write("        background-image: url(\"../image/body_backgrounf.jpg\");\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"main\">\n");
      out.write("  <!-- Header -->\n");
      out.write("  <div id=\"header\">\n");
      out.write("    <h1 id=\"logo\"><a href=\"http://all-free-download.com/free-website-templates/\"><img src=\"../design/logo.gif\" alt=\"\" /></a></h1>\n");
      out.write("    <hr class=\"noscreen\" />\n");
      out.write("    <!-- Date -->\n");
      out.write("    <div class=\"date date-24\">\n");
      out.write("      <p class=\"nom\">Today is <strong>Monday, March 24th 2009</strong><br />\n");
      out.write("        <span class=\"nonhigh\"><a href=\"http://all-free-download.com/free-website-templates/\">Make Catalogio your homepage</a></span></p>\n");
      out.write("    </div>\n");
      out.write("    <!-- /date -->\n");
      out.write("    <hr class=\"noscreen\" />\n");
      out.write("  </div>\n");
      out.write("  <!-- /header -->\n");
      out.write("  <!-- Tabs -->\n");
      out.write("  <div id=\"search-tabs\" class=\"box\">\n");
      out.write("    <ul id=\"search-type\">\n");
      out.write("      <li><a href=\"#s01\"><span>Internet</span></a></li>\n");
      out.write("      <li><a href=\"#s02\"><span>Firms</span></a></li>\n");
      out.write("      <li><a href=\"#s03\"><span>Articles</span></a></li>\n");
      out.write("      <li><a href=\"#s04\"><span>Images</span></a></li>\n");
      out.write("      <li><a href=\"#s05\"><span>News</span></a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("  <!-- /search-tabs -->\n");
      out.write("  <!-- Search -->\n");
      out.write("  <div id=\"search-top\"></div>\n");
      out.write("  <div id=\"search\">\n");
      out.write("    <div id=\"search-in\">\n");
      out.write("      <div id=\"s01\">\n");
      out.write("        <form action=\"http://all-free-download.com/free-website-templates/\" method=\"get\">\n");
      out.write("          <p class=\"nom t-center\">\n");
      out.write("            <label for=\"search-input01\">Internet:</label>\n");
      out.write("            <input type=\"text\" size=\"75\" name=\"\" id=\"search-input01\" />\n");
      out.write("            <input type=\"image\" value=\"Search\" src=\"design/search-button.gif\" class=\"search-submit\" />\n");
      out.write("          </p>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"s02\">\n");
      out.write("        <form action=\"http://all-free-download.com/free-website-templates/\" method=\"get\">\n");
      out.write("          <p class=\"nom t-center\">\n");
      out.write("            <label for=\"search-input02\">Firms:</label>\n");
      out.write("            <input type=\"text\" size=\"75\" name=\"\" id=\"search-input02\" />\n");
      out.write("            <input type=\"image\" value=\"Search\" src=\"design/search-button.gif\" class=\"search-submit\" />\n");
      out.write("          </p>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"s03\">\n");
      out.write("        <form action=\"http://all-free-download.com/free-website-templates/\" method=\"get\">\n");
      out.write("          <p class=\"nom t-center\">\n");
      out.write("            <label for=\"search-input03\">Articles:</label>\n");
      out.write("            <input type=\"text\" size=\"75\" name=\"\" id=\"search-input03\" />\n");
      out.write("            <input type=\"image\" value=\"Search\" src=\"design/search-button.gif\" class=\"search-submit\" />\n");
      out.write("          </p>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"s04\">\n");
      out.write("        <form action=\"http://all-free-download.com/free-website-templates/\" method=\"get\">\n");
      out.write("          <p class=\"nom t-center\">\n");
      out.write("            <label for=\"search-input04\">Images:</label>\n");
      out.write("            <input type=\"text\" size=\"75\" name=\"\" id=\"search-input04\" />\n");
      out.write("            <input type=\"image\" value=\"Search\" src=\"design/search-button.gif\" class=\"search-submit\" />\n");
      out.write("          </p>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"s05\">\n");
      out.write("        <form action=\"http://all-free-download.com/free-website-templates/\" method=\"get\">\n");
      out.write("          <p class=\"nom t-center\">\n");
      out.write("            <label for=\"search-input05\">News:</label>\n");
      out.write("            <input type=\"text\" size=\"75\" name=\"\" id=\"search-input05\" />\n");
      out.write("            <input type=\"image\" value=\"Search\" src=\"design/search-button.gif\" class=\"search-submit\" />\n");
      out.write("          </p>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <hr class=\"noscreen\" />\n");
      out.write("    </div>\n");
      out.write("    <!-- /search-in -->\n");
      out.write("  </div>\n");
      out.write("  <!-- /search -->\n");
      out.write("  <div id=\"search-bottom\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    new Control.Tabs('search-type');\n");
      out.write("    </script>\n");
      out.write("  <!-- Content -->\n");
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
