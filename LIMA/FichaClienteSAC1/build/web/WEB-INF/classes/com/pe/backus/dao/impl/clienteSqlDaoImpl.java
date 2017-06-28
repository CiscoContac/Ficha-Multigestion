/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.dao.impl;

import com.pe.backus.dao.clienteSqlDAO;
import com.pe.backus.dto.beanAgendaSAC;
import com.pe.backus.dto.beanAlertaPFR;
import com.pe.backus.dto.beanAnotacion;
import com.pe.backus.dto.beanCargaDistribucion;
import com.pe.backus.dto.beanClienteSAC;
import com.pe.backus.dto.beanClienteTelefono;
import com.pe.backus.dto.beanClienteTelefonoLocal;
import com.pe.backus.dto.beanDetalladoClienteSAC;
import com.pe.backus.dto.beanEntrega;
import com.pe.backus.dto.beanInformacionAdicionalBO;
import com.pe.backus.dto.beanListaClickTocall;
import com.pe.backus.dto.beanListaCuic;

import com.pe.backus.dto.beanResuLLamada;
import com.pe.backus.dto.beanResultadoGestionSAC;
import com.pe.backus.dto.beanResultadoSAC;
import com.pe.backus.dto.beanResumenCamp;
import com.pe.backus.dto.beanTelefonoAgregados;
import com.pe.backus.dto.beanTelefonoClienteLista;
import com.pe.backus.dto.beanTelefonoParentesco;
import com.pe.backus.dto.beansemaxprod;
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
public class clienteSqlDaoImpl implements clienteSqlDAO{

    @Override
    public List<beanAnotacion> ObtenerFecha(String xcodigo,Connection con) {
         List<beanAnotacion> listObtenerFecha = null;
         ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
      //  Statement st = con.createStatement();
        //int id=obtenerCodigo(campana);
        
 String sql = " select Top 32 Idx,CONVERT(VARCHAR,Hora , 103) + ' '+CONVERT(VARCHAR,Hora , 8)   as fecha,Descripcion "+
" from [Ficha_Cliente].[dbo].[Anotacion] "+
" where   "+
"    CodCliente ='"+ xcodigo+"'"+ 
" and Hora <> '1900-01-01 00:00:00.000' "
+ "  order by   Hora desc   ";
        
        
        
       // ResultSet rs = st.executeQuery(sql);
          ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        listObtenerFecha = new ArrayList<beanAnotacion>();
        
                while (rs.next()) {
                beanAnotacion fila = new beanAnotacion();
                fila.setId(rs.getString(1));
               fila.setFecha(rs.getString(2));
               fila.setDescripcion(rs.getString(3));
                listObtenerFecha.add(fila);
            }
            
               
        
        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerFecha :" +e.getMessage());
           listObtenerFecha = null; 
        }finally {
            try {
                rs.close();
                ps.close();
    
            } catch (SQLException e) {
            }
        }

