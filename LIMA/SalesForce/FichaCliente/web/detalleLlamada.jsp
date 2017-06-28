<%-- 
    Document   : detalleLlamada
    Created on : 03/01/2014, 02:51:35 PM
    Author     : GMD
--%>

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
  //out.println("DETALLADO CAMPAna"+ campana );
          
          String xcodigo= request.getParameter("codcli");
          
          String campa= request.getParameter("campa");
          
    
//out.println("DETALLADO CAMPA"+ campa );
     String refrescar= request.getParameter("refrescar");

    String  frame= request.getParameter("frame");
       String  concliente = request.getParameter("concliente");
      //CONEXION CON BASE DE DATOS        
  Connection connection = oracleDaoLocalFactoryImpl.getSQLConextion();
  Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
  //Connection cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
 Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();
  
clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();



        %>
        <form id='form3' name='form3' method='post' style="font-family: 'Trebuchet MS'; font-size: 12px;" >
            
 <%if (refrescar!=null)  { //Preparado %>  
 <iframe id="framecabecera"  frameborder="NO"   scrolling ="no" name="framecabecera" src="cabecera.jsp?campana=<%=campana%>&campa=<%=campa%>&refrescar=valor"  width="2000px" height="40px" >
 </iframe>  
 <iframe id="framenumero"  frameborder="NO" scrolling ="no"   name="framenumero" src="listaNumero.jsp?codcli=<%=xcodigo%>&campana=<%=campana%>&campa=<%=campa%>"  width="2000px" height="250px" >
</iframe> 
        
<% }  else  if (concliente != null){
 %>
 <iframe id="framecabecera"  frameborder="NO"   scrolling ="no" name="framecabecera" src="cabecera.jsp?campana=<%=campana%>&campa=<%=campa%>&refrescar=valor"  width="2000px" height="40px" >
 </iframe> 
      <iframe id="framenumero"  frameborder="NO" scrolling ="no"   name="framenumero" src="listaNumero.jsp?codcli=<%=xcodigo%>&campana=<%=campana%>&campa=<%=campa%>&valor=valor"  width="2000px" height="250px" >
</iframe>
 
 
<% 
}
 else{ //No preparado
//out.println("entro a detallado cabecera");
%> 
<iframe id="framecabecera"  frameborder="NO"   scrolling ="no" name="framecabecera" src="cabecera.jsp?campana=<%=campana%>&campa=<%=campa%>&concliente=<%=concliente%>"  width="2000px" height="40px" >
</iframe>
     <iframe id="framenumero"  frameborder="NO"  scrolling ="no"  name="framenumero" src="listaNumero.jsp?codcli=<%=xcodigo%>&campana=<%=campana%>&campa=<%=campa%>"  width="2000px" height="250px" >
</iframe>   
     <%
 }%>    
            
    <%if (frame != null ){//no preparado %>
    <iframe id="framedetalla"  frameborder="NO" scrolling ="no"   name="framedetalla" src="index.jsp?campana=<%=campana%>&campa=<%=campa%>&manual=valor"  width="1700px" height="5900px" >
     </iframe>
    <%
    }else  if (concliente != null){//manual con cliente
       // out.println("detalle concliente"+concliente);
        %>
      
          <iframe id="framedetalla"  frameborder="NO" scrolling ="no"   name="framedetalla" src="index.jsp?campana=<%=campana%>&campa=<%=campa%>&manual=valor&validacion=<%=concliente%>"  width="1700px" height="5900px" >
     </iframe>
     
   

        <%
    }else{//preparado
        //out.println("Entro al else de frame");
        %>
  
        
<iframe id="framedetalla"  frameborder="NO" scrolling ="no"   name="framedetalla" src="index.jsp?campana=<%=campana%>&campa=<%=campa%>"  width="1700px" height="5900px" ></iframe>     
          

     <%
  }
    
    request.removeAttribute("frame");
     %>

 
</form>
        
  
    
</body>
</html>