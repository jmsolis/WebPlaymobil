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
<head>
    <title>LISTADO DE ARTICULOS CON STOCK</title>
    <link rel="stylesheet" href="Fotos\style.css"> 
</head>
<body>
<%
request.getSession().setAttribute("cOpcListado", "articulos");
%>    
        
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Listado de Articulos con Stock ) ]</h1>

<table border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Id Articulo</TD> 
<TD WIDTH=400 ALIGN="CENTER" BGCOLOR="Brown">Descripción</TD>
<TD WIDTH=100 ALIGN="CENTER" BGCOLOR="Brown">Foto</TD>
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
<td WIDTH=60 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=articulo_tmp.getId_art()%></td>
<td WIDTH=400 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=articulo_tmp.getDescripcion()%></td>
<td WIDTH=100 ALIGN="CENTER" BGCOLOR="#FFF3CF"><img src='<%="Fotos/"+articulo_tmp.getFoto()%>' width='100' height='100'></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=articulo_tmp.getPrecio()%></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=articulo_tmp.getStock()%></td>
</tr>
<%}
// request.getSession().removeAttribute("listaArticulos");
%>
</table>

<br><br><br>

     
<button onclick="location.href='MenuAdmin.jsp'">Menu Administrador</button> &nbsp; &nbsp;
<button onclick="location.href='ServletExportaExcelArt'">Exportar a Excel (POI)</button> &nbsp; &nbsp;
<button onclick="location.href='http://localhost:8080/Excel/articulos.xlsx'" download="articulos.xlsx">Descargar Fichero via navegador (debera estar exportado)</button> 


</body>
</html>
