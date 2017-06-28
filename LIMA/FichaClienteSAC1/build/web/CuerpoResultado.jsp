<%@page import="com.pe.backus.dto.beanResultadoGestionSAC"%>
<%@page import="com.pe.backus.dto.beanClienteSAC"%>
<%@page import="com.pe.backus.dto.beanClienteSAC"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/Resultado.js"></script>
<link href="styles/css-calendar/calendario.css" type="text/css" rel="stylesheet">    </link>    
<script src="js/calendario/calendar.js" type="text/javascript"></script>
<script src="js/calendario/calendar-es.js" type="text/javascript"></script>
<script src="js/calendario/calendar-setup.js" type="text/javascript"></script>

 <script>
     function   VALINUMEROS(e) 
{ 
  var key = window.Event ? e.which : e.keyCode ;
//alert(key);

return ((key >= 48 && key <= 57) || (key===8))  ; 

}
function razoncontacto(G){
      ////  alert("llego");
    var indice = document.getElementById(G).selectedIndex;
   var textoEscogido = document.getElementById(G).options[indice].text;    
    //alert("textoEscogido"+textoEscogido);
   var indexTipoClien=  document.getElementById('selectTipoCliente').selectedIndex
    if (indice==0){
        alert("seleccionar  razon de contacto");
    }

 ////alert("indice=============>"+indice+"indexTipoClien===>"+indexTipoClien);
    if(indice==4 && (indexTipoClien==3 || indexTipoClien==2 )){
             document.getElementById('txtidagenda').value='Agendado';     
        document.getElementById('dvagenda').style.display='block';
    }else{
         document.getElementById('txtidagenda').value='';     
         document.getElementById('dvagenda').style.display='none';
    }
    
    
     document.getElementById('txtrazoncontacto').value=textoEscogido; 
}
     </script>
<title>Resultado de gestión</title>
<style type="text/css">

.Estilo60 {
	font-size: 16px;
	font-weight: bold;
	font-family: "Trebuchet MS";
}
</style>




</head>

    <body onload="cbclientedespues()">
    <form id="form1"  >
    <%       clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
           Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
           
           String campana = request.getParameter("campana");
           String retorno = request.getParameter("retorno");
           String codcli = request.getParameter("codcli");
           if (codcli == null || codcli == "null") {
               codcli = "";
           }
           String nombrecliente = request.getParameter("nombrecliente");
           String numeroentrante = request.getParameter("ANI");
           if (numeroentrante == null || numeroentrante == "null") {
               numeroentrante = "";
           }
           String varDNI = request.getParameter("DNI");
           String varRUC = request.getParameter("RUC");
           String varnombre = request.getParameter("nombre");
           String Scliente = request.getParameter("Scliente");
           String grabagestion = request.getParameter("Grabagestion");
           if (grabagestion == null) {
               grabagestion = "";
           }
           String Identificador = request.getParameter("Identificador");
           if (Identificador == null || Identificador.equals("null")) {
               Identificador = codcli;
           }
           String campanalocal = "";
           String varTipoCliente = "";
           String tipo_gestion = request.getParameter("tipo_gestion");
           if (tipo_gestion == null) {
               tipo_gestion = "";
           }
           String gestionentrante = (String) session.getAttribute("GestionEntrante");

           System.out.println("ENTRANTEEEEE======>>>>>>>>SESSION " + grabagestion);

           if ((tipo_gestion.equals("Entrante") || tipo_gestion.equals("Archivo Plano")) && (grabagestion != null || grabagestion != "" || grabagestion != "")) {

               ////System.out.println("ENTRANTEEEEE======>>>>>>>>SESSION"+ gestionentrante);  
               session.setAttribute("GestionEntrante", "gestionentrante");

           }
        
     
           
%>
<table>
    <input type="hidden" id="txtclientecb"  name="txtclientecb" value="<%=varTipoCliente%>" />
    <input type="hidden" id="txtgrabagestion"  name="txtgrabagestion" value="<%=grabagestion%>" /> 
    
    <input type="hidden" id="txtgestionentrante"  name="txtgestionentrante" value="<%=gestionentrante%>" />    
    <%if(gestionentrante==null || gestionentrante.equals("null") ||gestionentrante.equals("")  ){
        
    }else{
    
        /////session.removeAttribute("GestionEntrante");
        
    }
    %>
