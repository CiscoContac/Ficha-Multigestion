<%--  
    Document   : CONSULTOR
    Created on : 27/11/2013, 02:31:24 PM
    Author     : GMD
--%>

<%@page import="com.pe.backus.dto.beanInformacionCliente"%>
<%@page import="com.pe.backus.dto.beanSeguimientoCampana"%>
<%@page import="com.pe.backus.dto.beanSeguimientoCampana"%>
<%@page import="com.pe.backus.dto.beanResumenCamp"%>
<%@page import="com.pe.backus.dto.beanResuLLamada"%>
<%@page import="com.pe.backus.factory.sqlDaoRascal2FactoryImpl"%>
<%@page import="com.pe.backus.dto.beanBonificacion"%>
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
 <%response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache"); 
response.setDateHeader("Expires", 0); 
 %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
    <title>Información General</title>
    <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
    <script src="js/consultor.js"></script>
    <script src="js/Resultado.js"></script>
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
 .div6 {
   overflow-y: auto;
   overflow-x: hidden;
   height:80px;
      }
   
      #div66 {
         
   overflow:scroll;
   height:250px;
   width: 1301px;
   
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
    
#divbonifi {
         
   overflow:scroll;
   height:150px;
   width: 550px;
   
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
       String xcodigo= request.getParameter("xcodigo");
        if(xcodigo==null){xcodigo="";}  
        
        
        
        

       String  campa  =  request.getParameter("campana");//campaña de agente
       String capaign=  request.getParameter("campa");//c
      String refere=  request.getParameter("refere");
    
       String graba =request.getParameter("graba");
       String actualiza= request.getParameter("actualiza");

 
Connection orasql= oraclefactooriginal.getSQLConextion();//conexion a oracle 
 Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();

 /////////////////////////VALORES DE RESULTADO/////////////////////////////////////////////////////////////////      
    clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();

Connection  Diario_cn = sqlDaoRascalFactoryImpl.getSQLConextionRascal();


List<beanResuLLamada>  Lstresultado = sqlImplements.obtenerResultadoLlamada(xcodigo, Diario_cn);
List<beanResuLLamada>  Lstresultadohisto=sqlImplements.obtenerResultadoLlamadaHsitorico(xcodigo,cn_sql);

List NoContacto=sqlImplements.RazonesNoContacto(cn_sql);
List NoVenta=sqlImplements.RazonesNoVenta(cn_sql);
List TipoGest= sqlImplements.tipogestion(cn_sql);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
          SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy' 'HH':'mm':'ss");
       Date fechaDate = new Date();
        String fecha=formateador.format(fechaDate);

 
   DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
        DecimalFormat formatnumero = new DecimalFormat("###,###.##",simbolo);
    
 %>
  

<form name="form1">
    <%  out.println("<input type='hidden' name='campa'  id='campa'  value = "+"'"+campa+"'"+"/>"); %>
     <input type='hidden' name='campaign' id='campaign'  value="<%=capaign%>" >
       <input type="hidden" name="codigo" id="codigo" value="<%=xcodigo%>">
         <input TYPE="hidden" name="graba" id="graba"    value="<%=graba%>">
