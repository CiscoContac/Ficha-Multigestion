<%-- 
    Document   : ClicikInformacion
    Created on : 07/07/2014, 09:30:09 AM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.dto.beanTelefonoParentesco"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.dto.beanTelefonoClienteLista"%>
<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="com.pe.backus.factory.oracleDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/informacion.js"></script>
          <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
  <style type="text/css">
     #divscroll {
         
   overflow:scroll;
   height:185px;
   width: 250px;
   
      }
       #divnumero{
             
   overflow:scroll;
   width:220px;
    height: 80px;   
      }
  </style>
    </head>
    <body>
        <%
          
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
//Connection cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
clienteSqlDaoImpl  sqlCliente = new clienteSqlDaoImpl();
    clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
            String campana = request.getParameter("campana");

String campa= request.getParameter("campa");
String  cod = request.getParameter("codcli");
 String numerito=  request.getParameter("numerito"); 
 String estadocad=  sqlCliente.estadocad(campa,cn_sql);%>
 <form id="form" method="post" action="InformacionCliente">
  

 <input type='hidden' id="accionHtml"  name='accionHtml'/>

     <%  out.println("<input type='hidden' name='campana'  id='campana' value="    +"'"+ campana+"'"+   "/>"   );
                 out.println("<input type='hidden' name='GenCodigo'  id='GenCodigo' value=  "+"'"+cod+"'"+     "/>"  );
              %>
  <input type='hidden' name='telefonoSelect' > 
  <input type='hidden' name='campa'  id='campa' value='<%=campa%>'>
  <table>
      <tr>
          
          <td>  
   <img src="img/tel1.jpg" width="30" height="30" id="imgtelver"  onclick="fonavi()" style="display: block"/> 
 </td> 
  
        
        <td>
    <%
      
        if (numerito != null ){
     
        if(estadocad.equals("Preparado") ||  estadocad.equals("clicktocall")  ){
  %>
      <%if (  estadocad.equals("clicktocall") ){%>
      <table>
        <tr>
          <td id="tdtext">Estas en Llamada......</td>
        </tr>
      </table>
      <script>
    
       document.getElementById('imgtelver').style.display='block';
      </script>
      <%}%>
      <%
  }else   {
           
       beanTelefonoClienteLista beanClienteFono = null;
         List<beanTelefonoClienteLista> telefono = null ;
         List<beanTelefonoParentesco>  ListaParentesco = null;
         beanTelefonoParentesco     parentesco=null;
         Connection cn_gmrasca= null;
 
      cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
telefono = sqlCliente.ObtenerTelefonoLista(cod,cn_sql);
Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();

 ListaParentesco = oraCliente.ObtenerTelefonoParentesco(cod,cnNC);
cnNC.close();
//beanTelefonoParentesco   beanTelefonoParentesco;  

   
  for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);}
  ///out.println(xcodigo);
  //out.println(estadocad);