<tbody>
    <input type="hidden" name="campana" id="campana"   value="<%=campana%>"/>
    <input type="hidden" name="codcli" id="codcli" value="<%=codcli%>"/> 
    <input type="hidden" name="varDNI" id="varDNI" value="<%=varDNI%>"/> 
    <input type="hidden" name="varRUC" id="varRUC" value="<%=varRUC%>"/> 




    <input type="hidden" name="varnombre" id="varnombre" value="<%=varnombre%>"/> 
    <input type="hidden" name="nombrecliente" id="nombrecliente" value="<%=nombrecliente%>"/> 
    <input type="hidden" name="numeroentrante" id="numeroentrante" value="<%=numeroentrante%>"/>  
    <input type="hidden" name="Scliente" id="Scliente" value="<%=Scliente%>"/>  
    <input type="hidden" name="identificador" id="identificador" value="<%=Identificador%>"/>       
    <tr>
             <td width="1127" bgcolor="#97D4FE"> <span class="Estilo60">Resultado de Gestión</span></td>
    </tr>
   </tbody></table>
   
    <input type="hidden" id="accionResul" name="accionResul"/>
    <table width="992" height="557" border="0"  style="font-family: 'Arial'; font-size: 13px;">
    <tbody><tr>
      <td width="487" height="536" valign="top">
          <br></br>
           
      Tipo de Cliente
       <table width="590" border="0">
          <tbody>
          
          <tr>

      <td class="Estilo4">

          <input type="hidden"  name="txtcbtipocliente" id="txtcbtipocliente"/>
          
                    <select name="select" id="selectTipoCliente" onChange="cbcliente(this.id)">
                <option value="0" selected="selected">--Seleccionar--</option>
              
            
                
            <option value="1" class="Estilo4">a.- Cliente con código</option>
                           
                
            <option value="2" class="Estilo4">b.- Cliente sin código en base</option>
                           
                
            <option value="3" class="Estilo4">c.- Agregar Cliente sin código</option>
                           
                
                                       
              </select>
          </td>
              <td width="136" class=""></td>

    <td width="202" class="">

        
            <Strong>Venta 
                <input type="checkbox" name="checkVenta" id="checkVenta"/></Strong>

       

    </td>
              <td width="220">

                  <Strong>Cajas
                      <input type="text" name="txtcja" id="txtcja" size="10"/></Strong>


              </td>
          </tr>
              
              
              
              
              <tr>
              <td width="458" valign="top">        
         <% 
         
               ///System.out.println("retorno"+ retorno +"codcli"+codcli);   
         if(retorno==null ){
       
             campana=  campanalocal;
  
         %>
         <div id="regClie"  style="display: none "> 
                 
                 
              <%}else{%>
         <div id="regClie" > 
        <%}%>
          <fieldset >
                  <legend>Registrar cliente sin código</legend>
          
          <br>
              <%   

         List listacliente=sqlImplements.obtenerClienteSAC(campana, cn_rascalLocal);

            beanClienteSAC  beanlistasac  =null;  %>
          <table width="450" border="0">
            <tbody>
                

            <%  for(int i=0 ; i<listacliente.size(); i++){
                beanlistasac=(beanClienteSAC)listacliente.get(i);
                
                  }            %>    
                <tr>
                    
              
        
              <td height="61" >
                  <%if (listacliente.size()==0   &&    retorno==null ){%>
                  Nombre:</td>
              <td ><input size="50" type="text" id="txtnombre"   name="txtnombre"  />
                <%}else{
                      %>
                <input type="text" size="50"  id="txtnombre" disabled="disabled"  name="txtnombre" value="<%=beanlistasac.getNombre() %>"/>
                <%
                  }%></td>
        
       
      
              
                </tr>
               
            <tr>
              
              <td height="24" >
                  <%if(listacliente.size()==0   &&  retorno==null){%>
                  DNI:</td>
              <td >
                <input type="text" id="txtdni" name="txtdni"  maxlength="8" onkeypress=" return VALINUMEROS(event)" />
                <%}else{%>
                <input type="text" id="txtdni" name="txtdni" maxlength="8" onkeypress=" return VALINUMEROS(event)" disabled="disabled" value="<%=beanlistasac.getDNI() %>"/>
                <input type="hidden" id="txthidni" name="txthidni" value="<%=beanlistasac.getDNI()%>" />
                <%}%></td>
             
              
            </tr>
          <tr>
              
              
            
              <td height="24" >
                      <%if(listacliente.size()==0   &&    retorno==null ){ %>
                      
                    RUC:
              <td ><input type="text"     id="txtRUC"  name="txtRUC" maxlength="11" onkeypress=" return VALINUMEROS(event)"   />
                <%}else{
                          %>
                <input type="text"  disabled="disabled"   id="txtRUC" maxlength="11" onkeypress=" return VALINUMEROS(event)"   name="txtRUC" value="<%=beanlistasac.getRUC()%>"  />
                <%
                      }%>
              </tr>
                  
            <tr>
                 
              <td width="164" height="24"   >
              
                
                      <%if(listacliente.size()==0   &&    retorno==null ){ %>
                    Fijo 1:</td>
              <td width="506"   ><input type="text" id="txtfijo1" name="txtfijo1" maxlength="9" onkeypress=" return VALINUMEROS(event)" />
                <%}else{
                      
                      %>
                <input type="text" id="txtfijo1" name="txtfijo1" disabled="disabled" value="<%=beanlistasac.getFijo1() %>"   onkeypress=" return VALINUMEROS(event)" />
                <input  type ="hidden" id="txthiFijo1"  name="txthiFijo1" value="<%=beanlistasac.getFijo1() %>"/>
                <%    } %></td>
       
            </tr>
              <tr>
                      
                      <td height="24" >
                  <%if(listacliente.size()==0   &&    retorno==null ){ %>
                  Fijo 2:</td>
                      <td ><input type="text" id="txtfijo2" maxlength="9" name="txtfijo2" onkeypress=" return VALINUMEROS(event)" />
                        <%}else{%>
                        <input type="text" id="txtfijo2" disabled="disabled" name="txtfijo2" value="<%=beanlistasac.getFijo2() %>" onkeypress=" return VALINUMEROS(event)" />
                        <input  type ="hidden" id="txthiFijo2"  name="txthiFijo2" value="<%=beanlistasac.getFijo2() %>" />
                      <%
                  }%></td>
                     
              </tr>
                  
                      <tr>
                  <td height="24"  width="164" >
                  <%if(listacliente.size()==0   &&    retorno==null ){ %>
                  Celular 1:&nbsp;&nbsp;</td>
                  <td ><input type="text"  id="txtCelular1" maxlength="9" name="txtCelular1" onkeypress=" return VALINUMEROS(event)"/>
                    <%}else{
                      %>
                    <input type="text"  id="txtCelular1"  disabled="disabled" name="txtCelular1" value="<%=beanlistasac.getCelular1()%>" onkeypress=" return VALINUMEROS(event)"/>
                    <input  type ="hidden" id="txthicelular1"  name="txthicelular1" value="<%=beanlistasac.getCelular1()%>" />
                    <%
                  }%></td>
                  
                      </tr>
                     
                  
                  <tr>
                      
                      <td height="24"  width="164">
                  <%if(listacliente.size()==0   &&    retorno==null ){ %>
                  Celular 2:&nbsp;&nbsp;</td>
                      <td><input type="text"  maxlength="9" id="txtCelular2" name="txtCelular2"  onkeypress=" return VALINUMEROS(event)" />
                        <%}else{
                     %>
                        <input type="text"  id="txtCelular2" name="txtCelular2" disabled="disabled" value="<%=beanlistasac.getCelular2()%>" />
                        <input  type ="hidden" id="txthicelular2"  name="txthicelular2" value="<%=beanlistasac.getCelular2()%>" />
                      <% 
                  }%></td>
                     
                   
                  
                  </tr>
         
            <tr>
              <td colspan="4" class="Estilo4">&nbsp;</td>

            
           
            </tr>
            <tr>
                <td colspan="4"  class="Estilo4">Tipo: 
             
              <input type="hidden" id="txtcbtipoCliente" name="txtcbtipoCliente" />
              
                  <%if(listacliente.size()==0   &&    retorno==null ){%>
                  <select  id="cbtipocliente" name="cbtipocliente" onchange="cambiotipocliente(this.id)" >
                <option value="0" selected="selected">--Seleccionar--</option>
                
                <option value="1" class="Estilo4">a.-Nuevo Cliente</option>
                
                <option value="2" class="Estilo4">b.-Somos Fundamentales</option>
                
                <option value="3" class="Estilo4">c.-Consumidor Final</option>

              </select>
              <%}else{
                      %>
                      <select name="cbxrazonventa2"    disabled id="cbtipocliente" name="cbtipocliente">
                <option value="0" selected="selected">  <%=beanlistasac.getTipo() %></option>
                   </select>
                  
                  <%
                  }%>
              
              </td>
            </tr>
            
          
            
            <tr>
            <td colspan="4" class="Estilo4">&nbsp;</td>

            </tr>
                  <tr>
                 <td colspan="4" class="Estilo4">&nbsp;</td>
                  </tr>
                  <tr>
                  <td colspan="4">
          <div id="btnagrega" style="padding-right:300px;">
                  <p class="Estilo1" style="color:#FF0000"><strong>Agregar</strong></p>
                  
                  
  <img src="img/u14_normal.jpg" width="35" height="40" id="idAgregaClient" onclick="grabarcliente()">
          </div></td> </tr> </tbody> </table> </fieldset>  
        
         </div>
                </td>
          </tr>
        </tbody></table>
        
    
              
                <br>
        Tipo de Llamada 
    <table>
              <tr>
              <td>
                <input type="hidden" name="txttipollamada" id="txttipollamada" >
                    
                <select name="selectTipoLlamada" disabled id="selectTipoLlamada"  onchange="cbTipoLlamada(this.id)">
        <option value="0" selected="selected" class=" Estilo4">--Seleccionar--</option>
        
        
        <option value="1" class="Estilo4">a.-Llamada entrante</option>
        
        <option value="2" class="Estilo4">b.-Salida Rellamada</option>
        
        <option value="3" class="Estilo4">c.-Salida Agenda</option>
        
        <option value="4" class="Estilo4">d.-Salida Cierre de ticket</option>
        
        <option value="5" class="Estilo4">e.-Salida Buzones</option>
        
      </select>
      </td>
      </tr>
      </table>
      
      <br>
        Resultado de Llamada
