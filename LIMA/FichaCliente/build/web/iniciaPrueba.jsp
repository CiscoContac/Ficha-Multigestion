

<%@page import="com.pe.backus.factory.oracleDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
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

<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
        <title>Actualización de Datos</title>
          <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
          
          <style>
    #vertical-bar {
        border-left: 1px solid #ccc;
        width:1px;
        height:120px;
		
		
    }
	#vertical-bar2 {
        border-left: 1px solid #ccc;
        width:1px;
        height:90px;
		}
          </style>
<script language="javascript">
      function modificarparentesco(nro,parentesco,nombre) {
       f4 = document.forms[0]; 
    document.getElementById("relacion").disabled = true;
    document.getElementById("NombreParentesco").disabled = true;
    document.getElementById("Telefono").disabled = false;
  
                 }

            
            function soloNumeros(e) 
{ 
var key = window.Event ? e.which : e.keyCode 
return ((key >= 48 && key <= 57) || (key==8)) 
}
   function txNombres(e) {  if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))   event.returnValue = false; }
 
function Limpiar() {
f4 = document.forms[0];

//f4.Telefono.value="limpiar";
//f4.relacion.value="limpiar";
//f4.NombreParentesco.value="limpiar";
document.getElementById("relacion").disabled =false;
document.getElementById("NombreParentesco").disabled =false;
document.getElementById("Telefono").disabled =false;

//document.getElementById("relacion").disabled = false;
//document.getElementById("NombreParentesco").disabled = false;
//document.getElementById("Telefono").disabled = false;
f4.Telefono.value="";
f4.relacion.value="";
f4.NombreParentesco.value="";


document.getElementById("parentesco").value="";

//alert("Se limpio los campos nuevecito");

                 }
 

            function manual() {
                f2 = document.forms[0];
                var numero ="9961783052"
               //alert(numero);
               f2.document.getElementById("numeromanual").innerHTML=numero;

            }



function modificarnroagregado(valor){
if(valor==1){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag1';
f1.submit();}  
if(valor==2){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag2';
f1.submit();}    
if(valor==3){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag3';
f1.submit();}       
if(valor==4){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag4';
f1.submit();}      
if(valor==5){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag5';
f1.submit();}    
if(valor==6){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag6';
f1.submit();}    

if(valor==7){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag7';
f1.submit();}
if(valor==8){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag8';
f1.submit();}     
if(valor==9){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag9';
f1.submit();} 
if(valor==10){ f1 = document.forms[0];
document.getElementById("accion").value='modificarnroag10';
f1.submit();}                  
}





function eliminarnroagregado(valor){
     if(valor==1){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa1';
f1.submit();}
     if(valor==2){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa2';
f1.submit();}
 if(valor==3){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa3';
f1.submit();}
if(valor==4){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa4';
f1.submit();}
 if(valor==5){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa5';
f1.submit();}
 if(valor==6){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa6';
f1.submit();}
 if(valor==7){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa7';
f1.submit();}
 if(valor==8){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa8';
f1.submit();}
 if(valor==9){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa9';
f1.submit();}

 if(valor==10){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnroa10';
f1.submit();}

}




function elimination(valor){
    if(valor==1){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro1';
f1.submit();}
if(valor==2){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro2';
f1.submit();}
if(valor==3){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro3';
f1.submit();}
if(valor==4){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro4';
f1.submit();}
if(valor==5){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro5';
f1.submit();}
  if(valor==6){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro6';
f1.submit();}
if(valor==7){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro7';
f1.submit();}  
if(valor==8){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro8';
f1.submit();}
if(valor==9){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro9';
f1.submit();}
if(valor==10){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnro10';
f1.submit();}
}

function eliminitationa(valor){
    if(valor==1){ f1 = document.forms[0];
        
document.getElementById("accion").value='eliminarnrom1';

f1.submit();}
     if(valor==2){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnrom2';
f1.submit();}
     if(valor==3){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnrom3';
f1.submit();}
     if(valor==4){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnrom4';
f1.submit();}
   if(valor==5){ f1 = document.forms[0];
document.getElementById("accion").value='eliminarnrom5';
f1.submit();}  
    
    
    
}


