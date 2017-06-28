/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readProperties {
    
    public Properties getProperties (){
      try {  
        Properties propiedades;
        propiedades= new Properties();      
        
            FileInputStream input = new FileInputStream("C:/Apps/Backus/FichaCliente/Config/BD_configure.properties");
            propiedades.load(input);
            
            if(!propiedades.isEmpty()){
                return propiedades;
            }else{
                return null;
            }
        } catch (IOException ex) {
            System.out.println("Error al leer las propiedades :"+ex.getMessage());
        }
        
        return null;
        
        
    }
}
