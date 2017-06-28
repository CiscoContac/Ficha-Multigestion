<%-- 
    Document   : detalleLlamada
    Created on : 03/01/2014, 02:51:35 PM
    Author     : GMD
--%>

<%@page import="com.pe.backus.dto.beanResumenCamp"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="com.pe.backus.factory.sqlDaoRascal2FactoryImpl"%>
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

top.framedetalla.document.location.href="index.jsp?validacion=valor&campana="+campaña.toString()+"&campa="+campa.toString();   
top.framecabecera.document.location.href="cabecera.jsp?campa="+campa.toString();    
//window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campaña.toString()+"&valor="+valor+"&codcli="+codcliente,"infomacion");



f5.submit();

 }

 }
 
   function  fonavi(){
       f5 = document.forms[0]; 
   var campaña= f5.campa.value;
var codcliente=f5.codCliente.value;

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
  width:250px;
    height: 80px   
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
         // out.println(xcodigo);
          
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
   
  Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
    Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection   cn_rascal= sqlDaoRascal2FactoryImpl.getSQLConextionRascal();
 /// Connection   cn_rascal2= sqlDaoRascal2FactoryImpl.getSQLConextionRascal();

  
clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();


        

  String estadocad=  orasql.estadocad(campa,cn_sql);

       

 SimpleDateFormat formateador = new SimpleDateFormat("dd' de 'MMMM' 'yyyy' 'HH':'mm':'ss");
       Date fechaDate = new Date();
        String fecha=formateador.format(fechaDate);
        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
        DecimalFormat formatnumero = new DecimalFormat("###,###.##",simbolo);
        
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
             <table width="694" border="0">
                 <tr>
                 <td width="87">
               
            </td>
            <td width="650">
          
            </td>
           
             </tr>
             </table>

<div style="padding-right:800px;">
<table align="center" border="1" cellpadding="0" cellspacing="0" width="600" style="font-family: 'Trebuchet MS'; font-size: 12px;">
<tr style="font-weight: bold; background-color: #fdf1d9;">

            <th >
               % Atención
            </th>
            <th>Total TMO Entrada</th>
             <th>% Participación por Agente</th>
             <th>Llamadas Entrantes por Agente</th>
             <th>TMO Entrada por Agente</th>
             <th>Total TMO Saliente</th>
             <th>% Contacto por Agente</th>
             <th>Llamadas Salida por Agente</th>
             <th>TMO Salida por Agente</th>
             
            
            
            
            
             
            
            
            
              </tr>
                <tr>
<% 
        
        Double gestionada=0.00;
        
        List gestion = orasql.CampoSacGestion(xcodigo, cn_rascal);
            List CampoSacTMOSAC = orasql.CampoSacTMOSAC(cn_rascal);
            List CampoSacTMOcam = orasql.CampoSacTMOXCamapana(campa, cn_rascal);
            List CampoSacQLlamadas = orasql.CampoSacQLlamadas(campa, cn_rascal);
            Double contaentrante = orasql.telefonocontacto(campana, cn_rascalLocal);
            List<beanResumenCamp> ResuCamp = orasql.obtieneResumenCamp(campana, cn_rascal);
            beanResumenCamp resu = null;
     
         String TMOsacEntrante = "";
         String TMOsacSalida = "";
         String cantentrante = "";
         String cantsaliente = "";

         String TMOEntranteCam = "";
         String TMOSalienteCam = ""; 
      
           
        Double total=0.00;
          Double voz=0.00;
        
          Double porContacto=0.00;        
        if(CampoSacTMOSAC != null ||  CampoSacTMOSAC.size()!=0){
        for(int j=0;j<CampoSacTMOSAC.size();j++ ){
            
            if(CampoSacTMOSAC.get(j)==null){
                CampoSacTMOSAC.set(j, "0");
            }else{
            
                if(j==0){
                          TMOsacEntrante= CampoSacTMOSAC.get(j).toString();
                 }else{
                          TMOsacSalida=CampoSacTMOSAC.get(j).toString();
            }
        }
        }
        }
     if(CampoSacQLlamadas.size()!=0){    
           for(int h=0;h<CampoSacQLlamadas.size();h++ ){
               if(h==0){    
           cantentrante=CampoSacQLlamadas.get(h).toString();
               }else{
                   cantsaliente=CampoSacQLlamadas.get(h).toString();
               }
           } 
           
       }
     
      if(CampoSacTMOcam.size()!=0){ 
          for(int h=0;h<CampoSacTMOcam.size();h++ ){
             
              if(h==0){
                  TMOEntranteCam=CampoSacTMOcam.get(h).toString();
              }else{
                  TMOSalienteCam=CampoSacTMOcam.get(h).toString();
              }
              
              
              
              }
          
       }
      
      
      if(ResuCamp.size()!=0){
          
          resu=(beanResumenCamp)ResuCamp.get(0);
               total=  Double.parseDouble(resu.getTotal_records());
            voz= Double.parseDouble(resu.getVoice());
            porContacto= (voz/ total)* 100;
      }
      
   if(gestion == null || gestion.size()==0  ){   
       %>
  <td> &nbsp; </td> 
       <%
       }else{
   gestionada= (Double)gestion.get(1);
//gestionada = Integer.parseInt(cadevalor);
%>


<td>  <%= formatnumero.format(gestion.get(0))%> %   </td>   


        <%}
   
  if( TMOsacEntrante.equals("") ){
  %>    
 <td> &nbsp; </td> 
  <%   
  }else{
     %> 
   <td> <%=TMOsacEntrante%></td> 
<%
     }
   
   
    if(contaentrante==0){
               %>
               <td>&nbsp;</td>  
               <%
           }else{
             Double telcontac= (contaentrante / gestionada) * 100 ;
               
           
               %>
             <td><%=formatnumero.format(telcontac)%> %</td>  
              <%
               }
           if(cantentrante.equals("")){
            %>    <td>&nbsp;</td>  
              
            <%
           }else{
               %>
               <td><%=cantentrante%></td>  
            <%
           }
        if(TMOEntranteCam.equals("")){
            %>
         <td>&nbsp;</td>  
               <%}else{
            
            %>
          <td><%=TMOEntranteCam%></td>  
            <%
            }
      %>
      
      <%   if(TMOsacSalida.equals("")){
      %>
        <td>&nbsp;</td>  
      <%
      }else{
      %>
     <td><%=TMOsacSalida%></td>    
        
        <%
      }
      %>
      
            <td><%=formatnumero.format(porContacto)%> % </td>    
            
        <%if(cantsaliente.equals("")){
        %>
          <td>&nbsp;</td>    
        
        <%}else{
            %>
            <td><%=cantsaliente%></td>    
          <%
        }    
        if(TMOSalienteCam.equals("")){
            %>
          <td>&nbsp;</td>    
            <%
            }else{
            %>
            <td><%=TMOSalienteCam%></td>    
          <%
           }
        %>
            
            </tr>
</table>
</div>

</form>
        <p>&nbsp;</p>
        
  
    
</body>
</html>