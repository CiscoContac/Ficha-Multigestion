<%--  
    Document   : CONSULTOR
    Created on : 27/11/2013, 02:31:24 PM
    Author     : GMD
--%>

<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.dto.beanTelefonoParentesco"%>
<%@page import="com.pe.backus.dto.beanTelefonoClienteLista"%>
<%@page import="com.pe.backus.dto.beanCampania"%>
<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.dto.beansemaxprod"%>
<%@page import="com.pe.backus.dto.beanSumatoriaSemanas"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.factory.oracleDaoLocalFactoryImpl"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="com.pe.backus.dto.beantabladinamica"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.pe.backus.dto.beanCredito"%>
<%@page import="com.pe.backus.dto.beanProductividad"%>
<%@page import="com.pe.backus.dto.beanClienteBo"%>
<%@page import="com.pe.backus.dto.beanAnotacionAgente"%>
<%@page import="com.pe.backus.dto.beansemana"%>
<%@page import="com.pe.backus.dto.beanobtenersemanporpodycant"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.pe.backus.dto.beanAnotacion"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page import="com.pe.backus.dto.beanTotalCantidad"%>
<%@page import="com.pe.backus.dto.beanProducto"%>
<%@page import="com.pe.backus.dto.beanFecha"%>
<%/*@page import="com.pe.backus.dto.beanFecha"*/%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date " %>

<!DOCTYPE html>
<html id="htmlconsultor">
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
    <title>Información General</title>
    <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
    
     <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<title>JSP Page</title>
        <style type="text/css">
<!--
.Estilo2 {
	font-size: 16px;
	font-weight: bold;
	font-family: "Trebuchet MS";
}
-->
      #div6 {
   overflow:scroll;
   height:80px;
      }
 #div6 table {
   width:60px;
   background-color:lightgray;

}

     #div40 {
         
   overflow:scroll;
   height:160px;
   width: 970px;
   
      }
    





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
  
<body id="padreconsultor"  >
      <%
       String  campa  =  request.getParameter("campana");//campaña de agente
       String capaign=  request.getParameter("campa");//c
      String xpreparado = request.getParameter("Account_Number");
      String codigo = request.getParameter("txtcodigo");
     String  codCliente = request.getParameter("codCliente");
    
      %>
<form name="form1">   
   
    <%  if (xpreparado != null  ){%>
    
    <iframe id="consutorcabecera"  frameborder="NO"   scrolling ="no"  name="consutorcabecera" src="frameconsultor1.jsp?campana=<%=campa%>&campa=<%=capaign%>&Account_Number=<%=xpreparado%>&prepclicto=valor" style="height: 285px"  width="1600px"  >
 </iframe>  
 <iframe id="consultorcuerpo"  frameborder="NO"   scrolling ="no"   name="consultorcuerpo" src="frameConsultorCuerpo.jsp?campana=<%=campa%>&campa=<%=capaign%>&xcodigo=<%=xpreparado%>"  style="height: 3220px"  width="1600px" >
</iframe>
<iframe id="frameinvisible"  frameborder="NO"   scrolling ="no"   name="frameinvisible" src="frmConsulInvisible.jsp" width="1600px" height="1200px" style="display: none">
</iframe> 

<%}else if (codCliente != null){    
    %>
  

    <iframe id="consutorcabecera"  frameborder="NO"   scrolling ="no"  name="consutorcabecera" src="frameconsultor1.jsp?campana=<%=campa%>&campa=<%=capaign%>&codCliente=<%=codCliente%>"   style="height: 285px"  width="1600px"  >
 </iframe>  
 <iframe id="consultorcuerpo"  frameborder="NO"   scrolling ="no"   name="consultorcuerpo" src="frameConsultorCuerpo.jsp?campana=<%=campa%>&campa=<%=capaign%>&xcodigo=<%=codCliente%>" style="height: 3220px"  width="1600px" >
</iframe>
<iframe id="frameinvisible"  frameborder="NO"   scrolling ="no"   name="frameinvisible" src="frmConsulInvisible.jsp" width="1600px" height="1200px" style="display: none">
</iframe> 

<%
}else if(codigo != null){
   
%>
<iframe id="consutorcabecera"  frameborder="NO"   scrolling ="no"  name="consutorcabecera" src="frameconsultor1.jsp?campana=<%=campa%>&campa=<%=capaign%>&txtcodigo=<%=codigo%>"   style="height: 285px"  width="1600px"  >
 </iframe>  
 <iframe id="consultorcuerpo"  frameborder="NO"   scrolling ="no"   name="consultorcuerpo" src="frameConsultorCuerpo.jsp?campana=<%=campa%>&campa=<%=capaign%>&xcodigo=<%=codigo%>" style="height: 3220px"  width="1600px" >
</iframe>
<iframe id="frameinvisible"  frameborder="NO"   scrolling ="no"   name="frameinvisible" src="frmConsulInvisible.jsp" width="1600px" height="1200px" style="display: none">
</iframe> 

<%
    
}

else
    {
%>

<iframe id="consutorcabecera"  frameborder="NO"   scrolling ="no"  name="consutorcabecera" src="frameconsultor1.jsp?campana=<%=campa%>&campa=<%=capaign%>" style="height: 285px"   width="1600px"  >
 </iframe>  
 <iframe id="consultorcuerpo"  frameborder="NO"   scrolling ="no"   name="consultorcuerpo" src="frameConsultorCuerpo.jsp?campana=<%=campa%>&campa=<%=capaign%>" style="height: 3220px" width="1600px" >
</iframe>
<iframe id="frameinvisible"  frameborder="NO"   scrolling ="no"   name="frameinvisible" src="frmConsulInvisible.jsp" width="1600px" height="1200px" style="display: none">
</iframe> 

<%
    }
%>
</form>
  
</body>
</html>

