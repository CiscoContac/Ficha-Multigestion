package net.viralpatel.autocomplete;

import com.pe.backus.dao.impl.clienteOracleDaoImpl;
import com.pe.backus.dao.impl.clienteSqlDaoImpl;
import com.pe.backus.dto.beanFiltroCliente;
import com.pe.backus.factory.oracleDaoLocalFactoryImpl;
import com.pe.backus.factory.oraclefactooriginal;
import com.pe.backus.factory.sqlDaoLocalFactoryImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;


public class DummyDB {
/*	private int totalCountries;
         clienteOracleDaoImpl oraCliente = new clienteOracleDaoImpl();
          Connection orasql= oraclefactooriginal.getSQLConextion();//conexion a oracle 
         List<beanFiltroCliente> ListObtenerDetalleBusca= oraCliente.ObtenerDetalleBusca(orasql); 
         */
   // Connection cn_sql = sqlDaoLocalFactoryImpl.getSQLConextionLocal();
   // clienteSqlDaoImpl  sqlImplements = new clienteSqlDaoImpl();
      HttpSession sesion  ;
  // int cont =0;
    
	/*public DummyDB() {
        sesion.setAttribute("contador", cont);
            
            
	}*/
	/*
	public List<beanFiltroCliente> getData(String query) {
		
		query = query.toUpperCase();
                   
                List<beanFiltroCliente> matchematched = new ArrayList <beanFiltroCliente>();
		for(int i=0; i<ListObtenerDetalleBusca.size(); i++) {
			cliente =(beanFiltroCliente) ListObtenerDetalleBusca.get(i);
			if(cliente.getDesclidetallista().startsWith(query)) {
				matched.add(cliente);
			}
		}
		return matched;
	}*/
 
   public List <beanFiltroCliente> llenadoLista(String nombre){
	
		List<beanFiltroCliente> list = null;
		
		Connection con = oraclefactooriginal.getSQLConextion();
//oracleDaoLocalFactoryImpl.getSQLConextion();
ResultSet rs =null;
          PreparedStatement ps=null;
		try {
			//Statement st = con.createStatement();
                    //System.out.println("valor llenadolista "+ nombre);
			String sql = "SELECT top 20  CODCLIENTE,NOMBRE FROM vistaclientes where  NOMBRE like '%"+nombre+"%'";
			System.out.println("valor de sql llenado lista==========  "  +sql);
                        ps = con.prepareStatement(sql.toString());
                        rs = ps.executeQuery();

			list = new ArrayList<beanFiltroCliente>();

			while (rs.next()) {
				beanFiltroCliente client = new beanFiltroCliente();

				client.setCodcliente(rs.getString(1));
				client.setDesclidetallista(rs.getString(2));
				list.add(client);
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
    
    
     public List <beanFiltroCliente> llenadoListaFiltro(String nombre,String pet){
	
		List<beanFiltroCliente> list = null;
		
		Connection con = oraclefactooriginal.getSQLConextion();
ResultSet rs =null;
          PreparedStatement ps=null;
		try {
			//Statement st = con.createStatement();
                    //System.out.println("valor llenadolista "+ nombre);
			String sql = "SELECT top 20 CODCLIENTE,NOMBRE FROM vistaclientes where  NOMBRE like '%"+nombre+"%' and codzona_telv = '"+pet+"'";
			System.out.println("valor de sql==========  "  +sql);
                        ps = con.prepareStatement(sql.toString());
                        rs = ps.executeQuery();

			list = new ArrayList<beanFiltroCliente>();

			while (rs.next()) {
				beanFiltroCliente client = new beanFiltroCliente();

				client.setCodcliente(rs.getString(1));
				client.setDesclidetallista(rs.getString(2));
				list.add(client);
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
                	List<beanFiltroCliente>    obtenerCliente = llenadoLista(query) ;

                List  <beanFiltroCliente>matched=null;
                
		//System.out.println("Tamano de la lista "+obtenerCliente.size());
		
             try{           
		 matched = new ArrayList<beanFiltroCliente>();
		///System.out.println("Nombres que inician con " +query);
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
		///System.out.println("Antes del return");
		return matched; 
	}  
    public List<beanFiltroCliente> getDataPet(String query,String condicion ) {
		
		query = query.toUpperCase();
                //System.out.println("valor "+query);
                	List<beanFiltroCliente>    obtenerCliente = llenadoListaFiltro(query,condicion) ;

                List  <beanFiltroCliente>matched=null;
                
		//System.out.println("Tamano de la lista "+obtenerCliente.size());
		
             try{           
		 matched = new ArrayList<beanFiltroCliente>();
		///System.out.println("Nombres que inician con " +query);
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
		///System.out.println("Antes del return");
		return matched; 
	}  
}
