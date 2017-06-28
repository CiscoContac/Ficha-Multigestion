<%--  
    Document   : CONSULTOR
    Created on : 27/11/2013, 02:31:24 PM
    Author     : GMD
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.pe.backus.factory.sqlDaoFactoryImpl"%>
<%@page import="com.pe.backus.dto.beanDetalladoCliente"%>
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
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
    <title>Información General</title>
    <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
    <script src="js/consultor.js">
    </script>
    <script language="javascript">
         function  solovali(e){
        var key = window.Event ? e.which : e.keyCode 
//alert(key);
/*if( key == 13 ){
    buscarXnombre();
}*/
    if(key == 13){
   fllamar();
   //alert("entro");
    //return;
}else{    
      
return ((key >= 48 && key <= 57) || (key==8)) 
}
    }
     function fllamar(){
              ///alert("ddd");
              f1 = document.forms[0];
               // f1.codCliente.value = valor.value;¿
               var campaign= f1.campaign.value;
                var campa=  f1.campa.value;
                 var xcodigo = f1.codigo.value;
                 var numero = f1.numerox.value;
         
           top.consutorcabecera.document.location.href="frameconsultor1.jsp?campa="+campaign+"&campana="+campa+"&txtcodigo="+xcodigo+"&numeroclicktocholl=9"+numero+"&numerito=valor";
            
        }
        
    </script>
<link rel="stylesheet" type="text/css" href="styles/jquery.autocomplete.css" >       
	<script src="js/jquery.js"></script>
	<script src="js/jquery.autocomplete.js"></script>
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
      #divscroll{
       overflow:scroll;
       height:80px;   
      } 
 #div6 table {
   width:60px;
   background-color:lightgray;

}
  #divnumero{
             
   overflow:scroll;
    width:220px ;
    height: 60px   
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
<style type="text/css">
     #divscroll {
         
   overflow:scroll;
   height:185px;
   width: 200px;
   
      }
          #divcomenta{
             
   overflow:scroll;
    width:200px ;
    height: 40px   
      }
      
      
      #mensaje {
    position:absolute;
    left:420px;

    top:4px;
    width:500px;
    height:30px;
   
}
</style>
</head>
  
  <body>
       <%   
       String ConsulCodcli= request.getParameter("Account_Number");
       String  campa  =  request.getParameter("campana");//campaña de agente
       String capaign=  request.getParameter("campa");//c
       String manual = request.getParameter("manual");
       String consultor= request.getParameter("consultor");
      String refere=  request.getParameter("refere");
    String numerito=  request.getParameter("numerito");
       String graba =request.getParameter("graba");
       String actualiza= request.getParameter("actualiza");
    String pet = request.getParameter("PET");
        String xcodigo; 
           String codprinc   = (String) request.getParameter ("codCliente");   
            /*valor de la llamada en manual*/
            
             xcodigo  =request.getParameter("txtcodigo");

  if (xcodigo == null){
       xcodigo="";
           if (codprinc != null  ){
              xcodigo= codprinc.trim();}
           
           if(ConsulCodcli != null ){
               xcodigo=ConsulCodcli.trim();}
           
  }
             
             
             
            
       if(pet==null){
           pet = (String)session.getAttribute("PETVALOR"); 
       }
  String destroy = request.getParameter("DESTROY");
 
Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();


  Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();
 Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();


 Calendar calendario = new GregorianCalendar();
int hora, minutos, segundos;

hora =calendario.get(Calendar.HOUR_OF_DAY);

 
       if (graba==null)
       {
       graba="0";
       }
       
       session.setAttribute("campana", campa);
      
             
        if(refere != null){
      
%> 
  
    <body onload="redireccionar()">
      
        
<%
      }
 
       String  varfor;
          clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
           clienteSqlDaoImpl     sqlCliente= new clienteSqlDaoImpl();    
          varfor=   sqlCliente.AGENDAMIENTOVALIDAR(xcodigo, cn_rascalLocal);
      
    System.out.println("AGENDAMIENTOVALIDAR===================>"+varfor);
 %>
  <form name="form1">
        <% out.println("<input type='hidden' name='campa'  id='campa'  value = "+"'"+campa+"'"+"/>");
               %>
