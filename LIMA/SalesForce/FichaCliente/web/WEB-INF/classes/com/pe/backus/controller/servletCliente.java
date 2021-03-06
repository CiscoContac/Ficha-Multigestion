/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.controller;


import com.pe.backus.dao.impl.clienteSqlDaoImpl;
import com.pe.backus.factory.CerrarCursor;
import com.pe.backus.factory.sqlDaoLocalFactoryImpl;
import com.pe.backus.factory.sqlDaoRascalFactoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos
 */
public class servletCliente extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletCliente at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        /******************Conexiones  poll*****************/

Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
CerrarCursor  cerrar = new CerrarCursor();
/*********************************************************************/
       
       
        clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();  
        String xcodigo , xvalorcodigo ;

             xvalorcodigo   = request.getParameter("txtcodigo");   
             String accion = request.getParameter("actionResul");
             HttpSession sessEnviar= request.getSession();
             String codigoCampana =  request.getParameter("campa");
             String campaign = request.getParameter("campaign");
             String descrip= request.getParameter("txtanot");
            // String mod= request.getParameter("Modifica");
              String accion2= request.getParameter("acciondos");
             String grabacomentario = request.getParameter("grabacomentario");
             String txtcomentario= request.getParameter("txtcomentario");
             if(txtcomentario==null ||txtcomentario.equals("") || txtcomentario.equals("null") ){
                 txtcomentario= request.getParameter("comentario");
             }
           String   codigo = request.getParameter("codigo");
      //System.out.println("Codigo de campana"+ codigoCampana);
              
     String codfiltro =  request.getParameter("codfiltro");
               // System.out.println("conta se servel"+ contaanot);
     
   if (grabacomentario.equals("grabacomentario") ){
       
       int contacomen= sqlImplements.contaComentario(codigo, codigoCampana, cn_rascalLocal);
       if (contacomen==0 ){
       sqlImplements.insertacomentario(codigo, txtcomentario, codigoCampana, cn_rascalLocal);
       }else{
           sqlImplements.updateComentario(codigo, txtcomentario, cn_rascalLocal);
       }
       getServletContext().getRequestDispatcher("/frameconsultor1.jsp?campana="+codigoCampana+"&txtcodigo="+codigo+"&campa="+campaign.trim()+"&actualiza=valor").forward(request, response); 
  
       
   }else
     if( codfiltro.startsWith("00")){
         
          String Consulta="consulta";
            sqlImplements.insertarClienteIdentificador(codigoCampana, codfiltro ,"M",cn_sql);
           Integer Id= sqlImplements.obtenerCodigo(codigoCampana,cn_sql);
           sqlImplements.insertarClienteResultadoLlamada(Id,codfiltro,codigoCampana,cn_sql);  
           sqlImplements.insertarClienteManual(Id,Consulta,cn_sql);
           sqlImplements.insertarClienteAnotacion(Id,Consulta,codfiltro,cn_sql);
           
           String conta="0";
            Integer Idx= sqlImplements.obtenerCodigo(codigoCampana,cn_sql);
          sqlImplements.insertclickttocall(Idx,codigoCampana,conta,cn_sql);
          
          
          String estadocad=   sqlImplements.estadocad(campaign,cn_sql);
            
             
            if(estadocad.equals("Inicia manual con cliente" ) || estadocad.equals("Preparado") || estadocad.equals("Error Agente")){}else{
          sqlImplements.insertarestador( campaign,"", "","Inicia manual con cliente",cn_sql);}
            
            
           // System.out.println("Entro al consultor2 ");
       cerrar.cerrar(cn_sql);
        getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+codfiltro.trim()+"&campa="+campaign.trim()+"&actualiza=valor").forward(request, response); 

         
         
         
         
     }else
    
     
  if (accion.equals("GrabaAnotacion"))   {
      String contGraba= request.getParameter("graba");
     if(contGraba==null){
           contGraba="0";
     }
    String codanotacioncli;
              codanotacioncli= request.getParameter("clianotacion");
      int contaanot=         sqlImplements.contadorAnotaciones(codanotacioncli, cn_sql);
      //hacer la actualizada
     
  
               
              
           if (accion2.equals("ActualizarModificacion"))   { 
           
            sqlImplements.actualizarAnotacion(codigoCampana, descrip,contaanot,cn_sql);
            getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+codanotacioncli.trim()+"&campa="+campaign.trim()+"&desha=closer"+"&refere=valor").forward(request, response);
           
           }else
              
      if (accion2.equals("Cancelar"))   {
          
       
      
          getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+codanotacioncli.trim()+"&campa="+campaign.trim()+"&refere=valor").forward(request, response);
 
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
      getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+codanotacioncli.trim()+"&campa="+campaign.trim()+"&refere=valor&graba="+contGraba).forward(request, response);
  }  else{    
        
      
      
      
        if(xvalorcodigo == null  || xvalorcodigo.equals("")   ){
       xvalorcodigo=  request.getParameter("codCliente") ;
       
     
       
       if(xvalorcodigo == null || xvalorcodigo == "" ){
           xcodigo= request.getParameter("prepcodigo");
      //viene del preparado
            String Consulta="consulta";
           sqlImplements.insertarClienteIdentificador(codigoCampana, xcodigo ,"A",cn_sql);
           Integer Id= sqlImplements.obtenerCodigo(codigoCampana,cn_sql);
           sqlImplements.insertarClienteResultadoLlamada(Id,xcodigo,codigoCampana,cn_sql);  
           sqlImplements.insertarClienteManual(Id,Consulta,cn_sql);
           sqlImplements.insertarClienteAnotacion(Id,Consulta,xcodigo,cn_sql);
          
           
            String estadocad=   sqlImplements.estadocad(campaign,cn_sql);
            
             
            if(estadocad.equals("Inicia manual con cliente" ) || estadocad.equals("Preparado") || estadocad.equals("Error Agente")  ){}else{
          sqlImplements.insertarestador( campaign,"", "","Inicia manual con cliente",cn_sql);}
            System.out.println("Entro al consultor1");
           String conta="0";
          Integer Idx= sqlImplements.obtenerCodigo(codigoCampana,cn_sql);
          sqlImplements.insertclickttocall(Idx,codigoCampana,conta,cn_sql);
     cerrar.cerrar(cn_sql);
       getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+xcodigo.trim()+"&campa="+campaign.trim()+"&actualiza=valor").forward(request, response);    

       }else{
           //viene del Detallado
             xcodigo = xvalorcodigo.trim();
     cerrar.cerrar(cn_sql);
       getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+xcodigo.trim()+"&campa="+campaign.trim()+"&actualiza=valor").forward(request, response);
    }
       }else {
         //viene de la caja de texto de consultor
            xcodigo= xvalorcodigo.trim();
     
           String Consulta="consulta";
            sqlImplements.insertarClienteIdentificador(codigoCampana, xcodigo ,"M",cn_sql);
           Integer Id= sqlImplements.obtenerCodigo(codigoCampana,cn_sql);
           sqlImplements.insertarClienteResultadoLlamada(Id,xcodigo,codigoCampana,cn_sql);  
           sqlImplements.insertarClienteManual(Id,Consulta,cn_sql);
           sqlImplements.insertarClienteAnotacion(Id,Consulta,xcodigo,cn_sql);
           
           String conta="0";
            Integer Idx= sqlImplements.obtenerCodigo(codigoCampana,cn_sql);
          sqlImplements.insertclickttocall(Idx,codigoCampana,conta,cn_sql);
          
          
          String estadocad=   sqlImplements.estadocad(campaign,cn_sql);
            
             
            if(estadocad.equals("Inicia manual con cliente" ) || estadocad.equals("Preparado") || estadocad.equals("Error Agente")){}else{
          sqlImplements.insertarestador( campaign,"", "","Inicia manual con cliente",cn_sql);}
            
            
            System.out.println("Entro al consultor2 ");
       cerrar.cerrar(cn_sql);
        getServletContext().getRequestDispatcher("/CONSULTOR2.jsp?campana="+codigoCampana+"&txtcodigo="+xcodigo.trim()+"&campa="+campaign.trim()+"&actualiza=valor").forward(request, response); 
        } 
        
 }
    
    
        
   
    

    
}
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
