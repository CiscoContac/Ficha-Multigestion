<%-- 
    Document   : detalleLlamada
    Created on : 03/01/2014, 02:51:35 PM
    Author     : GMD
--%>

<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.factory.sqlDaoFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.factory.oracleDaoLocalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.pe.backus.dto.beanTelefonoClienteLista"%>
<%@page import="com.pe.backus.dto.beanClienteTelefono"%>
<%@page import="com.pe.backus.dto.beanClienteTelefono"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="com.pe.backus.dto.beanDetalladoCliente"%>
<%@page import="com.pe.backus.dto.beanTelefonoParentesco"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    
    <head>

  <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
    <script   src ="js/detalleLlamada.js">

       </script>

        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <title>DetalleLlamadas</title>
        <style type="text/css">
<!--
.Estilo4 {
	font-size: 12px;
	font-weight: bold;
	font-family: "Trebuchet MS";
}
-->
        </style>
                   <META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META HTTP-EQUIV="cache-control " CONTENT="no-cache">
<META http-equiv="expires" content="0">
<META name="expires" content="Wed, 01 jan 1997 00:00:00 GMT">
                    <script type="text/javascript">
  if(history.forward(1)){
    location.replace( history.forward(1) );
  }
</script>   
</head>

<body >

        
        
        <%

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

%>

<%
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
    %>
    
    <script language="javascript">
    redifiltro('#filtro')    
    
    </script>
    <%
}
//LLENANDO EL BEAN CON DATOS  DEL CLIENTE JALADOS DEL IPCC
  for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);}


        %>
        <form id='form3' name='form3' method='post' style="font-family: 'Trebuchet MS'; font-size: 12px;" >

<table width="1400" height="48">
        <tr> 
            <td width="545" height="42" align="center"><div id ="divactu" style="display: none">
                    <label>
                        <img  src="img/refrescar.jpg"   alt="Refrescar"  id="fresh"  value="Refresh"  onclick="refrescar()"style="width:90px;height:65px">
                    </label></div></td>
        <td width="650" align="right" >  <br> Leyenda de Call Result :   <img src="img/u11_normal.jpg" alt="Mostrar"    onclick="mostrar()"  width="20" height="20"/>  <img  src="img/u304_normal.jpg" alt="Ocultar"    onclick="ocultar()"    width="20" height="20" /> </td>
        <td width="494">&nbsp;</td>
     </tr>
    </table>
   <br>
    <table width="1420" height="25">
<tr>
            <td width="1740" bgcolor="#97D4FE" class="Estilo1">Detalle de llamadas Disponibles On Line-<%=fecha%>            </td>
      </tr>
  </table>
    
    
<input type='hidden' name='accionHTML'/>
<input type='hidden' name='codCliente' id="codCliente"  value='<%=xcodigo%>'/>
<input type='hidden' name='campa' value='<%= campana %>'> 
<input type='hidden' name='campaign' value='<%= campa %>'> 
<input type='hidden' name='telefonoSelect' > 
<input type='hidden' name='manual' id="manual" value='<%=manual%>'> 
<input type='hidden' name='contador' id="contador"  value='<%=contador%>'> 
<input type='hidden' name='consultor'  id="consultor"  value='<%=consultor%>' > 
<input type='hidden' name='consultor'  id="consultor"  value='<%=consultor%>' > 
       
 <%-- MUESTRA EL DETALLADO DE LA CAMPANA  --%>         