function clicktocall(valorr) {
    
if(valorr==null){}else{    
f1 = document.forms[0];           
f1.telefonoSelect.value=valorr;
document.getElementById("manual").value='llamadaManual';
 var campaña=f1.campana.value;
 var valor="valor";
window.open("http://10.165.70.246:8080/FichaCliente/detalleLlamada.jsp?campana="+campaña.toString()+"&valor="+valor,"detalle");
f1.submit();}}

function fllamar(){
f1 = document.forms[0];
document.getElementById("manual").value='Llamar';

f1.submit();}

 function listado (fila) {
       
       
       if(fila==1){
       
    f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number1.value; 
    f4.parentescoantiguo.value=f4.parentescox1.value;
    f4.nombreantiguo.value=f4.nombrex1.value;
    f4.Telefono.value=f4.number1.value;
    f4.relacion.value=f4.parentescox1.value;
    f4.NombreParentesco.value=f4.nombrex1.value;
   // document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;
      
      }
      if(fila==2){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number2.value; 
    f4.parentescoantiguo.value=f4.parentescox2.value;
    f4.nombreantiguo.value=f4.nombrex1.value;
    f4.Telefono.value=f4.number2.value;
    f4.relacion.value=f4.parentescox2.value;
    f4.NombreParentesco.value=f4.nombrex2.value;
   // document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;
      
    
      
        }
        
         if(fila==3){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number3.value; 
    f4.parentescoantiguo.value=f4.parentescox3.value;
    f4.nombreantiguo.value=f4.nombrex3.value;
    f4.Telefono.value=f4.number3.value;
    f4.relacion.value=f4.parentescox3.value;
    f4.NombreParentesco.value=f4.nombrex3.value;
  //  document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;
      
    
      
        }
         if(fila==4){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number4.value; 
    f4.parentescoantiguo.value=f4.parentescox4.value;
    f4.nombreantiguo.value=f4.nombrex4.value;
    f4.Telefono.value=f4.number4.value;
    f4.relacion.value=f4.parentescox4.value;
    f4.NombreParentesco.value=f4.nombrex4.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}
        
            if(fila==5){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number5.value; 
    f4.parentescoantiguo.value=f4.parentescox5.value;
    f4.nombreantiguo.value=f4.nombrex5.value;
    f4.Telefono.value=f4.number5.value;
    f4.relacion.value=f4.parentescox5.value;
    f4.NombreParentesco.value=f4.nombrex5.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}
        
           if(fila==6){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number6.value; 
    f4.parentescoantiguo.value=f4.parentescox6.value;
    f4.nombreantiguo.value=f4.nombrex6.value;
    f4.Telefono.value=f4.number6.value;
    f4.relacion.value=f4.parentescox6.value;
    f4.NombreParentesco.value=f4.nombrex6.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;} 
        
       if(fila==7){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number7.value; 
    f4.parentescoantiguo.value=f4.parentescox7.value;
    f4.nombreantiguo.value=f4.nombrex7.value;
    f4.Telefono.value=f4.number7.value;
    f4.relacion.value=f4.parentescox7.value;
    f4.NombreParentesco.value=f4.nombrex7.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}     
     
         if(fila==8){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number8.value; 
    f4.parentescoantiguo.value=f4.parentescox8.value;
    f4.nombreantiguo.value=f4.nombrex8.value;
    f4.Telefono.value=f4.number8.value;
    f4.relacion.value=f4.parentescox8.value;
    f4.NombreParentesco.value=f4.nombrex8.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}   
       if(fila==9){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number9.value; 
    f4.parentescoantiguo.value=f4.parentescox9.value;
    f4.nombreantiguo.value=f4.nombrex9.value;
    f4.Telefono.value=f4.number9.value;
    f4.relacion.value=f4.parentescox9.value;
    f4.NombreParentesco.value=f4.nombrex9.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}     
        
        
        
   }

