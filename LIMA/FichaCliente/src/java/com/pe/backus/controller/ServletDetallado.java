/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.controller;

import com.pe.backus.dao.impl.clienteOracleDaoImpl;
import com.pe.backus.dao.impl.clienteSqlDaoImpl;
import com.pe.backus.dto.beanDetalladoCliente;
import com.pe.backus.dto.beanTelefonoParentesco;
import com.pe.backus.factory.CerrarCursor;
import com.pe.backus.factory.sqlDaoFactoryImpl;
import com.pe.backus.factory.sqlDaoLocalFactoryImpl;
import com.pe.backus.factory.sqlDaoRascalFactoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonathan
 */
@WebServlet(name = "ServletDetallado", urlPatterns = {"/ServletDetallado_1"})
public class ServletDetallado extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDetallado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletDetallado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        
        
    }

 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*Conexiones poll
          autor :Edson */
        Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
        Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
        CerrarCursor cerrar =  new  CerrarCursor();
         
        HttpSession session=  request.getSession(); 

         String xcodigo , xvalorcodigo ;
        xvalorcodigo=  request.getParameter("codCliente") ; 
        
            if(xvalorcodigo==null){xvalorcodigo="";}
        xcodigo = xvalorcodigo.trim();
        
        if(xcodigo==null){xcodigo="";}
 
          xcodigo = xvalorcodigo.trim();
          
          
      // String campana = request.getParameter("campana");
    String accion = request.getParameter("accionHTML");
    String codigoCampana =  request.getParameter("campa");
    String campa = request.getParameter("campaign"); 
    //String accion1 = request.getParameter("manual");
                //setAttribute("CAMPAIGN",campaña);
    
     
    
        clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
        
        
        
        
        
     
        
       if (accion != null){
// if(accion1==null){accion1="";}
    if(codigoCampana==null){codigoCampana="";}
    if (accion.equals("avanceEnLinea")) {
            //Sesion para manejar Los Inserts y Updates
            String codCliente = request.getParameter("codCliente");
            String manual= "hola";
  

             //System.out.println("campana jonathan: "+codigoCampana );
             System.out.println("codcliente jonathan: "+codCliente );
            
            session.setAttribute("codCliente", codCliente);
           


        
           String Consulta="consulta";
           sqlImplements.insertarClienteIdentificador(codigoCampana, codCliente,"M",cn_rascalLocal );
            Integer Id= sqlImplements.obtenerCodigo(codigoCampana,cn_rascalLocal);
           sqlImplements.insertarClienteManual(Id,Consulta,cn_sql);
           sqlImplements.insertarClienteAnotacion(Id,Consulta,codCliente,cn_rascalLocal);
           sqlImplements.insertarClienteResultadoLlamada(Id,codCliente,codigoCampana,cn_rascalLocal);
           
            String estadocad=   sqlImplements.estadocad(campa,cn_sql);
            
             
             if(estadocad.equals("Inicia manual con cliente")){}else{
            sqlImplements.insertarestador( campa,"", "jijoja","Inicia manual con cliente",cn_sql);}
           String varcont="0";
           Integer Idx= sqlImplements.obtenerCodigo(codigoCampana,cn_rascalLocal);
             sqlImplements.insertclickttocall(Idx,codigoCampana,varcont,cn_sql);
         cerrar.cerrar(cn_sql);
         cerrar.cerrar(cn_rascalLocal);
          getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+xcodigo+"&campa="+campa+"&manual="+manual+"&click=valor").forward(request, response);
   
        }
          if (accion.equals("Llamar")){
         
            String nro= request.getParameter("numerox");  
           String manual="hello";

     String xcodigo1= request.getParameter("CodClienteDetalle");      
               cerrar.cerrar(cn_sql);
               cerrar.cerrar(cn_rascalLocal);
                   getServletContext().getRequestDispatcher("/listaNumero.jsp?campana="+codigoCampana+"&codcli="+xcodigo1+"&campa="+campa+"&manual="+manual+"&numeroclicktocholl=9"+nro+"&llamar=llamar&numerito=valor").forward(request, response);
        
          }
    
    
        
        if (accion.equals("llamadaManual")) {
            
            String codcliSession="";
                    String estadocad=  sqlImplements.estadocad(campa,cn_sql);
                codcliSession=request.getParameter("codCliente");
            String codCliente = request.getParameter("codCliente");
            
            String campana = request.getParameter("campa"); 
            String Nro = request.getParameter("telefonoSelect"); 
            int contador= sqlImplements.obtieneContador(codigoCampana,cn_sql);
                String valor="valor";        
          if(estadocad.equals("clicktocall") ||  estadocad.equals("Preparado"))      {
     getServletContext().getRequestDispatcher("/listaNumero.jsp?valor=valor&campana="+campana+"&campa="+campa+"&codcli="+codCliente).forward(request, response);
         
          }else{
            if (contador==0 ) {
              // session.removeAttribute("contador");
           
                contador++;
               //session.setAttribute("contador", contador);
               
                Integer Id= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
                sqlImplements.UpdateClienteManual(Nro,Id,cn_sql);
               sqlImplements.insertarestador( campana.substring(5),"", "","clicktocall",cn_sql);
               sqlImplements.updateclickttocall(Id,campana,Integer.toString(contador),cn_sql);
              //   getServletContext().getRequestDispatcher("/Informacion_Cliente.jsp?campana="+campana+"&codcli="+codCliente+"&valor="+valor).forward(request, response);
                cerrar.cerrar(cn_sql);
                cerrar.cerrar(cn_rascalLocal);
              
               getServletContext().getRequestDispatcher("/listaNumero.jsp?valor=valor&campana="+campana+"&campa="+campa+"&codcli="+codCliente).forward(request, response);
        //   getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
            else {
               
            String Consulta1 = "consulta";
            sqlImplements.insertarClienteIdentificador(campana, codCliente,"M",cn_rascalLocal);
             Integer Id= sqlImplements.obtenerCodigo(codigoCampana,cn_rascalLocal);
            sqlImplements.insertarClienteManual1(Id,Nro,cn_sql);
            sqlImplements.insertarClienteAnotacion(Id,Consulta1,codCliente,cn_rascalLocal);
            sqlImplements.insertarClienteResultadoLlamada(Id,codCliente,campana,cn_rascalLocal);
            sqlImplements.insertarestador( campana.substring(5),"", "","clicktocall",cn_sql);
           //  getServletContext().getRequestDispatcher("/Informacion_Cliente.jsp?campana="+campana+"&codcli="+codCliente+"&valor="+valor).forward(request, response);
            Integer Idx= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
            sqlImplements.insertclickttocall(Idx,codigoCampana,Integer.toString(contador),cn_sql);
            cerrar.cerrar(cn_sql);
            cerrar.cerrar(cn_rascalLocal);
           getServletContext().getRequestDispatcher("/listaNumero.jsp?valor=valor&campana="+campana+"&campa="+campa+"&codcli="+codCliente).forward(request, response);
            //  getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
 
         
          } 
  }
    if(accion.equals("filtro")){
   
        

       int contadorWhere =0;
        String cadena=" ";
        String where="";
        
        //
        String nombre = request.getParameter("txtbuscaXnombre");
        if (nombre == null || nombre.equals("")  ){ nombre=" ";}
        else{cadena += " LastName like ''%"+nombre.toUpperCase()+"%''"+ "/"; contadorWhere++;}        
        String codigo = request.getParameter("txtbuscaXcodigo");
        if(codigo == null || codigo.equals("")){ codigo =" ";}
        else{ cadena+="AccountNumber like ''%"+codigo.toUpperCase()+"%''"+"/"; contadorWhere++;}        
        String estado = request.getParameter("txtbuscaXestado");
        if(estado == null  || estado .equals("")){ estado =" ";}
        else{
         
            
            cadena+="status like ''%"+estado.toUpperCase()+"%''"+"/"; contadorWhere++;}   
        
        String result = request.getParameter("txtbuscaXresult");
        
        
        
        if(result == null || result.equals("")){ result= " ";}
        else{cadena+="Resultado like ''%"+result.toUpperCase()+"%''"+"/"; contadorWhere++;}
        String pei = request.getParameter("txtbuscaXPei");
        if(pei == null || pei.equals("") ){ pei= " ";}
        else{cadena+="CODZONAVENTA like ''%"+pei.toUpperCase()+"%''"+ "/"; contadorWhere++;}         
        
        
        
        
       String flagBusqueda ="1";
        
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
        
       
       
      
       // String CampanaSession = (String) session.getAttribute("campanaSesion");
        
        clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
        Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();
        //TIO QUE FUE L
         
        List<beanDetalladoCliente> ListObtenerDetalle= orasql.ObtenerDetallefiltro(codigoCampana,cn_ippc,where);
        String msg =" ";
        
        if( ListObtenerDetalle == null ||    ListObtenerDetalle.size()==0){
            msg="No se encontraron datos para esta búsqueda";
            
          /*  if(where == null ||where.equals("") ){
              where="";
            }else{
              request.setAttribute("where", where);
          }
            
            */
             request.setAttribute("where", where);
            request.setAttribute("msg", msg);
            request.setAttribute("ListObtenerDetalle", ListObtenerDetalle);
            getServletContext().getRequestDispatcher("/index.jsp?campana="+codigoCampana+"&codcli="+xcodigo+"&manual=manual&flagBusqueda="+flagBusqueda+"&validacion=validacion&anclafiltro=valor&campa="+campa).forward(request, response);
    
        }else{
        request.setAttribute("ListObtenerDetalle", ListObtenerDetalle);
        request.setAttribute("flagBusqueda", flagBusqueda);
      /* if(where == null ||where.equals("") ){
              where="";
            }else{
             
          }*/
         request.setAttribute("where", where);
         System.out.println("trabajo de where000000====>"+where);
        //getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
          cerrar.cerrar(cn_sql);
            cerrar.cerrar(cn_rascalLocal);
        getServletContext().getRequestDispatcher("/index.jsp?campana="+codigoCampana+"&codcli="+xcodigo+"&manual=manual&flagBusqueda="+flagBusqueda+"&validacion=validacion&anclafiltro=valor&campa="+campa).forward(request, response);
       //  getServletContext().getRequestDispatcher("/index.jsp?campana="+"CAMP_210"+"&codcli="+codigo+"&manual="+"manual"+"&click=valor").forward(request, response);
   }
        }
    
      if(accion.equals("filtro1")){
       int contadorWhere =0;
        String cadena=" ";
      String where= (String)session.getAttribute("wherejsp");
        if(where ==null || where.equals("null")){
            where="";
           // System.out.println("sociedad privada y el Lobo auuu");  
        }
        
       String flagBusqueda ="1";
        
        
        clienteSqlDaoImpl orasql = new clienteSqlDaoImpl();
        Connection cn_ippc= sqlDaoFactoryImpl.getSQLConextion();
       
         
        List<beanDetalladoCliente> ListObtenerDetalle= orasql.ObtenerDetallefiltro(codigoCampana,cn_ippc,where);
        String msg =" ";
       
        request.setAttribute("ListObtenerDetalle", ListObtenerDetalle);
        request.setAttribute("flagBusqueda", flagBusqueda);
        request.setAttribute("where", where);
        System.out.println("trabajo de where1111====>"+where);
        //getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
         cerrar.cerrar(cn_sql);
            cerrar.cerrar(cn_rascalLocal);
        getServletContext().getRequestDispatcher("/index.jsp?campana="+codigoCampana+"&codcli="+xcodigo+"&manual=manual&flagBusqueda="+flagBusqueda+"&validacion=validacion&anclafiltro=valor&campa="+campa).forward(request, response);
       //  getServletContext().getRequestDispatcher("/index.jsp?campana="+"CAMP_210"+"&codcli="+codigo+"&manual="+"manual"+"&click=valor").forward(request, response);
   }
    
 }     
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
