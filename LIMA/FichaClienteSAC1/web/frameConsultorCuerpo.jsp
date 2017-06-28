

<%@page import="com.pe.backus.dto.beanAlertaPFR"%>
<%@page import="com.pe.backus.dto.beanEntrega"%>
<%@page import="com.pe.backus.dto.beanCargaDistribucion"%>
<%@page import="com.pe.backus.dto.beanInformacionAdicionalBO"%>
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
 
<link rel="stylesheet" type="text/css" href="styles/jquery.autocomplete.css" >       
	<script src="js/jquery.js"></script>
	<script src="js/jquery.autocomplete.js"></script>
        <script src="js/consultor.js" type="text/javascript"></script>
     <META HTTP-EQUIV="Pragma" CONTENT="no-cache" >
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
 #div6 table {
   width:60px;
   background-color:lightgray;

}

     #div40 {
         
   overflow:scroll;
   height:160px;
   width: 970px;
   
      }
     #div43 {
         
   overflow:scroll;
   height:170px;
   width: 670px;
   
      }

 #div41 {
         
   overflow:scroll;
   height:260px;
   width: 384px;
   
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
  
  

  $(window).on('load',function (e){
     var codigo= $("#codigo").val();
    /// alert(codigo);
    tablaDinamica(codigo);
});
  
  function tablaDinamica(codigo){
     var fecha = $("#txtbusFecha").val();
    // alert(fecha);
        $.ajax({
                     url:'servletCliente',
                     type:'post',
                     datatype:'json',
                     data: {actionResul:'ListaProductos',codigocliente:codigo,Fecha:fecha},
                     success:function(data){
                     // alert("esto s"+data);
                        var json = eval('('+data+')');
                           var tbody="";
                
                
                             
                             if(json.length===0){
                             
                         tbody += '<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>';
                         
                         $("#tablaproducto tbody tr").remove();
                        $("#tablaproducto tbody").append(tbody);
                        $("#txtbusFecha").val('');
                         
                             }else{
                        for(var j=0; j< json.length;j++){
                            
                              tbody += '<tr><td>'+json[j].fechaCalendario+'</td><td>'+json[j].descategoria+'</td><td>'+json[j].desmarca+'</td><td>'+json[j].Desenvase+'</td><td>'+json[j].descapacidad+'</td><td>'+json[j].caja+'</td></tr>';
                            
                        }
                    }
                            $("#tablaproducto tbody tr").remove();
                        $("#tablaproducto tbody").append(tbody);
                        $("#txtbusFecha").val('');
                            }
               });
      
  }
</script>  
</head>
  
  <body>
       <%   
       String xcodigo= request.getParameter("xcodigo");
 if (xcodigo == null) {
         xcodigo = "";
     }

     String campa = request.getParameter("campana");//campaña de agente
     String capaign = request.getParameter("campa");//c

     String refere = request.getParameter("refere");

     String graba = request.getParameter("graba");
     String actualiza = request.getParameter("actualiza");
     String numero_entrante = request.getParameter("ANI");
     
     
 System.out.println("numeroentrante ==============================> "+numero_entrante);

 
 
     Connection orasql = oraclefactooriginal.getSQLConextion();//conexion a oracle 
//Connection connection = oracleDaoLocalFactoryImpl.getSQLConextion();
     Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();

     Connection sql_local = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
     Connection cnNC = oracleDaoLocalFactoryImpl.getSQLConextion();

     if (graba == null) {
         graba = "0";
     }

     session.setAttribute("campana", campa);

     if (refere != null) {
      
%> 
  
    <body onload="redireccionar()">
      
        
<%
      }
 
       int varfor;
          clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
           clienteSqlDaoImpl     sqlCliente= new clienteSqlDaoImpl();    
          SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy' 'HH':'mm':'ss");
       Date fechaDate = new Date();
        String fecha=formateador.format(fechaDate);

        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
        DecimalFormat formatnumero = new DecimalFormat("###,###.##",simbolo);
       
      ///// System.out.println("numerooo" +numero_entrante);  
       //System.out.println("xcodigo" +xcodigo  + " numero_entarnte "+ numero_entrante);
  String Cd="";
 %>
  

<form name="form1">
    <%  out.println("<input type='hidden' name='campa'  id='campa'  value = "+"'"+campa+"'"+"/>"); %>
     <input type='hidden' name='campaign' id='campaign'  value="<%=capaign%>" >
       <input type="hidden" name="codigo" id="codigo" value="<%=xcodigo%>">
         <input TYPE="hidden" name="graba" id="graba"    value="<%=graba%>">
<input type="hidden" name="GrabaAnotacion" />
<table  width="1500" border="0">
   
<tr >
  <td height="28"   colspan="3" bgcolor="#97D4FE"><div align="left" class="Estilo2">Informaci&oacute;n del Cliente</div></td>
  </tr>
  
    <tr>
