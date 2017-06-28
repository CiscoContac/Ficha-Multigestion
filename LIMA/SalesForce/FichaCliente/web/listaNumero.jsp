<%-- 
    Document   : detalleLlamada
    Created on : 03/01/2014, 02:51:35 PM
    Author     : GMD
--%>

<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
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
    <script   language="javascript">
function clicktocall(valorr) {
   // alert(valorr);
if(valorr==null){
   /// alert("nullclicttocall");
}else{   
   // desbotones(size);
  
f5 = document.forms[0];  

//alert(f5);
document.getElementById('div1').style.display = 'none'; 
document.getElementById('telefonoSelect').value=valorr;
//alert("condata1");
document.getElementById('accionHTML').value = 'llamadaManual';
f5.action = 'ServletDetallado';
f5.method = 'POST';
var campaña= f5.campa.value;
var codcliente=f5.codCliente.value;
var campa=f5.campaign.value;
var valor="valor";

//top.framedetalla.document.location.href="index.jsp?validacion=valor&campana="+campaña.toString()+"&campa="+campa.toString();   
///top.framecabecera.document.location.href="cabecera.jsp?campa="+campa.toString();    
//window.open("http://10.165.70.246:8080/FMSalesForce/Informacion_Cliente.jsp?campana="+campaña.toString()+"&valor="+valor+"&codcli="+codcliente,"infomacion");

//alert("CAMPAÑA DE LISTANUMERO"+campaña);

f5.submit();

 }

 }
 
   function  fonavi(){
       f5 = document.forms[0]; 
   var campaña= f5.campa.value;
var codcliente=document.getElementById('codCliente').value;

var campa=f5.campaign.value;
    //document.getElementById('tdmensaje').innerHTML='Estas en Llamada';
  top.framenumero.document.location.href="listaNumero.jsp?campana="+campaña.toString()+"&campa="+campa.toString()+"&codcli="+codcliente+"&numerito=valor";
 //alert("Lo hizo");
 
}
 
     function fllamar(){
              f1 = document.forms[0];
               // f1.codCliente.value = valor.value;
                // f1.codCampana.value=valor1.value;
                f1.accionHTML.value = 'Llamar';
                f1.action = 'ServletDetallado';
                f1.method = 'POST';
                //alert("llamarmnuermo");
                               f1.submit();
            
        }
        
    function  soloNumerosvali(e){
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
       </script>

        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <title>DetalleLlamadas</title>
        <style type="text/css">
<!--
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

<body>

        
        
        <%

          String campana = request.getParameter("campana");
          String xcodigo= request.getParameter("codcli");
      ///  out.println("CODIGO DE LISTANUMERO ===>"+xcodigo);
          
           String numerito=  request.getParameter("numerito"); 
          String campa= request.getParameter("campa");
String Drop =  request.getParameter("Drop");
String manual =  request.getParameter("manual");
String valor= request.getParameter("valor");
//out.println("pintada de valor"+  valor);
String contador=  request.getParameter("contador");
String consultor=  request.getParameter("consultor");
 String click =  request.getParameter("click");
  String         llamar =  request.getParameter("llamar");
          
      //CONEXION CON BASE DE DATOS     
  
  
    //Connection connection= oraclefactooriginal.getSQLConextion();
    Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
  Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
  
clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();


  String estadocad=  orasql.estadocad(campa,cn_sql);


        
        %>
        <form>      
  <input type='hidden' id="accionHTML"  name='accionHTML'/>
<input type='hidden' name='codCliente' id="codCliente"  value='<%=xcodigo%>'/>
<input type='hidden' name='campa' value='<%= campana %>'> 
<input type='hidden' name='campaign' value='<%= campa %>'> 
<input type='hidden' id="telefonoSelect" name='telefonoSelect' > 
<input type='hidden' name='manual' id="manual" value='<%=manual%>'> 
<input type='hidden' name='contador' id="contador"  value='<%=contador%>'> 
<input type='hidden' name='consultor'  id="consultor"  value='<%=consultor%>' > 
<input type='hidden' name='consultor'  id="consultor"  value='<%=consultor%>'> 
       
 <%-- MUESTRA LOS NROS DEL CLICK TO CALL  --%>  
       
 
            <%      Integer Id= orasql.obtenerCodigo(campana,cn_rascalLocal);
String codcliente=orasql.codigocliente(Id,cn_rascalLocal);   
xcodigo=codcliente;
//out.println("codigo cliente "+codcliente);
        %>
       
             <input type='hidden' name='codCliente' id="codCliente"  value='<%=xcodigo%>'/>
             <table>
                 <tr>
                 <td>
                     <br>
                  <img src="img/tel1.jpg" width="30" height="30" id="imgtelver"  onclick="fonavi()" style="display: block"/> 
            </td>
            <td>
              <%
      
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
         Connection cn_gmrasca= null;
 
      cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
telefono = orasql.ObtenerTelefonoLista(xcodigo,cn_sql);
Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();

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
  List numero= orasql.ListaNumeroContador(beanClienteFono.getCodCliente().toString(), beanClienteFono.getNro().toString(),cn_gmrasca);
  
        
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
      <%  }}} %>
            </td>
             </tr>
             </table>
</td>
</tr>
</table>
</div>
</form>
        
  
    
</body>
</html>