<table width="6700" border="0">
  <tr>
    <td width="33"><div id="u298" class="u298_container"   >
      <div id="u298_img" > <img src="img/u2_normal.jpg"  class="raw_image"></div>
      <div id="u299" class="u299" style="visibility:hidden;"  >
        <div id="u299_rtf"></div>
      </div>
    </div></td>
    <td width="1063"><div id="u302" class="u302_container"   >
      <div id="u302_img" > <img src="img/u4_normal.jpg"  class="raw_image"></div>
      <div id="u303" class="u303" style="visibility:hidden;"  >
        <div id="u303_rtf"></div>
      </div>
    </div></td>
    <td width="650px"><div id="u300" class="u300_container"   >
      <div id="u300_img"  align="center"> <img src="img/u0_normal.jpg"  class="raw_image"></div>
      <div id="u301" class="u301" style="visibility:hidden;"  >
        <div id="u301_rtf"></div>
      </div>
    </div>
    <%if(varfor==null ||varfor=="" ){ }else{%>
        
     <div id="mensaje" >
         <h2 style="color: red">CLIENTE AGENDADO ==> <%=varfor%> </h2>
  </div>
        <%
        
}%>
    
    </td>
  </tr>
</table>
<br>
<br>
<table width="1346"  border="0">
  <tr >