<td  height= "90" colspan="2">
    <br>
  <table height="150" border="1" bordercolor="#F6F6F6" >
      <% List<beanClienteBo> listaCliente = oraCliente.ClienteBo(xcodigo.trim(), orasql);
                    List<beanInformacionAdicionalBO> listaInformacion = null;
                    beanClienteBo clienbo = null;
                    beanInformacionAdicionalBO informacion = null;
               
                    if(listaInformacion==null || listaInformacion.size()==0){
                    
                    
                    }else{
                                
                        
                  for(int h =0 ; h<listaInformacion.size(); h++){
                      informacion=(beanInformacionAdicionalBO)listaInformacion.get(h);
                  
                  if(informacion.getIvs_AC()==null){
                      informacion.setIvs_AC("");
                  }if(informacion.getIvs_AT()==null){
                      informacion.setIvs_AT("");
                  }if(informacion.getS_Llamada()==null){
                      informacion.setS_Llamada("");
                  }if(informacion.getFech_venc_Envases()==null){
                       informacion.setFech_venc_Envases("");
                  }if(informacion.getFech_venc_Liquido()==null){
                      informacion.setFech_venc_Liquido("");
                  }if(informacion.getFech_venc_Percepcion()==null){
                      informacion.setFech_venc_Percepcion("");
                  }if(informacion.getMonto_venc_Envases()==null){
                      informacion.setMonto_venc_Envases("");
                  }if(informacion.getMonto_venc_Liquido()==null){
                      informacion.setMonto_venc_Liquido("");
                  }if(informacion.getMonto_venc_Percepcion()==null){
                      informacion.setMonto_venc_Percepcion("");
                  }
                  
                  }
                    }
                          
                  if( listaCliente.isEmpty()==false ){
                  for(int j =0 ;  j<listaCliente.size(); j++  ){
                      
                      clienbo =(beanClienteBo) listaCliente.get(j);
                      
                      if(clienbo.getCod_cli_sap()==null){
                          clienbo.setCod_cli_sap("");
                      }if(clienbo.getCodclasificameda()==null){
                          clienbo.setCodclasificameda("");
                      }if(clienbo.getDescanal()==null){
                          clienbo.setDescanal("");
                      }if(clienbo.getDesclasifiacionpos()==null){
                          clienbo.setDesclasifiacionpos("");
                      }if(clienbo.getDesclidetallista()==null){
                          clienbo.setDesclidetallista("");
                      }if(clienbo.getDesdiavistv()==null){
                          clienbo.setDesdiavistv("");
                      }if(clienbo.getDesdireccion()==null){
                          clienbo.setDesdireccion("");
                      }if(clienbo.getDesdistrito()==null){
                          clienbo.setDesdistrito("");
                      }if(clienbo.getDesfechacumpleanio()==null){
                          clienbo.setDesfechacumpleanio("");
                      }if(clienbo.getDespersonacontacto()==null){
                          clienbo.setDespersonacontacto("");
                      }if(clienbo.getDesprovincia()==null){
                          clienbo.setDesprovincia("");
                      }if(clienbo.getDestelefonofijo()==null){
                          clienbo.setDestelefonofijo("");
                      }if(clienbo.getDestelefonomovil()==null){
                          clienbo.setDestelefonomovil("");
                      }if(clienbo.getDiarep()==null){
                          clienbo.setDiarep("");
                      }if(clienbo.getLentreg()==null){
                          clienbo.setLentreg("");
                      }if(clienbo.getNomsupervisor()==null){
                          clienbo.setNomsupervisor("");
                      }if(clienbo.getNomtelv()== null){
                          clienbo.setNomtelv("");
                      }if(clienbo.getNomvendedor()==null){
                          clienbo.setNomvendedor("");
                      }if(clienbo.getTvist()==null){
                          clienbo.setTvist("");
                      }if(clienbo.getVenhor()==null){
                          clienbo.setVenhor("");
                      }if(clienbo.getDiavisitaac()==null){clienbo.setDiavisitaac(""); }
                        if(clienbo.getBk()==null){
                        clienbo.setBk("");
                      }if(clienbo.getEstcliente()==null){
                          clienbo.setEstcliente("");
                      }if(clienbo.getNombrecd()==null){
                        clienbo.setNombrecd("");
                      }if(clienbo.getZonatvta()==null){
                          clienbo.setZonatvta("");
                      }if(clienbo.getCodigoruc()==null){
                          clienbo.setCodigoruc("");
                      }
                   
                      session.setAttribute("NombreCliente",clienbo.getDesclidetallista() );
                      Cd=clienbo.getNombrecd();
                %>

          <tr>
            <td height="25" bgcolor="#DBDBDB" class="Estilo4">Nombre del Cliente</td>
            <td bgcolor="#F6F6F6" class="Estilo4"><%=clienbo.getDesclidetallista() %></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Nombre AC</strong></td>
            <td bgcolor="#F6F6F6" class="Estilo4"><%=clienbo.getNomvendedor() %></td>
          </tr>
          <tr>
            <td width="207" bgcolor="#DBDBDB" class="Estilo4"><strong>Contacto:</strong></td>

               <td width="329" bgcolor="#F6F6F6" class="Estilo4"><%=clienbo.getDespersonacontacto() %></td>
          </tr>
          <tr>
            <td height="24" bgcolor="#DBDBDB" class="Estilo4"><strong>Subcanal:</strong></td>
            <td bgcolor="#F6F6F6" class="Estilo4"><%=clienbo.getDescanal() %></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Clasif POS:</strong></td>
            <td bgcolor="#F6F6F6" class="Estilo4"><%=clienbo.getDesclasifiacionpos() %></td>
          </tr>
        </table>
         
        <br>
    <label>
                <img src="img/u11_normal.jpg" alt="Mostrar"    onclick="mostrar()"  width="30" height="30"/> </label>
          <label> 
          <img  src="img/u304_normal.jpg" alt="Ocultar"    onclick="ocultar()"    width="30" height="30" /> </label>
    
          
          <div  id="div1"  style="display:none">
              <br>
              <table>
                  <tr>
                      <td> 
          <table border="1" bordercolor="#F6F6F6"    >
            <tr>
              <td bgcolor="#DBDBDB"><strong>Nombre del Agente TVTA</strong></td>
              <td bgcolor="#F6F6F6"><%=clienbo.getNomtelv() %></td>
            </tr>
            <tr>
              <td bgcolor="#DBDBDB"><strong>Zona de TVTA</strong></td>
              <td bgcolor="#F6F6F6"><%=clienbo.getZonatvta() %></td>
            </tr>
            <tr>
              <td width="207" bgcolor="#DBDBDB"><strong>Supervisor de Ventas</strong></td>
              <td width="207" bgcolor="#F6F6F6"><%=clienbo.getNomsupervisor() %></td>
            </tr>
            <tr>
              <td bgcolor="#DBDBDB"><strong>Ventana Horaria Distribución</strong></td>
              <td bgcolor="#F6F6F6"><%=clienbo.getVenhor() %></td>
            </tr>
            <tr>
              <td bgcolor="#DBDBDB"><strong>Dia de llamada TV</strong></td>
              <td bgcolor="#F6F6F6"><%=clienbo.getDesdiavistv()%></td>
            </tr>
            <tr>
              <td bgcolor="#DBDBDB"><strong>Dia de visita AC</strong></td>
              <td bgcolor="#F6F6F6"><%=clienbo.getDiavisitaac()  %></td>
            </tr>
            <tr>
              <td bgcolor="#DBDBDB"><strong>Fecha de Pr&oacute;xima Visita AC</strong></td>
              <td bgcolor="#F6F6F6">&nbsp;</td>
            </tr>
             <tr>
              <td bgcolor="#DBDBDB"><strong>Código de RUC</strong></td>
              <td bgcolor="#F6F6F6"><%=clienbo.getCodigoruc() %></td>
            </tr>
            <tr>
            <td bgcolor="#DBDBDB"><strong>Zona de venta</strong></td>
            <td bgcolor="#F6F6F6"><%=clienbo.getCodzonaventa() %></td>
          </tr>
            <%   if (listaInformacion == null  || listaInformacion.size()==0) {%>
            
            <tr>
                <td bgcolor="#DBDBDB"><strong>IVS Ventas</strong></td>
                <td bgcolor="#F6F6F6" >       </td>
            </tr>
            <tr>
                <td bgcolor="#DBDBDB"><strong>IVS TV</strong></td>
                <td bgcolor="#F6F6F6">        </td>
            </tr>
            
            
            <%}else{%>
             
          <tr>
            <td bgcolor="#DBDBDB"><strong>IVS Ventas</strong></td>
            <td bgcolor="#F6F6F6"><%=informacion.getIvs_AC() %></td>
          </tr>
           <tr>
            <td bgcolor="#DBDBDB"><strong>IVS TV</strong></td>
            <td bgcolor="#F6F6F6"><%=informacion.getIvs_AT() %></td>
          </tr>
           <%}%>
          </table></td>
                      <td> <table>
                <td width="896" height="180">
     
     
        <table border="1" bordercolor="#F6F6F6" id="div2"  style="display: none" >
           
             <tr>
            <td bgcolor="#DBDBDB"><strong>Gerencia Venta</strong></td>
            <td bgcolor="#F6F6F6"><%=clienbo.getDesgerencia()%></td>
          </tr><tr>
            <td bgcolor="#DBDBDB"><strong>Direcci&oacute;n:</strong></td>
            <td bgcolor="#F6F6F6"><%=clienbo.getDesdireccion() %></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB"><strong>Distrito:</strong></td>
            <td bgcolor="#F6F6F6"><%=clienbo.getDesdistrito()  %></td>
          </tr>
          <tr>
            <td width="207" bgcolor="#DBDBDB"><strong>Teléfonos:</strong></td>
            <td width="207" bgcolor="#F6F6F6">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB"><strong>Fecha de Cumplea&ntilde;os:</strong></td>
          
             <td bgcolor="#F6F6F6"> <%=clienbo.getDesfechacumpleanio() %></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB"><strong>Estado del Cliente:</strong></td>
            <td bgcolor="#F6F6F6"><%=clienbo.getEstcliente() %></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB"><strong>MEDA:</strong></td>
            <td bgcolor="#F6F6F6"><%=clienbo.getCodclasificameda()%></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB"><strong>Nombre de CD:</strong></td>
            <td bgcolor="#F6F6F6"><%=clienbo.getNombrecd()  %></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB">BK(C&oacute;digo de CD)</td>
            <td bgcolor="#F6F6F6"><%=clienbo.getBk()  %></td>
          </tr>
          
              <%   if (listaInformacion == null  || listaInformacion.size()==0) {%>
              
              <tr>
                  <td bgcolor="#DBDBDB">Siguiente Llamada</td>
                  <td bgcolor="#F6F6F6">   </td>
              </tr>
              <tr>
                  <td bgcolor="#DBDBDB">Siguiente Visita</td>
                  <td bgcolor="#F6F6F6">    </td>
              </tr>
              
              <%}else{%>
              <tr>
                  <td bgcolor="#DBDBDB">Siguiente Llamada</td>
                  <td bgcolor="#F6F6F6"><%=informacion.getS_Llamada() %>     </td>
              </tr>
              <tr>
                  <td bgcolor="#DBDBDB">Siguiente Visita</td>
                  <td bgcolor="#F6F6F6"><%=informacion.getS_Visita() %>    </td>
              </tr>
              
              <%}%>
         
        </table>  
        <%}}else{
                      %>
                     
                      
                <div id="idsolo" style="border-style: solid; border-width: 1px; font-family: 'Trebuchet MS'; font-size: 14px;">
        <p class="Estilo4">No hay lista de  informaci&oacute;n de cliente.</p>
    </div>    
                      
                      <br>            
      <%    
                  }
          %>        </td>
            </table></td>
                      
                  </tr>
                  
                  
              </table>
                  
            
            <br>
           
        </div></td>
      
    </tr>

      <tr>
        <td height="28"  colspan="3"    bgcolor="#97D4FE">
        <span class="Estilo2">Gesti&oacute;n de Ventas</span>       </td>
      </tr>
      
     <td height="163"    valign="top"> 
        <table width="1131" border="0">
          <tr>
            <td width="439"><span class="Estilo4">
                    Plan De Disponibilidad
              <%
  List  listasku=   oraCliente.skudisponiblidad(xcodigo.trim(),orasql);
  
  
  
  if (listasku.size()!=0){
      
%>
            </span>
            
              <table width="434" border="1">
                <tr>
                  <td width="80" bgcolor="#DBDBDB" class="Estilo4">&nbsp;</td>
                  <%    
  String saltodelinea="\n";
  for (int j=0 ; j < listasku.size() ; j++ ){
%>
                  <td width="60" bgcolor="#DBDBDB" class="Estilo4" ><strong>SKU's<%=saltodelinea%><%=listasku.get(j)%></strong></td>
                  <%
  }
 List listaMarca= oraCliente.MARCADISPONIBILIDAD(xcodigo.trim(),orasql);
 %>
                </tr>
                <%
 for(int j=0; j <listaMarca.size();j++ ){
      %>
                <tr>
                  <td bgcolor="#DBDBDB" class="Estilo4"><strong><%=listaMarca.get(j)%> </strong></td>
                  <%
for (int f=0 ; f < listasku.size() ; f++ ){

List listaventa= oraCliente.disponibleventa(xcodigo.trim(), listaMarca.get(j).toString(), listasku.get(f).toString(),orasql) ;
   
%>
                  <%
    String vari="";
    for(int c=0; c<listaventa.size(); c++){
    vari= listaventa.get(c).toString();
    if(vari.equals("0")){
    
%>
                  <td class="Estilo4">&nbsp;</td>
                  <%
    }else{
%>
                  <td class="Estilo4"><%=listaventa.get(c) %></td>
                  <%
    }
    
        }

        }
%>
                </tr>
                <%
 }
 %>
              </table>
              <br>
              <%
  }else
  {
      
    %>
              
              <p class="Estilo4">No hay lista de gesti&oacute;n de ventas.</p>
              <table>
                <tr>
                  <td width="60" bgcolor="#DBDBDB" class="Estilo4" ><strong>SKU's</strong></td>
                  <td class="Estilo4">&nbsp;-------------</td>
                </tr>
                <tr>
                  <td bgcolor="#DBDBDB" ><span class="Estilo4"><strong> Productos</strong></span></td>
                  <td class="Estilo4">&nbsp;-------------</td>
                </tr>
              </table>
              <span class="Estilo4">
              <%
  }%>
              </span></td>
            <td width="58">
                
              <table width="82" border="0">
            <tr>
                      <td width="7">&nbsp;</td>
                  <td width="7">&nbsp;</td>
                  <td width="7">&nbsp;</td>
                  <td width="43">&nbsp;</td>
            </tr>
                  </table>
              </td>
     <td width="620" valign="top" >
                 Campañas
                  <% List<beanCampania> listaCampania= oraCliente.obtienecampanias(xcodigo, orasql);
                   beanCampania  listcampa =null;
                  if(listaCampania.size() !=0 ){
                     
                 %>     
                        <table border="1"  width="554">
                <tr>
                      <td bgcolor="#DBDBDB"  align="center" width="113" >&nbsp; Nombre    de     la     Campaña</td>
                    <td bgcolor="#DBDBDB" align="center" width="240"  class="Estilo4"  ><center> Descripción de la Bonificación</center></td>
                    <td bgcolor="#DBDBDB" align="center" width="79"  class="Estilo4"  ><center>Inicio de Vigencia</center></td>
                  <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>Fin de Vigencia</center></td>
                      </tr>
                        </table>
         <div id="div40"  style="width:620px"> 
                     <table border="1"  width="555">
                      
                  <% for( int y = 0 ; y< listaCampania.size() ; y++){
                      listcampa = (beanCampania) listaCampania.get(y);
                      %>
                       <tr>
                      
                         <td width="113"  align="center"><center><%= listcampa.getNomCampa() %></center></td> 
                          <td width="240"  align="center"><center><%= listcampa.getDescrBoni() %></center></td> 
                          <td width="80" align="center" ><center><%= listcampa.getFechIni() %></center></td> 
                         <td width="94" align="center" ><center><%= listcampa.getFechFin() %></center></td>      
                       </tr>
                      <%
                  }%>        
           
                  </table>  
              </div>
                  <%    
                      
                  }else{
                  %>
                  
                  <table border="1">
                      
                 <tr>
                          <td bgcolor="#DBDBDB" class="Estilo4">Nombre de la Campaña</td>
                          <td bgcolor="#DBDBDB" class="Estilo4"  > Descripción de la Bonificación</td>
                          <td bgcolor="#DBDBDB" class="Estilo4"  >Inicio de Vigencia</td>
                          <td bgcolor="#DBDBDB" class="Estilo4">Fin de Vigencia</td>
                      </tr>
                    
                      <tr>
                          <td>&nbsp;</td> 
                           <td>&nbsp;</td> 
                            <td>&nbsp;</td> 
                             <td>&nbsp;</td>                          
                      </tr>
                      
                      
                  </table>   
                  
                     
                  
                
<%}%>
              </td>
           
            
   
  
              
              
              
              
         
              
          </tr>
          
          
        
        </table>
            
        <span class="Estilo4"><br>
         </span>
              
              <table border="0" >
                 
                  <td><p ><span><strong class="Estilo4"> <span class="Estilo4">Hist&oacute;rico Venta - Cobetura (Cajas Equivalentes)</span></strong></span> </p>
         
         <label class="Estilo4">Buscar fecha: <input type="text" id="txtbusFecha"  name="txtbusFecha" placeholder="Ingresar Fecha"></label><label><input type="button" id="btnbuscafecha" name="btnbuscafecha" value="Busqueda" onclick="tablaDinamica('<%=xcodigo%>')"></label>
                    
                     <br>
                     <br>
                     <div id="div41">  
                     <table border ="1" id="tablaproducto" name="tablaproducto">
             <thead>
                 <tr>
                     <th bgcolor="#DBDBDB" class="Estilo4">Fecha</th>
                     <th bgcolor="#DBDBDB" class="Estilo4">Categoria</th>
                     <th bgcolor="#DBDBDB" class="Estilo4">Marca</th>
                     <th 
                         bgcolor="#DBDBDB" class="Estilo4">Desenvase</th>
                     <th bgcolor="#DBDBDB" class="Estilo4">Descapacidad</th>
                      <th bgcolor="#DBDBDB" class="Estilo4">    Caja     </th>
                      
                 </tr>
                 
             </thead>
             <tbody>

             </tbody>
         
         </table>
                     </div></td>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                    
                  
                         <td width="620" valign="top" >
                 Estado de Entrega y no Entrega
                  <% List<beanEntrega> listaEntrega= sqlCliente.obtieneEntrega(xcodigo, sql_local);
                   beanEntrega  listentre =null;
                  if(listaEntrega.size() !=0 ){
                     
                 %>     
                        <table border="1"  width="554">
                <tr>
                      <td bgcolor="#DBDBDB"  align="center" width="113" >&nbsp; Fecha</td>
                    <td bgcolor="#DBDBDB" align="center" width="240"  class="Estilo4"  ><center> Descripción Motivo</center></td>
                    <td bgcolor="#DBDBDB" align="center" width="79"  class="Estilo4"  ><center>Ruta SAP</center></td>
                  <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>Transportista</center></td>
                   <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>Placa</center></td>
                   <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>CD</center></td>
                      </tr>
                        </table>
         <div id="div40"  style="width:620px"> 
                     <table border="1"  width="555">
                      
                  <% for( int y = 0 ; y< listaEntrega.size() ; y++){
                      listentre = (beanEntrega) listaEntrega.get(y);
                      %>
                       <tr>
                      
                         <td width="113"  align="center"><center><%= listentre.getFecha() %></center></td> 
                          <td width="240"  align="center"><center><%= listentre.getDescrMoti() %></center></td> 
                          <td width="80" align="center" ><center><%= listentre.getRutaSAP() %></center></td> 
                         <td width="94" align="center" ><center><%= listentre.getTransportista() %></center></td>  
                        <td width="94" align="center" ><center><%= listentre.getPlaca() %></center></td> 
                       <td width="94" align="center" ><center><%= listentre.getCD() %></center></td> 

                       </tr>
                      <%
                  }%>        
           
                  </table>  
              </div>
                  <%    
                      
                  }else{
                  %>
                  
                  <table border="1">
                      
                 <tr>
                          <td bgcolor="#DBDBDB" class="Estilo4">Fecha</td>
                          <td bgcolor="#DBDBDB" class="Estilo4"  > Descripción Motivo</td>
                          <td bgcolor="#DBDBDB" class="Estilo4"  >Ruta SAP</td>
                          <td bgcolor="#DBDBDB" class="Estilo4">Transportista</td>
                           <td bgcolor="#DBDBDB" class="Estilo4">Placa</td>
                          <td bgcolor="#DBDBDB" class="Estilo4">CD</td>
                      </tr>
                    
                      <tr>
                          <td>&nbsp;</td> 
                           <td>&nbsp;</td> 
                            <td>&nbsp;</td> 
                             <td>&nbsp;</td>  
                             <td>&nbsp;</td> 
                             <td>&nbsp;</td> 
                            
                      </tr>
                      
                      
                  </table>   
                  
                     
                  
                
<%}%>
<br>
    Alerta Informativo PFR
    
      <% 
                  
                  
                  if(Cd==null){
                      Cd="";
                  }
                  
                  List<beanAlertaPFR> ListaPFR= sqlCliente.ListaPFR( Cd , sql_local);
                   beanAlertaPFR  Lis =null;
                  if(ListaPFR.size() !=0  && (xcodigo != "" || xcodigo != null  ) ){
                  
                  %>
                  <table border="1"  width="675">
                      <tr>
                          <td bgcolor="#DBDBDB"  align="center" width="113" >CD DISTRIBUCIÓN</td>
                          <td bgcolor="#DBDBDB" align="center" width="240"  class="Estilo4"  ><center> Nro. PFR Programados</center></td>
                  <td bgcolor="#DBDBDB" align="center" width="70"  class="Estilo4"  ><center>Nro. Cajas Programados</center></td>
      <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>Tope PFR</center></td>
      <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>Tope Cajas</center></td>
      <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>Falta Programar PFR</center></td>
      <td bgcolor="#DBDBDB"  align="center" width="94"  class="Estilo4"><center>Falta Programar Nro. cajas</center></td>
      </tr>
              </table>
                  <div id="div43"  style="width:705px"> 
                     <table border="1"  width="675">
                      
                  <% for( int y = 0 ; y< ListaPFR.size() ; y++){
                      Lis = (beanAlertaPFR) ListaPFR.get(y);
                      %>
                       <tr>
                      
                         <td width="113"  align="center"><center><%= Lis.getDESCENTRODIS() %></center></td> 
                          <td width="220"  align="center"><center><%= Lis.getPFR() %></center></td> 
                          <td width="90" align="center" ><center><%= Lis.getCaja() %></center></td> 
                         <td width="94" align="center" ><center><%= Lis.getTOPE_FR() %></center></td>  
                        <td width="94" align="center" ><center>     <%=Lis.getTOPE_CAJA() %>  </center></td> 
                       <td width="94" align="center" ><center><%=  Lis.getFALTA_PR()  %></center></td> 
                         <td width="94" align="center" ><center><%=  Lis.getFALTA_CAJA()  %></center></td> 
                       </tr>
                      <%
                  }%>        
           
                  </table>  
              </div>
                  <%
                  }else{
                      
                      %>
                       <table border="1" >
                      <tr>
                          <td bgcolor="#DBDBDB"   >CD DISTRIBUCIÓN</td>
                          <td bgcolor="#DBDBDB"class="Estilo4"  ><center> Nro. PFR Programados</center></td>
                  <td bgcolor="#DBDBDB"  class="Estilo4"  ><center>Nro. Cajas Programados</center></td>
      <td bgcolor="#DBDBDB"  class="Estilo4"><center>Tope PFR</center></td>
      <td bgcolor="#DBDBDB"    class="Estilo4"><center>Tope Cajas</center></td>
      <td bgcolor="#DBDBDB"    class="Estilo4"><center>Falta Programar PFR</center></td>
      <td bgcolor="#DBDBDB"   class="Estilo4"><center>Falta Programar Nro. cajas</center></td>
      </tr>
        <tr>
                          <td>&nbsp;</td> 
                           <td>&nbsp;</td> 
                            <td>&nbsp;</td> 
                             <td>&nbsp;</td>  
                             <td>&nbsp;</td> 
                             <td>&nbsp;</td> 
                             <td>&nbsp;</td> 
                      </tr>
              </table>
                    
                      <%
                  }
                 %>  
              </td>
                     </tr>
                  
              </table>
         
                     
                  
         
  <input TYPE="hidden" name="idcheck" id="idcheck">
            <input TYPE="hidden" name="valordes" id="valordes">
            <input TYPE="hidden" name="idllamada" id="idllamada">
     <tr>
        <td height="28" colspan="3" bgcolor="#97D4FE">
    <span class="Estilo2">Mensajes del Agente Comercial</span></tr>
        <tr>
          <td colspan="3">
                <%List listaAnotacionAG=   oraCliente.AnotacionAgente(xcodigo.trim(),orasql);
                 List listaAgendos= oraCliente.AnotacionAgentedos(xcodigo.trim(),orasql);
                
              int anotacionAg= listaAnotacionAG.size();
              int Agendos=listaAgendos.size();
                
                %>
         
           
            <table width="884" border="1">
              <tr>
                  <td width="112" bgcolor="#DBDBDB" class="Estilo4"><strong>Fecha</strong></td>
                <td width="432" bgcolor="#DBDBDB" class="Estilo4"><strong>Tipo Anotaci&oacute;n</strong></td>
                <td width="318" bgcolor="#DBDBDB" class="Estilo4"><strong>Anotaci&oacute;n</strong></td>
              </tr>
                <%if (listaAnotacionAG.size()==0){
                      %>
              <tr>
                <td class="Estilo4">&nbsp;</td> 
                <td class="Estilo4">&nbsp;</td> 
                <td class="Estilo4">&nbsp;</td> 
              </tr>   
                      <%
                           
                              }
                      
              if( anotacionAg != Agendos )    {      
                   anotacionAg=Agendos;
             
                  }     
                      
                      
                      
                      %>
              
              <% 
              beanAnotacionAgente anotagente=null;
                    int j=0 ;
                    int h ;
                    int varconteo=0 ;
               for ( h=0;h<anotacionAg;h++)    {
                    
                   anotagente =(beanAnotacionAgente)   listaAnotacionAG.get(h);  
              %>
              <tr>
                <td bgcolor="#DBDBDB" class="Estilo4"><%=anotagente.getPeriododia()%></td>
                <td bgcolor="#F6F6F6" class="Estilo4"><%=anotagente.getRespuesta()%></td>
                <%
               for ( int z=j ; z <Agendos; z++){
                   
                    if(varconteo>0) {
                       j++; 
                    }
               varconteo++ ;
             %>
                <td bgcolor="#F6F6F6" class="Estilo4"><%=listaAgendos.get(j) %></td>
                <%
               break;
               }
            %>
              </tr>
              <%
     }
             %>
            </table>
            <br>
        <tr>
            <td  height="28" colspan="3" bgcolor="#97D4FE"><Strong class="Estilo2">Cr&eacute;ditos y Promociones</strong></td>
    </tr>

    <table>             
        <tr>
          <td width="501" height="515" valign="top" class="Estilo4">
           <br>
           <p class="Estilo4"><span class="Estilo4"> <strong>Cr&eacute;ditos</strong></span>            </p>
            <table width="321" border="1" valign="top" >
            <%  List listaCredito = oraCliente.Credito(xcodigo.trim(),orasql);
              if (listaCredito.size()!=0){
               beanCredito creditobean= null;
               
               for(int k=0 ; k< listaCredito.size(); k++  ){
                creditobean=(beanCredito)listaCredito.get(k);
            %>
          <tr>
            <td width="188" bgcolor="#DBDBDB" class="Estilo4"><strong>L&iacute;nea de Cr&eacute;dito</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"> <strong> <sup>S/. </sup> <%=  formatnumero.format(creditobean.getLimite_credito() )%> </strong></td>
          </tr>
          
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Saldo Total</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong> <sup>S/. </sup><%= formatnumero.format(creditobean.getDeudatotal()) %> </strong></td>
          </tr>

          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Deuda L&iacute;quido</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong> <sup>S/. </sup><%= formatnumero.format(creditobean.getLiquido()) %> </strong></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Deuda Envases</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong> <sup>S/. </sup><%= formatnumero.format(creditobean.getEnvase()) %> </strong></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>% Utilizaci&oacute;n</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong> <%= formatnumero.format(creditobean.getUtilizacion()) %></strong></td>        
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Saldo Disponible</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong><sup>S/. </sup><%= formatnumero.format(creditobean.getSaldodisponible()) %></strong></td>
          </tr>
          <%}}else{
                %>
              <tr>
            <td width="188" bgcolor="#DBDBDB" class="Estilo4"><strong>L&iacute;nea de Cr&eacute;dito</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong><sup>S/.</sup>0.0</strong></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Saldo Total</strong></td>
            <td  width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong><sup>S/. </sup>0.0</strong></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Deuda L&iacute;quido</strong></td>
            <td width="117" align="center"  bgcolor="#F6F6F6" class="Estilo4"><strong><sup>S/ .</sup>0.0</strong></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Deuda Envases</strong></td>
            <td  width="117" align="center" bgcolor="#F6F6F6" class="Estilo4"><strong><sup>S/. </sup>0.0</strong></td>
          </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>% Utilizaci&oacute;n</strong></td>
            <td width="117" align="center" bgcolor="#F6F6F6" class="Estilo4" ><strong>0.0 %        </strong>  </tr>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>Saldo Disponible</strong></td>
            <td  width="117"  align="center" bgcolor="#F6F6F6" class="Estilo4"><strong><sup>S/. </sup>0.0</strong></td>
          </tr>  
                
              <%                   
              }

          %>
        </table>        
        
        
      <p class="Estilo4"><strong>Antig&uuml;edad de la Deuda</strong></p>
        <table width="321" border="1" >
            <%  List listadeuda = oraCliente.Antiguedad(xcodigo.trim(),orasql) ;
               if( listadeuda.isEmpty()==false){
                beanCredito credito= null;
                double sumar=0 ;
                double sumando ; 
            for (int i = 0; i < listadeuda.size() ; i++){
                credito =(beanCredito) listadeuda.get(i);
                sumando= credito.getDeuda();
                 sumar = sumando  + sumar ;
            %>
          <tr>
            <td width="192" bgcolor="#DBDBDB" class="Estilo4"><strong><%=credito.getDestiporango() %></strong></td>
            <td width="114" bgcolor="#F6F6F6" class="Estilo4"><center><strong><sup>S/ .</sup><%=formatnumero.format(credito.getDeuda() )%></strong></center></td>
          </tr>
          <%}%>
          <tr>
            <td bgcolor="#DBDBDB" class="Estilo4"><strong>TOTAL</strong></td>
            <td bgcolor="#F6F6F6" class="Estilo4"><center><strong><sup>S/. </sup><%=formatnumero.format(sumar)%></strong></center></td>
          </tr>
          <%}else{%>
          <tr>
            <td width="192" bgcolor="#DBDBDB" class="Estilo4"><center><strong>Total</strong></center></td>
            <td width="114" bgcolor="#F6F6F6" class="Estilo4"><center><strong><sup>S/.</sup> 0</strong></center></td>
          </tr>
          <%}%>
        </table>  
       <br>
        <br>
        <br>    
        <br>
        <br>
        <p></p>
          <td width="26" class="Estilo4">          
          <td height="515" valign="top" class="Estilo4"> <br>
            <p class="Estilo4"><strong>Promociones y Bonificaciones</strong>            </p>
            <table width="580" height="107" border="1"  >
          <tr>
            <td width="550" bordercolor="#FFFFFF"><p><span class="Estilo4">Promoci&oacute;n :</span>  
                <label>
              <input style="background:#DBDBDB;width:70%" type="text" name="textfield" id="textfield">
              </label>
            </p>
              <span class="Estilo4">Bonificaci&oacute;n:</span>
            <input  style="background:#DBDBDB;width:70%" type="text" name="textfield2" id="textfield2">           </td>
          </tr>
        </table>       
        <p><strong>Productividad de equipos en frio        </strong></p>
        <table width="359" height="52" border="1" >
          <tr>
            <td width="132" bgcolor="#DBDBDB" class="Estilo4"><strong>Prom. Venta Sem.</strong></td>
            <td width="73" bgcolor="#DBDBDB" class="Estilo4"><span class="Estilo4"><strong>
            
                        Ratio </strong> </span></td>
            <td width="132" bgcolor="#DBDBDB" class="Estilo4"><span class="Estilo4"><strong>
            
                        Productividad</strong></span></td>
          </tr>
          <tr>
            <td bgcolor="#F6F6F6" class="Estilo4">&nbsp;</td>
            <td bgcolor="#F6F6F6" class="Estilo4">&nbsp;</td>
            <td bgcolor="#F6F6F6" class="Estilo4">&nbsp;</td>
            
          </tr>
        </table>
        <p>&nbsp;</p>
        <table width="450" border="1">
          <tr>
              <td width="100" bgcolor="#DBDBDB" class="Estilo4">Marca</td>
            <td width="170" bgcolor="#DBDBDB" class="Estilo4"><strong>Sub Modelo</strong></td>
            <td width="79" bgcolor="#DBDBDB" class="Estilo4"><strong>Capacidad</strong></td>
            <td width="146" bgcolor="#DBDBDB" class="Estilo4"><strong>Productividad</strong></td>
            <td width="150" bgcolor="#DBDBDB" class="Estilo4"><strong>Codigo de Barra</strong></td>
          </tr>
          <%  List Productividad= oraCliente.Productividad(xcodigo.trim(),orasql);
          if(Productividad.isEmpty()==false){
            beanProductividad produ =null;
            for(int i =0; i<Productividad.size(); i++ ){
                produ =(beanProductividad)  Productividad.get(i);
            
          
          %>
          <tr>
              <td bgcolor="#F6F6F6" class="Estilo4" ><%= produ.getDeslogo() %></td>
            <td bgcolor="#F6F6F6" class="Estilo4" ><%=produ.getDessubmodelo() %></td>
            <td bgcolor="#F6F6F6" class="Estilo4"><%=produ.getValcapacidad() %></td>
            <td bgcolor="#F6F6F6" class="Estilo4"><%=produ.getProductividad() %></td>
             <td bgcolor="#F6F6F6" class="Estilo4"><%=produ.getNumero_serie() %></td>
          </tr>
          
          <% }
          }else{
          %>
              <tr class="Estilo4"><td bgcolor="#F6F6F6" >&nbsp;</td>
            <td bgcolor="#F6F6F6">&nbsp;</td>
            <td bgcolor="#F6F6F6">&nbsp;</td>
            <td bgcolor="#F6F6F6">&nbsp;</td>
            <td bgcolor="#F6F6F6">&nbsp;</td>
          
          <%}%>
        </table>
        <p>&nbsp;</p>       </td> 
    </tr>
</table>
  </table>
            
        <%  xcodigo =  "1"+xcodigo  ;    %>
  <script language="javascript">   
 
   //   alert("ca,bia titulo");
   document.title='Informacion General - '+ <%=xcodigo%> ;  
  
 
    </script>  
<% String  deshabi=  request.getParameter("desha");
          if(deshabi!=null){
     %>
  <script>
         
       desabi();       
     </script>
     <%  
          }
    
            
  
     if( actualiza != null)      {
    %>
    <script language="javascript">
   
      var campa =  document.getElementById("campaign").value; 
      // alert("vamos peru");     
   var campana= "CAMP_" + campa;
  
   var codcli =document.getElementById("codigo").value;
   ///alert(document.parent.URL);
 document.location.hash="http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?campana="+campana+"&campa="+campa+"&txtcodigo="+codcli;   
     /// alert("lel3")
     
     
     
    </script>
    
     
     <%
}  
          %>
          
   
    <%
            
orasql.close();
%>
</form>
  
  
</body>
</html>

