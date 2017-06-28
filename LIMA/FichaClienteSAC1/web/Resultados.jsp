<%-- 
    Document   : Resultados
    Created on : 28/11/2013, 01:20:48 PM
    Author     : GMD
--%>


<%@page import="com.pe.backus.factory.oracleDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.dto.beanTelefonoParentesco"%>
<%@page import="com.pe.backus.dto.beanTelefonoClienteLista"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.dto.beanResumenCamp"%>

<%@page import="com.pe.backus.factory.sqlDaoFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoRascal2FactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page import="com.pe.backus.dto.beanResuLLamada"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
 
<head>
<title>Resultados de Contacto</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
<script src ="js/Resultado.js"></script>

<style type="text/css">
     #div6 {
         
   overflow:scroll;
   height:250px;
   width: 1301px;
   
      }
         #vertical-bar {
        border-left: 1px solid #ccc;
        width:1px;
        height:450px;
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

<body>
 <form id="form1" name="form1">
     
     
       <%
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();

 // Connection cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection   cn_rascal2= sqlDaoRascal2FactoryImpl.getSQLConextionRascal();
Connection connection= oraclefactooriginal.getSQLConextion();

//Connection resucn = sqlresultadoConexion.getSQLConextion();


String codcli = request.getParameter("codcli"); 
String  campana = request.getParameter("campana"); 
String campa = request.getParameter("campa");
String ANI = request.getParameter("ANI");
String NombreCliente= (String)session.getAttribute("NombreCliente");
String  Identificador= request.getParameter("Identificador");
String Contacto=oraCliente.obtenerContacto(codcli,connection);
////System.out.println("contac==========> "+Contacto);
%>          
<iframe id="resultadocabecera"  frameborder="NO"   scrolling ="no"  name="resultadocabecera" src="cabeceraResultado.jsp?campana=<%=campana%>&campa=<%=campa%>&codcli=<%=codcli%>&contacto=<%=Contacto%>"  width="1600px"  height="300px" >
 </iframe>  
 <iframe id="resulContenido"  frameborder="NO"   scrolling ="no"   name="resulContenido" src="CuerpoResultado.jsp?Identificador=<%=Identificador%>&campana=<%=campana%>&campa=<%=campa%>&codcli=<%=codcli%>&ANI=<%=ANI%>&contacto=<%=Contacto%>&nombrecliente=<%=NombreCliente %>" width="1600px"  height="950px">
</iframe>
 
 </form>
    </body>
</html>