<td width="358" valign="top">
   
    
   
        <input type="hidden" name="actionResul">
        <input type="hidden" name="acciondos">
        <input type="hidden" name="Modifica" id="Modifica">
        <input type="hidden" name="manual" id="manual" value="<%=manual%>">
        <input type="hidden" name="id" id="id">
        <input type="hidden" name="consultor" id="consultor" value="<%=consultor%>">
        <input type='hidden' name='campaign' id='campaign'  value="<%=capaign%>" >
        <input TYPE="hidden" name="grabacioncontador" id="grabacioncontador">
        
        
        <% String estadocad=  sqlCliente.estadocad(capaign,cn_sql);
               
         if(estadocad.equals("Preparado")){
             %>
        <%--<strong> Código de Cliente<font size="3">: </font></strong>--%>
        
        
        <strong> Busqueda por cliente</strong> 
        <input type="text" id="country" name="country" disabled="true" size="50"  /> 
        
        <script>
                    $("#country").autocomplete("getdata.jsp");
        </script>
        
        
        <br>
        <br>
        <strong> Busqueda por código   </strong> 
        <input type="text"  id="txtcodigo" name="txtcodigo"   disabled="true"   maxlength="10"  onKeyPress="return soloNumeros(event)"/>
        <input type="button" id="btnbuscar" name="btnbuscar" value="BUSCAR"   disabled="true" style="width: 70px"  onclick="grabar()"  /> 
        <br> 
        
        <%
         }else{
        %>
        
        <span class="Estilo4" style="font-weight: bold" >Búsqueda por cliente</span>
        <input type="text"   id="country" name="country" size="50"    />
        <script>
         
        
                    $("#country").autocomplete("getdata.jsp");
                  
                  
                    
            </script>
        <br>
        <br>
        
        <span class="Estilo4" style="font-weight: bold"> Búsqueda por c&oacute;digo </span>
        <br>
        
        <input type="text"  id="txtcodigo" name="txtcodigo"   maxlength="10"  onKeyPress="return soloNumeros(event)" />
        <input type="button" id="btnbuscar" name="btnbuscar" value="BUSCAR" style="width: 70px" onClick="grabar()"  /> 
        <%}%>
   <%

    SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy' 'HH':'mm':'ss");
       Date fechaDate = new Date();
        String fecha=formateador.format(fechaDate);

        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
        DecimalFormat formatnumero = new DecimalFormat("###,###.##",simbolo);
       try  {
             
     //      String xcodigo; 
         //  String codprinc   = (String) request.getParameter ("codCliente");   
            /*valor de la llamada en manual*/
            
             xcodigo  =request.getParameter("txtcodigo");

 
            
                 /******************************/
      if (xcodigo == null){
          xcodigo="";
           if (codprinc != null  ){
              xcodigo= codprinc.trim();
         out.println("<input type='hidden' name='codCliente'  id='codCliente' value="  + "'"+xcodigo+"'"+   " />");        
              %>
              
              
      <%
 } 
           if(ConsulCodcli != null ){
               xcodigo=ConsulCodcli.trim();
             out.println("<input type='hidden' name='prepcodigo'  id='prepcodigo'  value = "+"'"+xcodigo+"'"+"  />");       
             %>
       
      <%      
     }
           //  session.setAttribute("codcli", xcodigo);   
      } 
      
    out.println("<input type='hidden' name='clianotacion'  id='clianotacion'  value = "+"'"+xcodigo+"'"+"/>");    
   
   
          
%>     
<BR>
     
<BR>
<%    out.println("Codigo de Cliente:" +xcodigo);%>
</td>
     <%    int AOPcont= sqlCliente.SelectClienteAOP(xcodigo, cn_rascalLocal); 
               if (AOPcont== 0){
             %>
            <td width="25" valign="top">&nbsp;</td>
            <% }else {
                   %>
                   <td width="260" valign="top" style="color: red"><H2>Cliente AOP ¡No Atender!</h2></td>      
               <%}%> 
<td width="150" valign="top">

    <p><span class="Estilo4" style="font-weight: bold">    PET: </span>
        <input type="checkbox" name="chbsolito" id="chbsolito" onClick="fnvalidaPet(this)"/>
      <br>
          <% 
if(destroy!=null){
 ///out.println("llegoooooooo");
  session.removeAttribute("CondicionPet");
    session.removeAttribute("PETVALOR");
    pet=null;
}   

if(pet != null ){ %> 
          <script>
      document.getElementById('chbsolito').checked=true; 
    
        </script>
          <input type="text" id="txtpet" name="txtpet"  size="20"  value="<%=pet%>" />
      
          <%
   
session.setAttribute("PETVALOR", pet);
}else{%>
          <input type="text" id="txtpet" name="txtpet"   disabled="true" size="20"  /> 
      
          <%
}%>
      </p>
      <input type="hidden" id="grabacomentario" name="grabacomentario">
      <input type="hidden" id="comentario" name="comentario">
   
<%--
<table width="289" border="0">
    <tr>
    <td>Comentario agente TV
    </tr>
    <% String txtcomenta=sqlCliente.selectComentario(xcodigo, campa, cn_rascalLocal) ;%>
      <tr>
          <td width="168" ><textarea name ="txtcomentario" disabled="true"    id="txtcomentario"  cols="30" rows="5"><%=txtcomenta%> </textarea>  </td>
        <td colspan="4" >
          
            <img name="agregar" src="img/u11_normal.jpg" id="agregar"  width="20px"  height="20px" onclick="agregacomentario()">
        </td>
        <td width="55" align="left">
            <img name="modificar" src="img/u13_normal.jpg" id="modificar"  width="20px"  height="20px" onclick="modificacomentario()" >
       </td>
      </tr>
    </table>    
   --%>

 
      <script>
                //alert("siii");
                    $("#txtpet").autopet("getpet.jsp");
            </script>     

</td>
     
      <input type="hidden" name="codigo" id="codigo" value="<%=xcodigo%>">
      <input type="hidden" name="codfiltro" id="codfiltro" ><td width="10"></td>
    <input type='hidden' id="telefonoSelect" name='telefonoSelect' > 
    
    <td width="180"   >
         <%
 String contavENTASAC =      sqlCliente.ListaVENTASAC(xcodigo, cn_rascalLocal);
 
      if(contavENTASAC != ""){
          
           System.out.println("ENTROOOOOO "+contavENTASAC);
      %>
      
             <input TYPE="hidden" name="contavENTASAC" id="contavENTASAC"    value="<%=contavENTASAC%>">
      
      
             
             
             <div>
                 
                 <label style="color: red" ><h1>Pedido SAC</h1></label> 
                 
             </div>
            
        <% 
      }
        
        %><img src="img/tel1.jpg" width="30" height="30" id="imgtelver"  onClick="fonavi()" style="display: block"/>    </td>
    <td  valign="top" ><% 
        if (numerito != null ){
        
        if(estadocad.equals("Preparado") ||  estadocad.equals("clicktocall") || ConsulCodcli != null ){
  %>
      <%if (  estadocad.equals("clicktocall") ){%>
      <table>
        <tr>
          <td id="tdtext">Estas en Llamada......</td>
        </tr>
      </table>
      <script>
    
       document.getElementById('imgtelver').style.display='block';
      </script>
      <%}%>
      <%
  }else   {
       beanTelefonoClienteLista beanClienteFono = null;
         List<beanTelefonoClienteLista> telefono = null ;
         List<beanTelefonoParentesco>  ListaParentesco = null;
         beanTelefonoParentesco     parentesco=null;
         Connection cn_gmrasca= null;
 
      cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
telefono = sqlCliente.ObtenerTelefonoLista(xcodigo,cn_sql);


 ListaParentesco = oraCliente.ObtenerTelefonoParentesco(xcodigo,cnNC);
cnNC.close();
//beanTelefonoParentesco   beanTelefonoParentesco;  

   
  for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);}
  ///out.println(xcodigo);
  //out.println(estadocad);
if(estadocad.equals("Inicia manual con cliente")||estadocad.equals("Fin de Manual") || estadocad.equals("NoPreparado") ||estadocad.equals("Inicia manual sin cliente")  ){  
  %>
      <table>
        <tr>
          <%if( beanClienteFono== null &&  beanClienteFono==null ){
          %>
          <td>Clente:</td>
          <td>No existen Datos de t&eacute;lefono</td>
          <%  }else{%>
          <td>Cliente:</td>
          <td><%= beanClienteFono.getNombre()%> <%= beanClienteFono.getApellido()%></td>
          <%}%>
        </tr>
      </table>
      <div  id="div10" style="width:650px">
        <table border="0"    cellspacing="0" cellpadding="0">
          <tr>
            <td width="230"><%if(beanClienteFono==null){%>
              <%}else {%>
          <center>
              <table style ="border-spacing: 0 0; border-collapse: collapse;"  border="0"  cellspacing="0" cellpadding="0">
                    <tr>
                      <td colspan="2" align="center"  >Tel&eacute;fonos del Cliente</td>
                      <td width="48" align="center"><font style="color: red">Cant </td>
                    </tr>
                  </table >
          </center>
              <div id="divnumero" style="  border-style:solid ;  border-width: 1px">
                  <CENTER>
                    <table style ="border-spacing: 0 0; border-collapse: collapse;" border="0"  cellspacing="0" cellpadding="0">
                    <%
 int var=0;
for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);
 
 %>
 <tr>
                      <td width="47"  >Nro<%=j+1%>.-</td>
                      <% //String nro="9"+ beanClienteFono.getNro();%>
                      <td  onclick= 'clicktocall(9<%=beanClienteFono.getNro()%>)'>
                                                          9<%=beanClienteFono.getNro() %>
                    </td>
                      <%  int h;
int z=0;
 String s="" ;
 //aqui va el rascal numero 1 ;
  List numero= sqlCliente.ListaNumeroContador(beanClienteFono.getCodCliente().toString(), beanClienteFono.getNro().toString(),cn_gmrasca);
  
        
%>
                      <%     
        
       
  for( h =0; h<numero.size();h++ ){
      
 
%>
                      <%        
              
             
%>
                      <td width="47"  align="center"><%=numero.get(z) %></td>
                      <%
 z++;
 break;
  }
  %>
                    </tr>
                    <%}
 cn_gmrasca.close();

%>
                    <%
 
for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);
 %>
                    <%}%>
                    <input type='hidden' name='CodClienteDetalle' value='<%=beanClienteFono.getCodCliente()%>'>
                  </table>
                  </center>
              </div>
                  
              <%}%>
              <br>
              <% 

