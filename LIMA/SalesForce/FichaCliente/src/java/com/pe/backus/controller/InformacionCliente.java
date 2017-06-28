/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.backus.controller;

import com.pe.backus.dao.impl.clienteOracleDaoImpl;
import com.pe.backus.dao.impl.clienteSqlDaoImpl;
import com.pe.backus.dto.beanClienteTelefono;
import com.pe.backus.dto.beanClienteTelefonoLocal;
import com.pe.backus.dto.beanResuLLamada;
import com.pe.backus.dto.beanTelefonoParentesco;
import com.pe.backus.factory.CerrarCursor;
import com.pe.backus.factory.oracleDaoLocalFactoryImpl;
import com.pe.backus.factory.oraclefactooriginal;
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
@WebServlet(name = "InformacionCliente", urlPatterns = {"/InformacionCliente"})
public class InformacionCliente extends HttpServlet {

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
          //  String codCliente=  request.getParameter("GenCodigo");
           // String  campana = request.getParameter("campana");
   /// getServletContext().getRequestDispatcher("/Informacion_Cliente.jsp?codcli="+codCliente+"&campana="+campana+"&afonos=afonos").forward(request, response);
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
        
HttpSession session = request.getSession();


/******************Conexiones  poll*****************/
   Connection  cnNC           = oracleDaoLocalFactoryImpl.getSQLConextion();
Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
CerrarCursor  cerrar = new CerrarCursor();
/*********************************************************************/
clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
String valor="valor";
String accion = request.getParameter("accionHtml");
String  campana = request.getParameter("campana");
String campaign= request.getParameter("campa");
String codCliente=  request.getParameter("GenCodigo");
int contador =sqlImplements.obtieneContador(campana,cn_sql);
        
