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

public final class listaNumero_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("  <link href=\"styles/estilos.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <script   language=\"javascript\">\n");
      out.write("function clicktocall(valorr) {\n");
      out.write("   // alert(valorr);\n");
      out.write("if(valorr==null){\n");
      out.write("   /// alert(\"nullclicttocall\");\n");
      out.write("}else{   \n");
      out.write("   // desbotones(size);\n");
      out.write("  \n");
      out.write("f5 = document.forms[0];  \n");
      out.write("\n");
      out.write("//alert(f5);\n");
      out.write("document.getElementById('div1').style.display = 'none'; \n");
      out.write("document.getElementById('telefonoSelect').value=valorr;\n");
      out.write("//alert(\"condata1\");\n");
      out.write("document.getElementById('accionHTML').value = 'llamadaManual';\n");
      out.write("f5.action = 'ServletDetallado';\n");
      out.write("f5.method = 'POST';\n");
      out.write("var campaña= f5.campa.value;\n");
      out.write("var codcliente=f5.codCliente.value;\n");
      out.write("var campa=f5.campaign.value;\n");
      out.write("var valor=\"valor\";\n");
      out.write("\n");
      out.write("//top.framedetalla.document.location.href=\"index.jsp?validacion=valor&campana=\"+campaña.toString()+\"&campa=\"+campa.toString();   \n");
      out.write("///top.framecabecera.document.location.href=\"cabecera.jsp?campa=\"+campa.toString();    \n");
      out.write("//window.open(\"http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana=\"+campaña.toString()+\"&valor=\"+valor+\"&codcli=\"+codcliente,\"infomacion\");\n");
      out.write("\n");
      out.write("//alert(\"CAMPAÑA DE LISTANUMERO\"+campaña);\n");
      out.write("\n");
      out.write("f5.submit();\n");
      out.write("\n");
      out.write(" }\n");
      out.write("\n");
      out.write(" }\n");
      out.write(" \n");
      out.write("   function  fonavi(){\n");
      out.write("       f5 = document.forms[0]; \n");
      out.write("   var campaña= f5.campa.value;\n");
      out.write("var codcliente=document.getElementById('codCliente').value;\n");
      out.write("\n");
      out.write("var campa=f5.campaign.value;\n");
      out.write("    //document.getElementById('tdmensaje').innerHTML='Estas en Llamada';\n");
      out.write("  top.framenumero.document.location.href=\"listaNumero.jsp?campana=\"+campaña.toString()+\"&campa=\"+campa.toString()+\"&codcli=\"+codcliente+\"&numerito=valor\";\n");
      out.write(" //alert(\"Lo hizo\");\n");
      out.write(" \n");
      out.write("}\n");
      out.write(" \n");
      out.write("     function fllamar(){\n");
      out.write("              f1 = document.forms[0];\n");
      out.write("               // f1.codCliente.value = valor.value;\n");
      out.write("                // f1.codCampana.value=valor1.value;\n");
      out.write("                f1.accionHTML.value = 'Llamar';\n");
      out.write("                f1.action = 'ServletDetallado';\n");
      out.write("                f1.method = 'POST';\n");
      out.write("                //alert(\"llamarmnuermo\");\n");
      out.write("                               f1.submit();\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    function  soloNumerosvali(e){\n");
      out.write("        var key = window.Event ? e.which : e.keyCode \n");
      out.write("//alert(key);\n");
      out.write("/*if( key == 13 ){\n");
      out.write("    buscarXnombre();\n");
      out.write("}*/\n");
      out.write("    if(key == 13){\n");
      out.write("   fllamar();\n");
      out.write("    //alert(\"entro\");\n");
      out.write("    //return;\n");
      out.write("}else{    \n");
      out.write("      \n");
      out.write("return ((key >= 48 && key <= 57) || (key==8)) \n");
      out.write("}\n");
      out.write("    }\n");
      out.write("       </script>\n");
      out.write("\n");
      out.write("        <META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n");
      out.write("        <title>DetalleLlamadas</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("<!--\n");
      out.write(" #divscroll {\n");
      out.write("         \n");
      out.write("   overflow:scroll;\n");
      out.write("   height:185px;\n");
      out.write("   width: 250px;\n");
      out.write("   \n");
      out.write("      }\n");
      out.write("      #divnumero{\n");
      out.write("             \n");
      out.write("   overflow:scroll;\n");
      out.write("  width:220px;\n");
      out.write("    height: 60px   \n");
      out.write("      }\n");
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
      out.write("<body>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");


          String campana = request.getParameter("campana");
          String xcodigo= request.getParameter("codcli");
      ///  out.println("CODIGO DE LISTANUMERO ===>"+xcodigo);
          
           String numerito=  request.getParameter("numerito"); 
          String campa= request.getParameter("campa");
String Drop =  request.getParameter("Drop");
String manual =  request.getParameter("manual");
String valor= request.getParameter("valor");
//out.println("pintada de valor"+  valor);
String contador=  request.getParameter("contador");
String consultor=  request.getParameter("consultor");
 String click =  request.getParameter("click");
  String         llamar =  request.getParameter("llamar");
          
      //CONEXION CON BASE DE DATOS     
  
  
    //Connection connection= oraclefactooriginal.getSQLConextion();
    Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
  Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
  
clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();


  String estadocad=  orasql.estadocad(campa,cn_sql);


        
        
      out.write("\n");
      out.write("        <form>      \n");
      out.write("  <input type='hidden' id=\"accionHTML\"  name='accionHTML'/>\n");
      out.write("<input type='hidden' name='codCliente' id=\"codCliente\"  value='");
      out.print(xcodigo);
      out.write("'/>\n");
      out.write("<input type='hidden' name='campa' value='");
      out.print( campana );
      out.write("'> \n");
      out.write("<input type='hidden' name='campaign' value='");
      out.print( campa );
      out.write("'> \n");
      out.write("<input type='hidden' id=\"telefonoSelect\" name='telefonoSelect' > \n");
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
      out.write("'> \n");
      out.write("       \n");
      out.write(" ");
      out.write("  \n");
      out.write("       \n");
      out.write(" \n");
      out.write("            ");
      Integer Id= orasql.obtenerCodigo(campana,cn_rascalLocal);
String codcliente=orasql.codigocliente(Id,cn_rascalLocal);   
xcodigo=codcliente;
//out.println("codigo cliente "+codcliente);
        
      out.write("\n");
      out.write("       \n");
      out.write("             <input type='hidden' name='codCliente' id=\"codCliente\"  value='");
      out.print(xcodigo);
      out.write("'/>\n");
      out.write("             <table>\n");
      out.write("                 <tr>\n");
      out.write("                 <td>\n");
      out.write("                     <br>\n");
      out.write("                  <img src=\"img/tel1.jpg\" width=\"30\" height=\"30\" id=\"imgtelver\"  onclick=\"fonavi()\" style=\"display: block\"/> \n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("              ");

      
        if (numerito != null ){
     
        if(estadocad.equals("Preparado") ||  estadocad.equals("clicktocall")  ){
  
      out.write("\n");
      out.write("      ");
if (  estadocad.equals("clicktocall") ){
      out.write("\n");
      out.write("      <table>\n");
      out.write("        <tr>\n");
      out.write("          <td id=\"tdtext\">Estas en Llamada......</td>\n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("      <script>\n");
      out.write("    \n");
      out.write("       document.getElementById('imgtelver').style.display='block';\n");
      out.write("      </script>\n");
      out.write("      ");
}
      out.write("\n");
      out.write("      ");

  }else   {
           
       beanTelefonoClienteLista beanClienteFono = null;
         List<beanTelefonoClienteLista> telefono = null ;
         List<beanTelefonoParentesco>  ListaParentesco = null;
         beanTelefonoParentesco     parentesco=null;
         Connection cn_gmrasca= null;
 
      cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
telefono = orasql.ObtenerTelefonoLista(xcodigo,cn_sql);
Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();

 ListaParentesco = oraCliente.ObtenerTelefonoParentesco(xcodigo,cnNC);
cnNC.close();
//beanTelefonoParentesco   beanTelefonoParentesco;  

   
  for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);}
  ///out.println(xcodigo);
  //out.println(estadocad);
if(estadocad.equals("Inicia manual con cliente")||estadocad.equals("Fin de Manual") || estadocad.equals("NoPreparado") ||estadocad.equals("Inicia manual sin cliente")  ){  
 
      
      out.write("\n");
      out.write("      <table>\n");
      out.write("        <tr>\n");
      out.write("          ");
if( beanClienteFono== null &&  beanClienteFono==null ){
          
      out.write("\n");
      out.write("          <td>Clente:</td>\n");
      out.write("          <td>No existen Datos de t&eacute;lefono</td>\n");
      out.write("          ");
  }else{
      out.write("\n");
      out.write("          <td>Cliente:</td>\n");
      out.write("          <td>");
      out.print( beanClienteFono.getNombre());
      out.write(' ');
      out.print( beanClienteFono.getApellido());
      out.write("</td>\n");
      out.write("          ");
}
      out.write("\n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("      <div  id=\"div10\" style=\"width:650px\">\n");
      out.write("        <table border=\"0\"    cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("          <tr>\n");
      out.write("            <td width=\"230\">");
if(beanClienteFono==null){
      out.write("\n");
      out.write("              ");
}else {
      out.write("\n");
      out.write("          <center>\n");
      out.write("              <table style =\"border-spacing: 0 0; border-collapse: collapse;\"  border=\"0\"  cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                    <tr>\n");
      out.write("                      <td colspan=\"2\" align=\"center\"  >Tel&eacute;fonos del Cliente</td>\n");
      out.write("                      <td width=\"48\" align=\"center\"><font style=\"color: red\">Cant </td>\n");
      out.write("                    </tr>\n");
      out.write("                  </table >\n");
      out.write("          </center>\n");
      out.write("              <div id=\"divnumero\" style=\"  border-style:solid ;  border-width: 1px\">\n");
      out.write("                  <center>\n");
      out.write("                    <table style =\"border-spacing: 0 0; border-collapse: collapse;\" border=\"0\"  cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                    ");

 int var=0;
for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);
 
 
      out.write("\n");
      out.write(" <tr>\n");
      out.write("                      <td width=\"47\"  >Nro");
      out.print(j+1);
      out.write(".-</td>\n");
      out.write("                      ");
 //String nro="9"+ beanClienteFono.getNro();
      out.write("\n");
      out.write("                      <td  onclick= 'clicktocall(9");
      out.print(beanClienteFono.getNro());
      out.write(")'>\n");
      out.write("                        9");
      out.print(beanClienteFono.getNro() );
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                      ");
  int h;
int z=0;
 String s="" ;
 //aqui va el rascal numero 1 ;
  List numero= orasql.ListaNumeroContador(beanClienteFono.getCodCliente().toString(), beanClienteFono.getNro().toString(),cn_gmrasca);
  
        

      out.write("\n");
      out.write("                      ");
     
        
       
  for( h =0; h<numero.size();h++ ){
      
 

      out.write("\n");
      out.write("                      ");
        
              
             

      out.write("\n");
      out.write("                      <td width=\"47\"  align=\"center\">");
      out.print(numero.get(z) );
      out.write("</td>\n");
      out.write("                      ");

 z++;
 break;
  }
  
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
 cn_gmrasca.close();


      out.write("\n");
      out.write("                    ");

 
for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);
 
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    <input type='hidden' name='CodClienteDetalle' value='");
      out.print(beanClienteFono.getCodCliente());
      out.write("'>\n");
      out.write("                  </table>\n");
      out.write("                  </center>\n");
      out.write("              </div>\n");
      out.write("                  \n");
      out.write("              ");
}
      out.write("\n");
      out.write("              <br>\n");
      out.write("              ");
 

if(beanClienteFono ==null){
}else{
String variable = request.getParameter("numeroclicktocholl");

      out.write("\n");
      out.write("\n");
      out.write("<div style=\"  border-style:solid ;  border-width: 1px;width: 222px;height: 84px\">\n");
      out.write("    <center>\n");
      out.write("    <table  style=\"border-spacing: 0 0; border-collapse: collapse;\" cellspacing=\"0\" cellpadding=\"0\"  height=\"70\" align=\"left\"  border=\"0\">\n");
      out.write("                  <tr>\n");
      out.write("                    <td width=\"128\" height=\"32\"> Ingresar N&uacute;mero:\n");
      out.write("                      <input type=\"text\" id =\"numerox\" name=\"numerox\" size=\"21\"  maxlength=\"9\" onKeyPress=\"return solovali(event)\" onBlur=\"verif(this)\" ></td>\n");
      out.write("                    <td width=\"57\"><input type=\"button\" value=\"Llamar\" name=\"llamar\" id=\"llamar\" onClick=\"fllamar()\"></td>\n");
      out.write("                  </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <td>¿Desea Llamar a este Nro?</td>\n");
      out.write("                    ");
  if(variable==null){ 
                          
      out.write("\n");
      out.write("                    <td>&nbsp;</td>\n");
      out.write("                    ");

                          }
                          else{
      out.write("\n");
      out.write("                    <td  onclick= 'clicktocall(");
      out.print(variable);
      out.write(")'>");
      out.print(variable);
      out.write("</td>\n");
      out.write("                    ");

}
      out.write("\n");
      out.write("                  </tr>\n");
      out.write("                </table>\n");
      out.write("    </center>\n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("              ");


}

      out.write("</td>\n");
      out.write("            <td width=\"8\"></td>\n");
      out.write("            <td width=\"395\" valign=\"top\">");
if(ListaParentesco.size()!=0){
      out.write("\n");
      out.write("              <div id=\"divscroll\"   style=\"border-style:solid ;  border-width: 1px;\">\n");
      out.write("                <center>\n");
      out.write("                  <table border=\"0\"  cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                    <tr>\n");
      out.write("                      <td height=\"25\" colspan=\"2\" align=\"center\">Otros Contactos</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 for (int i = 0; i < ListaParentesco.size(); i++) {
parentesco = (beanTelefonoParentesco) ListaParentesco.get(i);

      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                      <td width=\"82\">");
      out.print(parentesco.getParentesco());
      out.write("</td>\n");
      out.write("                      <td style=\"height: auto\"  onclick= 'clicktocall(9");
      out.print( parentesco.getNumero());
      out.write(")' >9");
      out.print(parentesco.getNumero());
      out.write("</td>\n");
      out.write("                      <td width=\"50\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                  </table>\n");
      out.write("                </center>\n");
      out.write("              </div>\n");
      out.write("              ");

}         
      out.write("</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td height=\"2\" colspan=\"3\"></td>\n");
      out.write("          </tr>\n");
      out.write("        </table>\n");
      out.write("      </div>\n");
      out.write("      ");
  }}} 
      out.write("\n");
      out.write("            </td>\n");
      out.write("             </tr>\n");
      out.write("             </table>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</div>\n");
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
