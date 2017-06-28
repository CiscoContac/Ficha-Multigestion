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
        function valorllega(){
    
   
       f1 = document.forms[0];
        var codigo=   f1.codigo.value ;
    var campaign= f1.campaign.value;
///alert(campaign);
 var numerox= document.getElementById('numeroentrante').value;
var campa=  f1.campa.value;
var txtpara= document.getElementById('txtparametro').value; 
///alert("txtpara"+txtpara);
var txtvalor= document.getElementById('txtvalor').value; 
    window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campa.toString()+"&campa="+campaign+"&codcli="+codigo,"infomacion");
  window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?codcli="+codigo+"&ANI="+numerox+"&campana="+campa+"&campa="+campaign,"resultados");
 
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
     
      

  #divnumero{
             
   overflow:scroll;
    width:250px ;
    height: 80px   
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

    
      
</style>
</head>
  
  <body>
       <% String Identificador ;  
       String ConsulCodcli = request.getParameter("Account_Number");
           String campa = request.getParameter("campana");//campaña de agente
           String capaign = request.getParameter("campa");//c
           String manual = request.getParameter("manual");
           String consultor = request.getParameter("consultor");
           String refere = request.getParameter("refere");
           String numerito = request.getParameter("numerito");
           String graba = request.getParameter("graba");
           String parametro = request.getParameter("parametro");
           String valor = request.getParameter("valor");
           String numero_entrante = request.getParameter("ANI");
           String comparacodigo = request.getParameter("comparacodigo");
           String numeroancla = request.getParameter("numeroancla");
           String filtro = request.getParameter("filtro");
           String where = request.getParameter("where2");
           String varRuc=request.getParameter("varRuc");if(varRuc==null){varRuc="";}
           String varDNI=request.getParameter("varDNI");
           String gestion= (String)request.getParameter("GestionEntrante");
           String llega = request.getParameter("llega");
           
       
           
           if(varDNI==null){
           varDNI="";
           }
           String varNombre=request.getParameter("varNombre");
           

        
  
  if(filtro==null){
            filtro="";
        }
      if(comparacodigo==null){comparacodigo="";}
      /// System.out.println("comparar2222222222222222222222222222222222222222222 "+comparacodigo);
//conexion a oracle 
//Connection connection = oracleDaoLocalFactoryImpl.getSQLConextion();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();


  Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();
Connection  Diario_cn = sqlDaoRascalFactoryImpl.getSQLConextionRascal();


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
 
       int varfor;
          clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
           clienteSqlDaoImpl     sqlCliente= new clienteSqlDaoImpl();    
        
 %>
  <form name="form1">
        <% out.println("<input type='hidden' name='campa'  id='campa'  value = "+"'"+campa+"'"+"/>");
               %>
               <input type='hidden' name='numeroentrante'  id='numeroentrante'  value ="<%=numero_entrante%>" />
               
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
    </div></td>
  </tr>
</table>
      <br>
      
    <table width="1592" border="0">
  <tr >
