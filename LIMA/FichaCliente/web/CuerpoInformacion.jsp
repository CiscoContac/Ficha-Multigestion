<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.factory.oracleDaoLocalFactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dto.beanTelefonoAgregados"%>
<%@page import="com.pe.backus.dto.beanTelefonoClienteLista"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.dto.beanClienteTelefonoLocal"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="com.pe.backus.dto.beanClienteTelefono"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pe.backus.dto.beanTelefonoParentesco"%>
<%--jsp:useBean id="beanClienteFono" class="com.pe.backus.dto.beanClienteTelefono" scope="session"></jsp:useBean>
<jsp:useBean id="beanClienteFonoLocal" class="com.pe.backus.dto.beanClienteTelefonoLocal" scope="session"></jsp:useBean--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   
<head>
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <meta equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Actualización de Datos</title>
        <script src="js/informacion.js"></script>
          <link href="styles/estilos.css" rel="stylesheet" type="text/css" />


    <style type="text/css">

 #vertical-bar {
       
        overflow:scroll;
        height:330px;
		
		
    }
	#vertical-bar2 {
        border-left: 1px solid #ccc;
        width:1px;
        height:90px;
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
        <%
 //  String  cod = "0010081655";
String campana = request.getParameter("campana");


String campa= request.getParameter("campa");
String  cod = request.getParameter("codcli");





String Drop =  request.getParameter("Drop");
String manual =  request.getParameter("manual");
String valor= request.getParameter("valor");
String contador=  request.getParameter("contador");
String consultor=  request.getParameter("consultor");
String redire = request.getParameter("redire");
String otro=request.getParameter("otro");
String tacto=request.getParameter("Contacto");
String afonos=request.getParameter("afonos");
String llamadas=request.getParameter("llamadas");
String variable = request.getParameter("numeroclicktocholl");

Connection connection= oraclefactooriginal.getSQLConextion();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();


List<beanTelefonoClienteLista> Listobtienetelefono = sqlImplements.ObtenerTelefonoLista(cod,cn_sql);
List<beanTelefonoParentesco>  ListaParentesco = oraCliente.ObtenerTelefonoParentesco(cod,cnNC);
List<beanTelefonoClienteLista>  ListaTelefono=sqlImplements.ObtenerTelefonoLista(cod,cn_sql);
List<beanTelefonoAgregados>  ListaTelefonoAgregados=sqlImplements.ObtenerTelefonoAgregados(cod,cnNC);
String Contacto=oraCliente.obtenerContacto(cod,connection);
%>
<form id="form1" name="form1" method="post" action="InformacionCliente">
             <%  out.println("<input type='hidden' name='campana'  id='campana' value="    +"'"+ campana+"'"+   "/>"   );
                 out.println("<input type='hidden' name='GenCodigo'  id='GenCodigo' value=  "+"'"+cod+"'"+     "/>"  );
              %>
              
