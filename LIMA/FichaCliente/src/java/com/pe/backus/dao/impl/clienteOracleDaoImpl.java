/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.dao.impl;

import com.pe.backus.dao.clienteOracleDAO;
import com.pe.backus.dto.beanAnotacionAgente;
import com.pe.backus.dto.beanBonificacion;
import com.pe.backus.dto.beanCampania;
import com.pe.backus.dto.beanClienteBo;
import com.pe.backus.dto.beanCredito;
import com.pe.backus.dto.beanDisponibilidad;
import com.pe.backus.dto.beanFecha;
import com.pe.backus.dto.beanProductividad;
import com.pe.backus.dto.beanProducto;
import com.pe.backus.dto.beanSumatoriaSemanas;
import com.pe.backus.dto.beanTelefonoParentesco;
import com.pe.backus.dto.beanTotalCantidad;
import com.pe.backus.dto.beanobtenersemanporpodycant;
import com.pe.backus.dto.beansemana;
import com.pe.backus.dto.beansemaxprod;
import com.pe.backus.dto.beantabladinamica;
import com.pe.backus.factory.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public   class clienteOracleDaoImpl implements clienteOracleDAO{

     @Override
    public List<beanFecha> ObtenerMes(String xcodigo,String  semana,Connection con) {
        List ListbeanObtieneMes = null;
           ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       
        String sql = "SELECT DISTINCT(CASE(SELECT MONTH (GETDATE()- (1 + "+semana+")) ) \n" +
"                      WHEN '01' THEN 'ENERO' \n" +
"                      WHEN '02' THEN 'FEBRERO'  \n" +
"                     WHEN '03' THEN 'MARZO'   \n" +
"                     WHEN '04' THEN 'ABRIL'  \n" +
"                     WHEN '05' THEN 'MAYO'    \n" +
"                     WHEN '06' THEN 'JUNIO'   \n" +
"                    WHEN '07' THEN 'JULIO'  \n" +
"                     WHEN '08' THEN 'AGOSTO'    \n" +
"                     WHEN '09' THEN 'SETIEMBRE'  \n" +
"                     WHEN '10' THEN 'OCTUBRE'    \n" +
"                     WHEN '11' THEN 'NOVIEMBRE'   \n" +
"                     WHEN '12' THEN 'DICIEMBRE'       \n" +
"                     ELSE 'N/A' END )  mes ; ";
        
      
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        ListbeanObtieneMes = new ArrayList<beanFecha>();
        
                while (rs.next()) {
             // beanFecha bfecha = new beanFecha();
                
               /// bfecha.setMesDescripcion(rs.getString(1));
                //bfecha.setMes(rs.getString(2));
               // bfecha.setAnio(rs.getString(3));
                ListbeanObtieneMes.add(rs.getString(1));
            }
                   
        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerMes :" +e.getMessage());
           ListbeanObtieneMes = null; 
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return ListbeanObtieneMes;
    }

    @Override
     public List obtenesemanaAño(String xcodigo ,Connection con){
           List listObetenersemanaAño = null;
        
           ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
       // Statement st = con.createStatement();
        String sql = "SELECT  PERIODODIASEMA AS FECHA FROM TABLA_PRODUCTOS_BO WHERE   COD_CLI_SAP  =  '"+xcodigo+"'  GROUP BY  PERIODODIASEMA  ORDER BY "+ 
                     "  PERIODODIASEMA "; 
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        listObetenersemanaAño = new ArrayList();
        
                while (rs.next()) {

               listObetenersemanaAño.add(rs.getString(1));
            }
            
               
        
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenesemanaAño :" +e.getMessage());
           listObetenersemanaAño = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return listObetenersemanaAño;
         
     }
     @Override 
    public List<beansemana> ObtenerSemana(String xcodigo,Connection con) {
       List<beansemana> listObtenerSemana = null;
       ResultSet rs =null;
          PreparedStatement ps=null;
        try {
        
        String sql = "SELECT NROSEMANA AS sem_año , aniomes,nromes    "+
                     "FROM TABLA_PRODUCTOS_BO  "+
                    " WHERE    "+
                     "  COD_CLI_SAP  =  '"+xcodigo+"'  "+   
                     " GROUP BY  NROSEMANA ,ANIO  ,aniomes ,nromes  "+
                     " ORDER BY  ANIO ,NROSEMANA "; 
        
       ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        listObtenerSemana = new ArrayList<beansemana>();
        
                while (rs.next()) {
                 beansemana bsemana = new beansemana();
                bsemana.setSemana(rs.getString(1));
                bsemana.setMes(rs.getString(3));
                listObtenerSemana.add(bsemana);
            }
            
             
        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerSemana :" +e.getMessage());
           listObtenerSemana = null; 
        }finally {
            try {
                 rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return listObtenerSemana;
    }
    public List<beanCampania> obtienecampanias(String xcodigo,Connection con) {
       List<beanCampania> listObtenercampania = null;
       ResultSet rs =null;
          PreparedStatement ps=null;
        try {
        
        String sql = "SELECT NOMCAMPANIA, DESCBONIFI, FECHINICIO, FECFIN  " + 
                      " FROM  CAMPANIAS_BO WHERE "
                       + "  COD_CLI_SAP= " + "'"+xcodigo +  "'"  ; 
        
       ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        listObtenercampania = new ArrayList<beanCampania>();
        
                while (rs.next()) {
                 beanCampania campania = new beanCampania();
                campania.setNomCampa(rs.getString(1));
                campania.setDescrBoni(rs.getString(2));
                campania.setFechIni(rs.getString(3));
                campania.setFechFin(rs.getString(4));
                listObtenercampania.add(campania);
            }
            
             
        } catch (Exception e) {
            System.out.println("Error en el metodo obtienecampanias :" +e.getMessage());
        
        }finally {
            try {
                 rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return listObtenercampania;
    }

   public int contadorproductos(String xcodigo,Connection con) {
        int cont=0;
       
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql =" select count(cod_cli_sap)    from tabla_productos_bo \n" +
"    where cod_cli_sap = " + "'"+xcodigo+"'";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
     
        
                while (rs.next()) {
               cont= rs.getInt(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo contadorproductos :" +e.getMessage());
          
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return cont ;
    }
    public List descripcionCategoria(String xcodigo,Connection con) {
        
        List  ListDescripcionCategoria = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql =" Select DESCATEGORIA  as cat   "+
                " FROM    TABLA_PRODUCTOS_BO  "+
                " WHERE   "+
                "  COD_CLI_SAP  =  '"+xcodigo+"'  "+    
               "  group by DESCATEGORIA     "+
               "  order by DESCATEGORIA asc ";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        ListDescripcionCategoria =  new ArrayList();
        
                while (rs.next()) {
               

               
                ListDescripcionCategoria.add(rs.getString(1));
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo descripcionCategoria :" +e.getMessage());
           ListDescripcionCategoria = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return ListDescripcionCategoria;
    }
 
    @Override
    public List listaProductos(String xcodigo, String xcategoria,Connection con) {
        List ListListaProductos = null;
            ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       
        String sql ="Select distinct DESMARCA as prod FROM  TABLA_PRODUCTOS_BO  "+
              " WHERE  "+
              " COD_CLI_SAP  =  '"+xcodigo+"'  "+
              " and DESCATEGORIA= '"+xcategoria+"'  "+
              " GROUP BY DESMARCA,      "+
              "  Diautilmes,    "+
              "  SEMANA     "   ;
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        ListListaProductos = new ArrayList();
        
                while (rs.next()) {

                ListListaProductos.add(rs.getString(1));
            }
            
           
        
        } catch (Exception e) {
            System.out.println("Error en el metodo ListaProductos :" +e.getMessage());
           ListListaProductos = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return ListListaProductos;
    }

    @Override
    public List contadorCategoria(String xcodigo, String sprod,Connection con) {
         List LiscontadorCategoria = null;
         ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       
        String sql = "Select DESCAPACIDAD "+
                 " FROM   TABLA_PRODUCTOS_BO  "+
                " WHERE   "+
                "  COD_CLI_SAP  =  '"+xcodigo+"'  "+  
                " and DESMARCA=      '"+sprod+"'  "+
                " GROUP BY DESCAPACIDAD  ";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        LiscontadorCategoria = new ArrayList();
        
                while (rs.next()) {
               
                LiscontadorCategoria.add(rs.getString(1));
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo contadorCategoria :" +e.getMessage());
           LiscontadorCategoria = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return LiscontadorCategoria;
    }

    @Override
  public int  listaSumaCapacidad(String xcodigo, String xcategoria,Connection con) {
      int xxvalor=0;
        ResultSet rs =null;
          PreparedStatement ps=null;
          
        try {
        
        
        String sql = "SELECT COUNT(*) FROM( Select DESCAPACIDAD, DESENVASE, DESMARCA  \n" +
"  FROM    TABLA_PRODUCTOS_BO\n" +
" WHERE     \n" +
" COD_CLI_SAP  =  '"+xcodigo+"'      \n" +
"and DESCATEGORIA = '"+xcategoria+"'     \n" +
"  GROUP BY    \n" +
" DESCAPACIDAD, DESENVASE, DESMARCA) as C;"  ;
        
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
    
        
                while (rs.next()) {
               
              xxvalor=  rs.getInt(1);
            }
            
               
        
        } catch (Exception e) {
            System.out.println("Error en el metodo listaSumaCapacidad :" +e.getMessage());
           
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return xxvalor;  
    }
  
  
    @Override
    public List<beanProducto> ObtenerDescripcionEnvace(String xcodigo, String sprod, Connection con ) {
     List<beanProducto> LisObtenerDescripcionEnvace = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {
        con = oracleDaoLocalFactoryImpl.getSQLConextion();
        Statement st = con.createStatement();
        String sql = " SELECT DESENVASE as envase,      "+
                    "  DESCAPACIDAD as  capacidad    "+  
                    "   FROM  TABLA_PRODUCTOS_BO    "+ 
                   "  WHERE       "+
                    " COD_CLI_SAP  =  '"+xcodigo+"'  "+
                    " and DESMARCA= '"+sprod+"'  "+                      
                   "  GROUP BY     "+
                   " DESENVASE,       "+
                  "  DESCAPACIDAD " ;
        
        
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        LisObtenerDescripcionEnvace = new ArrayList<beanProducto>();
        
                while (rs.next()) {
                beanProducto bproducto = new beanProducto();
               bproducto.setEnvase(rs.getString(1));
               bproducto.setCapacidad(rs.getString(2));
               // bfecha.setMesDescripcion(rs.getString(1));
               // bfecha.setMes(rs.getInt(2));
                LisObtenerDescripcionEnvace.add(bproducto);
            }
            
                
        
        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerDescripcionEnvace :" +e.getMessage());
           LisObtenerDescripcionEnvace = null; 
        }finally {
            try {
               rs.close();
              ps.close();
            }      
   catch (SQLException e) {
            }
        }

       return LisObtenerDescripcionEnvace;     
    }

    @Override
    public List  contadorNrosemana(String xcodigo, String sem_prod,Connection con) {
        List LisContadorNrosemana = null;
         ResultSet rs =null;
          PreparedStatement ps=null;

        try {
        
        String sql =  "Select count(distinct( NROSEMANA)) "+
    " FROM TABLA_PRODUCTOS_BO "+
    " WHERE         "+ 
   "  COD_CLI_SAP  =    '"+xcodigo+"'  "+
    "   and PERIODODIASEMA between (    "+
    "   Select      "+
    "  MIN( PERIODODIASEMA)  "+
   "  FROM       "+
   "     TABLA_PRODUCTOS_BO          "+     
   " WHERE       "+
   "    COD_CLI_SAP  =  '"+xcodigo+"'  "+
   " )    "+
   "      AND   '"+sem_prod+"'  "+
   " GROUP BY  NROSEMANA  " ;
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        LisContadorNrosemana = new ArrayList();
        
                while (rs.next()) {
                
                LisContadorNrosemana.add(rs.getInt(1));
            }
            
              
        
        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerDescripcionEnvace :" +e.getMessage());
           LisContadorNrosemana = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return LisContadorNrosemana;  
    }

    @Override
    public List  ObtenerCantidadEquiv(String xcodigo, String sem_prod, String capacidad, String sprod,String nromes,Connection con) {
        List LisObtenerCantidadEquiv = null;
        int nrosemPar = Integer.parseInt(sem_prod);
        int capacpar=   Integer.parseInt(capacidad);
         ResultSet rs =null;
          PreparedStatement ps=null;

        try {
      
        String sql =  " Select to_char(Sum(CAJA_EQUIVALENTE),'999999999.99')as CAJA_EQuivalente "+
         " FROM      TABLA_PRODUCTOS_BO  "+
         " WHERE   "+
         " COD_CLI_SAP  =  '"+xcodigo+"'  "+
         " and DESMARCA = '"+sprod+"'  "+
         " and DESCAPACIDAD =    "+capacidad+
         " and NROMES ="+nromes+       
         " and NROSEMANA =    trim(substr("+sem_prod+",5,2)) ";  
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        LisObtenerCantidadEquiv = new ArrayList();
        
         while (rs.next()) {       
               
               LisObtenerCantidadEquiv.add(rs.getString(1));
        }

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerCantidadEquiv :" +e.getMessage());
           LisObtenerCantidadEquiv = null; 
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return LisObtenerCantidadEquiv;   
    }

    
  
    
    
    @Override
     public int sumaDesmarca(String xcodigo, String xcategoria,Connection con) {
       int xxpositivo=0;
         ResultSet rs =null;  
          PreparedStatement ps=null;
        try {
       
        String sql = "SELECT  COUNT (*) FROM ( Select DESMARCA \n" +
" FROM   TABLA_PRODUCTOS_BO  \n" +
" WHERE   \n" +
"  COD_CLI_SAP  =  '"+xcodigo+"'  \n" +
"   and DESCATEGORIA = '"+xcategoria+"'  \n" +
"   GROUP BY    \n" +
"    DESMARCA) AS C ; " ;        
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
              
                xxpositivo=rs.getInt(1);
            }
          
        } catch (Exception e) {
            System.out.println("Error en el metodo sumaDesmarca :" +e.getMessage());
           
        }finally {
            try {
               rs.close();
               ps.close();
                       
                       } catch (SQLException e) {
            }
        }

       return xxpositivo;   
    }

    
    public List totaldeproycate (String xcodigo, String xcategoria ,int flag,Connection con){
         List listotProdCat = null;
         ResultSet rs =null;
          PreparedStatement ps=null;
        try {
      
     
        String   sql="";
        if(flag==1) {
        sql =  " SELECT           round(sum(CAJA ),2) "+
                       "  FROM                                   "+          
                       "  TABLA_PRODUCTOS_BO                       "+             
                        "     WHERE                                "+             
                         "    COD_CLI_SAP  =  '"+xcodigo+"'  "+                            
                         "    and DESMARCA= '"+xcategoria+"'  "  ;
        }else
        {
            sql =  " SELECT         round(sum(CAJA ) ,2)"+
                       "  FROM                                   "+          
                       "  TABLA_PRODUCTOS_BO                       "+             
                        "     WHERE                                "+             
                         "    COD_CLI_SAP  =  '"+xcodigo+"'  "+                            
                         "    and DESCATEGORIA= '"+xcategoria+"'  "  ;
        }
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        listotProdCat = new ArrayList();
        
                while (rs.next()) {
              
                listotProdCat.add(rs.getDouble(1));
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo sumaDesmarca :" +e.getMessage());
           listotProdCat = null; 
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return listotProdCat;   
    }
    
  /* public int validacion(String xcodigo,Connection con){
    int valor=0;
    
           ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
        //Statement st = con.createStatement();
        String   sql=" select count(*)  from tabla_productos_bo  " +
                     "    where Cod_cli_sap = '"+xcodigo+"'  " ;
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        
                while (rs.next()) {
              
              valor=rs.getInt(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo validacion :" +e.getMessage());
         
        }finally {
            try {
               rs.close();
               ps.close();
            } catch (SQLException e) {
            }
        }

       return valor;  
    
   }*/
    @Override
    
    public List<beanTotalCantidad> obtieneEnvaceCapaSemana(String xcodigo, String xcategoria, String sem_prod,int flag,String nromes,Connection con) {
       List<beanTotalCantidad> LisObtieneEnvaceCapaSemana = null;
           ResultSet rs =null;
          PreparedStatement ps=null;

        int sempprodParse= Integer.parseInt(sem_prod);
        try {
        
        String sql="";
        if (flag==1){
             sql =  "SELECT   DESENVASE ,   "+                                 
                        "  DESCAPACIDAD    ,    "+   
                  " SEMANA   ,     "+ 
                  " to_char(CAJA,'999999999.99')  "+ 
                  "   FROM             "+                         
                  "   TABLA_PRODUCTOS_BO    "+                         
                    "     WHERE                 "+                     
                     "    COD_CLI_SAP  =  '"+xcodigo+"'  "+                             
                     "    and DESMARCA= '"+xcategoria+"'  "+                           
                      "    and   NROSEMANA=  "  +sem_prod +
                      "and NROMES= "+nromes+
                      "     GROUP BY       DESENVASE  "+ 
                      "     ,  DESCAPACIDAD ,  SEMANA ,   CAJA ";
        }
        else{
        
           sql = "SELECT   DESENVASE , "+                                       
                        "    DESCAPACIDAD    ,    "+     
                        "     SEMANA   ,         "+
                        " to_char(CAJA,'999999999.99') "+
                        "      FROM         "+                               
                        "            Tabla_Productos_BO       "+                      
                         "  WHERE          "+                              
                        "   COD_CLI_SAP  =  '"+xcodigo+"'  "+                                                                                     
                        "   and Descategoria= '"+xcategoria+"'  "+                 
                        "    and   Nrosemana=   "  +sem_prod + 
                        " and nromes="+nromes+
                         "    GROUP BY             "+                          
                        "    DESENVASE ,        "+                               
                        "     DESCAPACIDAD ,      "+   
                        "     SEMANA,  "+
                         "    caja ";     }
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        LisObtieneEnvaceCapaSemana = new ArrayList<beanTotalCantidad>();
        
                while (rs.next()) {
                beanTotalCantidad btotalcantidad= new beanTotalCantidad();  
                //btotalcantidad.setEnvase(rs.getString(1));
              //  btotalcantidad.setCapacidad(rs.getString(2));
                //btotalcantidad.setSemana(rs.getString(3));
                btotalcantidad.setTotal(rs.getString(4));
                //bfecha.setMes(rs.getInt(2));
              //  ListbeanObtieneMes.add(bfecha);
                LisObtieneEnvaceCapaSemana.add(btotalcantidad);
            }
            
          if (LisObtieneEnvaceCapaSemana.isEmpty()) {
                LisObtieneEnvaceCapaSemana = null;
            }
        
        } catch (Exception e) {
            System.out.println("Error en el metodo obtieneEnvaceCapaSemana :" +e.getMessage());
           LisObtieneEnvaceCapaSemana = null; 
        }finally {
            try {
             rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return LisObtieneEnvaceCapaSemana;    
    }

    @Override
    public List contcombmes(String xcodigo, String xnummes, String anio,Connection con) {
      List LisObtienecontscombsema = null;
       ResultSet rs =null;
          PreparedStatement ps=null;

        try {
        
        String sql = "SELECT NROSEMANA AS sem_año    , "+
        " anio "+
     " FROM    Tabla_Productos_BO    "+   
     " WHERE "+
      " COD_CLI_SAP  =  '"+xcodigo+"'  "+        
       "     AND Nromes= " +  xnummes + 
       " and  anio = "+anio+      
    " GROUP BY  anio  ,   NROSEMANA   "+   
  "  ORDER BY anio,   NROSEMANA "  ;    
        
     ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
      
        LisObtienecontscombsema = new ArrayList();
        
                while (rs.next()) {
                LisObtienecontscombsema.add(rs.getString(1));
            }
            
               
        
        } catch (Exception e) {
            System.out.println("Error en el metodo contcombmes  :" +e.getMessage());
           LisObtienecontscombsema = null; 
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
        return  LisObtienecontscombsema;
    }

    @Override
    public List<beanobtenersemanporpodycant> obtenersemanporprodycant(String xcodigo, String xprod, String xcapacidad,Connection con) {
      List<beanobtenersemanporpodycant> LisObtiene_seman_prod = null;
         ResultSet rs =null;
          PreparedStatement ps=null;

        try {
        
        String sql =  "Select distinct(periododiasema) as sem_prod , aniomes,nromes"+
       " FROM  Tabla_Productos_BO      "+
   " WHERE       "+
     " COD_CLI_SAP  =  '"+xcodigo+"'  "+ 
     " and Desmarca = '"+xprod+"'  "+ 
    "  and Descapacidad =  "+xcapacidad+
    " GROUP BY anio ,  aniomes , periododiasema,nromes      "+
    " order by periododiasema "   ;    
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        LisObtiene_seman_prod = new ArrayList<beanobtenersemanporpodycant>();
        
                while (rs.next()) {
                    beanobtenersemanporpodycant bf= new  beanobtenersemanporpodycant();
                bf.setNrosemana(rs.getInt(1));
                bf.setNromes(rs.getInt(3));
                
                LisObtiene_seman_prod.add(bf);
            }
            
               
        
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenersemanporprodycant  :" +e.getMessage());
           LisObtiene_seman_prod = null; 
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
        return  LisObtiene_seman_prod;  
    }
    
    
    
    
    
   public List totalxfilas(String xcodigo, String xprod, String xcapacidad,Connection con) {
       List listtotalxfilas = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       
        String sql =  "Select round(sum(caja),2)   "+
       " FROM  Tabla_Productos_BO      "+
   " WHERE       "+
     " COD_CLI_SAP  =  '"+xcodigo+"'  "+ 
     " and Desmarca = '"+xprod+"'  "+ 
    "  and Descapacidad =  "+xcapacidad ;    
       
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        listtotalxfilas = new ArrayList();
        
                while (rs.next()) {
                listtotalxfilas.add(rs.getDouble(1));
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo totalxfilas  :" +e.getMessage());
           listtotalxfilas = null; 
        }finally {
            try {
                 rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
        return  listtotalxfilas; 
   }    
    

   
   
   public List<beantabladinamica> ObtenerTablaDinamica6(String s1,String s2,String s3,String s4,String s5,String s6, String producto,String codcliente,Connection con) {
     List<beantabladinamica> LisObtenerTablaDinamica = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
          
          
          
          
        try {
        //con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
       String sql = "SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE, CAST("+s1+" AS INT)AS "+s1+",CAST("+s2+" AS INT) AS "+s2+" ,CAST("+s3+" AS INT) AS "+s3+", CAST("+s4+" AS INT) AS "+s4+",CAST("+s5+" AS INT) AS "+s5+",CAST("+s6+" AS INT) AS "+s6+"  FROM (SELECT DESCATEGORIA,NROSEMANA,DESMARCA,DESENVASE,DESCAPACIDAD, \n" +
"round(sum( CAJA_EQUIVALENTE),0) AS CAJA_EQUIVALENTE FROM TABLA_PRODUCTOS_BO\n" +
"where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"' GROUP BY \n" +
"DESCATEGORIA, NROSEMANA, DESMARCA,DESENVASE,DESCAPACIDAD,CAJA_EQUIVALENTE) C \n" +
"PIVOT \n" +
"(SUM(CAJA_EQUIVALENTE) \n" +
"FOR   NROSEMANA  IN ("+s1+","+s2+","+s3+","+s4+","+s5+","+s6 +")) AS pvt ORDER BY  DESMARCA;" ;
        
        
        System.out.println("solooo "+sql);;
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
       LisObtenerTablaDinamica = new ArrayList<beantabladinamica>();
        
                while (rs.next()) {
               beantabladinamica bdinamico = new beantabladinamica();
               bdinamico.setDescategoria(rs.getString(1));
               bdinamico.setDesmarca(rs.getString(2));
               bdinamico.setDescapacidad(rs.getString(3));
               bdinamico.setDesenvase(rs.getString(4));
               bdinamico.setSemana1(rs.getString(5));
               bdinamico.setSemana2(rs.getString(6));
               bdinamico.setSemana3(rs.getString(7));
               bdinamico.setSemana4(rs.getString(8));
               bdinamico.setSemana5(rs.getString(9));  
               bdinamico.setSemana6(rs.getString(10));
               LisObtenerTablaDinamica.add(bdinamico);
            }
            
                
        
        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerTablaDinamica6 :" +e.getMessage());
            LisObtenerTablaDinamica = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
               
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  LisObtenerTablaDinamica;     
    }
   
   
   
   
    public List<beanSumatoriaSemanas> SumatoriadeCajaEquivalente6(String s1,String s2,String s3,String s4,String s5,String s6, String producto,String codcliente,Connection con) {
     List<beanSumatoriaSemanas> LisSumatoriadeCajaEquivalente6 = null;
ResultSet rs =null;
PreparedStatement ps=null;

        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
     String sql = "SELECT CAST(SUM("+s1+")AS INT) AS "+s1+" , CAST(SUM("+s2+")AS INT) AS "+s2+" ,  CAST(SUM("+s3+")AS INT) AS "+s3+", CAST(SUM("+s4+")AS INT) AS "+s4+", CAST(SUM("+s5+")AS INT) AS "+s5+" ,  CAST(SUM("+s6+")AS INT) AS "+s6+"  \n" +
"FROM (SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+","+s2+","+s3+","+s4+","+s5+" ,"+s6+" \n" +
"FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, \n" +
"round(sum( CAJA_EQUIVALENTE),0)as CAJA_EQUIVALENTE FROM   TABLA_PRODUCTOS_BO \n" +
"where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"' group by  \n" +
"DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA_EQUIVALENTE) C\n" +
"PIVOT \n" +
"(SUM(CAJA_EQUIVALENTE) \n" +
"FOR   NROSEMANA  IN ("+s1+" ,  "+s2+", "+s3+" , "+s4+" , "+s5+"  , "+s6+")) AS PVT) AS B; " ;
     
       System.out.println("queryryryr "+sql);
       
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      LisSumatoriadeCajaEquivalente6= new ArrayList<beanSumatoriaSemanas>();
        
                while (rs.next()) {
              beanSumatoriaSemanas bdinamico = new beanSumatoriaSemanas();
               bdinamico.setSem1(rs.getString(1));
               bdinamico.setSem2(rs.getString(2));
               bdinamico.setSem3(rs.getString(3));
               bdinamico.setSem4(rs.getString(4));
                bdinamico.setSem5(rs.getString(5));
                bdinamico.setSem6(rs.getString(6));
               LisSumatoriadeCajaEquivalente6.add(bdinamico);
            }
            
                
        
        } catch (SQLException e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente5:" +e.getMessage());
            LisSumatoriadeCajaEquivalente6 = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  LisSumatoriadeCajaEquivalente6;     
    }   
      public List<beansemaxprod> sumatoriaxpord6(String s1,String s2,String s3,String s4,String s5,String s6, String producto,String codcliente,Connection con) {
     List<beansemaxprod> listaxprod = null;
ResultSet rs =null;
PreparedStatement ps=null;

        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
      String sql = "SELECT CAST(SUM("+s1+")AS INT) AS "+s1+" , CAST(SUM("+s2+")AS INT) AS "+s2+" ,  CAST(SUM("+s3+")AS INT) AS "+s3+", CAST(SUM("+s4+")AS INT) AS "+s4+", CAST(SUM("+s5+")AS INT) AS "+s5+" ,  CAST(SUM("+s6+")AS INT) AS "+s6+" \n" +
"from (  SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+","+s2+","+s3+","+s4+","+s5+" ,"+s6+" \n" +
"FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, round(sum( CAJA_EQUIVALENTE),0)as CAJA_EQUIVALENTE \n" +
"FROM   TABLA_PRODUCTOS_BO where DESMARCA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"'  \n" +
"group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA_EQUIVALENTE) C\n" +
"PIVOT \n" +
"(SUM(CAJA_EQUIVALENTE) FOR   NROSEMANA  IN ("+s1+", "+s2+","+s3+" ,"+s4+" ,"+s5+"  ,"+s6+" ))AS PVT) AS B " ;
      
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      listaxprod= new ArrayList<beansemaxprod>();
        
                while (rs.next()) {
              beansemaxprod xsumprod = new beansemaxprod();
               xsumprod.setSem1(rs.getString(1));
               xsumprod.setSem2(rs.getString(2));
               xsumprod.setSem3(rs.getString(3));
               xsumprod.setSem4(rs.getString(4));
                xsumprod.setSem5(rs.getString(5));
                xsumprod.setSem6(rs.getString(6));
               listaxprod.add(xsumprod);
            }
            
                
        
        } catch (SQLException e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente5:" +e.getMessage());
            listaxprod = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  listaxprod;     
    }   
   public String semanasmaxima(int valor,Connection con){
     String semana  ="";
            ResultSet rs =null;
          PreparedStatement ps=null;
        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
       String sql = " EXEC  [Ficha].[dbo].[FECHA_NUMERO_SEMANA]"+ valor; 
        
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
    
        
                while (rs.next()) {
              
             semana=rs.getString(1);
            }
            
                
        
        } catch (SQLException e) {
            System.out.println("Error en el metodo semanasmaxima:" +e.getMessage());
            
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }   
        return semana;
   }
   
     public List<beanSumatoriaSemanas> SumatoriadeCatCajaEquivalante6(String s1,String s2,String s3,String s4,String s5,String s6, String producto,String codcliente,Connection con) {
     List<beanSumatoriaSemanas> LisSumatoriadeCajaEquivalente6 = null;
ResultSet rs =null;
PreparedStatement ps=null;

        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
       String sql = " SELECT SUM("+s1+"),SUM("+s2+") , SUM("+s3+"),SUM("+s4+"),SUM("+s5+") , SUM("+s6+")  from (  SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+","+s2+","+s3+","+s4+","+s5+" ,"+s6+" FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, sum( CAJA)as CAJA FROM   TABLA_PRODUCTOS_BO where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"'  group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA) PIVOT (SUM(CAJA) FOR   NROSEMANA  IN ('"+s1+"' as "+s1+", '"+s2+"' as "+s2+",'"+s3+"' as "+s3+" ,'"+s4+"' as "+s4+" ,'"+s5+"' as "+s5+"  ,'"+s6+"' as "+s6+")  )  ) " ;
        
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      LisSumatoriadeCajaEquivalente6= new ArrayList<beanSumatoriaSemanas>();
        
                while (rs.next()) {
              beanSumatoriaSemanas bdinamico = new beanSumatoriaSemanas();
               bdinamico.setSem1(rs.getString(1));
               bdinamico.setSem2(rs.getString(2));
               bdinamico.setSem3(rs.getString(3));
               bdinamico.setSem4(rs.getString(4));
                bdinamico.setSem5(rs.getString(5));
                bdinamico.setSem6(rs.getString(6));
               LisSumatoriadeCajaEquivalente6.add(bdinamico);
            }
            
                
        
        } catch (SQLException e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente5:" +e.getMessage());
            LisSumatoriadeCajaEquivalente6 = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  LisSumatoriadeCajaEquivalente6;     
    }   
  
   
   
   
     public void ejecutarpocedue( String xcodigo,Connection con){
      CallableStatement cst=null;
        try {
           // cn = oracleDaoLocalFactoryImpl.getSQLConextion();
            cst = con.prepareCall("{call consulta_bo (?)}");
           cst.setString(1, xcodigo.trim());

        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
            cst.execute();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo ejecutarpocedue:" + e.getMessage());

        }finally {
            try {
               cst.close();
               
            } catch (SQLException e) {
            }
        }
        
 }  
     
       public void procedureCliente( String xcodigo,Connection con){
    CallableStatement  cst=null;
        try {
           
           cst = con.prepareCall("{call CONSULTA_CLIENTE_BO (?)}");
           cst.setString(1, xcodigo.trim());  
           cst.execute();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo procedureCliente:" + e.getMessage());

        }finally {
            if(con!=null){
            
            try {
               cst.close();
               
            } catch (SQLException e) {
            }
       
            }    
        }
        
 } 
  
  public int insertarClienteTelefono(String campana, String codCliente,String nro1,String nro2 ,String nro3 ,String nro4  ){
        Connection cn = null;
        int insert = 0;
        try {
            cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            Statement st = cn.createStatement();
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
             String sql = "INSERT INTO [Ficha_Cliente].[dbo].[TelefonosCliente] ([Campana],[CodCliente],[telefono1],[telefono2],[telefono3],[telefono4],[Hora]) VALUES('"+campana+"','"+codCliente+"','"+nro1 +"','"+nro2 +"','"+nro3 +"','"+nro4 +"','"+sqlTimestamp+"')  ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
            insert = st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteManual:" + e.getMessage());

        }
        return insert;
    }  
    
    
    
   
 
   
    
      public int  validaciondemessemana(String xcodigo, String xsemana,Connection con){
        // List listvalidaciondemessemana = null;
         ResultSet rs =null;
          PreparedStatement ps=null;

        int cont=0;
        try {
            
        
        
        String sql = "select count( distinct(nromes)) from Tabla_Productos_BO WHERE        COD_CLI_SAP  = '" + xcodigo + "'"+
                     "and periododiasema="+xsemana;
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      //  listvalidaciondemessemana = new ArrayList();
        
                while (rs.next()) {

                cont =rs.getInt(1);
            }
            
          
        
        } catch (Exception e) {
            System.out.println("Error en el metodo validaciondemessemana :" +e.getMessage());
          // listvalidaciondemessemana = null; 
        }finally {
            try {
              rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return cont;
     }
     
     
     public List<beanAnotacionAgente> AnotacionAgente(String xcodigo,Connection con){
      // select  respuesta, periododia from tabla_anotacion_agente Where COD_CLI_SAP = '0011117887'     AND GrupoPREGUNTA='1.Tipo de respuesta'
      List<beanAnotacionAgente>  listaAnotacionAgente = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
           
        String sql ="select   RESPUESTA, PERIODODIA from TABLA_ANOTACION_AGENTE Where COD_CLI_SAP = '"+xcodigo+"'   AND GRUPOPREGUNTA='1.Tipo de respuesta' order by PERIODODIA desc" ;    
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        listaAnotacionAgente = new ArrayList<beanAnotacionAgente>();
        
                while (rs.next()) {
                    
                beanAnotacionAgente anotacion  = new beanAnotacionAgente();
                anotacion.setRespuesta(rs.getString(1));
                anotacion.setPeriododia(rs.getString(2));
               listaAnotacionAgente.add(anotacion);
            }
            
        
        } catch (Exception e) {
            System.out.println("Error en el metodo AnotacionAgente  :" +e.getMessage());
            
           listaAnotacionAgente = null; 
        }finally {
            try {
              rs.close();
              ps.close();
            } catch (SQLException e) {
            }
        }
     return listaAnotacionAgente;
 }
 public List AnotacionAgentedos(String xcodigo,Connection con){
      // select  respuesta, periododia from tabla_anotacion_agente Where COD_CLI_SAP = '0011117887'     AND GrupoPREGUNTA='1.Tipo de respuesta'
      List listaAnotacionAgente = null;
         ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
       // Statement st = con.createStatement();
        String sql ="select   RESPUESTA, PERIODODIA from TABLA_ANOTACION_AGENTE Where COD_CLI_SAP = '"+xcodigo+"'   AND GRUPOPREGUNTA='2.Observación'  order by PERIODODIA desc" ;    
        ps = con.prepareStatement(sql.toString());
        rs = ps.executeQuery();
        listaAnotacionAgente = new ArrayList();
        
                while (rs.next()) {
                   
               listaAnotacionAgente.add(rs.getString(1));
            }
            
        
        } catch (Exception e) {
            System.out.println("Error en el metodo AnotacionAgentedos  :" +e.getMessage());
            
           listaAnotacionAgente = null; 
        }finally {
            try {
              rs.close();
             ps.close();
            } catch (SQLException e) {
            }
        }
     return listaAnotacionAgente;
 }
 public List skudisponiblidad(String xcodigo,Connection con){
     List listSkuDispobniblidad  = null;
       ResultSet rs =null;
          PreparedStatement ps=null;
     try {
        //con = oracleDaoLocalFactoryImpl.getSQLConextion();
        //Statement st = con.createStatement();
        String sql ="SELECT  distinct(SKU)as sku  FROM  TABLA_PLAN_DISPONIBLIDAD_BO Where COD_CLI_SAP = '"+xcodigo+"' order by SKU  desc  " ;    
       // ResultSet rs = st.executeQuery(sql);
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        
        
        listSkuDispobniblidad = new ArrayList();
        
                while (rs.next()) {
                    
              /*  beanDisponibilidad disponible  = new beanDisponibilidad();
                disponible.setDESFAMILIAMARCA(rs.getString(1));
                disponible.setSKU(rs.getString(2));
                disponible.setVENTA(rs.getString(3));*/
               listSkuDispobniblidad.add(rs.getString(1));
            }
            
        
        } catch (Exception e) {
            System.out.println("Error en el metodo DISPONIBILIDAD  :" +e.getMessage());
            
           listSkuDispobniblidad = null; 
        }finally {
            try {
               ps.close();
               rs.close();
            } catch (SQLException e) {
            }
        }
     
     return listSkuDispobniblidad;
 }
 
 
  public List<beanDisponibilidad> DISPONIBILIDAD(String xcodigo,Connection con){
 
  List<beanDisponibilidad>  listaPlanDispo = null;
      
        try {
       
        Statement st = con.createStatement();
        String sql ="SELECT DESFAMILIAMARCA, SKU, VENTA FROM  TABLA_PLAN_DISPONIBLIDAD_BO Where COD_CLI_SAP = '"+xcodigo+"'  " ;    
        ResultSet rs = st.executeQuery(sql);
        listaPlanDispo = new ArrayList<beanDisponibilidad>();
        
                while (rs.next()) {
                    
                beanDisponibilidad disponible  = new beanDisponibilidad();
                disponible.setDESFAMILIAMARCA(rs.getString(1));
                disponible.setSKU(rs.getString(2));
                disponible.setVENTA(rs.getString(3));
               listaPlanDispo.add(disponible);
            }
            
        
        } catch (Exception e) {
            System.out.println("Error en el metodo DISPONIBILIDAD  :" +e.getMessage());
            
           listaPlanDispo = null; 
        }
     return listaPlanDispo;
 
  }
  
 //SELECT  dISTINCT(DESFAMILIAMARCA)  FROM TABLA_PLAN_DISPONIBLIDAD_BO 
 // where COD_CLI_SAP='0011188952'
  //GROUP BY DESFAMILIAMARCA
 public List MARCADISPONIBILIDAD(String xcodigo,Connection con){
 
  List listaMarcaDisponibiidad = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT  dISTINCT(DESFAMILIAMARCA) as marca   FROM TABLA_PLAN_DISPONIBLIDAD_BO Where COD_CLI_SAP = '"+xcodigo+"'   GROUP BY DESFAMILIAMARCA,SKU"  ;    
      //  ResultSet rs = st.executeQuery(sql);
        
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        listaMarcaDisponibiidad = new ArrayList();
                while (rs.next()) {
                    
              
               listaMarcaDisponibiidad.add(rs.getString(1));
            }
        
        } catch (Exception e) {
            System.out.println("Error en el metodo MARCADISPONIBILIDAD  :" +e.getMessage());
           listaMarcaDisponibiidad = null; 
        }finally {
            try {
               //
               
                rs.close();
                rs=null;
                 ps.close();
                ps=null;
            } catch (SQLException e) {
            }
        }
     return listaMarcaDisponibiidad;
 
  }
 
 //select  nomsupervisor, nomvendedor, desclidetallista, cod_cli_sap, desdireccion,    
 //desdistrito, desprovincia,  descanal, desdiavistv, desdiavisven,     tvist, venhor,
 //lentreg, diarep, codclasificameda, desclasifiacionpos,  nomtelv, descentrodis, destelefonomovil, 
 //destelefonofijo, desfechacumpleanio,   despersonacontacto, telefono from tabla_cliente_bo

 public List<beanClienteBo> ClienteBo(String xcodigo,Connection con){
 
  List<beanClienteBo> listaClientebo = null;
         ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
        //Statement st = con.createStatement();
         String sql = "SELECT  TOP 1 NOMSUPERVISOR, \n" +
"      NOMVENDEDOR , \n" +
"   DESCLIDETALLISTA,  \n" +
"   COD_CLI_SAP, \n" +
"    DESDIRECCION,              \n" +
"     DESDISTRITO,  \n" +
"      DESPROVINCIA,    \n" +
"      DESCANAL,  \n" +
"       DESDIAVISTV,  \n" +
"        DESDIAVISVEN,  \n" +
"        TVIST,  \n" +
"         VENHOR,            \n" +
"     LENTREG,  \n" +
"      DIAREP,  \n" +
"       matriz_abc,  \n" +
"      DESCLASIFIACIONPOS  ,   \n" +
"         NOMTELV,  \n" +
"          DESCENTRODIS,  \n" +
"           DESTELEFONOMOVIL,            \n" +
"     DESTELEFONOFIJO,   \n" +
"     fecha_nac ,  \n" +
"        DESPERSONACONTACTO, \n" +
"         CODZONA_TELV,  \n" +
"         CODESTADO, \n" +
"         COD_CENTRO_SUMI  ,   \n" +
" CODIGORUC    \n" +
"          FROM TABLA_CLIENTE_BO  \n" +
"           where  COD_CLI_SAP  =  '"+xcodigo+"';" ;
             ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        listaClientebo = new ArrayList<beanClienteBo>();
                while (rs.next()) {
                    beanClienteBo  cliente=new beanClienteBo();
              cliente.setNomsupervisor(rs.getString(1));
              cliente.setNomvendedor(rs.getString(2));
               cliente.setDesclidetallista(rs.getString(3));
               cliente.setDesdireccion(rs.getString(5));
               cliente.setDesdistrito(rs.getString(6));
               cliente.setDescanal(rs.getString(8));
               cliente.setDesdiavistv(rs.getString(9));
               cliente.setDiavisitaac(rs.getString(10));
               cliente.setTvist(rs.getString(11));
               cliente.setVenhor(rs.getString(12));
               cliente.setCodclasificameda(rs.getString(15));
               cliente.setDesclasifiacionpos(rs.getString(16));
               cliente.setNomtelv(rs.getString(17));
               cliente.setNombrecd(rs.getString(18));
               cliente.setDestelefonomovil(rs.getString(19));
               cliente.setDestelefonofijo(rs.getString(20));
               cliente.setDesfechacumpleanio(rs.getString(21));
               cliente.setDespersonacontacto(rs.getString(22));
               cliente.setZonatvta(rs.getString(23));
               cliente.setEstcliente(rs.getString(24));
               cliente.setBk(rs.getString(25));
               cliente.setCodigoruc(rs.getString(26));
               
               listaClientebo.add(cliente);
            }
        
        } catch (Exception e) {
            System.out.println("Error en el metodo ClienteBo  :" +e.getMessage());
           listaClientebo = null; 
        }finally {
            try {
               
               ps.close();
                rs.close();
                
            } catch (SQLException e) {
            }
        }
     return listaClientebo;
 
  }
 
  //select Dessubmodelo,venta,valcapacidad from tabla_productividad_bo 
 
 //beanProductividad
 
  public int  conteoProdu (String xcodigo ,String product,Connection con ){
    int cont=0;
    ResultSet rs =null;
PreparedStatement ps=null;

        try {
     
        String sql = " SELECT SUM(DESCAPACIDAD) FROM (select COUNT(DISTINCT(DESCAPACIDAD)) AS DESCAPACIDAD FROM   TABLA_PRODUCTOS_BO   \n" +
" where DESMARCA= '"+product+"'   and  COD_CLI_SAP =  '"+xcodigo+"'\n" +
" group by DESCAPACIDAD ,DESENVASE) AS C; ";
       
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
  
        
      
      
                while (rs.next()) {
            
                
             cont=  rs.getInt(1);
            }
            
                
        
        } catch (SQLException e) {
            System.out.println("Error en el metodo conteoProdu :" +e.getMessage());
          //  listacontxProduct = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }

        }

    
    
      return  cont;
  }
 
 public List<beanProductividad> Productividad(String xcodigo,Connection con){
 
  List<beanProductividad> listaProductividad = null;
     ResultSet rs =null;
          PreparedStatement ps=null;
        try {
        //con = oracleDaoLocalFactoryImpl.getSQLConextion();
        //Statement st = con.createStatement();
        String sql ="select DESSUBMODELO,VENTA,VALCAPACIDAD,DESLOGO from TABLA_PRODUCTIVIDAD_BO Where COD_CLI_SAP = '"+xcodigo+"'" ;    
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        listaProductividad = new ArrayList<beanProductividad>();
                while (rs.next()) {
                    
              beanProductividad produ=new beanProductividad();
              // listaProductividad.add(rs.getString(1));
              produ.setDessubmodelo(rs.getString(1));
              produ.setVenta(rs.getString(2));
              produ.setValcapacidad(rs.getString(3));
              produ.setDeslogo(rs.getString(4));
              listaProductividad.add(produ);
            }
        
        } catch (Exception e) {
            System.out.println("Error en el metodo Productividad  :" +e.getMessage());
           listaProductividad = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }
     return listaProductividad;
 
  }
  // Select sum(venta) From tabla_plan_disponiblidad_bo 
  // where Cod_cli_sap ='0011188952'
  //and Desfamiliamarca='Cristal'
  //AND SKU='BR-650';
 
 public List disponibleventa(String xcodigo,String marca,String sku,Connection con){
  List listaventadisponible = null;
       ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       
String sql ="select TOP 1 VENTA from \n" +
"(select CASE WHEN not exists \n" +
"(SELECT COD_CLI_SAP FROM tabla_plan_disponiblidad_bo WHERE COD_CLI_SAP ='"+xcodigo+"' \n" +
"AND Desfamiliamarca='"+marca+"' AND SKU ='"+sku+"') THEN '0' ELSE \n" +
"(SELECT SUM(CAST(SUBSTRING(VENTA,1,1) AS INT)) FROM TABLA_PLAN_DISPONIBLIDAD_BO WHERE COD_CLI_SAP ='"+xcodigo+"' \n" +
"AND Desfamiliamarca='"+marca+"' AND SKU='"+sku+"') END as VENTA   \n" +
" FROM tabla_plan_disponiblidad_bo) AS C";
       
       
       
       
    ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        
      //  ResultSet rs = st.executeQuery(sql);
        listaventadisponible = new ArrayList();
                while (rs.next()) {
               listaventadisponible.add(rs.getString(1));
            }
        
             
        } catch (Exception e) {
            System.out.println("Error en el metodo disponibleventa  :" +e.getMessage());
           listaventadisponible = null; 
        }finally {
            try {
                rs.close();
                ps .close();
            } catch (SQLException e) {
            }
        }
     return listaventadisponible;   
 }
 
 public List<beanCredito> Antiguedad(String xcodigo,Connection con){
     List<beanCredito> listaantiguedad = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
        //con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="select DESTIPORANGO,round(cast(DEUDA as decimal(9,2)),2) from TABLA_CREDITO_1  Where COD_CLI_SAP = '"+xcodigo+"' and DEUDA<>'0';"   ; 
        ///// System.out.println("Error en el metodo Antiguedad  :"+sql);
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        listaantiguedad = new ArrayList<beanCredito>();
                while (rs.next()) {
                    
              beanCredito credito=new beanCredito();
              // listaProductividad.add(rs.getString(1));
              credito.setDestiporango(rs.getString(1));
              credito.setDeuda(rs.getDouble(2));
              listaantiguedad.add(credito);
            }
        
        } catch (Exception e) {
            System.out.println("Error en el metodo Antiguedad  :" +e.getMessage());
           listaantiguedad = null; 
        }finally {
            try {
               rs.close();
               ps.close();
            } catch (SQLException e) {
            }
        }
     return listaantiguedad;
}
 //SELECT SUM(C1.DEUDA) AS  DEUDA ,TO_CHAR(C2.LIMITE_CREDITO,'999999.99')AS LIMITE_credito , TO_CHAR((SUM(C1.DEUDA) / C2.LIMITE_CREDITO  * 100 ),'9999')AS UTILIZACION ,  (C2.LIMITE_CREDITO - SUM(C1.DEUDA) ) as saldo  FROM   
 //tabla_credito_1 C1, Tabla_credito_bo2 C2
//WHERE C1.cod_cli_sap=C2.COD_CLI_SAP
//AND C1.cod_cli_sap='0010190045'
//GROUP BY C2.LIMITE_CREDITO
 
 
public List<beanCredito>Credito (String xcodigo,Connection con){
 List<beanCredito> listacredito = null;
         ResultSet rs =null;
          PreparedStatement ps= null;
        try {
       
        String sql =" SELECT \n" +
" (SELECT SUM(cast (F.DEUDA as decimal(9,2))) AS  DEUDA  FROM     tabla_credito_1  F WHERE F.cod_cli_sap='"+xcodigo+"'  ) AS  DEUDA    \n" +
" , (SELECT  cast(J.LIMITE_CREDITO as decimal(9,2))AS LIMITE_credito FROM Tabla_credito_bo2 J WHERE J.cod_cli_sap='"+xcodigo+"' ) AS LIMITE_credito , \n" +
"   ( select SUM(cast (s.DEUDA as decimal(9,2))) from tabla_credito_1 s          where  cod_cli_sap='"+xcodigo+"'             and DESTIPODEUDA='Cuasi Depósito') AS ENVASE,       \n" +
"   (               select SUM(cast (g.DEUDA as decimal(9,2))) from tabla_credito_1 g        where  cod_cli_sap='"+xcodigo+"'        and DESTIPODEUDA='Cuentas X Cobrar Comerciales'       ) AS LIQUIDO   \n" +
" FROM     tabla_credito_1 C1, Tabla_credito_bo2 C2     WHERE  C2.cod_cli_sap='"+xcodigo+"'  GROUP BY  C2.LIMITE_CREDITO  ";
        
          System.out.println("Query ==>  :" + sql);
        
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        listacredito = new ArrayList<beanCredito>();
                while (rs.next()) {
                    
              beanCredito credito=new beanCredito();
              // listaProductividad.add(rs.getString(1));
              credito.setDeudatotal(rs.getDouble(1));
              credito.setLimite_credito(rs.getDouble(2));
              credito.setEnvase(rs.getDouble(3));
              credito.setLiquido(rs.getDouble(4));
              listacredito.add(credito);
            }
        
        } catch (Exception e) {
            System.out.println("Error en el metodo Credito  :" +e.getMessage());
           listacredito = null; 
        }finally {
            try {
               rs.close();
                ps.close();
               
            } catch (SQLException e) {
            }
        }
     return listacredito;    
     
     
     
     
     
 }
 
 
 //******************Nuevos********************////
    public List<beanSumatoriaSemanas> SumatoriadeCajaEquivalente1(String s1,String producto,String codcliente,Connection con) {
     List<beanSumatoriaSemanas> LisSumatoriadeCajaEquivalente1 = null;
       
        
           ResultSet rs =null;
          PreparedStatement ps=null;
               
        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
        String sql = "SELECT SUM("+s1+") FROM ( SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+"  FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, sum( CAJA)as CAJA FROM   TABLA_PRODUCTOS_BO where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"'  group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA) PIVOT (SUM(CAJA) FOR   NROSEMANA  IN ('"+s1+"' as "+s1+" )  ))  " ;
        
       // rs = st.executeQuery(sql);
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
       LisSumatoriadeCajaEquivalente1 = new ArrayList<beanSumatoriaSemanas>();
        
                while (rs.next()) {
              beanSumatoriaSemanas bdinamico = new beanSumatoriaSemanas();
               bdinamico.setSem1(rs.getString(1));
               
            
               LisSumatoriadeCajaEquivalente1.add(bdinamico);
            }
            
                
        
        } catch (SQLException e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente1 :" +e.getMessage());
            LisSumatoriadeCajaEquivalente1 = null; 
        }finally {
            if(con!=null){
            
            try {
                
              ps.close();
               
                rs.close();
            } catch (SQLException e) {
            }
      
            }
        }
      return   LisSumatoriadeCajaEquivalente1;
        
    } 
    public String obtenerContacto(String CodCliente,Connection con) {
      //  Connection cn = null;
        String codigo = "";
        
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
           // cn = oracleDaoLocalFactoryImpl.getSQLConextion();
           // Statement st = cn.createStatement();
            String sql = "Select  DESPERSONACONTACTO from TABLA_CLIENTE_BO where    \n" +
                           " COD_CLI_SAP='"+CodCliente+"' ";
            
            //ResultSet rs = st.executeQuery(sql);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerContacto :" + e.getMessage());
        }
        return codigo;
     
     
     }
    public List<beanSumatoriaSemanas> SumatoriadeCajaEquivalente2(String s1,String s2, String producto,String codcliente,Connection con) {
     List<beanSumatoriaSemanas> LisSumatoriadeCajaEquivalente2 = null;
ResultSet rs =null;
PreparedStatement ps=null;
          
        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
       String sql = " SELECT SUM("+s1+"),SUM("+s2+") from (SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+","+s2+"  FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, sum( CAJA)as CAJA FROM   TABLA_PRODUCTOS_BO where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"'  group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA) PIVOT (SUM(CAJA) FOR   NROSEMANA  IN ('"+s1+"' as "+s1+", '"+s2+"' as "+s2+" )  ) ) " ;
        
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      LisSumatoriadeCajaEquivalente2= new ArrayList<beanSumatoriaSemanas>();
        
                while (rs.next()) {
              beanSumatoriaSemanas bdinamico = new beanSumatoriaSemanas();
               bdinamico.setSem1(rs.getString(1));
               bdinamico.setSem2(rs.getString(2));
               
              
               LisSumatoriadeCajaEquivalente2.add(bdinamico);
            }
            
                
        
        } catch (Exception e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente2 :" +e.getMessage());
            LisSumatoriadeCajaEquivalente2 = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  LisSumatoriadeCajaEquivalente2;     
    }  
    
    public List<beanSumatoriaSemanas> SumatoriadeCajaEquivalente3(String s1,String s2,String s3, String producto,String codcliente,Connection con) {
     List<beanSumatoriaSemanas> LisSumatoriadeCajaEquivalente3 = null;
ResultSet rs =null;
PreparedStatement ps=null;
          
        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
       String sql = " SELECT SUM("+s1+"),SUM("+s2+") , SUM("+s3+")from (   SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+","+s2+","+s3+"  FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, sum( CAJA)as CAJA FROM   TABLA_PRODUCTOS_BO where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"'  group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA) PIVOT (SUM(CAJA) FOR   NROSEMANA  IN ('"+s1+"' as "+s1+", '"+s2+"' as "+s2+",'"+s3+"' as "+s3+"   )  )) " ;
        
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      LisSumatoriadeCajaEquivalente3= new ArrayList<beanSumatoriaSemanas>();
        
                while (rs.next()) {
              beanSumatoriaSemanas bdinamico = new beanSumatoriaSemanas();
               bdinamico.setSem1(rs.getString(1));
               bdinamico.setSem2(rs.getString(2));
               bdinamico.setSem3(rs.getString(2));
              
               LisSumatoriadeCajaEquivalente3.add(bdinamico);
            }

        
        } catch (SQLException e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente3 :" +e.getMessage());
            LisSumatoriadeCajaEquivalente3 = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  LisSumatoriadeCajaEquivalente3;     
    } 
    
      public List<beanSumatoriaSemanas> SumatoriadeCajaEquivalente4(String s1,String s2,String s3,String s4, String producto,String codcliente,Connection con) {
     List<beanSumatoriaSemanas> LisSumatoriadeCajaEquivalente4 = null;
ResultSet rs =null;
PreparedStatement ps=null;
          
          
          
          
        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
       String sql = " SELECT SUM("+s1+"),SUM("+s2+") , SUM("+s3+"),SUM("+s4+")   from (  SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+","+s2+","+s3+","+s4+" FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, sum( CAJA)as CAJA FROM   TABLA_PRODUCTOS_BO where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"'  group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA) PIVOT (SUM(CAJA) FOR   NROSEMANA  IN ('"+s1+"' as "+s1+", '"+s2+"' as "+s2+",'"+s3+"' as "+s3+" ,'"+s4+"' as "+s4+"   )  )  ) " ;
        
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      LisSumatoriadeCajaEquivalente4= new ArrayList<beanSumatoriaSemanas>();
        
                while (rs.next()) {
              beanSumatoriaSemanas bdinamico = new beanSumatoriaSemanas();
               bdinamico.setSem1(rs.getString(1));
               bdinamico.setSem2(rs.getString(2));
               bdinamico.setSem3(rs.getString(3));
               bdinamico.setSem4(rs.getString(4));
               LisSumatoriadeCajaEquivalente4.add(bdinamico);
            }
            
                
        
        } catch (Exception e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente4 :" +e.getMessage());
            LisSumatoriadeCajaEquivalente4 = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  LisSumatoriadeCajaEquivalente4;     
    }   
  public List<beanSumatoriaSemanas> SumatoriadeCajaEquivalente5(String s1,String s2,String s3,String s4,String s5, String producto,String codcliente,Connection con) {
     List<beanSumatoriaSemanas> LisSumatoriadeCajaEquivalente5 = null;
ResultSet rs =null;
PreparedStatement ps=null;

        try {
      //  con = oracleDaoLocalFactoryImpl.getSQLConextion();
      // st = con.createStatement();
       String sql = " SELECT SUM("+s1+"),SUM("+s2+") , SUM("+s3+"),SUM("+s4+"),SUM("+s5+")    from (  SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,"+s1+","+s2+","+s3+","+s4+","+s5+"  FROM (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, sum( CAJA)as CAJA FROM   TABLA_PRODUCTOS_BO where DESCATEGORIA='"+producto+"' and  COD_CLI_SAP ='"+codcliente+"'  group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA) PIVOT (SUM(CAJA) FOR   NROSEMANA  IN ('"+s1+"' as "+s1+", '"+s2+"' as "+s2+",'"+s3+"' as "+s3+" ,'"+s4+"' as "+s4+" ,'"+s5+"' as "+s5+" )  )  ) " ;
        
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      LisSumatoriadeCajaEquivalente5= new ArrayList<beanSumatoriaSemanas>();
        
                while (rs.next()) {
              beanSumatoriaSemanas bdinamico = new beanSumatoriaSemanas();
               bdinamico.setSem1(rs.getString(1));
               bdinamico.setSem2(rs.getString(2));
               bdinamico.setSem3(rs.getString(3));
               bdinamico.setSem4(rs.getString(4));
                bdinamico.setSem5(rs.getString(5));
               LisSumatoriadeCajaEquivalente5.add(bdinamico);
            }
            
                
        
        } catch (SQLException e) {
            System.out.println("Error en el metodo SumatoriadeCajaEquivalente5:" +e.getMessage());
            LisSumatoriadeCajaEquivalente5 = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }
        
        
        }

       return  LisSumatoriadeCajaEquivalente5;     
    }   
  
  
  
    
    
    
  public List<beansemaxprod> sumaporproductos(String s1,String s2,String s3,String s4,String s5,String s6, String producto,String codcliente,Connection con) {
     List<beansemaxprod> listasumaxprod = null;
ResultSet rs =null;
PreparedStatement ps=null;

        try {
     
       String sql = "SELECT SUM(S6),SUM(S7) , SUM(S8),SUM(S9),SUM(S10)   "+ 
 "    from (  SELECT  DESCATEGORIA,  DESMARCA,  DESCAPACIDAD,DESENVASE ,S6,S7,S8,S9,S10  FROM "+
"   (SELECT   DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, sum( CAJA)as CAJA "+
 "   FROM   TABLA_PRODUCTOS_BO "+
 "   where DESMARCA= '"+producto+"' " +
 "   and  COD_CLI_SAP =  '"+codcliente+"' " +
  "  group by  DESCATEGORIA, NROSEMANA, DESMARCA, ANIO, DESENVASE,  DESCAPACIDAD, CAJA) "+
  "  PIVOT (SUM(CAJA) FOR   NROSEMANA  IN ('S6' as S6, 'S7' as S7,'S8' as S8 ,'S9' as S9 ,'S10' as S10 )  )  ) ";
       
       
   ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      listasumaxprod= new ArrayList<beansemaxprod>();
        
      
                while (rs.next()) {
              beansemaxprod bdinamico = new beansemaxprod();
               bdinamico.setSem1(rs.getString(1));
               bdinamico.setSem2(rs.getString(2));
               bdinamico.setSem3(rs.getString(3));
               bdinamico.setSem4(rs.getString(4));
                bdinamico.setSem5(rs.getString(5));
                
               listasumaxprod.add(bdinamico);
            }
            
                
        
        } catch (Exception e) {
            System.out.println("Error en el metodo sumaporproductos :" +e.getMessage());
            listasumaxprod = null; 
        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
                
                rs.close();
            } catch (SQLException e) {
            }
       
            }

        }

       return  listasumaxprod;     
    }   
  
 public int insertarClienteParentesco (int id,String CodCliente, String Nro, String Parentesco ,String Nombre,String  Campana,Connection con) {
        
        int insert = 0;
         ResultSet rs =null;
          PreparedStatement ps=null;
          
        try {
                java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);  
         //  int id = sobtenerCodigo(Campana, con);
            
             String sql = " INSERT INTO PARENTESCO (ID,CODCLIENTE, NRO, PARENTESCO, NOMBRE,Hora) VALUES ('" +id +"','"+CodCliente+"', '"+Nro+"', '"+Parentesco+"', '"+Nombre+"' , '" + sqlTimestamp+"'  )" ;
 ps = con.prepareStatement(sql.toString());
 ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteParentesco:" + e.getMessage());

        }finally {
            if(con!=null){
            
            try {
               ps.close();
              
               
            } catch (SQLException e) {
            }
       
            }   
        }
        return insert;
    }
    public List <beanTelefonoParentesco> ObtenerTelefonoParentesco(String xcodigo,Connection con){
     List<beanTelefonoParentesco> ListObtenerTelefonoParentesco = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {
           // con = oracleDaoLocalFactoryImpl.getSQLConextion();
           // Statement st = con.createStatement();
            String sql = "select ID, CODCLIENTE , PARENTESCO , NRO ,NOMBRE from  PARENTESCO   where CODCLIENTE= '" + xcodigo + "'";
           // ResultSet rs = st.executeQuery(sql); 
            ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerTelefonoParentesco= new ArrayList<beanTelefonoParentesco>();
            while (rs.next()) {
                
                beanTelefonoParentesco ObtenerTelefonoParentesco=new beanTelefonoParentesco();
                
                ObtenerTelefonoParentesco  = new beanTelefonoParentesco();
                ObtenerTelefonoParentesco .setID(rs.getInt(1));
                ObtenerTelefonoParentesco .setCodCliente(rs.getString(2));
                ObtenerTelefonoParentesco.setParentesco(rs.getString(3));
                ObtenerTelefonoParentesco .setNumero(rs.getString(4));
              ObtenerTelefonoParentesco .setNombre(rs.getString(5));
              
               ListObtenerTelefonoParentesco.add(ObtenerTelefonoParentesco);

            }


        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerTelefonoParentesco :" + e.getMessage());
        } finally {
            try {
               rs.close();
               ps.close();
            } catch (SQLException e) {
            }
        }

        return ListObtenerTelefonoParentesco;
    }
   
    public int EliminarClienteParentesco (String CodCliente, String Nro,String campana ,Connection con) {
        
        int insert = 0;
        //ResultSet rs =null;
          PreparedStatement ps=null;
        try {
          
             String sql = " DELETE FROM PARENTESCO WHERE     CODCLIENTE = '" +CodCliente+"' and NRO='"+Nro +"'";
            
    
             ps = con.prepareStatement(sql.toString());
           ps.executeUpdate();
          
        } catch (Exception e) {
            System.out.println("Error en la  el metodo EliminarClienteParentesco:" + e.getMessage());

        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
               
            
            } catch (SQLException e) {
            }
       
            }
        }   
        return insert;
    }
    public int ActualizarClienteParentesco (String Nroantiguo, String Nro, String Parentesco ,String Nombre,String Campana, Connection con) {
      
          PreparedStatement ps=null;
        int insert = 0;
        try {
                 java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);  
         //  int id = obtenerCodigo(Campana, con);
                   
             String sql = " UPDATE PARENTESCO  SET NRO='" +Nro +"' ,  Hora = '" +sqlTimestamp+"'" 
                    
                     + " WHERE   NRO='"+ Nroantiguo +"'" ;
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           
             ps = con.prepareStatement(sql.toString());
              ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en la  el metodo ActualizarClienteParentesco:" + e.getMessage());

        }finally {
            if(con!=null){
            
            try {
                
                ps.close();
               
               
            } catch (SQLException e) {
            }
       
            }
        }   
        return insert;
    }
  public String VentanaHoraria(String codigox,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
           String ventana="";
        try {
            
            
           String  sql = "Select VentanaHoraria FROM VentanaHoraria where     CodCliente ='"+codigox+"'";
           ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
            ventana = rs.getString(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo VentanaHoraria :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        
        return  ventana;
    }
  
 
       public int VerificarCodigoVentanaHoraria(int id,String codigox,String campana ,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
           
          ///  int id = obtenerCodigo(campana, con);
           String  sql = "Select count(CodCliente) FROM VentanaHoraria  where   CodCliente ='"+codigox+"'";
             ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerCodigo :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        
        return  codigo ;
    }
      public int insertarVentanaHoraria(int id,String campana, String codCliente,String rango,String Campana ,Connection con  ){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
         
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
 
             String sql = "INSERT INTO  VentanaHoraria (Id,CodCliente,VentanaHoraria,Hora) VALUES('" +id  +"' , '"+codCliente+"','"+rango +"','"+sqlTimestamp+"')  ";

 ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarVentanaHoraria:" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
     
   public int ActualizarVentanaHoraria(int id,String campana, String codCliente,String rango,Connection con ){
       ResultSet rs =null;
          PreparedStatement ps=null;



        int insert = 0;
        try {
         
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
  //   int id = obtenerCodigo(campana, con);
             String sql = "UPDATE VentanaHoraria   SET  VentanaHoraria='"+rango +"' ,   Id='"+ id+"'    WHERE     CodCliente  =   '"+ codCliente+"'      ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
            
 ps = con.prepareStatement(sql.toString());
      ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la  el metodo ActualizarVentanaHoraria:" + e.getMessage());

        }
finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }
   
    public int contaagrega(String CodCliente,Connection con) {
      //  Connection cn = null;
        int codigo = 0;
        
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
           // cn = oracleDaoLocalFactoryImpl.getSQLConextion();
           // Statement st = cn.createStatement();
            String sql = "SELECT COUNT(ID) FROM nroagregado  " +
"WHERE codcliente='"+CodCliente+"'";
            
            //ResultSet rs = st.executeQuery(sql);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo contaagrega :" + e.getMessage());
        }
        return codigo;
     
     
     } 
  public List ListaBonificacion (String CodCliente,Connection con) {
      //  Connection cn = null;
     
        int codigo = 0;
          List<beanBonificacion> listaBonificacion = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
           // cn = oracleDaoLocalFactoryImpl.getSQLConextion();
           // Statement st = cn.createStatement();'
            String sql = "  select descbonificacion,  periododiani, periododiafin from bonificacion  \n" +
"where COD_CLI_SAP= '"+CodCliente+"'";
         /////////// System.out.println("ccnnnn===> "+sql);  
            //ResultSet rs = st.executeQuery(sql);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
             listaBonificacion= new ArrayList<beanBonificacion>();
            while(rs.next()){
             beanBonificacion ObtenerBonifi=new beanBonificacion();
                
                
                ObtenerBonifi .setDescbonificacion(rs.getString(1));
             
                 ObtenerBonifi .setPeriododiani(rs.getString(2));
                ObtenerBonifi .setPeriododiafin(rs.getString(3));
               listaBonificacion.add(ObtenerBonifi);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo ListaBonificacion :" + e.getMessage());
        }
        return listaBonificacion;
     
     
     } 
   
   
   
   
   
    @Override
    public List<beantabladinamica> ObtenerTablaDinamica1(String s1, String producto, String codcliente, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
   
  
  
  
  
}
    


    

