package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pe.backus.factory.sqlDaoRascalFactoryImpl;
import com.pe.backus.factory.sqlDaoRascal2FactoryImpl;
import com.pe.backus.factory.sqlDaoFactoryImpl;
import com.pe.backus.factory.CerrarCursor;
import com.pe.backus.factory.sqlDaoLocalFactoryImpl;
import java.sql.Connection;
import com.pe.backus.dao.impl.clienteSqlDaoImpl;

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
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("  if(history.forward(1)){\n");
      out.write("    location.replace( history.forward(1) );\n");
      out.write("  }\n");
      out.write("</script>   \n");
      out.write("\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <form  name=\"formulario\" id=\"formulario\">\n");
      out.write("        \n");
 String login =request.getParameter("LOGIN");
String logout =request.getParameter("LOGOUT");
String anexo =request.getParameter("ANEXO");
if(anexo != null){
session.setAttribute("sessionAnexo", anexo);
}
String preparado=request.getParameter("EST_PREP");
String nopreparado=request.getParameter("EST_NOPREP");
String nopreparadomanual=request.getParameter("NOPREP_MANUAL");
String drop =request.getParameter("Drop");   
String var="";
String campanita=request.getParameter("CAMPAIGN"); ;
String numcli=request.getParameter("Account_Number");
String Setcamapaid= request.getParameter("CampaId");
String Setqueryid= request.getParameter("QueryId");
String cam= "CAMP_"+campanita;
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection   cn_rascal2= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();
CerrarCursor cerrar = new CerrarCursor();
Integer Id= sqlImplements.obtenerCodigo(cam,cn_rascal2);
String codcliente=sqlImplements.codigocliente(Id,cn_rascal2);
 String  campacod;
String camquery;
if (Setcamapaid == null ||   Setcamapaid ==""  ){
    
    campacod =   sqlImplements.ListIdCamap(campanita, 1, cn_rascal2);
    
session.setAttribute("CampaId", campacod);

 }else{
   campacod=  Setcamapaid;
 }
 if (Setqueryid == null ||   Setqueryid ==""  ){
 
  camquery=   sqlImplements.ListIdCamap(campanita, 2, cn_rascal2);
 session.setAttribute("QueryId", camquery);
 } else{
     camquery=Setqueryid;
 }



      out.write("\n");
      out.write("\n");
      out.write(" <input type='hidden' name='codcli' value='");
      out.print(codcliente);
      out.write("'> \n");
      out.write(" \n");
      out.write(" ");