<input type='hidden' name='contador' id="contador" value='<%=contador%>'> 
<input type='hidden' name='campa'  id='campa' value='<%=campa%>'>
<input type='hidden' name='consultor'  id="consultor"  value='<%=consultor%>' >           
<input type='hidden' name='cliknum'  id="cliknum"  value='<%=variable%>' >             
<%
String Contactomodificado=sqlImplements.obtenerContactomodificado(cod, cnNC);
if(Contactomodificado==null){

Contactomodificado="No ha realizado Cambio de Contacto";
}


     beanTelefonoParentesco  parentesco=null;
     beanTelefonoClienteLista  beanClienteFono =null;
     beanClienteTelefonoLocal fonolocal= null;
      beanTelefonoClienteLista  telefono=null;
       beanTelefonoAgregados  telefonoagregado=null;
     String numero1 = "";   
     String numero2="";
     String numero3="";
     String numero4="";
     String nombre ="";
     String apellido="";
     String codcli="";
     
     for (int j=0 ;  j <Listobtienetelefono.size() ;j++ ){
        
         beanClienteFono = (beanTelefonoClienteLista) Listobtienetelefono.get(j);
         
        numero1 =  beanClienteFono.getNro();
        nombre= beanClienteFono.getNombre();
        apellido= beanClienteFono.getApellido();
        codcli= beanClienteFono.getCodCliente();
     }
     
     
     
        String Lnum1="";
        String Lnum2="";
        String Lnum3="";
        String Lnum4="";
        String Lcodcli="";

        
        
 if(redire !=null) {
      
      String campanitas=campana.substring(5);
      
      
      String estadocad=   sqlImplements.estadocad(campanitas,cn_sql);
      
if(estadocad.equals("Inicia manual con cliente")){%>

 <%--<body onload="redireccionarconcliente('#horaria')">--%>
     
     <script>
         
           ///  alert("1111111");
      var campa =  document.getElementById("campa").value; 
      // alert("vamos peru");     
   var campana= "CAMP_"+campa;
  
   var codcli =document.getElementById("GenCodigo").value;

  //document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#horaria";   
    
     </script>


<%}else{
      %>
      
      <%-- <body onload="redireccionar('#horaria')">--%>
           
            <script>
        /// alert("222222");
          
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_"+campa;
  
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
   //document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#horaria";   
    
            </script>
     
     
     
      <%
  }
  
}if(otro!=null){
    
         String campanitas=campana.substring(5);
      
      
      String estadocad=   sqlImplements.estadocad(campanitas,cn_sql);
      
  if(estadocad.equals("Inicia manual con cliente")){%>  
  
     <%--<body onload="redireccionarconcliente('#numero')">--%>
         
 <script>
        /// alert("222222");
          
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_"+campa;
   var num = document.getElementById('cliknum').value;
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
   //document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&numeroclicktocholl="+num+"#numero";   
    
            </script>        
         
         
         
    
<%    }else{
%>

 <%--<body onload="redireccionar('#numero')">--%>
     <script>
        /// alert("222222");
          
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_"+campa;
  
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
   //document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#numero";   
    
            </script>        
          
<%
  }
  
  
  
}if(tacto!=null){
       String campanitas=campana.substring(5);
     
      System.out.println("error campana "+campanitas);
      String estadocad=   sqlImplements.estadocad(campanitas,cn_sql);
      
    
    if(estadocad.equals("Inicia manual con cliente")){%>
     
      <%--<body onload="redireccionarconcliente('#contacto')">--%>
         
          <script>
        /// alert("222222");
          //alert("manual");
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_"+campa;
  //alert("contacto "+campana);
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
  // document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#contacto";   
    
            </script>        
         
    
 <% } else {  %>
  <%-- <body onload="redireccionar('#contacto')">     --%>
       <script>
        /// alert("222222");
          // alert("preparado");
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_" +campa;
  // alert("contacto "+campana);
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
  // document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#contacto";   
    
            </script>    
      <%
  }
} 
  if(afonos !=null) {
      
      
      
      String campanitas=campana.substring(5);
      
      
      String estadocad=   sqlImplements.estadocad(campanitas,cn_sql);
    
if(estadocad.equals("Inicia manual con cliente")){%>

 <%--<body onload="redireccionarconcliente('#Telefono')">--%>
  <script>
        /// alert("222222");
          
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_"+campa;
  // alert("telefonos2222 "+campana);
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
// alert("telefonos2222 "+campana);
  /// document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#Telefono";   
    
            </script> 

<%}else{
      %>
      
      <%-- <body onload="redireccionar('#Telefono')">--%>
        <script>
        /// alert("222222");
          
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_"+campa;
  // alert("telefonos "+campana);
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
   //document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#Telefono";   
    
            </script>     
           
      <%
  }
  
}
  if(llamadas !=null){
  
  %>
  
   <script>
        /// alert("222222");
          
      var campa =  document.getElementById("campa").value; 
        
   var campana= "CAMP_"+campa;
  // alert("telefonos "+campana);
   var codcli =document.getElementById("GenCodigo").value;
 //alert(codcli); 
 ///  document.URL="http://10.165.70.246:8080/FichaCliente/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#llamadas";   
    //alert("lleggggggoooooo");
            </script>     
  
  <%
  }
      %>
      
      <table width="1900" >
            <tr>
              <td width="33"><div id="u298" class="u298_container"   >
<div id="u298_img" >
<img src="img/u2_normal.jpg"  class="raw_image"></div>
<div id="u299" class="u299" style="visibility:hidden;"  >
<div id="u299_rtf"></div>
</div>
</div></td>
                <td width="1063">

                    
                  <div id="u302" class="u302_container"   >
<div id="u302_img" >
<img src="img/u4_normal.jpg"  class="raw_image"></div>
<div id="u303" class="u303" style="visibility:hidden;"  >
<div id="u303_rtf"></div>
</div>
</div></td>
                <td width="100">
                <div id="u300" class="u300_container"   >
