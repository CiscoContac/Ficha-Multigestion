<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryAQLlima"%>
<%@page import="com.pe.backus.dto.beanResultadoSAC"%>
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
        overflow:scroll;
        height:330px;
        width: 1185px;
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


<script type="text/javascript">
function soloNumeros(e) 
{ 
var key = window.Event ? e.which : e.keyCode 
//alert(key);
if( key == 13 ){
    grabar();
 
}
return ((key >= 48 && key <= 57) || (key==8)) 
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
Connection  Diario_cn = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection aqpLima=  sqlDaoLocalFactoryAQLlima.getSQLConextionLocal();
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

  //document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#horaria";   
    
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
   //document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#horaria";   
    
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
   //document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&numeroclicktocholl="+num+"#numero";   
    
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
   //document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#numero";   
    
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
  // document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#contacto";   
    
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
  // document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#contacto";   
    
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
  /// document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#Telefono";   
    
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
   //document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"&valor=valor#Telefono";   
    
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
 ///  document.URL="http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana+"&campa="+campa+"&codcli="+codcli+"#llamadas";   
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
             <table width="1190">
<tr>
<td width="" bgcolor="#97D4FE" class="Estilo1 "><span class="Estilo1"><strong>Actualización de Datos Cliente</strong>          
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
      <table width="1190">
<tr>
<td width="" bgcolor="#97D4FE" class="Estilo1" ><span>Resultado de Gestión       
</span></td>
</tr>
       
       
     </table>
    <br>
    <table border="1"  width="1166" cellspacing="0" CELLPADDING="2" border="0" style="font-family: 'Trebuchet MS'; font-size: 12px;border-bottom: none;">
           <tr style="font-weight: bold; background-color: #fdf1d9;">
                 <td width="129">

                     Fecha
                 </td>
                 <td width="10">

                     Contacto
                 </td>
                 <td width="10">

                     Venta
                 </td>
                 <td width="172">

                     Tipo gestion
                 </td>
                 
                 <td width="10">

                     Recojo
                 </td>
                  <td width="10">

                     Cobranza
                 </td>
                 <td width="10">

                     Evento
                 </td>
                 <td width="123">

                     Razon no venta
                 </td> 
                  <td width="10">

                    Tipo
                 </td> 
                 <td width="107">

                    Campana
                 </td> 
                  <td width="70">

                    Número
                 </td> 
                 <td width="158">

                    Nombre
                 </td> 
                  <td width="105">

                    Team
                 </td> 
             </tr>
              </table>
    <div id="vertical-bar2"  style="  border-style:solid ;  border-width: 1px;">
            <% List<beanResultadoSAC> listaSAC=      sqlImplements.ObtenerResultadoSAC(cod, Diario_cn);//DIARIO LIMA
            ///  List<beanResultadoSAC> listaSACArequipa=      sqlImplements.ObtenerResultadoSAC(cod, aqpLima);//DIARIO AREQUIPA
               List<beanResultadoSAC> listaSAC_Historico=      sqlImplements.ObtenerResultadoSAC_Historico(cod, cn_sql);
               
               
            beanResultadoSAC listaBeanSAC=null;
             beanResultadoSAC HistoricolistaBeanSAC=null;
            %>
             
                  
         <table border="1"  width="1166px"  >
            <%
            
   if(listaSAC==null && listaSAC_Historico== null   )   {
       
   }else{
            
       if (listaSAC !=null){
       
     for(int i=0; i<listaSAC.size(); i++ ){
         listaBeanSAC= (beanResultadoSAC)listaSAC.get(i);
         
         if(listaBeanSAC.getFecha() == null  ||  listaBeanSAC.getFecha().equals("") ){
             listaBeanSAC.setFecha("&nbsp;"); 
         }  if(listaBeanSAC.getContacCliente() == null ||  listaBeanSAC.getContacCliente().equals("") ){
              listaBeanSAC.setContacCliente("&nbsp;"); 
         }  if(listaBeanSAC.getRealizoVenta() == null ||  listaBeanSAC.getRealizoVenta().equals("")){
             listaBeanSAC.setRealizoVenta("&nbsp;"); 
         }  if(listaBeanSAC.getTipogestion() == null ||  listaBeanSAC.getTipogestion().equals("")  ){
             listaBeanSAC.setTipogestion("&nbsp;");
         }  if(listaBeanSAC.getRecojo() == null  ||  listaBeanSAC.getRecojo().equals("") ){
              listaBeanSAC.setRecojo("&nbsp;");
         }  if(listaBeanSAC.getCobranza() == null   ||  listaBeanSAC.getCobranza().equals("") ){
             listaBeanSAC.setCobranza("&nbsp;");
         }  if(listaBeanSAC.getEvento() == null ||  listaBeanSAC.getEvento().equals("")   ){
             listaBeanSAC.setEvento("&nbsp;");
         }if(listaBeanSAC.getRazonNoVenta() == null ||  listaBeanSAC.getRazonNoVenta().equals("") ){
             listaBeanSAC.setRazonNoVenta("&nbsp;");
         }if(listaBeanSAC.getTipo() == null || listaBeanSAC.getTipo().equals("")  ){
             listaBeanSAC.setTipo("&nbsp;");
         }if(listaBeanSAC.getCampana() == null  || listaBeanSAC.getCampana().equals("")  ){
             listaBeanSAC.setCampana("&nbsp;");
         }if(listaBeanSAC.getNombre() == null || listaBeanSAC.getNombre().equals("")   ){
             listaBeanSAC.setNombre("&nbsp;");
         }
         if(listaBeanSAC.getTeam() == null  || listaBeanSAC.getTeam().equals("")){
             listaBeanSAC.setTeam("&nbsp;");
         }
         %>
     
           <tr>
              
            <td width="" ><%=listaBeanSAC.getFecha()%> </td>
            
            
             <td width="50"><%=listaBeanSAC.getContacCliente()   %> </td>
             <td width="30"><%=listaBeanSAC.getRealizoVenta() %> </td>
             <td width="175"><%=listaBeanSAC.getTipogestion() %> </td>
              <%  if(listaBeanSAC.getRecojo() == null ){%>
              <td  width="">&nbsp;</td>
              <% }else{%>
             <td  width="40"><%=listaBeanSAC.getRecojo() %> </td>
<% }%>
             <td  width="53"><%=listaBeanSAC.getCobranza() %> </td>
             <td width="38"><%=listaBeanSAC.getEvento()  %> </td>
             <td  width="115" ><%=listaBeanSAC.getRazonNoVenta() %> </td>
             <td  width ="23" ><%=listaBeanSAC.getTipo() %> </td>
             <td  width ="110"><%=listaBeanSAC.getCampana() %> </td>
             <%if(listaBeanSAC.getIppc() == null &&  listaBeanSAC.getManual() != null     ){
             %>
              <td  width ="65"><%=listaBeanSAC.getManual() %> </td>
             
             <%
                 
             }else if (listaBeanSAC.getManual() == null  && listaBeanSAC.getIppc() != null  ){%>
             
             <td  width ="65"><%=listaBeanSAC.getIppc() %></td>
             <%}else{
                 %>
                 <td  width ="65">&nbsp;</td>
                 <% 
             }%>
             
              <td width="" ><%=listaBeanSAC.getNombre() %> </td>
              <td   width="" ><%=listaBeanSAC.getTeam() %></td>
         </tr>

       <%  
     }       
   }     
    if(listaSAC_Historico != null ){
     
     for(int i=0; i<listaSAC_Historico.size(); i++ ){
         listaBeanSAC= (beanResultadoSAC)listaSAC_Historico.get(i);
         
         if(listaBeanSAC.getFecha() == null  ||  listaBeanSAC.getFecha().equals("") ){
             listaBeanSAC.setFecha("&nbsp;"); 
         }  if(listaBeanSAC.getContacCliente() == null ||  listaBeanSAC.getContacCliente().equals("") ){
              listaBeanSAC.setContacCliente("&nbsp;"); 
         }  if(listaBeanSAC.getRealizoVenta() == null ||  listaBeanSAC.getRealizoVenta().equals("")){
             listaBeanSAC.setRealizoVenta("&nbsp;"); 
         }  if(listaBeanSAC.getTipogestion() == null ||  listaBeanSAC.getTipogestion().equals("")  ){
             listaBeanSAC.setTipogestion("&nbsp;");
         }  if(listaBeanSAC.getRecojo() == null  ||  listaBeanSAC.getRecojo().equals("") ){
              listaBeanSAC.setRecojo("&nbsp;");
         }  if(listaBeanSAC.getCobranza() == null   ||  listaBeanSAC.getCobranza().equals("") ){
             listaBeanSAC.setCobranza("&nbsp;");
         }  if(listaBeanSAC.getEvento() == null ||  listaBeanSAC.getEvento().equals("")   ){
             listaBeanSAC.setEvento("&nbsp;");
         }if(listaBeanSAC.getRazonNoVenta() == null ||  listaBeanSAC.getRazonNoVenta().equals("") ){
             listaBeanSAC.setRazonNoVenta("&nbsp;");
         }if(listaBeanSAC.getTipo() == null || listaBeanSAC.getTipo().equals("")  ){
             listaBeanSAC.setTipo("&nbsp;");
         }if(listaBeanSAC.getCampana() == null  || listaBeanSAC.getCampana().equals("")  ){
             listaBeanSAC.setCampana("&nbsp;");
         }if(listaBeanSAC.getNombre() == null || listaBeanSAC.getNombre().equals("")   ){
             listaBeanSAC.setNombre("&nbsp;");
         }
         if(listaBeanSAC.getTeam() == null  || listaBeanSAC.getTeam().equals("")){
             listaBeanSAC.setTeam("&nbsp;");
         }
         %>
         
         <tr>
             <td width="" ><%=listaBeanSAC.getFecha()%> </td>
             <td width="50"><%=listaBeanSAC.getContacCliente()   %> </td>
             <td width="30"><%=listaBeanSAC.getRealizoVenta() %> </td>
             <td width="175"><%=listaBeanSAC.getTipogestion() %> </td>
              <%  if(listaBeanSAC.getRecojo() == null ){%>
              <td  width="">&nbsp;</td>
              <% }else{%>
             <td  width="40"><%=listaBeanSAC.getRecojo() %> </td>
<% }%>
             <td  width="53"><%=listaBeanSAC.getCobranza() %> </td>
             <td width="38"><%=listaBeanSAC.getEvento()  %> </td>
             <td  width="115" ><%=listaBeanSAC.getRazonNoVenta() %> </td>
             <td  width ="23" ><%=listaBeanSAC.getTipo() %> </td>
             <td  width ="110"><%=listaBeanSAC.getCampana() %> </td>
             <%if(listaBeanSAC.getIppc() == null &&  listaBeanSAC.getManual() != null     ){
             %>
              <td  width ="65"><%=listaBeanSAC.getManual() %> </td>
             
             <%
                 
             }else if (listaBeanSAC.getManual() == null  && listaBeanSAC.getIppc() != null  ){%>
             
             <td  width ="65"><%=listaBeanSAC.getIppc() %></td>
             <%}else{
                 %>
                 <td  width ="65">&nbsp;</td>
                 <% 
             }%>
             
              <td width="" ><%=listaBeanSAC.getNombre() %> </td>
              <td   width="" ><%=listaBeanSAC.getTeam() %></td>

              
         </tr>

       <%  
     }               
            
    } }%>
    
    
   
       
  <%--if(listaSACArequipa != null  ){  
     for(int i=0; i<listaSACArequipa.size(); i++ ){
         listaBeanSAC= (beanResultadoSAC)listaSACArequipa.get(i);
         
         if(listaBeanSAC.getFecha() == null  ||  listaBeanSAC.getFecha().equals("") ){
             listaBeanSAC.setFecha("&nbsp;"); 
         }  if(listaBeanSAC.getContacCliente() == null ||  listaBeanSAC.getContacCliente().equals("") ){
              listaBeanSAC.setContacCliente("&nbsp;"); 
         }  if(listaBeanSAC.getRealizoVenta() == null ||  listaBeanSAC.getRealizoVenta().equals("")){
             listaBeanSAC.setRealizoVenta("&nbsp;"); 
         }  if(listaBeanSAC.getTipogestion() == null ||  listaBeanSAC.getTipogestion().equals("")  ){
             listaBeanSAC.setTipogestion("&nbsp;");
         }  if(listaBeanSAC.getRecojo() == null  ||  listaBeanSAC.getRecojo().equals("") ){
              listaBeanSAC.setRecojo("&nbsp;");
         }  if(listaBeanSAC.getCobranza() == null   ||  listaBeanSAC.getCobranza().equals("") ){
             listaBeanSAC.setCobranza("&nbsp;");
         }  if(listaBeanSAC.getEvento() == null ||  listaBeanSAC.getEvento().equals("")   ){
             listaBeanSAC.setEvento("&nbsp;");
         }if(listaBeanSAC.getRazonNoVenta() == null ||  listaBeanSAC.getRazonNoVenta().equals("") ){
             listaBeanSAC.setRazonNoVenta("&nbsp;");
         }if(listaBeanSAC.getTipo() == null || listaBeanSAC.getTipo().equals("")  ){
             listaBeanSAC.setTipo("&nbsp;");
         }if(listaBeanSAC.getCampana() == null  || listaBeanSAC.getCampana().equals("")  ){
             listaBeanSAC.setCampana("&nbsp;");
         }if(listaBeanSAC.getNombre() == null || listaBeanSAC.getNombre().equals("")   ){
             listaBeanSAC.setNombre("&nbsp;");
         }
         if(listaBeanSAC.getTeam() == null  || listaBeanSAC.getTeam().equals("")){
             listaBeanSAC.setTeam("&nbsp;");
         }
         %>
         
         <tr>
             <td width="" ><%=listaBeanSAC.getFecha()%> </td>
             <td width="50"><%=listaBeanSAC.getContacCliente()   %> </td>
             <td width="30"><%=listaBeanSAC.getRealizoVenta() %> </td>
             <td width="175"><%=listaBeanSAC.getTipogestion() %> </td>
              <%  if(listaBeanSAC.getRecojo() == null ){%>
              <td  width="">&nbsp;</td>
              <% }else{%>
             <td  width="40"><%=listaBeanSAC.getRecojo() %> </td>
<% }%>
             <td  width="53"><%=listaBeanSAC.getCobranza() %> </td>
             <td width="38"><%=listaBeanSAC.getEvento()  %> </td>
             <td  width="115" ><%=listaBeanSAC.getRazonNoVenta() %> </td>
             <td  width ="23" ><%=listaBeanSAC.getTipo() %> </td>
             <td  width ="110"><%=listaBeanSAC.getCampana() %> </td>
             <%if(listaBeanSAC.getIppc() == null &&  listaBeanSAC.getManual() != null     ){
             %>
              <td  width ="65"><%=listaBeanSAC.getManual() %> </td>
             
             <%
                 
             }else if (listaBeanSAC.getManual() == null  && listaBeanSAC.getIppc() != null  ){%>
             
             <td  width ="65"><%=listaBeanSAC.getIppc() %></td>
             <%}else{
                 %>
                 <td  width ="65">&nbsp;</td>
                 <% 
             }%>
             
              <td width="" ><%=listaBeanSAC.getNombre() %> </td>
              <td   width="" ><%=listaBeanSAC.getTeam() %></td>

              
         </tr>

       <%      
        
    }
    
    
    
    
    
   } --%>
       
           </table>   
            
        </div>
    <br><br>
     <table width="1190">
<tr>
<td width="" bgcolor="#97D4FE" class="Estilo1" ><span>Búsqueda por número          
</span></td>
</tr>
       
       
     </table>
    
    
    <a name="contacto" ></a>
    
    <br>
    <br>
    <table>
        <tr>
            <td>
        Buscar número:  <input type="text" name="txtbuscar" id="txtbuscar" onKeyPress="return soloNumeros(event)" /><input type="button" id="txtbnumero"   name="txtbnumero" value="Buscar número"  onclick="buscarnumero()">
            </td>
        <td>&nbsp;&nbsp;</td>
            <td>
  Número(s) del cliente:   <select name="numeroIpcc" id="numeroIpcc"  onChange="enviarnumeroippc(this.id)" >
        <option  value="0"  class=" Estilo4" selected="selected">(Selecione número)</option>
        
        <% for (int f = 0; f < ListaTelefono.size(); f++) {
                                    telefono = (beanTelefonoClienteLista) ListaTelefono.get(f);
                                   // telefonoagregado = (beanTelefonoAgregados) ListaTelefonoAgregados.get(i);
                   
 nro=    telefono.getNro()   ;//
 String valornro =nro.substring(0, 2);
 ///System.out.println("valornro======> "+valornro);
 if(valornro.equals("01")){
     
      nro= nro.substring(2, 9);
 }

 

%>
        <option value="<%=f+1%>" class="Estilo4"><%=nro%></option>
        <%}%>
        
      </select>
            </td>
        </tr>
    </table>
      
            <br>
            <br>
            
    <div  style="  border-style:solid ;  border-width: 1px;">
       
 <iframe id="framecuic"  frameborder="NO" name="framecuic"    scrolling ="si" src=""  width="1200px"  height="230px"></iframe>
      
        </div> 
    
    </tr>
  </table>
             </body>
             
             </form>