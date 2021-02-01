<%-- 
    Document   : Validar_Menu_A
    Created on : 14-ene-2021, 11:30:44
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head><title>PLAYMOBIL</title></head>
<link rel="stylesheet" href="Fotos\style.css"> 
<body>

<%
//  Parametros recibidos.
    String seleccion = request.getParameter("seleccion");
     switch(seleccion.charAt(0)) {
        case '1' :  
            response.sendRedirect("AltaArticulo.jsp");
            break;
        case '2' :
            response.sendRedirect("EntradaSalidaStock.jsp");
            break;           
        case '3' :
            response.sendRedirect("ServletListadoUsuarios");
            break;
        case '4' :
            response.sendRedirect("ServletListadoArticulosAdmin");
            break;           
        case '5' :
            response.sendRedirect("ServletListadoVentas");
            break;           
            
    }  // Fin del Switch.


  
 %>
 </body>
</html>