        System.out.println("valor de la accion "+accion);
if (accion.equals("Llamar")){
         
String nro= request.getParameter("numerox");  
String xcodigo1= request.getParameter("CodClienteDetalle");      
//session.setAttribute("numeroclicktocholl", nro);
cerrar.cerrar(cn_sql);
cerrar.cerrar(cnNC);
cerrar.cerrar(cn_sql);
cerrar.cerrar(cn_rascalLocal);
getServletContext().getRequestDispatcher("/ClicikInformacion.jsp?campana="+campana+"&codcli="+codCliente+"&numeroclicktocholl=9"+nro+"&otro=valor&numerito=valor").forward(request, response);
}else

if (accion.equals("llamadaManual")) {
  String estadocad=  sqlImplements.estadocad(campaign,cn_sql);
        String codcliSession="";
     
                codcliSession=request.getParameter("GenCodigo");

           
            String codClien = request.getParameter("GenCodigo");
            String campa = request.getParameter("campana"); 
            String Nro = request.getParameter("telefonoSelect"); 
                String val="valor";        
                String konstante="constante";
     if(estadocad.equals("clicktocall") || estadocad.equals("Preparado") ){
 getServletContext().getRequestDispatcher("/ClicikInformacion.jsp?campana="+campa+"&codcli="+codClien+"&valor="+val+"&konstante="+konstante+"&contador="+contador+"&llamadas=afonos").forward(request, response);               //   getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&valor="+valor+"&contador="+contador+"&manual=").forward(request, response);
         
     }else{           
            if ( contador==0 ) {
              // session.removeAttribute("contador");
              
                contador++;
           
                Integer Id= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
                sqlImplements.UpdateClienteManual(Nro,Id,cn_sql);
               
               sqlImplements.insertarestador( campana.substring(5),"", "","clicktocall",cn_sql);
                sqlImplements.updateclickttocall(Id,campana,Integer.toString(contador),cn_sql);
               //  System.out.println("contador" + contador);
                 cerrar.cerrar(cn_sql);
                 cerrar.cerrar(cnNC);
                    cerrar.cerrar(cn_rascalLocal);
               getServletContext().getRequestDispatcher("/ClicikInformacion.jsp?campana="+campa+"&codcli="+codClien+"&valor="+val+"&konstante="+konstante+"&contador="+contador+"&llamadas=afonos").forward(request, response);               //   getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&valor="+valor+"&contador="+contador+"&manual=").forward(request, response);
        //   getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
            else {
               
            String Consulta1 = "consulta";
            sqlImplements.insertarClienteIdentificador(campana, codCliente,"M",cn_rascalLocal);
            
            Integer Id= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
            sqlImplements.insertarClienteManual(Id,Nro,cn_sql);
            sqlImplements.insertarClienteAnotacion(Id,Consulta1,codCliente,cn_rascalLocal);
            sqlImplements.insertarClienteResultadoLlamada(Id,codCliente,campana,cn_rascalLocal);
            sqlImplements.insertarestador( campana.substring(5),"", "","clicktocall",cn_sql);
            Integer Idx= sqlImplements.obtenerCodigo(campana,cn_rascalLocal);
             sqlImplements.insertclickttocall(Idx,campana,Integer.toString(contador),cn_sql);
             cerrar.cerrar(cn_sql);
             cerrar.cerrar(cnNC);
                cerrar.cerrar(cn_rascalLocal);
        getServletContext().getRequestDispatcher("/ClicikInformacion.jsp?campana="+campa+"&codcli="+codClien+"&valor="+valor+"&konstante="+konstante+"&contador="+contador+"&llamadas=afonos").forward(request, response);            //  getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&valor="+valor+"&manual=").forward(request, response);
            //  getServletContext().getRequestDispatcher("/detalleLlamada.jsp?campana="+codigoCampana+"&codcli="+codCliente+"&contador="+contador).forward(request, response);
            }
               
       
     }  
            
    
  }else 
  

if (accion.equals("modificarcontacto")){
 String codClien = request.getParameter("GenCodigo");
 String contacto = request.getParameter("contacto1");
 String contacto1 = request.getParameter("contacto");
  Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
     sqlImplements.ModificarContacto (codClien ,  contacto.replace("'", "''"), contacto1.replace("'", "''") , Id , cnNC);
   System.out.println("contacto "+contacto.replace("'", "''"));
     cerrar.cerrar(cn_sql);
           cerrar.cerrar(cnNC);
              cerrar.cerrar(cn_rascalLocal);
           getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&afonos=afonos").forward(request, response);
     
     
     
     
}else

if (accion.equals("eliminacontacto")){
    String codClien = request.getParameter("GenCodigo");
 String contacto = request.getParameter("contacto1");
 String contacto1 = " ";
  Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
     sqlImplements.ModificarContacto (codClien ,  contacto, contacto1 , Id , cnNC);
   
     cerrar.cerrar(cn_sql);
           cerrar.cerrar(cnNC);
              cerrar.cerrar(cn_rascalLocal);
           getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&afonos=afonos").forward(request, response);
      
} else
     



if (accion.equals("Agregar")){
    

        
String telefono = request.getParameter("Telefono");   
String parentesco= request.getParameter("relacion");  
String NombreParentesco= request.getParameter("NombreParentesco");  
String telefonoAntiguo = request.getParameter("numeroantiguo"); 

if(parentesco == null){
    if(telefono==null){}else{
    //  Integer Resultado= sqlImplements.VerificarNroDeCliente(telefono,codCliente,cn_sql);
    //  Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(telefono, codCliente,cnNC);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(telefono, codCliente,cn_sql);
      Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, telefono, cnNC);
      
       if(/*Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&*/Resultado3.equals(0)){
    
oraCliente.ActualizarClienteParentesco(telefonoAntiguo,  telefono,  parentesco , NombreParentesco,campana,cnNC);
      }else{}
    }
         }else{
         
    if(telefono==null){}else{
     /// Integer Resultado= sqlImplements.VerificarNroDeCliente(telefono,codCliente,cn_sql);
     // Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(telefono, codCliente,cnNC);
     // Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(telefono, codCliente,cn_sql);
      Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, telefono, cnNC);
      System.out.println("Resultados 3 "+ Resultado3);
       if(/*Resultado.equals(0)&&Resultado1.equals(0)*//*&&Resultado2.equals(0)&&*/Resultado3.equals(0)){
       int id = sqlImplements.obtenerCodigo(campana, cn_rascalLocal);
     oraCliente.insertarClienteParentesco( id,codCliente,  telefono,  parentesco , NombreParentesco,campana,cnNC);
      }else{
           
       }
    }
         }
        cerrar.cerrar(cn_sql);
           cerrar.cerrar(cnNC);
              cerrar.cerrar(cn_rascalLocal);
        getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&valor="+valor+"&Contacto=valor").forward(request, response);
      
    }else
   

   
       
       if (accion.equals("Eliminar")) {
       
       //System.out.println("Entro a eliminar");
           
           
           String parentesconro = request.getParameter("numeroantiguo"); 
          oraCliente.EliminarClienteParentesco ( codCliente,  parentesconro,campana,cnNC);
         
            cerrar.cerrar(cn_sql);
           cerrar.cerrar(cnNC);
           cerrar.cerrar(cn_sql);
           cerrar.cerrar(cn_rascalLocal);
        getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&valor="+valor+"&Contacto=valor").forward(request, response);
           
       }else
          if (accion.equals("Modificar")){
        
        
     String telefono = request.getParameter("Telefono");   
     String parentesco= request.getParameter("relacion");  
    // String Codcliente = (String) session.getAttribute("codCliente");
     String NombreParentesco= request.getParameter("NombreParentesco");
     
    String telefonoAntiguo = request.getParameter("numeroantiguo");  
     oraCliente.ActualizarClienteParentesco(telefonoAntiguo,  telefono,  parentesco , NombreParentesco,campana,cnNC);
        
        cerrar.cerrar(cn_sql);
           cerrar.cerrar(cnNC);
              cerrar.cerrar(cn_rascalLocal);
     getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&valor="+valor+"&Contacto=valor").forward(request, response);
        }else
          if (accion.equals("GrabarVentanaHoraria")){
         
         
             
             // String Codcliente = (String) session.getAttribute("codCliente");
             // String Campana="0006022175";
              String rango= request.getParameter("rango"); 
              int id = sqlImplements.obtenerCodigo(campana, cn_rascalLocal);
         Integer Resultado= oraCliente.VerificarCodigoVentanaHoraria(id,codCliente,campana,cnNC);
              
              
         if(Resultado.equals(0)){
    //  int id = sqlImplements.obtenerCodigo(campana, cn_sql);
             oraCliente.insertarVentanaHoraria(id,campana, codCliente,rango,campana,cnNC);
             
              
             
         }else{
         
             oraCliente.ActualizarVentanaHoraria(id,campana, codCliente,rango,cnNC );
             
           
         }
            cerrar.cerrar(cn_sql);
           cerrar.cerrar(cnNC);
            cerrar.cerrar(cn_rascalLocal);
          getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&valor="+valor+"&redire=valor").forward(request, response);
         }else{
          
      
        
        
        if (accion.equals("ActualizarTelefono")) {
        
        String nro1 = request.getParameter("text_1"); 
        String nro2 = request.getParameter("text_2");
        String nro3 = request.getParameter("text_3");
        String nro4 = request.getParameter("text_4");  
       // String Codcliente = (String) session.getAttribute("codCliente");
       // String Campana="0006015031";
        //CAMP_0006015031
        //obtiene el codigo de cliente para ver si existe o no 
        Integer Resultado= sqlImplements.VerificarCodigo(codCliente,cn_sql);
        
         if(Resultado.equals(0)){

             sqlImplements.insertarClienteTelefono(campana, codCliente,nro1,nro2,nro3,nro4,cn_sql);
             
              
             
         }else{
         
             sqlImplements.ActualizarClienteTelefono(campana, codCliente, nro1, nro2, nro3, nro4,cn_sql);
             
               
         
         }
         
        }
        
     
      
             
        if (accion.equals("modificarnro1")) {String  nroantiguo = request.getParameter("nroantiguo1");
                String  nromodificado=request.getParameter("nronuevo1"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
                
      //Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
     // Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
     // Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
     // Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
      // if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);//}else{}
              }
        
        
 if (accion.equals("modificarnro2")) {String  nroantiguo = request.getParameter("nroantiguo2");
                String  nromodificado=request.getParameter("nronuevo2"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
                
   //   Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
    //  Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
    //  Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
     // Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
       ///if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);//}else{}
                }
 
 
         if (accion.equals("modificarnro3")) {String  nroantiguo = request.getParameter("nroantiguo3");
                String  nromodificado=request.getParameter("nronuevo3"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
                
     // Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
     // Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
    //  Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
   //   Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
       //if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);//}else{}
                }
         if (accion.equals("modificarnro4")) {String  nroantiguo = request.getParameter("nroantiguo4");
                String  nromodificado=request.getParameter("nronuevo4"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
                
    // Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
     // Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
    //  Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
    //  Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
     //  if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);//}else{}
                }
         if (accion.equals("modificarnro5")) {String  nroantiguo = request.getParameter("nroantiguo5");
                String  nromodificado=request.getParameter("nronuevo5"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
    // Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
      //Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
       //if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);//}else{}
                }
      if (accion.equals("modificarnro6")) {String  nroantiguo = request.getParameter("nroantiguo5");
                String  nromodificado=request.getParameter("nronuevo6"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
   //  Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
     // Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
      //Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
       //if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);//}else{}
                }     
         
     if (accion.equals("modificarnro7")) {String  nroantiguo = request.getParameter("nroantiguo5");
                String  nromodificado=request.getParameter("nronuevo7"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
     /*Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
      Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
      Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
       if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){*/
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);//}else{}
                }      
         
       if (accion.equals("modificarnro8")) {String  nroantiguo = request.getParameter("nroantiguo5");
                String  nromodificado=request.getParameter("nronuevo8"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
     sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);
                }        
       if (accion.equals("modificarnro9")) {String  nroantiguo = request.getParameter("nroantiguo5");
                String  nromodificado=request.getParameter("nronuevo9"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
    sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);
                }      
        if (accion.equals("modificarnro10")) {String  nroantiguo = request.getParameter("nroantiguo5");
                String  nromodificado=request.getParameter("nronuevo10"); 
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
    /* Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_gmrasca);
      Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
      Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nromodificado, cn_sql);
      
       if(Resultado.equals(0)&&Resultado1.equals(0)&&Resultado2.equals(0)&&Resultado3.equals(0)){*/
           sqlImplements.ModificacionNro(Id, nroantiguo, nromodificado,codCliente,cnNC);/*}else{}*/
                }        
         if (accion.equals("eliminarnro1")) {String nroeliminado  = request.getParameter("nroeliminado1");
            Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
            sqlImplements.EliminarNro(Id, nroeliminado,codCliente,cnNC);}
        if (accion.equals("eliminarnro2")) {String nroeliminado  = request.getParameter("nroeliminado2");
            Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
            sqlImplements.EliminarNro(Id, nroeliminado,codCliente,cnNC);}
        if (accion.equals("eliminarnro3")) {String nroeliminado  = request.getParameter("nroeliminado3");
            Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
            sqlImplements.EliminarNro(Id, nroeliminado,codCliente,cnNC);}
        if (accion.equals("eliminarnro4")) {String nroeliminado  = request.getParameter("nroeliminado4");
            Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
            sqlImplements.EliminarNro(Id, nroeliminado,codCliente,cnNC);}
         if (accion.equals("eliminarnro5")) {String nroeliminado  = request.getParameter("nroeliminado5");
            Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
            sqlImplements.EliminarNro(Id, nroeliminado,codCliente,cnNC);}
          if (accion.equals("Grabar")) {
              
      String nronuevo  = request.getParameter("nronuevo");
      
      if(nronuevo.equals("")){}else{
      Integer Resultado= sqlImplements.VerificarNroDeCliente(nronuevo,codCliente,cn_sql);/*problema de validacion 07/04/2013*/
      System.out.println("Contador de resultado "+Resultado);
     Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nronuevo, codCliente,cnNC);
      System.out.println("Contador de Resultado1 "+Resultado1);
     /*  Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nronuevo, codCliente,cn_sql);
      Integer  Resultado3=   sqlImplements.validnumerparente(codCliente, nronuevo, cn_sql);*/
    if(Resultado  ==  0 && Resultado1 ==0 /*&&Resultado2.equals(0)&&Resultado3.equals(0)*/  ){

  System.out.println("ENTRADA DE RESULTADOSSSSS");         
      Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
      System.out.println("IDDDDDDDDD");    
      //Integer contnum= oraCliente.contaagrega(codCliente, cnNC);
      sqlImplements.InsertarNroNuevo(Id, nronuevo,codCliente,cnNC); 
               System.out.println("INSERTO");  
             
         }else{}
}}
          
          
          
   if (accion.equals("eliminarnroa1")) {
     String nroeliminado  = request.getParameter("nroeliminadoa1");
     sqlImplements.eliminarNroAgregado(codCliente,nroeliminado,cnNC);
}   if (accion.equals("eliminarnroa2")) {
     String nroeliminado  = request.getParameter("nroeliminadoa2");
     sqlImplements.eliminarNroAgregado(codCliente,nroeliminado,cnNC);
}  if (accion.equals("eliminarnroa3")) {
     String nroeliminado  = request.getParameter("nroeliminadoa3");
     sqlImplements.eliminarNroAgregado(codCliente,nroeliminado,cnNC);
}    if (accion.equals("eliminarnroa4")) {
     String nroeliminado  = request.getParameter("nroeliminadoa4");
     sqlImplements.eliminarNroAgregado(codCliente,nroeliminado,cnNC);
}    if (accion.equals("eliminarnroa5")) {
     String nroeliminado  = request.getParameter("nroeliminadoa5");
     sqlImplements.eliminarNroAgregado(codCliente,nroeliminado,cnNC);
}    if (accion.equals("eliminarnroa6")) {
     String nroeliminado  = request.getParameter("nroeliminadoa6");
     sqlImplements.eliminarNroAgregado(codCliente,nroeliminado,cnNC);
}    if (accion.equals("eliminarnroa7")) {
     String nroeliminado  = request.getParameter("nroeliminadoa7");
     sqlImplements.eliminarNroAgregado(codCliente,nroeliminado,cnNC);
}   




if (accion.equals("modificarnroag1")) {
    String  nroantiguo = request.getParameter("nroantiguoa1");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa1"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
} 


 if (accion.equals("modificarnroag2")) {String  nroantiguo = request.getParameter("nroantiguoa2");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa2"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}

} 
  if (accion.equals("modificarnroag3")) {String  nroantiguo = request.getParameter("nroantiguoa3");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa3"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
} 
   if (accion.equals("modificarnroag4")) {String  nroantiguo = request.getParameter("nroantiguoa4");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa4"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
} 
   if (accion.equals("modificarnroag5")) {String  nroantiguo = request.getParameter("nroantiguoa5");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa5"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
} 
     if (accion.equals("modificarnroag6")) {String  nroantiguo = request.getParameter("nroantiguoa6");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa6"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
} 
if (accion.equals("modificarnroag7")) {String  nroantiguo = request.getParameter("nroantiguoa7");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa7"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
} 
if (accion.equals("modificarnroag8")) {String  nroantiguo = request.getParameter("nroantiguoa8");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa8"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
}
if (accion.equals("modificarnroag9")) {String  nroantiguo = request.getParameter("nroantiguoa9");
                Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado=request.getParameter("nronuevoa9"); 
Integer Resultado= sqlImplements.VerificarNroDeCliente(nromodificado,codCliente,cn_sql);
      //Integer Resultado1= sqlImplements.VerificarNroDeClienteLocal(nromodificado, codCliente,cn_sql);
      //Integer Resultado2= sqlImplements.VerificarNroDeClienteModificados(nromodificado, codCliente,cn_sql);
if(Resultado.equals(0)/*&&Resultado1.equals(0)&&Resultado2.equals(0)*/){ 
    sqlImplements.ModificacionNroAgregado(  codCliente,nroantiguo, nromodificado,Id ,cnNC);}else{}
}

if (accion.equals("grabarcontacto")) {
String  contacto=request.getParameter("contacto"); 
String  contactoa=request.getParameter("contactoa");
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
sqlImplements.ActualizarContacto( Id,  codCliente , contacto, contactoa,cn_sql);
}
if (accion.equals("eliminarnrom1")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado1");
String nro=request.getParameter("nroeliminado1");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
   sqlImplements.EliminarNrox(nro, codCliente,cnNC);

}
if (accion.equals("eliminarnrom2")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado2");
String nro=request.getParameter("nroeliminado2");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
   sqlImplements.EliminarNrox(nro, codCliente,cnNC);
}
if (accion.equals("eliminarnrom3")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado3");
String nro=request.getParameter("nroeliminado3");
sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
 sqlImplements.EliminarNrox(nro, codCliente,cnNC);
}
if (accion.equals("eliminarnrom4")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado4");
String nro=request.getParameter("nroeliminado4");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cn_sql);
sqlImplements.EliminarNrox(nro, codCliente,cn_sql);
}
if (accion.equals("eliminarnrom5")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado5");
String nro=request.getParameter("nroeliminado5");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
sqlImplements.EliminarNrox(nro, codCliente,cnNC);
}
if (accion.equals("eliminarnrom6")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado6");
String nro=request.getParameter("nroeliminado6");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
sqlImplements.EliminarNrox(nro, codCliente,cnNC);
}
if (accion.equals("eliminarnrom7")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado7");
String nro=request.getParameter("nroeliminado7");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
sqlImplements.EliminarNrox(nro, codCliente,cnNC);
}
if (accion.equals("eliminarnrom8")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado8");
String nro=request.getParameter("nroeliminado8");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
sqlImplements.EliminarNrox(nro, codCliente,cnNC);
}
if (accion.equals("eliminarnrom9")) {
Integer Id=sqlImplements.obtenerCodigo( campana,cn_rascalLocal);
String  nromodificado1=request.getParameter("nroeliminado9");
String nro=request.getParameter("nroeliminado9");
   sqlImplements.EliminacionNroModificado(Id, codCliente, nromodificado1,cnNC);
sqlImplements.EliminarNrox(nro, codCliente,cnNC);
}

       cerrar.cerrar(cn_sql);
           cerrar.cerrar(cnNC);
            cerrar.cerrar(cn_rascalLocal);
           if(accion.equals("retornar")){
    
        getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&afonos=afonos").forward(request, response);
}else
if(accion.equals("regresa")){
    
        getServletContext().getRequestDispatcher("/ClicikInformacion.jsp?codcli="+codCliente+"&campana="+campana+"&numerito=afonos").forward(request, response);
}else{
         

  getServletContext().getRequestDispatcher("/CuerpoInformacion.jsp?codcli="+codCliente+"&campana="+campana).forward(request, response);
         
}
          }      
 
   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }
