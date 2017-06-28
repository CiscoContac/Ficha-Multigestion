<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.factory.oracleDaoLocalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dto.beanTelefonoAgregados"%>
<%@page import="com.pe.backus.dto.beanTelefonoClienteLista"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.dto.beanClienteTelefonoLocal"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="com.pe.backus.dto.beanClienteTelefono"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pe.backus.dto.beanTelefonoParentesco"%>
<%--jsp:useBean id="beanClienteFono" class="com.pe.backus.dto.beanClienteTelefono" scope="session"></jsp:useBean>
<jsp:useBean id="beanClienteFonoLocal" class="com.pe.backus.dto.beanClienteTelefonoLocal" scope="session"></jsp:useBean--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   
<head>
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <meta equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Actualización de Datos</title>

    <style type="text/css">

 #vertical-bar {
        border-left: 1px solid #ccc;
        width:1px;
        height:120px;
		
		
    }
	#vertical-bar2 {
        border-left: 1px solid #ccc;
        width:1px;
        height:90px;
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
 <script src="js/informacion.js">
            
            
            
        </script>
        
        
          <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>  
        <%
 //  String  cod = "0010081655";
String campana = request.getParameter("campana");
String campa= request.getParameter("campa");
String  cod = request.getParameter("codcli");
String Drop =  request.getParameter("Drop");
String manual =  request.getParameter("manual");
String valor= request.getParameter("valor");
String contador=  request.getParameter("contador");
String consultor=  request.getParameter("consultor");
String redire = request.getParameter("redire");
String otro=request.getParameter("otro");
String tacto=request.getParameter("Contacto");
String afonos=request.getParameter("afonos");
String llamadas=request.getParameter("llamadas");
String variable = request.getParameter("numeroclicktocholl");
%>

<iframe id="inforcabecera"  frameborder="NO"   scrolling ="no"  name="inforcabecera" src="CuerpoInformacion.jsp?campana=<%=campana%>&campa=<%=campa%>&codcli=<%=cod%>"  width="1600px"  height="1820px" >
 </iframe>  


</body>
</html>