       return listObtenerFecha;
    }
    

    
    public void actualizarAnotacion(String campana , String Anotacion,int cont ,Connection con ){
        
        ResultSet rs =null;
          PreparedStatement ps=null;
   int id;
   int conta;
        try {
             Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
       id=obtenerCodigo(campana,cn_rascalLocal);  
       cn_rascalLocal.close();
       conta= cont +1 ;
       System.out.println("imprimirr actuaconta:"+ conta);
       if(Anotacion.equals("")){}else{
//  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "Update [Ficha_Cliente].[dbo].[Anotacion]  SET [Hora] = '"+sqlTimestamp+"', contador= "+conta+"  , [Descripcion] = '" + Anotacion+ "' where  Idx='"+ id+"' ";
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
    
        
 ps = con.prepareStatement(sql.toString());
   ps.executeUpdate();
   con.commit();
}
        } catch (SQLException e) {
            System.out.println("Error en la  el metodo actualizarAnotacion :" + e.getMessage());

        } 
finally {
            try {
             
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
  
        
        
    }
    
    public void ModificaAnotacion( String Anotacion ,String id, int cont ,Connection con){
        
          PreparedStatement ps=null;
          int conta;
        try {
           
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
           //  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
   conta = cont+1;
       System.out.println("imprimirr modifica:"+ conta);
  String sql = "Update [Ficha_Cliente].[dbo].[Anotacion]  SET   [Descripcion] = '" + Anotacion+ "', [contador] = "+conta+" where  Idx='"+ id+"' ";
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
    
          ps = con.prepareStatement(sql.toString());
    ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo ModificaAnotacion :" + e.getMessage());

        } finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        
        
    }

    
    
    public List<beanClienteTelefono> ObtenerTelefono(String codigocliente) {
        List<beanClienteTelefono> listObtenerTelefono = null ;
        
        Connection con = null;
        try {
            con = javaclassconexionsql.getSQLConextion();
            Statement st = con.createStatement();
            String sql = "select  AccountNumber ,Phone01,Phone02,Phone03,Phone04,FirstName,LastName  FROM [rmc_baA].[dbo].[Automatica] where [AccountNumber] like '" + codigocliente + "'";
            ResultSet rs = st.executeQuery(sql);
            listObtenerTelefono = new ArrayList<beanClienteTelefono>();
            while (rs.next()) {
                
                beanClienteTelefono beanObtenerTelefono    = new  beanClienteTelefono();
                
                beanObtenerTelefono = new beanClienteTelefono();
                beanObtenerTelefono.setCodCliente(rs.getString(1));
                beanObtenerTelefono.setNumero1(rs.getString(2));
                beanObtenerTelefono.setNumero2(rs.getString(3));
                beanObtenerTelefono.setNumero3(rs.getString(4));
                beanObtenerTelefono.setNumero4(rs.getString(5));
                beanObtenerTelefono.setApellido(rs.getString(6));
                beanObtenerTelefono.setNombre(rs.getString(7));
                
                
              listObtenerTelefono.add(beanObtenerTelefono);

            }


        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerTelefono :" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return listObtenerTelefono;
    }

    
    public List<beanListaClickTocall> ObtenerListaTelefonoClick(String codigocliente) {
        List<beanListaClickTocall> listObtenerListaTelefonoClick = null ;
        
        Connection con = null;
        try {
            con = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
            Statement st = con.createStatement();
            String sql = "SELECT [AccountNumber],[FirstName],[LastName],[Phone01],[Phone02],[Phone03],[Phone04],[Phone05],[Phone06],[Phone07],[Phone08],[Phone09],[Phone10]FROM [GMD_RASCAL].[dbo].[Automatica]where [AccountNumber]='"+codigocliente+"' AND [Fecha]=(select max([Fecha])  from  [GMD_RASCAL].[dbo].[Automatica] where [AccountNumber]='"+codigocliente+"')";
            ResultSet rs = st.executeQuery(sql);
            listObtenerListaTelefonoClick  = new ArrayList<beanListaClickTocall>();
            while (rs.next()) {
                
                beanListaClickTocall beanObtenerTelefonoclick    = new  beanListaClickTocall();
                
                beanObtenerTelefonoclick  = new beanListaClickTocall();
               beanObtenerTelefonoclick .setCodCliente(rs.getString(1));
               beanObtenerTelefonoclick.setApellido(rs.getString(3));
              beanObtenerTelefonoclick.setNombre(rs.getString(2));
               beanObtenerTelefonoclick.setNumero1(rs.getString(4));
                beanObtenerTelefonoclick.setNumero2(rs.getString(5));
               beanObtenerTelefonoclick.setNumero3(rs.getString(6));
              beanObtenerTelefonoclick.setNumero4(rs.getString(7));
               beanObtenerTelefonoclick.setNumero5(rs.getString(8));
                beanObtenerTelefonoclick.setNumero6(rs.getString(9));
               beanObtenerTelefonoclick.setNumero7(rs.getString(10));
              beanObtenerTelefonoclick.setNumero8(rs.getString(11));
                beanObtenerTelefonoclick.setNumero9(rs.getString(12));
              beanObtenerTelefonoclick.setNumero10(rs.getString(13));
              
                
                
              listObtenerListaTelefonoClick.add(beanObtenerTelefonoclick);

            }


        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerListaTelefonoClick :" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return listObtenerListaTelefonoClick;
    }
       

    public String obtenerContactomodificado(String CodCliente,Connection con) {
      //  Connection cn = null;
        String codigo = "";
        
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
           // cn = oracleDaoLocalFactoryImpl.getSQLConextion();
           // Statement st = cn.createStatement();
            String sql = "Select CONTACTOMODIFICADO from MODIFICACIONCONTACTO where    \n" +
                           " CODCLIENTE='"+CodCliente+"'  AND  HORA=(SELECT MAX(HORA) FROM   MODIFICACIONCONTACTO  WHERE CODCLIENTE='"+CodCliente+"' )  "  ;
            
            //ResultSet rs = st.executeQuery(sql);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerContactomodificado( :" + e.getMessage());
        }
        return codigo;
     
     
     }

 
   
  public List <beanResumenCamp> obtieneResumenCamp(String campana,Connection con){
     List<beanResumenCamp> listaResumenCamp = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {
           // con = oracleDaoLocalFactoryImpl.getSQLConextion();
           // Statement st = con.createStatement();
            String sql = " exec get_inf_rt_Campaign "+campana;
           // ResultSet rs = st.executeQuery(sql); 
            ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            listaResumenCamp= new ArrayList<beanResumenCamp>();
            while (rs.next()) {
             
                beanResumenCamp ObtenerResumenCamp=new beanResumenCamp();
                
             ObtenerResumenCamp.setTotal_records(rs.getString(1));
              ObtenerResumenCamp.setVoice(rs.getString(2));
              ObtenerResumenCamp.setAvailable(rs.getString(3));
              ObtenerResumenCamp.setClosed(rs.getString(4));
              ObtenerResumenCamp.setCallback(rs.getString(5));
               listaResumenCamp.add(ObtenerResumenCamp);
            }


        } catch (Exception e) {
            System.out.println("Error en el metodo obtieneResumenCamp :" + e.getMessage());
        } finally {
            try {
               rs.close();
               ps.close();
            } catch (SQLException e) {
            }
        }

        return listaResumenCamp;
    } 
   
   
   
  
   public int ModificarContacto (String CodCliente, String contacto, String ContactoModificado ,Integer  id ,Connection con) {
        
        int insert = 0;
         ResultSet rs =null;
          PreparedStatement ps=null;
          System.out.println("hola");
     System.out.println("   "+CodCliente+contacto+ContactoModificado+id);
        try {
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
           
            
 String sql = " INSERT INTO MODIFICACIONCONTACTO (ID,CODCLIENTE, CONTACTO, CONTACTOMODIFICADO, HORA) VALUES ('"+id+"', '"+CodCliente+"', '"+contacto+"', '"+ContactoModificado+"', '"+sqlTimestamp+"')" ;
 ps = con.prepareStatement(sql.toString());
 ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo ModificarContacto :" + e.getMessage());

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

    
    
    public List<beanDetalladoClienteSAC> ObtenerDetalle(String campana,Connection con) {
        List<beanDetalladoClienteSAC> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {

             String sql =      " EXEC	[Rascal].[dbo].[DetalladoSacFinal]"+
		" @campana  = N'"+campana+"',  "+
		" @where = N'numero like ''%%''' ";
    
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanDetalladoClienteSAC>();

            while (rs.next()) {
                beanDetalladoClienteSAC obtenerDetalle = new beanDetalladoClienteSAC();
               
                obtenerDetalle.setNumero(rs.getString(1));
                obtenerDetalle.setFecha(rs.getString(2));
                obtenerDetalle.setTipo(rs.getString(3));
                obtenerDetalle.setTipo_Identificador(rs.getString(4));
                obtenerDetalle.setTipo_Cliente(rs.getString(5));
                obtenerDetalle.setCodcliente(rs.getString(6));
                obtenerDetalle.setTipo_Llamada(rs.getString(7));
                obtenerDetalle.setResultado_Contacto(rs.getString(8));
                obtenerDetalle.setTipificacion_Llamada(rs.getString(9));
                obtenerDetalle.setCONTADORCliente( rs.getString(10) );
                 obtenerDetalle.setCONTADORContacto( rs.getString(11) );
                 
                ListObtenerDetalle.add(obtenerDetalle);
            }

            if (ListObtenerDetalle.isEmpty()) {
                ListObtenerDetalle = null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerDetalle :" + e.getMessage());
            ListObtenerDetalle = null;
        } finally {
            try {
               ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }

        return ListObtenerDetalle;
    }

    public int insertarClienteIdentificador(String campana, String codCliente ,String automatic,Connection con) {
        Statement st = null;

        int insert = 0;
        try {
         
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
             st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
             String sql = "INSERT INTO [Rascal].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora],[Tipo]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"','"+automatic+"')";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
                st.executeUpdate(sql);
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteIdentificador :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }
    public  String sumaventa(String Campana ,Connection con) {
        
     String  resul ="";
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT sum(CONTADOR)\n" +
"  FROM [Rascal].[dbo].[VentasXCampanaXRUTA]\n" +
"  where IDTelevendedor='"+Campana+"'";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                resul=rs.getString(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo sumaventa:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return resul;
    }
   public  String sumacontacto(String Campana ,Connection con) {
        
     String  resul ="";
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT sum(CONTADOR)\n" +
"  FROM [Rascal].[dbo].[EfectividadXContacto]\n" +
"  where IDTelevendedor='"+Campana+"'";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                resul=rs.getString(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo sumaventa:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return resul;
    } 
   
    public  String numeroAPSAC(String codcliente ,Connection con) {
        
     String  resul ="";
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT \n" +
"      [Phone01]\n" +
"      \n" +
"  FROM [rmc_baA].[dbo].[Capacitacion]\n" +
"  where \n" +
"  [AccountNumber]='"+codcliente+"'";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                resul=rs.getString(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo numeroAPSAC:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return resul;
    } 
   
   
     public List<beanResuLLamada> obtenerResultadoLlamadaHsitorico( String xcodigo,Connection con ){
       List<beanResuLLamada> ListbeanResullamada ;
      ResultSet rs =null;
          PreparedStatement ps=null;
        int id ;
        try {
      
        //id = obtenerCodigo(Campana);
        String sql = "SELECT Idx      \n" +
"         ,CONVERT(VARCHAR,Hora , 103) +  ' '  + CONVERT(VARCHAR,Hora , 8)   as fecha       \n" +
"        ,contacto_cliente     \n" +
"        ,razon_no_contacto     \n" +
"        ,Realizo_venta       \n" +
"         ,razon_no_venta        \n" +
"         ,recojo         \n" +
"        ,cobranza           \n" +
"         ,evento         \n" +
"        , Tipo_Gestion                   \n" +
"    \n" +
"           ,CodCliente     \n" +
"  FROM [Ficha_Cliente].[dbo].[ResultadoLlamada]\n" +
"\n" +
"  where [CodCliente]='"+xcodigo+"'\n" +
"  and contador >='1'\n" +
"    order by [FechaA] desc ";

        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
  
        ListbeanResullamada = new ArrayList<beanResuLLamada>();
        
                while (rs.next()) {
                beanResuLLamada beanresullamada = new beanResuLLamada();
                beanresullamada.setId(rs.getString(1));
                beanresullamada.setFecha(rs.getString(2));
                beanresullamada.setContacCliente(rs.getString(3));
                beanresullamada.setRazonNoContacto(rs.getString(4));
                beanresullamada.setRealizoVenta(rs.getString(5));
                beanresullamada.setRazonNoVenta(rs.getString(6));
                beanresullamada.setRecojo(rs.getString(7));
                beanresullamada.setCobranza(rs.getString(8));
                beanresullamada.setEvento(rs.getString(9));
                beanresullamada.setTipogestion(rs.getString(10));
                ListbeanResullamada.add(beanresullamada);
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerResultadoLlamada :" +e.getMessage());
           ListbeanResullamada = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return ListbeanResullamada;
  }
     
  public int LlamadaSAC (Connection con)  { 
   
             ResultSet rs =null;
          PreparedStatement ps=null;
        int resultado = 0;
        try {
           
            String sql = "    SELECT max([Id_Llamada]) \n" +
"    FROM [Rascal].[dbo].[Identificadoor_SAC]  ";
            ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

            while(rs.next()){
            resultado = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo LlamadaSAC :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return resultado;
            }
 public int insertarClienteIdentificadorSAC(String num_entrante,String campana ,Connection con) {
        Statement st = null;

        int insert = 0;
        try {
         int id_llamada= LlamadaSAC(con);
         System.out.println("valor ========> "+id_llamada);
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
        if( id_llamada==0){
            id_llamada=1;
        }else{
            id_llamada ++;
        }
             st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
        String sql = "INSERT INTO [Rascal].[dbo].[Identificadoor_SAC]([Id_Llamada],[numero_entrante] ,[Campana],[Hora]) VALUES    ('"+id_llamada+"','"+num_entrante+"','"+campana+"','"+sqlTimestamp+"')";
  
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
                st.executeUpdate(sql);
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteIdentificadorSAC :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }    
public int InsertClienteIdentificadorSAC(String tipo,int ID_llamada,String numero,String Campana , Connection con) {
        Statement st = null;
        int insert = 0;
        try {
         
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
             st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
 
        //// System.out.println("valor ========> "+id_llamada);
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
        
    
  String sql = "INSERT INTO [Rascal].[dbo].[Identificadoor_SAC](\n" +
"            [Tipo]\n" +
"           ,[Id_Llamada]\n" +
"           ,[numero]\n" +
"           ,[Campana]\n" +
"           ,[Fecha_Ingreso]) VALUES    ('"+tipo+"','"+ID_llamada+"', '"+numero+"', '"+Campana+"', '"+sqlTimestamp+"') "  ;
       

        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
                st.executeUpdate(sql);
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo InsertClienteIdentificadorSAC :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }    
 public int UpdateIdentificadorSAC (String numero,int id  , Connection con) {
        Statement st = null;
        int insert = 0;
        try {
         
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
             st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
 
        //// System.out.println("valor ========> "+id_llamada);
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
        
    
  String sql = "UPDATE [Rascal].[dbo].[Identificadoor_SAC]\n" +
"   SET\n" +
"      [numero] = '"+numero+"' \n" +
"   \n" +
" WHERE [Id_Gestion]='"+id+"' "  ;
       

        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
                st.executeUpdate(sql);
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo InsertClienteIdentificadorSAC :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }    
 public int InsertClienteResultadoGestionSAC(String TipoIdentif,String identificador,String tipo_cliente,String Tipo_Llamada,String Resultado_Contacto,String Cliente_Contactado, String Cliente_No_Contactado,String Campana,Connection con) {
        Statement st = null;
        int insert = 0;
        try {
         
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
             st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
 int id=obtenerCodigoSAC(Campana, con);
        //// System.out.println("valor ========> "+id_llamada);
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
        
    
  String sql = "INSERT INTO [Rascal].[dbo].[Resultado_Gestion_SAC]\n" +
"           ([Id]\n" +
"           ,[Tipo_Identificador]\n" +
          " ,[Identificador]"+
"           ,[Tipo_Cliente]\n" +
"           ,[Tipo_Llamada]\n" +
"           ,[Resultado_Contacto]\n" +
"           ,[Cliente_Contactado]\n" +
"           ,[Cliente_No_Contactado]\n" +
"           ,[Fecha]"
          + " ,[Campana])VALUES    ('"+id+"','"+TipoIdentif+"', '"+identificador+"', '"+tipo_cliente+"', '"+Tipo_Llamada+"', '"+Resultado_Contacto+"','"+Cliente_Contactado+"','"+Cliente_No_Contactado+"','"+sqlTimestamp+"','"+Campana+"') "  ;
       

        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
                st.executeUpdate(sql);
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo InsertClienteResultadoGestionSAC :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }    
 
  public int InsertClienteAgendaSAC( String campana,String tipo_identi,
          String codigoIdenti,String tel_fijo1,String tel_fijo2, String celular1 ,String celular2,String fecha_agendado, Connection con) {
        Statement st = null;
        int insert = 0;
        try {
         
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
             st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
 int id=obtenerCodigoSAC(campana, con);
        //// System.out.println("valor ========> "+id_llamada);
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
        

String sql = "insert into [Rascal].[dbo].[Agenda_SAC] (\n" +
"       [id_Gestion]\n" +
"      ,[campana]\n" +
"      ,[tipo_Identificador]\n" +
"      ,[codigo_Identificador]\n" +
"      ,[telf_Fijo1]\n" +
"      ,[telf_Fijo2]\n" +
"      ,[celular1]\n" +
"      ,[celular2]\n" +
"      ,[fecha_Insertada]\n" +
"      ,[fecha_Agendado])values('"+id+"','"+campana+"','"+tipo_identi+"','"+codigoIdenti+"','"+tel_fijo1+"','"+tel_fijo2+"','"+celular1+"','"+celular2+"','"+sqlTimestamp+"','"+fecha_agendado+"') "  ;


        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
                st.executeUpdate(sql);
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo InsertClienteAgendaSAC :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }    
 
 
 
 
 
 
 
 
 
 
 
 
 
 
public int UpdateIdentificadorSAC(String nomcliente,String tipo_identificador,String Apellido,String Campana ,String Codcliente,Connection con) {
        Statement st = null;

        int insert = 0;
        try {
         
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
             st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
    ///int id= obtenerCodigoSAC(numero, con);
    
        String sql = "UPDATE [Rascal].[dbo].[Identificadoor_SAC]\n" +
"   SET \n" +
  "  [Nombre]= '"+nomcliente+"' "+
 " , [Tipo_Identificador] = ' "+ tipo_identificador+"'"+
",[CodCliente]='"+Codcliente+"'\n" +
"             ,[Fecha_Gestion]='"+sqlTimestamp+"' "+
" WHERE [Id_Gestion] =\n" +
" (\n" +
"  SELECT max([Id_Gestion])\n" +
"    FROM [Rascal].[dbo].[Identificadoor_SAC]\n" +
"    where Campana='"+Campana+"'\n" +
" ) ";
       
  
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
                st.executeUpdate(sql);
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo UpdateIdentificadorSAC :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }     

public int PROCEDUREVENTASAC(String Codcliente,String Campana,String caja,Connection con) {
        Statement st = null;

        int insert = 0;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {
         
           // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
             st = con.createStatement();
        
         
    ///int id= obtenerCodigoSAC(numero, con);
            String sql = "EXEC	[Rascal].[dbo].[VENTASAC]  '"+Codcliente+"','"+Campana+"','"+caja+"'";
            System.out.println("Error en la " + sql);
            ps = con.prepareStatement(sql.toString());
            ps.executeUpdate();
  
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
               

        } catch (Exception e) {
            System.out.println("Error en la  el metodo PROCEDUREVENTASAC :" + e.getMessage());

        }
finally {
            try {
               
                st.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }    

    public int insertarClienteAnotacion(int id,String Anotacion,String codcli,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
           
         // Integer Id= obtenerCodigo(campana,con);
                    // st = con.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
             String sql = " INSERT INTO [Rascal].[dbo].[Anotacion] ([Idx],[Descripcion],[Hora],[CodCliente],[FechaA])VALUES('"+id+"','"+Anotacion+"','','"+codcli+"','"+sqlTimestamp+"' )  ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
             ps = con.prepareStatement(sql.toString());
             ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteAnotacion:" + e.getMessage());

        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
       public int insertarClienteManual(int id,String Nro,String campana,Connection con) {
      /*  Connection cn = null;*/
           ResultSet rs =null;
          PreparedStatement ps=null;

        int insert = 0;
        try {

             java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
       // int id = obtenerCodigo(campana, con);    
            
             String sql = " INSERT INTO [Rascal].[dbo].[Manual_SAC]([ID_Gestion],[numero],[HoraClick],[Campana])VALUES('"+id+"','"+Nro+"','"+sqlTimestamp+"','"+campana+"') ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
        ps = con.prepareStatement(sql.toString());
         ps.executeUpdate();
      
        } catch (SQLException e) {
            System.out.println("Error en la  el metodo insertarClienteManual:" + e.getMessage());

        }
finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }

         public int insertarClienteManual1( int id,String Nro,Connection con) {
      /*  Connection cn = null;*/
           ResultSet rs =null;
          PreparedStatement ps=null;

        int insert = 0;
        try {

             java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
            
            
             String sql = " INSERT INTO [Ficha_Cliente].[dbo].[Manual]([Idx],[Nro],[HoraClick])VALUES('"+id+"','"+Nro+"','"+sqlTimestamp+"') ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
        ps = con.prepareStatement(sql.toString());
         ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo insertarClienteManual1:" + e.getMessage());

        }
finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
       
       
       
       
       
       
       
       
       
       
         public int UpdateClienteManual(String Nro, Integer Id,Connection cn) {
        ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
          
           
             java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 

             String sql = "Update [Rascal].[dbo].[Manual_SAC]  SET [numero] = '"+Nro+"' , [HoraClick]='"+ sqlTimestamp +"'  where  [ID_Gestion]='"+ Id+"'      ";
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           ps = cn.prepareStatement(sql.toString());
      ps.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error en la  el metodo UpdateClienteManual:" + e.getMessage());

        }finally {
            try {
             
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
     public int insertarClienteParentesco (String CodCliente, String Nro, String Parentesco ,String Nombre) {
        Connection cn = null;
        int insert = 0;
        try {
            cn = oracleDaoFactoryImpl.getOracleConextion();
            Statement st = cn.createStatement();
           
             String sql = " INSERT INTO PARENTESCO (CODCLIENTE, NRO, PARENTESCO, NOMBRE) VALUES ('"+CodCliente+"', '"+Nro+"', '"+Parentesco+"', '"+Nombre+"')" ;
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
             st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteParentesco:" + e.getMessage());

        }
        return insert;
    }

     
   public int insertarClienteSAC (String nombre, String DNI, String Fijo1 ,String Fijo2,String Celular1,String Celular2,String Tipo,String RUC,int id,String Campana,  Connection cn ) {
      
        int insert = 0;
        try {
           
            Statement st = cn.createStatement();//create statmenet
            
              java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
  
             String sql = "INSERT INTO [Rascal].[dbo].[CLIENTE_SAC]\n" +
"           ([Nombre]\n" +
"           ,[DNI]\n" +
"           ,[Fijo1]\n" +
"           ,[Fijo2]\n" +
"           ,[Celular1]\n" +
"           ,[Celular2]\n" +
"           ,[Tipo]\n" +
"           ,[RUC]\n" +
                     " ,[ID_gestion]"+
 ",[Campana]\n" +
"           ,[Fecha])"+ 

"     VALUES\n" +
"           ('"+nombre+"','"+DNI+"','"+Fijo1+"','"+Fijo2+"','"+Celular1+"','"+Celular2+"','"+Tipo+"','"+RUC+"', "+id+" ,'"+Campana+"','"+sqlTimestamp+"')" ;
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
             st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error en   el metodo insertarClienteSAC:" + e.getMessage());

        }
        return insert;
    }
   
   public List<beanClienteSAC> obtenerClienteSAC( String campana,Connection con ){
       List<beanClienteSAC> ListclienteSAC;
      ResultSet rs =null;
          PreparedStatement ps=null;
        int id ;
        try {
      
        //id = obtenerCodigo(Campana);
        String sql = "SELECT \n" +
"       [Nombre]\n" +
"      ,[DNI]\n" +
"      ,[Fijo1]\n" +
"      ,[Fijo2]\n" +
"      ,[Celular1]\n" +
"      ,[Celular2]\n" +
"      ,[Tipo]\n" +
"      ,[RUC]\n" +
"  FROM [Rascal].[dbo].[CLIENTE_SAC]\n" +
"  where Id=(SELECT  max(ID) from [Rascal].[dbo].[CLIENTE_SAC]\n" +
"  where Campana='"+campana+"')";

        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
     con.commit();
        ListclienteSAC = new ArrayList<beanClienteSAC>();
        
                while (rs.next()) {
                beanClienteSAC beanresullamada = new beanClienteSAC();
               beanresullamada.setNombre(rs.getString(1));
               beanresullamada.setDNI(rs.getString(2));
               beanresullamada.setFijo1(rs.getString(3));
               beanresullamada.setFijo2(rs.getString(4));
               beanresullamada.setCelular1(rs.getString(5));
               beanresullamada.setCelular2(rs.getString(6));
               beanresullamada.setTipo(rs.getString(7));
                 beanresullamada.setRUC(rs.getString(8));
                ListclienteSAC.add(beanresullamada);
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerClienteSAC :" +e.getMessage());
           ListclienteSAC = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return ListclienteSAC;
  }
    
     
        public int insertarClienteResultadoLlamada(int id,String xcodigo,String campana,Connection con){
        ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
           
             java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
  //int id = obtenerCodigo(campana, con);
  
  
            String sql = "INSERT INTO [Rascal].[dbo].[ResultadoLlamada]([Idx],[CodCliente],[Hora],[contador],[Campana],[FechaA]) "
                                         + "VALUES ('"+id+"','"+xcodigo+"','',0,'"+campana+"','"+sqlTimestamp+"' )";
            ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();
   
        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteResultadoLlamada:" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
 
          public int insertarClienteTelefono(String campana, String codCliente,String nro1,String nro2 ,String nro3 ,String nro4 ,Connection con ){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
           
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
             String sql = "INSERT INTO [Ficha_Cliente].[dbo].[TelefonosCliente] ([Campana],[CodCliente],[telefono1],[telefono2],[telefono3],[telefono4],[Hora]) VALUES('"+campana+"','"+codCliente+"','"+nro1 +"','"+nro2 +"','"+nro3 +"','"+nro4 +"','"+sqlTimestamp+"')  ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           ps = con.prepareStatement(sql.toString());
      ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarClienteTelefono:" + e.getMessage());

        }
finally {
            try {
             
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
        public int obtenerCodigoSAC(String Campana,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
        int codigo = 0;
        try {
           
            String sql = "Select max(Id_Gestion) from [Rascal].[dbo].[Identificadoor_SAC]  where Campana = " +"'"+ Campana+"'";
           
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
        return codigo;
    }
    @Override
    public int obtenerCodigo(String campana,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
        int codigo = 0;
        try {
           
            String sql = "Select max(Id) from [Rascal].[dbo].[Identificadoor] where Campana = " +"'"+ campana+"'";
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
        return codigo;
    }
@Override
  public List<beanResuLLamada> obtenerResultadoLlamada( String xcodigo,Connection con ){
       List<beanResuLLamada> ListbeanResullamada ;
      ResultSet rs =null;
          PreparedStatement ps=null;
        int id ;
        try {
      
        //id = obtenerCodigo(Campana);
        String sql = "select Top 32 Idx  "+
       ",CONVERT(VARCHAR,Hora , 103) +' '+ CONVERT(VARCHAR,Hora , 8)   as fecha   "+
     " ,contacto_cliente "+
     " ,razon_no_contacto "+
     " ,Realizo_venta   "+
      " ,razon_no_venta    "+
    "   ,recojo     "+
"      ,cobranza       "+
    "   ,evento     "+
    "  , Tipo_Gestion               "+
    
       "  ,CodCliente "+
    "   from [Rascal].[dbo].[ResultadoLlamada]  "+
  
 "  where  " +
  " CodCliente = " + "'"+ xcodigo+"'"  +
 "  and Hora <> '1900-01-01 00:00:00.000'"+
            "    order by Hora desc ";

        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
     con.commit();
        ListbeanResullamada = new ArrayList<beanResuLLamada>();
        
                while (rs.next()) {
                beanResuLLamada beanresullamada = new beanResuLLamada();
                beanresullamada.setId(rs.getString(1));
                beanresullamada.setFecha(rs.getString(2));
                beanresullamada.setContacCliente(rs.getString(3));
                beanresullamada.setRazonNoContacto(rs.getString(4));
                beanresullamada.setRealizoVenta(rs.getString(5));
                beanresullamada.setRazonNoVenta(rs.getString(6));
                beanresullamada.setRecojo(rs.getString(7));
                beanresullamada.setCobranza(rs.getString(8));
                beanresullamada.setEvento(rs.getString(9));
                beanresullamada.setTipogestion(rs.getString(10));
                ListbeanResullamada.add(beanresullamada);
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerResultadoLlamada :" +e.getMessage());
           ListbeanResullamada = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return ListbeanResullamada;
  }
 @Override 
 
 
 public void actualizarResultadoLlamada(String campana,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String recojo,String cobranza,String evento,String tipgestion ,Connection con){
   ResultSet rs =null;
          PreparedStatement ps=null;

  
   int id;
        try {
           
           
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
 Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
       id=obtenerCodigo(campana,cn_rascalLocal);   
       cn_rascalLocal.close();
           //  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "Update [Rascal].[dbo].[ResultadoLlamada]  SET [Hora] = '"+sqlTimestamp+"' , [contacto_cliente]='"+ noContactoCli +"', [razon_no_contacto]='"
            +razonNoContac+"' , [Realizo_venta]='"+ RealVenta+"', [razon_no_venta]='"+NoVentaCerve+"', [recojo]='"+recojo+"',[cobranza]='"+cobranza+"',[evento]='"+evento+"',[Tipo_Gestion]= '" +tipgestion+"'  ,[contador]=[contador]+1   where  Idx='"+ id+"' ";
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
 ps = con.prepareStatement(sql.toString());
    ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Error en la  el metodo actualizarResultadoLlamada :" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

    }   
 
 
 public void actualizarResultadoLlamada1(String campana,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String recojo,String cobranza,String evento,String tipgestion,Integer id,Connection con ){

          PreparedStatement ps=null;

          
        try {
           
           
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
      // id=obtenerCodigo(campana);   
           //  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "Update [Ficha_Cliente].[dbo].[ResultadoLlamada]  SET [Hora] = '"+sqlTimestamp+"' , [contacto_cliente]='"+ noContactoCli +"', [razon_no_contacto]='"
            +razonNoContac+"' , [Realizo_venta]='"+ RealVenta+"',  [razon_no_venta]='"+NoVentaCerve+"', [recojo]='"+recojo+"',[cobranza]='"+cobranza+"',[evento]='"+evento+"',[Tipo_Gestion]= '" +tipgestion+"' , [contador]=[contador]+1   where  Idx='"+ id+"' ";
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
        
 ps = con.prepareStatement(sql.toString());
      ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Error en la  el metodo actualizarResultadoLlamada1 :" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
    }   
 
 public int contadorVentas(String xcampana,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
         // Campana="CAMP_"+Campana;
          int codigo =0;
        try {
     
          
        String sql = " SELECT SUM(RANKING) as Ventas FROM(  "+
  " select  ROW_NUMBER() OVER (PARTITION BY CodCliente ORDER BY FechaA DESC) AS RANKING, Campana  "+
  "FROM [Rascal].[dbo].[ResultadoLlamada]  "+
 "WHERE CONVERT(varchar, Hora, 103) = CONVERT(varchar, getdate(), 103) and Realizo_venta='Si'  "+
 " ) AS F  WHERE RANKING =1 and Campana='"+xcampana+"'";
           
           
           
          ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo contadorVentas :" + e.getMessage());
        }finally {
            try {
                  rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
        }   
        return  codigo ;
    }
 
 public int contadorAnotaciones(String Codcli,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
         // Campana="CAMP_"+Campana;
          int codigo =0;
        try {
     
   String  sql ="select contador from( "+
 " SELECT  contador , CodCliente,ROW_NUMBER() OVER (PARTITION BY CodCliente ORDER BY FechaA DESC) as RANKING  FROM [Ficha_Cliente].[dbo].[Anotacion] "+
" WHERE CONVERT(varchar, FechaA, 103) = CONVERT(varchar, getdate(), 103) and CodCliente= "+"'"+Codcli+"'"+") as FI "+
" WHERE RANKING = 1 ";
      
      
          ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo contadorAnotaciones :" + e.getMessage());
        }finally {
            try {
                  rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
        }   
        return  codigo ;
    }
 
 
 
 
 public void modificaResultadoLlamada(String id,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String NoVentaGaseosa,String NoventaAgua,String NoventaMalta,String Catventa, String tipgestion ){
   
   Connection cn = null;

        try {
            cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            Statement st = cn.createStatement();
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
           //  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "Update [Ficha_Cliente].[dbo].[ResultadoLlamada]  SET [Hora] = '"+sqlTimestamp+"' , [contacto_cliente]='"+ noContactoCli +"', [razon_no_contacto]='"
            +razonNoContac+"' , [Realizo_venta]='"+ RealVenta+"', [Descripcion_venta]='"+DescVenta+"', [No_venta_cerveza]='"+NoVentaCerve+"', [No_venta_gaseosa]='"
            +NoVentaGaseosa+ "', [No_venta_agua]='"+NoventaAgua+"', [No_venta_malta]='"+NoventaMalta+"', [Categoria_No_venta]='"  +Catventa+"', [Tipo_Gestion]='"  +tipgestion+"' ,[contador]=[contador]+1   where  Idx='"+ id+"' ";
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
          st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error en la  el metodo modificaResultadoLlamada :" + e.getMessage());

        }
    }   
 
 
 
  @Override 
 public void eliminaResultadoLlamada(String campana) {
     
      Connection cn = null;
   int id;
        try {
            cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            Statement st = cn.createStatement();
           
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
  Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
       id=obtenerCodigo(campana,cn_rascalLocal); 
       cn_rascalLocal.close();
           //  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "delete from [Ficha_Cliente].[dbo].[ResultadoLlamada] where Id= " +id ;
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
          st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error en la  el metodo eliminaResultadoLlamada :" + e.getMessage());

        } 
 }
 
 

     
     
 

  /*****nuevo *******/ 
  public int VerificarCodigo(String codigox,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
          
            
            
           String  sql = "Select count([CodCliente]) from [Ficha_Cliente].[dbo].[TelefonosCliente]  where [CodCliente] ='"+codigox+"'";
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (SQLException e) {
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
 public int ActualizarClienteTelefono(String campana, String codCliente,String nro1,String nro2 ,String nro3 ,String nro4,Connection con  ){
    ResultSet rs =null;
          PreparedStatement ps=null;

        int insert = 0;
        try {
         
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
             String sql = "UPDATE [Ficha_Cliente].[dbo].[TelefonosCliente]   SET  [Campana]='"+ campana+"',    [telefono1]='"+nro1 +"', [telefono2]='"+nro2 +"', [telefono3]='"+nro3 +"' , [telefono4]='"+nro4+"',[Hora]='"+sqlTimestamp+"'   WHERE  [CodCliente]='"+ codCliente+"'      ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
             ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo ActualizarClienteTelefono:" + e.getMessage());

        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    } 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public List<beanListaCuic> ObtenerTelefonoListaCuic(String numero,Connection con) {
       List<beanListaCuic> ListObtenerTelefonoLista = null;
        
        ResultSet rs =null;
          PreparedStatement ps=null;
       
        try {

            //con = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
            Statement st = con.createStatement();
            String sql = " EXEC	[rmc_awdb].[dbo].[LLAMADASSAC]"+
		" @NUMERO = N'"+numero+"' "  ;

            
            ///System.out.println("sql============> "+sql);
           
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            ListObtenerTelefonoLista= new ArrayList<beanListaCuic>();

            while (rs.next()) {
                beanListaCuic beanTelefonoClienteLista = new beanListaCuic();
               
                beanTelefonoClienteLista.setFecha_hora(rs.getString(2));
                beanTelefonoClienteLista.setFecha(rs.getString(3));
                beanTelefonoClienteLista.setAgente(rs.getString(4));
              beanTelefonoClienteLista.setCampana(rs.getString(5));
              beanTelefonoClienteLista.setTelefono(rs.getString(6));
              
              beanTelefonoClienteLista.setTiempo_check(rs.getString(7));
              beanTelefonoClienteLista.setDuracion_total(rs.getString(8));
                beanTelefonoClienteLista.setTimbrado(rs.getString(9));
                beanTelefonoClienteLista.setTiempo_espera(rs.getString(10));
                beanTelefonoClienteLista.setConversacion(rs.getString(11));
                ListObtenerTelefonoLista.add(beanTelefonoClienteLista);
            }

         

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerTelefonoListaCuic :" + e.getMessage());
            ListObtenerTelefonoLista = null;
        } finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerTelefonoLista ;
 }
 
 
 
 
 public List<beanListaCuic> ObtenerTelefonoListaCuicAQP(String numero,Connection con) {
       List<beanListaCuic> ListObtenerTelefonoLista = null;
        
        ResultSet rs =null;
          PreparedStatement ps=null;
       
        try {

            //con = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
            Statement st = con.createStatement();
            String sql = " EXEC	[Rascal].[dbo].[Numero_CUIC_AQP]"+
		" @numero = N'"+numero+"' "  ;

            
            ///System.out.println("sql============> "+sql);
           
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            ListObtenerTelefonoLista= new ArrayList<beanListaCuic>();

            while (rs.next()) {
                beanListaCuic beanTelefonoClienteLista = new beanListaCuic();

                beanTelefonoClienteLista.setFecha_hora(rs.getString(2));
                beanTelefonoClienteLista.setFecha(rs.getString(3));
                beanTelefonoClienteLista.setAgente(rs.getString(4));
                beanTelefonoClienteLista.setCampana(rs.getString(5));
                beanTelefonoClienteLista.setTelefono(rs.getString(6));

                beanTelefonoClienteLista.setTiempo_check(rs.getString(7));
                beanTelefonoClienteLista.setDuracion_total(rs.getString(8));
                beanTelefonoClienteLista.setTimbrado(rs.getString(9));
                beanTelefonoClienteLista.setTiempo_espera(rs.getString(10));
                beanTelefonoClienteLista.setConversacion(rs.getString(11));
                ListObtenerTelefonoLista.add(beanTelefonoClienteLista);
            }

         

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerTelefonoListaCuic :" + e.getMessage());
            ListObtenerTelefonoLista = null;
        } finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerTelefonoLista ;
 }
 
       
        public List<beanResultadoSAC> ObtenerResultadoSAC(String codcliente,Connection con) {
        List<beanResultadoSAC> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {

          String sql =      " EXEC	[Rascal].[dbo].[ResultadoLlamadaSac2]"+
		" @codcliente  = N'"+codcliente+"'";

         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanResultadoSAC>();

            while (rs.next()) {
                beanResultadoSAC obtenerDetalle = new beanResultadoSAC();
                obtenerDetalle.setFecha(rs.getString(2));
                  obtenerDetalle.setContacCliente(rs.getString(3));
                  obtenerDetalle.setRazonNoContacto(rs.getString(4));
                  obtenerDetalle.setRealizoVenta(rs.getString(5));
                  obtenerDetalle.setTipogestion(rs.getString(6));
                  obtenerDetalle.setRecojo(rs.getString(7));
                  obtenerDetalle.setCobranza(rs.getString(8));
                   obtenerDetalle.setEvento(rs.getString(9));
                   obtenerDetalle.setRazonNoVenta(rs.getString(10));
                   obtenerDetalle.setTipo(rs.getString(12));
                   obtenerDetalle.setCampana(rs.getString(13));
                   obtenerDetalle.setIppc(rs.getString(14));
                   obtenerDetalle.setManual(rs.getString(15));
                   obtenerDetalle.setNombre(rs.getString(16));
                   obtenerDetalle.setTeam(rs.getString(18));
                /// obtenerDetalle.set
                ListObtenerDetalle.add(obtenerDetalle);
            }

            if (ListObtenerDetalle.isEmpty()) {
                ListObtenerDetalle = null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerResultadoSAC :" + e.getMessage());
            ListObtenerDetalle = null;
        } finally {
            try {
               ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }

        return ListObtenerDetalle;
    }
       
      
  public List<beanResultadoSAC> ObtenerResultadoSAC_Historico(String codcliente,Connection con) {
        List<beanResultadoSAC> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {

          String sql =      " EXEC	[Ficha_Cliente].[dbo].[ResultadoLlamadaSac]"+
		" @Codcliente  = N'"+codcliente+"'";

         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanResultadoSAC>();

            while (rs.next()) {
                beanResultadoSAC obtenerDetalle = new beanResultadoSAC();
                obtenerDetalle.setFecha(rs.getString(2));
                  obtenerDetalle.setContacCliente(rs.getString(3));
                  obtenerDetalle.setRazonNoContacto(rs.getString(4));
                  obtenerDetalle.setRealizoVenta(rs.getString(5));
                  obtenerDetalle.setTipogestion(rs.getString(6));
                  obtenerDetalle.setRecojo(rs.getString(7));
                  obtenerDetalle.setCobranza(rs.getString(8));
                   obtenerDetalle.setEvento(rs.getString(9));
                   obtenerDetalle.setRazonNoVenta(rs.getString(10));
                   obtenerDetalle.setTipo(rs.getString(12));
                   obtenerDetalle.setCampana(rs.getString(13));
                   obtenerDetalle.setIppc(rs.getString(14));
                   obtenerDetalle.setManual(rs.getString(15));
                   obtenerDetalle.setNombre(rs.getString(16));
                   obtenerDetalle.setTeam(rs.getString(18));
                /// obtenerDetalle.set
                ListObtenerDetalle.add(obtenerDetalle);
            }

            if (ListObtenerDetalle.isEmpty()) {
                ListObtenerDetalle = null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerResultadoSAC_Historico :" + e.getMessage());
            ListObtenerDetalle = null;
        } finally {
            try {
               ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }

        return ListObtenerDetalle;
    }
       
       
       
       
       
     
   
    
    @Override
    public List<beanClienteTelefonoLocal> ObtenerTelefonoLocal(String codigocliente) {
       List<beanClienteTelefonoLocal> listObtenerTelefonoLocal=null ;
        Connection con = null;
        try {
           con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            Statement st = con.createStatement();
            String sql = "select  [CodCliente],[telefono1],[telefono2],[telefono3],[telefono4]    FROM [Ficha_Cliente].[dbo].[TelefonosCliente]  where [CodCliente] = '" + codigocliente + "'";
            ResultSet rs = st.executeQuery(sql);  
            listObtenerTelefonoLocal = new ArrayList<beanClienteTelefonoLocal>();
            
            while (rs.next()) {
              beanClienteTelefonoLocal    beanobtenerfonolocal = new beanClienteTelefonoLocal();
              
                 beanobtenerfonolocal.setCodCliente(rs.getString(1));
                beanobtenerfonolocal.setNumero1(rs.getString(2));
                beanobtenerfonolocal.setNumero2(rs.getString(3));
               beanobtenerfonolocal.setNumero3(rs.getString(4));
                beanobtenerfonolocal.setNumero4(rs.getString(5));
                listObtenerTelefonoLocal.add(beanobtenerfonolocal);
               
            }


        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerTelefonoLocal :" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return listObtenerTelefonoLocal;
    }

    @Override
 public List<beanTelefonoClienteLista> ObtenerTelefonoLista(String codcliente,Connection con) {
       List<beanTelefonoClienteLista> ListObtenerTelefonoLista = null;
        
        ResultSet rs =null;
          PreparedStatement ps=null;
       
        try {

            //con = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
            Statement st = con.createStatement();
            String sql = "select [AccountNumber]  , [Phone] ,[FirstName],[LastName] from (   SELECT [AccountNumber],[FirstName],[LastName], [Phone01] ,[Phone02],[Phone03],[Phone04],[Phone05],[Phone06],[Phone07],[Phone08],[Phone09],[Phone10]  FROM [Ficha_Cliente].[dbo].[Automatica] WHERE [AccountNumber]='"+codcliente+"' AND [Fecha]=(select max([Fecha])  from  [Ficha_Cliente].[dbo].[Automatica] where [AccountNumber]='"+codcliente+"')) p unpivot ([Phone] for telefono in ([Phone01],[Phone02],[Phone03],[Phone04],[Phone05],[Phone06],[Phone07],[Phone08],[Phone09],[Phone10])) as unpvt where  [AccountNumber] ='"+codcliente+"'";

            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            ListObtenerTelefonoLista= new ArrayList<beanTelefonoClienteLista>();

            while (rs.next()) {
                beanTelefonoClienteLista beanTelefonoClienteLista = new beanTelefonoClienteLista();
                beanTelefonoClienteLista.setCodCliente(rs.getString(1));
              beanTelefonoClienteLista.setNro(rs.getString(2));
              beanTelefonoClienteLista.setNombre(rs.getString(3));
              beanTelefonoClienteLista.setApellido(rs.getString(4));
                ListObtenerTelefonoLista.add(beanTelefonoClienteLista);
            }

         

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerDetalle :" + e.getMessage());
            ListObtenerTelefonoLista = null;
        } finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerTelefonoLista ;
 }
    
 

 
 
    public List<beanAgendaSAC> obtenerListaAgenda(String campana,Connection con) {
       List<beanAgendaSAC> ListObtenerAgenda = null;
        
        ResultSet rs =null;
          PreparedStatement ps=null;
       
        try {

            //con = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
            ////Statement st = con.createStatement();
            String sql = "  SELECT  \n" +
"      [tipo_Identificador]\n" +
"      ,[codigo_Identificador]\n" +
"      ,[telf_Fijo1]\n" +
"      ,[telf_Fijo2]\n" +
"      ,[celular1]\n" +
"      ,[celular2]\n" +
"      ,[fecha_Insertada]\n" +
"      ,[fecha_Agendado]  \n" +
" from  [Rascal].[dbo].[Agenda_SAC] where [campana]='"+campana+"' \n" +
" AND CONVERT(VARCHAR,replace([fecha_Agendado],'-','/'),103)=CONVERT (VARCHAR,GETDATE(),103 )";

                    
         ///ps = con.prepareStatement(sql);
              ps = con.prepareStatement(sql.toString());
         rs = ps.executeQuery();
      
            ListObtenerAgenda = new ArrayList<beanAgendaSAC>();
    ///System.out.println(sql);
            while (rs.next()) {
                beanAgendaSAC beanlistagenda = new beanAgendaSAC();
                beanlistagenda.setTipoIdentificador(rs.getString(1));
                beanlistagenda.setCodigoIdentificador(rs.getString(2));
                beanlistagenda.setTelf_Fijo1(rs.getString(3));
                beanlistagenda.setTelf_Fijo2(rs.getString(4));
                beanlistagenda.setCelular1(rs.getString(5));
                beanlistagenda.setCelular2(rs.getString(6));
                beanlistagenda.setFecha_insertada(rs.getString(7));
                beanlistagenda.setFecha_agendado(rs.getString(8));
            ListObtenerAgenda.add(beanlistagenda);
            }

         

        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerListaAgenda :" + e.getMessage());
           ListObtenerAgenda = null;
        } finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerAgenda ;
 } 
    
    public int ModificacionNro(int id,String nroantiguo,String modificado,String codcliente,Connection con){
       ResultSet rs =null;
          PreparedStatement ps=null;

        int insert = 0;
        try {
         
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
  String sql = "INSERT INTO MODIFICACIONNRO (Id,CodCliente,Nro,NroModificado,Hora)VALUES('"+ id+"','"+codcliente+"','"+nroantiguo+"','"+modificado+"', '"+sqlTimestamp+"') ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo ModificacionNro:" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
   
    
    
  public List CampoSacGestion (String codigox,Connection con) {
       List listCamposSac = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
          //double  valor=0.00;
          //int valor2=0;
        try {
           listCamposSac = new ArrayList(); 
String  sql = "SELECT Per_Handled*100 , CallsHandled\n" +
"FROM (\n" +
"   SELECT	\n" +
"   Per_Handled = CASE WHEN SUM(ISNULL(SGHH.CallsHandledToHalf, 0)) = 0 THEN 0\n" +
"		ELSE ISNULL(SUM(ISNULL(SGHH.CallsHandledToHalf, 0)) *1.0 / (SUM(ISNULL(SGHH.RouterCallsAbandQToHalf, 0)) + SUM(ISNULL(SGHH.AbandonRingCallsToHalf, 0)) + SUM(ISNULL(SGHH.RedirectNoAnsCallsToHalf, 0)) + SUM(ISNULL(SGHH.CallsHandledToHalf, 0))),0)\n" +
"		END,\n" +
" CallsHandled = SUM(ISNULL(SGHH.CallsHandledToHalf, 0))\n" +
"    FROM Skill_Group,   \n" +
"         Skill_Group_Half_Hour SGHH,   \n" +
"         Media_Routing_Domain  \n" +
"   WHERE ( Skill_Group.SkillTargetID = SGHH.SkillTargetID ) and  \n" +
"         ( Skill_Group.MRDomainID = Media_Routing_Domain.MRDomainID ) and  \n" +
"         ( ( Skill_Group.SkillTargetID in ( 5201 ) ) AND  \n" +
"     (    convert(varchar (20),DateTime,3)= convert(varchar (20),getdate(),3)   ))   ) R";
           
////System.out.println("sql=============================>"+sql);

           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
        
                listCamposSac.add(rs.getDouble(1))     ;
           listCamposSac.add(rs.getDouble(2))     ;
               }
        } catch (SQLException e) {
            System.out.println("CampoSacGestion :" + e.getMessage());
            listCamposSac =null;
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
          
        }

        return  listCamposSac ;
    }
    /*
   
    */
   public List CampoSacQLlamadas(String campana,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
         List valor= null;
        try {
          
              java.util.Date date = new java.util.Date(); 
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
String fecha = sdf.format(date);
            
           String  sql = "SELECT [PeripheralNumber]\n" +
"      ,[entrantes]\n" +
"      ,[salientes]\n" +
"  FROM [rmc_awdb].[dbo].[Vista_Entrante_Saliente_SAC]\n" +
"  where PeripheralNumber='"+campana+"'" ;
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
         valor =  new ArrayList();
            while(rs.next()){
          valor.add(rs.getString(2));
            valor.add(rs.getString(3));
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo CampoSacQLlamadas :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  valor ;
    }
  
  
  
    public List CampoSacTMOSAC(Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
         List valor= null;
        try {
          
              java.util.Date date = new java.util.Date(); 
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
String fecha = sdf.format(date);
            
            
           String  sql = " EXEC [rmc_awdb].[dbo].[TMOXGLOBAL]";
           
 
         //  System.out.println("sql========> "+sql);
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
       valor =  new ArrayList();
            while(rs.next()){
          valor.add(rs.getString(1));
           valor.add(rs.getString(2));
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo CampoSacTMO :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  valor ;
    }
    
    
    public List BusquedaDNIRUC(String parametro, String valor, Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
         List listasac= null;
        try {
          
              
            
            
           String  sql = "SELECT  \n" +
"       [Nombre]\n" +
"      ,[DNI]\n" +
"      ,[RUC]\n" +
"  FROM [Rascal].[dbo].[CLIENTE_SAC]\n" +
" WHERE "+parametro+   " = '"+valor+"'  \n";
           
 
     /// System.out.println("sql========> "+sql);
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
       listasac =  new ArrayList();
            while(rs.next()){
          listasac.add(rs.getString(1));
           listasac.add(rs.getString(2));
             listasac.add(rs.getString(3));
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo BusquedaDNIRUC :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  listasac ;
    }
    
  
    public List<beanResultadoGestionSAC> ListaResultadoGestionSAC(String codcliente,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
         List<beanResultadoGestionSAC> valor= null;
        try {
          
          
            
           String  sql = " EXEC [Rascal].[dbo].[ReporteResultadoSac_will]"+
                         "  @identificador = N'"+codcliente+"' ";
 
        //// System.out.println("sql========> "+sql);
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
       valor =  new ArrayList<beanResultadoGestionSAC>();
            while(rs.next()){
                
                beanResultadoGestionSAC lista= new beanResultadoGestionSAC();
     
                lista.setId(rs.getString(1));
                lista.setTipo_Identificador(rs.getString(2));
                lista.setIdentificador(rs.getString(3));
                lista.setTipo_Cliente(rs.getString(4));
                lista.setTipo_Llamada(rs.getString(5));
                lista.setResultado_Contacto(rs.getString(6));
                lista.setTipificacion_Llamada(rs.getString(7));
                lista.setFecha(rs.getString(8));
           valor.add(lista);
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo ListaResultadoGestionSAC :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  valor ;
    }
    
    
    public List CampoSacTMOXCamapana(String campana,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
         List valor= null;
        try {
          
              java.util.Date date = new java.util.Date(); 
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
String fecha = sdf.format(date);
            
            
           String  sql = " EXEC [rmc_awdb].[dbo].[TMOXCAMPANA]"+
                         "  @CAMPANA = N'"+campana+"' ";
 
         //  System.out.println("sql========> "+sql);
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
       valor =  new ArrayList();
            while(rs.next()){
          valor.add(rs.getString(2));
           valor.add(rs.getString(3));
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo CampoSacTMOXCamapana :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  valor ;
    }
    

  
     public int EliminarNro(int id,String nroeliminado,String codcliente,Connection con){
        ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
 String NroEliminado="Nro Sera Eliminado";
  
  String sql = "INSERT INTO EliminacionNro(Id,CodCliente,Nro,NroEliminado,Hora)VALUES('"+ id+"','"+codcliente+"','"+nroeliminado+"','"+NroEliminado+"', '"+sqlTimestamp+"') ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
      ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo EliminarNro:" + e.getMessage());

        }
finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
     
     public int EliminarNrox(String nro,String codcliente,Connection con){
      
          PreparedStatement ps=null;
        int insert = 0;
        try {
         
  String sql = "  DELETE  FROM  EliminacionNro where CodCliente= '"+codcliente+ "'   and Nro=   '"+nro+"'"  ;
            
       ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo EliminarNrox:" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }
    
     
     
     
     
    public String obtenerNroModificado(String nro,String codcliente,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
        String codigo = "";
        try {
            String sql = "select NROMODIFICADO FROM MODIFICACIONNRO where HORA= (SELECT MAX(HORA) FROM ModificacionNro where NRO='"+nro+"' and CODCLIENTE='"+codcliente+"') and NRO='"+nro+"'";
            ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerNroModificado :" + e.getMessage());
        }finally {
            try {
                rs.close();
                ps.close();
    
            } catch (SQLException e) {
            }
        }
        return codigo;
    }
    
  public String numeroRealTime (String nro,String codcliente,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          String codigo="";
        try {
          
            String sql = " select NroEliminado FROM EliminacionNro where Hora= (select MAX (Hora)  FROM EliminacionNro where Nro='"+nro+"' and CodCliente='"+codcliente+"')and Nro='"+nro+"'";
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();

            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerNroEliminado :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return codigo;
     
     
     }
  
  public String obtenerNroEliminado(String nro,String codcliente,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          String codigo="";
        try {
          
            String sql = " select NroEliminado FROM EliminacionNro where Hora= (select MAX (Hora)  FROM EliminacionNro where Nro='"+nro+"' and CodCliente='"+codcliente+"')and Nro='"+nro+"'";
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();

            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerNroEliminado :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return codigo;
     
     
     }
      public int InsertarNroNuevo(int id,String nro, String codcliente,Connection con){
        //Connection cn = null;
        int insert = 0;
        try {
            ///cn = oracleDaoLocalFactoryImpl.getSQLConextion();
            Statement st = con.createStatement();
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
 
  
  String sql = "INSERT INTO NROAGREGADO (Id,CodCliente,Nro,Hora)VALUES('"+id+"','"+codcliente+"', '"+nro+"'   ,  '"+sqlTimestamp+"') ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
            insert = st.executeUpdate(sql);
            con.commit();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo InsertarNroNuevo:" + e.getMessage());

        }
        return insert;
    }

       public List<beanTelefonoAgregados> ObtenerTelefonoAgregados(String codcliente,Connection con) {
       List<beanTelefonoAgregados> ListObtenerTelefonoAgregados = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {

           
            String sql = "SELECT  CodCliente,Nro FROM NROAGREGADO where CodCliente='"+ codcliente+"'";

             ps = con.prepareStatement(sql.toString());
             rs = ps.executeQuery();
             
            ListObtenerTelefonoAgregados= new ArrayList<beanTelefonoAgregados>();

            while (rs.next()) {
             beanTelefonoAgregados beanTelefonoAgregados = new beanTelefonoAgregados();
             beanTelefonoAgregados.setCodCliente(rs.getString(1));
             beanTelefonoAgregados.setNro(rs.getString(2));
             ListObtenerTelefonoAgregados.add(beanTelefonoAgregados);
            }

           

        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerTelefonoAgregados :" + e.getMessage());
            ListObtenerTelefonoAgregados = null;
        } finally {
            try {
                ps.close();
                rs.close();
               
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerTelefonoAgregados
             
             ;}
       
       
           public List<beanEntrega> obtieneEntrega(String xcodigo,Connection con) {
       List<beanEntrega> listObtenerentrega = null;
       ResultSet rs =null;
          PreparedStatement ps=null;
        try {
        
        String sql = "SELECT [DiaNatural] \n" +
"      ,[DescripMotivo]\n" +
"      ,[RutaSAP]\n" +
"      ,[Transportista]\n" +
"      ,[Vehiculo]\n" +
"      ,[CentroDistribucion]\n" +
" FROM [Rascal].[dbo].[Motivo_No_Reparto] where "
                       + "  CodSAP= " + "'"+xcodigo +  "'\n" +

"    order by substring([DiaNatural],4,2) desc ,substring([DiaNatural],1,2) desc  "  ; 
        
        
        
  
        
        
       ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        listObtenerentrega = new ArrayList<beanEntrega>();
        
                while (rs.next()) {
                 beanEntrega entrega = new beanEntrega();
                entrega.setFecha(rs.getString(1));
                entrega.setDescrMoti(rs.getString(2));
                entrega.setRutaSAP(rs.getString(3));
                entrega.setTransportista(rs.getString(4));
                entrega.setPlaca(rs.getString(5));
                entrega.setCD(rs.getString(6));
                listObtenerentrega.add(entrega);
            }
            
             
        } catch (Exception e) {
            System.out.println("Error en el metodo obtieneentrega :" +e.getMessage());
        
        }finally {
            try {
                 rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return listObtenerentrega;
    }
    public List<beanAlertaPFR> ListaPFR(String cd,Connection con) {
       List<beanAlertaPFR> listObtenerentrega = null;
       ResultSet rs =null;
          PreparedStatement ps=null;
        try {
        
        String sql = " EXEC	[Rascal].[dbo].[ALERTA_PFR_SAC] "+
		" @CD= N'"+cd+"'  " ; 
        
     System.out.println("E ListaPFR :" +sql);
  
        
        
       ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

        listObtenerentrega = new ArrayList<beanAlertaPFR>();
        
                while (rs.next()) {
                 beanAlertaPFR entrega = new beanAlertaPFR();
                 
                 entrega.setPFR(rs.getString(1));
                 entrega.setCaja(rs.getString(2));
                 entrega.setDESCENTRODIS(rs.getString(3));
                 entrega.setTOPE_FR(rs.getString(4));
                 entrega.setTOPE_CAJA(rs.getString(5));
                 entrega.setFALTA_PR(rs.getString(6));
                 entrega.setFALTA_CAJA(rs.getString(7));
//                entrega.setFecha(rs.getString(1));
//                entrega.setDescrMoti(rs.getString(2));
//                entrega.setRutaSAP(rs.getString(3));
//                entrega.setTransportista(rs.getString(4));
//                entrega.setPlaca(rs.getString(5));
//                entrega.setCD(rs.getString(6));
                listObtenerentrega.add(entrega);
            }
            
             
        } catch (Exception e) {
            System.out.println("Error en el metodo ListaPFR :" +e.getMessage());
        
        }finally {
            try {
                 rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return listObtenerentrega;
    }
       
    public List<beanInformacionAdicionalBO> ObtenerInformacionAdcional(String codcliente,Connection con) {
       List<beanInformacionAdicionalBO> ListObtenerTelefonoAgregados = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {

           
            String sql = "SELECT [CODIGO_CLIENTE],\n"
                    + "		[SIGUIENTE_LLAMADA],\n"
                    + "		[SIGUIENTE_VISITA],\n"
                    + "		IVS_AC,\n"
                    + "		IVS_AT\n"
                    + "		,[FEC_BASE_VENC_LIQUIDO]\n"
                    + "		,[MONTO_PROX_VENC_LIQUIDO]\n"
                    + "		,[FEC_BASE_VENC_ENVASES]\n"
                    + "		,[MONTO_PROX_VENC_ENVASES]\n"
                    + "		,[FEC_BASE_VENC_PERCEPCION]\n"
                    + "		,[MONTO_PROX_VENC_PERCEPCION]\n"
                    + "  FROM [PruebaCSV].[dbo].[PE_InformacionAdicional]\n"
                    + "  where '00'+[CODIGO_CLIENTE]='" + codcliente + "'";

             ps = con.prepareStatement(sql.toString());
             rs = ps.executeQuery();
             
            ListObtenerTelefonoAgregados= new ArrayList<beanInformacionAdicionalBO>();

            while (rs.next()) {
                beanInformacionAdicionalBO informacion = new beanInformacionAdicionalBO();
                informacion.setS_Llamada(rs.getString(2));
                
                informacion.setS_Visita(rs.getString(3));
                
                informacion.setIvs_AC(rs.getString(4));
                informacion.setIvs_AT(rs.getString(5));
                informacion.setFech_venc_Liquido(rs.getString(6));
                informacion.setMonto_venc_Liquido(rs.getString(7));
                informacion.setFech_venc_Envases(rs.getString(8));
                informacion.setMonto_venc_Envases(rs.getString(9));
                informacion.setFech_venc_Percepcion(rs.getString(10));
                informacion.setMonto_venc_Percepcion(rs.getString(11));
                
                ListObtenerTelefonoAgregados.add(informacion);
                
            }

           

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerInformacionAdcional :" + e.getMessage());
            ListObtenerTelefonoAgregados = null;
        } finally {
            try {
                ps.close();
                rs.close();
               
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerTelefonoAgregados
             
             ;}
		
     
  public List<beanCargaDistribucion> ObteneCargaDistribucion(String codcliente,Connection con) {
       List<beanCargaDistribucion> ListObtenerTelefonoAgregados = null;
          ResultSet rs =null;
          PreparedStatement ps=null;
        try {

           
            String sql = "SELECT \n" +
"      [Fecha_inicio]\n" +
"      ,[Fecha_fin]\n" +
"       ,[Secuencia]\n" +
"      ,[Concepto]\n" +
"      ,[Valor]\n" +
"  FROM [PruebaCSV].[dbo].[PE_InformacionFlexible]\n" +
"  where\n" +
"   '00'+[Codigo_cliente]='"+codcliente+"'";

             ps = con.prepareStatement(sql.toString());
             rs = ps.executeQuery();
             
            ListObtenerTelefonoAgregados= new ArrayList<beanCargaDistribucion>();

            while (rs.next()) {
                beanCargaDistribucion informacion = new beanCargaDistribucion();
               informacion.setFechaIni(rs.getString(1));
               informacion.setFechaFin(rs.getString(2)); 
               informacion.setSecuencia(rs.getString(3)); 
               informacion.setConcepto(rs.getString(4)); 
               informacion.setValor(rs.getString(5)); 
                ListObtenerTelefonoAgregados.add(informacion);
                
            }

           

        } catch (Exception e) {
            System.out.println("Error en el metodo ObteneCargaDistribucion :" + e.getMessage());
            ListObtenerTelefonoAgregados = null;
        } finally {
            try {
                ps.close();
                rs.close();
               
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerTelefonoAgregados
             
             ;}     
       
       
       
      
          public int VerificarNroDeCliente(String nro,String CodCliente,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;

          int codigo = 0;
        try {
         
            
            
           String  sql = "select  count(*) from\n" +
"(SELECT [AccountNumber],[FirstName],[LastName], [Phone01] ,[Phone02],[Phone03],[Phone04],[Phone05],[Phone06],[Phone07],[Phone08],[Phone09],[Phone10]\n" +
" \n" +
" \n" +
"FROM [Ficha_Cliente].[dbo].[Automatica]\n" +
" \n" +
" \n" +
" WHERE [AccountNumber]= '" +CodCliente+"'  AND [Fecha]=(select max([Fecha])\n" +
" \n" +
"  from  [Ficha_Cliente].[dbo].[Automatica]\n" +
"  \n" +
"  where [AccountNumber]= '" +CodCliente+"'  ))  as x\n" +
" \n" +
"  \n" +
"  where [Phone01]=  '" +nro+"'  or [Phone02] ='" +nro+"'  or [Phone03] =  '" +nro+"'  or [Phone04] = '" +nro+"'  or [Phone05] = '" +nro+"' or [Phone06] = '" +nro+"' or [Phone07] = '" +nro+"'  or [Phone08] = '" +nro+"' or [Phone09] = '" +nro+"' or [Phone10] ='" +nro+"' ";
            ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (SQLException e) {
            System.out.println("Error en el metodo VerificarNroDeCliente :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        
        return  codigo ;
    }
       public void eliminarNroAgregado(String codigo,String nro,Connection cn) {
  
   int id;
        try {
          
            Statement st = cn.createStatement();
           
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
         
          
    String sql = "DELETE FROM NROAGREGADO  WHERE CodCliente='"+codigo+"' and Nro='"+nro+"'";
        
          st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error en la  el metodo eliminarNroAgregado :" + e.getMessage());

        }
 }
      
     public int ModificacionNroAgregado( String codCliente,String nroa,String nron,Integer id,Connection con ){
   ResultSet rs =null;
          PreparedStatement ps=null;

        int insert = 0;
        try {
          
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
             String sql = "UPDATE NROAGREGADO set Nro='"+nron+"',Id='"+id+"' WHERE Nro='"+nroa+"' and CodCliente='"+codCliente+"'";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
          ps = con.prepareStatement(sql.toString());
     ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Error en la  el metodo ModificacionNroAgregado:" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }  
  public int VerificarNroDeClienteLocal(String nro,String CodCliente,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
           
            
           String  sql = "SELECT count(Nro)  FROM NroAgregado where Nro='"+nro +"' and CodCliente='"+CodCliente+"'";
          
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo VerificarNroDeClienteLocal :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        
        return  codigo ;
    }
  
   public int VerificarNroDeClienteModificados(String nro,String CodCliente,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
           
            
           String  sql = "SELECT count(Nro)  FROM ModificacionNro where [NroModificado]='"+nro +"' and [CodCliente]='"+CodCliente+"'";
           
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo VerificarNroDeClienteLocal :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  codigo ;
    }
    
   public int contadorSACcontacto(String nro,String gestion, String Identificador,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
           
            
           String  sql = "select   CONTADOR FROM [Rascal].[dbo].[ContadorXContacto] \n" +
"    where [Telefono]='"+nro+"'\n" +
"      and [Gestion]='"+gestion+"'\n" +
"      and [Identificador]='"+Identificador+"'";
           
         ////  System.out.println("CONTADOCONTACTO====>"+sql);
           
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo contadorSACcontacto :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  codigo ;
    }
   
   
    public int countSACcontacto(String nro,String gestion, String Identificador,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
           
            
           String  sql = "select   count(*) FROM [Rascal].[dbo].[ContadorXContacto] \n" +
"    where [Telefono]='"+nro+"'\n" +
"      and [Gestion]='"+gestion+"'\n" +
"      and [Identificador]='"+Identificador+"'";
           
           System.out.println("CONTADOCONTACTO====>"+sql);
           
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo countSACcontacto :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  codigo ;
    }
   
  public int contadorSACcliente(String gestion, String Identificador,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
           
            
           String  sql = "select   CONTADOR  FROM [Rascal].[dbo].[ContadorXCliente] \n" +
"    where  [Gestion]='"+gestion+"'\n" +
"      and [Identificador]='"+Identificador+"'";
         
 ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo contadorSACcliente :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        
        return  codigo ;
    } 
   
  public int ActualizarContacto(int id, String codcliente ,String contacto,String contactoa,Connection con){
        ResultSet rs =null;
          PreparedStatement ps=null;

        int insert = 0;
        try {
            
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
 
  
  String sql = "UPDATE [Ficha_Cliente].[dbo].[Parentesco] set Id='"+id+"' , [Contacto]='"+contacto+"' , [Hora]='"+sqlTimestamp +"' where [CodCliente]='"+codcliente+"' and [Contacto]='"+contactoa +"'";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           
 ps = con.prepareStatement(sql.toString());
      ps.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error en la  el metodo ActualizarContacto:" + e.getMessage());

        }
finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
  

  public int insertcontadorConactoSAC(String telefono, String  gestion,String identificador,int contador ,String campana ,Connection con){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            

  
  String sql = " INSERT INTO [Rascal].[dbo].[ContadorXContacto]\n" +
"           ([Telefono]\n" +
"           ,[Gestion]\n" +
"           ,[Identificador]"
          + ", [CONTADOR] "
          + " ,[campana] )\n" +
"     VALUES\n" +
"           ('"+telefono+"','"+gestion+"','"+identificador+"',"+contador+", '"+campana+"' )";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           
 ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo insertcontadorConactoSAC:" + e.getMessage());

        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }
                   
  
  public int UpdatecontadorConactoSAC(String telefono, String  gestion,String identificador,int contador ,Connection con){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            

  
  String sql = "Update [Rascal].[dbo].[ContadorXContacto]\n" +
"set CONTADOR=\n" +contador+
"where [Telefono]='"+telefono+"'\n" +
"    and [Gestion]='"+gestion+"'\n" +
"      and [Identificador]='"+identificador+"'";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           
 ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo UpdatecontadorConactoSAC:" + e.getMessage());

        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    } 
  public int UpdatecontadorClienteSAC(String  gestion,String identificador,int contador ,Connection con){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            

  
  String sql = "Update [Rascal].[dbo].[ContadorXCliente]\n" +
"set CONTADOR=\n" +contador+
"where [Gestion]='"+gestion+"'\n" +
"      and [Identificador]='"+identificador+"'";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           
 ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo UpdatecontadorClienteSAC:" + e.getMessage());

        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    } 
  
  
                    public int insertcontadorClienteSAC( String  gestion,String identificador,int contador ,Connection con){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            

  
  String sql = " INSERT INTO [Rascal].[dbo].[ContadorXCliente]\n" +
"           ([Gestion]\n" +
"           ,[Identificador]\n" +
"           ,[CONTADOR])\n" +
"     VALUES\n" +
"           ('"+gestion+"','"+identificador+"',"+contador+")";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           
 ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo insertcontadorClienteSAC:" + e.getMessage());

        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }
     public int EliminacionNroModificado( Integer id,String codcliente,String nromodificado,Connection con){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
 String valor= "  ";
  
  String sql = "INSERT INTO ModificacionNro(Id,CodCliente,Nro,NroModificado,Hora)VALUES('"+ id+"','"+codcliente+"','"+nromodificado+"','"+valor+ "', '"+sqlTimestamp+"') ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
           
 ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo EliminacionNroModificado:" + e.getMessage());

        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return insert;
    }
     
     
   
     
  
   
 public List ObtieneEfectiidad(String xcampana,String campa,Connection con){
      List listaEfectividad = null;
     ResultSet rs =null;
          PreparedStatement ps=null;
      
        try {
            
            listaEfectividad = new ArrayList();


                   
     String sql = " SELECT SUM(RANKING) as Ventas FROM(  "+
  " select  ROW_NUMBER() OVER (PARTITION BY CodCliente ORDER BY FechaA DESC) AS RANKING, Campana  "+
  "FROM [Ficha_Cliente].[dbo].[ResultadoLlamada]  "+
 "WHERE CONVERT(varchar, Hora, 103) = CONVERT(varchar, getdate(), 103) and Realizo_venta='Si'  "+
 " ) AS F  WHERE RANKING =1 and Campana='"+xcampana+"'";
                   
                   
                   
                   
          ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            //codigo = rs.getString(1);
           listaEfectividad.add(rs.getInt(1))     ;
            }
        } catch (SQLException e) {
            System.out.println("ObtieneEfectiidad :" + e.getMessage());
            listaEfectividad =null;
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
     
     return listaEfectividad;
     
 } 
 @Override
 public List obtieneContacto( String xcampana ,Connection con)
 {
  List listaContacto = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
      
        try {
         
            listaContacto = new ArrayList();
             String sql = "SELECT   ROUND(convert(Float ,(SUM(ISNULL(dbo.Campaign_Query_Rule_Real_Time.FutureUseInt1, 0)) + " +
"ISNULL(dbo.Campaign_Query_Rule_Real_Time.PersonalCallbackCount, 0))) / " +
"convert(float,sum(isnull(Campaign_Query_Rule_Real_Time.TotalCount,0))) *100,2) as [%Contacto]  " +
"FROM         dbo.Campaign_Query_Rule_Real_Time INNER JOIN   " +
"                      dbo.vw_campana ON dbo.Campaign_Query_Rule_Real_Time.CampaignID = dbo.vw_campana.CampaignID  " +
"                      where dbo.vw_campana.Campana= '"+xcampana+"'  "+
"GROUP BY dbo.Campaign_Query_Rule_Real_Time.TotalCount, dbo.Campaign_Query_Rule_Real_Time.FutureUseInt1,   " +
"                      dbo.Campaign_Query_Rule_Real_Time.PersonalCallbackCount, dbo.Campaign_Query_Rule_Real_Time.TotalCount,   " +
"                      dbo.Campaign_Query_Rule_Real_Time.FutureUseInt1, dbo.Campaign_Query_Rule_Real_Time.ClosedCount, dbo.Campaign_Query_Rule_Real_Time.ClosedCount,  " +
"                      dbo.Campaign_Query_Rule_Real_Time.PersonalCallbackCount, dbo.Campaign_Query_Rule_Real_Time.PersonalCallbackCount, dbo.vw_campana.Campana  " ;
             
             ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            while(rs.next()){
            //codigo = rs.getString(1);
           listaContacto.add(rs.getDouble(1))     ;
            }
        } catch (SQLException e) {
            System.out.println("obtieneContacto :" + e.getMessage());
            listaContacto =null;
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
     
     return listaContacto;
 
 }
 
 public String codigocliente(Integer id,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
          String codigo="";
        try {
          
            String sql = "Select [CodCliente] from [Rascal].[dbo].[Identificadoor] where Id = '"+id+"'";
            ps = con.prepareStatement(sql.toString());
             rs = ps.executeQuery();
            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo obtenerCodigo :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return codigo;
    }
 
 /*
 public int estadoContador(String campana, String anexo,String team,String estado ,String conta,Connection con ){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            
            java.util.Date utilDate = new java.util.Date();
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
             String sql = "INSERT INTO [Ficha_Cliente].[dbo].[DetalleHora_Estado] ([Campana],[Anexo],[Team],[Estado_CAD],[Hora],[Contador]) VALUES('"+campana+"','"+anexo+"','"+team+"','"+estado+"','"+sqlTimestamp +"','"+conta+"') ";
           
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
            ps = con.prepareStatement(sql.toString());
    ps.executeUpdate();
 
        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarestador:" + e.getMessage());
 
        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
 */
 
 
 public int insertarestador(String campana, String anexo,String team,String estado ,Connection con ){
       ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            
            java.util.Date utilDate = new java.util.Date();
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
             String sql = "INSERT INTO [Ficha_Cliente].[dbo].[DetalleHora_Estado] ([Campana],[Anexo],[Team],[Estado_CAD],[Hora]) VALUES('"+campana+"','"+anexo+"','"+team+"','"+estado+"','"+sqlTimestamp +"') ";
           
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
            ps = con.prepareStatement(sql.toString());
    ps.executeUpdate();
 
        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertarestador:" + e.getMessage());
 
        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
 
 public String estadocad(String campana,Connection con) {
      ResultSet rs =null;
          PreparedStatement ps=null;
          
          String codigo="";
        try {
            
            String sql = " Select [Estado_CAD] from [Ficha_Cliente].[dbo].[DetalleHora_Estado] where Id=(SELECT MAX(Id) from [Ficha_Cliente].[dbo].[DetalleHora_Estado] where Campana='"+campana+"')";
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();

            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo estadocad:" + e.getMessage());
        }
finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

        return codigo;
    }
 
 
 
 
 
 
 
  public String Horaestadonopreparado(String campana) {
        Connection cn = null;
        String codigo ="";
        try {
            cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            Statement st = cn.createStatement();
            String sql = " Select convert(varchar,[Hora],120 ) FROM [Ficha_Cliente].[dbo].[DetalleHora_Estado]where Id=(SELECT MAX(Id)FROM [Ficha_Cliente].[dbo].[DetalleHora_Estado]where Campana='"+campana+"' and [Estado_CAD]='No Preparado Manual')";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo estadocad:" + e.getMessage());
        }
        return codigo;
    }
  
  public String HoraInsert(String campana) {
        Connection cn = null;
        String codigo ="";
        try {
            cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            Statement st = cn.createStatement();
String sql = "select convert(varchar,[Hora],120 )  FROM [Ficha_Cliente].[dbo].[Identificadoor] where Id=(select max(Id) FROM [Ficha_Cliente].[dbo].[Identificadoor] where [Campana]='"+campana+"'"+")";
 
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            codigo = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo HoraInsert:" + e.getMessage());
        }
        return codigo;
    }
  
   public int ejecprocedurefechas( String CAMPANA){
     Connection cn = null;
     int codigo=0;
        try {
            cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            Statement st = cn.createStatement();
             String sql = "DECLARE	@return_value int EXEC	@return_value = [Ficha_Cliente].[dbo].[compararfechas]  @CAMPAÑA = "+CAMPANA+" SELECT	'Return Value' = @return_value";

            ResultSet rs = st.executeQuery(sql);

              while(rs.next()){
            codigo = rs.getInt(1);
              }

        } catch (Exception e) {
            System.out.println("Error en la  el metodo ejecutarpocedue:" + e.getMessage());

        }
      return codigo;
 }  
   
 public int insertclickttocall(int id,String campana,String contador,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
          
          
        int codigo=0 ;
        try {
           
            String sql = "INSERT INTO [Ficha_Cliente].[dbo].[clicktocall] "+
           "(   [Id] ,  "
        +  " [Descripcion_ventana]  "+
          " ,[contador])   "+
          " VALUES   "+
          "  ( " +  id   + " ,"
           + " 'consulta'"   +
          ","+contador+")";
            
         ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Error en el metodo clickttocall:" + e.getMessage());
        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }

     return codigo;
    }
  

   public int updateclickttocall(int id,String campana, String contador,Connection cn) {
       ResultSet rs =null;
          PreparedStatement ps=null;
        int codigo=0 ;
        ///int id=0;
        try {
          
            ///id=obtenerCodigo(campana,cn);  
            String sql = "UPDATE [Ficha_Cliente].[dbo].[clicktocall] "+
   "SET [Descripcion_ventana] = 'ventana' "+
    "  ,[contador] =  '"+ contador +"'" +
   " WHERE [Id]="+id;
       
 ps = cn.prepareStatement(sql.toString());
      ps.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Error en el metodo clickttocall:" + e.getMessage());
        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
     return codigo;
    }
   
   public int obtieneContador(String campana,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
        int codigo =0;
       int id=0;
        try {
            Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
             id=obtenerCodigoSAC(campana,cn_rascalLocal); 
             cn_rascalLocal.close();
            String sql = "SELECT \n" +
"      [contador]\n" +
"  FROM [Ficha_Cliente].[dbo].[clicktocall] "+
  "where Id= "+  id;
           ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery(); 
            while(rs.next()){
            codigo = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtieneContador :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }


        return codigo;
    } 
    
public List ListaNumeroContador (String xcodigo,String xnumero,Connection con ){
    List listaContador = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
        try {
            
       listaContador = new ArrayList();
      /* String sql = "Select Telefono, count(Telefono) as Q from  \n" +
"  [GMD_RASCAL].dbo.Tabla_GMD_BD_Llamadas_Final_2  \n" +
"  Where ([Fecha y Hora]) between (getdate()-90) and ( getdate())  \n" +
"   and ACDTime > 19 "+
 " and Telefono='"+xnumero.trim()+"' " +                                      
"  Group by Telefono ";*/

   String sql =    " SELECT [Q] "+
 " FROM [Rascal].[dbo].[Tabla_Contador_Telefono] "+
 "  where Telefono='"+xnumero.trim()+"' " ;       
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
            while(rs.next()){
            //codigo = rs.getString(1);
           listaContador.add(rs.getString(1))     ;
            }
        } catch (Exception e) {
            System.out.println("ListaNumeroContador :" + e.getMessage());
            listaContador =null;
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

     
     return listaContador;
      
    
}

  public List tipogestion(Connection con) {
        
        List  tipoGestion = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
            String sql ="SELECT [TipodeGestion] FROM [Ficha_Cliente].[dbo].[TipoGestion2] order by [TipodeGestion]";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        tipoGestion =  new ArrayList();
        
                while (rs.next()) {
               

               
              tipoGestion.add(rs.getString(1));
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo tipogestion:" +e.getMessage());
          tipoGestion = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return tipoGestion;
    }
 public List RazonesNoVenta(Connection con) {
        
        List  RazonesNoVenta = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT [Motivo_No_Venta] FROM [Ficha_Cliente].[dbo].[MotivoNoVentac] order by [Motivo_No_Venta]";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        RazonesNoVenta =  new ArrayList();
        
                while (rs.next()) {
               

               
              RazonesNoVenta.add(rs.getString(1));
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo RazonesNoVenta:" +e.getMessage());
          RazonesNoVenta = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return RazonesNoVenta;
    }



public List RazonesNoContacto(Connection con) {
        
        List RazonesNoContacto = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT [Motivo_No_Contacto] FROM [Ficha_Cliente].[dbo].[MotivoNoContactoc]  order by [Motivo_No_Contacto] ";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
        RazonesNoContacto =  new ArrayList();
        
                while (rs.next()) {
               

               
                RazonesNoContacto.add(rs.getString(1));
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo RazonesNoContacto:" +e.getMessage());
           RazonesNoContacto = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return RazonesNoContacto;
    }

public  int validnumerparente(String codcli, String nro ,Connection con) {
        
     int resul =0;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT count(*)\n" +
"  FROM PARENTESCO \n" +
"  where CODCLIENTE='"+codcli+"'   AND NRO='"+nro+"'";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                resul=rs.getInt(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo validnumerparente:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return resul;
    }


       public int contadordetallado(String campana,Connection con) {
       ResultSet rs =null;
          PreparedStatement ps=null;
          int codigo = 0;
        try {
           
            
           String  sql = "SELECT count(*)  FROM [Ficha_Cliente].[dbo].[Automatica] where [IDTelevendedor]='"+campana+ "'";
             ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

            while(rs.next()){
            codigo = rs.getInt(1);
               }
        } catch (Exception e) {
            System.out.println("Error en el metodo contadordetallado :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        
        return  codigo ;
    }
     

public List<beanDetalladoClienteSAC> ObtenerDetallefiltro(String CampanaSession, Connection con,String where) {
List<beanDetalladoClienteSAC> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {

       //     String sql = "EXEC  [rmc_baA].[dbo].[cb_web_campaign_det_avaliable_prueba_tipogestion_JTFINAL]  " + CampanaSession +"," + where;
 if(where =="" ){
    where="[CodCliente] like ''%%''  ";
 }
            
      String sql =      " EXEC	[Rascal].[dbo].[DetalladoSacFinal] "+
		" @campana= N'"+CampanaSession+"',  "+
		" @where = N'"+where+"' ";
            
      System.out.println("sql====>"+sql);
      
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanDetalladoClienteSAC>();

            while (rs.next()) {
                beanDetalladoClienteSAC obtenerDetalle = new beanDetalladoClienteSAC();
               
               
                obtenerDetalle.setNumero(rs.getString(1));
                obtenerDetalle.setFecha(rs.getString(2));
                obtenerDetalle.setTipo(rs.getString(3));
                obtenerDetalle.setTipo_Identificador(rs.getString(4));
                obtenerDetalle.setTipo_Cliente(rs.getString(5));
                obtenerDetalle.setCodcliente(rs.getString(6));
                obtenerDetalle.setTipo_Llamada(rs.getString(7));
                obtenerDetalle.setResultado_Contacto(rs.getString(8));
                obtenerDetalle.setTipificacion_Llamada(rs.getString(9));
                obtenerDetalle.setCONTADORCliente( rs.getString(10) );
                 obtenerDetalle.setCONTADORContacto( rs.getString(11) );
                 
                ListObtenerDetalle.add(obtenerDetalle);
            }

            if (ListObtenerDetalle.isEmpty()) {
                ListObtenerDetalle = null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo ObtenerDetalle :" + e.getMessage());
            ListObtenerDetalle = null;
        } finally {
            try {
               ps.close();
                rs.close();
            } catch (SQLException e) {
            }
        }

        return ListObtenerDetalle;
    }
          
 
    
public  int  selectventaruta(String codcli, String campana,Connection con) {
        
     int  resul =0;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT   [CONTADOR]\n" +

"  FROM [Rascal].[dbo].[VentasXCampanaXRUTA] "
                + "where   [AccountNumber]= '"+codcli+"'  ";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                resul=rs.getInt(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo selectventaruta:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return resul;
    }
    
public  int  SelectClienteAOP(String codcli, Connection con) {
        
     int  resul =0;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT COUNT(*)\n" +
"  FROM [Rascal].[dbo].[Tabla_Cliente_AOP]\n" +
"  where [Cod_Cliente]='"+codcli+"'  " ;
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                resul=rs.getInt(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo SelectClienteAOP:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return resul;
    }
 public void actualizarResultadoLlamada1(String campana,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String recojo,String cobranza,String evento,String tipgestion,Integer id,String codcli,Connection con ){

          PreparedStatement ps=null;

          /// idx=0;
        try {
           
           
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
    ////Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
      
  if (id.equals(1)){
       id=obtenerCodigoVenta(campana,codcli,con);   
  }
      // id=obtenerCodigo(campana);   
           //  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "Update [Rascal].[dbo].[ResultadoLlamada]  SET [Hora] = '"+sqlTimestamp+"' , [contacto_cliente]='"+ noContactoCli +"', [razon_no_contacto]='"
            +razonNoContac+"' , [Realizo_venta]='"+ RealVenta+"',  [razon_no_venta]='"+NoVentaCerve+"', [recojo]='"+recojo+"',[cobranza]='"+cobranza+"',[evento]='"+evento+"',[Tipo_Gestion]= '" +tipgestion+"' , [contador]=[contador]+1   where  Idx='"+ id+"' ";
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
        
 ps = con.prepareStatement(sql.toString());
      ps.executeUpdate();

    

        } catch (SQLException e) {
            System.out.println("Error en la  el metodo actualizarResultadoLlamada1 :" + e.getMessage());

        }finally {
            try {
              
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
    }   


 public int obtenerCodigoVenta(String campana,String codcli,Connection con) {
        ResultSet rs =null;
          PreparedStatement ps=null;
        int codigo = 0;
        try {
           
            String sql = "select max(Idx)\n" +
"   FROM [Rascal].[dbo].[ResultadoLlamada]    \n" +
"  WHERE   Campana='"+campana+"' and codCliente='"+codcli+"' and contacto_cliente='si'";
            ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();

      System.out.println("obtenerCodigoVenta ===> "+sql);
      
            while(rs.next()){
            codigo = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo obtenerCodigoVenta :" + e.getMessage());
        }finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return codigo;
    }


public int updateContacto(String campana, String codcli,int contador,String valor,Connection cn) {
       ResultSet rs =null;
          PreparedStatement ps=null;
        int id=0 ;
        ///int id=0;
        try {
          if(valor.equals("1") ){
            id=obtenerCodigo(campana,cn);   
          }else if (valor.equals("2") ){
               id=obtenerCodigoVenta(campana,codcli,cn);   
          }else{
              id= Integer.parseInt(campana);
          }
            System.out.println("System ==>"+campana+"id max===>"+id);
            String sql = "UPDATE [Rascal].[dbo].[EfectividadXContacto] "+
   "SET [CONTADOR] =  "+contador +
    " ,   [Id]= "+ id+ 
    " where    [AccountNumber]= '"+codcli+"'  ";
       
 ps = cn.prepareStatement(sql.toString());
      ps.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Error en el metodo updateContacto:" + e.getMessage());
        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
     return id;
    }
public int updateVentanaruta(String campana, String codcli,int contador,String valor,Connection cn) {
       ResultSet rs =null;
          PreparedStatement ps=null;
        int id=0 ;
        ///int id=0;
        try {
          if(valor.equals("1")){

            id=obtenerCodigo(campana,cn);  
          }else if (valor.equals("2") ){
               id=obtenerCodigoVenta(campana,codcli,cn);   
          }else{
              id= Integer.parseInt(campana);
          }
            String sql = "UPDATE [Rascal].[dbo].[VentasXCampanaXRUTA] "+
   "SET [CONTADOR] =  "+contador +
   " , [Id]="+id+ 
    " where    [AccountNumber]= '"+codcli+"'  ";
       
 ps = cn.prepareStatement(sql.toString());
      ps.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Error en el metodo updateVentanaruta:" + e.getMessage());
        }finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
     return id;
    }

public String  NumeroGestionSac ( int id, Connection con ){
   // List listaContador = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
          String codigo="";
        try {
            
      // listaContador = new ArrayList();

   String sql =    " SELECT \n" +
"      [numero]\n" +
"  FROM [Rascal].[dbo].[Identificadoor_SAC]\n" +
"  where Id_Gestion="+id;
           
    
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
 
      while(rs.next()){
            codigo = rs.getString(1);
           //listaContador.add(rs.getString(1))     ;
            }
 
        } catch (Exception e) {
            System.out.println("NumeroGestionSac :" + e.getMessage());
          ///  listaContador =null;
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

     
     return codigo;
      
    
}

 public String  ListIdCamap (String campa, int option , Connection con ){
   // List listaContador = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
          String codigo="";
        try {
            
      // listaContador = new ArrayList();

   String sql =    " SELECT  [CampaignID]\n" +
"      ,[QueryRuleID]\n" +
"  FROM [Rascal].[dbo].[campaignxqueryrule] "
           + " where [Campana]='"+campa+"'";
           
    
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
 if(option==1)   {  
            while(rs.next()){
            codigo = rs.getString(1);
           //listaContador.add(rs.getString(1))     ;
            }
 }else{
      while(rs.next()){
            codigo = rs.getString(2);
           //listaContador.add(rs.getString(1))     ;
            }
 }
        } catch (Exception e) {
            System.out.println("ListaNumeroContador :" + e.getMessage());
          ///  listaContador =null;
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

     
     return codigo;
      
    
}
  public String selectCodNulo( String campaid,String queryId ,Connection con ){
       
      ResultSet rs =null;
          PreparedStatement ps=null;
       String cod="";
        try {
     
          
    
        //id = obtenerCodigo(Campana);
        String sql = "EXEC [rmc_baA].[dbo].[Clientenull]'"+campaid+"' , '"+queryId+"' ";
System.out.println("Elselct "+sql);
          
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
     con.commit();
        //ListproceCodNulo = new ArrayList();
       ///  if (opcion==1){
                while (rs.next()) {
             
            cod=rs.getString(1);
           // }
       ///  }else{
            
            } 
      //   }
        } catch (Exception e) {
            System.out.println("Error en el metodo procedureCodNulo :" +e.getMessage());
          // ListproceCodNulo = null; 
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return cod;
  } 
    @Override
    public int insertarVentanaHoraria(String campana, String codCliente, String rango, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 public void execProcedureTel( String campana ,String codcli,Connection con){
    // Connection cn = null;
     int codigo=0;
       PreparedStatement ps=null;
        try {
          ///  cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            //Statement st = con.createStatement();
             String sql = " exec [Rascal].[dbo].[Telefono_Real_Time_SAC]  '"+campana+"','"+codcli+"'";
            //// System.out.println("sql de procedure=======================>" +sql);
  ps = con.prepareStatement(sql.toString());
         ps.executeUpdate();

             
        } catch (Exception e) {
            System.out.println("Error en la  el metodo ejecutarpocedue:" + e.getMessage());

        }
      
 }  
  



public List  IntentosxClienteSAC ( String gestion,String identificador, Connection con ){
   List listIntentos = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
          //String intentos="";
        try {
            
      listIntentos = new ArrayList();

   String sql =    " SELECT \n" +
"     [Gestion]\n" +
"      ,[Identificador]\n" +
"      ,[CONTADOR]\n" +
"  FROM [Rascal].[dbo].[ContadorXCliente]\n" +
"  where [Gestion]='"+gestion+"' and [Identificador]= '"+identificador+"' "   ;
           
          /////  System.out.println(sql);
 //////  " '"+var+"' "
    
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
 
      while(rs.next()){
            //intentos = rs.getString(1);
           listIntentos.add(rs.getString(2))     ;
           listIntentos.add(rs.getString(3))     ;
            }
 
        } catch (Exception e) {
            System.out.println("IntentosxNumeroSAC :" + e.getMessage());
            listIntentos =null;
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

     
     return listIntentos;
      
    
}


public Double telefonocontacto ( String campana, Connection con ){
   Double listIntentos = 0.00;
      ResultSet rs =null;
          PreparedStatement ps=null;
          //String intentos="";
        try {
            
     // listIntentos = new ArrayList();

   String sql =    "SELECT \n" +
"      COUNT([numero])AS CONTA\n" +
"  FROM [Rascal].[dbo].[detallado_sac1]\n" +
"  where  [Tipo]='Entrante' and [Campana]='"+campana+"'   "   ;
           
            ////System.out.println(sql);
 //////  " '"+var+"' "
    
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
 
      while(rs.next()){
            //intentos = rs.getString(1);
          // listIntentos.add(rs.getString(2))     ;
           //listIntentos.add(rs.getString(3))     ;
          listIntentos=rs.getDouble(1);
            }
 
        } catch (Exception e) {
            System.out.println("telefonocontacto :" + e.getMessage());
           /// listIntentos =null;
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

     
     return listIntentos;
      
    
}



   
}
