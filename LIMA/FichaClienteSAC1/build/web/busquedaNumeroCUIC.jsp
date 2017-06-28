<%-- 
    Document   : busquedaNumeroCUIC
    Created on : 30/03/2015, 04:12:25 PM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.dto.beanListaCuic"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.backus.factory.sqlDaoRascal2FactoryImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="styles/cool.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <table width="1150" class="cool"  border="1" style="font-family: 'Trebuchet MS'; font-size: 12px;">
            <tr style="font-weight: bold; background-color: #fdf1d9;">
                <td>Agente</td>
                 <td>Fecha</td>
                  <td>Campana</td>
                <td>Fecha y Hora</td>
                 <td>Teléfono</td>
                 <td>Tiempo antes del check</td>
                    <td>Timbrado</td>
                 <td>Conversación</td>  
                  <td>Tiempo en espera</td>  
                  <td>Duración Total</td>  
            </tr>
            
            <%
                clienteSqlDaoImpl sqlImplements = new clienteSqlDaoImpl();
                    String numerocuic = request.getParameter("numeroCuic");
                    Connection con = sqlDaoRascal2FactoryImpl.getSQLConextionRascal();
                    Connection Diario_cn = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
                    List<beanListaCuic> listaCuic = sqlImplements.ObtenerTelefonoListaCuic(numerocuic, con);

                    List<beanListaCuic> listacuicArequipa = sqlImplements.ObtenerTelefonoListaCuicAQP(numerocuic, Diario_cn);
                     
                    beanListaCuic listar = null;
                     
                    if (listaCuic == null) {

                    } else {

                        for (int i = 0; i < listaCuic.size(); i++) {

                            listar = (beanListaCuic) listaCuic.get(i);
        %>
            <tr>

                <td><%=listar.getAgente()%></td>
                <td><%=listar.getFecha()%></td>
                <td><%=listar.getCampana()%></td>
                <td><%= listar.getFecha_hora()%></td>
                <td><%=listar.getTelefono()%></td>
                <td><%=listar.getTiempo_check()%></td>
                <td><%=listar.getTimbrado()%></td>
                <td><%=listar.getConversacion()%></td>
                <td><%=listar.getTiempo_espera()%></td>
                <td><%=listar.getDuracion_total()%></td>

            </tr>
            
            <%}
  }if(listacuicArequipa==null){
      
  }else{
       for(int i =0; i<listacuicArequipa.size();i++  ){
             listar=(beanListaCuic)listacuicArequipa.get(i);
          %>   
            <tr>
   
         <td><%=listar.getAgente()%></td>
                <td><%=listar.getFecha()%></td>
                <td><%=listar.getCampana()%></td>
                <td><%= listar.getFecha_hora()%></td>
                <td><%=listar.getTelefono()%></td>
                <td><%=listar.getTiempo_check()%></td>
                <td><%=listar.getTimbrado()%></td>
                <td><%=listar.getConversacion()%></td>
                <td><%=listar.getTiempo_espera()%></td>
                <td><%=listar.getDuracion_total()%></td>
    
            </tr>
            
            <%  
       }
  }
  
  
            
        con.close();
        Diario_cn.close();
            
            
            
            %>
        </table>
    </body>
</html>
