<%-- 
    Document   : scroll tabla
    Created on : 19/03/2014, 11:34:56 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="styles/css-calendar/calendario.css" type="text/css" rel="stylesheet">
        
<script src="js/calendario/calendar.js" type="text/javascript"></script>
<script src="js/calendario/calendar-es.js" type="text/javascript"></script>
<script src="js/calendario/calendar-setup.js" type="text/javascript"></script>
    
    </head>
    <body>
       <input type="text" name="ingreso" id="ingreso" value="dd-mm-yyyy" /> 
<img src="img/calendar/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador">
<!-- script que define y configura el calendario--> 
<script type="text/javascript"> 
   Calendar.setup({ 
    inputField     :    "ingreso",     // id del campo de texto 
     ifFormat     :     "%d-%m-%Y",     // formato de la fecha que se escriba en el campo de texto 
     button     :    "lanzador"     // el id del botón que lanzará el calendario 
}); 
</script>

    </body>
</html>