function modificarx(valor){
 
    if(valor==1){ f1 = document.forms[0];
      
        document.getElementById("accion").value='modificarnro1';
 
    f1.submit();}
     if(valor==2){ f1 = document.forms[0];
    document.getElementById("accion").value='modificarnro2';
    f1.submit();}
     if(valor==3){ f1 = document.forms[0];
    document.getElementById("accion").value='modificarnro3';
    f1.submit();}
      if(valor==4){ f1 = document.forms[0];
   document.getElementById("accion").value='modificarnro4';
    f1.submit();}
      if(valor==5){ f1 = document.forms[0];
   document.getElementById("accion").value='modificarnro5';
    f1.submit();}
  if(valor==6){ f1 = document.forms[0];
   document.getElementById("accion").value='modificarnro6';
    f1.submit();}

  if(valor==7){ f1 = document.forms[0];
   document.getElementById("accion").value='modificarnro7';
    f1.submit();}
  if(valor==8){ f1 = document.forms[0];
   document.getElementById("accion").value='modificarnro8';
    f1.submit();}
  if(valor==9){ f1 = document.forms[0];
   document.getElementById("accion").value='modificarnro9';
    f1.submit();}
  if(valor==10){ f1 = document.forms[0];
   document.getElementById("accion").value='modificarnro10';
    f1.submit();}
}

            function modifica() {
           
       
                document.getElementById("text_1").disabled = false;
                 document.getElementById("text_2").disabled = false;
                 document.getElementById("text_3").disabled = false;
                 document.getElementById("text_4").disabled = false;
                 }
               

            function LlamadaManual() {
          // alert("jossy cabro");
               document.getElementById('div1').style.display = 'block';

        //f1.submit();


            }
  function AgregarNro() {
          // alert("jossy cabro");
         // alert("hola");
               document.getElementById('div1').style.display = 'block';
        //  alert("hola");
        //f1.submit();


            }
            
        function  modificarcontacto () {f4 = document.forms[0];
            f4.contactoa.value=f4.contacto.value;
         document.getElementById("contacto").disabled = true;
  
    }
            
        function valorcontador(){
            var contador=  document.getElementById("contador").value;
            var consultor="consultor";
            var campaña= f1.campana.value;
             var campa= f1.campaign.value;
            var   codCliente= f1.codCliente.value;
            var manual="manual";
            var drop="drop";
            //alert("Entro al valorccontador");
            window.open("http://10.165.70.246:8080/FichaCliente/detalleLlamada.jsp?campana="+campaña.toString()+"&consultor="+consultor+"&contador="+contador+"&campa="+campa+"&manual="+manual+"&Drop="+drop+"&codcli="+codCliente,"detalle");
        }    
function  modificanro1() {
f4 = document.forms[0];
 f4.nroantiguo1.value=f4.nronuevo1.value;
 document.getElementById("nronuevo1").disabled = false;}
function  modificanro2() { 
f4 = document.forms[0];
f4.nroantiguo2.value=f4.nronuevo2.value;
document.getElementById("nronuevo2").disabled = false;
}function  modificanro3() {
f4 = document.forms[0];
f4.nroantiguo3.value=f4.nronuevo3.value;        
document.getElementById("nronuevo3").disabled = false;}
function  modificanro4() {
f4 = document.forms[0];
f4.nroantiguo4.value=f4.nronuevo4.value;          
document.getElementById("nronuevo4").disabled = false;}
function  modificanro5() {
f4 = document.forms[0];
f4.nroantiguo5.value=f4.nronuevo5.value;          
document.getElementById("nronuevo5").disabled = false;}
function  modificanroagregado1() {
f4 = document.forms[0];
f4.nroantiguoa1.value=f4.nronuevoa1.value;          
document.getElementById("nronuevoa1").disabled = false;}      
function  modificanroagregado2() {
f4 = document.forms[0];
f4.nroantiguoa2.value=f4.nronuevoa2.value;          
document.getElementById("nronuevoa2").disabled = false;}
function  modificanroagregado3() {
f4 = document.forms[0];
f4.nroantiguoa3.value=f4.nronuevoa3.value;          
document.getElementById("nronuevoa3").disabled = false;}
function  modificanroagregado4() {
f4 = document.forms[0];
f4.nroantiguoa4.value=f4.nronuevoa4.value;          
document.getElementById("nronuevoa4").disabled = false;}
function  modificanroagregado5() {
f4 = document.forms[0];
f4.nroantiguoa5.value=f4.nronuevoa5.value;          
document.getElementById("nronuevoa5").disabled = false;}