if(beanClienteFono ==null){
}else{
String variable = request.getParameter("numeroclicktocholl");
%>

<div style="  border-style:solid ;  border-width: 1px;width: 222px;height: 84px">
    <center>
    <table  style="border-spacing: 0 0; border-collapse: collapse;" cellspacing="0" cellpadding="0"  height="70" align="left"  border="0">
                  <tr>
                    <td width="128" height="32"> Ingresar N&uacute;mero:
                      <input type="text" id ="numerox" name="numerox" size="21"  maxlength="9" onKeyPress="return solovali(event)" onBlur="verif(this)" ></td>
                    <td width="57"><input type="button" value="Llamar" name="llamar" id="llamar" onClick="fllamar()"></td>
                  </tr>
                  <tr>
                    <td>¿Desea Llamar a este Nro?</td>
                    <%  if(variable==null){ 
                          %>
                    <td>&nbsp;</td>
                    <%
                          }
                          else{%>
                    <td  onclick= 'clicktocall(<%=variable%>)'><%=variable%></td>
                    <%
}%>
                  </tr>
                </table>
    </center>
              </div>

              <%

}
%></td>
            <td width="8"></td>
            <td width="395" valign="top"><%if(ListaParentesco.size()!=0){%>
              <div id="divscroll"   style="border-style:solid ;  border-width: 1px;">
                <center>
                  <table border="0"  cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="25" colspan="2" align="center">Otros Contactos</td>
                    </tr>
                    <% for (int i = 0; i < ListaParentesco.size(); i++) {
parentesco = (beanTelefonoParentesco) ListaParentesco.get(i);
%>
                    <tr>
                      <td width="82"><%=parentesco.getParentesco()%></td>
                      <td style="height: auto"  onclick= 'clicktocall(9<%= parentesco.getNumero()%>)' >9<%=parentesco.getNumero()%></td>
                      <td width="50"></td>
                    </tr>
                    <%}%>
                  </table>
                </center>
              </div>
              <%
}         %></td>
          </tr>
          <tr>
            <td height="2" colspan="3"></td>
          </tr>
        </table>
      </div>
      <%  }}} %></td>
        <td>
       <%    System.out.println("RAMIREZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ===================>"+capaign);
  
