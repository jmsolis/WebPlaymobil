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
    String cUsr = (String) request.getSession().getAttribute("cUsuario"); 
    %>       
        
        
    <h1>[ PLAYMOBIL - SEGUNDA MANO ]</h1><br><br>    
     <h2>[  Usuario ]  [ &nbsp;<%=cUsr%> &nbsp; - &nbsp; &nbsp;  ¡¡¡  Password, NO valida, reintetelo  !!!. &nbsp;]</h2><br><br>   

        <button onclick="location.href='index.jsp'">Volver</button>
    </body>
</html>
