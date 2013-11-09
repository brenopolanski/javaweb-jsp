package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"cadForm centered\">\n");
      out.write("            <form action=\"resultado.jsp\" method=\"post\">\n");
      out.write("                <h2>Formulário</h2>\n");
      out.write("\n");
      out.write("                <div class=\"group-form\">\n");
      out.write("                    <label for=\"nome\">Nome</label>\n");
      out.write("                    <input name=\"nome\" id=\"nome\" type=\"text\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"group-form\">\n");
      out.write("                    <label for=\"sexo\">Sexo</label>\n");
      out.write("                    <input type=\"radio\" name=\"M\" id=\"M\"> <span>Masculino</span>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"radio\" name=\"F\" id=\"F\"> <span>Feminino</span>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"group-form\">\n");
      out.write("                    <label for=\"idade\">Idade</label>\n");
      out.write("                    <select name=\"idade\" id=\"idade\">\n");
      out.write("                        <option value=\"crianca\">0-12</option>\n");
      out.write("                        <option value=\"adolescente\">13-18</option>\n");
      out.write("                        <option value=\"adulto\">19-60</option>\n");
      out.write("                        <option value=\"idoso\">61 em diante</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"group-form\">\n");
      out.write("                    <input type=\"submit\" id=\"cadastrar\" name=\"cadastrar\" value=\"Cadastrar\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\t\n");
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
