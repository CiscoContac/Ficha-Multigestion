<%-- 
    Document   : CuerpoResultado
    Created on : 07/07/2014, 12:04:16 PM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.dto.beanResumenCamp"%>
<%@page import="com.pe.backus.dto.beanResumenCamp"%>
<%@page import="com.pe.backus.factory.sqlDaoFactoryImpl"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="com.pe.backus.dto.beanResuLLamada"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.factory.sqlDaoRascal2FactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
     <title>Resultados de Contacto</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
<script src ="js/Resultado.js"></script>

<style type="text/css">
     #div6 {
         
   overflow:scroll;
   height:250px;
   width: 1301px;
   
      }
       #divnumero{
             
   overflow:scroll;
    width:350px ;
    height: 80px   
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
        <%clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();

Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection  Diario_cn = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection   cn_rascal2= sqlDaoRascal2FactoryImpl.getSQLConextionRascal();

//Connection resucn = sqlresultadoConexion.getSQLConextion();


String codcli = request.getParameter("codcli"); 

String  campana = request.getParameter("campana"); 
String campa = request.getParameter("campa");

List<beanResuLLamada>  Lstresultado = sqlImplements.obtenerResultadoLlamada(codcli, Diario_cn);
List<beanResuLLamada>  Lstresultadohisto=sqlImplements.obtenerResultadoLlamadaHsitorico(codcli,cn_sql);

List NoContacto=sqlImplements.RazonesNoContacto(cn_sql);
List NoVenta=sqlImplements.RazonesNoVenta(cn_sql);
List TipoGest= sqlImplements.tipogestion(cn_sql);

   
   DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
        DecimalFormat formatnumero = new DecimalFormat("###,###.##",simbolo);
        
           SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy' 'HH':'mm':'ss");
        
        %>
        <form id="formresul">
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
                <input type ="hidden"  name="ventaruta"  id ="ventaruta" />
                   <input type ="hidden"  name="contacto"  id ="contacto" />
           <input type='hidden' id="telefonoSelect" name='telefonoSelect' > 
           <input type ="hidden"  name="valortipogestion"     id ="valortipogestion" />  
             <input type ="hidden"  name="actuventa"     id ="actuventa" />  
      <table>
