/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.viralpatel.autocomplete;

import com.pe.backus.dto.beanFiltroCliente;
import com.pe.backus.factory.oracleDaoLocalFactoryImpl;
import com.pe.backus.factory.oraclefactooriginal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DbuscadorPET {
    public List  llenadoListaPET(String pet){
	
		List list = null;
		
		Connection con = oraclefactooriginal.getSQLConextion();
ResultSet rs =null;
          PreparedStatement ps=null;
		try {
			//Statement st = con.createStatement();
                    //System.out.println("valor llenadolista "+ pet);
			String sql = "select codzona_telv from codzona_telv WHERE codzona_telv like   '%"+pet+"%'";
			ps = con.prepareStatement(sql.toString());
                        rs = ps.executeQuery();

			list = new ArrayList();

			while (rs.next()) {
				
				list.add(rs.getString(1));
			}

			if (list.isEmpty()) {
				list = null;
			}

		} catch (SQLException e) {
			list = null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}

		return list;
	}
    public List<beanFiltroCliente> getData(String query) {
		
		query = query.toUpperCase();
                //System.out.println("valor "+query);
                	List    obtenerCliente = llenadoListaPET(query) ;

                List  matched=null;
                
		//System.out.println("Tamano de la lista "+obtenerCliente.size());
		
             try{           
		 matched = new ArrayList();
		//System.out.println("Nombres que inician con " +query);
		for(int i=0; i<obtenerCliente.size(); i++){
                    //System.out.println("nombres que Ingresan al For " +obtenerCliente.get(i).getDesclidetallista());
                    
			/*if(obtenerCliente.get(i).getDesclidetallista().startsWith(query) || obtenerCliente.get(i).getCodcliente().startsWith(query)  ){
				System.out.println("Ingresa al match :"+ obtenerCliente.get(i).getDesclidetallista());
				System.out.println("Ingresa al match :"+ obtenerCliente.get(i).getCodcliente());
                                matched.add(obtenerCliente.get(i));
                                System.out.println("El tamano del Match obtenido "+matched.size());
			}*/
   
               matched.add(obtenerCliente.get(i));
             //  System.out.println("Ingresa al match :"+ obtenerCliente.get(i).getDesclidetallista());
		}
             }catch (Exception e) {
                 System.out.println("Error en el Metodo Getada "+  e.getMessage());
                         
             }
		//System.out.println("Antes del return");
		return matched; 
	}  
}