<div id="u300_img" >
<img src="img/u0_normal.jpg"  class="raw_image"></div>
<div id="u301" class="u301" style="visibility:hidden;"  >
<div id="u301_rtf"></div>
</div>
</div></td>
            </tr>
          </table>            
             <input type='hidden' name='numeroantiguo'  id="numeroantiguo"/>
             <input type='hidden' name='accionHtml'  id="accionHtml"/>
             <input type='hidden' name='nombreantiguo'   id="nombreantiguo" />
             <input type='hidden' name='parentescoantiguo' id="parentescoantiguo" />
             <input type='hidden' name='telefonoSelect' > 
             <br>
             <br>
             <table width="1123">
<tr>
<td width="1115" bgcolor="#97D4FE" class="Estilo1 "><span class="Estilo1"><strong>Actualización de Datos Cliente</strong>          
</span></td>
</tr>
       
       
     </table><br>
              <table width="947"  style="height: 500%"    id="AnotaPerso" name="AnotaPerso" >
    <tr>
    <a name="Telefono"></a>
    <td width="532" height="445"><strong><p style="font-size: 12px ;font-family: Trebuchet MS " >Teléfono y Contacto del Cliente
    
            </p></strong>
   
         <table width="876" >
  <tr>
      <td width="839"> <div id="vertical-bar" style="  border-style:solid ;  border-width: 1px;" >
       <input type='hidden' name='accion'  id="accion"   />
            <input type='hidden' name='manual'  id="manual"   />
              <table width="683" height="226" >
          <tr>
            <td width="114" rowspan="2">&nbsp;</td>
            <td width="144" rowspan="2"></td>
            <td width="65" rowspan="2" align="center"><span class="Estilo4">Modificar</span></td>
            <td width="59" rowspan="2" align="center" ><span class="Estilo4">Eliminar</span></td>
            <td width="63" rowspan="2" align="center"><span class="Estilo4">Guardar</span></td>
            <td> </td>
            <td width="76" height="40"><span class="Estilo4">Nro. Modificados</span></td>
           
            <td width="65"><span class="Estilo4">Nro. Eliminados</span></td>
          </tr>
          <tr><td> </td>
            <td> 
