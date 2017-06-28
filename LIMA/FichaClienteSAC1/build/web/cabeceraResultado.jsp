<%@page import="com.pe.backus.dto.beanAgendaSAC"%>
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
<script language="javascript">
      function Numerosvali(e){
      //alert("dsss");
        var key = window.Event ? e.which : e.keyCode 
//alert(key);
/*if( key == 13 ){
    buscarXnombre();
}*/
    if(key == 13){
   fllamar();
  //  alert("entro");
    //return;
}else{    
      
return ((key >= 48 && key <= 57) || (key==8)) 
}
    }
    </script>
<style type="text/css">
     #divscroll {
         
   overflow:scroll;
   height:185px;
   width: 250px;
   
      }
       #divnumero{
             
   overflow:scroll;
    width:220px;
    height: 60px   
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
    <form id="form1" name="form1"  method="post" action="ServletResuLLamada">
       <%
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();

 // Connection cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
///Connection connection= oraclefactooriginal.getSQLConextion();
 Connection sqllocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal() ;
//Connection resucn = sqlresultadoConexion.getSQLConextion();

 String numerito=  request.getParameter("numerito"); 
String codcli = request.getParameter("codcli"); 
String  campana = request.getParameter("campana"); 
String campa = request.getParameter("campa");
String Graba= request.getParameter("Graba");

String Contacto = request.getParameter("contacto");
   DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
  String estadocad=  sqlImplements.estadocad(campa,cn_sql);
  
if(Graba!= null){
          %>
          
        <body onload="redireccionar()">   
          
          
<%
      }

%>
       
  <br>
   <div  id="div10" style="width:650px"></div>     
   <input type="hidden"   id="codcli" name="codcli" value="<%=codcli%>"  />           
   <input type="hidden"   name="campana" value="<%=campana%>"  />
   <input type="hidden" id="campa"   name="campa" value="<%=campa%>"  />
   <input type="hidden"   name="accionResul"  id ="accionResul"/>
   
   <input type ="hidden"  name="idactualizado"  id ="idactualizado" />
   <input type ="hidden"  name="valorcbxrazonllamada"  id ="valorcbxrazonllamada" />
   <input type ="hidden"  name="valorcbxnocerveza"  id ="valorcbxnocerveza" />
   <input type ="hidden"  name="valorcbxnogaseosas"  id ="valorcbxnogaseosas" />
   <input type ="hidden"  name="valorcbxnoagua"  id ="valorcbxnoagua" />
   <input type ="hidden"  name="valorcbxnomalta"   id ="valorcbxnomalta" />
   <input type ="hidden"  name="valoradio"/>
   <input type ="hidden"  name="valorrbcerveza" id="valorrbcerveza" />
   <input type ="hidden"  name="valorrbgaseosa" id ="valorrbgaseosa" >
   <input type ="hidden"  name="valorrbagua"  id ="valorrbagua">
   <input type ="hidden"  name="valorrbmalta"  id ="valorrbmalta">
   <input type ="hidden"  name="llamada"  id ="llamada" />
   <input type ="hidden"  name="norespondio"  id ="norespondio" />
    <input type ="hidden"  name="realizventa"  id ="realizventa" />
     <input type ="hidden"  name="descripventa"  id ="descripventa" />
      <input type ="hidden"  name="noventacer"  id ="noventacer" />
       <input type ="hidden"  name="noventagase"  id ="noventagase" />
        <input type ="hidden"  name="noventaagua"  id ="noventaagua" />
         <input type ="hidden"  name="nomalta"  id ="nomalta" />
          <input type ="hidden"  name="nocategoria"  id ="nocategoria" />
           <input type='hidden' id="telefonoSelect" name='telefonoSelect' > 
          
<input type ="hidden"  name="valortipogestion"     id ="valortipogestion" />  
          
     <input type ="hidden"  name="codmodifi"  id ="codmodifi" />    
            <table width="1500" border="0">
            <tr>
              <td width="49"><div id="u298" class="u298_container"   >
<div id="u298_img" >
<img src="img/u2_normal.jpg"  class="raw_image"></div>
<div id="u299" class="u299" style="visibility:hidden;"  >
<div id="u299_rtf"></div>
</div>
</div></td>
                <td width="490">

                    
                  <div id="u302" class="u302_container"   >
<div id="u302_img" >
<img src="img/u4_normal.jpg"  class="raw_image"></div>
<div id="u303" class="u303" style="visibility:hidden;"  >
<div id="u303_rtf"></div>
</div>
</div></td>
<td width="1000" align="right" style ="width: 1000px"><center><div align="right" id="u300" class="u300_container"   >
<div id="u300_img" >
<img src="img/u0_normal.jpg"  class="raw_image"></div>
<div id="u301"  style="visibility:hidden;"  >
<div id="u301_rtf"></div>
</div>
              </div></center></td>
            </tr>
          </table>
