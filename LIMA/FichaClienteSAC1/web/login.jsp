<%-- 
    Document   : login
    Created on : 01/02/2014, 03:36:26 PM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.factory.sqlDaoFactoryImpl"%>
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
                    <script type="text/javascript">
  if(history.forward(1)){
    location.replace( history.forward(1) );
  }
  
  
  function enviarnumero(){
  
     var campa= locationVars('CAMPAIGN') ;
var campaña ="CAMP_"+campa;
//var codcli= document.getElementById("codnull").value;

var numero = document.getElementById('numero').value;

    window.open("http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?campana="+campaña+"&ANI="+numero+"&campa="+campa,"consultor");
       window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campaña+"&ANI="+numero+"&campa="+campa,"infomacion");
      window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?campana="+campaña+"&ANI="+numero+"&campa="+campa,"resultados");
  
    //window.open("http://10.165.70.249:8084/FichaClienteSAC1/logon.jsp?CAMPAIGN="+campa+"&Account_Number="+codcli,"procedure");
 
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

String numero_entrante= request.getParameter("ANI");
/*
if(numcli==null|| numcli.equals("")  ){
    numero_entrante=null;
    System.out.println("numero");
} */
String cam= "CAMP_"+campanita;
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();

Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection   cn_rascal2= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection  Diario_cn = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection cn_ippc=sqlDaoFactoryImpl.getSQLConextion();
CerrarCursor cerrar = new CerrarCursor();
Integer Id= sqlImplements.obtenerCodigo(cam,cn_rascal2);
String codcliente=sqlImplements.codigocliente(Id,cn_rascal2);
  String codnull="";
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
 <input type='hidden' name='numero' id="numero"  value='<%=numero_entrante%>'>
 <%
if(numcli!=null  ){  
  String estadocad=   sqlImplements.estadocad(campanita,cn_sql);
 
%>

<% if( numcli.equals("")   ){  %>

 <%
   
        
 codnull= sqlImplements.selectCodNulo(campacod, camquery ,cn_ippc);
out.println("el codigo impreso del procedure====>"+codnull+"campacod===>"+campacod+"camquery=====>"+camquery);
   // 
  if (codnull== null || codnull.equals("") || codnull.equals("null") ){
    out.println("codclientee base de datosss  ===>"+codnull);
 }else{
%>

<input type="hidden" name="codnull" id="codnull" value="<%=codnull%>" >

<script language="javascript">
/////alert("Presionar Boton Enviar CodCliente");

enviarcodnull();
</script>

<%}
  }
  
  else{
      
     if(estadocad.equals("Preparado")){
   
  }else{
       String estado="Preparado"; sqlImplements.insertarestador( campanita,  anexo, "no hay", estado,cn_sql);
    %>
 <script language="javascript">
  /// soloprepa();
</script>   
 <%
  }

%> 
<script language="javascript">   

var campa= locationVars('CAMPAIGN') ;
var codcli= locationVars('Account_Number');
var campaña ="CAMP_"+campa;  
var valor = "valor";

window.open("http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?campana="+campaña+"&Account_Number="+codcli+"&campa="+campa,"consultor");
 ///alert("valor"+codcli);
//window.open("http://10.165.70.249:8084/FichaClienteSAC1/logon.jsp?CAMPAIGN="+campa+"&Account_Number="+codcli,"procedure");
 


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
  /// soloprepa();
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
     session.setAttribute("TipoGestion", "Manual");
         session.removeAttribute("GestionEntrante");
         String estado = "NoPreparado";
         sqlImplements.insertarestador(campanita, anexo, "no hay", estado, cn_sql);
  
  
%>  
<script language="javascript">
    //alert("Inicio No preparado");
 sinclicktocall();
 </script>
<%}else if(estadocad.equals("Preparado")){  
    session.setAttribute("TipoGestion", "Manual");
         session.removeAttribute("GestionEntrante");
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
 session.removeAttribute("GestionEntrante");
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
String estado=   sqlImplements.estadocad(campanita,cn_sql);
 String Tipo="";


///System.out.println("numero_entrante ====>"+numero_entrante+"numcli====>"+numcli);



  String valor="";
 if (numero_entrante !=null ){
       valor=  numero_entrante.substring(0,1);

 }
 
 if (numero_entrante == null){
  
     }else
if(valor.equals("8")  ){
    
     Tipo = "Archivo Plano";
     
         session.removeAttribute("GestionEntrante");
         session.setAttribute("TipoGestion", Tipo);
         int id_llamada = 0;
         ////String numeroAP=sqlImplements.numeroAPSAC(numcli, cn_ippc);
         String numeroAP = "";
         sqlImplements.InsertClienteIdentificadorSAC(Tipo, id_llamada, numeroAP, cam, Diario_cn);
         Connection cn_rascalCopia = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
         sqlImplements.execProcedureTel(cam, numcli, cn_rascalCopia);
         cn_rascalCopia.close();
    
}else {
    
        
            Tipo = "Entrante";
        session.removeAttribute("GestionEntrante");
        session.setAttribute("TipoGestion", Tipo);

        int id_llamada = sqlImplements.LlamadaSAC(Diario_cn);
        if (id_llamada == 0) {
            id_llamada++;
        } else {

            id_llamada++;

        }
        sqlImplements.InsertClienteIdentificadorSAC(Tipo, id_llamada, numero_entrante, cam, Diario_cn);
   
      
    
    %>
    <script language="javascript">
     
       enviarnumero(); 
      
        </script>
<%
}
    
   




cerrar.cerrar(cn_sql);
cerrar.cerrar(Diario_cn);



%>

</form>
    </body>
</html>