function  modificanroagregado6() {
f4 = document.forms[0];
f4.nroantiguoa6.value=f4.nronuevoa6.value;          
document.getElementById("nronuevoa6").disabled = false;}

function  modificanroagregado7() {
f4 = document.forms[0];
f4.nroantiguoa7.value=f4.nronuevoa7.value;          
document.getElementById("nronuevoa7").disabled = false;}
function  modificanroagregado8() {
f4 = document.forms[0];
f4.nroantiguoa8.value=f4.nronuevoa8.value;          
document.getElementById("nronuevoa8").disabled = false;}
function  modificanroagregado9() {
f4 = document.forms[0];
f4.nroantiguoa9.value=f4.nronuevoa9.value;          
document.getElementById("nronuevoa9").disabled = false;}
function  modificanroagregado10() {
f4 = document.forms[0];
f4.nroantiguoa10.value=f4.nronuevoa10.value;          
document.getElementById("nronuevoa10").disabled = false;}





  function redireccionar(text){
             location.href= text;
             document.getElementById('div2').style.display = 'block'; 
        }
  

   </script>    

    <style type="text/css">
<!--
.Estilo4 {font-size: 24px}
#apDiv1 {
	position:absolute;
	left:446px;
	top:258px;
	width:17px;
	height:108px;
	z-index:1;
	overflow: visible;
}
.Estilo7 {font-size: 12px}
-->
    </style>
</head>
 
<body>  
        <%
 //  String  cod = "0010081655";
String campana = request.getParameter("campana");
String  cod = request.getParameter("codcli");
String Drop =  request.getParameter("Drop");
String manual =  request.getParameter("manual");
String valor= request.getParameter("valor");
String contador=  request.getParameter("contador");
String consultor=  request.getParameter("consultor");
String redire = request.getParameter("redire");
String otro=request.getParameter("otro");
String tacto=request.getParameter("Contacto");
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();


   


    //out.println(cod);

    Connection connection = oracleDaoLocalFactoryImpl.getSQLConextion();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection cn_gmrasca= sqlDaoRascalFactoryImpl.getSQLConextionRascal();


List<beanTelefonoClienteLista> Listobtienetelefono = sqlImplements.ObtenerTelefonoLista(cod,cn_gmrasca);
List<beanTelefonoParentesco>  ListaParentesco = oraCliente.ObtenerTelefonoParentesco(cod,connection);
List<beanTelefonoClienteLista>  ListaTelefono=sqlImplements.ObtenerTelefonoLista(cod,cn_gmrasca);
List<beanTelefonoAgregados>  ListaTelefonoAgregados=sqlImplements.ObtenerTelefonoAgregados(cod,cn_sql);
String Contacto=oraCliente.obtenerContacto(cod,connection);

String Contactomodificado=oraCliente.obtenerContactomodificado(cod, connection);
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
        
