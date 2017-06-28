<%@page import="java.util.ArrayList"%>
<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.dto.beanFiltroCliente"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="net.viralpatel.autocomplete.DummyDB"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%
    response.setHeader("Cache-Control", "no-store");
      response.setHeader("Pragma", "no-cache");
      response.setDateHeader("Expires", 0);
DummyDB db = new DummyDB();
	String query = request.getParameter("q");
 String ConPet= (String)session.getAttribute("CondicionPet");
 String pet = (String)session.getAttribute("PETVALOR");
 /*  System.out.println("valor de dataa==================  "+query);
            System.out.println("condicion de pet =============== "+ConPet);
     System.out.println("valor de pettttt============= "  +pet);      */
 if(ConPet != null){
     System.out.println("entro para la condicion");
  List<beanFiltroCliente> clientesObtenidos = db.getDataPet(query,pet);
	for(int i=0; i< clientesObtenidos.size(); i++){
		String clie = (String)clientesObtenidos.get(i).getDesclidetallista();
		String codClie = (String)clientesObtenidos.get(i).getCodcliente();
		out.println(clie +" - "+codClie);
	}   
 }else{
 
         
	List<beanFiltroCliente> clientesObtenidos = db.getData(query);
	for(int i=0; i< clientesObtenidos.size(); i++){
		String clie = (String)clientesObtenidos.get(i).getDesclidetallista();
		String codClie = (String)clientesObtenidos.get(i).getCodcliente();
		out.println(clie +" - "+codClie);
	}
 } 
        
    %>    
        