<table width="569">
<tr>
<td width="215">
              <input type="hidden" id="txtresultado" name="txtresultado" />
        <select name="SelectResultadoLlamada"  disabled id="SelectResultadoLlamada" onChange="cbResultadoLlamada(this.id)" >
        <option value="0" class=" Estilo4" selected="selected">--Seleccionar--</option>
        
        <option value="1" class="Estilo4">a.-Contacto</option>
        
        <option value="2" class="Estilo4">b.-No contacto</option>
        
       
        
      </select>
      </td>
	  
    
      </tr>
      </table>
        &nbsp;
        <input type="hidden" name="txtventaU" id="txtventaU"></input>     
 <div id="cliNoContac" style="display: none"> 
<fieldset>
  <legend>Cliente no Contactado</legend>
  <br />
  <table width="447" border="0">
    <tbody>
      <tr>
        <td colspan="2" class="Estilo4">Razones de no contacto: </td>
        <td class="Estilo4">&nbsp;</td>
        <input type="hidden" id="txtrazonNoConacto" name="txtrazonNoConacto" />
        <td class="Estilo4"><select name="cbrazonNoContacto" id="cbrazonNoContacto"  onchange="razonNoContacto(this.id)"  >
          <option value="0" selected="selected">--Seleccionar--</option>
          <option value="1" class="Estilo4">a.-No contestan</option>
          <option value="2" class="Estilo4">b.-Fuera de servicio</option>
          <option value="3" class="Estilo4">c.-Equivocado</option>
          <option value="4" class="Estilo4">d.-Mala Señal</option>
          <option value="5" class="Estilo4">e.-Ocupado</option>
          <option value="6" class="Estilo4">f.-Buzón / Contestador</option>
        </select></td>
      </tr>
    </tbody>
  </table>
 