//       for (int i=0 ;  i <listClienteFonoLocal.size() ;i++ ){
     
           //fonolocal =  (beanClienteTelefonoLocal) listClienteFonoLocal.get(i);
      
       // Lnum1= fonolocal.getNumero1();
      //  Lnum2=fonolocal.getNumero2();
      //  Lnum3=    fonolocal.getNumero3();
      //  Lnum4= fonolocal.getNumero4();
      //  Lcodcli= fonolocal.getCodCliente();
      // }
     
  if(redire !=null) {
      
      
      %><body onload="redireccionar('#horaria')">
      <%
  }
  
  if(otro!=null){
%>

 <body onload="redireccionar('#numero')">
<%
  }
  if(tacto!=null){
      %>
 <body onload="redireccionar('#contacto')">     
      
      <%
  }
        %>
      <form id="form1" name="form1" method="post" action="InformacionCliente">
             <%  out.println("<input type='hidden' name='campana'  id='campana' value="    +"'"+ campana+"'"+   "/>"   );
                 out.println("<input type='hidden' name='GenCodigo'  id='GenCodigo' value=  "+"'"+cod+"'"+     "/>"  );
              %>
              
              
              <%--
                 if((contador==null|| contador.equals("")) &&(consultor==null || consultor.equals(""))){
                       
          
                 if(Integer.parseInt(contador) > 0 && consultor.equals("consultor")){
              %>
              <script language="javascript">
              valorcontador()
              </script>
              <%
                 }  } 
              
              --%>
              <input type='hidden' name='contador' id="contador" value='<%=contador%>'> 
<input type='hidden' name='consultor'  id="consultor"  value='<%=consultor%>' > 
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
             <input type='hidden' name='nombreantiguo'   id="nombreantiguo" />
             <input type='hidden' name='parentescoantiguo' id="parentescoantiguo" />
             <input type='hidden' name='telefonoSelect' > 
             <br>
             <br>
             <br>
              <br>
             <table width="1123">
<tr>
             <td width="1115" bgcolor="#97D4FE"> <span class="Estilo1 Estilo4"><strong>
             
             Actualización de Datos Cliente</strong>
</span></td>
       </tr>
     </table>
              <table width="947"  style="height: 500%"    id="AnotaPerso" name="AnotaPerso" >
    <tr>
    <a name="Telefono"></a>
      <td width="532" height="445"><strong>Teléfono y Contacto del Cliente
</strong>
     
          <table width="876" >
  <tr>
      <td width="839"> <div style="  border-style:solid ;  border-width: 1px;" >
        <table width="683" height="226" >
          <tr>
            <td width="114" rowspan="2">&nbsp;</td>
            <td width="144" rowspan="2"></td>
            <td width="65" rowspan="2" align="center">Modificar</td>
            <td width="59" rowspan="2" align="center" >Eliminar</td>
            <td width="63" rowspan="2" align="center">Guardar</td>
            <td width="2" rowspan="4"><div id="vertical-bar"></div></td>
            <td width="76" height="40">Nro Modificados</td>
            <td width="2" rowspan="3"><div id="vertical-bar2"></div></td>
            <td width="65">Nro Eliminados</td>
          </tr>
          <tr>
            <td>
