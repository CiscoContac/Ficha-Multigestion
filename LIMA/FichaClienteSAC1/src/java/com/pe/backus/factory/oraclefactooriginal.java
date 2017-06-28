/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.backus.factory;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Administrador
 */
public class oraclefactooriginal {
      public static Connection getSQLConextion(){
    
                            // jdbc:oracle:thin:localhost:1521:orcl","system","cisco"          
       try {
         //  Class.forName("oracle.jdbc.OracleDriver");
          Connection cn_ora = null;
          // cn_ora  =DriverManager.getConnection(CADENA,usuario,password);
           InitialContext initialContext = new InitialContext();
Context context = (Context) initialContext.lookup("java:comp/env");

//The JDBC Data source that we just created
DataSource ds = (DataSource) context.lookup("oracle");
 cn_ora = ds.getConnection() ;    
          
           return cn_ora;
       } catch (Exception e) {
           System.out.println("Error en la conexion Oracle local: "+e.getMessage());
       return null;
       } 
    }
}