<td width="990" height="365" valign="top"><table width="960" height="98" border="0" cellspacing="0">
          <tr>
            <td width="415" height="45" valign="top" >
              <input type="hidden" name="actionResul">
              <input type="hidden" name="acciondos">
              <input type="hidden" name="Modifica" id="Modifica">
              <input type="hidden" name="manual" id="manual" value="<%=manual%>">
              <input type="hidden" name="id" id="id">
              <input type="hidden" name="consultor" id="consultor" value="<%=consultor%>">
              <input type='hidden' name='campaign' id='campaign'  value="<%=capaign%>" >
              <input TYPE="hidden" name="grabacioncontador" id="grabacioncontador">
              <% String estadocad=  sqlCliente.estadocad(capaign,cn_sql);
             %>
             <br>
                <%
       try  {
             
           String xcodigo; 
           String codprinc   = (String) request.getParameter ("codCliente");   
            /*valor de la llamada en manual*/
            
             xcodigo  =request.getParameter("txtcodigo");

             
             ////////alert("Sytem ")
              
      if (xcodigo == null){
          xcodigo="";
           if (codprinc != null  ){
              xcodigo= codprinc.trim();
         out.println("<input type='hidden' name='codCliente'  id='codCliente' value="  + "'"+xcodigo+"'"+   " />");        
           
 } 
           if(ConsulCodcli != null ){
               xcodigo=ConsulCodcli.trim();
             out.println("<input type='hidden' name='prepcodigo'  id='prepcodigo'  value = "+"'"+xcodigo+"'"+"  />");       
                  
     }
           //  session.setAttribute("codcli", xcodigo);   
      } 
      
    out.println("<input type='hidden' name='clianotacion'  id='clianotacion'  value = "+"'"+xcodigo+"'"+"/>");    

       
Identificador=xcodigo;
%>
             <span class="Estilo4" style="font-weight: bold">B&uacute;squeda por cliente</span>
             <input type="text"   id="country" name="country"  size="50"   />   
               
                <script>
         
        
                    $("#country").autocomplete("getdata.jsp");
                  
                  
                    
              </script>
            </td>
            
            <%    int AOPcont= sqlCliente.SelectClienteAOP(xcodigo, Diario_cn); 
               if (AOPcont== 0){
             %>
            <td width="25" valign="top">&nbsp;</td>
            <% }else {
                   %>
                   <td width="260" valign="top" style="color: red"><H2>Cliente AOP ¡No Atender!</h2></td>      
               <%}%>
            
            <td width="335" valign="top"><BR>
                <strong>B&uacute;squeda por DNI</strong>
                <input type="text" name="txtDNI" id="txtDNI" maxlength="8"  onKeyPress="return soloNumerosbusqueda(event)">  &nbsp;<input type="button" name="tre" id="tre"  onclick="busqueda('DOCIDENTIDAD','txtDNI')" value="Buscar" >
            </td>
            <td width="120" > <input type="checkbox" name="checkDNI" id="checkDNI">
              <label>Buscar código nuevo</label> </td>
          </tr>
          <tr>
              <td height="53" valign="top"><br><span class="Estilo4" style="font-weight: bold">B&uacute;squeda por c&oacute;digo   </span>
                  <input type="text"  id="txtcodigo" name="txtcodigo"   maxlength="10"  onKeyPress="return soloNumeros(event)" />
                  <input type="button" id="btnbuscar" name="btnbuscar" value="BUSCAR"   onclick="grabar()"  /><% out.println(" "+xcodigo);%>
              
                  
          
               <input type="hidden" name="codigo" id="codigo" value="<%=xcodigo%>">
               <input type="hidden" name="codfiltro" id="codfiltro" >
            <br></td>
            <td>&nbsp;</td>
            <td valign="top"> <BR>
                
              <strong>B&uacute;squeda por RUC</strong>              
              <input type="text" name="txtruc" id="txtruc"   maxlength="11"  onKeyPress="return soloNumerosbusqueda(event)"> <input type="button" name="tre" id="tre" onclick="busqueda('CODIGORUC','txtruc')" value="Buscar">
            </td>
            <td ><input type="checkbox" name="checkRUC" id="checkRUC" ><label>Buscar código nuevo</label></td>
          </tr>
        </table>
     <%
     
   
     if(varRuc.equals("") || varRuc=="null" || varRuc==null ) {
                 
         
               }else{
                     //session.session.setAttribute("GestionEntrante","gestion" );
                       
                         out.println("Nombre: " + varNombre + " - N° Ruc:" + varRuc);

                         session.setAttribute("ClienteAlta", varNombre);
                         session.setAttribute("RUCALTA", varRuc);
                         Identificador = varRuc;
       } if(varDNI.equals("")|| varDNI=="null" || varDNI==null  ){

       }else{
            out.println("Nombre: " + varNombre + "- N° DNI:" + varDNI);
                session.setAttribute("ClienteAlta", varNombre);
                //////session.removeAttribute("GestionEntrante");
                session.setAttribute("DNIALTA", varDNI);
                System.out.println("DNI ALTAAA=========================>" + varDNI);
                Identificador = varDNI;
       }
    
       %>     
       <iframe id="frameSearch"  frameborder="NO" name="frameSearch"    scrolling ="no" src="busquedaFiltro.jsp?ANI=<%=numero_entrante%>&parametro=<%=parametro%>&valor=<%=valor%>&campa=<%=capaign%>&campana=<%=campa%>&comparacodigo=<%=comparacodigo%>&numeroancla=<%=numeroancla%>&filtro=<%=filtro%>&where=<%=where%>"  width="950px"  height="200px"></iframe>
        <input type="hidden" name="txtparametro" id="txtparametro" value ="<%=parametro %>" >
         <input type="hidden" name="txtvalor" id="txtvalor" value ="<%=valor%>">
        
     </td>
    <input type='hidden' id="telefonoSelect" name='telefonoSelect' >
    <td>
        &nbsp;
        <table width="215" height="68" border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td><center>Identificador</center></td>
                <td><center>Intentos</center></td>
            </tr>
            <thead>
              
                <tr>
                    
                    <th width="" height="23" colspan="2" style="background-color: #fdf1d9;">Contador de gestión por cliente</th>

                  
                </tr>
               
            </thead>
            <tbody>
                <%
                String Gestion = (String) session.getAttribute("TipoGestion");
                List listIntentos = sqlCliente.IntentosxClienteSAC(Gestion, Identificador, Diario_cn);%>

              
                    <%
                       if(listIntentos.size()==0){
                           %>
                           <tr>
                           
                               <td>&nbsp;</td>
                               <td>&nbsp;</td> 
                           </tr>
                           <%
                           }else{    
                           %>
                  <tr>            
                <%
                        for (int h = 0; h < listIntentos.size(); h++) {
                    %>


                    <td align="center"><%=listIntentos.get(h)%></td>

                    <%

                        }
                       }
                    %>
                </tr>

            </tbody>
        </table>
    </td>
    
   
                        </tr>
                        
     
   
    <input type="hidden" name="GrabaAnotacion" />   


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
   }if(llega==null || llega.equals("")){
       %>
     
     <%}else{
       %>
   
     <script language="javascript">  
         
    valorllega();
     
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