<hr width="100%"></td>
            <td width="65"><hr width="100%"></td>
          </tr>
          <% for (int i = 0; i < ListaTelefono.size(); i++) {
                                    telefono = (beanTelefonoClienteLista) ListaTelefono.get(i);
                                   // telefonoagregado = (beanTelefonoAgregados) ListaTelefonoAgregados.get(i);
                   
String nro=    telefono.getNro()   ;//se capturar el nro para ver si vas ha ser modificado o eliminado        

                            %>
          <tr>
            <td>Telefono <%=i+1%></td>
            <td><input type="text" name="nronuevo<%=i+1%>" id="nronuevo<%=i+1%>" value="<%=telefono.getNro()%>"  disabled="disabled"  maxlength="9"   onKeyPress="return soloNumeros(event)" />            </td>
            <td onClick="modificanro<%=i+1%>()"  align="center"><img src="img/u13_normal.jpg" width="30" height="30" /></td>
            <td  onClick="elimination(<%=i+1%>)" align="center"><img src="img/u15_normal.jpg" width="30" height="30" /> </td>
            <td onClick="modificarx(<%=i+1%>)"  value ="modificarnro<%=i+1%>" align="center"><img src="img/u14_normal.jpg" width="30" height="30" /></td>
            <input type='hidden' name='accion'  id="accion"   />
            <input type='hidden' name='manual2'  id="manual"   />
            <% nro =telefono.getNro();
                              
                 String nromodificado=sqlImplements.obtenerNroModificado(nro,cod,cn_sql);
                 String nroeliminado=sqlImplements.obtenerNroEliminado(nro,cod,cn_sql);
                 
                 
                 //eliminarnromql
%>
            <td><%=nromodificado%> </td>
            <td><%=nroeliminado%> </td>
            <td width="30" onClick= "eliminitationa(<%=i+1%>)"><img src="img/u15_normal.jpg" width="30" height="30" /></td>
            <td width="15"></td>
            <input type='hidden' name='nroantiguo<%=i+1%>'  id="nroantiguo<%=i+1%>"      />
            <input type='hidden' name='nroeliminado<%=i+1%>'  id="nroeliminado<%=i+1%>" value="<%=telefono.getNro()%>"    />
            <input type='hidden' name='nromodificado<%=i+1%>'  id="nromodificado<%=i+1%>" value="<%=nromodificado%>"    />
            <%} int j=ListaTelefono.size()+1;%>
          </tr>
          <%     for (int i = 0; i < ListaTelefonoAgregados.size(); i++) {
                                    telefonoagregado = (beanTelefonoAgregados) ListaTelefonoAgregados.get(i);          
                   
                     
                   //   
                            %>
          <tr>
            <td>Telefono <%=j%></td>
            <td><input type="text" name="nronuevoa<%=i+1%>" id="nronuevoa<%=i+1%>" value="<%=telefonoagregado.getNro()%>"  disabled="disabled"  maxlength="9"   onKeyPress="return soloNumeros(event)" />            </td>
            <td onClick="modificanroagregado<%=i+1%>()"  align="center" ><img src="img/u13_normal.jpg" width="31" height="30" /></td>
            <td  onClick="eliminarnroagregado(<%=i+1%>)" align="center"><img src="img/u15_normal.jpg" width="30" height="30" /> </td>
            <td onClick="modificarnroagregado(<%=i+1%>)" align="center"><img src="img/u14_normal.jpg" width="30" height="30" /> </td>
            <td colspan="4"><span class="Estilo7">El Nro Sera Agregado </span></td>
            <input type='hidden' name='nroantiguoa<%=i+1%>'  id="nroantiguoa<%=i+1%>"      />
            <input type='hidden' name='nroeliminadoa<%=i+1%>'  id="nroeliminadoa<%=i+1%>" value="<%=telefonoagregado.getNro()%>"    />
          </tr>
          <%  j=j+1;} %>
          <tr id="div1"  style="display:none"  >
            <td>Ingresar Nro Nuevo:</td>
            <td><input type="text" width="90" name="nronuevo" id="nronuevo" maxlength="9" onKeyPress="return soloNumeros(event)"  /></td>
          </tr>
          <tr>
            <td>Contacto</td>
            <td><input type="text" name="contacto2" id="contacto" value="<%=Contacto%>" disabled="disabled"/></td>
            <td colspan="4" onClick="modificarcontacto"  align="center"><input type="submit" name="grabarcontacto" id="grabarcontacto" value="grabarcontacto"></td>
            <input type='hidden' name='contactoa'  id="contactoa"    />
          </tr>
          <tr>
            <td><center>
                <label>
                <input onClick ='AgregarNro()'type="button" name="button2" id="button2" value="Agregar Nro">
                </label>
            </center></td>
            <td><center>
                <label>
                <input type="submit"name="Grabar" id="Grabar" value="Grabar">
                </label>
            </center></td>
          </tr>
        </table>
      </div>

    <br>
    <strong>Otros Contactos</strong>
    
    
    <a name="contacto" ></a>
 <div  style="  border-style:solid ;  border-width: 1px;">
        <table width="738" >
            <br>
            <br>
  <tr>
    <td width="144">Telefono</td>
    <td colspan="2"><label>
              <input type="text" name="Telefono" id="Telefono"  maxlength="9" onKeyPress="return soloNumeros(event)"  />
            </label></td>
            
    <td width="133">&nbsp;</td>
  </tr>
  <tr>
    <td height="73">Relacion</td>
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
      
        
    <select name="parentesco" size="4" id="parentesco"  onchange="javascript:listado(this.value);"   >
     
        
                            <% 
                              
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
                <input type="submit" name="accionHtml" id="agregar" value="Agregar" />
              </div></td>
              
                <%if(parentesco!= null){%>
                
 <td width="144"><div align="center">
           <input  onclick="modificarparentesco('<%= parentesco.getNumero() %>','<%=parentesco.getParentesco()%>','<%= parentesco.getNombre()%>')"  type="button"  id="modificar" value="Modificar" />          
                  </div></td> 
<%}  else{ %>
              
    <td width="68"><div align="center">
          <input    type="button"  id="modificar" value="Modificar" />
              </div></td>
              
              <%  }   %>
              
              
    <td width="133"><div align="center">
                <input  type="submit" name="accionHtml" id="eliminar" value="Eliminar" />
              </div></td>
    <td width="225"><input onclick ="Limpiar()" type="button"  value="Limpiar" /></td>
  </tr>
