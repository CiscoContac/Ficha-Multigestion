<%-- 
    Document   : getpet
    Created on : 14/07/2014, 03:34:27 PM
    Author     : Administrador
--%>

<%@page import="net.viralpatel.autocomplete.DbuscadorPET"%>
<%@page import="com.pe.backus.dto.beanFiltroCliente"%>
<%@page import="java.util.List"%>
<%@page import="net.viralpatel.autocomplete.DummyDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
            response.setHeader("Cache-Control", "no-store");
      response.setHeader("Pragma", "no-cache");
      response.setDateHeader("Expires", 0);
DbuscadorPET db = new DbuscadorPET();

	String query = request.getParameter("q");
        String valor = request.getParameter("z");
        session.setAttribute("CondicionPet", valor);
  /* System.out.println("valor de pet jsppppp============================== "+query);
   System.out.print("valor de filtro get "+valor);*/
	List clientesObtenidos = db.getData(query);
	for(int i=0; i< clientesObtenidos.size(); i++){
		String clie = (String)clientesObtenidos.get(i);
		out.println(clie);
	}
    %>  