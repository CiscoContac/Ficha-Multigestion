<%-- 
    Document   : busquedaFiltro
    Created on : 16/02/2015, 10:52:24 AM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="com.pe.backus.dto.beanClienteBo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/estilos.css" rel="stylesheet" type="text/css" />
           <script src="js/consultor.js">
    </script>
        <title>JSP Page</title>
       <style type="text/css"> 
      #div6 {
         
   overflow-x: hidden;
    overflow-y: scroll;
   height:100px;
   width: 915px;
   
      }        
        
       </style>   
    </head>
    <body class="Estilo4" style="font-weight: bold" >
        <form>
        <% clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
        Connection orasql= oraclefactooriginal.getSQLConextion();
         String parametro= request.getParameter("parametro");
       String   ANI = request.getParameter("ANI");
         String campa = request.getParameter("campa");
         String capaign = request.getParameter("campana");
         String valor = request.getParameter("valor");
         String comparacodigo = request.getParameter("comparacodigo");

         String numeroancla = request.getParameter("numeroancla");
         String WhereSession = (String) session.getAttribute("WhereSession");
         System.out.println("WhereSession" + WhereSession);

         String cadena = "";
         String where = "";
           int contadorWhere =0;
       String direccion=request.getParameter("txtdireccion");
       if (direccion == null || direccion.equals("")  ){ direccion=" ";}
        else{cadena += " UPPER(DESDIRECCION) like '%"+direccion.toUpperCase() +"%'"+ "/"; contadorWhere++;}   
       String distrito=request.getParameter("txtdistrito");
        if (distrito == null || distrito.equals("")  ){ distrito=" ";}
        else{cadena += " UPPER(DESDISTRITO) like '%"+distrito.toUpperCase() +"%'"+ "/"; contadorWhere++;}  
        
           String[] arrResult = cadena.split("/");
        
        for(int i=0; i<arrResult.length; i++){
            if(i==0){
            where+=(arrResult[i]);
            }else{
                if(i >0 && i <= arrResult.length-1 ){
                    where+=" AND "+(arrResult[i]+"  ");
                }else{
                }if(i==arrResult.length){
                    where+=" "+(arrResult[i]);
                }
            }
        }
        
        String filtro=request.getParameter("filtro");
        if(filtro==null){
            filtro="";
        }
        

           %>
         
         
           
          
           <script language="javascript">
          
          location.href="#valor<%=numeroancla%>";
          </script>
           
                          <input type='hidden' name='numeroentrante'  id='numeroentrante'  value ="<%=ANI%>" />
           <input type="hidden" id="campa" name="campa" value="<%=campa%>">        
           <input type="hidden" id="campaign" name="campaign" value="<%=capaign%>">  
             <input type="hidden" id="txtparametro" name="txtparametro" value="<%=parametro%>">  
            <input type="hidden" id="txtvalor" name="txtvalor" value="<%=valor%>">  
            <input type="hidden" id="txtcompara" name="txtcompara" value="<%=comparacodigo%>">                  
           <%--
            <div style="padding-left:374px;">
                FILTRAR POR:    <table  border="1" cellspacing="0">
        <tr>
            <td width="230">Dirección <input type="text" name="txtDireccion"  id="txtDireccion" onKeyPress="return buscarenter(event)" >   </td>
            <td width="203">Distrito <input type="text" name="txtDistrito" id="txtDistrito"  onKeyPress="   return buscarenter(event)">  
            <td><img alt="Buscar" src="img/search_f2.png" style="height: 22px; width: 25px" onclick="buscardetalle()">  </td>
            <td><img src="img/serio.jpg" width="30px" height="30px"  onclick="refrescartotal()" >  </td>
        </tr>
     </table> 
                </div>
            --%>

            <table style="float:right;"><td><img alt="Buscar" src="img/search_f2.png" style="height: 22px; width: 25px" onclick="buscardetalle()">  </td>
            <td><img src="img/serio.jpg" width="30px" height="30px"  onclick="refrescartotal()" >  </td></table>
            <table width="915" border="1" valign="top" cellspacing="0" style="font-family: 'Trebuchet MS'">
                <tr style="font-weight: bold; background-color: #fdf1d9; border-bottom: none;">
                    <td width="2">N°&nbsp;</td>
          <td width="126">CLIENTE</td>
          <td width="103">CÓDIGO </td>
          <td width="79">RUC</td>
          <td width="80">DNI</td>
          <td width="268">DIRECCIÓN <input STYLE="width: 195px;" type="text" name="txtDireccion"  id="txtDireccion" onKeyPress="return buscarenter(event)" ></td>
          <td width="144">DISTRITO <input  STYLE="width: 80px;"width="20" type="text" name="txtDistrito" id="txtDistrito"  onKeyPress="   return buscarenter(event)"></td>
          <td width="">PROVINCIA</td>
          
          
        </tr>
        
        </table>
            
            <div width="980" id="div6" style="border-style:solid ;border-width: 1px">          
       <table  border="1" valign="top" cellspacing="0">
       
        <%
        
    ///System.out.println("valor where=========>"  +where);
        
        
    session.setAttribute("WhereSession", where);
    
        if(where.equals("")){
            where=WhereSession;
        }
        
        List<beanClienteBo> listaduro= null;
        
        if(parametro == null && valor==null){
            
        }else{
                
                if( filtro == null || filtro.equals("")){
               
                 listaduro  = oraCliente.BusquedaEspecifica(parametro, valor, orasql); 
                 
                }else{
                
            
               listaduro= oraCliente.BusquedaEspecificawhere(parametro,valor,where,  orasql);
                }
        }
        
        
        beanClienteBo bolista=null;
      if(listaduro == null  )  {
        %>     
        <tr>
               <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        
     <%}else{
          int conta=0;
   for(int j =0 ; j<listaduro.size() ; j++){
       conta++;
      bolista= (beanClienteBo) listaduro.get(j);
  
      if(bolista.getDesclidetallista()== null){
          bolista.setDesclidetallista("&nbsp;");
      }if(bolista.getCod_cli_sap()==null){
          bolista.setCod_cli_sap("&nbsp;");
      }if(bolista.getCodigoruc()== null){
          bolista.setCodigoruc("&nbsp;");
      }if(bolista.getDocidentidad()== null){
          bolista.setDocidentidad("&nbsp;");
      }if(bolista.getDesdireccion()== null){
          bolista.setDesdireccion("&nbsp;");
      }if(bolista.getDesdistrito()== null){
          bolista.setDesdistrito("&nbsp;");
      }if(bolista.getDesprovincia()== null){
          bolista.setDesprovincia("&nbsp;");
      }
          %>
          
          <%if(bolista.getCod_cli_sap().equals(comparacodigo)){%>  
          
       
          <tr style=" background: #0099CC ;color:#fdf1d9  ">
              <td width="2"><%=conta%><a name="valor<%=conta%>"></a></td>
         
          <td width="126"><%=bolista.getDesclidetallista() %></td>
          <td width="103"><input type="button" id="txtcodigox" name="txtcodigox"  value="<%=bolista.getCod_cli_sap()%>" onclick="enviacodigo('<%=bolista.getCod_cli_sap()%>','<%=conta%>','<%=filtro %>')" /></td>
              <% ////System.out.println("valor where=========>"  +where); %>
          
          <td width="79"><%=bolista.getCodigoruc()%></td>
          <td width="80"><%=bolista.getDocidentidad()   %></td>
          <td width="268"><%=bolista.getDesdireccion()%></td>
          <td width="144"><%=bolista.getDesdistrito()%></td>
          <td width="48"><%=bolista.getDesprovincia()%></td>        
          </tr>
          
         <%}else{%>
          <tr>
              <td width="2"><%=conta%>  <a name="valor<%=conta%>"></a>  </td>
          <td width="126"><%=bolista.getDesclidetallista() %></td>
            <td width="103"><input type="button" id="txtcodigox" name="txtcodigox"  value="<%=bolista.getCod_cli_sap()%>" onclick="enviacodigo('<%=bolista.getCod_cli_sap()%>','<%=conta%>','<%=filtro %>')" /></td>
                 <% /////System.out.println("valor where=========>"  +where); %>
            <td width="79"><%=bolista.getCodigoruc()%></td>
          <td width="80"><%=bolista.getDocidentidad()   %></td>
          <td width="268"><%=bolista.getDesdireccion()%></td>
          <td width="144"><%=bolista.getDesdistrito()%></td>
          <td width="48"><%=bolista.getDesprovincia()%></td>    
          </tr>
          <%}%>
          
          
         <%     }   
   
      }%>   
      </table>
            </div>
        </form>
        </body>
    
   
</html>
