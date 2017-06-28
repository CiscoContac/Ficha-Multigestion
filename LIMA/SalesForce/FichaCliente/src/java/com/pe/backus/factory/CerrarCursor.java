/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.backus.factory;

import java.sql.Connection;

/**
 *
 * @author GMD
 */
public class CerrarCursor {
    
    
    public void cerrar(Connection con){
        try{
      con.close();
        }catch(Exception e){
          System.out.println("ERROR EN CERAR EL CURSOR: "+e.getMessage())  ;
        }
        
    }
    
    
}
