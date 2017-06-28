/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.factory;

import com.pe.backus.util.readProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Carlos
 */
public class oracleDaoFactoryImpl extends daoFactory {

   private static Properties propiedades = new readProperties().getProperties();
   private static String IP_ORA = propiedades.getProperty("IP_ora");
   private static String SID_ORA = propiedades.getProperty("SID_ora");
   private static String PORT_ORA = propiedades.getProperty("PORT_ora");
   private static String USER_ORA = propiedades.getProperty("USER_ora");
   private static String PASS_ORA = propiedades.getProperty("PASS_ora");
    
      public static Connection getOracleConextion(){
       String CADENA = "jdbc:oracle:thin:@"+IP_ORA+":"+PORT_ORA+":"+SID_ORA;
       try {
           Class.forName("oracle.jdbc.OracleDriver").newInstance();
           Connection cn_ora=DriverManager.getConnection(CADENA,USER_ORA,PASS_ORA);
           return cn_ora;
       } catch (Exception e) {
           System.out.println("Error en la conexion Oracle: "+e.getMessage());
       return null;
       }  
   }
}
