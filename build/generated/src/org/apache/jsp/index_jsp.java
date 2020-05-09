package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/toolBar.jsp");
    _jspx_dependants.add("/body.jsp");
    _jspx_dependants.add("/footer.jsp");
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>Corporate Blue Theme - Free Website Template</title>\n");
      out.write("<meta name=\"keywords\" content=\"corporate blue, theme, free templates, website templates, CSS, HTML\" />\n");
      out.write("<meta name=\"description\" content=\"Corporate Blue Theme is a free website template provided by tooplate.com\" />\n");
      out.write("<link href=\"tooplate_style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">\n");
      out.write("function clearText(field)\n");
      out.write("{\n");
      out.write("    if (field.defaultValue == field.value) field.value = '';\n");
      out.write("    else if (field.value == '') field.value = field.defaultValue;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<!--   Free Website Template by t o o p l a t e . c o m   -->\n");
      out.write("</head>\n");
      out.write("<body> \n");
      out.write("\n");
      out.write("<div id=\"tooplate_header_wrapper\">\n");
      out.write("\t<div id=\"tooplate_header\">\n");
      out.write("    \n");
      out.write("    \t<div id=\"site_title\">\n");
      out.write("            <h1><a href=\"http://www.tooplate.com\" rel=\"nofollow\"><img src=\"images/tooplate_logo.png\" alt=\"logo\" /><span>Your tagline goes here</span></a></h1>\n");
      out.write("        </div> <!-- end of site_title -->\n");
      out.write("        \n");
      out.write("        <div id=\"header_right\">\n");
      out.write("        \n");
      out.write("        \t<div id=\"social_box\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"#\"><img src=\"images/facebook.png\" alt=\"facebook\" /></a></li>\n");
      out.write("                    <li><a href=\"#\"><img src=\"images/twitter.png\" alt=\"twitter\" /></a></li>\n");
      out.write("                    <li><a href=\"#\"><img src=\"images/linkedin.png\" alt=\"linkin\" /></a></li>\n");
      out.write("                    <li><a href=\"#\"><img src=\"images/technorati.png\" alt=\"technorati\" /></a></li>\n");
      out.write("                    <li><a href=\"#\"><img src=\"images/myspace.png\" alt=\"myspace\" /></a></li>                \n");
      out.write("                </ul>\n");
      out.write("                <div class=\"cleaner\"></div>\n");
      out.write("\t\t\t</div>   \n");
      out.write("\t\t\t         \n");
      out.write("             <div id=\"search_box\">\n");
      out.write("                <form action=\"#\" method=\"get\">\n");
      out.write("                    <input type=\"text\" value=\"Search\" name=\"q\" size=\"10\" id=\"searchfield\" title=\"searchfield\" onfocus=\"clearText(this)\" onblur=\"clearText(this)\" />\n");
      out.write("                  <input type=\"submit\" name=\"Search\" value=\"\" id=\"searchbutton\" title=\"Search\" />\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \t\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("        ");
      out.write("<div id=\"tooplate_menu\">\n");
      out.write("                \n");
      out.write("    <ul>\n");
      out.write("        <li><a href=\"index.html\" class=\"current\">Home</a></li>\n");
      out.write("        <li><a href=\"about.html\">About Us</a></li>\n");
      out.write("        <li><a href=\"services.html\">Services</a></li>\n");
      out.write("        <li><a href=\"gallery.html\">Gallery</a></li>\n");
      out.write("        <li><a href=\"contact.html\">Contact</a></li>\n");
      out.write("    </ul>    \t\n");
      out.write("\n");
      out.write("\t<div class=\"cleaner\"></div>\n");
      out.write("</div> <!-- end of templatetooplate_menu -->");
      out.write("\n");
      out.write("        ");
      out.write("<div id=\"tooplate_content\">\n");
      out.write("\n");
      out.write("\t<div id=\"services\">\n");
      out.write("        <div class=\"col_w300\">\n");
      out.write("            <h3 class=\"service1\">Web Design</h3>\n");
      out.write("            <p>Nunc lobortis, mi a pellentesque posuere, lorem felis vulputate lectus, sit amet bibendum.</p>\n");
      out.write("            <div class=\"btn_more\"><a href=\"#\">More...</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"col_w300\">\n");
      out.write("            <h3 class=\"service2\">Online Marketing</h3>\n");
      out.write("            <p>Suspendisse vitae velit augue. Quisque a cursus purus. Suspendisse eros orci bibendum in leo.</p>\n");
      out.write("            <div class=\"btn_more\"><a href=\"#\">More...</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"col_w300 last_col\">\n");
      out.write("            <h3 class=\"service3\">Social Networking</h3>\n");
      out.write("            <p>Maecenas venenatis bibendum metus eget blandit. Nam leo justo, convallis nec aliquet.</p>\n");
      out.write("            <div class=\"btn_more\"><a href=\"#\">More...</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"cleaner\"></div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"content_box content_box_last\">\n");
      out.write("    \t<div class=\"col_w460\">\n");
      out.write("        \t<h2> Welcome to Corporate Blue</h2>\n");
      out.write("            <div class=\"image_wrapper image_fl\"><img src=\"images/tooplate_image_02.jpg\" alt=\"Image 02\" /></div>\n");
      out.write("          \n");
      out.write("            <p><em>Nam porta mauris nec odio sollicitudin sodales urna in nulla commodo luctus.</em></p>\n");
      out.write("            <p>Corporate Blue is a free <a rel=\"nofollow\" href=\"http://www.tooplate.com\" target=\"_parent\">website template</a> for everyone and it can be used for any purpose. Credits go to <a rel=\"nofollow\" href=\"http://www.photovaco.com/\" target=\"_blank\">Free Photos</a> for photos and <a rel=\"nofollow\" href=\"http://www.brusheezy.com/brush/1407-Solid-Tech-Rings\" target=\"_blank\">Photoshop Tutorials</a> for Solid Tech Rings Brush.</p>\n");
      out.write("            \n");
      out.write("            <div class=\"cleaner_h20\"></div>\n");
      out.write("            <h6>Vivamus at ipsum at neque fringilla</h6>\n");
      out.write("            <ul class=\"tooplate_list\">\n");
      out.write("                <li>Sapien odio iaculis dui</li>\n");
      out.write("                <li>Curabitur ullamcorper</li>\n");
      out.write("                <li>Pellentesque adipiscing</li>\n");
      out.write("                <li>Molestie sit amet nisi</li>\n");
      out.write("            </ul>\n");
      out.write("            \n");
      out.write("            <div class=\"btn_more\"><a href=\"#\">More...</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"col_w460 last_col\">\n");
      out.write("        \t<h2>Sed venenatis mattis dignissim</h2>\n");
      out.write("            <div class=\"image_wrapper\"><img src=\"images/tooplate_image_03.jpg\" alt=\"Image 03\" /></div>\n");
      out.write("            <p><em>Cras fringilla, velit ac facilisis viverra, tortor velit hendrerit erat, sed pharetra nulla mi in lectus.</em></p>\n");
      out.write("            <p>Aenean dolor mi, malesuada eget consequat tristique, tempor vehicula ligula. Ut quis nibh orci, fermentum consequat est. Proin porta congue enim, a interdum mi hendrerit quis. Validate <a href=\"http://validator.w3.org/check?uri=referer\" rel=\"nofollow\"><strong>XHTML</strong></a> and <a href=\"http://jigsaw.w3.org/css-validator/check/referer\" rel=\"nofollow\"><strong>CSS</strong></a>.</p>\n");
      out.write("            <p>Vivamus at ipsum at neque fringilla imperdiet non gravida velit. Donec vel enim leo, at elementum augue. Phasellus at suscipit dolor. Cras vulputate, tortor in lobortis imperdiet, ante urna ultricies elit, ut suscipit tortor tortor ac tellus.</p>\n");
      out.write("            <div class=\"btn_more\"><a href=\"#\">More...</a></div>\n");
      out.write("        </div>\n");
      out.write("\t\t\n");
      out.write("        <div class=\"cleaner\"></div>            \n");
      out.write("    </div>\n");
      out.write("\t\n");
      out.write("    <div class=\"cleaner\"></div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("        ");
      out.write("<div id=\"tooplate_footer_wrapper\">\n");
      out.write("\n");
      out.write("     <div id=\"tooplate_footer\">\n");
      out.write("    \n");
      out.write("        Copyright © 2048 <a href=\"#\">Company Name</a>\n");
      out.write("    \n");
      out.write("    </div> \n");
      out.write("     <!-- end of templatetooplate_footer -->\n");
      out.write("</div> \n");
      out.write("<!--   Free Website Template by t o o p l a t e . c o m   -->\n");
      out.write("</body>\n");
      out.write("</html>");
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
