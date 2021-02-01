<%-- 
    Document   : Validar_Menu_U
    Created on : 14-ene-2021, 13:49:44
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
    if( seleccion.equals("V") ){
            response.sendRedirect("ServletListaArticulos");
	}else{
            if( seleccion.equals("B") ) {
                response.sendRedirect("Buscar_Articulo.jsp");
                } else {
                response.sendRedirect("ServletListaCesta");	
            }
	}
  
 %>
 </body>
</html>