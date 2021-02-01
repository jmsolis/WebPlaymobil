<%-- 
    Document   : ListaUsuarios
    Created on : 13-ene-2021, 11:13:53
    Author     : JuanMi
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html>
<head>
    <title>LISTADO DE USUARIOS</title>
    <link rel="stylesheet" href="Fotos\style.css"> 
</head>
<body>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Listado de Usuarios ) ]</h1><br><br>

<table id="tblUser" border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=70 ALIGN="CENTER" BGCOLOR="Brown">Id User</TD> 
<TD WIDTH=90 ALIGN="CENTER" BGCOLOR="Brown">Usuario</TD>
<TD WIDTH=90 ALIGN="CENTER" BGCOLOR="Brown">Password</TD>
<TD WIDTH=250 ALIGN="CENTER" BGCOLOR="Brown">Nombre</TD>
<TD WIDTH=400 ALIGN="CENTER" BGCOLOR="Brown">Dirección</TD>
<TD WIDTH=150 ALIGN="CENTER" BGCOLOR="Brown">Telefono</TD>
<TD WIDTH=400 ALIGN="CENTER" BGCOLOR="Brown">E-mail</TD>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Nº Compras</TD>
</TR>
<%
request.getSession().setAttribute("cOpcListado", "usuarios");
ArrayList listaUsuarios = (ArrayList) request.getSession().getAttribute("listaUsuarios");
 
Iterator itlistaUsuarios = listaUsuarios.iterator();
        
while(itlistaUsuarios.hasNext()){
    Usuarios usuario_tmp = new Usuarios();
    usuario_tmp = (Usuarios) itlistaUsuarios.next();
%> 

<tr>
<td WIDTH=70 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=usuario_tmp.getId_user()%></td>
<td WIDTH=90 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getUsuario()%></td>
<td WIDTH=90 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getPassword()%></td>
<td WIDTH=250 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getNombre()%></td>
<td WIDTH=400 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getDireccion()%></td>
<td WIDTH=150 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getTelefono()%></td>
<td WIDTH=400 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getEmail()%></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getCompras()%></td>
</tr>

<%}
// request.getSession().removeAttribute("listaUsuarios");
%>
</table>

<br><br><br>

<button onclick="location.href='MenuAdmin.jsp'">Menu Administrador</button> &nbsp; &nbsp;
<button onclick="location.href='ServletExportaExcelUsr'">Exportar a Excel (POI)</button> &nbsp; &nbsp;
<button onclick="location.href='http://localhost:8080/Excel/usuarios.xlsx'" download="usuarios.xlsx">Descargar Fichero via navegador (debera estar exportado)</button> 

</body>
</html>
