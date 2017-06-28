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
      
        String nombre = request.getParameter("txtnombre");
        String DNI = request.getParameter("txtdni");
        String RUC = request.getParameter("txtRUC");
        String fijo1 = request.getParameter("txtfijo1");
        String fijo2 = request.getParameter("txtfijo2");
        String celular1 = request.getParameter("txtCelular1");
        String celular2 = request.getParameter("txtCelular2");
        String tipocliente = request.getParameter("txtcbtipocliente");

        String txttipollamada = request.getParameter("txttipollamada");
        String txtresultado = request.getParameter("txtresultado");
        String txtrazoncontacto = request.getParameter("txtrazoncontacto");
        String txtrazonNoConacto = request.getParameter("txtrazonNoConacto");

        String Scliente = request.getParameter("Scliente");
        //System.out.println("valor decodigo resultado===>"+tipocliente);
        String varnombre = request.getParameter("varnombre");
        String varDNI = request.getParameter("varDNI");
        String varRUC = request.getParameter("varRUC");
        String nombrecliente = request.getParameter("nombrecliente");

        String numeroentrante = request.getParameter("numeroentrante");

        String campana = request.getParameter("campana");
        String campa = request.getParameter("campa");
        String codresul = request.getParameter("codcli");

        String accion = request.getParameter("accionResul");
        HttpSession session = request.getSession();

        String tipo_gestion = (String) session.getAttribute("TipoGestion");if(tipo_gestion==null){tipo_gestion="";}
        String ClienteAlta = (String) session.getAttribute("ClienteAlta");
        String DNIAlta = (String) session.getAttribute("DNIALTA");
        String RUCAlta = (String) session.getAttribute("RUCALTA");
        
        String Agendado= request.getParameter("txtidagenda");if(Agendado==null){Agendado="";}

        ////System.out.println("Agendado=========> "+RUCAlta);
        
        String  txthiFijo1= request.getParameter("txthiFijo1");
        String  txthiFijo2= request.getParameter("txthiFijo2");
        String txthicelular1 = request.getParameter("txthicelular1");
        String txthicelular2 = request.getParameter("txthicelular2");
        
        String  fechahidden =request.getParameter("fechahidden");
        
