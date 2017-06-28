<%-- 
    Document   : frmConsulInvisible
    Created on : 01/07/2014, 09:05:53 AM
    Author     : Administrador
--%>

<%@page import="com.pe.backus.factory.sqlDaoRascalFactoryImpl"%>
<%@page import="com.pe.backus.dao.impl.clienteSqlDaoImpl"%>
<%@page import="com.pe.backus.factory.sqlDaoLocalFactoryImpl"%>
<%@page import="com.pe.backus.factory.CerrarCursor"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
        <%
            
              /******************Conexiones  poll*****************/

Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
 Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
CerrarCursor  cerrar = new CerrarCursor();
/*********************************************************************/
       
       
        clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl(); 
      String   xcodigo  =request.getParameter("txtcodigo");
      String codigoCampana= request.getParameter("campana");
     String campaign= request.getParameter("campa");
     String  accion = request.getParameter("accion");
      String  accion2 = request.getParameter("acciondos");
     String  prepcodigo=  request.getParameter("prepxcodigo");
     String     descrip= request.getParameter("descrip");
     String codianot = request.getParameter("codianot");
      String numero_entrante = request.getParameter("ANI");
    // String accionHTML =  request.getParameter("accionHTML");
        %>
     <input type='hidden' name='campaign' id='campaign'  value="<%=campaign%>" >    
     <input type='hidden' name='codigoCampana' id='codigoCampana'  value="<%=codigoCampana%>" > 
    <input type='hidden' name='txtcodigo' id='txtcodigo'  value="<%=codianot%>" >  
     
        
            <%
                ///System.out.println("Valor a la luzzz==============>");
      if(xcodigo!= null ){
          String Tipo="Manual";
            String conta="0";
         
            String estadocad=   sqlImplements.estadocad(campaign,cn_sql);
             System.out.println("ESTADO ========"+estadocad);
           int id_llamada=0;
           String numero="";
      if(estadocad.equals("NoPreparado") ||estadocad.equals("Inicia manual con cliente") ) {
           session.removeAttribute("GestionEntrante");
          System.out.println("Valor a la luzzz==============>");
                session.setAttribute("TipoGestion", Tipo);
            sqlImplements.InsertClienteIdentificadorSAC(Tipo,id_llamada,numero,codigoCampana,cn_rascalLocal);
                 Integer Idx= sqlImplements.obtenerCodigoSAC(codigoCampana,cn_rascalLocal);
             sqlImplements.insertclickttocall(Idx,codigoCampana,conta,cn_sql);
      }     
            

          
          
        
            if(estadocad.equals("Inicia manual con cliente" ) || estadocad.equals("Preparado") || estadocad.equals("Error Agente")){}else{
          sqlImplements.insertarestador( campaign,"", "","Inicia manual con cliente",cn_sql);}
            
            
            System.out.println("Entro a grabar ");
       cerrar.cerrar(cn_sql);
          cn_rascalLocal.close();
      
 
          
      }else if (prepcodigo != null  ){
          String Consulta="consulta";
        
            
        
     
      
          /*Estados del CAD de FichaClienteSAC*/
            String estadocad=   sqlImplements.estadocad(campaign,cn_sql);
            if(estadocad.equals("Inicia manual con cliente" ) || estadocad.equals("Preparado") || estadocad.equals("Error Agente")  ){}else{
          sqlImplements.insertarestador( campaign,"", "","Inicia manual con cliente",cn_sql);}
            System.out.println("Entro al consultor1");
            
            
         
     cerrar.cerrar(cn_sql);
     cerrar.cerrar(cn_rascalLocal);
     
     %> 
    
         
     <% 
      
      }else  if (accion.equals("GrabaAnotacion"))   {
      String contGraba= request.getParameter("graba");
     if(contGraba==null){
           contGraba="0";
     }
   
      int contaanot=         sqlImplements.contadorAnotaciones(codigoCampana, cn_sql);
      //hacer la actualizada
      String codanotacioncli;
              codanotacioncli= request.getParameter("clianotacion");
  
               
              
           if (accion2.equals("ActualizarModificacion"))   { 
           
               %>
              
               <%
            sqlImplements.actualizarAnotacion(codigoCampana, descrip,contaanot,cn_sql);
 
           }else
              
      if (accion2.equals("Cancelar"))   {
          
       
      
        //  getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+codanotacioncli.trim()+"&campa="+campaign.trim()+"&refere=valor").forward(request, response);
 
      }else
     
                  
     if(accion2.equals("ModificaAnotac")){
         
      
       String   textmod = request.getParameter("idcheck");
       //String id = request.getParameter("id");
         String id = request.getParameter("idllamada");
         
         if( id.equals("")){}else{
         
         id=id.substring(2);}
         sqlImplements.ModificaAnotacion(textmod, id, contaanot ,cn_sql);//modificada

     }else{
         sqlImplements.actualizarAnotacion(codigoCampana, descrip,contaanot,cn_sql);//insertada
           contGraba="1";
     }
 
     cerrar.cerrar(cn_sql);
     // getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+codanotacioncli.trim()+"&campa="+campaign.trim()+"&refere=valor&graba="+contGraba).forward(request, response);
  
     
    } else  if (accion.equals("llamadaManual")) {
               int contador= sqlImplements.obtieneContador(codigoCampana,cn_sql);
          String estadocad=  sqlImplements.estadocad(campaign,cn_sql);
                   
               // codcliSession=request.getParameter("codCliente");
            String codCliente = request.getParameter("CodCliente");
            //String campana = request.getParameter("campa"); 
            String Nro = request.getParameter("telefonoSelect"); 
                ///String valor="valor";        
            
            if(estadocad.equals("clicktocall")){
                
            }else{
            
            if (/*codcliSession.equals(codCliente) && */contador==0 ) {
              // session.removeAttribute("contador");
           
                contador++;
               //session.setAttribute("contador", contador);
               
                Integer Id= sqlImplements.obtenerCodigoSAC(codigoCampana,cn_rascalLocal);
                sqlImplements.UpdateIdentificadorSAC(Nro,Id,cn_rascalLocal);
               
               sqlImplements.insertarestador( codigoCampana.substring(5),"", "","clicktocall",cn_sql);
               sqlImplements.updateclickttocall(Id,codigoCampana,Integer.toString(contador),cn_sql);
              //   getServletContext().getRequestDispatcher("/Informacion_Cliente.jsp?campana="+campana+"&codcli="+codCliente+"&valor="+valor).forward(request, response);
                cerrar.cerrar(cn_sql);
                 cerrar.cerrar(cn_rascalLocal);
             //  getServletContext().getRequestDispatcher("/listaNumero.jsp?valor=valor").forward(request, response);
        //   getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
            else {
               
            String Tipo = "Manual";
              int id_llamada=0;
           sqlImplements.InsertClienteIdentificadorSAC(Tipo,id_llamada,Nro,codigoCampana,cn_rascalLocal);
          //////////////  cn_rascalLocal.close();
             ///Integer Id= sqlImplements.obtenerCodigo(codigoCampana,cn_rascalLocal);
             
             
           // sqlImplements.insertarClienteManual1(Id,Nro,cn_sql);
          Integer Idx= sqlImplements.obtenerCodigoSAC(codigoCampana,cn_rascalLocal);
            sqlImplements.insertclickttocall(Idx,codigoCampana,Integer.toString(contador),cn_sql);
            cerrar.cerrar(cn_sql);
            cerrar.cerrar(cn_rascalLocal);
         //  getServletContext().getRequestDispatcher("/listaNumero.jsp?valor="+valor).forward(request, response);
            //  getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
 
            }///cerramos si no es click to call
            
  }

        %>
        
        
        </form>
    </body>
</html>
