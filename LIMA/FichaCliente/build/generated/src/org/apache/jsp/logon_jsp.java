package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pe.backus.factory.sqlDaoRascalFactoryImpl;
import com.pe.backus.factory.sqlDaoRascal2FactoryImpl;
import com.pe.backus.factory.CerrarCursor;
import com.pe.backus.factory.sqlDaoLocalFactoryImpl;
import java.sql.Connection;
import com.pe.backus.dao.impl.clienteSqlDaoImpl;

public final class logon_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src =\"js/login.js\"> </script> \n");
      out.write("        \n");
      out.write("      <META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form  name=\"formulario\" id=\"formulario\">\n");
      out.write("  \n");
      out.write("   \n");
      out.write("\n");
      out.write("      \n");
      out.write("      ");

    
   String numcli=request.getParameter("Account_Number");
   System.out.println("Account_Number================>"+numcli);
   String campanita=request.getParameter("CAMPAIGN"); 
   String campana= "CAMP_"+campanita;
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
Connection   cn_rascalCopia= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
  if(numcli==null || numcli=="" ){
      
  }else{

      // out.println("Hoal"); 
       
      String sesAnexo=(String)session.getAttribute("sessionAnexo");
     System.out.println("sessionanexo=============>"+sesAnexo);
      String cortanexo= sesAnexo.substring(2);
     System.out.println("anexooooooo=======>"+cortanexo );
     /////
sqlImplements.execProcedureTel(campana,numcli,"1"+cortanexo, cn_rascalCopia);   

  }
   
      out.write("     \n");
      out.write("\n");
      out.write("</form>\n");
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
