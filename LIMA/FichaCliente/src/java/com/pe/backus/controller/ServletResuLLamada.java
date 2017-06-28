package com.pe.backus.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pe.backus.dao.impl.clienteSqlDaoImpl;
import com.pe.backus.dto.beanResuLLamada;
import com.pe.backus.factory.CerrarCursor;
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
 * @author GMD
 */
@WebServlet(urlPatterns = {"/ServletResuLLamada"})
public class ServletResuLLamada extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<title>Servlet ServletResultadoLLamada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletResultadoLLamada at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
         Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
     // Connection cn_sql = sqlresultadoConexion.getSQLConextion();
      CerrarCursor   cerrar =new CerrarCursor();
      String flagSiono= request.getParameter("valoradio")  ;
      String razonnollamada =  request.getParameter("valorcbxrazonllamada");
 
      String catVendia="";
   
      String accion = request.getParameter("accionResul");
      HttpSession session = request.getSession();
      String campana = request.getParameter("campana"); 
      String campa = request.getParameter("campa"); 
      String codresul=request.getParameter("codcli");
      String ventaruta= request.getParameter("ventaruta");
   String    contacto = request.getParameter("contacto");
      String razoncerveza=request.getParameter("valorrbcerveza");
      String  actuventa=request.getParameter("actuventa");
  
    ///////  System.out.println("valor decodigo resultado===>"+codresul);

      
      
      if (razoncerveza==null  || razoncerveza.equals("") ){
          razoncerveza="";
      }


      String nocerveza=request.getParameter("valorcbxnocerveza");

      String tipogestion=request.getParameter("valortipogestion");

      //Nuevos parametros
     String txtrecojo= request.getParameter("txtrecojo");
     if(txtrecojo==null)txtrecojo="";
    String  txtcobranza= request.getParameter("txtcobranza");
     if(txtcobranza==null) txtcobranza="";
     String  thtevento= request.getParameter("thtevento");
      if(thtevento==null) thtevento="";
      String txtenvase = request.getParameter("txtenvase");
    if(txtenvase==null) txtenvase="";
       clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();

    if (accion.equals("Modifica")){

    String idx =request.getParameter("idactualizado");  
    
    if(idx.equals("")){}else{
    
        Integer id= Integer.parseInt(idx);
        
         String valoradio=request.getParameter("valoradio");
         
           if(valoradio.equals("")) {}else{
      
  /**********************************/

               if(razoncerveza.equals("si")){
                   razoncerveza="Si";
               }else if (razoncerveza.equals("No") ){
                   razoncerveza="No";
               }else{
                   razoncerveza="";
               }
               ///[lado]
 sqlImplements.actualizarResultadoLlamada1(campana, flagSiono, razonnollamada, razoncerveza, catVendia, nocerveza, txtrecojo, txtcobranza, thtevento,tipogestion,id,codresul,txtenvase,cn_rascalLocal);

  if(contacto.equals("sicontacto")){
        sqlImplements.updateContacto(""+id, codresul, 1,"0", cn_rascalLocal);
    }else if(contacto.equals("nocontacto")){
         sqlImplements.updateContacto(""+id, codresul, 0,"0", cn_rascalLocal);
    }
  
 if(ventaruta.equals("ventaruta")){
        sqlImplements.updateVentanaruta(""+id, codresul, 1,"0" ,cn_rascalLocal);
        //System.out.println("solucion  valorizada" );
    }else if(ventaruta.equals("noruta")){
        sqlImplements.updateVentanaruta(""+id, codresul,0,"0",  cn_rascalLocal); 
    } 


           
 
   cerrar.cerrar(cn_sql);
     cerrar.cerrar(cn_rascalLocal);
    getServletContext().getRequestDispatcher("/CuerpoResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);       
   
           } }  }
    
  else if (accion.equals("GrabaResultado")){
       
      Integer cont=sqlImplements.contadorVentas(codresul,cn_rascalLocal);
     // System.out.println("El contaventa es : "+cont);
       if(cont !=0){
         cerrar.cerrar(cn_sql);   
  getServletContext().getRequestDispatcher("/CuerpoResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);     
        
          
       }else{
       String valoradio=request.getParameter("valoradio");
       
    if(valoradio.equals("")) {}else{
       
   if(razoncerveza.equals("si")){
                   razoncerveza="Si";
               }else if (razoncerveza.equals("No") ){
                   razoncerveza="No";
               }else{
                   razoncerveza="";
               }
   String condicion="";
        if (actuventa.equals("actuventa")){
 sqlImplements.actualizarResultadoLlamada1(campana, flagSiono, razonnollamada, razoncerveza, catVendia, nocerveza, txtrecojo, txtcobranza, thtevento,tipogestion,1,codresul,txtenvase,cn_rascalLocal);
      //// System.out.println("ENTRO A RESULTADO 1 ");
condicion="modificacion";
        }else{
            
    //AQUI ES CAUNDO SE GENERA UNA FILA DEL IDENTIFICADOOR

          sqlImplements.actualizarResultadoLlamada(campana, flagSiono, razonnollamada, razoncerveza, catVendia, nocerveza, txtrecojo, txtcobranza, thtevento, tipogestion,txtenvase,cn_rascalLocal);
  
    }        

        
        
  if(contacto.equals("sicontacto")){
         
     //if resultado codigo es contacto el ultimo con la campña  contador 1
      
      if(condicion.equals("modificacion")){
          
        sqlImplements.updateContacto(campana, codresul, 1,"2", cn_rascalLocal);
        
  }else{
        sqlImplements.updateContacto(campana, codresul, 1,"1", cn_rascalLocal);
        
      }
        
  }
  
  if(ventaruta.equals("ventaruta")){
     
      if(condicion.equals("modificacion")){
          
       sqlImplements.updateVentanaruta(campana, codresul, 1,"2", cn_rascalLocal);
        
  }else{
         sqlImplements.updateVentanaruta(campana, codresul, 1,"1", cn_rascalLocal);
        
    }

     
        //System.out.println("solucion  valorizada" );
        
 }else if(ventaruta.equals("noruta")){
     
     if(condicion.equals("modificacion")){
          
       sqlImplements.updateVentanaruta(campana, codresul,0, "2", cn_rascalLocal); 
        
  }else{
         
         sqlImplements.updateVentanaruta(campana, codresul,0, "1", cn_rascalLocal); 
         
    }
       
  } 

   
    
 }    
       cerrar.cerrar(cn_sql);
    
     cerrar.cerrar(cn_rascalLocal);
    getServletContext().getRequestDispatcher("/CuerpoResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);     
   }     
   }else    if (accion.equals("llamadaManual")) {
               int contador= sqlImplements.obtieneContador(campana,cn_sql);
               String estadocad=  sqlImplements.estadocad(campa,cn_sql);
            String codcliSession="";
                 
                codcliSession=request.getParameter("codCliente");
            ///String codCliente = request.getParameter("CodClienteDetalle");
          
            String Nro = request.getParameter("telefonoSelect"); 
                String valor="valor";        
          if(estadocad.equals("clicktocall") || estadocad.equals("Preparado")){
               getServletContext().getRequestDispatcher("/cabeceraResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);
          } else{     
            if (/*codcliSession.equals(codCliente) && */contador==0 ) {
              // session.removeAttribute("contador");
           
                contador++;
       
               
                Integer Id= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
                sqlImplements.UpdateClienteManual(Nro,Id,cn_sql);
               sqlImplements.insertarestador( campana.substring(5),"", "","clicktocall",cn_sql);
               sqlImplements.updateclickttocall(Id,campana,Integer.toString(contador),cn_sql);
              //   getServletContext().getRequestDispatcher("/Informacion_Cliente.jsp?campana="+campana+"&codcli="+codCliente+"&valor="+valor).forward(request, response);
               cerrar.cerrar(cn_sql);
     cerrar.cerrar(cn_rascalLocal);
                getServletContext().getRequestDispatcher("/cabeceraResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);
        //   getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
            else {
               
            String Consulta1 = "consulta";
            sqlImplements.insertarClienteIdentificador(campana, codresul,"M",cn_rascalLocal);
             Integer Id= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
            sqlImplements.insertarClienteManual1(Id,Nro,cn_sql);
            sqlImplements.insertarClienteAnotacion(Id,Consulta1,codresul,cn_rascalLocal);
            sqlImplements.insertarClienteResultadoLlamada(Id,codresul,campana,cn_rascalLocal);
            sqlImplements.insertarestador( campana.substring(5),"", "","clicktocall",cn_sql);
           //  getServletContext().getRequestDispatcher("/Informacion_Cliente.jsp?campana="+campana+"&codcli="+codCliente+"&valor="+valor).forward(request, response);
            Integer Idx= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
            sqlImplements.insertclickttocall(Idx,campana,Integer.toString(contador),cn_sql);
           cerrar.cerrar(cn_sql);
     cerrar.cerrar(cn_rascalLocal);
           getServletContext().getRequestDispatcher("/cabeceraResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);
            //  getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
 
          }
            
  }else if (accion.equals("Llamar")){
         
            String nro= request.getParameter("numerox");  
     
                 cerrar.cerrar(cn_sql);
     cerrar.cerrar(cn_rascalLocal);
                   getServletContext().getRequestDispatcher("/cabeceraResultado.jsp?campana="+campana+"&codcli="+codresul+"&campa="+campa+"&numeroclicktocholl=9"+nro+"&actualilllamar=valor&numerito=valor").forward(request, response);
        
          }else{
       
     cerrar.cerrar(cn_sql);
     cerrar.cerrar(cn_rascalLocal);
    getServletContext().getRequestDispatcher("/cabeceraResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&numerito=graba&actuali=valor").forward(request, response);     
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
