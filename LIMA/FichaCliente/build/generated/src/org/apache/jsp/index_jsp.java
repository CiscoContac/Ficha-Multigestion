package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pe.backus.factory.oraclefactooriginal;
import com.pe.backus.factory.sqlDaoFactoryImpl;
import com.pe.backus.factory.sqlDaoRascalFactoryImpl;
import com.pe.backus.factory.sqlDaoLocalFactoryImpl;
import com.pe.backus.factory.oracleDaoLocalFactoryImpl;
import java.sql.Connection;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.pe.backus.dto.beanTelefonoClienteLista;
import com.pe.backus.dto.beanClienteTelefono;
import com.pe.backus.dto.beanClienteTelefono;
import java.util.List;
import com.pe.backus.dao.impl.clienteSqlDaoImpl;
import com.pe.backus.dao.impl.clienteOracleDaoImpl;
import com.pe.backus.dto.beanDetalladoCliente;
import com.pe.backus.dto.beanTelefonoParentesco;
import java.util.ArrayList;

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
      response.setContentType("text/html;charset=ISO-8859-1");
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
      out.write("    \n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("  <link href=\"styles/estilos.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <script   src =\"js/detalleLlamada.js\">\n");
      out.write("\n");
      out.write("       </script>\n");
      out.write("\n");
      out.write("        <META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n");
      out.write("        <title>DetalleLlamadas</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("<!--\n");
      out.write(".Estilo4 {\n");
      out.write("\tfont-size: 12px;\n");
      out.write("\tfont-weight: bold;\n");
      out.write("\tfont-family: \"Trebuchet MS\";\n");
      out.write("}\n");
      out.write("-->\n");
      out.write("        </style>\n");
      out.write("                   <META HTTP-EQUIV=\"pragma\" CONTENT=\"no-cache\">\n");
      out.write("<META HTTP-EQUIV=\"cache-control \" CONTENT=\"no-cache\">\n");
      out.write("<META http-equiv=\"expires\" content=\"0\">\n");
      out.write("<META name=\"expires\" content=\"Wed, 01 jan 1997 00:00:00 GMT\">\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("  if(history.forward(1)){\n");
      out.write("    location.replace( history.forward(1) );\n");
      out.write("  }\n");
      out.write("</script>   \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body >\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");


          String campana = request.getParameter("campana");
          //out.println("CAMPANA DE INDEX"+campana);
          String xcodigo= request.getParameter("codcli");
          String campa= request.getParameter("campa");
          //out.println("campa DE INDEX"+campa);
String manual =  request.getParameter("manual");
String contador=  request.getParameter("contador");
String consultor=  request.getParameter("consultor");
String validacion = request.getParameter("validacion");
String flagBusqueda = request.getParameter("flagBusqueda");
  
String  anclafiltro = request.getParameter("anclafiltro");
String where = (String)request.getAttribute("where");
   if(where== null || where.equals("null")){
    where="";
    
   }
   session.setAttribute("wherejsp", where);
   
   //CONEXION CON BASE DE DATOS        
   ///Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();
  Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
 Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();
  
clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
List<beanDetalladoCliente> DetalleCliente =null;


      out.write('\n');
      out.write('\n');

if (campana == null || campana.equals("") ){
    
    
}else{
if (validacion == null){
    
DetalleCliente  = orasql.ObtenerDetalle(campana,cn_ippc);
   cn_ippc.close();
session.setAttribute("sessiondetallado", DetalleCliente);
 //out.println("Entro la primera vez");
    }
if(flagBusqueda==null){
    
}else

if(flagBusqueda.equals("1")){
    session.setAttribute("campanaSesion", campana);
    List<beanDetalladoCliente> DetalleClienteBusqueda = null;
    DetalleClienteBusqueda = (ArrayList)request.getAttribute("ListObtenerDetalle");
    session.setAttribute("sessiondetallado", DetalleClienteBusqueda);
}
}
List<beanDetalladoCliente> cliente =(ArrayList) session.getAttribute("sessiondetallado");





beanDetalladoCliente beanDetalladoCliente;
beanDetalladoCliente bdetalle = null;
        
List<beanTelefonoClienteLista> telefono = orasql.ObtenerTelefonoLista(xcodigo,cn_sql);
//beanClienteTelefono beanClienteTelefono;
beanTelefonoClienteLista beanClienteFono = null;

//List<beanTelefonoParentesco>  ListaParentesco = oraCliente.ObtenerTelefonoParentesco(xcodigo,cnNC);
//cnNC.close();
//beanTelefonoParentesco   beanTelefonoParentesco;  
beanTelefonoParentesco     parentesco=null;
   


 SimpleDateFormat formateador = new SimpleDateFormat("dd' de 'MMMM' 'yyyy' 'HH':'mm':'ss");
       Date fechaDate = new Date();
        String fecha=formateador.format(fechaDate);



if (anclafiltro !=null){
    
      out.write("\n");
      out.write("    \n");
      out.write("    <script language=\"javascript\">\n");
      out.write("    redifiltro('#filtro')    \n");
      out.write("    \n");
      out.write("    </script>\n");
      out.write("    ");

}
//LLENANDO EL BEAN CON DATOS  DEL CLIENTE JALADOS DEL IPCC
  for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);}


        
      out.write("\n");
      out.write("        <form id='form3' name='form3' method='post' style=\"font-family: 'Trebuchet MS'; font-size: 12px;\" >\n");
      out.write("\n");
      out.write("<table width=\"1400\" height=\"48\">\n");
      out.write("        <tr> \n");
      out.write("            <td width=\"545\" height=\"42\" align=\"center\"><div id =\"divactu\" style=\"display: none\">\n");
      out.write("                    <label>\n");
      out.write("                        <img  src=\"img/refrescar.jpg\"   alt=\"Refrescar\"  id=\"fresh\"  value=\"Refresh\"  onclick=\"refrescar()\"style=\"width:90px;height:65px\">\n");
      out.write("                    </label></div></td>\n");
      out.write("        <td width=\"650\" align=\"right\" >  <br> Leyenda de Call Result :   <img src=\"img/u11_normal.jpg\" alt=\"Mostrar\"    onclick=\"mostrar()\"  width=\"20\" height=\"20\"/>  <img  src=\"img/u304_normal.jpg\" alt=\"Ocultar\"    onclick=\"ocultar()\"    width=\"20\" height=\"20\" /> </td>\n");
      out.write("        <td width=\"494\">&nbsp;</td>\n");
      out.write("     </tr>\n");
      out.write("    </table>\n");
      out.write("   <br>\n");
      out.write("    <table width=\"1420\" height=\"25\">\n");
      out.write("<tr>\n");
      out.write("            <td width=\"1740\" bgcolor=\"#97D4FE\" class=\"Estilo1\">Detalle de llamadas Disponibles On Line-");
      out.print(fecha);
      out.write("            </td>\n");
      out.write("      </tr>\n");
      out.write("  </table>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("<input type='hidden' name='accionHTML'/>\n");
      out.write("<input type='hidden' name='codCliente' id=\"codCliente\"  value='");
      out.print(xcodigo);
      out.write("'/>\n");
      out.write("<input type='hidden' name='campa' value='");
      out.print( campana );
      out.write("'> \n");
      out.write("<input type='hidden' name='campaign' value='");
      out.print( campa );
      out.write("'> \n");
      out.write("<input type='hidden' name='telefonoSelect' > \n");
      out.write("<input type='hidden' name='manual' id=\"manual\" value='");
      out.print(manual);
      out.write("'> \n");
      out.write("<input type='hidden' name='contador' id=\"contador\"  value='");
      out.print(contador);
      out.write("'> \n");
      out.write("<input type='hidden' name='consultor'  id=\"consultor\"  value='");
      out.print(consultor);
      out.write("' > \n");
      out.write("<input type='hidden' name='consultor'  id=\"consultor\"  value='");
      out.print(consultor);
      out.write("' > \n");
      out.write("       \n");
      out.write(" ");
      out.write("         \n");
      out.write("\n");
      out.write("\n");
      out.write("         \n");
 if(cliente==null   ){
   
      out.write("\n");
      out.write("<br>\n");
      out.write(" <a name=\"filtro\"></a>\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("\t<td colspan=\"6\">\n");
      out.write("\t\t<div> \n");
      out.write("        <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <td>Nombre <input type=\"text\" name=\"txtbuscaXnombre\" onKeyPress=\"return enter(event)\">   </td>\n");
      out.write("        <td>Código <input type=\"text\" name=\"txtbuscaXcodigo\" onKeyPress=\"return enter(event)\"> ></td>\n");
      out.write("        <td>Estado <input type=\"text\" name=\"txtbuscaXestado\"  onKeyPress=\"return enter(event)\"> ></td>\n");
      out.write("        <td>Resultado de Gestión <input type=\"text\" name=\"txtbuscaXresult\" onKeyPress=\"return enter(event)\">   \n");
      out.write("        <td>PEM <input type=\"text\" name=\"txtbuscaXPei\" onKeyPress=\"return enter(event)\"> \n");
      out.write("            \n");
      out.write("        <img alt=\"Buscar\" src=\"img/search_f2.png\" style=\"height: 22px; width: 25px\" onclick=\"buscarXnombre()\"> </td>\n");
      out.write("        <td> <img alt=\"Buscar\" src=\"img/actualizar.jpg\" style=\"height: 22px; width: 25px\" onclick=\"buscarXnombre1()\"></td>\n");
      out.write("        \n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("        </table>\n");
      out.write("        </div>\n");
      out.write("<center> <p><h3>No se encontraron resultados</h3></p></center>\n");
      out.write("        </td>\n");
      out.write("</tr>\n");
      out.write("    \n");
      out.write("    <tr>   <td> \n");
      out.write("                ");

}else{
      out.write("\n");
      out.write("<br>\n");
      out.write("<a name=\"filtro\"></a>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("\t<td colspan=\"6\">\n");
      out.write("\t\t<div> \n");
      out.write("        <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("        <td>Nombre <input type=\"text\" name=\"txtbuscaXnombre\" onKeyPress=\"return enter(event)\"> </td>\n");
      out.write("        <td>Código <input type=\"text\" name=\"txtbuscaXcodigo\" onKeyPress=\"return enter(event)\"></td>\n");
      out.write("        <td>Estado <input type=\"text\" name=\"txtbuscaXestado\" onKeyPress=\"return enter(event)\"></td>\n");
      out.write("        <td>Resultado de Gestión <input type=\"text\" name=\"txtbuscaXresult\" onKeyPress=\"return enter(event)\"> \n");
      out.write("        <td>PEM <input type=\"text\" name=\"txtbuscaXPei\" onKeyPress=\"return enter(event)\"> \n");
      out.write("            \n");
      out.write("        <img alt=\"Buscar\" src=\"img/search_f2.png\" style=\"height: 22px; width: 25px\" onclick=\"buscarXnombre()\"> </td>\n");
      out.write("        <td> <img alt=\"Buscar\" src=\"img/actualizar.jpg\" style=\"height: 22px; width: 25px\" onclick=\"buscarXnombre1()\"></td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("        </table>\n");
      out.write("        </div>\n");
      out.write("\t</td>\n");
      out.write("</tr>\n");
      out.write("    \n");
      out.write("    <tr>   <td> \n");
      out.write("            \n");
      out.write(" <table width=\"1700\" BORDER=1>\n");
      out.write("<tr> \n");
      out.write("<td width=\"18\" align =\"center\" class=\"Estilo4\">ID</td>\n");
      out.write("<td width=\"105\"  align =\"center\" class=\"Estilo4\">Código Cliente</td>\n");
      out.write("<td width=\"250\" align =\"center\"   class=\"Estilo4\" >Nombre</td>\n");
      out.write("<td width=\"130\" align =\"center\" class=\"Estilo4\">Estado</td>\n");
      out.write("<td width=\"54\" align =\"center\" class=\"Estilo4\" >PEM</td>\n");
      out.write("<td width=\"200\"  align =\"center\" class=\"Estilo4\">Resultado de Gestión</td>\n");
      out.write("<td width=\"450\" align =\"center\" class=\"Estilo4\" >Anotación</td>\n");
      out.write("<td width=\"60\" align =\"center\" class=\"Estilo4\">Teléfono01</td> \n");
      out.write("<td width=\"60\" align =\"center\" class=\"Estilo4\">Callresult01</td>\n");
      out.write("<td width=\"60\" align =\"center\" class=\"Estilo4\">Callback01</td> \n");
      out.write("<td width=\"60\" align =\"center\" class=\"Estilo4\">Teléfono02</td> \n");
      out.write("<td width=\"60\" align =\"center\" class=\"Estilo4\">Callresult02</td>\n");
      out.write("<td width=\"60\" align =\"center\" class=\"Estilo4\"  >Callback02</td>            \n");
      out.write("<td width=\"60\" align =\"center\" class=\"Estilo4\" >Teléfono03</td> \n");
      out.write("<td width=\"70\"  align =\"center\" class=\"Estilo4\">Callresult03</td>\n");
      out.write("<td width=\"70\" align =\"center\" class=\"Estilo4\" >Callback03</td>\n");
      out.write("<td width=\"60\"  align =\"center\" class=\"Estilo4\">Intentos</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("</tr> \n");
      out.write("\n");
 
  /*  Integer Id= orasql.obtenerCodigo(campana,cn_sql);
String codcliente= "1"+orasql.codigocliente(Id,cn_sql);*/
    
    if (DetalleCliente != null){
 for (  int i = 0; i < DetalleCliente.size(); i++) {
 
     
     
     bdetalle = (beanDetalladoCliente) DetalleCliente.get(i);


 




      out.write("\n");
      out.write("<tr> \n");
      out.write("    <td align =\"center\" class=\"Estilo4\"> ");
      out.print(i + 1);
      out.write("</td>\n");
      out.write("  \n");
      out.write("\n");
      out.write("  <td align =\"center\" class=\"Estilo4\"><input type='button' name='codcliente");
      out.print(i);
      out.write("' id='codcliente");
      out.print(i);
      out.write("' disabled=\"true\"  onclick ='copiar(this.id)' value= '");
      out.print(bdetalle.getCodCliente());
      out.write("'  /> </td>\n");
      out.write("\n");

 
 if(bdetalle.getNrocallback()==null){
    bdetalle.setCallback1("");
    bdetalle.setCallback2("");
    bdetalle.setCallback3("");
 }
 
 
 if(bdetalle.getApellido()==null){
     
     
      out.write("\n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");


 }else{

      out.write("\n");
      out.write("<td class=\"Estilo4\" >");
      out.print(bdetalle.getApellido());
      out.write("</td>\n");
      out.write(" ");

 }

 
 if(bdetalle.getEstado()==null){
  
      out.write("\n");
      out.write("   <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("  \n");
      out.write("  ");

 }
 
 
 
 else{
         
  
      out.write("\n");
      out.write("  <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getEstado());
      out.write("</td>\n");
      out.write("  \n");
      out.write("     ");
         
 }
 if(bdetalle.getCodzonaventa()==null){
     
      out.write("\n");
      out.write("     <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("  \n");
      out.write("     ");

 }else{
     
     
      out.write("\n");
      out.write("     \n");
      out.write("  <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCodzonaventa());
      out.write("</td>\n");
      out.write("  ");

 }
 
 
      out.write("\n");
      out.write("  \n");
      out.write("\n");
  if( bdetalle.getTipo_gestion()==null  || bdetalle.getTipo_gestion().equals("")){
      out.write("\n");
      out.write(" \n");
      out.write("<td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("  \n");
      out.write("   ");
 }else{
    
    
      out.write("\n");
      out.write(" <td class=\"Estilo4\" >");
      out.print(bdetalle.getTipo_gestion());
      out.write("</td>\n");
      out.write("    ");

    }

   
      out.write("\n");
      out.write("   \n");
      out.write("   \n");
      out.write("    \n");
      out.write("    ");

 
 if(bdetalle.getAnotacion()==null){
     
      out.write("\n");
      out.write("     \n");
      out.write("     <td class=\"Estilo4\" style=\"width: auto\" >&nbsp;</td>\n");
      out.write("     \n");
      out.write("     ");

 }else{
     
      out.write("\n");
      out.write("     \n");
      out.write("     <td class=\"Estilo4\" style=\"width: auto\"   >");
      out.print(bdetalle.getAnotacion());
      out.write("</td>\n");
      out.write("     ");

 }
 
      out.write("\n");
      out.write(" \n");
      out.write(" ");

 if(bdetalle.getNumero1()==null || bdetalle.getNumero1().equals("") ){
  
 
      out.write("\n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");

 }else{    

      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getNumero1());
      out.write("</td>\n");
      out.write("\n");

 }
 if(bdetalle.getCallResult1()==null ){
     
      out.write("\n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>   \n");
      out.write("     ");

 }else{
  
     if(bdetalle.getCallResult1().equals("0")){
     
     }
         
   

      out.write("\n");
      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallResult1());
      out.write("</td>\n");
   
 }
 
 if( bdetalle.getCallback1()==null || bdetalle.getCallback1()==""){

      out.write("\n");
      out.write("   <td class=\"Estilo4\" >&nbsp;</td>     \n");
      out.write("     \n");
      out.write("     ");

 }else{
     

      out.write("\n");
      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallback1());
      out.write("</td>\n");

 }
 if(bdetalle.getNumero2()==null || bdetalle.getNumero2() ==""  ){
     

      out.write("\n");
      out.write("   \n");
      out.write(" \n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");

 }else{
     
      out.write("\n");
      out.write("   <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getNumero2());
      out.write("</td>  \n");
      out.write("\n");
      out.write("     ");

 }
 if(bdetalle.getCallResult2()==null){
     
      out.write("\n");
      out.write("     <td class=\"Estilo4\" >&nbsp;</td>  \n");
      out.write("     ");

 }
 else{
     

      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallResult2());
      out.write("</td>\n");
      out.write("\n");

     
 }
 
 if(bdetalle.getCallback2()==null   || bdetalle.getCallback2()==""){
     
   
      out.write("\n");
      out.write("   <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("   ");

 }else{
  
      out.write("\n");
      out.write("  \n");
      out.write("  <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallback2());
      out.write("</td>\n");
      out.write("  ");

 }
 
 if(bdetalle.getNumero3()==null || bdetalle.getNumero3().equals("")){
     bdetalle.setNumero3("");
 

      out.write(" \n");
      out.write("<td class=\"Estilo4\" >&nbsp;</td>\n");

 }else{
 

      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getNumero3());
      out.write("</td>\n");
      out.write("\n");
    
 }
 

 if(bdetalle.getCallResult3()==null){
     
      out.write("\n");
      out.write("    <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("     ");

 }else{


      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallResult3());
      out.write("</td>\n");
      out.write("\n");
      out.write("   ");


  
 }
 
 if(bdetalle.getCallback3()==null  || bdetalle.getCallback3()=="" ){bdetalle.setCallback3("");
 
      out.write("\n");
      out.write(" \n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");

 }else{

      out.write("\n");
      out.write("\n");
      out.write("<td class=\"Estilo4\"> ");
      out.print(bdetalle.getCallback3());
      out.write("</td>\n");
      out.write("\n");
      out.write(" ");
 

   
     }
 if(bdetalle.getIntentos()==null){
     
     
      out.write("\n");
      out.write("     \n");
      out.write("       <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("     ");

 }else{
     
      out.write("\n");
      out.write("     \n");
      out.write("   <td  align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getIntentos());
      out.write("</td>  \n");
      out.write("     \n");
      out.write("     ");

 }
 

      out.write("\n");
      out.write("</tr>\n");
} 

}else{
        
        
       // out.println("Entro a manual");
    
for (  int i = 0; i < cliente.size(); i++) {
 
     
     
    bdetalle = (beanDetalladoCliente) cliente.get(i);

      out.write("\n");
      out.write("<tr> \n");
      out.write("    <td align =\"center\" class=\"Estilo4\"> ");
      out.print(i + 1);
      out.write("</td>\n");
      out.write("  \n");
      out.write("\n");
      out.write("  <td align =\"center\" class=\"Estilo4\"><input type='button' name='codcliente");
      out.print(i);
      out.write("' id='codcliente");
      out.print(i);
      out.write("' disabled=\"true\"  onclick ='copiar(this.id)' value= '");
      out.print(bdetalle.getCodCliente());
      out.write("'  /> </td>\n");
      out.write("\n");

 
 if(bdetalle.getNrocallback()==null){
    bdetalle.setCallback1("");
    bdetalle.setCallback2("");
    bdetalle.setCallback3("");
 }
 
 
 if(bdetalle.getApellido()==null){
     
     
      out.write("\n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");


 }else{

      out.write("\n");
      out.write("<td class=\"Estilo4\" >");
      out.print(bdetalle.getApellido());
      out.write("</td>\n");
      out.write(" ");

 }
 

 
 if(bdetalle.getEstado()==null){
  
      out.write("\n");
      out.write("   <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("  \n");
      out.write("  ");

 }
 
 
 
 else{
         
  
      out.write("\n");
      out.write("  <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getEstado());
      out.write("</td>\n");
      out.write("  \n");
      out.write("     ");
        
 }
 
 if(bdetalle.getCodzonaventa()==null){
     
      out.write("\n");
      out.write("     <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("  \n");
      out.write("     ");

 }else{
     
     
      out.write("\n");
      out.write("     \n");
      out.write("  <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCodzonaventa());
      out.write("</td>\n");
      out.write("  ");

 }
 
 
      out.write('\n');
      out.write(' ');

if(bdetalle.getTipo_gestion()==null  || bdetalle.getTipo_gestion().equals("") ){
 
      out.write("\n");
      out.write(" <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("  \n");
      out.write("    ");

}else{
    
      out.write("\n");
      out.write("   <td class=\"Estilo4\" >");
      out.print(bdetalle.getTipo_gestion());
      out.write("</td>\n");
      out.write("    \n");
      out.write(" ");

}
 
 if(bdetalle.getAnotacion()==null){
     
      out.write("\n");
      out.write("     \n");
      out.write("      <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("     \n");
      out.write("     ");

 }else{
     
      out.write("\n");
      out.write("     \n");
      out.write("     <td class=\"Estilo4\" >");
      out.print(bdetalle.getAnotacion());
      out.write("</td>\n");
      out.write("     ");

 }
 
      out.write("\n");
      out.write(" \n");
      out.write(" ");

 if(bdetalle.getNumero1()==null || bdetalle.getNumero1().equals("") ){
  
 
      out.write("\n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");

 }else{    

      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getNumero1());
      out.write("</td>\n");
      out.write("\n");

 }
 if(bdetalle.getCallResult1()==null ){
     
      out.write("\n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>   \n");
      out.write("     ");

 }else{
  
     if(bdetalle.getCallResult1().equals("0")){
     
     }
         
   

      out.write("\n");
      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallResult1());
      out.write("</td>\n");
   
 }
 
 if( bdetalle.getCallback1()==null || bdetalle.getCallback1()==""){

      out.write("\n");
      out.write("   <td class=\"Estilo4\" >&nbsp;</td>     \n");
      out.write("     \n");
      out.write("     ");

 }else{
     

      out.write("\n");
      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallback1());
      out.write("</td>\n");

 }
 if(bdetalle.getNumero2()==null  || bdetalle.getNumero2().equals("") ){
     
     bdetalle.setNumero2("");
 
      out.write("\n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");

 }else{
     
      out.write("\n");
      out.write("   <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getNumero2());
      out.write("</td>  \n");
      out.write("\n");
      out.write("     ");

 }
 if(bdetalle.getCallResult2()==null){
     
      out.write("\n");
      out.write("     <td class=\"Estilo4\" >&nbsp;</td>  \n");
      out.write("     ");

 }
 else{
     

      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallResult2());
      out.write("</td>\n");
      out.write("\n");

     
 }
 
 if(bdetalle.getCallback2()==null   || bdetalle.getCallback2()==""){
     
   
      out.write("\n");
      out.write("   <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("   ");

 }else{
  
      out.write("\n");
      out.write("  \n");
      out.write("  <td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallback2());
      out.write("</td>\n");
      out.write("  ");

 }
 
 if(bdetalle.getNumero3()==null || bdetalle.getNumero3().equals("")  ){
     bdetalle.setNumero3("");
 

      out.write(" \n");
      out.write("<td class=\"Estilo4\" >&nbsp;</td>\n");

 }else{
 

      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getNumero3());
      out.write("</td>\n");
      out.write("\n");
    
 }
 

 if(bdetalle.getCallResult3()==null){
     
      out.write("\n");
      out.write("    <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("     ");

 }else{


      out.write("\n");
      out.write("<td align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getCallResult3());
      out.write("</td>\n");
      out.write("\n");
      out.write("   ");


  
 }
 
 if(bdetalle.getCallback3()==null  || bdetalle.getCallback3()=="" ){bdetalle.setCallback3("");
 
      out.write("\n");
      out.write(" \n");
      out.write("  <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write(" ");

 }else{

      out.write("\n");
      out.write("\n");
      out.write("<td class=\"Estilo4\"> ");
      out.print(bdetalle.getCallback3());
      out.write("</td>\n");
      out.write("\n");
      out.write(" ");
 

   
     }
 if(bdetalle.getIntentos()==null){
     
     
      out.write("\n");
      out.write("     \n");
      out.write("       <td class=\"Estilo4\" >&nbsp;</td>\n");
      out.write("     ");

 }else{
     
      out.write("\n");
      out.write("     \n");
      out.write("   <td  align =\"center\" class=\"Estilo4\"> ");
      out.print(bdetalle.getIntentos());
      out.write("</td>  \n");
      out.write("     \n");
      out.write("     ");

 }
 
 
 
 
 

      out.write("\n");
      out.write("</tr>    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");

    }
    }




      out.write("\n");
      out.write("        </table>   </td> \n");
      out.write("        \n");
      out.write("        ");
 for (int vueltas=0;vueltas<28;vueltas ++){
      out.write("\n");
      out.write("        \n");
      out.write("        <td width=\"120\" > </td>\n");
      out.write("      ");
 }
      out.write("\n");
      out.write("        \n");
      out.write("        <td id=\"div60\"  style=\"display:none\" valign =\"top\"  valign=\"left\"> <table width=\"584\" border=\"1\" >\n");
      out.write("  <tr>\n");
      out.write("    <td width=\"94\" align =\"center\" class=\"Estilo5\">Call Result</td>\n");
      out.write("    <td width=\"474\" align =\"center\" class=\"Estilo5\">Significado</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">0</td>\n");
      out.write("    <td>El sistema no concreta intento de marcación al cliente.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">2</td>\n");
      out.write("    <td>Error de marcación. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">3</td>\n");
      out.write("    <td>Número no reportados en el servicio por la red.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">4</td>\n");
      out.write("    <td>Sin Tono de retorno después de discado. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">5</td>\n");
      out.write("    <td>Operador, intersección de regresar a la red cuando intentó establecer línea.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">6</td>\n");
      out.write("    <td>Sin tono de marcación. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">7</td>\n");
      out.write("    <td>Número invalido. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">8</td>\n");
      out.write("    <td>No responde. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">9</td>\n");
      out.write("    <td>Número de cliente se encuentra ocupado. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">10</td>\n");
      out.write("    <td>Llamada Atendida por Agente. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">11</td>\n");
      out.write("    <td>Fax Detectado. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">12</td>\n");
      out.write("    <td>Contestadora Automática.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">13</td>\n");
      out.write("    <td>Marcador detuvo la marcación por falta de recursos.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">14</td>\n");
      out.write("    <td>Cliente solicita devolución de llamada.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">16</td>\n");
      out.write("    <td>Llamada abandonada por el Discador a la falta de agente.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">17</td>\n");
      out.write("    <td>Error al agente de reserva para la devolución de llamada personal.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">18</td>\n");
      out.write("    <td>Agente omite llamada.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">19</td>\n");
      out.write("    <td>Agente rechaza y cierra llamada. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">20</td>\n");
      out.write("    <td>Cliente ha sido abandonado a un IVR.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">21</td>\n");
      out.write("    <td>Llamada colgada por cliente.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">22</td>\n");
      out.write("    <td>Generalmente se utiliza conmutadores TDM - contestador automático de red.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">23</td>\n");
      out.write("    <td>Número contactado con éxito pero un número equivocado.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">24</td>\n");
      out.write("    <td>Número contactado con éxito pero llegado a la persona equivocada</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">25</td>\n");
      out.write("    <td>Discador descarta llamada por cambios realizados en campaña.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">26</td>\n");
      out.write("    <td>El número estaba en la lista de no llamar.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">27</td>\n");
      out.write("    <td>Llamada descartada por operador.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">28</td>\n");
      out.write("    <td>Detecta tono de silencio. </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">100</td>\n");
      out.write("    <td>Llamada Manual en Ruta.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">101</td>\n");
      out.write("    <td>Llamada Manual Fuera de Ruta.</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td align =\"center\">102</td>\n");
      out.write("    <td>Llamada Manual.</td>\n");
      out.write("  </tr>\n");
      out.write("        \n");
      out.write("                       </table>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("<a name=\"llamada\"></a>\n");
      // System.out.println("valor de campana:" + campa);
               String estadocad=  orasql.estadocad(campa,cn_sql);
            ///   System.out.println("Entro preparado"+estadocad); 
               
               
         if(estadocad.equals("Preparado")){
             //out.println("Entro preparado detalle");
             
            // System.out.println("tamaño "+cliente.size() );
             
      out.write("\n");
      out.write("           \n");
      out.write("             <script type=\"text/javascript\">\n");
      out.write("   //alert(\"Desactiva boton\");\n");
      out.write("   var tam= ");
      out.print(cliente.size());
      out.write(";\n");
      out.write("   ///alert(\"lista tamaño\"+ tam);\n");
      out.write("   if( tam == 0){\n");
      out.write("     // alert(\"lista trae 0\");\n");
      out.write("   }else{\n");
      out.write("   \n");
      out.write("      var i=0;for(i=0;i < ");
      out.print(cliente.size());
      out.write("  ;i++){\n");
      out.write("     document.getElementById(\"codcliente\"+i).disabled = true; \n");
      out.write("     \n");
      out.write("      }  \n");
      out.write("  }\n");
      out.write("    </script>\n");
      out.write("             ");

         }else{
        
      out.write("\n");
      out.write("         <script type=\"text/javascript\">\n");
      out.write("  \n");
      out.write("    var i=0;for(i=0;  i <  ");
      out.print(cliente.size());
      out.write("  ;i++){\n");
      out.write("     document.getElementById(\"codcliente\"+i).disabled = false; \n");
      out.write(" \n");
      out.write("      }\n");
      out.write(" \n");
      out.write("  </script>    \n");
      out.write("       \n");
      out.write("         ");
   
         }
        
      out.write("\n");
      out.write(" \n");
      out.write("  \n");
      out.write(" ");
      out.write("  \n");
      out.write(" \n");
      out.write("\n");
 }
   


      request.removeAttribute("manual");
        
        xcodigo="1" + xcodigo;

      out.write("\n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("  <script language=\"javascript\">   \n");
      out.write(" \n");
      out.write("   //   alert(\"ca,bia titulo\");\n");
      out.write("  /* var codi =;\n");
      out.write("   var concate= codi.substring(1);*/\n");
      out.write("   \n");
      out.write("   document.title=  'DetalleLlamadas - '+ ");
      out.print(xcodigo);
      out.write(" ;  \n");
      out.write("  \n");
      out.write(" \n");
      out.write("    </script>\n");
      out.write("</form>\n");
      out.write("        \n");
      out.write("  \n");
      out.write("    \n");
      out.write("</body>\n");
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