if(estadocad.equals("Inicia manual con cliente")||estadocad.equals("Fin de Manual") || estadocad.equals("NoPreparado") ||estadocad.equals("Inicia manual sin cliente")  ){  
 
      %>
      <table>
        <tr>
          <%if( beanClienteFono== null &&  beanClienteFono==null ){
          %>
          <td>Clente:</td>
          <td>No existen Datos de t&eacute;lefono</td>
          <%  }else{%>
          <td>Cliente:</td>
          <td><%= beanClienteFono.getNombre()%> <%= beanClienteFono.getApellido()%></td>
          <%}%>
        </tr>
      </table>
      <div  id="div10" style="width:650px">
        <table border="0"    cellspacing="0" cellpadding="0">
          <tr>
            <td width="230"><%if(beanClienteFono==null){%>
              <%}else {%>
          <center>
              <table style ="border-spacing: 0 0; border-collapse: collapse;"  border="0"  cellspacing="0" cellpadding="0">
                    <tr>
                      <td colspan="2" align="center"  >Tel&eacute;fonos del Cliente</td>
                      <td width="48" align="center"><font style="color: red">Cant </td>
                    </tr>
                  </table >
          </center>
              <div id="divnumero" style="  border-style:solid ;  border-width: 1px">
                  <center>
                    <table style ="border-spacing: 0 0; border-collapse: collapse;" border="0"  cellspacing="0" cellpadding="0">
                    <%
 int var=0;
for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);
 
 %>
 <tr>
                      <td width="47"  >Nro<%=j+1%>.-</td>
                      <% //String nro="9"+ beanClienteFono.getNro();%>
                      <td  onclick= 'clicktocall(9<%=beanClienteFono.getNro()%>)'>
                        9<%=beanClienteFono.getNro() %>
                    </td>
                      <%  int h;
int z=0;
 String s="" ;
 //aqui va el rascal numero 1 ;
  List numero= sqlCliente.ListaNumeroContador(beanClienteFono.getCodCliente().toString(), beanClienteFono.getNro().toString(),cn_gmrasca);
  
        
%>
                      <%     
        
       
  for( h =0; h<numero.size();h++ ){
      
 
%>
                      <%        
              
             
%>
                      <td width="47"  align="center"><%=numero.get(z) %></td>
                      <%
 z++;
 break;
  }
  %>
                    </tr>
                    <%}
 cn_gmrasca.close();

%>
                    <%
 
for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);
 %>
                    <%}%>
                    <input type='hidden' name='CodClienteDetalle' value='<%=beanClienteFono.getCodCliente()%>'>
                  </table>
                  </center>
              </div>
                  
              <%}%>
              <br>
              <% 

if(beanClienteFono ==null){
}else{
String variable = request.getParameter("numeroclicktocholl");
%>

<div style="  border-style:solid ;  border-width: 1px;width: 222px;height: 84px">
    <center>
    <table  style="border-spacing: 0 0; border-collapse: collapse;" cellspacing="0" cellpadding="0"  height="70" align="left"  border="0">
                  <tr>
                    <td width="128" height="32"> Ingresar N&uacute;mero:
                      <input type="text" id ="numerox" name="numerox" size="21"  maxlength="9" onKeyPress="return solovali(event)" onBlur="verif(this)" ></td>
                    <td width="57"><input type="button" value="Llamar" name="llamar" id="llamar" onClick="fllamar()"></td>
                  </tr>
                  <tr>
                    <td>¿Desea Llamar a este Nro?</td>
                    <%  if(variable==null){ 
                          %>
                    <td>&nbsp;</td>
                    <%
                          }
                          else{%>
                    <td  onclick= 'clicktocall(<%=variable%>)'><%=variable%></td>
                    <%
}%>
                  </tr>
                </table>
    </center>
              </div>

              <%

}
%></td>
            <td width="8"></td>
            <td width="395" valign="top"><%if(ListaParentesco.size()!=0){%>
              <div id="divscroll"   style="border-style:solid ;  border-width: 1px;">
                <center>
                  <table border="0"  cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="25" colspan="2" align="center">Otros Contactos</td>
                    </tr>
                    <% for (int i = 0; i < ListaParentesco.size(); i++) {
parentesco = (beanTelefonoParentesco) ListaParentesco.get(i);
%>
                    <tr>
                      <td width="82"><%=parentesco.getParentesco()%></td>
                      <td style="height: auto"  onclick= 'clicktocall(9<%= parentesco.getNumero()%>)' >9<%=parentesco.getNumero()%></td>
                      <td width="50"></td>
                    </tr>
                    <%}%>
                  </table>
                </center>
              </div>
              <%
}         %></td>
          </tr>
          <tr>
            <td height="2" colspan="3"></td>
          </tr>
        </table>
      </div>
      <%  }}} %>
        </td>
     </tr>
  </table>
 </form>
    </body>
</html>
