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
    int nUnd = (Integer) request.getSession().getAttribute("nUnd");
    int nStk = (Integer) request.getSession().getAttribute("nStk");
    String cDes = (String) request.getSession().getAttribute("cDes"); 
    %>    
        
        <h1>¡¡¡ ERROR !!!, no hay suficiente stock del articulo.</h1>
        <br><br>
        <h2>[  Articulo ]  [ &nbsp;<%=nArt%> &nbsp; - &nbsp; <%=cDes%>&nbsp;]</h2>
        <h2>[  Unidades pedidas : &nbsp;<%=nUnd%> &nbsp; | Unidades en stock :  &nbsp; <%=nStk%> &nbsp;]</h2><br>
        
        <button onclick="location.href='ServletListaCesta'">Volver</button>
    </body>
</html>
