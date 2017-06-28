<%-- 
    Document   : login
    Created on : 01/02/2014, 03:36:26 PM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoRascal2FactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoFactoryImpl"%>
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
                    <script type="text/javascript">
  if(history.forward(1)){
    location.replace( history.forward(1) );
  }
</script>   

    
    </head>
    <body>
        
        <form  name="formulario" id="formulario">
        
<% String login =request.getParameter("LOGIN");
String logout =request.getParameter("LOGOUT");
String anexo =request.getParameter("ANEXO");
if(anexo != null){
session.setAttribute("sessionAnexo", anexo);
}
String preparado=request.getParameter("EST_PREP");
String nopreparado=request.getParameter("EST_NOPREP");
String nopreparadomanual=request.getParameter("NOPREP_MANUAL");
String drop =request.getParameter("Drop");   
String var="";
String campanita=request.getParameter("CAMPAIGN"); ;
String numcli=request.getParameter("Account_Number");
String Setcamapaid= request.getParameter("CampaId");
String Setqueryid= request.getParameter("QueryId");
String cam= "CAMP_"+campanita;
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection   cn_rascal2= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();
CerrarCursor cerrar = new CerrarCursor();
Integer Id= sqlImplements.obtenerCodigo(cam,cn_rascal2);
String codcliente=sqlImplements.codigocliente(Id,cn_rascal2);
 String  campacod;
String camquery;
if (Setcamapaid == null ||   Setcamapaid ==""  ){
    
    campacod =   sqlImplements.ListIdCamap(campanita, 1, cn_rascal2);
    
session.setAttribute("CampaId", campacod);

 }else{
   campacod=  Setcamapaid;
 }
 if (Setqueryid == null ||   Setqueryid ==""  ){
 
  camquery=   sqlImplements.ListIdCamap(campanita, 2, cn_rascal2);
 session.setAttribute("QueryId", camquery);
 } else{
     camquery=Setqueryid;
 }


%>

 <input type='hidden' name='codcli' value='<%=codcliente%>'> 
 
 <%
if(numcli!=null  ){  
  String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
 
%>

<% if( numcli.equals("")){  %>

 <%
   
        
    String codnull = sqlImplements.selectCodNulo(campacod, camquery ,cn_ippc);
System.out.println("el codigo impreso del procedure====>"+codnull);
   // 
 ////// if (codnull== null || codnull.equals("") || codnull.equals("null") ){
      /////out.println("codclientee   ===>"+codnull);
 ////}else{
%>

<input type="hidden" name="codnull" id="codnull" value="<%=codnull%>">

<script language="javascript">
//alert("Presionar Boton Enviar CodCliente");
enviarcodnull();
</script>

<%///// }
  }
  
  else{
      
     if(estadocad.equals("Preparado")){
   
  }else{
       String estado="Preparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
    %>
 <script language="javascript">
   soloprepa();
</script>   
 <%
  }

%> 
<script language="javascript">   

var campa= locationVars('CAMPAIGN') ;
var codcli= locationVars('Account_Number');
var campaña ="CAMP_"+campa;  
var valor = "valor";

window.open("http://10.165.70.246:8080/FichaCliente/CONSULTOR2.jsp?campana="+campaña+"&Account_Number="+codcli+"&campa="+campa,"consultor");
 
//window.open("http://10.165.70.246:8080/FichaCliente/logon.jsp?CAMPAIGN="+campa+"&Account_Number="+codcli,"procedure");
 


</script> 
<%
}
%> 

<%}else if(campanita!=null && anexo!=null && login!=null){ String estado="Login"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql); %>

<%}else if(campanita!=null && anexo!=null && preparado!=null){
String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
%>



<%
if(estadocad.equals("Inicia manual sin cliente") || estadocad.equals("Inicia manual con cliente")   ){
//String estado="Fin de Manual"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
}
  if(estadocad.equals("Preparado")){
  }else{
     String estado="Preparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
   %>
  <script language="javascript">
   soloprepa();
</script>
   <%
  }
%>

<%}else if(campanita!=null && anexo!=null && nopreparado!=null){
String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
out.print("estado anterior :"+estadocad); 
// String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado);
%>
<%if(estadocad.equals("Login")){ 
  String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
  
  
%>  
<script language="javascript">
    //alert("Inicio No preparado");
 sinclicktocall();
 </script>
<%}else if(estadocad.equals("Preparado")){  
  String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
  %>
<script language="javascript">
//alert("Inicia manual sin cliente");
sincliente();
</script>  
 
<%}else if(estadocad.equals("Error Agente")){   %>   
<script language="javascript">
//alert("Inicia manual sin cliente");
sincliente();
</script>
<%   //String estado="NoPreparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado);
  String  estado="Inicia manual sin cliente"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql); %>
<%}else if(estadocad.equals("clicktocall")){   
String estado="Fin de Manual"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
%>   
<%}else if(estadocad.equals("Inicia manual sin cliente")){   %>  
<%}else {%>


<%}%>

<%}else if(campanita!=null && anexo!=null  && nopreparadomanual!=null){
String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
out.print("estado anterior :"+estadocad);  %>
<% if(estadocad.equals("Preparado")){ 
String estado="NoPreparadoM"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql) ;
String error="Error Agente";
sqlImplements.insertarestador( campanita,  anexo, "no hay",error,cn_sql);  %>

<%}else if(estadocad.equals("Inicia manual con cliente")){   %>  

<script language="javascript">
concliente();
</script>


<%}else if(estadocad.equals("Inicia manual sin cliente")){   %>  
<%}else if(estadocad.equals("Fin de Manual")){  
   String estado="Inicia manual con cliente"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);%>   
<script language="javascript">
concliente();
</script>
<%} else if(estadocad.equals("NoPreparado")) {%>
<script language="javascript">
sincliente();
</script>
<%  String estado="Inicia manual sin cliente"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql) ;  %>
<% } %>

<%}else if(campanita!=null && anexo!=null && logout!=null){  String estado="Logout"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);           %>
<script language="javascript">
sinclicktocall();
</script>
<%}else{    }
cerrar.cerrar(cn_sql);
%>

</form>
    </body>
</html>