<tr>
             <td width="1127" bgcolor="#97D4FE"> <span class="Estilo1">Resultado de Contacto</span></td>
     </tr>
   </table>
     
    <table width="992" height="530" border="0">
    <tr>
      <td width="487"  height="201"><p class="Estilo4">&iquest;Contacto al Cliente?</p>
       <table width="425" border="0">
          <tr>
            <td colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td width="59" class="Estilo4">SI</td>
            <td width="100" class="Estilo4">NO</td>
            <td width="244" class="Estilo4">Razones de No Contacto</td>
          </tr>
          <tr>
            <td class="Estilo4"><label>
              <input name="si"  id="rdSi" type="radio"  value="si" onClick="habilitar()" />
            </label>            </td>
            <td class="Estilo4"><input type="radio" id="rdNo" name="No"  value="No" onClick="deshabilitar()" /></td>
      <td class="Estilo4"><label>
                    <select name="select" id="selectResuLlamada"  disabled="true"  onChange="dimePropiedades(this.id,'valorcbxrazonllamada')">
                <option value="0" selected="selected">(Seleccione una Razón)</option>
              
            <%    for(int u=0;u<NoContacto.size(); u++){%>
                
            <option value="<%=u+1%>" class="Estilo4"><%=NoContacto.get(u)%></option>
                           <% }%>
              </select>
            </label></td>
          </tr>
        </table>
        
    <p class="Estilo4">
              <br>
        Tipo de Gestión

        <label>
        <select name="tipogestion" id="tipogestion"  disabled="true" onChange="tipoGestion(this.id,'valortipogestion')">
        <option  value="0"  class=" Estilo4" selected="selected">(Selecione gestión)</option>
        
        <%for(int j =0 ;j <TipoGest.size();j++){%>
        <option value="<%=j+1%>" class="Estilo4"><%=TipoGest.get(j)%></option>
        <%}%>
      </select>
      </label>
      </p>
    <p class="Estilo4">&nbsp;</p>
      <input type="hidden" name="thtevento" id="thtevento"  >
    <table width="600" >
      <tr>
        <td width="100" height="52" class="Estilo4"><span class="Estilo4">Gestión adicional</span></td>
        <td width="100" class="Estilo4"><label>
                <input type="checkbox" name="radio"  disabled="true" id="radio" value="radio" onClick="evento(this.id,'thtevento')" >
          Evento</label></td>
           <td width="100" class="Estilo4"><label>
          <input type="checkbox" name="radioenvase" id="radioenvase"   disabled="true" onClick="envase('radioenvase','txtenvase')">
          Envases</label></td>
          
        <td width="100" class="Estilo4"><label>
          <input type="checkbox" name="radiorecojo" id="radiorecojo"   disabled="true" onClick="gestirecojo('radiorecojo','txtrecojo')">
          Recojo</label></td>
        <td width="100" class="Estilo4"><input type="checkbox" disabled="true" name="radio3" id="radio3"  onclick="gestiadicion(this.id,'txtcobranza')" >
          Cobranza</td>
      </tr>
      
        <tr>
        <td>Envases en el POS</td>
        <td ><label>
                <input name="txtenvase" type="text" disabled="true"   id="txtenvase" size="10"  onKeyPress="return soloNumeros(event)"  ></label></td><td>Cajas.</td>
         <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>Recojo programado</td>
        <td ><label>
                <input name="txtrecojo" type="text" disabled="true"   id="txtrecojo" size="10"  onKeyPress="return soloNumeros(event)"  >
            </label></td><td>Cajas.</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>Cobranza acordada</td>
        <td ><label> S/.
          <input name="txtcobranza" type="text"  disabled="true"  id="txtcobranza" size="10"  onKeyPress="return soloNumeros(event)">
        </label></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
    </div>
    <p align="left" class="Estilo4">&nbsp;</p>
    <p class="Estilo4">&nbsp;</p></td>
     
      <td width="33" align="left"><div id="vertical-bar"></div></td>
      <td width="458" valign="top">        
         
         


 <table width="100" border="1" align="center">
        <tr>
            <td>Total</td>
            <td>Voz</td>    
            <td>Disponible</td>
            <td>Cerrados</td>
            <td>Callbacks</td>
            <td><strong>Contactados</strong></td>
            <td>Efect.contacto</td>
            <td><strong>Ventas</strong></td>
            <td>Efect.venta</td>
            
           
        
        </tr>
        <tr>
            <%

              String contaventa=  sqlImplements.sumaventa(campa, Diario_cn) ; 
               String contaContacto=  sqlImplements.sumacontacto(campa, Diario_cn);
               if(contaventa == null || contaventa.equals("null") ){
      contaventa="0";
  }
               
              if(contaContacto == null || contaContacto.equals("null") ){
      contaContacto="0";
  }    
               
    System.out.println("llego a pintar");
              
        List<beanResumenCamp> ResuCamp=  sqlImplements.obtieneResumenCamp(campana, cn_rascal2)  ; 
            beanResumenCamp resu = null;
    
      Double total=0.00;
      Double totventa;
      
      Double voz=0.00;
          
          for (int i =0 ; i<ResuCamp.size();i++){
          resu=(beanResumenCamp)ResuCamp.get(i);
            if(resu.getTotal_records()==null){
              resu.setTotal_records("");
              }if(resu.getVoice()==null){
                 resu.setVoice("");
              }if(resu.getAvailable()==null ){
                  resu.setAvailable("0");
              }if(resu.getClosed()==null){
                  resu.setClosed("0");
              }if(resu.getCallback()==null){
                  resu.setCallback("0");
              }
          
            total=  Double.parseDouble(resu.getTotal_records());
            voz= Double.parseDouble(resu.getVoice());
      %>
           <td align="center" ><center><strong><%=resu.getTotal_records()  %></strong></center></td>
          <td align="center"><center><strong><%=resu.getVoice() %></strong></center></td>
                 <%
 
 Double converVenta= Double.parseDouble(contaventa) ;
  Double converContacto=Double.parseDouble(contaContacto);
      
         
 Double venta= (converVenta  / total ) * 100 ;

 Double contacto= ( converContacto  / total  ) * 100;
 Double efecVenta= (venta / contacto) * 100 ;

          %>
       <td align="center" ><center><strong><%=resu.getAvailable() %></strong></center></td>
          <td align="center"><center><strong><%=resu.getClosed()%></strong></center></td>
           <td align="center"><center><strong><%=resu.getCallback()%></strong></center></td>
          <%
        
             %>   
          <%
          if (total.equals(0.00) || contacto.equals(0.00) ){%>
          <td align="center"><center><strong> 0 </strong></center></td>
          <td align="center"><center><strong> 0 %</strong></center></td>
           <td align="center"><center><strong> 0 </strong></center></td>
           <td align="center"><center><strong> 0 %</strong></center></td>
          <%}else{%>
         <td align="center"><span class="Estilo5"><%=contaContacto %></span></td>
           <td align="center"><center><strong><%=formatnumero.format(contacto)%> % </strong></center></td>
          <td align="center"><span class="Estilo5"><%=contaventa%> </span></td>
           <td align="center"><center><strong><%=formatnumero.format(efecVenta)%> %</strong></center></td>
          <%}%>
          <%
          }
      
          /// if( contdetallado==0){
               %>
       

        </tr>
      </table>
          
          <p align="left" class="Estilo4">Resultado de Venta</p>
          <br>
          <table width="447" border="0" >
            <tr>
              <td width="56" class="Estilo4">&nbsp;</td>
              <td width="20" class="Estilo4"  >Si</td>
              <td width="24" class="Estilo4"  > No </td>
              <td width="210" class="Estilo4">&nbsp;</td>
            </tr>
            <tr>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4"><input type="radio"  disabled="true" name="chbsi" id="chbsi"  onclick="habisi(this.id,'cbxrazonventa2','checkbox4','valorrbcerveza','valorcbxnocerveza')" /></td>
              <td class="Estilo4"><input type="radio"  disabled="true"  name="checkbox4" id="checkbox4" onClick="habino(this.id,'cbxrazonventa2','chbsi','valorrbcerveza')"/></td>
              <td class="Estilo4">&nbsp;</td>
            </tr>
            <tr>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2" class="Estilo4">Razones de No venta</td>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4"><select name="cbxrazonventa2"  id="cbxrazonventa2" disabled="true" onChange="dimePropiedades(this.id,'valorcbxnocerveza')">
                <option value="0" selected="selected">(Seleccione Razón No Venta )</option>
                <%    for(int u=0;u<NoVenta.size(); u++){%>
                <option value="<%=u+1%>"  class="Estilo4"><%=NoVenta.get(u)%></option>
                <% }%>
              </select></td>
            </tr>
            
            <tr>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2" class="Estilo4" align="right">
                  <label>
                      
               <%     ///int ventadia=   sqlImplements.contaGrabacDiaVenta(codcli,cn_sql);
             int ventaruta= sqlImplements.selectventaruta(codcli, campana, Diario_cn);
        
               %>
                 <%--  
                if (cont!= 0){
               
               --%>
               
               <%--<input type="button" name="button" id="button" value="Agregar" disabled="true" onClick="enviar()" class="Estilo4"  style="width:100px">--%>
              <%-- <div id="btnagrega"  style="visibility: hidden">
                   <p class="Estilo1" style="color:#FF0000"><strong>Agregar</strong></p><img src="img/u14_normal.jpg" width="35" height="40" onclick="enviar()" />
               </div>--%>
               <%--
               }else{
                   --%>
              <%--<input type="button" name="button" id="button" value="Agregar" onClick="enviar()" class="Estilo4"  style="width:100px">--%>
              <div id="btnagrega">
                  <p class="Estilo1" style="color:#FF0000"><strong>Agregar</strong></p><img src="img/u14_normal.jpg" width="35" height="40" id="imagrabaresulta" onclick="enviar(<%=ventaruta%>)"/>
              </div>
              <%--    
               }   
               --%>      
                      
              
                  
                  </label>
              
              
              </td>
              
              
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4">
                  
                  <%--<input type="button" name="button2" id="button2" value="Modificar" onClick=" Modifica()" class="Estilo4" style="width:100px">--%>
                <div id="idbtnmodif" >
                     
                      <p class="Estilo1" style="color:#FF0000"><strong>Modificar</strong></p>
                      <img src="img/u13_normal.jpg" width="40"  onclick="Modifica(<%=ventaruta%>)" id="imamodifiresul" height="35" />
                  </div>
              </td>
            </tr>
          </table>
        <p>&nbsp;</p>
      <p>&nbsp;</p></td>
    </tr>
    <tr>
      <td height="323" colspan="3" align="left"><p><a name="graba"></a>      </p>
    
     <div id="divcab"  align="left">       
      <table width="1249" border="1" id="tsd" >
           <tr>
            <td width="22" class="Estilo4"> </td>
            <th width="82" class="Estilo4">Fecha/Hora</th>
            <th width="73" class="Estilo4">Contacto Cliente</th>
            <th width="91" class="Estilo4">Razón No Contacto</th>
            <th width="64" class="Estilo4" >Realizó Venta</th>
            <th width="77" class="Estilo4">Razon No Venta</th>  
            <th width="81" class="Estilo4">Recojo</th>
            <th width="79" class="Estilo4">Cobranza</th>
            <th width="94" class="Estilo4">Evento</th>
            <th width="60" class="Estilo4">Envases</th>
            <th width="95" class="Estilo4">Tipo Gesti&oacute;n</th>
          </tr>
      </table>
      </div>
      <div id="div6"  align="left">
          <table width="1249" border="1" id="tbResuLlamada">
            <%
              beanResuLLamada beannoventa;
               beanResuLLamada beannoventa2=null;
                int var =0; 
                
          for(int i=0 ; i<Lstresultado.size();i++){
            %>
     
                
            <%
              beannoventa =(beanResuLLamada) Lstresultado.get(i);   
             
             String conacto= beannoventa.getContacCliente();
              
             String noContac= beannoventa.getRazonNoContacto();
             String relVenta=  beannoventa.getRealizoVenta();
       
             String  noVenCerve=  beannoventa.getRazonNoVenta();
            String  noVenGase= beannoventa.getRecojo();   
            String  noVenAgua= beannoventa.getCobranza();
           String  noVenMalta=     beannoventa.getEvento();
            String tipoGestion=  beannoventa.getTipogestion();
            
         %>  
          <tr>
            <td width="20" class="Estilo4">
              <span class="Estilo4">
          <label>
                    <input type="radio" id="chb<%=var%>"   name= "chb"   value ="<%=i%>"   onclick="ActualizarResultadoVentana(this.id,'<%=beannoventa.getId()%>')" />
                    <input type="hidden" id="idresu" name="idresu">
          </label>
              </span></td>
            <td width="86" class="Estilo4" id="dat<%=var%>"><%=formateador.format(formateador.parse(beannoventa.getFecha())) %></td>
            
            
        <%if( conacto.equals("")){
                %>
                
                <td width="68" class="Estilo4" id="codcli<%=var%>">&nbsp;</td>
            <%
            }else{
           
%>
 <td width="68" class="Estilo4" id="codcli<%=var%>"><%= beannoventa.getContacCliente() %></td>
           <%
            }
           %>
            
           <% if( noContac == null || noContac.equals("") ){
               %>
               <td width="94" class="Estilo4" id="noconta<%=var%>">&nbsp;</td>
               
            <%
           }
           else{
               %>
                <td width="94" class="Estilo4" id="noconta<%=var%>"><%=beannoventa.getRazonNoContacto() %></td>
               
  <%
               }%>
           
               <%if( relVenta==null  ||  relVenta.equals("  ")){
             %>
            
             <td width="63" class="Estilo4" id="reaventa<%=var%>">&nbsp;</td>
              <%
         }else{
%>  
<td width="63" class="Estilo4" id="reaventa<%=var%>"><%=beannoventa.getRealizoVenta()%></td>
<%      
}%>      

<%if    ( noVenCerve==null ||  noVenCerve.equals("")){
%> 
<td width="74" class="Estilo4" id="ventcer<%=var%>">&nbsp;</td>
<%    
 }else{
%>  
 <td width="74" class="Estilo4" id="ventcer<%=var%>"><%=beannoventa.getRazonNoVenta()%></td>
<%   
 }%>           
            
 <%if(noVenGase == null||  noVenGase.equals("")  ||  noVenGase.equals("null") ){
  
     %>
     <td width="82" class="Estilo4" id="nogaseo<%=var%>" >&nbsp;</td>
 
 <%

 }else{
%>
 <td width="82" class="Estilo4" id="nogaseo<%=var%>" ><%=beannoventa.getRecojo()%></td>
<%    
}%>
      
<%if( noVenAgua == null ||  noVenAgua.equals("")|| noVenAgua.equals("null")){
    %>
    
    <td width="80" class="Estilo4" id="noventagua<%=var%>">&nbsp;</td>
    <%
}else{
    %>
  <td width="80" class="Estilo4" id="noventagua<%=var%>"><%=beannoventa.getCobranza()%></td>   
 <% 
    
}
 %>
           
 <%if(  noVenMalta == null || noVenMalta.equals("")){
     %>
     
     <td width="92" class="Estilo4" id="novenmal<%=var%>">&nbsp;</td>
<%
   }else{
%>
<td width="92" class="Estilo4" id="novenmal<%=var%>"><%=beannoventa.getEvento()%></td>
<%     
}%>

  <%if(  beannoventa.getEnvase() == null || beannoventa.getEnvase().equals("")){
     %>
     
     <td width="58" class="Estilo4" id="novenmal<%=var%>">&nbsp;</td>
<%
   }else{
%>
<td width="58" class="Estilo4" id="novenmal<%=var%>"><%=beannoventa.getEnvase()%></td>
<%     
}%>
       
<%if(tipoGestion.equals("")){
            
         %>   
         <td width="97" class="Estilo4" id="tipges<%=var%>">&nbsp;</td>       
         
    <%     
        }else{
            %>
       <td width="97" class="Estilo4" id="tipges<%=var%>"><%=beannoventa.getTipogestion()  %></td>     
 <%                   
}%>   
            
            <td  width="91" class="Estilo4" id="id<%=var%>"  style="display: none" ><%=beannoventa.getId()%> </td>
          </tr>
          <%
          var++;
          }
   for(int i=0 ; i<Lstresultadohisto.size();i++){
           
              beannoventa2 =(beanResuLLamada) Lstresultadohisto.get(i);   
             
             String conacto= beannoventa2.getContacCliente();
              
             String noContac= beannoventa2.getRazonNoContacto();
             String relVenta=  beannoventa2.getRealizoVenta();
       
             String  noVenCerve=  beannoventa2.getRazonNoVenta();
            String  noVenGase= beannoventa2.getRecojo();   
            String  noVenAgua= beannoventa2.getCobranza();
           String  noVenMalta=     beannoventa2.getEvento();
            String tipoGestion=  beannoventa2.getTipogestion();
            
         %>  
          <tr>
            <td width="20" class="Estilo4">
              <span class="Estilo4">
          <label>
                    <input type="radio" id="chb<%=var%>"   name= "chb"   value ="<%=i%>"   onclick="ActualizarResultadoVentana(this.id,'<%=beannoventa2.getId()%>')" />
              </label>
              </span></td>
            <td width="86" class="Estilo4" id="dat<%=var%>"><%=formateador.format(formateador.parse(beannoventa2.getFecha())) %></td>
            
            
        <%if( conacto.equals("")){
                %>
                
                <td width="68" class="Estilo4" id="codcli<%=var%>">&nbsp;</td>
            <%
            }else{
           
%>
 <td width="68" class="Estilo4" id="codcli<%=var%>"><%= beannoventa2.getContacCliente() %></td>
           <%
            }
           %>
            
           <% if( noContac == null || noContac.equals("") ){
               %>
               <td width="94" class="Estilo4" id="noconta<%=var%>">&nbsp;</td>
               
            <%
           }
           else{
               %>
                <td width="94" class="Estilo4" id="noconta<%=var%>"><%=beannoventa2.getRazonNoContacto() %></td>
               
  <%
               }%>
           
               <%if( relVenta==null  ||  relVenta.equals("  ")){
             %>
            
             <td width="63" class="Estilo4" id="reaventa<%=var%>">&nbsp;</td>
              <%
         }else{
%>  
<td width="63" class="Estilo4" id="reaventa<%=var%>"><%=beannoventa2.getRealizoVenta()%></td>
<%      
}%>      

<%if    ( noVenCerve==null ||  noVenCerve.equals("")){
%> 
<td width="74" class="Estilo4" id="ventcer<%=var%>">&nbsp;</td>
<%    
 }else{
%>  
 <td width="74" class="Estilo4" id="ventcer<%=var%>"><%=beannoventa2.getRazonNoVenta()%></td>
<%   
 }%>           
            
 <%if(noVenGase == null||  noVenGase.equals("")  ||  noVenGase.equals("null") ){
  
     %>
     <td width="82" class="Estilo4" id="nogaseo<%=var%>" >&nbsp;</td>
 
 <%

 }else{
%>
 <td width="82" class="Estilo4" id="nogaseo<%=var%>" ><%=beannoventa2.getRecojo()%></td>
<%    
}%>
      
<%if( noVenAgua == null ||  noVenAgua.equals("")|| noVenAgua.equals("null")){
    %>
    
    <td width="80" class="Estilo4" id="noventagua<%=var%>">&nbsp;</td>
    <%
}else{
    %>
  <td width="80" class="Estilo4" id="noventagua<%=var%>"><%=beannoventa2.getCobranza()%></td>   
 <% 
    
}
 %>
           
 <%if(  noVenMalta == null || noVenMalta.equals("")){
     %>
     
     <td width="92" class="Estilo4" id="novenmal<%=var%>">&nbsp;</td>
<%
   }else{
%>
<td width="92" class="Estilo4" id="novenmal<%=var%>"><%=beannoventa2.getEvento()%></td>
<%     
}%>
 
<%if(  beannoventa2.getEnvase() == null || beannoventa2.getEnvase().equals("")){
     %>
     
     <td width="58" class="Estilo4" id="novenmal<%=var%>">&nbsp;</td>
<%
   }else{
%>
<td width="58" class="Estilo4" id="novenmal<%=var%>"><%=beannoventa2.getEnvase()%></td>
<%     
}%>
       
       
<%if(tipoGestion.equals("")){
            
         %>   
         <td width="97" class="Estilo4" id="tipges<%=var%>">&nbsp;</td>       
         
    <%     
        }else{
            %>
       <td width="97" class="Estilo4" id="tipges<%=var%>"><%=beannoventa2.getTipogestion()  %></td>     
 <%                   
}%>   
            
            <td  width="91" class="Estilo4" id="id<%=var%>"  style="display: none" ><%=beannoventa2.getId()%> </td>
          </tr>
          <%
          var++;
                  
     }               
          
          
    Diario_cn.close();
    cn_sql.close();
    cn_rascal2.close();
          
          
          %>
        </table>
      </div>
      <span class="Estilo4"><br />
      </span>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
    </tr>
  </table>
   
        
        
        
        
        
     <%
          session.removeAttribute("ListaResultadoLlamada");
              codcli="1" + codcli;
          %>
          
   <script language="javascript">   
 
   //   alert("ca,bia titulo");
  /* var codi =;
   var concate= codi.substring(1);*/
   
   document.title=  'Resultados de Contacto - '+ <%=codcli%> ;  
  
 
    </script>    
   
          
</form>
    </body>
</html>

  