</fieldset>
 </div>


   <div id="cliContac" style="display: none"> 
              
             <table>
                 <tr>
                     <td>
          <fieldset>
                  <legend>Cliente Contactado</legend>
         
          <br>
          <table width="447" border="0">
            <tbody>
            <tr>
              <td colspan="2" class="Estilo4">Razones de contacto:  </td>
              <td class="Estilo4">&nbsp;</td>
              <td class="Estilo4"><input type="hidden" id="txtrazoncontacto" name="txtrazoncontacto" />
                  <select name="cbrazoncontacto" id="cbrazoncontacto"  onchange="razoncontacto(this.id)">
                <option value="0" selected="selected">--Seleccionar--</option>
                
                <option value="1" class="Estilo4">a.-Información General  </option>
                  
                <option value="2" class="Estilo4">b.-Solicitud</option>
                
                <option value="3" class="Estilo4">c.-Reclamo </option>
                
                <option value="4" class="Estilo4">d.-Agenda </option>
                
                <option value="5" class="Estilo4">e.-Cliente corta llamada</option>
                <option value="6" class="Estilo4">f.-Mala Señal </option>
                
                <option value="7" class="Estilo4">g.-Vicio </option>
                 
                <option value="8" class="Estilo4">h.-Ausente </option>
                
           
                
              </select></td>
            </tr>

          </tbody></table>
              </fieldset>  
              </td>
                     <input type="hidden" id="txtidagenda" name="txtidagenda"/>  
                    
                         <td> <div id="dvagenda" style="display: none"><fieldset>
                  <legend>Programar Agenda</legend>
                  
                  <span><img src="img/calendar/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"></img></span>  <label>       <input type="text" name="ingreso" disabled id="ingreso" value="dd-mm-yyyy" /> </label> 
                  <input type="hidden" id="fechahidden" name="fechahidden" onchange="copiarfecha()" >
                  
                  <script type="text/javascript"> 
   Calendar.setup({ 
    inputField     :    "fechahidden",     // id del campo de texto 
     ifFormat     :     "%d-%m-%Y",     // formato de la fecha que se escriba en el campo de texto 
     button     :    "lanzador"     // el id del botón que lanzará el calendario 
}); 
</script>
       </fieldset></div></td>
                     
                 </tr>
             </table>
             
       
        
    </div>
        <p class="Estilo1" style="color:#FF0000"><strong>Grabar Gestión</strong></p> 
          <img src="img/u14_normal.jpg" width="35" height="40" id="idAgregaClient" onclick="grabaGestion()"/> 
      
      
      </td>

     
                  </tr>
    </tbody>
    </table>
        <table  border="0">
 
