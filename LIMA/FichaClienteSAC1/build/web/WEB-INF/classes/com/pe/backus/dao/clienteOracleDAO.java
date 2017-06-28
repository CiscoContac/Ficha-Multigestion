/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.dao;

import com.pe.backus.dto.beanAnotacionAgente;
import com.pe.backus.dto.beanClienteBo;
import com.pe.backus.dto.beanCredito;
import com.pe.backus.dto.beanDisponibilidad;
import com.pe.backus.dto.beanFecha;
import com.pe.backus.dto.beanProducto;
import com.pe.backus.dto.beanSumatoriaSemanas;
import com.pe.backus.dto.beanTelefonoParentesco;
import com.pe.backus.dto.beanTotalCantidad;
import com.pe.backus.dto.beanobtenersemanporpodycant;
import com.pe.backus.dto.beansemaxprod;
import com.pe.backus.dto.beantabladinamica;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface clienteOracleDAO {
    
     public List<beanFecha> ObtenerMes(String xcodigo,String valor,Connection con);
    public List ObtenerSemana(String xcodigo,Connection con);
    public List contcombmes(String xcodigo,String xnummes,String anio ,Connection con); 
    public List descripcionCategoria(String xcodigo,Connection con);
    public List listaProductos(String xcodigo, String xcategoria,Connection con);
    public List contadorCategoria(String xcodigo,String sprod,Connection con);
    public int  listaSumaCapacidad(String xcodigo, String xcategoria,Connection con);
    public List<beanProducto> ObtenerDescripcionEnvace(String xcodigo,String sprod,Connection con);
     public List<beanobtenersemanporpodycant> obtenersemanporprodycant(String xcodigo, String xprod, String xcapacidad,Connection con);
    public List contadorNrosemana(String xcodigo, String sem_prod,Connection con);
    //el ST9 se reutiliza, ST10 no existe
   public List  ObtenerCantidadEquiv(String xcodigo, String sem_prod, String capacidad, String sprod,String nromes,Connection con);
    public int   sumaDesmarca(String xcodigo, String xcategoria,Connection con);
 public List<beanTotalCantidad> obtieneEnvaceCapaSemana(String xcodigo, String xcategoria, String sem_prod,int flag,String nromes,Connection con);
     public List obtenesemanaAño(String xcodigo,Connection con);
     
   
 
 public void ejecutarpocedue( String xcodigo,Connection con);

  public List totalxfilas(String xcodigo, String xprod, String xcapacidad,Connection con);
 public List totaldeproycate (String xcodigo, String xcategoria,int flag,Connection con);
  public List<beantabladinamica> ObtenerTablaDinamica1(String s1,String producto,String codcliente,Connection con); 
//

public List<beanAnotacionAgente> AnotacionAgente(String xcodigo,Connection con);
 public List AnotacionAgentedos(String xcodigo,Connection con);
public List<beanDisponibilidad> DISPONIBILIDAD(String xcodigo,Connection con);
public List MARCADISPONIBILIDAD(String xcodigo,Connection con);
 public List<beanClienteBo> ClienteBo(String xcodigo,Connection con);
 
public List disponibleventa(String xcodigo,String marca,String sku,Connection con);
  
   public List<beanCredito> Antiguedad(String xcodigo,Connection con);
 
    public List<beanCredito>Credito (String xcodigo,Connection con);
public List skudisponiblidad(String xcodigo,Connection con);

    public List<beanSumatoriaSemanas> SumatoriadeCajaEquivalente1(String s1,String producto,String codcliente,Connection con);
 
    
    ////
     public List<beansemaxprod> sumaporproductos(String s1,String s2,String s3,String s4,String s5,String s6, String producto,String codcliente,Connection con);
  public int contadorproductos(String xcodigo,Connection con);
}
