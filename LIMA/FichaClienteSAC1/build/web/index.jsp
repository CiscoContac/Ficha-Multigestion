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
<%@page import="com.pe.backus.dto.beanDetalladoClienteSAC"%>
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
String Drop =  request.getParameter("Drop");
String manual =  request.getParameter("manual");
String valor= request.getParameter("valor");
String contador=  request.getParameter("contador");
String consultor=  request.getParameter("consultor");
 String click =  request.getParameter("click");
  String         llamar =  request.getParameter("llamar");
   String refrescar= request.getParameter("refrescar");
   String validacion = request.getParameter("validacion");
  String flagBusqueda = request.getParameter("flagBusqueda");
  
 String  anclafiltro = request.getParameter("anclafiltro");
   String where = (String)request.getAttribute("where");
   if(where== null || where.equals("null")){
    where="";
    
   }
   session.setAttribute("wherejsp", where);
   
   //CONEXION CON BASE DE DATOS        
   Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();
  Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
     Connection sql_local=    sqlDaoRascalFactoryImpl.getSQLConextionRascal() ;
 Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();
  
clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
List<beanDetalladoClienteSAC> DetalleCliente =null;

%>

<%
if (campana == null || campana.equals("") ){
    
    
}else{
if (validacion == null){
    
DetalleCliente  = orasql.ObtenerDetalle(campana,sql_local);

   cn_ippc.close();
session.setAttribute("sessiondetallado", DetalleCliente);
 //out.println("Entro la primera vez");
    }
if(flagBusqueda==null){
    
}else

if(flagBusqueda.equals("1")){
    session.setAttribute("campanaSesion", campana);
    List<beanDetalladoClienteSAC> DetalleClienteBusqueda = null;
    DetalleClienteBusqueda = (ArrayList)request.getAttribute("ListObtenerDetalle");
    session.setAttribute("sessiondetallado", DetalleClienteBusqueda);
}
}
List<beanDetalladoClienteSAC > cliente =(ArrayList) session.getAttribute("sessiondetallado");





beanDetalladoClienteSAC beanDetalladoCliente;
beanDetalladoClienteSAC bdetalle = null;
        
List<beanTelefonoClienteLista> telefono = orasql.ObtenerTelefonoLista(xcodigo,cn_sql);
//beanClienteTelefono beanClienteTelefono;
beanTelefonoClienteLista beanClienteFono = null;

List<beanTelefonoParentesco>  ListaParentesco = oraCliente.ObtenerTelefonoParentesco(xcodigo,cnNC);
cnNC.close();
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
       
       
     </tr>
    </table>
   
    <table width="" height="25">
<tr>
            <td width="1740" bgcolor="#97D4FE" class="Estilo1">Detalle de Gestión SAC Online-<%=fecha%>            </td>
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
		<div > 
        <table border="1">
        <tr align="center">
            <td>Teléfono Gestionado<br><input type="text" name="txtbuscaXtelef" onKeyPress="return enter(event)"> </td>
            <td>Identificador de Cliente<br><input type="text" name="txtbuscaXidenti" onKeyPress="return enter(event)"> </td>

            <td>Gestión<br><input type="text" name="txtbuscaXgesti" onKeyPress="return enter(event)"> </td>
           
            <td>Tipo Cliente<br><input type="text" name="txtbuscaXtipoCliente" onKeyPress="return enter(event)"> </td> 
                
            <td>Tipo Llamada<br><input type="text" name="txtbuscaXtipoLlamada" onKeyPress="return enter(event)"> </td> 
             
            <td>Resultado Llamada<br><input type="text" name="txtbuscaXresultadoLlamada" onKeyPress="return enter(event)"> </td> 
             
            <td>Tipificación de Llamada<br><input type="text" name="txtbuscaXtipificacionLlamada" onKeyPress="return enter(event)">  
                
        
        
             <td><img alt="Buscar" src="img/search_f2.png" style="height: 22px; width: 25px" onclick="buscarXnombre()"> </td>
            <td> <img alt="Buscar" src="img/actualizar.jpg" style="height: 22px; width: 25px" onclick="buscarXnombre1()"></td>
        </tr>


       
        </table>
                    <br>
        </div>
            <center> <p><h3>No se encontraron resultados</h3></p></center>
	</td>