List<beanDetalladoCliente> recordar=      sqlCliente.RecordarAgendamiento(capaign, cn_rascalLocal);
        
      beanDetalladoCliente deta =null;

       %>
      
       <table border="1">
           <thead>
               <tr>
                   <th colspan="3" scope="col" bgcolor="#00006C" style="color: #ffffff" >Lista de Agendamientos</th>
                   
               </tr>
               <tr>
                   <th bgcolor="#00006C" style="color: #ffffff"  >Cliente</th>
                   <th bgcolor="#00006C" style="color: #ffffff" >Hora</th>
                   <th bgcolor="#00006C" style="color: #ffffff" >Resultado de Gestión</th>
               </tr>
           </thead>
           <%      if(recordar==null){ %>
           <tr>
               
                <td> </td>
                 <td> </td>
                  <td>  </td>
               
           </tr>
                
             <% }else{  
               
      for (int i = 0; i < recordar.size(); i++) {
          
   deta=(beanDetalladoCliente)    recordar.get(i);
          String sbHora=  deta.getCallback1();
          
          sbHora= sbHora.substring(0, 2);
          System.out.println("SBS HORA"+ sbHora);
          
          
          %>
          
          <tr>
              <td bgcolor="#DBDBDB">  <%=deta.getCodCliente()%></td>
              
              <%     if (hora == Integer.parseInt(sbHora)  ){
              %>
              
              
              <td style="color: #FF0000">  <%=deta.getCallback1() %></td>
              <%
    }else {  %>
                 <td>  <%=deta.getCallback1() %></td>
                 
                <% } %>
                    <td>  <%=deta.getTipo_gestion() %></td>
          </tr>
           <%
      }
        
        
        }

            %> 
          
            
            
        </table> 
       
        
    </td>
     
  </tr>
  </table>
    
        <%  if(ConsulCodcli != null ){
      %>
     
    
  <script language="javascript">   
            // alert("Entro al autoamtico");
           grabaprecod();
             // document.getElementById('prepcodigo').value<%=xcodigo%>;
     </script>
<%
            } if(codprinc !=null){
      %>
      
       <script language="javascript">   
             
                 grabacodcli() ;
                  // document.getElementById('codCliente').value=<%--xcodigo;--%>

     </script>
      <%
   }
            %>


</form>
  
     <%    
         
      }catch(Exception ee){
              out.println(ee.getMessage());
          }
        %>
</body>
</html>

