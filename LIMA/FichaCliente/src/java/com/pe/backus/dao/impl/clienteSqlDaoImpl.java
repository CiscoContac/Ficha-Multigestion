/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.dao.impl;

import com.pe.backus.dao.clienteSqlDAO;
import com.pe.backus.dto.beanAnotacion;
import com.pe.backus.dto.beanClienteTelefono;
import com.pe.backus.dto.beanClienteTelefonoLocal;
import com.pe.backus.dto.beanDetalladoCliente;
import com.pe.backus.dto.beanInformacionCliente;
import com.pe.backus.dto.beanListaClickTocall;

import com.pe.backus.dto.beanResuLLamada;
import com.pe.backus.dto.beanResumenCamp;
import com.pe.backus.dto.beanSeguimientoCampana;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        
 String sql = "   select  Idx,CONVERT(VARCHAR,Hora , 103) + ' '+CONVERT(VARCHAR,Hora , 8)   as fecha,Descripcion   \n" +
"   from [Rascal].[dbo].[Anotacion]   \n" +
"     where     \n" +
"      CodCliente ='"+xcodigo+"'  \n" +
" and contador >= 1\n" +
"    order by   Hora desc  ";
        
        
        
        
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
    

     public List<beanAnotacion> ObtenerFechaHistori(String xcodigo,Connection con) {
         List<beanAnotacion> listObtenerFecha = null;
         ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
      //  Statement st = con.createStatement();
        //int id=obtenerCodigo(campana);
        
 String sql = "   select  Idx,CONVERT(VARCHAR,Hora , 103) + ' '+CONVERT(VARCHAR,Hora , 8)   as fecha,Descripcion   \n" +
"   from [Ficha_Cliente].[dbo].[Anotacion]   \n" +
"     where     \n" +
"      CodCliente ='"+xcodigo+"'  \n" +
" and contador >= 1\n" +
"    order by   Hora desc  ";
        
        
        
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
            
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
   Connection   cn_rascalLocal= sqlDaoRascalFactoryImpl.getSQLConextionRascal();
       id=obtenerCodigo(campana,cn_rascalLocal);   
       conta= cont +1 ;
       System.out.println("imprimirr actuaconta:"+ conta);
       if(Anotacion.equals("")){}else{
//  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "Update [Rascal].[dbo].[Anotacion]  SET [Hora] = '"+sqlTimestamp+"', contador= "+conta+"  , [Descripcion] = '" + Anotacion+ "' where  Idx='"+ id+"' ";
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
      
  String sql = "Update [Rascal].[dbo].[Anotacion]  SET   [Descripcion] = '" + Anotacion+ "', [contador] = "+conta+" where  Idx='"+ id+"' ";
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

    
  
    
    
    public List<beanDetalladoCliente> ObtenerDetalle(String campana,Connection con) {
        List<beanDetalladoCliente> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {

          String sql =      " EXEC	[rmc_baA].[dbo].[cb_web_campaign_det_avaliable_prueba_tipogestion_JTFINAL2_ORDENAMIENTO] "+
		" @campaignName = N'"+campana+"',  "+
		" @where = N'AccountNumber like ''%%''' ";
          
    
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanDetalladoCliente>();

            while (rs.next()) {
                 beanDetalladoCliente obtenerDetalle = new beanDetalladoCliente();
                obtenerDetalle.setCodCliente(rs.getString(1));
                obtenerDetalle.setApellido(rs.getString(2));
                //obtenerDetalle.setNombre(rs.getString(3));
                obtenerDetalle.setNumero1(rs.getString(4));
                obtenerDetalle.setNumero2(rs.getString(5));
                obtenerDetalle.setNumero3(rs.getString(6));
                obtenerDetalle.setExtension(rs.getString(7));
                obtenerDetalle.setEstado(rs.getString(8));
                obtenerDetalle.setCallResult1(rs.getString(10));
                obtenerDetalle.setCallResult2(rs.getString(11));
                obtenerDetalle.setCallResult3(rs.getString(12));
                obtenerDetalle.setIntentos(rs.getString(13));
                obtenerDetalle.setCallback1(rs.getString(14));
                obtenerDetalle.setCallback2(rs.getString(15));
                obtenerDetalle.setCallback3(rs.getString(16));
                obtenerDetalle.setNrocallback(rs.getString(17));
                obtenerDetalle.setTipo_gestion(rs.getString(18));
                obtenerDetalle.setCodzonaventa(rs.getString(19));
                obtenerDetalle.setAnotacion(rs.getString(20));
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

    public List<beanDetalladoCliente> ObtenerDetalleNUEVO(String campana,Connection con) {
        List<beanDetalladoCliente> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {

          String sql =      " EXEC	[Rascal].[dbo].[DETALLE_FICHA_NUEVO] "+
		" @CAMPANA = N'"+campana+"'  ";

          
    
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanDetalladoCliente>();

            while (rs.next()) {
                 beanDetalladoCliente obtenerDetalle = new beanDetalladoCliente();
                obtenerDetalle.setCodCliente(rs.getString(1));
                obtenerDetalle.setApellido(rs.getString(2));
                //obtenerDetalle.setNombre(rs.getString(3));
                obtenerDetalle.setNumero1(rs.getString(7));
                obtenerDetalle.setNumero2(rs.getString(10));
                obtenerDetalle.setNumero3(rs.getString(13));
                obtenerDetalle.setExtension(rs.getString(18));
                obtenerDetalle.setEstado(rs.getString(3));
                obtenerDetalle.setCallResult1(rs.getString(11));
                obtenerDetalle.setCallResult2(rs.getString(14));
                obtenerDetalle.setCallResult3(rs.getString(17));
                obtenerDetalle.setIntentos(rs.getString(16));
                obtenerDetalle.setCallback1(rs.getString(12));
                obtenerDetalle.setCallback2(rs.getString(15));
                obtenerDetalle.setCallback3(rs.getString(18));
                obtenerDetalle.setNrocallback(rs.getString(17));
                obtenerDetalle.setTipo_gestion(rs.getString(5));
                obtenerDetalle.setCodzonaventa(rs.getString(4));
                obtenerDetalle.setAnotacion(rs.getString(6));
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
     String sql="";
     

  
              sql = "INSERT INTO [Rascal].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora],[Tipo]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"','"+automatic+"')";
     
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
       public int insertarClienteManual(int id,String Nro,Connection con) {
      /*  Connection cn = null;*/
           ResultSet rs =null;
          PreparedStatement ps=null;

        int insert = 0;
        try {

             java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
       // int id = obtenerCodigo(campana, con);    
            
             String sql = " INSERT INTO [Ficha_Cliente].[dbo].[Manual]([Idx],[Nro],[HoraClick])VALUES('"+id+"','"+Nro+"','') ";
            
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

             String sql = "Update [Ficha_Cliente].[dbo].[Manual]  SET [Nro] = '"+Nro+"' , [HoraClick]='"+ sqlTimestamp +"'  where  Idx='"+ Id+"'      ";
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
    
 
    
@Override
  public List<beanResuLLamada> obtenerResultadoLlamada( String xcodigo,Connection con ){
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
"        , Tipo_Gestion  "
              + " ,lado                 \n" +
"    \n" +
"           ,CodCliente     \n" +
"  FROM [Rascal].[dbo].[ResultadoLlamada]\n" +
"\n" +
"  where [CodCliente]='"+xcodigo+"'\n" +
"  and contador >='1' \n" +
"    order by [FechaA] desc ";

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
                beanresullamada.setEnvase(rs.getString(11));
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
"         , lado           \n" +
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
                beanresullamada.setEnvase(rs.getString(11));
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
 public void actualizarResultadoLlamada(String campana,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String recojo,String cobranza,String evento,String tipgestion ,String txtenvase,Connection con){
   ResultSet rs =null;
          PreparedStatement ps=null;

  
   int id;
        try {
           
           
         java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
   
       id=obtenerCodigo(campana,con);   
    
               
           //  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "Update [Rascal].[dbo].[ResultadoLlamada]  SET [Hora] = '"+sqlTimestamp+"' , [contacto_cliente]='"+ noContactoCli +"', [razon_no_contacto]='"
            +razonNoContac+"' , [Realizo_venta]='"+ RealVenta+"', [razon_no_venta]='"+NoVentaCerve+"', [recojo]='"+recojo+"',[cobranza]='"+cobranza+"',[evento]='"+evento+"',[Tipo_Gestion]= '" +tipgestion+"'  ,"
            + "[lado]= '"+txtenvase+"',[contador]=[contador]+1   where  Idx='"+ id+"' ";
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
 
 
 public void actualizarResultadoLlamada1(String campana,String noContactoCli,String razonNoContac,String RealVenta,String DescVenta,String NoVentaCerve, String recojo,String cobranza,String evento,String tipgestion,Integer id,String codcli,String txtenvase,Connection con ){

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
            +razonNoContac+"' , [Realizo_venta]='"+ RealVenta+"',  [razon_no_venta]='"+NoVentaCerve+"', [recojo]='"+recojo+"',[cobranza]='"+cobranza+"',[evento]='"+evento+"',[Tipo_Gestion]= '" +tipgestion+"' , "
            + " [lado]= '"+txtenvase+"',[contador]=[contador]+1   where  Idx='"+ id+"' ";
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
     
          
    String sql =   "    select contador from(     \n" +
"      SELECT  contador , CodCliente,ROW_NUMBER() OVER (PARTITION BY CodCliente ORDER BY FechaA DESC) as RANKING  FROM [Rascal].[dbo].[ResultadoLlamada]     \n" +
"     WHERE  CodCliente='"+xcampana+"') as FI     \n" +
"     WHERE RANKING=1 ";
                
           
           
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
 " SELECT  contador , CodCliente,ROW_NUMBER() OVER (PARTITION BY CodCliente ORDER BY FechaA DESC) as RANKING  FROM [Rascal].[dbo].[Anotacion] "+
" WHERE CodCliente= "+"'"+Codcli+"'"+") as FI "+
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
    String sql = "Update [Rascal].[dbo].[ResultadoLlamada]  SET [Hora] = '"+sqlTimestamp+"' , [contacto_cliente]='"+ noContactoCli +"', [razon_no_contacto]='"
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
    
    
    
 
  public List<beanDetalladoCliente> RecordarAgendamiento(String campana,Connection con) {
       List<beanDetalladoCliente> ListObtenerTelefonoLista = null;
        
        ResultSet rs =null;
          PreparedStatement ps=null;
       
        try {

            //con = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
            Statement st = con.createStatement();
            String sql = "SELECT  [Campana]\n" +
"      ,[CodCliente]\n" +
"      ,[Hora]\n" +
"      ,[Resultado]\n" +
"  FROM [Rascal].[dbo].[AGENDAMIENTO_FICHA]"
                    + "where Campana = '"+campana+"' ";
System.out.println("RAMIREZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ===================>"+sql);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            ListObtenerTelefonoLista= new ArrayList<beanDetalladoCliente>();

            while (rs.next()) {
                
                
                beanDetalladoCliente beanTelefonoClienteLista = new beanDetalladoCliente();
                beanTelefonoClienteLista.setCodCliente(rs.getString(2));
                beanTelefonoClienteLista.setCallback1(rs.getString(3));
                beanTelefonoClienteLista.setTipo_gestion(rs.getString(4));
//                beanTelefonoClienteLista.setCodCliente(rs.getString(1));
//              beanTelefonoClienteLista.setNro(rs.getString(2));
//              beanTelefonoClienteLista.setNombre(rs.getString(3));
//              beanTelefonoClienteLista.setApellido(rs.getString(4));
                ListObtenerTelefonoLista.add(beanTelefonoClienteLista);
                
            }

         

        } catch (Exception e) {
            System.out.println("Error en el metodo RecordarAgendamiento :" + e.getMessage());
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
 
 
 public String  AGENDAMIENTOVALIDAR(String codcliente,Connection con) {
      String ListObtenerTelefonoLista = "";
        
        ResultSet rs =null;
          PreparedStatement ps=null;
       
        try {
Calendar calendario = new GregorianCalendar();
int hora;

hora =calendario.get(Calendar.HOUR_OF_DAY);
  System.out.println("HORAAA METODODODODO========>"+hora);
            //con = sqlDaoRascalFactoryImpl.getSQLConextionRascal();
            Statement st = con.createStatement();
            String sql = "SELECT  [Hora] \n" +
"  FROM [Rascal].[dbo].[AgendamientoxHoraCampa]"
                    + "where [CodCliente] = '"+codcliente+"'   ";
System.out.println("AGENDAMIENTOVALIDAR===================>"+sql);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
          
//
            while (rs.next()) {
                
                ListObtenerTelefonoLista = rs.getString(1);

            }

         

        } catch (Exception e) {
            System.out.println("Error en el metodo RecordarAgendamiento :" + e.getMessage());
        ///   ListObtenerTelefonoLista = null;
        } finally {
            try {
               rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
    
     return ListObtenerTelefonoLista ;
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
  "FROM [Rascal].[dbo].[ResultadoLlamada]  "+
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
             id=obtenerCodigo(campana,cn_rascalLocal); 
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
public String ListaVENTASAC(String xcodigo,Connection con ){
    List listaContador = null;
      ResultSet rs =null;
          PreparedStatement ps=null;
          String conta="";
        try {
            
       listaContador = new ArrayList();
      /* String sql = "Select Telefono, count(Telefono) as Q from  \n" +
"  [GMD_RASCAL].dbo.Tabla_GMD_BD_Llamadas_Final_2  \n" +
"  Where ([Fecha y Hora]) between (getdate()-90) and ( getdate())  \n" +
"   and ACDTime > 19 "+
 " and Telefono='"+xnumero.trim()+"' " +                                      
"  Group by Telefono ";*/

   String sql =    " SELECT [Fecha] \n" +
"  FROM [Rascal].[dbo].[Venta_SAC]\n" +
"  \n" +
"  where Cod_Cliente='"+xcodigo+"'\n" +
"  " ;       
        ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
         System.out.println("Query venta "+sql);
            while(rs.next()){
            //codigo = rs.getString(1);
          // listaContador.add(rs.getString(1))     ;
                conta = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("ListaVENTASAC :" + e.getMessage());
            listaContador =null;
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

     
     return conta;
      
    
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
     

public List<beanDetalladoCliente> ObtenerDetallefiltro(String CampanaSession, Connection con,String where) {
List<beanDetalladoCliente> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {

       //     String sql = "EXEC  [rmc_baA].[dbo].[cb_web_campaign_det_avaliable_prueba_tipogestion_JTFINAL]  " + CampanaSession +"," + where;
 if(where =="" ){
    where="AccountNumber like ''%%''  ";
 }
            
      String sql =      " EXEC	[rmc_baA].[dbo].[cb_web_campaign_det_avaliable_prueba_tipogestion_JTFINAL2_ORDENAMIENTO] "+
		" @campaignName = N'"+CampanaSession+"',  "+
		" @where = N'"+where+"' ";
            
            
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanDetalladoCliente>();

            while (rs.next()) {
                beanDetalladoCliente obtenerDetalle = new beanDetalladoCliente();
                obtenerDetalle.setCodCliente(rs.getString(1));
                obtenerDetalle.setApellido(rs.getString(2));
                //obtenerDetalle.setNombre(rs.getString(3));
                obtenerDetalle.setNumero1(rs.getString(4));
                obtenerDetalle.setNumero2(rs.getString(5));
                obtenerDetalle.setNumero3(rs.getString(6));
                obtenerDetalle.setExtension(rs.getString(7));
                obtenerDetalle.setEstado(rs.getString(8));
                obtenerDetalle.setCallResult1(rs.getString(10));
                obtenerDetalle.setCallResult2(rs.getString(11));
                obtenerDetalle.setCallResult3(rs.getString(12));
                obtenerDetalle.setIntentos(rs.getString(13));
                obtenerDetalle.setCallback1(rs.getString(14));
                obtenerDetalle.setCallback2(rs.getString(15));
                obtenerDetalle.setCallback3(rs.getString(16));
                obtenerDetalle.setNrocallback(rs.getString(17));
                obtenerDetalle.setTipo_gestion(rs.getString(18));
                obtenerDetalle.setCodzonaventa(rs.getString(19));
                obtenerDetalle.setAnotacion(rs.getString(20));
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

 public int  contaGrabacDiaVenta( String codcli ,Connection con){
              ResultSet rs =null;
          PreparedStatement ps=null;
  
   int conta=0;
        try {
//  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = "SELECT     *\n" +
"FROM    (\n" +
"SELECT     ROW_NUMBER() OVER (PARTITION BY CodCliente\n" +
"ORDER BY Hora DESC) AS orden,\n" +
"CASE WHEN (Realizo_venta = 'Si') \n" +
"THEN '1'\n" +
"ELSE\n" +
"'0'\n" +
"END as conta\n" +
"\n" +
"FROM          [Rascal].[dbo].[ResultadoLlamada]\n" +
"WHERE     \n" +
"CodCliente='"+codcli+"'\n" +
"and\n" +
"CONVERT(varchar, Hora, 103) = CONVERT(varchar, getdate(), 103) \n" +
") a where a.orden =1" ;
        
    ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
  while (rs.next()) {
    conta=rs.getInt(2);
      
            }
        } catch (SQLException e) {
            System.out.println("Error en la  el metodo contaGrabacDiaVenta :" + e.getMessage());

        } 
finally {
            try {
             
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
   
        return conta;
    
        }  
      

public int  contaGrabacDia( String codcli ,Connection con){
              ResultSet rs =null;
          PreparedStatement ps=null;
  
   int conta=0;
        try {
//  String sql = "INSERT INTO [Ficha_Cliente].[dbo].[Identificadoor]([Campana] ,[CodCliente],[Hora]) VALUES    ('"+campana+"','"+codCliente+"','"+sqlTimestamp+"')";
    String sql = " SELECT count(CodCliente) " +
"  FROM [Rascal].[dbo].[ResultadoLlamada]  " +
"  where CodCliente= '"+codcli+"' " +
"and  (CONVERT(varchar,Hora, 103) = " +
"  CONVERT(varchar, GETDATE(), 103)) ";
        
    ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
  while (rs.next()) {
    conta=rs.getInt(1);
      
            }
        } catch (SQLException e) {
            System.out.println("Error en la  el metodo contaGrabacDia :" + e.getMessage());

        } 
finally {
            try {
             
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
   
        return conta;
    
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

public  int  selectContacto(String codcli, String campana,Connection con) {
        
     int  resul =0;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT   [CONTADOR]\n" +

"  FROM [Rascal].[dbo].[EfectividadXContacto] "
                + "where   [AccountNumber]= '"+codcli+"'  ";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                resul=rs.getInt(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo selectContacto:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return resul;
    }

    @Override
    public int insertarVentanaHoraria(String campana, String codCliente, String rango, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            ///System.out.println("System ==>"+campana+"id max===>"+id);
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

   public int updateContacto2(String campana, String codcli,int contador,Connection cn) {
       ResultSet rs =null;
          PreparedStatement ps=null;
        int codigo=0 ;
        ///int id=0;
        try {
          
            ///id=obtenerCodigo(campana,cn);  
            String sql = "UPDATE [Rascal].[dbo].[EfectividadXContacto] "+
   "SET [CONTADOR] =  "+contador +
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
     return codigo;
    }
 public int insertacomentario(String codcliente, String comentario, String campana,Connection con){
        ResultSet rs =null;
          PreparedStatement ps=null;
        int insert = 0;
        try {
            
            java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
 String NroEliminado="Nro Sera Eliminado";
  
  String sql = "INSERT INTO [Rascal].[dbo].comentario(cod_cliente,comentario,fecha,Campana)VALUES('"+ codcliente+"','"+comentario+"','"+sqlTimestamp+"','"+campana+"') ";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
      ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo insertacomentario:" + e.getMessage());

        }
finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
 public int updateComentario(String codcliente,String coment,Connection con){
   
          PreparedStatement ps=null;
        int insert = 0;
        try {
            
     java.util.Date utilDate = new java.util.Date(); 
            long lnMilisegundos = utilDate.getTime();
  java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos); 
  
  String sql = "UPDATE [Rascal].[dbo].comentario "
          + "SET comentario= '"+coment+"',"
          + " fecha = '"+sqlTimestamp+"' "
          + " WHERE cod_cliente='"+codcliente+"'";
            
        //    String sql = "INSERT INTO IDENTIFICADOR VALUES (" + obtenerCodigo(campana) + "," + campana + "," + codCliente + ",SYSTDATETIME)";
         
      ps = con.prepareStatement(sql.toString());
       ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la  el metodo updateComentario:" + e.getMessage());

        }
finally {
            try {
               
                ps.close();
            } catch (SQLException e) {
            }
            
           
        }
        return insert;
    }
 
 
 public  String  selectComentario(String codcli, String campana,Connection con) {
        
     String  comentario ="";
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT \n" +
"      [comentario]\n" +
"  FROM [Rascal].[dbo].[comentario] where [cod_cliente]= '"+codcli+"' ";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                comentario=rs.getString(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo selectContacto:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return comentario;
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


  public  int  contaComentario(String codcli, String campana,Connection con) {
        
     int   conta =0;
        ResultSet rs =null;
          PreparedStatement ps=null;
        try {
       // con = oracleDaoLocalFactoryImpl.getSQLConextion();
      //  Statement st = con.createStatement();
        String sql ="SELECT count(*)" +
"  FROM [Rascal].[dbo].[comentario] where [cod_cliente]= '"+codcli+"' ";
        
      ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
      
        
                while (rs.next()) {
               

               
                conta=rs.getInt(1);
            }
            
             
        
        } catch (Exception e) {
            System.out.println("Error en el metodo contaComentario:" +e.getMessage());
         
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
        }

       return conta;
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
  
  public void execProcedureTel( String anexo ,String id,String xcodigo,Connection con){
    // Connection cn = null;
     int codigo=0;
       PreparedStatement ps=null;
        try {
          ///  cn = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
            //Statement st = con.createStatement();
             String sql = " exec [Rascal].[dbo].[Telefono_Real_Time]  '"+anexo+"','"+id+"' ,'"+xcodigo+"' ";
             System.out.println("sql de procedure=======================>" +sql);
  ps = con.prepareStatement(sql.toString());
         ps.executeUpdate();

             
        } catch (Exception e) {
            System.out.println("Error en la  el metodo ejecutarpocedue:" + e.getMessage());

        }
      
 }  
  
    public List<beanSeguimientoCampana> Seguimiento(String codigocliente,Connection con) {
      List<beanSeguimientoCampana> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {


      String sql =      "  EXEC  [Rascal].[dbo].[SEGUIMIENTO] "
              + "          @cod_cli_sap = N'"+codigocliente+"'    ";
            
            
         ps = con.prepareStatement(sql.toString());
      rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanSeguimientoCampana>();

            while (rs.next()) {
                beanSeguimientoCampana obtenerDetalle = new beanSeguimientoCampana();
                obtenerDetalle.setCodigo(rs.getString(1));
                obtenerDetalle.setNombreProducto(rs.getString(2));
                obtenerDetalle.setMarca(rs.getString(3));
                obtenerDetalle.setCuota(rs.getString(4));
                obtenerDetalle.setAvance(rs.getString(5));
                obtenerDetalle.setSaldo(rs.getString(6));
                ListObtenerDetalle.add(obtenerDetalle);
            }

            if (ListObtenerDetalle.isEmpty()) {
                ListObtenerDetalle = null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo Seguimiento :" + e.getMessage());
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
      public List<beanInformacionCliente> CAMPANAInformacion(String codigocliente,Connection con) {
      List<beanInformacionCliente> ListObtenerDetalle = null;
        //Connection con = null;
        ResultSet rs =null;
          PreparedStatement ps=null;
        
        try {


      String sql =      "EXEC	[Rascal].[dbo].[INFORMACION_CLIENTE]\n" +
                         " @cod_cli_sap = N'"+codigocliente+"' ";
            
            
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            ListObtenerDetalle = new ArrayList<beanInformacionCliente>();

            while (rs.next()) {
                beanInformacionCliente obtenerDetalle = new beanInformacionCliente();
               obtenerDetalle.setMensaje(rs.getString(1));
               obtenerDetalle.setInicio(rs.getString(2));
               obtenerDetalle.setFin(rs.getString(3));
                ListObtenerDetalle.add(obtenerDetalle);
            }

            if (ListObtenerDetalle.isEmpty()) {
                ListObtenerDetalle = null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo CAMPANAInformacion :" + e.getMessage());
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
  
}