<input type="hidden" name="GrabaAnotacion" />
<table  border="0">

    
 
      <tr>
        <td height="28"  colspan="3"    bgcolor="#97D4FE">
        <span class="Estilo2">Gesti&oacute;n de Ventas</span>       </td>
      </tr>
      
     <td height="163" colspan="3"  valign="top"> 
        <table width="1131" border="0">
          <tr>
            <td width="439"><span class="Estilo4">
                    <%List<beanSeguimientoCampana> seguimiento = sqlCliente.Seguimiento(xcodigo.trim(), cn_rascalLocal); 
                        beanSeguimientoCampana SegCampa = null;
                    %>         
                    Seguimiento de Campana
                    <table id="tbSeguimiento" name="tbSeguimiento" border="1">
                        <thead>
                            <tr>
                                <th bgcolor="#DBDBDB" class="Estilo4">Nombre Producto</th>
                                <th bgcolor="#DBDBDB" class="Estilo4">Marca</th>
                                <th bgcolor="#DBDBDB" class="Estilo4">Cuota</th>   
                                <th bgcolor="#DBDBDB" class="Estilo4">Avance</th>  
                                <th bgcolor="#DBDBDB" class="Estilo4">Saldo</th>  
                            </tr>
                        </thead>
                        <tbody>
                            
                            
                            
                            <%
                        if(seguimiento==null){
                            %>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                            <%
                        }else{
                        
                        
                        
                        
                        for(int j =0 ; j<seguimiento.size();j++){
                                SegCampa=(beanSeguimientoCampana) seguimiento.get(j);
                            
                            %>
                            <tr>
                                <td><%=SegCampa.getNombreProducto()%></td>
                                <td><%=SegCampa.getMarca()%></td>
                                <td><%=SegCampa.getCuota()%></td>
                                <%if(SegCampa.getAvance()==null){ %>
                                    
                                     <td> 0 </td>
                              <%  }else{  %>
                                     <td><%=SegCampa.getAvance()%></td>
                                    
                              <%      
                                } %>
                               
                                
                             <%  
                                if(SegCampa.getSaldo()==null){  %>
                                    
                                 <td> 0 </td>   
                               <% }else{ %>
                                    
                                      <td><%=SegCampa.getSaldo()%></td>
                                    
                              <%  }
                             %>   
                              
                                
                            </tr>
                            
                            <%}
                            
                        }%>
                            
                            
                            
                            
                            
                        </tbody>
                    </table>
                    
                        <br>
                        <br>
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
             <td width="300"> 
                 <% List <beanInformacionCliente> listainfor = sqlCliente.CAMPANAInformacion(xcodigo.trim(), cn_rascalLocal);
                 beanInformacionCliente info=null;
                 %>
             Observaciones
                 <table  border="1">
                     <thead>
                     <th  bgcolor="#DBDBDB" >Mensaje Informativo</th>
                     <th  bgcolor="#DBDBDB" >Inicio</th>  
                     <th  bgcolor="#DBDBDB" >Fin</th>  
                     </thead>
                     <tbody>
                                   
                            <%
                        if(listainfor==null){
                            %>
                            <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                            </tr>
                            <% }else{ %>
                         <%for (int j = 0; j < listainfor.size(); j++) {
                                 info = (beanInformacionCliente) listainfor.get(j);
                         %>

                         <tr>
                             <td><%=info.getMensaje()%> </td>
                             <td><%=info.getInicio()%> </td>
                             <td><%=info.getFin()%> </td>
                         </tr>



                         <%
                                 }
                         
                         
                        }%>



                     </tbody>

                 </table>
                 
             </td>
                  </tr>        
            </table>      
                        <br>
                        <br>
         </span>
                
         <p ><span><strong class="Estilo4"> <span class="Estilo4">Hist&oacute;rico Venta - Cobetura (Cajas Equivalentes)</span></strong></span> </p>
        <span class="Estilo4">
        <%
 
    int contacion1=    oraCliente.contadorproductos(xcodigo, orasql);
    if(contacion1!=0){%>
   
 
        <% int valor=0;
     
 
     List semaaño= oraCliente.obtenesemanaAño(xcodigo,orasql);
     if(semaaño.size()!=0 ){
     List Categoria=oraCliente.descripcionCategoria(xcodigo,orasql);
     
     
     Integer cantidad =semaaño.size();
     Integer NroCategoria =Categoria.size();      
     
     
     
     if(cantidad==0){
             }else {
              
         
         
               int xvalorx=0;
               
         
              
       String sumatori6;
       String sumatori5;
       String sumatori4  ;
       String sumatori3; 
       String sumatori2;  
             String sumatori1 ;  
           
                 
               
                 String Año1;
                  String Año2;
                   String Año3;
                    String Año4;
                     String Año5;
                      String Año6;
                      
                       
                //Declaracion de variables para lops meses
                      
                
                  
                String Mes1="";
                  String Mes2="";
                   String Mes3="";
                    String Mes4="";
                     String Mes5="";
                      String Mes6="";   
                  
        String sem1 = oraCliente.semanasmaxima(xvalorx+35, orasql);
       ///System.out.println("valorr "+sem1);
     Año1= sem1.substring(0, 4);
     String semvalida1= sem1.substring(4,5);
        ////System.out.println"valorr de semananaaaa"+ sem5.substring(5,6)  );
      if(semvalida1.equals("0")){
        sem1='S'+sem1.substring(5,6);
      }else{
       sem1='S'+sem1.substring(4);
      }
       //sem1='S'+sem1.substring(4);
  
         String sem2=  oraCliente.semanasmaxima(xvalorx+28, orasql);
           ///System.out.println("valorr "+sem2);
          Año2=  sem2.substring(0, 4);
          String semvalida2= sem2.substring(4,5);
        ////System.out.println"valorr de semananaaaa"+ sem5.substring(5,6)  );
      if(semvalida2.equals("0")){
        sem2='S'+sem2.substring(5,6);
      }else{
       sem2='S'+sem2.substring(4);
      }
        // sem2='S'+sem2.substring(4);
        
         String sem3=  oraCliente.semanasmaxima(xvalorx+21, orasql);
           ///System.out.println("valorr "+sem3);
         Año3= sem3.substring(0, 4);
         String semvalida3= sem3.substring(4,5);
        ////System.out.println"valorr de semananaaaa"+ sem5.substring(5,6)  );
      if(semvalida3.equals("0")){
        sem3='S'+sem3.substring(5,6);
      }else{
       sem3='S'+sem3.substring(4);
      }
         ///sem3='S'+sem3.substring(4);
     
       String sem4=  oraCliente.semanasmaxima(xvalorx+14, orasql) ;
         ///System.out.println("valorr "+sem4);
       Año4=sem4.substring(0, 4);
        String semvalida4= sem4.substring(4,5);
        ////System.out.println"valorr de semananaaaa"+ sem5.substring(5,6)  );
      if(semvalida4.equals("0")){
        sem4='S'+sem4.substring(5,6);
      }else{
       sem4='S'+sem4.substring(4);
      }
     
      /// sem4='S'+sem4.substring(4);
     
       String sem5= oraCliente.semanasmaxima(xvalorx+7, orasql);
        
      Año5=sem5.substring(0, 4);
      String semvalida5= sem5.substring(4,5);
        ////System.out.println("valorr de semananaaaa"+ sem5.substring(5,6)  );
      if(semvalida5.equals("0")){
        sem5='S'+sem5.substring(5,6);
      }else{
       sem5='S'+sem5.substring(4);
      }
     
     
     
      String sem6=   oraCliente.semanasmaxima(xvalorx, orasql);
      
      Año6=sem6.substring(0, 4);
       String semvalida6= sem6.substring(4,5);
      System.out.println("valorr "+semvalida6);
       if(semvalida6.equals("0")){
        sem6='S'+sem6.substring(5,6);
      }else{
       sem6='S'+sem6.substring(4);
      }
      ///sem6='S'+sem6.substring(4);
      
      
      for (int n=1; n<7;n++){
     if(n==1 ) {
          
          
      List mesletra = oraCliente.ObtenerMes(xcodigo, ""+35, orasql);
      
      Mes1= mesletra.get(0).toString();
      
      }else if(n==2){
          
           List mesletra = oraCliente.ObtenerMes(xcodigo, ""+28, orasql);
      
      Mes2= mesletra.get(0).toString();
      }else if (n==3){
      List mesletra = oraCliente.ObtenerMes(xcodigo,""+21 ,orasql);
      Mes3= mesletra.get(0).toString();
      }else if (n==4){
           List mesletra = oraCliente.ObtenerMes(xcodigo, ""+14, orasql);
      Mes4= mesletra.get(0).toString();
      }else if (n==5){
      List mesletra = oraCliente.ObtenerMes(xcodigo, ""+7, orasql);
      Mes5= mesletra.get(0).toString(); 
      }else if(n==6){
      List mesletra = oraCliente.ObtenerMes(xcodigo, ""+0, orasql);
      Mes6= mesletra.get(0).toString();  
      }
      
      
      
      }//cierra el for
     
     
     %>
        </span>
        <table  border="1" >  
                            
            <tr> <td colspan="4"></td><td bgcolor="#00006C" style="color: #ffffff;text-shadow: calc" align="center"><strong><%=Mes1%></strong></td><td bgcolor="#00006C" style="color: #ffffff" align="center"><%=Mes2%></td><td  bgcolor="#00006C" style="color: #ffffff" align="center"><%=Mes3%></td><td  bgcolor="#00006C" style="color: #ffffff" align="center"><%=Mes4%></td><td bgcolor="#00006C" style="color: #ffffff" align="center"><%=Mes5%></td><td bgcolor="#00006C" style="color: #ffffff" align="center"><%=Mes6%></td></tr>
            
            <tr>

                <td bgcolor="#DBDBDB" class="Estilo4"  >Categoria</td><td bgcolor="#DBDBDB" class="Estilo4">Marca</td><td bgcolor="#DBDBDB" class="Estilo4">Capacidad</td><td bgcolor="#DBDBDB" class="Estilo4">Envase</td><td class="Estilo4" bgcolor="#00006C" style="color: #ffffff ; width:100px" align="center"><%=Año1%> - <%=sem1%></td><td  bgcolor="#00006C" style="color: #ffffff; width: 100px" align="center" class="Estilo4" ><%=Año2%> - <%=sem2%></td><td  bgcolor="#00006C" style="color: #ffffff;width: 100px" align="center" class="Estilo4" ><%=Año3%> - <%=sem3%></td><td bgcolor="#00006C" style="color: #ffffff;width:100px "  align="center" class="Estilo4" ><%=Año4%> - <%=sem4%></td><td bgcolor="#00006C" style="color: #ffffff;width: 100px" class="Estilo4"  align="center" ><%=Año5%> - <%=sem5%></td><td  bgcolor="#00006C" style="color: #ffffff;width: 100px" class="Estilo4" align="center" ><%=Año6%> - <%=sem6%></td></tr>
                
          <%
              String cat1="";
                      String cat2="";
                      String cat3="";
                      String cat4="";
              
             cat1=Categoria.get(0).toString();
            if(NroCategoria>=2){
            cat2=Categoria.get(1).toString();}
            if(NroCategoria>=3){
             cat3=Categoria.get(2).toString();}
            if(NroCategoria==4){
            cat4=Categoria.get(3).toString();}
     
     if(cat1!=null && cat1!=""){
     List listacat1= oraCliente.ObtenerTablaDinamica6(sem1,sem2,sem3,sem4,sem5,sem6,cat1,xcodigo,orasql);
    List listasumcat1= oraCliente.SumatoriadeCajaEquivalente6(sem1,sem2,sem3,sem4,sem5,sem6,cat1,xcodigo,orasql);
     
     beanSumatoriaSemanas sumatoria=null;
     beantabladinamica tabladinamica=null;
     beansemaxprod    sumaxproducto=null;
     tabladinamica=(beantabladinamica)listacat1.get(0);
     String xproduc = tabladinamica.getDesmarca();
     
     
      List listasumxprodu= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,xproduc,xcodigo,orasql);
         
      sumaxproducto = (beansemaxprod)  listasumxprodu.get(0);
       String  semana1=tabladinamica.getSemana1();
       
       String semana2=tabladinamica.getSemana2();
     String semana3=tabladinamica.getSemana3();
     String semana4=tabladinamica.getSemana4();
     String semana5=tabladinamica.getSemana5();
     
     String semana6=tabladinamica.getSemana6();
     
     if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
     
    /// Double s=0.000;
     
     if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }     
            int xsuma;
       int xvalor =   oraCliente.listaSumaCapacidad(xcodigo,cat1,orasql);
       
       int xcanval= oraCliente.sumaDesmarca(xcodigo,cat1,orasql);
       
       xsuma= (xvalor+xcanval);
                  %>
     
     
     <tr><td rowspan="<%=xsuma%>" class="Estilo4"  ><%=tabladinamica.getDescategoria()%></td><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
     
     
     <%
      int conta=0;
      int xcount=0;
      int yycount = 0 ;
        conta = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
     if (conta==1){
     
     %>
     
     <tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td  bgcolor="#FFFF8A"     align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td align="center"  bgcolor="#FFFF8A"     class="Estilo4"><%=sumaxproducto.getSem2() %></td><td  bgcolor="#FFFF8A"     align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td   bgcolor="#FFFF8A"     align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"     align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"     align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
     
     
     <%
     
     }else{
         xcount++;
         yycount++;
     }
     
     String Kprod="";
     tabladinamica=(beantabladinamica)listacat1.get(0);
      Kprod=tabladinamica.getDesmarca();
     String prod="";
     
     
     
     
     for( int h=1;h<listacat1.size();h++){
     tabladinamica=(beantabladinamica)listacat1.get(h);
     prod= tabladinamica.getDesmarca();
      semana1=tabladinamica.getSemana1();
      semana2=tabladinamica.getSemana2();
      semana3=tabladinamica.getSemana3();
      semana4=tabladinamica.getSemana4();
     semana5=tabladinamica.getSemana5();
     semana6=tabladinamica.getSemana6();
     if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }     
     %>
     <tr><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align ="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
    
     <%
     
     int xxcont = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
     
     if (xxcont <=1){ 
     
           if(Kprod.equals(prod) ){       
               
               xcount ++  ;
           if(xxcont == xcount ) {
               List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
              for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
           if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
     
         %>
         
       <tr><td colspan="3"  bgcolor="#FFFF8A"   class="Estilo4" >Total por Producto</td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
         
         <%
        }
           }
          
           }else{
               
              List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
         if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         
         %>
         
      <tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
         <%
         
        }
      }
     }else{
          yycount++;
         
         if(xxcont == yycount ){
            List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
         if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
     
        %>
        
       <tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>       
     
        
       <% 
         
         }
        yycount=0;
     }
      
     }
       Kprod=tabladinamica.getDesmarca();
     
       }
     for( int a=0;a<listasumcat1.size();a++){
     sumatoria=(beanSumatoriaSemanas)listasumcat1.get(a);
     sumatori1=sumatoria.getSem1();
     if(sumatori1==null){
     sumatoria.setSem1("&nbsp;");
     }else{
         String st1= sumatoria.getSem1();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem1(st1); 
         }
     }
     sumatori2=sumatoria.getSem2();
     if(sumatori2==null){
     sumatoria.setSem2("&nbsp;");
     }else{
       String st1= sumatoria.getSem2();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem2(st1); 
         }  
     }
     sumatori3=sumatoria.getSem3();
     if(sumatori3==null){
     sumatoria.setSem3("&nbsp;");
     }else{
         String st1= sumatoria.getSem3();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem3(st1); 
         }
     }
     sumatori4=sumatoria.getSem4();
     if(sumatori4==null){
     sumatoria.setSem4("&nbsp;");
     }else{
      String st1= sumatoria.getSem4();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem4(st1); 
         }   
     }
     sumatori5=sumatoria.getSem5();
     if(sumatori5==null){
     sumatoria.setSem5("&nbsp;");
     }else{
       String st1= sumatoria.getSem5();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem5(st1); 
         }  
     }
     sumatori6=sumatoria.getSem6();
     if(sumatori6==null){
     sumatoria.setSem6("&nbsp;");
     }else{
         String st1= sumatoria.getSem6();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem6(st1); 
         }
     }
     %>
     
     
       <tr><td colspan="4" bgcolor="#00006C" style="color: #ffffff"  class="Estilo4">Total por Categoría</td>     <td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem1()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem2()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem3()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem4()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem5()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem6()%></td></tr>
       
     <%
     }
     }  %>
     
     
      <%if(cat2!=null  && cat2!=""){
     List listacat2= oraCliente.ObtenerTablaDinamica6(sem1,sem2,sem3,sem4,sem5,sem6,cat2,xcodigo,orasql);
     List listasumcat2= oraCliente.SumatoriadeCajaEquivalente6(sem1,sem2,sem3,sem4,sem5,sem6,cat2,xcodigo,orasql);
     
     beanSumatoriaSemanas sumatoria=null;
     beantabladinamica tabladinamica=null;
     beansemaxprod    sumaxproducto=null;
     tabladinamica=(beantabladinamica)listacat2.get(0);
     
     
     String xproduc = tabladinamica.getDesmarca();
     
     
      List listasumxprodu= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,xproduc,xcodigo,orasql);
         
      sumaxproducto = (beansemaxprod)  listasumxprodu.get(0);
      
       String semana1=tabladinamica.getSemana1();
     String semana2=tabladinamica.getSemana2();
     String semana3=tabladinamica.getSemana3();
     String semana4=tabladinamica.getSemana4();
     String semana5=tabladinamica.getSemana5();
     String semana6=tabladinamica.getSemana6();
     
     if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
     
     
     
     if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }     
          int xsuma;
       int xvalor =   oraCliente.listaSumaCapacidad(xcodigo,cat2,orasql);
       
       int xcanval= oraCliente.sumaDesmarca(xcodigo,cat2,orasql);
       
       xsuma= (xvalor+xcanval);
       
     %>
     
     
   <tr><td rowspan="<%=xsuma%>" class="Estilo4"  ><%=tabladinamica.getDescategoria()%></td><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
     
     
     <%
      int conta=0;
      int yycount=0;
      int xcount=0;
        conta = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
     if (conta==1){
     
     %>
     
        <tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>       
     
     
     <%    
     }else{
         xcount++;
         yycount++;
     }
     
     String Kprod="";
     
     tabladinamica=(beantabladinamica)listacat2.get(0);
      Kprod=tabladinamica.getDesmarca();
      
     String prod="";
     
     for( int h=1;h<listacat2.size();h++){
     tabladinamica=(beantabladinamica)listacat2.get(h);
      prod= tabladinamica.getDesmarca();
     semana1=tabladinamica.getSemana1();
     semana2=tabladinamica.getSemana2();
     semana3=tabladinamica.getSemana3();
      semana4=tabladinamica.getSemana4();
     semana5=tabladinamica.getSemana5();
     semana6=tabladinamica.getSemana6();
     if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }     
     %>
    
      <tr><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align ="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
    
     <%
     
     int xxcont = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
     
     if (xxcont <=1){ 
     
           if(Kprod.equals(prod) ){
               
         //  int xxcont = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
            xcount ++  ;
            
           if(xxcont == xcount ) {
               List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
              for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
         if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         %>
       <tr><td colspan="3" bgcolor="#FFFF8A"   class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td bgcolor="#FFFF8A" align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
         <%
          yycount=0;
      xcount=0;
        }
           }
           }else{
               
               
               
           
              List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
         
         if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         %>
         
        <tr><td colspan="3"   bgcolor="#FFFF8A"  class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"    align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         <%
          yycount=0;
      xcount=0;
        }
        
        
      }
     }else{
        yycount++;
         
         if(xxcont == yycount ){
            List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
         
          if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         
        %>
        
        
           
     <tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
      <% 
      yycount=0;
      xcount=0;
      
        }
     }
     }
      
      
       Kprod=tabladinamica.getDesmarca();
     
       }
     for( int a=0;a<listasumcat2.size();a++){
     sumatoria=(beanSumatoriaSemanas)listasumcat2.get(a);
      sumatori1=sumatoria.getSem1();
     if(sumatori1==null){
     sumatoria.setSem1("&nbsp;");
     }else{
         String st1= sumatoria.getSem1();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem1(st1); 
         }
     }
     sumatori2=sumatoria.getSem2();
     if(sumatori2==null){
     sumatoria.setSem2("&nbsp;");
     }else{
       String st1= sumatoria.getSem2();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem2(st1); 
         }  
     }
     sumatori3=sumatoria.getSem3();
     if(sumatori3==null){
     sumatoria.setSem3("&nbsp;");
     }else{
         String st1= sumatoria.getSem3();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem3(st1); 
         }
     }
     sumatori4=sumatoria.getSem4();
     if(sumatori4==null){
     sumatoria.setSem4("&nbsp;");
     }else{
      String st1= sumatoria.getSem4();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem4(st1); 
         }   
     }
     sumatori5=sumatoria.getSem5();
     if(sumatori5==null){
     sumatoria.setSem5("&nbsp;");
     }else{
       String st1= sumatoria.getSem5();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem5(st1); 
         }  
     }
     sumatori6=sumatoria.getSem6();
     if(sumatori6==null){
     sumatoria.setSem6("&nbsp;");
     }else{
         String st1= sumatoria.getSem6();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem6(st1); 
         }
     }
     
     %>
     
     
    <tr><td colspan="4" bgcolor="#00006C" style="color: #ffffff"  class="Estilo4">Total por Categoría</td>     <td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem1()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem2()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem3()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem4()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem5()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem6()%></td></tr>
       
     <%
     }
     }  %>
     
     <%if(cat3!=null && cat3!=""){
     List listacat3= oraCliente.ObtenerTablaDinamica6(sem1,sem2,sem3,sem4,sem5,sem6,cat3,xcodigo,orasql);
     List listasumcat3= oraCliente.SumatoriadeCajaEquivalente6(sem1,sem2,sem3,sem4,sem5,sem6,cat3,xcodigo,orasql);
     
     beanSumatoriaSemanas sumatoria=null;
     beantabladinamica tabladinamica=null;
     beansemaxprod    sumaxproducto=null;
     
     tabladinamica=(beantabladinamica)listacat3.get(0);
     
     
     
     String xproduc = tabladinamica.getDesmarca();
     
     
      List listasumxprodu= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,xproduc,xcodigo,orasql);
         
      sumaxproducto = (beansemaxprod)  listasumxprodu.get(0);
      
       String  semana1=tabladinamica.getSemana1();
     String semana2=tabladinamica.getSemana2();
     String semana3=tabladinamica.getSemana3();
     String semana4=tabladinamica.getSemana4();
     String semana5=tabladinamica.getSemana5();
     String semana6=tabladinamica.getSemana6();
     
        if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
    if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }
     int xsuma;
       int xvalor =   oraCliente.listaSumaCapacidad(xcodigo,cat3,orasql);
       
       int xcanval= oraCliente.sumaDesmarca(xcodigo,cat3,orasql);
       
       xsuma= (xvalor+xcanval);
     %>
     
    <tr><td rowspan=<%=xsuma%> class="Estilo4"  ><%=tabladinamica.getDescategoria()%></td><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
     
     <%
      int conta=0;
      int xcount=0;
      int  yycount=0;
        conta = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);

     if (conta==1){
     
     %>
     
   <tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
     <%
         
         
         
         }else{
         xcount++;
         yycount++;
     }
     
     String Kprod="";
     tabladinamica=(beantabladinamica)listacat3.get(0);
      Kprod=tabladinamica.getDesmarca();
     String prod="";
     
     
         for( int h=1;h<listacat3.size();h++){
     tabladinamica=(beantabladinamica)listacat3.get(h);
     prod= tabladinamica.getDesmarca();/** captura el producto*/
      semana1=tabladinamica.getSemana1();
     semana2=tabladinamica.getSemana2();
      semana3=tabladinamica.getSemana3();
     semana4=tabladinamica.getSemana4();
      semana5=tabladinamica.getSemana5();
      semana6=tabladinamica.getSemana6();
    if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }
     %>
    
   <tr><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align ="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
    
     <%
     
     int xxcont = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
     
     if (xxcont <=1){ 
     
           if(Kprod.equals(prod) ){
               
           //int xxcont = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
            xcount ++  ;
            
           if(xxcont == xcount ) {
               List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
              for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
        if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         %>
         
<tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
         
         <%
        }
               xcount=0;
           }
           
           }else{
              List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
           if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         
         %>
<tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
     
     
     <%
        }
          }
           xcount=0;
     }else{
       yycount++;
        if(xxcont == yycount ){
            List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
          if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
        %>
<tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
      <%   
        }
       yycount=0;  
        }
        
        
         
         
     }  
          Kprod=tabladinamica.getDesmarca();  
       }
     for( int a=0;a<listasumcat3.size();a++){
     sumatoria=(beanSumatoriaSemanas)listasumcat3.get(a);
     sumatori1=sumatoria.getSem1();
     if(sumatori1==null){
     sumatoria.setSem1("&nbsp;");
     }else{
         String st1= sumatoria.getSem1();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem1(st1); 
         }
     }
     sumatori2=sumatoria.getSem2();
     if(sumatori2==null){
     sumatoria.setSem2("&nbsp;");
     }else{
       String st1= sumatoria.getSem2();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem2(st1); 
         }  
     }
     sumatori3=sumatoria.getSem3();
     if(sumatori3==null){
     sumatoria.setSem3("&nbsp;");
     }else{
         String st1= sumatoria.getSem3();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem3(st1); 
         }
     }
     sumatori4=sumatoria.getSem4();
     if(sumatori4==null){
     sumatoria.setSem4("&nbsp;");
     }else{
      String st1= sumatoria.getSem4();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem4(st1); 
         }   
     }
     sumatori5=sumatoria.getSem5();
     if(sumatori5==null){
     sumatoria.setSem5("&nbsp;");
     }else{
       String st1= sumatoria.getSem5();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem5(st1); 
         }  
     }
     sumatori6=sumatoria.getSem6();
     if(sumatori6==null){
     sumatoria.setSem6("&nbsp;");
     }else{
         String st1= sumatoria.getSem6();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem6(st1); 
         }
     }
     
     %>
     
     
      <tr><td colspan="4" bgcolor="#00006C" style="color: #ffffff"  class="Estilo4">Total por Categoría</td>     <td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem1()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem2()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem3()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem4()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem5()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem6()%></td></tr>
      
     <%
     }
     
     }
      
     
     if(cat4!=null  && cat4!=""){
     List listacat4= oraCliente.ObtenerTablaDinamica6(sem1,sem2,sem3,sem4,sem5,sem6,cat4,xcodigo,orasql);
     List listasumcat4= oraCliente.SumatoriadeCajaEquivalente6(sem1,sem2,sem3,sem4,sem5,sem6,cat4,xcodigo,orasql);
     
     beanSumatoriaSemanas sumatoria=null;
     
     
     beantabladinamica tabladinamica=null;
     
     beansemaxprod    sumaxproducto=null;
     
     
     tabladinamica=(beantabladinamica)listacat4.get(0);
     String xproduc = tabladinamica.getDesmarca();
     
     
     
      List listasumxprodu= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,xproduc,xcodigo,orasql);
         
      sumaxproducto = (beansemaxprod)  listasumxprodu.get(0);
     
     
       String  semana1=tabladinamica.getSemana1();
     String semana2=tabladinamica.getSemana2();
     String semana3=tabladinamica.getSemana3();
     String semana4=tabladinamica.getSemana4();
     String semana5=tabladinamica.getSemana5();
     String semana6=tabladinamica.getSemana6();
     
       if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
     if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }
     int xsuma;
       int xvalor =   oraCliente.listaSumaCapacidad(xcodigo,cat4,orasql);
       
       int xcanval= oraCliente.sumaDesmarca(xcodigo,cat4,orasql);
       
       xsuma= (xvalor+xcanval);
     %>
     
     
    <tr><td rowspan=<%=xsuma%> class="Estilo4"  ><%=tabladinamica.getDescategoria()%></td><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
     
     <%
      int conta=0;
      int xcount=0;
      int  yycount=0;
        conta = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
     if (conta==1){
     
     %>
     
<tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
     <%
     }else{
         
         xcount++;
         yycount++;
     }
         
         String Kprod="";
     tabladinamica=(beantabladinamica)listacat4.get(0);
      Kprod=tabladinamica.getDesmarca();
     String prod="";
     
         
         for( int h=1;h<listacat4.size();h++){
     tabladinamica=(beantabladinamica)listacat4.get(h);
     prod= tabladinamica.getDesmarca();/** captura el producto*/
      semana1=tabladinamica.getSemana1();
     semana2=tabladinamica.getSemana2();
      semana3=tabladinamica.getSemana3();
      semana4=tabladinamica.getSemana4();
      semana5=tabladinamica.getSemana5();
      semana6=tabladinamica.getSemana6();
    if(semana1==null){
         tabladinamica.setSemana1("&nbsp;");
       
   
     }else{
         String s1= tabladinamica.getSemana1();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana1(s1); 
         }
         
     }
     
     
     if(semana2==null){
        tabladinamica.setSemana2("&nbsp;");
     }else{
          String s1= tabladinamica.getSemana2();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana2(s1); 
         }
     }
     
     if(semana3==null){
        tabladinamica.setSemana3("&nbsp;");
     } else{
         String s1= tabladinamica.getSemana3();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana3(s1); 
         }
     }
            
     if(semana4==null){
        tabladinamica.setSemana4("&nbsp;");
     }else{
     String s1= tabladinamica.getSemana4();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana4(s1); 
         }
     
     }
     
       if(semana5==null){
        tabladinamica.setSemana5("&nbsp;");
       }else{
            String s1= tabladinamica.getSemana5();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana5(s1); 
         }
       }     
          if(semana6==null){
        tabladinamica.setSemana6("&nbsp;");
          } else{
                String s1= tabladinamica.getSemana6();
         String conc= s1.substring(0,1);
         
         if(conc.equals(".")){
             s1="0"+s1;
             tabladinamica.setSemana6(s1); 
         }
          }
     
     %>
    <tr><td class="Estilo4"><%=tabladinamica.getDesmarca()%></td><td class="Estilo4"><%=tabladinamica.getDescapacidad()%></td><td class="Estilo4"><%=tabladinamica.getDesenvase()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana1()%></td><td align ="center" class="Estilo4"><%=tabladinamica.getSemana2()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana3()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana4()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana5()%></td><td align="center" class="Estilo4"><%=tabladinamica.getSemana6()%></td></tr>
    
     <%
     
     int xxcont = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
     
     if (xxcont <=1){ 
     
           if(Kprod.equals(prod) ){
               
           //int xxcont = oraCliente.conteoProdu(xcodigo, tabladinamica.getDesmarca()  ,orasql);
            xcount ++  ;
            
           if(xxcont == xcount ) {
               List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
              for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
          if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         %>
<tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
         
         <%
        }
           }
           }else{
              List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
         
           if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
         %>
         
<tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
     
     <%
        }
          }
     }else{
       yycount++;
        if(xxcont == yycount ){
            List listsumXprod= oraCliente.sumatoriaxpord6(sem1,sem2,sem3,sem4,sem5,sem6,prod,xcodigo,orasql);
         
        for(int f=0 ; f< listasumxprodu.size(); f++   )
        {
         sumaxproducto =(beansemaxprod)   listsumXprod.get(f);
           if(sumaxproducto.getSem1()==null){
         sumaxproducto.setSem1("&nbsp;");
     }else{
         String sp1= sumaxproducto.getSem1();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem1(sp1); 
         }
         
     }
     
     
     
     if(sumaxproducto.getSem2()==null){
         sumaxproducto.setSem2("&nbsp;");
     }else{
      String sp1= sumaxproducto.getSem2();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem2(sp1); 
         }   
     }
     
     if(sumaxproducto.getSem3()==null){
         sumaxproducto.setSem3(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem3();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem3(sp1); 
         }    
     }
     
     if(sumaxproducto.getSem4()==null){
         sumaxproducto.setSem4(" &nbsp; ");
     }else{
      String sp1= sumaxproducto.getSem4();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem4(sp1); 
         }       
     }
     
     if(sumaxproducto.getSem5()==null){
         sumaxproducto.setSem5(" &nbsp; ");
     }else{
         String sp1= sumaxproducto.getSem5();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem5(sp1); 
         }    
     }
     if(sumaxproducto.getSem6()==null){
         sumaxproducto.setSem6(" &nbsp; ");
     }else{
        String sp1= sumaxproducto.getSem6();
         String conc= sp1.substring(0,1);
         
         if(conc.equals(".")){
             sp1="0"+sp1;
             sumaxproducto.setSem6(sp1); 
         }     
     }
     
     %>
        