<tr>
  <td  width="1150"  colspan="3" bgcolor="#97D4FE"><div align="left" class="Estilo60">Gesti&oacute;n Hist&oacute;rica</div></td>
  </tr>
                      </table>
  <div>
                      <% List <beanResultadoGestionSAC> listagestion =sqlImplements.ListaResultadoGestionSAC(Identificador,cn_rascalLocal );
                      beanResultadoGestionSAC resultaogestion=null;
                      %>
                      
                 
                  
                                  <br>
                  <table border="1" valign="top" cellspacing="0" style="font-family: arial;font-size: 13px;">
                      <tr style="font-weight: bold; background-color: #fdf1d9; border-bottom: none;font-family: arial;">
                          <td>Nro</td>
                          <td>Agente</td>
                          <td>
                            Tipo identificador  
                          </td>
                       <td>
                            Identificador Cliente  
                        </td>   
                           <td>
                           Tipo Cliente
                          </td>   
                          <td>
                           Tipo Llamada
                          </td> 
                          <td>
                           Resultado Contacto
                          </td> 
                            <td>
                         Tipificacion Llamada
                          </td> 
                          <td>
                         Fecha
                          </td> 
                      </tr>
                     
                          
                          <%int conta=1;
                        for( int h =0;   h< listagestion.size(); h++  ){
                            resultaogestion = listagestion.get(h);
                           %>
                           <tr>  
                                <td><strong><%=conta ++  %></strong></td>
                               <td><strong><%=resultaogestion.getId()  %></strong></td>
                           <td><%=resultaogestion.getTipo_Identificador() %>  </td>
                           <td><%=resultaogestion.getIdentificador() %>  </td>
                           <td><%=resultaogestion.getTipo_Cliente() %>  </td>
                           <td><%=resultaogestion.getTipo_Llamada() %>  </td> 
                           <td><%=resultaogestion.getResultado_Contacto() %>  </td> 
                           <td><%=resultaogestion.getTipificacion_Llamada() %>  </td> 
                            <td><%=resultaogestion.getFecha() %>  </td> 
                    </tr>
                          <%
                        }
                         System.out.println("Identificador ===========>"+Identificador);    
                  if(Scliente ==null|| Scliente.equals("null")|| Scliente.equals("")){
         
     }else{
              
         %>
         <script>
      ///////   ////window.onload(function(e){
          //   alert('cambia');
            document.getElementById('selectTipoCliente').value='3';
           ////// document.getElementById('selectTipoCliente').disabled=true;
              document.getElementById('txtcbtipocliente').value='c.- Agregar Cliente sin código';
                document.getElementById('selectTipoLlamada').disabled=false;
        ////////////// //}) ;  
         </script>
        <%
         }
                          %>
                          
                    
                  </table>
      </div>

    </form>
    
</body>
</html>

