<%@page import="java.util.ArrayList"%>
<%@page import="com.pe.backus.factory.oraclefactooriginal"%>
<%@page import="com.pe.backus.dto.beanFiltroCliente"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pe.backus.dao.impl.clienteOracleDaoImpl"%>
<%@page import="net.viralpatel.autocomplete.DummyDB"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%
DummyDB db = new DummyDB();

	String query = request.getParameter("q");
      
        
	List<beanFiltroCliente> clientesObtenidos = db.getData(query);
	for(int i=0; i< clientesObtenidos.size(); i++){
		String clie = (String)clientesObtenidos.get(i).getDesclidetallista();
		String codClie = (String)clientesObtenidos.get(i).getCodcliente();
		out.println(clie +" - "+codClie);
	}
        
        
    %>    
        