</table>
        </div> 
    <br>
    <a name="horaria"></a>
       <strong>Ventana Horaria</strong>
        <div style=" border-style:solid ;  border-width: 1px;">
            <table width="837" >
          <tr>
            <td width="63">Rango de llamada</td>
            <td width="321"><label>
                    <% String Ventana=sqlImplements.VentanaHoraria(cod,cn_sql) ; %>
              <select name="rango" id="rango" ><% if(Ventana.equals("")){%>
                 <option value="">Selecciona Ventana Horaria  </option>  
            
      <% }else{ %>
      <option value="<%=Ventana%>"><%=Ventana%></option>
         <% } %>
          
                <option value="08:00:00-10:00:00 ">08:00:00-10:00:00 </option>
                 <option value="10:00:00-12:00:00">10:00:00-12:00:00</option>
                  <option value="12:00:00-14:00:00">10:00:00-14:00:00</option>
                   <option value="12:00:00-14:00:00">12:00:00-14:00:00</option>
                    <option value="14:00:00-16:00:00">14:00:00-16:00:00</option>
                     <option value="16:00:00-18:00:00">16:00:00-18:00:00</option>
                </select>
            </label></td>
            
             <td width="173">  <input type="submit" name="accionHtml" id="VentanaHoraria" value="GrabarVentanaHoraria" /></td>
           
              <% if(cod==null){}else{%>
           
              
              
             <% if(Ventana.equals("")){%>
             <td width="99"> No cuenta con ventana Horaria  el cliente : <%= beanClienteFono.getNombre()%>    <%= beanClienteFono.getApellido()%> </td>
             
                <% }else{ %>
                <td width="73" > Ventana Horaria : </td>
                
             <td width="70" > <%=Ventana%> </td>
             
             <% }} %>
          </tr>
        </table> 
      </div>
      <td width="25">&nbsp;</td>
    </tr>
  </table>
     

 <%-- MUESTRA LOS NROS DEL CLICK TO CALL  --%>  
 
 <div  id="div2" > 
 <table width="553" >
     <a name="manual"></a>
     <strong>Llamadas Manuales</strong>
    <tr>
      <td td width="312"><%if(beanClienteFono==null){%>
<center>
    <div  style="  border-style:solid ;  border-width: 1px;">
<table >
<tr>
<td>campaña</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>CodigoCliente</td>
<td>&nbsp;</td>
</tr>

<tr>
<td>Nombre y Apellido</td>
<td>&nbsp;</td>
</tr>
<tr>
      <td colspan="2">Teléfonos del Cliente</td>
</tr>

        
       <%-- <tr>
<td>Nro</td>
<td   name='nro'  onclick= 'clicktocall(<%= beanClienteFono.getNro()%>)'> <%=beanClienteFono.getNro()%> </td>
</tr>
--%>

      
<tr>
<td>Nro</td>
<td >&nbsp;</td>
</tr>
</table> </div></center>
<%}else {%>
<center>
    <table>
      <tr>
<td>Cliente:</td>
<td> <%= beanClienteFono.getNombre()%>    <%= beanClienteFono.getApellido()%> </td>
</tr>  
        
    </table>
    <div  style="  border-style:solid ;  border-width: 1px;">
<table >

    <td colspan="2"align="center" >Teléfonos del Cliente</td>
   
      <td width="88" align="center"> <font style="color: red">  Cant</td>
</tr>
<%
 //int var=0;
for (int i = 0; i < Listobtienetelefono.size(); i++) {
  beanClienteFono = (beanTelefonoClienteLista) Listobtienetelefono.get(i);
 //String  varia=beanClienteFono.getNro() ;
  //out.print(varia);
        %>

        
       <%-- <tr>
<td>Nro</td>
<td   name='nro'  onclick= 'clicktocall(<%= beanClienteFono.getNro()%>)'> <%=beanClienteFono.getNro()%> </td>
</tr>
--%>

      
<tr>
<td width="122">Nro<%=i+1%>.-</td>
<td width="100"  onclick= 'clicktocall(<%= beanClienteFono.getNro()%>)'> 9<%=beanClienteFono.getNro() %> </td>
<p></p>
<%  int h;
int z=0;
 String s="" ;
  List numero= sqlImplements.ListaNumeroContador(beanClienteFono.getCodCliente().toString(), beanClienteFono.getNro().toString() ,cn_sql);

%>

<%     
        
       
  for( h =0; h<numero.size();h++ ){
      
    
%>      

<%        
              
             
%>
<td><%=numero.get(z) %></td>
<%
 z++;
 break;
  }
  
%>
</tr>

<%}%>
<input type='hidden' name='CodClienteDetalle' value='<%=beanClienteFono.getCodCliente()%>'> 
</table> </div></center>
<%}%>   </td>
 <td width="18"> </td>
 <td width="207"> 
 <center>
     <div  style="  border-style:solid ;  border-width: 1px;">
         <table >