</tr>
    
    <tr>   
        <td> 
                <%
}else{%>
<br>
<a name="filtro"></a>
<table>
  <tr>
	<td colspan="6">
		<div > 
        <table border="1">
        <tr align="center">
            <td>Teléfono Gestionado<br><input type="text" name="txtbuscaXtelef" onKeyPress="return enter(event)"> </td>
            <td>Identificador de Cliente<br><input type="text" name="txtbuscaXidenti" onKeyPress="return enter(event)"> </td>

            <td>Gestión<br><input type="text" name="txtbuscaXgesti" onKeyPress="return enter(event)"> </td>
            <td>Tipo Cliente<br><input type="text" name="txtbuscaXtipoCliente" onKeyPress="return enter(event)"> </td> 
                
            <td>Tipo Llamada<br><input type="text" name="txtbuscaXtipoLlamada" onKeyPress="return enter(event)"> </td> 
             
            <td>Resultado Llamada<br><input type="text" name="txtbuscaXresultadoLlamada" onKeyPress="return enter(event)"> </td> 
             
            <td>Tipificación de Llamada<br><input type="text" name="txtbuscaXtipificacionLlamada" onKeyPress="return enter(event)">  
              
            <td><img alt="Buscar" src="img/search_f2.png" style="height: 22px; width: 25px" onclick="buscarXnombre()"> </td>
            <td> <img alt="Buscar" src="img/actualizar.jpg" style="height: 22px; width: 25px" onclick="buscarXnombre1()"></td>
        </tr>


       
        </table>
                       <br>
        </div>
	</td>
</tr>
    
    <tr>   
        <td> 
            
 <table width="1450" BORDER=1>
<tr> 
<td width="18" align ="center" class="Estilo4">ID</td>
<td width="200"  align ="center" class="Estilo4">Teléfono Gestionado</td>
<td width="250" align ="center"   class="Estilo4" >Fecha y Hora </td>
<td width="250" align ="center"   class="Estilo4" >Gestión</td>
<td width="200"  align ="center" class="Estilo4">Tipo Identificador</td>
<td width="100"  align ="center" class="Estilo4">Identificador de Cliente</td>
<td width="200"  align ="center" class="Estilo4">Tipo Cliente</td>
<td width="200"  align ="center" class="Estilo4">Tipo Llamada</td>
<td width="100"  align ="center" class="Estilo4">Resultado de Llamada</td>
<td width="100"  align ="center" class="Estilo4">Tipificación de Llamada</td>
<td width="100"  align ="center" class="Estilo4">Reintentos por Contacto</td>
<td width="100"  align ="center" class="Estilo4">Reintentos por Cliente</td>

</tr> 

<% 
  /*  Integer Id= orasql.obtenerCodigo(campana,cn_sql);
String codcliente= "1"+orasql.codigocliente(Id,cn_sql);*/
    
    if (DetalleCliente != null){
 for (  int i = 0; i < DetalleCliente.size(); i++) {

     
     bdetalle = (beanDetalladoClienteSAC) DetalleCliente.get(i);

%>
<tr> 
    <td align ="center" class="Estilo4"> <%=i + 1%></td>
  
  
<%
 
 
 
 if(bdetalle.getNumero()==null ||bdetalle.getNumero().equals("null")  || bdetalle.getNumero().equals("")){
     
     %>
  <td class="Estilo4" >&nbsp;</td>
 <%

 }else{
%>
<td class="Estilo4" ><%=bdetalle.getNumero()%></td>
 <%
 }
 
if(bdetalle.getFecha()==null){
     
     %>
  <td class="Estilo4" >&nbsp;</td>
 <%

 }else{
%>
<td class="Estilo4" ><%=bdetalle.getFecha()%></td>
 <%
 }
 
 if(bdetalle.getTipo()==null || bdetalle.getTipo().equals("") ){
  %>
   <td class="Estilo4" >&nbsp;</td>
  
  <%
 }
 
 
 
 else{
         
  %>
  <td align ="center" class="Estilo4"> <%=bdetalle.getTipo()%></td>
  
     <%         
 }
%>
  

<%  if( bdetalle.getTipo_Identificador()==null  || bdetalle.getTipo_Identificador().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipo_Identificador()%></td>
    <%
    }

   %>
   
  <%  if( bdetalle.getCodcliente()==null  || bdetalle.getCodcliente().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getCodcliente()%></td>
    <%
    }

   %>
 
   <% if( bdetalle.getTipo_Cliente()==null  || bdetalle.getTipo_Cliente().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipo_Cliente()%></td>
    <%
    }

   %>   
   
   
   
  <% if( bdetalle.getTipo_Llamada()==null  || bdetalle.getTipo_Llamada().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipo_Llamada()%></td>
    <%
    }

   %>   
 <%  if( bdetalle.getResultado_Contacto()==null  || bdetalle.getResultado_Contacto().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getResultado_Contacto()%></td>
    <%
    }

   %>   
    <%  if( bdetalle.getTipificacion_Llamada()==null  || bdetalle.getTipificacion_Llamada().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipificacion_Llamada()%></td>
    <%
    }

   %>  
   
  <%  if( bdetalle.getCONTADORCliente()==null  || bdetalle.getCONTADORCliente().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getCONTADORCliente()%></td>
    <%
    }

   %>      
   
   
  <%  if( bdetalle.getCONTADORContacto()==null  || bdetalle.getCONTADORContacto().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getCONTADORContacto()%></td>
    <%
    }

   %>    
   

</tr>
<%} 

}else{
        for (  int i = 0; i < cliente.size(); i++) {
 
     
     
    bdetalle = (beanDetalladoClienteSAC) cliente.get(i);
        
        %>
       
      <tr> 
     <td align ="center" class="Estilo4"> <%=i + 1%></td>
  
  
<%
 
 
 
 if(bdetalle.getNumero()==null ||bdetalle.getNumero().equals("null")  || bdetalle.getNumero().equals("")){
     
     %>
  <td class="Estilo4" >&nbsp;</td>
 <%

 }else{
%>
<td class="Estilo4" ><%=bdetalle.getNumero()%></td>
 <%
 }
 
if(bdetalle.getFecha()==null){
     
     %>
  <td class="Estilo4" >&nbsp;</td>
 <%

 }else{
%>
<td class="Estilo4" ><%=bdetalle.getFecha()%></td>
 <%
 }
 
 if(bdetalle.getTipo()==null || bdetalle.getTipo().equals("") ){
  %>
   <td class="Estilo4" >&nbsp;</td>
  
  <%
 }
 
 
 
 else{
         
  %>
  <td align ="center" class="Estilo4"> <%=bdetalle.getTipo()%></td>
  
     <%         
 }
%>
  

<%  if( bdetalle.getTipo_Identificador()==null  || bdetalle.getTipo_Identificador().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipo_Identificador()%></td>
    <%
    }

   %>
   
  <%  if( bdetalle.getCodcliente()==null  || bdetalle.getCodcliente().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getCodcliente()%></td>
    <%
    }

   %>
 
   <% if( bdetalle.getTipo_Cliente()==null  || bdetalle.getTipo_Cliente().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipo_Cliente()%></td>
    <%
    }

   %>   
   
   
   
  <% if( bdetalle.getTipo_Llamada()==null  || bdetalle.getTipo_Llamada().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipo_Llamada()%></td>
    <%
    }

   %>   
 <%  if( bdetalle.getResultado_Contacto()==null  || bdetalle.getResultado_Contacto().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getResultado_Contacto()%></td>
    <%
    }

   %>   
    <%  if( bdetalle.getTipificacion_Llamada()==null  || bdetalle.getTipificacion_Llamada().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getTipificacion_Llamada()%></td>
    <%
    }

   %>  
   
  <%  if( bdetalle.getCONTADORCliente()==null  || bdetalle.getCONTADORCliente().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getCONTADORCliente()%></td>
    <%
    }

   %>      
   
   
  <%  if( bdetalle.getCONTADORContacto()==null  || bdetalle.getCONTADORContacto().equals("")){%>
 
<td class="Estilo4" >&nbsp;</td>
  
   <% }else{
    
    %>
 <td class="Estilo4" ><%=bdetalle.getCONTADORContacto()%></td>
    <%
    }

   %>    
   

</tr>
<%}
    }



%>
        </table>   </td> 
        
        <% for (int vueltas=0;vueltas<28;vueltas ++){%>
        
        <td width="120" > </td>
      <% }%>
        
        <td id="div60"  style="display:none" valign ="top"  valign="left"> 
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
        
     <%--   if( manual==null ){
    
//out.println("Desactiva botones");
    %>
    <script type="text/javascript">
   
      var i=0;for(i=0;i < <%=DetalleCliente.size()%>  ;i++){
     document.getElementById("codcliente"+i).disabled = true; 
     
      }  
    </script>
    
    <%
}else{
//out.println("Activa botones");
%>
  <script type="text/javascript">
  
    var i=0;for(i=0;  i <  <%=cliente.size()%>  ;i++){
     document.getElementById("codcliente"+i).disabled = false; 
 
      }
 
  </script>
  
   <%if(manual.equals("desactivado")){%>
  
  
  <script type="text/javascript">
  
    var i=0;for(i=0;i < <%=DetalleCliente.size()%>  ;i++){
     document.getElementById("codcliente"+i).disabled = true; 
 
      }
 
  </script>
 <% }%>
  
  
  
  <%}--%>

  
  
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