<%-- 
    Document   : detalleLlamada
    Created on : 03/01/2014, 02:51:35 PM
    Author     : GMD
--%>

<%@page import="com.pe.backus.factory.CerrarCursor"%>
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
<%@page import="com.pe.backus.dto.beanTelefonoParentesco"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   
    <head>

  <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
  <script   src ="js/cabecera.js">

       </script>

        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <title>cabecera</title>
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
 String campa= request.getParameter("campa");
//out.println("CABECERA DE CAMPA"+campa);
 String codCliente = request.getParameter("codCliente");
String refrescar = request.getParameter("refrescar");
//out.println("cabecera"+refrescar);
 String campaña= "CAMP_"+campa;
  String grabar = request.getParameter("grabar");
String  concliente = request.getParameter("concliente");
session.setAttribute("codclisession", codCliente);

String codcli= (String) session.getAttribute("codclisession");

  Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
 Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
     CerrarCursor cerrar =  new  CerrarCursor();
clienteSqlDaoImpl sqlImplements = new clienteSqlDaoImpl();

    
%>

<form id='form3' name='form3' method='post' style="font-family: 'Trebuchet MS'; font-size: 12px;" >
 
<table width="1900" border="0">
            <tr>
              <td width="54" valign="top"><div id="u298" class="u298_container"   >
<div id="u298_img" >
<img src="img/u2_normal.jpg"  class="raw_image"></div>
<div id="u299" class="u299" style="visibility:hidden;"  >
<div id="u299_rtf"></div>
</div>
</div></td>
                <td width="376" valign="top">

                    
                  <div id="u302" class="u302_container"   >
<div id="u302_img" >
<img src="img/u4_normal.jpg"  class="raw_image"></div>
<div id="u303" class="u303" style="visibility:hidden;"  >
<div id="u303_rtf"></div>
</div>
</div></td>
                <td width="1292" valign="top"><table width="1400" height="10">
        <tr> 
            <td width="545" height="57" align="center" valign="top">
          <div id="mensaje" style="display: none">
                    <MARQUEE scrollamount="5" width="20"> <<<</marquee><h4>Actualizando Espere......</h4> <MARQUEE scrollamount="5" direction="right" width="60"> >>> </marquee>  
                </div>
                
                
                <div id ="divactu" style="top: -2px; position:absolute">
       <label>
    <img    src="img/refrescar.jpg"   alt="Refrescar"  id="fresh"  value="Refresh"  onclick="refrescar()"  style="width:50px;height:50px;top: -100px">  
      </label></div>
            </td>
       
     </tr>
    </table></td>
                <td width="160" valign="top">
                <div id="u300" class="u300_container"   >
<div id="u300_img" >
<img src="img/u0_normal.jpg"  class="raw_image"></div>
<div id="u301" class="u301" style="visibility:hidden;"  >
<div id="u301_rtf"></div>
</div>
</div></td>
            </tr>
  </table>
  
  <input type="hidden" id="campa" name="campa" value="<%=campa%>" >
    <input type="hidden" id="campana" name="campana" value="<%=campaña%>" >
 <%--<input type="hidden" id="refrescar" name="refrescar" value="<%=refrescar%>" >--%> 
   
     <%
  
if( grabar !=null){
    
     String Consulta="consulta";
           //out.println("<H1>"+campaña+"</H1>");
 %>
 <%--<script>
     alert('<%=campaña%>');
     </script>--%>
    <%
           
           sqlImplements.insertarClienteIdentificador(campaña, codCliente,"M",cn_rascalLocal );
          //// cn_rascalLocal.close();
            Integer Id= sqlImplements.obtenerCodigo(campaña,cn_rascalLocal);
            cn_rascalLocal.close();
       ///    sqlImplements.insertarClienteManual(Id,Consulta,cn_sql);
           sqlImplements.insertarClienteAnotacion(Id,Consulta,codCliente,cn_sql);
           sqlImplements.insertarClienteResultadoLlamada(Id,codCliente,campaña,cn_sql);
           
            String estadocad=   sqlImplements.estadocad(campa,cn_sql);
            
             
             if(estadocad.equals("Inicia manual con cliente")){}else{
            sqlImplements.insertarestador( campa,"", "jijoja","Inicia manual con cliente",cn_sql);}
           String varcont="0";
             sqlImplements.insertclickttocall(Id,campaña,varcont,cn_sql);
         cerrar.cerrar(cn_sql);
    
    
}
        
        %>
</form>
        
  
    
</body>
</html>