if(numcli!=null  ){  
  String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
 

      out.write('\n');
      out.write('\n');
 if( numcli.equals("")){  
      out.write("\n");
      out.write("\n");
      out.write(" ");

   
        
    String codnull = sqlImplements.selectCodNulo(campacod, camquery ,cn_ippc);
System.out.println("el codigo impreso del procedure====>"+codnull);
   // 
 ////// if (codnull== null || codnull.equals("") || codnull.equals("null") ){
      /////out.println("codclientee   ===>"+codnull);
 ////}else{

      out.write("\n");
      out.write("\n");
      out.write("<input type=\"hidden\" name=\"codnull\" id=\"codnull\" value=\"");
      out.print(codnull);
      out.write("\">\n");
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("//alert(\"Presionar Boton Enviar CodCliente\");\n");
      out.write("enviarcodnull();\n");
      out.write("</script>\n");
      out.write("\n");
///// }
  }
  
  else{
      
     if(estadocad.equals("Preparado")){
   
  }else{
       String estado="Preparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
    
      out.write("\n");
      out.write(" <script language=\"javascript\">\n");
      out.write("   soloprepa();\n");
      out.write("</script>   \n");
      out.write(" ");

  }


      out.write(" \n");
      out.write("<script language=\"javascript\">   \n");
      out.write("\n");
      out.write("var campa= locationVars('CAMPAIGN') ;\n");
      out.write("var codcli= locationVars('Account_Number');\n");
      out.write("var campaña =\"CAMP_\"+campa;  \n");
      out.write("var valor = \"valor\";\n");
      out.write("\n");
      out.write("window.open(\"http://10.165.70.246:8080/FichaCliente/CONSULTOR2.jsp?campana=\"+campaña+\"&Account_Number=\"+codcli+\"&campa=\"+campa,\"consultor\");\n");
      out.write(" \n");
      out.write("//window.open(\"http://10.165.70.246:8080/FichaCliente/logon.jsp?CAMPAIGN=\"+campa+\"&Account_Number=\"+codcli,\"procedure\");\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("</script> \n");

}

      out.write(" \n");
      out.write("\n");
}else if(campanita!=null && anexo!=null && login!=null){ String estado="Login"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql); 
      out.write('\n');
      out.write('\n');
}else if(campanita!=null && anexo!=null && preparado!=null){
String estadocad=   sqlImplements.estadocad(campanita,cn_sql);

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

if(estadocad.equals("Inicia manual sin cliente") || estadocad.equals("Inicia manual con cliente")   ){
//String estado="Fin de Manual"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
}
  if(estadocad.equals("Preparado")){
  }else{
     String estado="Preparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
   
      out.write("\n");
      out.write("  <script language=\"javascript\">\n");
      out.write("   soloprepa();\n");
      out.write("</script>\n");
      out.write("   ");

  }

      out.write('\n');
      out.write('\n');
}else if(campanita!=null && anexo!=null && nopreparado!=null){
String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
out.print("estado anterior :"+estadocad); 
// String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado);

      out.write('\n');
if(estadocad.equals("Login")){ 
  String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
  
  

      out.write("  \n");
      out.write("<script language=\"javascript\">\n");
      out.write("    //alert(\"Inicio No preparado\");\n");
      out.write(" sinclicktocall();\n");
      out.write(" </script>\n");
}else if(estadocad.equals("Preparado")){  
  String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
  
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("//alert(\"Inicia manual sin cliente\");\n");
      out.write("sincliente();\n");
      out.write("</script>  \n");
      out.write(" \n");
}else if(estadocad.equals("Error Agente")){   
      out.write("   \n");
      out.write("<script language=\"javascript\">\n");
      out.write("//alert(\"Inicia manual sin cliente\");\n");
      out.write("sincliente();\n");
      out.write("</script>\n");
   //String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado);
  String  estado="Inicia manual sin cliente"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql); 
      out.write('\n');
}else if(estadocad.equals("clicktocall")){   
String estado="Fin de Manual"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);

      out.write("   \n");
}else if(estadocad.equals("Inicia manual sin cliente")){   
      out.write("  \n");
}else {
      out.write("\n");
      out.write("\n");
      out.write("\n");
}
      out.write('\n');
      out.write('\n');
}else if(campanita!=null && anexo!=null  && nopreparadomanual!=null){
String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
out.print("estado anterior :"+estadocad);  
      out.write('\n');
 if(estadocad.equals("Preparado")){ 
String estado="NoPreparadoM"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql) ;
String error="Error Agente";
sqlImplements.insertarestador( campanita,  anexo, "no hay",error,cn_sql);  
      out.write('\n');
      out.write('\n');
}else if(estadocad.equals("Inicia manual con cliente")){   
      out.write("  \n");
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("concliente();\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
}else if(estadocad.equals("Inicia manual sin cliente")){   
      out.write("  \n");
}else if(estadocad.equals("Fin de Manual")){  
   String estado="Inicia manual con cliente"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
      out.write("   \n");
      out.write("<script language=\"javascript\">\n");
      out.write("concliente();\n");
      out.write("</script>\n");
} else if(estadocad.equals("NoPreparado")) {
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("sincliente();\n");
      out.write("</script>\n");
  String estado="Inicia manual sin cliente"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql) ;  
      out.write('\n');
 } 
      out.write('\n');
      out.write('\n');
}else if(campanita!=null && anexo!=null && logout!=null){  String estado="Logout"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);           
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("sinclicktocall();\n");
      out.write("</script>\n");
}else{    }
cerrar.cerrar(cn_sql);

      out.write("\n");
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
