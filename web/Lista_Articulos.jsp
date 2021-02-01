<%-- 
    Document   : ListaArticulos
    Created on : 13-ene-2021, 11:13:53
    Author     : JuanMi
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.Articulos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html>
<head><title>LISTADO DE ARTICULOS CON STOCK</title></head>
<body >
<h1>[ AMAZON LIGHT ( Listado de Articulos con Stock ) ]</h1><br><br>

<table border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Id Articulo</TD> 
<TD WIDTH=200 ALIGN="CENTER" BGCOLOR="Brown">Titulo</TD>
<TD WIDTH=300 ALIGN="CENTER" BGCOLOR="Brown">Descripción</TD>
<TD WIDTH=150 ALIGN="CENTER" BGCOLOR="Brown">Foto</TD>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Precio</TD>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Stock</TD>
</TR>
<%
ArrayList listaArticulos = (ArrayList) request.getSession().getAttribute("listaArticulos");
 
Iterator itlistaArticulos = listaArticulos.iterator();
        
while(itlistaArticulos.hasNext()){
    Articulos articulo_tmp = new Articulos();
    articulo_tmp = (Articulos) itlistaArticulos.next();
%> 
<tr>
<td WIDTH=50 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=articulo_tmp.getId_art()%></td>
<td WIDTH=200 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=articulo_tmp.getTitulo()%></td>
<td WIDTH=300 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=articulo_tmp.getDescripcion()%></td>
<td WIDTH=150 ALIGN="CENTER" BGCOLOR="#FFF3CF"><img src='<%="Fotos/"+articulo_tmp.getFoto()%>'></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=articulo_tmp.getPrecio()%></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=articulo_tmp.getCantidad()%></td>
</tr>
<%}
request.getSession().removeAttribute("listaArticulos");
%>
</table>

<br><br><br>

<button onclick="location.href='Menu_Usuario.jsp'">Menu Usuario</button> &nbsp; &nbsp;
<button onclick="location.href='ServletExportaExcel'">Exportar a Excel (POI)</button> &nbsp; &nbsp;
<button onclick="location.href='http://localhost:8080/Excel/articulos.xlsx'" download="articulos.txt">Descargar Fichero via navegador</button> &nbsp; &nbsp;

<!--
<a download href="http://localhost:8080/Excel/articulos.xlsx">Descargar fichero</a>
-->

</body>
</html>