<hr width="100%"></td>
            <td width="65"><hr width="100%"></td>
            
          </tr>
          <% 
          String nro="";
          int conteo= ListaTelefono.size();
          for (int i = 0; i < ListaTelefono.size(); i++) {
                                    telefono = (beanTelefonoClienteLista) ListaTelefono.get(i);
                                   // telefonoagregado = (beanTelefonoAgregados) ListaTelefonoAgregados.get(i);
                   
 nro=    telefono.getNro()   ;//se capturar el nro para ver si vas ha ser modificado o eliminado        

                            %>
          <tr>
            <td>Teléfono <%=i+1%></td>
            <td><input type="text" name="nronuevo<%=i+1%>" id="nronuevo<%=i+1%>" value="<%=telefono.getNro()%>" onKeyPress="return soloNumeros(event)"  onblur="verif(this)" disabled="disabled"  maxlength="9"    />            </td>
            <td  align ="center" onClick="modificanro<%=i+1%>()" ><img src="img/u13_normal.jpg" width="30" height="30" /></td>
            <td   align ="center"onClick="elimination(<%=i+1%>)"><img src="img/u15_normal.jpg" width="30" height="30" /> </td>
            <td  align ="center"   value ="modificarnro<%=i+1%>"><img src="img/u14_normal.jpg" width="30" height="30" id="imgippcsave" onClick="modificarx(<%=i+1%>,<%=conteo%>)" /></td>
           
            <td> </td>
            <% nro =telefono.getNro();
                              
                String nromodificado=sqlImplements.obtenerNroModificado(nro,cod,cnNC);
                String nroeliminado=sqlImplements.obtenerNroEliminado(nro,cod,cnNC);
                 
                 
                 //eliminarnrom


     if(nro.equals(nromodificado)){
        // System.out.println("numeros iguasles may..");
               
%>    

<td width="50">&nbsp;</td>
<%}else{
         %>
         
<td width="50"><%=nromodificado%></td>
<%
         
     }%>
<td><%=nroeliminado%></td>
            <td  align ="center" onClick= "eliminitationa(<%=i+1%>)"><img src="img/u15_normal.jpg" width="30" height="30" /></td>
            <td></td>
            <td></td>
            <input type='hidden' name='nroantiguo<%=i+1%>'  id="nroantiguo<%=i+1%>"      />
            <input type='hidden' name='nroeliminado<%=i+1%>'  id="nroeliminado<%=i+1%>" value="<%=telefono.getNro()%>"    />
            <input type='hidden' name='nromodificado<%=i+1%>'  id="nromodificado<%=i+1%>" value="<%=nromodificado%>"    />
            <input type='hidden' name="numerito" id="numerito" value="<%=telefono.getNro()%>"  >
            <%} int j=ListaTelefono.size()+1;%>
          </tr>
          <%     
            
            int conttelagrega= ListaTelefonoAgregados.size();
            for (int i = 0; i < ListaTelefonoAgregados.size(); i++) {
                                    telefonoagregado = (beanTelefonoAgregados) ListaTelefonoAgregados.get(i);          
             String telagregado=    telefonoagregado.getNro();
                     
                   //   
                            %>
          <tr>
            <td>Teléfono <%=j%></td>
            <td><input type="text" name="nronuevoa<%=i+1%>" id="nronuevoa<%=i+1%>" value="<%=telefonoagregado.getNro()%>"  disabled="disabled"  maxlength="9"   onKeyPress="return soloNumeros(event)" onblur="verif(this)"  />            </td>
            <td  align ="center"  onClick="modificanroagregado<%=i+1%>()" ><img src="img/u13_normal.jpg" width="30" height="30" /></td>
            <td   align ="center" onClick="eliminarnroagregado(<%=i+1%>)"><img src="img/u15_normal.jpg" width="30" height="30" /> </td>
            <td  align ="center" onClick="modificarnroagregado(<%=i+1%>)" ><img src="img/u14_normal.jpg" width="30" height="30" /> </td>
            
            <td width="50"></td>
            <td colspan="3">El Nro. Sera Agregado </td>
            <input type='hidden' name='nroantiguoa<%=i+1%>'  id="nroantiguoa<%=i+1%>"      />
            <input type='hidden' name='nroeliminadoa<%=i+1%>'  id="nroeliminadoa<%=i+1%>" value="<%=telefonoagregado.getNro()%>"    />
          </tr>
          <%  j=j+1;} %>
          <tr id="div1"  style="display:none"  >
            <td>Ingresar Nro. Nuevo:</td>
            <td><input type="text" width="90" name="nronuevo" id="nronuevo" maxlength="9"   onKeyPress="return soloNumeros(event)" onblur="verif(this)"  /></td>
           
              <label>
                  <td  align ="center"  > <img src="img/u14_normal.jpg" width="30" height="30" id="imanumnew"  onClick="GuardarNumero()" /></td>
               
                </label>
            </center></td>
          </tr>
          <tr>
            <td>Contacto</td>
            <td><input type="text" name="contacto" id="contacto" value="<%=Contacto%>" disabled="disabled"/></td>
            <td  align ="center"  onclick=" modificaContacto()"><img src="img/u13_normal.jpg" width="30" height="30" /></td>
            <td   align ="center" > <img src="img/u14_normal.jpg" width="30" height="30" id="imgcontasave" onClick="ContactoModificado()" /></td>
            <td ></td><td width="50"></td>
             <td ><%=Contactomodificado%></td>
             <td>
                 
             </td>
             <td  align ="center" onclick="eliminacontacto()" ><img src="img/u15_normal.jpg" width="30" height="30" /></td>
            <input type='hidden' name='contactoa'  id="contactoa"    />
               <input type='hidden' name='contacto1'  id="contacto1"    />
          </tr>
          <tr>
            <td><center>
                <label>  <br>
                <input onClick ='AgregarNro()'type="button" name="button2" id="button2" value="Agregar Nro">
                </label>
            </center></td>
           
            
            <%-- MUESTRA LOS NROS DEL CLICK TO CALL    <td><center>
             <label>
                <input type="submit"name="accionHtml" id="Grabar" value="Grabar">
                </label>
            </center></td>--%> 
          </tr>
        </table>
      </div>

    <br>
    <strong>Otros Contactos <br> <br></strong>
    
    
    <a name="contacto" ></a>
    
 <div  style="  border-style:solid ;  border-width: 1px;">
     <br>
      <table width="738" >
            
            
  <tr>
      
      
    <td width="144">Teléfono</td>
    <td colspan="2"><label>
            <input type="text" name="Telefono" id="Telefono"   maxlength="9" onKeyPress="return soloNumeros(event)"  onblur="verif(this)"/>
            </label></td>
            
    <td width="133">&nbsp;</td>
  </tr>
  <tr>
    <td height="73">Relación</td>
    <td colspan="2"><label>
              <select name="relacion" id="relacion">
                <option value="Padre">Padre</option>
                <option value="Madre">Madre</option>
                <option value="Hijo">Hijo</option>
                <option value="Hermano">Hermano</option>
                <option value="Primo">Primo</option>
                <option value="Sobrino">Sobrino</option>
                 <option value="Cuñado">Cuñado</option>
                <option value="Vecino">Vecino</option>
                 <option value="Amigo">Amigo</option>
                </select>
            </label></td>
    <td>
    <label>
        <p align='left' class="Estilo4"><span class="Estilo4">Lista de contactos</span></p>
        
    <select name="parentesco" size="4" id="parentesco"  onchange="javascript:listado(this.value);"     >
     
        
                            <% 
                            //  onchange="javascript:listado(this.value);"  
                            for (int i = 0; i < ListaParentesco.size(); i++) {
                                    parentesco = (beanTelefonoParentesco) ListaParentesco.get(i);
                            %>

                            <option   value ="<%=i+1%>"  >  <%=parentesco.getParentesco()%> , <%= parentesco.getNombre()%> ,<%= parentesco.getNumero()%>    </option>   
                            
                            
                           
     
     <%}
    
                              
                            for (int i = 0; i < ListaParentesco.size(); i++) {
                                    parentesco = (beanTelefonoParentesco) ListaParentesco.get(i);
                            %>
                             <input type='hidden' name="number<%=i+1%>"  id="number<%=i+1%>" value="<%= parentesco.getNumero()%>"     />
                             <input type='hidden' name="parentescox<%=i+1%>"  id="parentescox<%=i+1%>" value="<%=parentesco.getParentesco()%>"     />
                             <input type='hidden' name="nombrex<%=i+1%>"  id="nombrex<%=i+1%>" value="<%= parentesco.getNombre()%>"     />
     
     
    <%}   %>
    </select>
    </label> </td>
  </tr>
  <tr>
    <td>Nombre del Parentesco</td>
    <td colspan="2"><label>
              <input type="text" name="NombreParentesco" id="NombreParentesco"  onKeyPress="return txNombres(event)" />
            </label></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>              <div align="center">
            
            <br>
            
            <input type="button" name="agregar" id="agregar" value="Agregar" onclick="agregaparent()" />
              </div></td>
              
    
    <td width="144"><div align="center">
            <br>
            <input  type="button" name="eliminar" id="eliminar" value="Eliminar" onclick= "Elimiparent()" />
              </div></td>
    <td width="144"><div align="center"> <br><input onclick ="Limpiar()" type="button"  value="Limpiar" /></div></td>
  </tr>
