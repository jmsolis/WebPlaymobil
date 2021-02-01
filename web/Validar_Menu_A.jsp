<%-- 
    Document   : Validar_Menu_A
    Created on : 14-ene-2021, 11:30:44
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head><title>CRM</title></head>
<body>

<%
//  Parametros recibidos.
String seleccion = request.getParameter("seleccion");
    if( seleccion.equals("A") ){
            response.sendRedirect("Alta_Articulo.jsp");
	}else{
            if( seleccion.equals("L") ) {
                response.sendRedirect("ServletListadoVentas");
                } else {
                response.sendRedirect("ServletListadoUsuarios");	
            }
	}
  
 %>
 </body>
</html>