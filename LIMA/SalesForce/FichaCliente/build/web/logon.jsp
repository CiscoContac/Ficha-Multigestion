<%-- 
    Document   : login
    Created on : 01/02/2014, 03:36:26 PM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoRascal2FactoryImpl"%>
<%@page import="com.pe.backus.factory.CerrarCursor"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src ="js/login.js"> </script> 
        
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <title>Login</title>
    </head>
    <body>
        <form  name="formulario" id="formulario">
  
   

      
      <%
    
   String numcli=request.getParameter("Account_Number");
   System.out.println("Account_Number================>"+numcli);
   String campanita=request.getParameter("CAMPAIGN"); 
   String campana= "CAMP_"+campanita;
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
Connection   cn_rascalCopia= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
  if(numcli==null || numcli=="" ){
      
  }else{

      // out.println("Hoal"); 
       
      String sesAnexo=(String)session.getAttribute("sessionAnexo");
     System.out.println("sessionanexo=============>"+sesAnexo);
      String cortanexo= sesAnexo.substring(2);
     System.out.println("anexooooooo=======>"+cortanexo );
     /////
sqlImplements.execProcedureTel(campana,numcli,"1"+cortanexo, cn_rascalCopia);   

  }
   %>     

</form>
    </body>
</html>
