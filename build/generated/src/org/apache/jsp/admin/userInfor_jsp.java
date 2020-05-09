package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userInfor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/admin/header.jsp");
    _jspx_dependants.add("/admin/../footer.jsp");
  }

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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("  <title>Modern Business - Start Bootstrap Template</title>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core CSS -->\n");
      out.write("  <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <!-- Custom styles for this template -->\n");
      out.write("  <link href=\"css/modern-business.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <!-- Navigation -->\n");
      out.write("  <nav class=\"navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"index.html\">Start Bootstrap</a>\n");
      out.write("      <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("      </button>\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("        <ul class=\"navbar-nav ml-auto\">\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"index.jsp\">User Management</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"#\">Device Management</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"#\">Room Management</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"#\">Notification</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"../contact.html\">Contact</a>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("         \n");
      out.write("      </div>\n");
      out.write("       <a href=\"login.jsp\" class=\"btn-danger btn-sm align-baseline\">Logout</a>\n");
      out.write("    </div>\n");
      out.write("  </nav>");
      out.write("\n");
      out.write("  <!-- Page Content -->\n");
      out.write("  <div class=\"container\">\n");
      out.write("\n");
      out.write("    <!-- Page Heading/Breadcrumbs -->\n");
      out.write("    <h1 class=\"mt-4 mb-3\">Portfolio Item\n");
      out.write("      <small>Subheading</small>\n");
      out.write("    </h1>\n");
      out.write("\n");
      out.write("    <ol class=\"breadcrumb\">\n");
      out.write("      <li class=\"breadcrumb-item\">\n");
      out.write("        <a href=\"index.html\">Home</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"breadcrumb-item active\">Portfolio Item</li>\n");
      out.write("    </ol>\n");
      out.write("\n");
      out.write("    <!-- Portfolio Item Row -->\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("      <div class=\"col-md-8\">\n");
      out.write("        <img src=\"../image/avata.png\" alt=\"Avatar\" class=\"img-fluid\">\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"col-md-4\">\n");
      out.write("        <h3 class=\"my-3\">Project Description</h3>\n");
      out.write("        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>\n");
      out.write("        <h3 class=\"my-3\">Project Details</h3>\n");
      out.write("        <ul>\n");
      out.write("          <li>Lorem Ipsum</li>\n");
      out.write("          <li>Dolor Sit Amet</li>\n");
      out.write("          <li>Consectetur</li>\n");
      out.write("          <li>Adipiscing Elit</li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.row -->\n");
      out.write("\n");
      out.write("    <!-- Related Projects Row -->\n");
      out.write("    <h3 class=\"my-4\">Related Projects</h3>\n");
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("      <div class=\"col-md-3 col-sm-6 mb-4\">\n");
      out.write("        <a href=\"#\">\n");
      out.write("          <img class=\"img-fluid\" src=\"http://placehold.it/500x300\" alt=\"\">\n");
      out.write("        </a>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"col-md-3 col-sm-6 mb-4\">\n");
      out.write("        <a href=\"#\">\n");
      out.write("          <img class=\"img-fluid\" src=\"http://placehold.it/500x300\" alt=\"\">\n");
      out.write("        </a>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"col-md-3 col-sm-6 mb-4\">\n");
      out.write("        <a href=\"#\">\n");
      out.write("          <img class=\"img-fluid\" src=\"http://placehold.it/500x300\" alt=\"\">\n");
      out.write("        </a>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"col-md-3 col-sm-6 mb-4\">\n");
      out.write("        <a href=\"#\">\n");
      out.write("          <img class=\"img-fluid\" src=\"http://placehold.it/500x300\" alt=\"\">\n");
      out.write("        </a>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.row -->\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <!-- /.container -->\n");
      out.write(" <!-- Footer -->\n");
      out.write("  <footer class=\"py-5 bg-dark\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <p class=\"m-0 text-center text-white\">Copyright &copy; Your Website 2019</p>\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core JavaScript -->\n");
      out.write("  <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("  <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
      out.write('\n');
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