<p style="font-size: smaller"></p>
    

     <table width="1647" border="0">
       <tr>
         <td colspan="2" ><%out.println("<p style='color:#FF0000;font-size: smaller'><strong>Nombre de Contacto: "  +  Contacto +"</strong> </p> ");%></td>
       </tr>
       
           
       <tr>
         <td width="30" ><img src="img/tel1.jpg" alt="" width="30" height="30" id="imgtelver" style="display: block"  onclick="fonavi()"/></td>
         <td width="563" valign="top">  <%
      
        if (numerito != null ){
     
        if(estadocad.equals("Preparado") ||  estadocad.equals("clicktocall")  ){
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
         Connection cn_gmrasca=null;
 
      cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal() ;
telefono = sqlImplements.ObtenerTelefonoLista(codcli,cn_sql);
Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();
 /////Connection sql_local= sqlDaoRascalFactoryImpl.getSQLConextionRascal() ;
 
 ListaParentesco = oraCliente.ObtenerTelefonoParentesco(codcli,cnNC);
cnNC.close();
//beanTelefonoParentesco   beanTelefonoParentesco;  

   
  for (int j = 0; j < telefono.size(); j++) {
  beanClienteFono = (beanTelefonoClienteLista) telefono.get(j);}
  ///out.println(xcodigo);
  //out.println(estadocad);
if(estadocad.equals("Inicia manual con cliente")||estadocad.equals("Fin de Manual") || estadocad.equals("NoPreparado") ||estadocad.equals("Inicia manual sin cliente")  ){  
 
      %>
      <div  id="div10" style="width:580 px ">
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
                  <center>
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
  List numero= sqlImplements.ListaNumeroContador(beanClienteFono.getCodCliente().toString(), beanClienteFono.getNro().toString(),cn_gmrasca);
  
        
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
            <td width="297" valign="top"><%if(ListaParentesco.size()!=0){%>
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
      <td width="15">&nbsp;</td>
      <td width="">
          <% List<beanAgendaSAC> listaagenda=   sqlImplements.obtenerListaAgenda(campana, sqllocal );
            beanAgendaSAC beanlistagenda=null;
          if(listaagenda .size()==0 ){
              
              %>
              <label><strong>Agenda</strong></label>
              <div style="padding-right: 500px;">
          <table border="1" width="708" cellpadding="0" cellspacing="0">
              <thead style="font-weight: bold; background-color: #fdf1d9; border-bottom: none;">
              <th width="95">Tipo identificador</th>
              <th width="95">Código identificador</th>   
              <th width="72">Teléfono Fijo 1</th>    
              <th width="72">Teléfono Fijo 2</th>    
              <th width="61">Celular 1</th>   
              <th width="61">Celular 2</th>   
              <th width="91">Fecha programada</th>   
              <th width="91">Fecha Agendada</th>
         </thead>
          <tbody>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
                 <td>&nbsp;</td>           
          </tbody>
          </table>
             </div>
          <%
              }else{
          
        

          %>
          <label><strong>Agenda</strong></label>
           <div style="padding-right: 500px;">
          <table width="700" border="1" cellpadding="0" cellspacing="0">
              <thead style="font-weight: bold; background-color: #fdf1d9; border-bottom: none;">
              <th width="80">Tipo identificador</th>
              <th width="100">Código identificador</th>   
              <th width="80">Teléfono Fijo 1</th>    
              <th width="80">Teléfono Fijo 2</th>    
              <th width="80">Celular 1</th>   
              <th width="80">Celular 2</th>   
              <th width="80">Fecha programada</th>   
              <th width="80">Fecha Agendada</th>


          </thead>
       
          <tbody>
              <% for (int j = 0; j < listaagenda.size(); j++) {
                      beanlistagenda = (beanAgendaSAC) listaagenda.get(j);

                      if (beanlistagenda.getTipoIdentificador() == null || beanlistagenda.getTipoIdentificador().equals("")) {

                          beanlistagenda.setTipoIdentificador("&nbsp;");
                      }
                      if (beanlistagenda.getCodigoIdentificador() == null || beanlistagenda.getCodigoIdentificador().equals("")) {
                          beanlistagenda.setCodigoIdentificador("&nbsp;");

                      }
                     
                      if (beanlistagenda.getFecha_insertada() == null || beanlistagenda.getFecha_insertada().equals("")) {
                          beanlistagenda.setFecha_insertada("&nbsp;");
                      }
                      if (beanlistagenda.getFecha_agendado() == null || beanlistagenda.getFecha_agendado().equals("")) {
                          beanlistagenda.setFecha_agendado("&nbsp;");
                      }
            
            
              %>
                  <tr>
                      <td><%=beanlistagenda.getTipoIdentificador()%></td>   
                      <td><%=beanlistagenda.getCodigoIdentificador()%></td> 
                      <%
                       if (beanlistagenda.getTelf_Fijo1() == null || beanlistagenda.getTelf_Fijo1().equals("")) {%>
                        <td>&nbsp;</td>  
                      
                     <%  }else{
                     %> 
                        <td>   9<%=beanlistagenda.getTelf_Fijo1()%>   </td>  
                     
                        <%}
                      
                      if (beanlistagenda.getTelf_Fijo2() == null || beanlistagenda.getTelf_Fijo2().equals("")) {%>

                          <td>&nbsp;</td>  
                     <% }else{
                          %>
                       <td>  9<%=beanlistagenda.getTelf_Fijo2()%> </td>  
                          <%}
                      if (beanlistagenda.getCelular1() == null || beanlistagenda.getCelular1().equals("")) {%>
                         <td>&nbsp;</td>  
                          <%
                      }else{
                          %>
                           <td> 9<%=beanlistagenda.getCelular1()%> </td>   
                          <%
                      }
                      if (beanlistagenda.getCelular2() == null || beanlistagenda.getCelular2().equals("")) {%>
                          <td>&nbsp;</td>  
                   <%   }else{
                          %>
                        <td> 9<%=beanlistagenda.getCelular2()%> </td>
                          <%
                          }
                      %>
                     
                      <td><%=beanlistagenda.getFecha_insertada()%></td>   
                      <td><%=beanlistagenda.getFecha_agendado()%></td>  
                  </tr>   
                  
              <%
              }%>
              
              
              
          </tbody>
              
          </table>
           </div>
          <% } %>
      </td>
       </tr>
     </table>
</body>
 </form>