</table>
        </div> 
    <br>
    <a name="horaria"></a>
       <strong>Rango de llamada sugerida<br><br></strong>
        <div style=" border-style:solid ;  border-width: 1px;">
        <table width="200" >
          <tr>
            <td width="250"  align="left"><label>
                    <% String Ventana=oraCliente.VentanaHoraria(cod,cnNC) ;
                    cnNC.close();
                    %>
              <select name="rango" id="rango" >
                  
                  <% if(Ventana.equals("") ){%>
                 <option   value="0">Selecciona Rango de llamada</option>  
            
      <% }else{ %>
      <option value="<%=Ventana%>"><%=Ventana%></option>
         <% } %>
          
                <option value="08:00:00 ">08:00:00 </option>
                 <option value="09:00:00">09:00:00</option>
                  <option value="10:00:00">10:00:00</option>
                   <option value="11:00:00">11:00:00</option>
                    <option value="12:00:00">12:00:00</option>
                     <option value="13:00:00">13:00:00</option>
         
                  <option value="14:00:00">14:00:00</option>
                   <option value="15:00:00">15:00:00</option>
                    <option value="16:00:00">16:00:00</option>
                     <option value="17:00:00">17:00:00</option>
                      <option value="18:00:00">18:00:00</option>
                     
                      
                      
            </select>
            </label></td>
            
             <td width="100" align="left">  <input type="button" name="VentanaHoraria" id="VentanaHoraria" value="GrabarVentanaHoraria"  onclick="gabventana()"/></td>
           
           <% if(cod==null){}else{%>
           
              
              
             <% if(Ventana.equals("")){%>
           
                <% }else{ %>
                <td width="300" > Rango de llamada sugerida: </td>
                
             <td width="100" > <%=Ventana%> </td>
             
             <% }} %>
             
          </tr>
        </table> 
      </div>
    
    </tr>
  </table>
             </body>
             
             </form>