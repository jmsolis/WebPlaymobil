<%-- 
    Document   : OK
    Created on : 13-ene-2021, 14:03:15
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Fotos\style.css"> 
    </head>
    <body>
    <%
    int nArt = (Integer) request.getSession().getAttribute("nArt");
    %>    
        
        <h1>¡¡¡ ERROR !!!, el articulo [&nbsp; <%=nArt%> &nbsp; ], No existe.</h1>
        <br><br>
        <button onclick="location.href='ServletListaCesta'">Volver</button>
    </body>
</html>
