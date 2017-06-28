/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.dao;

import com.pe.backus.dto.beanAnotacion;
import com.pe.backus.dto.beanClienteTelefono;
import com.pe.backus.dto.beanClienteTelefonoLocal;
import com.pe.backus.dto.beanListaClickTocall;
import com.pe.backus.dto.beanResuLLamada;
import com.pe.backus.dto.beanTelefonoAgregados;
import com.pe.backus.dto.beanTelefonoClienteLista;
import com.pe.backus.dto.beanTelefonoParentesco;
import com.pe.backus.dto.beansemaxprod;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface clienteSqlDAO {
    
    public List<beanAnotacion> ObtenerFecha(String xcodigo,Connection con);
public List <beanClienteTelefono> ObtenerTelefono(String codigocliente);
//public List<beanDetalladoCliente> ObtenerDetalle(String campana);
public int obtenerCodigo(String campana,Connection con);
public int insertarClienteIdentificador( String campana, String codCliente,String tipo,Connection con );
public int insertarClienteManual(int id,String Nro,Connection con) ;
public int insertarClienteAnotacion(int id,String Anotacion,String codcli,Connection con);
public int insertarClienteParentesco (String CodCliente, String Nro, String Parentesco ,String Nombre);
public int insertarClienteResultadoLlamada(int id,String xcodigo,String campana,Connection con);
public int UpdateClienteManual(String Nro, Integer Id,Connection cn);
public  List<beanResuLLamada> obtenerResultadoLlamada(   String xcodigo,Connection con);
public void actualizarResultadoLlamada(String campana,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String NoVentaGaseosa,String NoventaAgua,String NoventaMalta,String tipgestion,String txtenvase,Connection con);
public void eliminaResultadoLlamada(String campana);
public void actualizarAnotacion(String campana , String Anotacion,int cont ,Connection con );
public int VerificarCodigo(String codigox,Connection con);
 public int ActualizarClienteTelefono(String campana, String codCliente,String nro1,String nro2 ,String nro3 ,String nro4,Connection con  );
public int insertarVentanaHoraria(String campana, String codCliente,String rango, Connection con  );
 //public int VerificarCodigoVentanaHoraria(String codigox,String campana,Connection con);
 //public int ActualizarVentanaHoraria(String campana, String codCliente,String rango,Connection con );
  public List<beanClienteTelefonoLocal> ObtenerTelefonoLocal(String codigocliente);
 
    public int insertarClienteTelefono(String campana, String codCliente,String nro1,String nro2 ,String nro3 ,String nro4  ,Connection con);

      //nuevos
    
public List<beanTelefonoClienteLista> ObtenerTelefonoLista(String codcliente,Connection con);
   public int ModificacionNro(int id,String nroantiguo,String modificado,String codcliente,Connection con);
    public int EliminarNro(int id,String nroeliminado,String codcliente,Connection con);
    public String obtenerNroModificado(String nro,String codcliente,Connection con);
    public String obtenerNroEliminado(String nro,String codcliente,Connection con);
    public int InsertarNroNuevo(int id,String nro,String CodCliente,Connection con);
    public List<beanTelefonoAgregados> ObtenerTelefonoAgregados(String codcliente,Connection con);
    public int VerificarNroDeCliente(String nro,String CodCliente,Connection con);
    public void eliminarNroAgregado(String codigo,String nro,Connection con);
     public int ModificacionNroAgregado( String codCliente,String nroa,String nron,Integer id,Connection con );
      public int VerificarNroDeClienteLocal(String nro,String CodCliente,Connection con);
       public int VerificarNroDeClienteModificados(String nro,String CodCliente,Connection con);
     public int ActualizarContacto(int id, String codcliente ,String contacto,String contactoa,Connection con);
      public int EliminacionNroModificado(Integer id,String codcliente,String nromodificado,Connection con);
      // public int ActualizarClienteParentesco (String Nroantiguo, String Nro, String Parentesco ,String Nombre,String Campana,Connection con);
      //27/01/2013
       //public int EliminarClienteParentesco (String CodCliente, String Nro,String campana,Connection con); 
       public List ObtieneEfectiidad(String xcodigo,String campa,Connection con);
        public List obtieneContacto( String xcampana,Connection con);
  public List<beanListaClickTocall> ObtenerListaTelefonoClick(String codigocliente);
  
  public void actualizarResultadoLlamada1(String campana,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String NoVentaGaseosa,String NoventaAgua,String NoventaMalta,String tipgestion,Integer id ,String codcli,String txtenvase,Connection con);
  
  public List ListaNumeroContador (String xcodigo,String xnumero,Connection con );
  //  public List <beanTelefonoParentesco> ObtenerTelefonoParentesco(String xcodigo,Connection con);
  public int updateVentanaruta(String campana, String codcli,int contador,String valor,Connection cn) ;
 public int insertarClienteManual1(int id,String Nro,Connection con);
   public int contadordetallado(String campana,Connection con);
}
