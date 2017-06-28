/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.backus.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author GMD
 */
public class javaclassconexionsql {
    
    
    public static  Connection getSQLConextion(){
       try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
           Connection cn_sql1 = DriverManager.getConnection("jdbc:sqlserver://10.165.136.141;databaseName= ;user=sql-admin; password=cisco");
           return cn_sql1;
       } catch (Exception e) {
           System.out.println("Error en conexion SQL :"+e.getMessage() );
        return null;
       }
       
       
   }
    
}