<tr><td colspan="3"  bgcolor="#FFFF8A"    class="Estilo4">Total por Producto</td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem1() %> </td><td bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem2() %></td><td bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem3() %></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem4()%></td><td  bgcolor="#FFFF8A"  align="center" class="Estilo4"><%=sumaxproducto.getSem5()%></td><td  bgcolor="#FFFF8A"   align="center" class="Estilo4"><%=sumaxproducto.getSem6()%></td></tr>
     
         
         
      <%   
        }
         yycount=0;
      xcount=0;
        }
        
        
         
         
     }  
          Kprod=tabladinamica.getDesmarca();  
       }
     for( int a=0;a<listasumcat4.size();a++){
     sumatoria=(beanSumatoriaSemanas)listasumcat4.get(a);
     sumatori1=sumatoria.getSem1();
     
     
    if(sumatori1==null){
     sumatoria.setSem1("&nbsp;");
     }else{
         String st1= sumatoria.getSem1();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem1(st1); 
         }
     }
     sumatori2=sumatoria.getSem2();
     if(sumatori2==null){
     sumatoria.setSem2("&nbsp;");
     }else{
       String st1= sumatoria.getSem2();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem2(st1); 
         }  
     }
     sumatori3=sumatoria.getSem3();
     if(sumatori3==null){
     sumatoria.setSem3("&nbsp;");
     }else{
         String st1= sumatoria.getSem3();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem3(st1); 
         }
     }
     sumatori4=sumatoria.getSem4();
     if(sumatori4==null){
     sumatoria.setSem4("&nbsp;");
     }else{
      String st1= sumatoria.getSem4();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem4(st1); 
         }   
     }
     sumatori5=sumatoria.getSem5();
     if(sumatori5==null){
     sumatoria.setSem5("&nbsp;");
     }else{
       String st1= sumatoria.getSem5();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem5(st1); 
         }  
     }
     sumatori6=sumatoria.getSem6();
     if(sumatori6==null){
     sumatoria.setSem6("&nbsp;");
     }else{
         String st1= sumatoria.getSem6();
         String conc= st1.substring(0,1);
         
         if(conc.equals(".")){
             st1="0"+st1;
             sumatoria.setSem6(st1); 
         }
     }
     %>
     
     
      <tr><td colspan="4" bgcolor="#00006C" style="color: #ffffff"  class="Estilo4">Total por Categoría</td>     <td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem1()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem2()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem3()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem4()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem5()%></td><td bgcolor="#00006C" style="color: #ffffff"  align="center" class="Estilo4"><%=sumatoria.getSem6()%></td></tr>
      
     <%
     }
     }  %>
        </table>   
                  
                <span class="Estilo4">
     <%    
                  
     }
               %>
      
     <%}%>       
     <%}else{
                    
                %>
                </span>
        <table width="549" border="1">
    <tr>
        <td colspan="4" class="Estilo4" style="visibility: hidden"></td>
      <td colspan="3" class="Estilo4"><div align="center" class="Estilo4">MES</div></td>
      <td class="Estilo4" style="visibility: hidden"></td>
    </tr>
    <tr>
      <td colspan="4" class="Estilo4">&nbsp;</td>
      <td width="53" align ="center" class="Estilo4">Sem1</td>
      <td width="56" align ="center" class="Estilo4">Sem2</td>
      <td width="62" align ="center" class="Estilo4">Sem3</td>
      <td width="55" class="Estilo4">TOTAL</td>
    </tr>
    <tr>
      <td width="60" rowspan="3" class="Estilo4">Categor&iacute;a</td>
      <td width="60" class="Estilo4">Producto</td>
      <td width="72" class="Estilo4">Descripci&oacute;n</td>
      <td width="79" class="Estilo4">C&oacute;digo marca</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
    </tr>
    <tr>
      <td class="Estilo4">Producto</td>
      <td class="Estilo4">Descripci&oacute;n</td>
      <td class="Estilo4">C&oacute;digo marca</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3" bgcolor='#D4DBEE' class="Estilo4">Total por productos</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'; font-size: 14px;">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="4" bgcolor='#D4DBEE' class="Estilo4">Total por categor&iacute;a</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'">&nbsp;</td>
      <td class="Estilo4" style="font-family: 'Trebuchet MS'">&nbsp;</td>
    </tr>
  </table>
      <%}%>
    
    <br>
  <input TYPE="hidden" name="idcheck" id="idcheck">
            <input TYPE="hidden" name="valordes" id="valordes">
            <input TYPE="hidden" name="idllamada" id="idllamada">
     <tr>
        <td height="28" colspan="3" bgcolor="#97D4FE">
    <span class="Estilo2">Anotaciones Personales</span></tr>
        <tr>
          <td colspan="3">
              <span class="Estilo4"><BR>
           
                 <%
     
          int var=0;
         
        
          Integer grabax=sqlCliente.contadorAnotaciones(xcodigo, cn_rascalLocal);
          List listaAnotacion= sqlCliente.ObtenerFecha(xcodigo,cn_rascalLocal);
          List listaAnotaHisto= sqlCliente.ObtenerFechaHistori(xcodigo,cn_sql);
          beanAnotacion anotacion =null;
          
          beanAnotacion anotaHisto =null;
          for(int k =0;k <listaAnotaHisto.size();k++){
              anotaHisto = (beanAnotacion)   listaAnotaHisto.get(k);}
          
          if(anotaHisto==null && listaAnotacion ==null){%>
              </span>
            <table style="width: 890px; font-family: 'Trebuchet MS'; font-size: 12px;" border="1">
              <tr>
                <th width="27"  bgcolor="#DBDBDB" class="Estilo4"><a name="anotacion"></a></th>
                <th bgcolor="#DBDBDB" width="170"><center>
                  <span class="Estilo4">Fecha</span>
                </center></th>
                <th bgcolor="#DBDBDB" width="605"><center>
                  <span class="Estilo4"> Anotaci&oacute;n </span>
                </center></th>
              </tr>
           <tr> <td>&nbsp;   </td>    <td bgcolor="#DBDBDB"><center>
             <span class="Estilo4"><%=fecha%></span>
           </center></td><td bgcolor="#F6F6F6" class="Estilo4" id="tdanotacion" >
              
               
               <input type= " text" name="txtanot" id="txtanot" size="50" onKeyPress="return desabilita(event)" >
              
              
               <input type="button" name="grabanotacionllamada" id="grabanotacionllamada" value="Grabar Anotación"   onclick="grabaranotacionllamada()">
    
           </td>
              </tr>  
            </table>
              <span class="Estilo4">
              <%}else {%>
              </span>
            <table style="width: 890px; font-family: 'Trebuchet MS'; font-size: 16px;" border="1">
              <tr>
                <th width="27"  bgcolor="#DBDBDB" class="Estilo4"><a name="anotacion"></a></th>
                <th bgcolor="#DBDBDB" width="170"><center>
                  <span class="Estilo4">Fecha</span>
                </center></th>
                <th bgcolor="#DBDBDB" width="605"><center>
                  <span class="Estilo4"> Anotaci&oacute;n </span>
                </center></th>
              </tr>
            </table>
              <div id="div6"  class="div6" style="width:900px ">
              <table border =2 style="width:890px">
    
                  <tr> <td class="Estilo4">&nbsp;   </td>    
                  <td bgcolor="#DBDBDB" class="Estilo4"><center>
                    <span class="Estilo4"><%=fecha%></span>
                  </center></td><td bgcolor="#F6F6F6" class="Estilo4" id="tdanotacion" >
               <%
   
if(grabax!=0){   %>       
                      
                      
          <input type= " text" name="txtanot" id="txtanot"   disabled="true" size="50" onKeyPress="return desabilita(event)" >
          <input type="button" name="grabanotacionllamada" disabled="true"  id="grabanotacionllamada" value="Grabar Anotación"   onclick="grabaranotacionllamada()">
    <%}else{
               
    %>
  
    <input type= " text" name="txtanot" id="txtanot" size="50" onKeyPress="return desabilita(event)" >
    <input type="button" name="grabanotacionllamada" id="grabanotacionllamada"  value="Grabar Anotación"   onclick="grabaranotacionllamada()">
    
  <%  
               }%>
                  </td>
               </tr>   
                  
             <% for(int k =0;k <listaAnotacion.size();k++){
                 System.out.println("vamos a cantar ===> "+listaAnotacion.size() );
              anotacion = (beanAnotacion)   listaAnotacion.get(k);%>
                <tr>
                    <td class="Estilo4"><center>
                      <span class="Estilo4">
                      <input type=radio id="chb<%=var%>" value ="<%=k%>"  name= "chb<%=var%>"     onClick="valanot(this.id,'des<%=+var%>','id<%=anotacion.getId()%>','<%=graba%>'  , 'chb<%=var%>')"/>
                      </span>
                  </center> </td>
                  <td align="center" bgcolor="#DBDBDB" class="Estilo4" id="fech<%=+var%>"><%= formateador.format(formateador.parse( anotacion.getFecha()))%></td>
                  <td bgcolor="#F6F6F6" class="Estilo4"  >
                      <input type="text" name="des<%=+var%>"  id="des<%=+var%>" disabled="disabled"  value="<%=anotacion.getDescripcion() %>" size="50" />   

                  </td>
            
                  <td width="17" class="Estilo4" id ="id<%=anotacion.getId()%>"  style=" display: none"><%=anotacion.getId()%> </td>
                </tr>
                <%
             var= var+ 1;
             }
              for(int k =0;k <listaAnotaHisto.size();k++){
                   System.out.println("vamos a cantar ===> "+listaAnotaHisto.size() );
              anotaHisto = (beanAnotacion)   listaAnotaHisto.get(k);%>
                  <tr>
                    <td class="Estilo4"><center>
                      <span class="Estilo4">
                      <input type=radio id="chb<%=var%>" value ="<%=k%>"  name= "chb<%=var%>"     onClick="valanot(this.id,'des<%=+var%>','id<%=anotaHisto.getId()%>','<%=graba%>'  , 'chb<%=var%>')"/>
                      </span>
                  </center> </td>
                  <td align="center" bgcolor="#DBDBDB" class="Estilo4" id="fech<%=+var%>"><%= formateador.format(formateador.parse( anotaHisto.getFecha()))%></td>
                  <td bgcolor="#F6F6F6" class="Estilo4"  >
                  <input type="text" name="des<%=+var%>"  id="des<%=+var%>" disabled="disabled"  value="<%=anotaHisto.getDescripcion() %>" size="50" />   
                  </td>
                  <td width="17" class="Estilo4" id ="id<%=anotaHisto.getId()%>"  style=" display: none"><%=anotaHisto.getId()%> </td>
               </tr>
                <%
             var= var+ 1;
             }
                %>
            </table>
            </div>
                <span class="Estilo4">
                <%
           }
       %>
                </span>
            <div align="center">
                <table>
				<tr>
				<td class="Estilo4">
			    <input type="button" name="btngraanot" id="btngraanot" value="Grabar Anotación" align="rigth"   style="visibility: hidden" onClick="fgrabaanotacion()" >			    </td>
               <td><td>
			   <td>   <span class="Estilo4">
			   <input type="button" name="cancelarx" id="cancelarx" value="Cancelar" align="rigth"  style="visibility: hidden"  onclick="cancelaranotacion()" >
			   </span></td>
			 </tr>
			 </table>
		    </div>
         
     </td> 
    </tr>
  </table>

    
          
 <%         
          
          
    Diario_cn.close();
    cn_sql.close();
    
          
          
          %>
        </table>
      </div>           
    
  <script language="javascript">   
 
     var codigo=document.getElementById('codigo').value;
   document.title='Informacion General - '+ codigo;  
////paren///t.document.title='Informacion General - '+ codigo;  ;
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
   
 parent.document.URL  ="http://10.165.70.246:8080/FMSalesForce/CONSULTOR2.jsp?campana="+campana+"&campa="+campa+"&txtcodigo="+codcli;   
     /// alert("lel3");
    </script>
    
     
     <%
}  
          
 %>         
  <iframe   frameborder="NO" scrolling ="no"  src="logon.jsp?CAMPAIGN=<%=capaign %>&Account_Number=<%=xcodigo%>" name="frameprocedure" width="50px" height="50px" style="display: none"/> 
 </iframe>        
  <%          
orasql.close();
%>
</form>
  
  
</body>
</html>