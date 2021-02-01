<%-- 
    Document   : Validar_Menu_U
    Created on : 14-ene-2021, 13:49:44
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>PLAYMOBIL</title>
    <link rel="stylesheet" href="Fotos\style.css"> 
</head>
<body>

<%
//  Parametros recibidos.
String seleccion = request.getParameter("seleccion");
    if( seleccion.equals("1") ){
        request.getSession().setAttribute("cOpcion", "XX");
        response.sendRedirect("ServletListadoArticulos");
	}else{
            if( seleccion.equals("2") ) {
                response.sendRedirect("BuscarArticuloCodigo.jsp");
                }else{
                    if( seleccion.equals("3") ) {
                        response.sendRedirect("BuscarArticuloNombre.jsp");
                    }else{
                        response.sendRedirect("ServletListaCesta");	
                    }
                }
            }
  
 %>
 </body>
</html>