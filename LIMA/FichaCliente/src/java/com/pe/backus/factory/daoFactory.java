/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.backus.factory;

/**
 *
 * @author Carlos
 */
public abstract class daoFactory {
     public static final String BD_SQL="bd_sql";
     public static final String BD_ORACLE="bd_oracle";
    
    
     public static daoFactory getDAOFactory(String motor){
		if(motor.equals(BD_SQL)){
                  // return new sqlDaoFactoryImpl();
		}
                if(motor.equals(BD_ORACLE)){
                    return new oracleDaoFactoryImpl();
                }  
		return null;
	}

     
     
}