////System.out.println(" sesssion DNIAlta==========================================================>"+DNIAlta);
        String txthidni= request.getParameter("txthidni");
      
      //Nuevos parametros
     String txtrecojo= request.getParameter("txtrecojo");
     if(txtrecojo==null)txtrecojo="";
    String  txtcobranza= request.getParameter("txtcobranza");
     if(txtcobranza==null) txtcobranza="";
     String  thtevento= request.getParameter("thtevento");
      if(thtevento==null) thtevento="";
    
       clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();

  
     
    /////   
      /************Se agrega a sac el modulo de agregar clientes *******************/ 
         int id=sqlImplements.obtenerCodigoSAC(campana, cn_rascalLocal);
      if(accion.equals("grabaGestion")){
         String identificador="";
         String tipo_identificador="";
            if(varnombre==null ||varnombre.equals("")  || varnombre.equals("null")){
              
             nombrecliente=ClienteAlta;
          }else{
            ///
             nombrecliente= varnombre;
          }
          String Apellido="";
     
          if( (varDNI==null || varDNI.equals("null") || varDNI.equals("") ) && (DNIAlta==null || DNIAlta.equals("null") || DNIAlta.equals("") ) ){
              
          }else{
              DNI=varDNI;
              
              if (DNI==null || DNI.equals("null")|| DNI.equals("")){
                  identificador=DNIAlta;
              }else{
              
              identificador=varDNI;
              }
              
              /*if(txthidni!=null||txthidni!="null" || txthidni!="" ){
                  identificador=txthidni;
              }*/
              
              tipo_identificador="DNI";
          }
          
          if( (varRUC==null || varRUC.equals("null") || varRUC.equals("")) && (RUCAlta==null || RUCAlta.equals("null") || RUCAlta.equals(""))  ){
              
              
              
          }else{
              RUC=varRUC;
              if (RUC==null || RUC.equals("null")|| RUC.equals("")){
                  identificador=RUCAlta;
              }else{
              
              identificador=varRUC;
              }
              
              
              
               tipo_identificador="RUC";
          }
     
          if(codresul==null || codresul.equals("null") ||codresul.equals("") ){
              
          }else{
             identificador =codresul;
      //// System.out.println("identifiacdororororoor"+codresul);   
               tipo_identificador="CODIGO CLIENTE";
          }
 
       if(    Scliente== null ||Scliente.equals("null") || Scliente.equals("")    ){
           
           
       
       
          
          sqlImplements.UpdateIdentificadorSAC(nombrecliente,tipo_identificador, Apellido,campana, identificador, cn_rascalLocal);

 int contacliente= sqlImplements.contadorSACcliente(tipo_gestion, identificador, cn_rascalLocal);
    //// System.out.println("identificador===================>"+contacliente);   
 if(contacliente==0){   
    contacliente=1;
    ///////  System.out.println("identificador===================>"+contacliente);   
     sqlImplements.insertcontadorClienteSAC(tipo_gestion, identificador, contacliente, cn_rascalLocal)  ;
     
     
 }else{
     contacliente++;
    
    sqlImplements.UpdatecontadorClienteSAC(tipo_gestion, identificador, contacliente, cn_rascalLocal);
     
 }

String Numero= sqlImplements.NumeroGestionSac(id, cn_rascalLocal);
 
 int contaContacto= sqlImplements.contadorSACcontacto(Numero, tipo_gestion, identificador, cn_rascalLocal);
 int countContacto=  sqlImplements.countSACcontacto(Numero, tipo_gestion, identificador, cn_rascalLocal);
 if( (tipo_gestion.equals("Manual") ||tipo_gestion.equals("") )&& Numero.equals("") && countContacto==1 && contaContacto==0 ){
     
 }else{
  if(contaContacto==0){
      
      if((tipo_gestion.equals("Manual")||tipo_gestion.equals("")) && Numero.equals("") ){
          
      }else{
      contaContacto=1;
      }
      
     sqlImplements.insertcontadorConactoSAC(Numero, tipo_gestion, identificador, contaContacto, campana,cn_rascalLocal);
 }else{
      
      if((tipo_gestion.equals("Manual")||tipo_gestion.equals("")) && Numero.equals("") ){
          
      }else{
     contaContacto++;
      }
      ///String telefono, String  gestion,String identificador,int contador 
      ////String telefono, String  gestion,String identificador,int contador
     sqlImplements.UpdatecontadorConactoSAC(Numero, tipo_gestion, identificador, contaContacto, cn_rascalLocal);
     
 }
 }

  
          sqlImplements.InsertClienteResultadoGestionSAC(tipo_identificador,identificador, tipocliente, txttipollamada, txtresultado, txtrazoncontacto, txtrazonNoConacto, campana, cn_rascalLocal);
   
       }else{
           
        
           
              sqlImplements.InsertClienteResultadoGestionSAC(tipo_identificador,identificador, tipocliente, txttipollamada, txtresultado, txtrazoncontacto, txtrazonNoConacto, campana, cn_rascalLocal);
      
       }
       
       
       if(Agendado.equals("Agendado")){
           
           
    sqlImplements.InsertClienteAgendaSAC(campana, tipo_identificador, identificador, txthiFijo1, txthiFijo2, txthicelular1, txthicelular2, fechahidden, cn_rascalLocal);
    
           
       }
       
       
             String check= request.getParameter("txtventaU");
             String txtCaja =  request.getParameter("txtcja");
             
             if(check.equals("VALOR")){
                 
                 
                 sqlImplements.PROCEDUREVENTASAC(identificador, campana,txtCaja,cn_rascalLocal);
                 
                 System.out.println("codigogogog "+identificador);
                 
             }
       
       
 getServletContext().getRequestDispatcher("/CuerpoResultado.jsp?campana="+campana+"&campa="+campa+"&Grabagestion=valor&Identificador="+identificador+"&tipo_gestion="+tipo_gestion).forward(request, response);     
        
      }else
       
       if (accion.equals("grabacliente")) {
            String identificador="";
             String tipo_identificador="";
             
          sqlImplements.insertarClienteSAC(nombre, DNI, fijo1, fijo2, celular1, celular2, tipocliente, RUC,id,campana ,cn_rascalLocal);
          
         
            if(nombre==null ||nombre.equals("")  || nombre.equals("null")){
              
             
          }else{
         
             nombrecliente= nombre;
          }
          String Apellido="";
          if( DNI==null || DNI=="null" || DNI==""  ){
              
          }else{
            
              identificador=DNI;
              tipo_identificador="DNI";
          }
          
          if( RUC==null || RUC=="null" || RUC==""  ){
              
          }else{
             /// RUC=varRUC;
               identificador=RUC;
                tipo_identificador="RUC";
          }
          
        
      /// System.out.println("DNI========>"+DNI+"RUC==>"+RUC+"codresul==>"+codresul+"identificador"+identificador);
          sqlImplements.UpdateIdentificadorSAC(nombrecliente,tipo_identificador, Apellido,campana, identificador, cn_rascalLocal);
     
            int contacliente= sqlImplements.contadorSACcliente(tipo_gestion, identificador, cn_rascalLocal);
    
 if(contacliente==0){   
    contacliente=1;
     sqlImplements.insertcontadorClienteSAC(tipo_gestion, identificador, contacliente, cn_rascalLocal)  ;
     
     
 }else{
     contacliente++;
    
    sqlImplements.UpdatecontadorClienteSAC(tipo_gestion, identificador, contacliente, cn_rascalLocal);
     
 }

String Numero= sqlImplements.NumeroGestionSac(id, cn_rascalLocal);
 
 int contaContacto= sqlImplements.contadorSACcontacto(Numero, tipo_gestion, identificador, cn_rascalLocal);
  
  if(contaContacto==0){
      contaContacto=1;
     sqlImplements.insertcontadorConactoSAC(Numero, tipo_gestion, identificador, contaContacto,campana, cn_rascalLocal);
 }else{
      
     contaContacto++;
      ///String telefono, String  gestion,String identificador,int contador 
      ////String telefono, String  gestion,String identificador,int contador
     sqlImplements.UpdatecontadorConactoSAC(Numero, tipo_gestion, identificador, contaContacto, cn_rascalLocal);
     
 }
  //   System.out.println("Identificador Servlettt===========>"+identificador);  
          getServletContext().getRequestDispatcher("/CuerpoResultado.jsp?campana="+campana+"&campa="+campa+"&retorno=graba&DNI="+DNI+"&RUC="+RUC+"&nombre="+nombre+"&Identificador="+identificador+"&Scliente=valor").forward(request, response);     
         
      }else
       if (accion.equals("llamadaManual")) {
  ///       System.out.println("valorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
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
               //session.setAttribute("contador", contador);
               
                Integer Id= sqlImplements.obtenerCodigoSAC(campana,cn_rascalLocal);
                sqlImplements.UpdateIdentificadorSAC(Nro,Id,cn_rascalLocal);
               
               sqlImplements.insertarestador( campana.substring(5),"", "","clicktocall",cn_sql);
               sqlImplements.updateclickttocall(Id,campana,Integer.toString(contador),cn_sql);
              //   getServletContext().getRequestDispatcher("/Informacion_Cliente.jsp?campana="+campana+"&codcli="+codCliente+"&valor="+valor).forward(request, response);
                cerrar.cerrar(cn_sql);
                 cerrar.cerrar(cn_rascalLocal);
                getServletContext().getRequestDispatcher("/cabeceraResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);
        //   getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
            else {
                 ///// System.out.println("sYSTEMMENTRO222222222222222222222222222222222222222222222222222");
            String Tipo = "Manual";
              int id_llamada=0;
           sqlImplements.InsertClienteIdentificadorSAC(Tipo,id_llamada,Nro,campana,cn_rascalLocal);
          //////////////  cn_rascalLocal.close();
             ///Integer Id= sqlImplements.obtenerCodigo(codigoCampana,cn_rascalLocal);
             
             
           // sqlImplements.insertarClienteManual1(Id,Nro,cn_sql);
          Integer Idx= sqlImplements.obtenerCodigoSAC(campana,cn_rascalLocal);
            sqlImplements.insertclickttocall(Idx,campana,Integer.toString(contador),cn_sql);
            cerrar.cerrar(cn_sql);
            cerrar.cerrar(cn_rascalLocal);
           getServletContext().getRequestDispatcher("/cabeceraResultado.jsp?codcli="+codresul+"&campana="+campana+"&campa="+campa+"&Graba=graba&actuali=valor").forward(request, response);
            //  getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
 
          }
            
  }else if (accion.equals("Llamar")){
         
            String nro= request.getParameter("numerox");  
      Integer Idx= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
                sqlImplements.UpdateClienteManual(nro,Idx,cn_sql);
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