<tr>
<td height="21" colspan="2"  >Otros Contactos</td> 
</tr>


 <%if(ListaParentesco==null){%>

<tr> 
<td width="40"></td>
<td width="127"></td>
</tr>
<%}else{%>
<% for (int i = 0; i < ListaParentesco.size(); i++) {
parentesco = (beanTelefonoParentesco) ListaParentesco.get(i);
%>




<tr> 
<td> <%=parentesco.getParentesco()%></td>

<td   onclick= 'clicktocall(9<%= parentesco.getNumero()%>)' > 9<%= parentesco.getNumero()%></td>
</tr>


<%}}%> 
</table>
     </div>
 </center>
      </td>
    </tr>
    <tr>
        <td colspan="3">
            <br>
            <br>
            <strong>Otro Número</strong>
            
            <div  style="  border-style:solid ;  border-width: 1px;width:420px  "><table>
<tr>
<td width="239">
Ingresar Numero: 
  <input type="text" id ="numerox" name="numerox" size="12" maxlength="9">
</td>
<td width="63"> <input type="submit" value="Llamar" name="accionHtml" onClick="fllamar()"></td></tr>
<tr>
<td>Esta seguro de Llamar a este Nro?</td>
<% String variable = request.getParameter("numeroclicktocholl");
if(variable==null){ variable="";}else{}

if(beanClienteFono==null){%>
<td></td> backusa


<% }else{%>


<td width="102" onclick= 'clicktocall(<%=variable%>)'>    <%=variable%>  </td> 
<% }%>

</tr>


                </table></div> </td>
    </tr>
 </table></div>



</table>



</form>



<%  if(Drop!=null ){  %>
<script type="text/javascript">
document.getElementById('div2').style.display = 'block';   
</script>
<%}if(valor!=null){%>
<script type="text/javascript">
 document.getElementById('div2').style.display = 'none'; 
</script><%}%>                     
</body>
</html>

   
