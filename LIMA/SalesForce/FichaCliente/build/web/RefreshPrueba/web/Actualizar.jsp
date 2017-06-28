<%-- 
    Document   : index
    Created on : May 2, 2014, 4:14:51 PM
    Author     : jquispeo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> ^^(°,..,°)^^   ^^(°,..,°)^^  ^^(°,..,°)^^  ^^(°,..,°)^^</title>
    </head>
    <body  onkeydown="return (event.keyCode != 116)">
<script>
document.attachEvent("onkeydown", my_onkeydown_handler)
function my_onkeydown_handler() {

  if(event.keyCode == 116) {
    event.keyCode = 0;
    event.returnValue = false;
  }
}
</script>
        <h1>Prueba</h1>
    </body>
</html>