<%-- Consulta si tiene carga el agente  --%>         
<% if(cliente==null   ){
   %>
<br>
 <a name="filtro"></a>
<table>
<tr>
	<td colspan="6">
		<div> 
        <table border="1">
        <tr>
            <td>Nombre <input type="text" name="txtbuscaXnombre" onKeyPress="return enter(event)">   </td>
        <td>Código <input type="text" name="txtbuscaXcodigo" onKeyPress="return enter(event)"> ></td>
        <td>Estado <input type="text" name="txtbuscaXestado"  onKeyPress="return enter(event)"> ></td>
        <td>Resultado de Gestión <input type="text" name="txtbuscaXresult" onKeyPress="return enter(event)">   
        <td>PEM <input type="text" name="txtbuscaXPei" onKeyPress="return enter(event)"> 
            
        <img alt="Buscar" src="img/search_f2.png" style="height: 22px; width: 25px" onclick="buscarXnombre()"> </td>
        <td> <img alt="Buscar" src="img/actualizar.jpg" style="height: 22px; width: 25px" onclick="buscarXnombre1()"></td>
        
        </tr>


       
        </table>
        </div>
<center> <p><h3>No se encontraron resultados</h3></p></center>
        </td>
</tr>
    
    <tr>   <td> 
                <%
}else{%>
<br>
<a name="filtro"></a>
<table>
    <tr>
	<td colspan="6">
		<div> 
        <table border="1">
        <tr>
        <td>Nombre <input type="text" name="txtbuscaXnombre" onKeyPress="return enter(event)"> </td>
        <td>Código <input type="text" name="txtbuscaXcodigo" onKeyPress="return enter(event)"></td>
        <td>Estado <input type="text" name="txtbuscaXestado" onKeyPress="return enter(event)"></td>
        <td>Resultado de Gestión <input type="text" name="txtbuscaXresult" onKeyPress="return enter(event)"> 
        <td>PEM <input type="text" name="txtbuscaXPei" onKeyPress="return enter(event)"> 
            
        <img alt="Buscar" src="img/search_f2.png" style="height: 22px; width: 25px" onclick="buscarXnombre()"> </td>
        <td> <img alt="Buscar" src="img/actualizar.jpg" style="height: 22px; width: 25px" onclick="buscarXnombre1()"></td>
        </tr>


       
        </table>
        </div>
	</td>
</tr>
    
    <tr>   <td> 
            
 <table width="1700" BORDER=1>
<tr> 
<td width="18" align ="center" class="Estilo4">ID</td>
<td width="105"  align ="center" class="Estilo4">Código Cliente</td>
<td width="250" align ="center"   class="Estilo4" >Nombre</td>
<td width="130" align ="center" class="Estilo4">Estado</td>
<td width="54" align ="center" class="Estilo4" >PEM</td>
<td width="200"  align ="center" class="Estilo4">Resultado de Gestión</td>
<td width="450" align ="center" class="Estilo4" >Anotación</td>
<td width="60" align ="center" class="Estilo4">Teléfono01</td> 
<td width="60" align ="center" class="Estilo4">Callresult01</td>
<td width="60" align ="center" class="Estilo4">Callback01</td> 
<td width="60" align ="center" class="Estilo4">Teléfono02</td> 
<td width="60" align ="center" class="Estilo4">Callresult02</td>
<td width="60" align ="center" class="Estilo4"  >Callback02</td>            
<td width="60" align ="center" class="Estilo4" >Teléfono03</td> 
<td width="70"  align ="center" class="Estilo4">Callresult03</td>
<td width="70" align ="center" class="Estilo4" >Callback03</td>
<td width="60"  align ="center" class="Estilo4">Intentos</td>


</tr> 

<% 
  /*  Integer Id= orasql.obtenerCodigo(campana,cn_sql);
String codcliente= "1"+orasql.codigocliente(Id,cn_sql);*/
    
    if (DetalleCliente != null){
 for (  int i = 0; i < DetalleCliente.size(); i++) {
 
     
     
     bdetalle = (beanDetalladoCliente) DetalleCliente.get(i);


 



%>
<tr> 
    <td align ="center" class="Estilo4"> <%=i + 1%></td>
  

  <td align ="center" class="Estilo4"><input type='button' name='codcliente<%=i%>' id='codcliente<%=i%>' disabled="true"  onclick ='copiar(this.id)' value= '<%=bdetalle.getCodCliente()%>'  /> </td>

<%
 
 if(bdetalle.getNrocallback()==null){
    bdetalle.setCallback1("");
    bdetalle.setCallback2("");
    bdetalle.setCallback3("");
 }
 
 
 if(bdetalle.getApellido()==null){
     
     %>
  <td class="Estilo4" >&nbsp;</td>
 <%

 }else{
%>
<td class="Estilo4" ><%=bdetalle.getApellido()%></td>
 <%
 }

 
 if(bdetalle.getEstado()==null){
  %>
   <td class="Estilo4" >&nbsp;</td>
  
  <%
 }
 
 
 
 else{
         
  %>
  <td align ="center" class="Estilo4"> <%=bdetalle.getEstado()%></td>
  
     <%         
 }
 if(bdetalle.getCodzonaventa()==null){
     %>
     <td class="Estilo4" >&nbsp;</td>
  
     <%
 }else{
     
     %>
     
  <td align ="center" class="Estilo4"> <%=bdetalle.getCodzonaventa()%></td>
  <%
 }
 
 %>
  

<%  if( bdetalle.getTipo_gestion()==null  || bdetalle.getTipo_gestion().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipo_gestion()%></td>
    <%
    }

   %>
   
   
    
    <%
 
 if(bdetalle.getAnotacion()==null){
     %>
     
     <td class="Estilo4" style="width: auto" >&nbsp;</td>
     
     <%
 }else{
     %>
     
     <td class="Estilo4" style="width: auto"   ><%=bdetalle.getAnotacion()%></td>
     <%
 }
 %>
 
 <%
 if(bdetalle.getNumero1()==null || bdetalle.getNumero1().equals("") ){
  
 %>
  <td class="Estilo4" >&nbsp;</td>
 <%
 }else{    
%>
<td align ="center" class="Estilo4"> <%=bdetalle.getNumero1()%></td>

<%
 }
 if(bdetalle.getCallResult1()==null ){
     %>
  <td class="Estilo4" >&nbsp;</td>   
     <%
 }else{
  
     if(bdetalle.getCallResult1().equals("0")){
     
     }
         
   
%>

<td align ="center" class="Estilo4"> <%=bdetalle.getCallResult1()%></td>
<%   
 }
 
 if( bdetalle.getCallback1()==null || bdetalle.getCallback1()==""){
%>
   <td class="Estilo4" >&nbsp;</td>     
     
     <%
 }else{
     
%>

<td align ="center" class="Estilo4"> <%=bdetalle.getCallback1()%></td>
<%
 }
 if(bdetalle.getNumero2()==null || bdetalle.getNumero2() ==""  ){
     
%>
   
 
  <td class="Estilo4" >&nbsp;</td>
 <%
 }else{
     %>
   <td align ="center" class="Estilo4"> <%=bdetalle.getNumero2()%></td>  

     <%
 }
 if(bdetalle.getCallResult2()==null){
     %>
     <td class="Estilo4" >&nbsp;</td>  
     <%
 }
 else{
     
%>
<td align ="center" class="Estilo4"> <%=bdetalle.getCallResult2()%></td>

<%
     
 }
 
 if(bdetalle.getCallback2()==null   || bdetalle.getCallback2()==""){
     
   %>
   <td class="Estilo4" >&nbsp;</td>
   <%
 }else{
  %>
  
  <td align ="center" class="Estilo4"> <%=bdetalle.getCallback2()%></td>
  <%
 }
 
 if(bdetalle.getNumero3()==null || bdetalle.getNumero3().equals("")){
     bdetalle.setNumero3("");
 
%> 
<td class="Estilo4" >&nbsp;</td>
<%
 }else{
 
%>
<td align ="center" class="Estilo4"> <%=bdetalle.getNumero3()%></td>

<%    
 }
 

 if(bdetalle.getCallResult3()==null){
     %>
    <td class="Estilo4" >&nbsp;</td>
     <%
 }else{

%>
<td align ="center" class="Estilo4"> <%=bdetalle.getCallResult3()%></td>

   <%

  
 }
 
 if(bdetalle.getCallback3()==null  || bdetalle.getCallback3()=="" ){bdetalle.setCallback3("");
 %>
 
  <td class="Estilo4" >&nbsp;</td>
 <%
 }else{
%>

<td class="Estilo4"> <%=bdetalle.getCallback3()%></td>

 <% 

   
     }
 if(bdetalle.getIntentos()==null){
     
     %>
     
       <td class="Estilo4" >&nbsp;</td>
     <%
 }else{
     %>
     
   <td  align ="center" class="Estilo4"> <%=bdetalle.getIntentos()%></td>  
     
     <%
 }
 
%>
</tr>
<%} 

}else{
        
        
       // out.println("Entro a manual");
    
for (  int i = 0; i < cliente.size(); i++) {
 
     
     
    bdetalle = (beanDetalladoCliente) cliente.get(i);
%>
<tr> 
    <td align ="center" class="Estilo4"> <%=i + 1%></td>
  

  <td align ="center" class="Estilo4"><input type='button' name='codcliente<%=i%>' id='codcliente<%=i%>' disabled="true"  onclick ='copiar(this.id)' value= '<%=bdetalle.getCodCliente()%>'  /> </td>

<%
 
 if(bdetalle.getNrocallback()==null){
    bdetalle.setCallback1("");
    bdetalle.setCallback2("");
    bdetalle.setCallback3("");
 }
 
 
 if(bdetalle.getApellido()==null){
     
     %>
  <td class="Estilo4" >&nbsp;</td>
 <%

 }else{
%>
<td class="Estilo4" ><%=bdetalle.getApellido()%></td>
 <%
 }
 

 
 if(bdetalle.getEstado()==null){
  %>
   <td class="Estilo4" >&nbsp;</td>
  
  <%
 }
 
 
 
 else{
         
  %>
  <td align ="center" class="Estilo4"> <%=bdetalle.getEstado()%></td>
  
     <%        
 }
 
 if(bdetalle.getCodzonaventa()==null){
     %>
     <td class="Estilo4" >&nbsp;</td>
  
     <%
 }else{
     
     %>
     
  <td align ="center" class="Estilo4"> <%=bdetalle.getCodzonaventa()%></td>
  <%
 }
 
 %>
 <%
if(bdetalle.getTipo_gestion()==null  || bdetalle.getTipo_gestion().equals("") ){
 %>
 <td class="Estilo4" >&nbsp;</td>
  
    <%
}else{
    %>
   <td class="Estilo4" ><%=bdetalle.getTipo_gestion()%></td>
    
 <%
}
 
 if(bdetalle.getAnotacion()==null){
     %>
     
      <td class="Estilo4" >&nbsp;</td>
     
     <%
 }else{
     %>
     
     <td class="Estilo4" ><%=bdetalle.getAnotacion()%></td>
     <%
 }
 %>
 
 <%
 if(bdetalle.getNumero1()==null || bdetalle.getNumero1().equals("") ){
  
 %>
  <td class="Estilo4" >&nbsp;</td>
 <%
 }else{    
%>
<td align ="center" class="Estilo4"> <%=bdetalle.getNumero1()%></td>

<%
 }
 if(bdetalle.getCallResult1()==null ){
     %>
  <td class="Estilo4" >&nbsp;</td>   
     <%
 }else{
  
     if(bdetalle.getCallResult1().equals("0")){
     
     }
         
   
%>

<td align ="center" class="Estilo4"> <%=bdetalle.getCallResult1()%></td>
<%   
 }
 
 if( bdetalle.getCallback1()==null || bdetalle.getCallback1()==""){
%>
   <td class="Estilo4" >&nbsp;</td>     
     
     <%
 }else{
     
%>

<td align ="center" class="Estilo4"> <%=bdetalle.getCallback1()%></td>
<%
 }
 if(bdetalle.getNumero2()==null  || bdetalle.getNumero2().equals("") ){
     
     bdetalle.setNumero2("");
 %>
  <td class="Estilo4" >&nbsp;</td>
 <%
 }else{
     %>
   <td align ="center" class="Estilo4"> <%=bdetalle.getNumero2()%></td>  

     <%
 }
 if(bdetalle.getCallResult2()==null){
     %>
     <td class="Estilo4" >&nbsp;</td>  
     <%
 }
 else{
     
%>
<td align ="center" class="Estilo4"> <%=bdetalle.getCallResult2()%></td>

<%
     
 }
 
 if(bdetalle.getCallback2()==null   || bdetalle.getCallback2()==""){
     
   %>
   <td class="Estilo4" >&nbsp;</td>
   <%
 }else{
  %>
  
  <td align ="center" class="Estilo4"> <%=bdetalle.getCallback2()%></td>
  <%
 }
 
 if(bdetalle.getNumero3()==null || bdetalle.getNumero3().equals("")  ){
     bdetalle.setNumero3("");
 
%> 
<td class="Estilo4" >&nbsp;</td>
<%
 }else{
 
%>
<td align ="center" class="Estilo4"> <%=bdetalle.getNumero3()%></td>

<%    
 }
 

 if(bdetalle.getCallResult3()==null){
     %>
    <td class="Estilo4" >&nbsp;</td>
     <%
 }else{

%>
<td align ="center" class="Estilo4"> <%=bdetalle.getCallResult3()%></td>

   <%

  
 }
 
 if(bdetalle.getCallback3()==null  || bdetalle.getCallback3()=="" ){bdetalle.setCallback3("");
 %>
 
  <td class="Estilo4" >&nbsp;</td>
 <%
 }else{
%>

<td class="Estilo4"> <%=bdetalle.getCallback3()%></td>

 <% 

   
     }
 if(bdetalle.getIntentos()==null){
     
     %>
     
       <td class="Estilo4" >&nbsp;</td>
     <%
 }else{
     %>
     
   <td  align ="center" class="Estilo4"> <%=bdetalle.getIntentos()%></td>  
     
     <%
 }
 
 
 
 
 
%>
</tr>    
    
    
    
    <%
    }
    }



%>
        </table>   </td> 
        
        <% for (int vueltas=0;vueltas<28;vueltas ++){%>
        
        <td width="120" > </td>
      <% }%>
        
        <td id="div60"  style="display:none" valign ="top"  valign="left"> <table width="584" border="1" >
  <tr>
    <td width="94" align ="center" class="Estilo5">Call Result</td>
    <td width="474" align ="center" class="Estilo5">Significado</td>
  </tr>
  <tr>
    <td align ="center">0</td>
    <td>El sistema no concreta intento de marcación al cliente.</td>
  </tr>
  <tr>
    <td align ="center">2</td>
    <td>Error de marcación. </td>
  </tr>
  <tr>
    <td align ="center">3</td>
    <td>Número no reportados en el servicio por la red.</td>
  </tr>
  <tr>
    <td align ="center">4</td>
    <td>Sin Tono de retorno después de discado. </td>
  </tr>
  <tr>
    <td align ="center">5</td>
    <td>Operador, intersección de regresar a la red cuando intentó establecer línea.</td>
  </tr>
  <tr>
    <td align ="center">6</td>
    <td>Sin tono de marcación. </td>
  </tr>
  <tr>
    <td align ="center">7</td>
    <td>Número invalido. </td>
  </tr>
  <tr>
    <td align ="center">8</td>
    <td>No responde. </td>
  </tr>
  <tr>
    <td align ="center">9</td>
    <td>Número de cliente se encuentra ocupado. </td>
  </tr>
  <tr>
    <td align ="center">10</td>
    <td>Llamada Atendida por Agente. </td>
  </tr>
  <tr>
    <td align ="center">11</td>
    <td>Fax Detectado. </td>
  </tr>
  <tr>
    <td align ="center">12</td>
    <td>Contestadora Automática.</td>
  </tr>
  <tr>
    <td align ="center">13</td>
    <td>Marcador detuvo la marcación por falta de recursos.</td>
  </tr>
  <tr>
    <td align ="center">14</td>
    <td>Cliente solicita devolución de llamada.</td>
  </tr>
  <tr>
    <td align ="center">16</td>
    <td>Llamada abandonada por el Discador a la falta de agente.</td>
  </tr>
  <tr>
    <td align ="center">17</td>
    <td>Error al agente de reserva para la devolución de llamada personal.</td>
  </tr>
  <tr>
    <td align ="center">18</td>
    <td>Agente omite llamada.</td>
  </tr>
  <tr>
    <td align ="center">19</td>
    <td>Agente rechaza y cierra llamada. </td>
  </tr>
  <tr>
    <td align ="center">20</td>
    <td>Cliente ha sido abandonado a un IVR.</td>
  </tr>
  <tr>
    <td align ="center">21</td>
    <td>Llamada colgada por cliente.</td>
  </tr>
  <tr>
    <td align ="center">22</td>
    <td>Generalmente se utiliza conmutadores TDM - contestador automático de red.</td>
  </tr>
  <tr>
    <td align ="center">23</td>
    <td>Número contactado con éxito pero un número equivocado.</td>
  </tr>
  <tr>
    <td align ="center">24</td>
    <td>Número contactado con éxito pero llegado a la persona equivocada</td>
  </tr>
  <tr>
    <td align ="center">25</td>
    <td>Discador descarta llamada por cambios realizados en campaña.</td>
  </tr>
  <tr>
    <td align ="center">26</td>
    <td>El número estaba en la lista de no llamar.</td>
  </tr>
  <tr>
    <td align ="center">27</td>
    <td>Llamada descartada por operador.</td>
  </tr>
  <tr>
    <td align ="center">28</td>
    <td>Detecta tono de silencio. </td>
  </tr>
  <tr>
    <td align ="center">100</td>
    <td>Llamada Manual en Ruta.</td>
  </tr>
  <tr>
    <td align ="center">101</td>
    <td>Llamada Manual Fuera de Ruta.</td>
  </tr>
  <tr>
    <td align ="center">102</td>
    <td>Llamada Manual.</td>
  </tr>
        
                       </table>
    </tr>
</table>
<a name="llamada"></a>
<%      // System.out.println("valor de campana:" + campa);
               String estadocad=  orasql.estadocad(campa,cn_sql);
            ///   System.out.println("Entro preparado"+estadocad); 
               
               
         if(estadocad.equals("Preparado")){
             //out.println("Entro preparado detalle");
             
            // System.out.println("tamaño "+cliente.size() );
             %>
           
             <script type="text/javascript">
   //alert("Desactiva boton");
   var tam= <%=cliente.size()%>;
   ///alert("lista tamaño"+ tam);
   if( tam == 0){
     // alert("lista trae 0");
   }else{
   
      var i=0;for(i=0;i < <%=cliente.size()%>  ;i++){
     document.getElementById("codcliente"+i).disabled = true; 
     
      }  
  }
    </script>
             <%
         }else{
        %>
         <script type="text/javascript">
  
    var i=0;for(i=0;  i <  <%=cliente.size()%>  ;i++){
     document.getElementById("codcliente"+i).disabled = false; 
 
      }
 
  </script>    
       
         <%   
         }
        %>
 
  
 <%-- MUESTRA LOS NROS DEL CLICK TO CALL  --%>  
 

<% }
   


      request.removeAttribute("manual");
        
        xcodigo="1" + xcodigo;
%>
      


  <script language="javascript">   
 
   //   alert("ca,bia titulo");
  /* var codi =;
   var concate= codi.substring(1);*/
   
   document.title=  'DetalleLlamadas - '+ <%=xcodigo%> ;  
  
 
    </script>
</form>
        
  
    
</body>
</html>