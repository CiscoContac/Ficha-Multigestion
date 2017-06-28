/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.factory;

import com.pe.backus.util.readProperties;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class sqlDaoFactoryImpl {

   public static Connection getSQLConextion(){
       try {
             Connection cn_ora = null;
          // cn_ora  =DriverManager.getConnection(CADENA,usuario,password);
           InitialContext initialContext = new InitialContext();
Context context = (Context) initialContext.lookup("java:comp/env");

//The JDBC Data source that we just created
DataSource ds = (DataSource) context.lookup("ippcsql");
 cn_ora = ds.getConnection() ;   
 
 return cn_ora;
       } catch (Exception  e) {
           System.out.println("Error en conexion SQL :"+e.getMessage() );
        return null;
       }
       
       
   }
   


 
   
}
