<%-- 
    Document   : ListaVentas
    Created on : 20-ene-2021, 11:13:53
    Author     : JuanMi
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.Ventas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html>
<head>
    <title>LISTADO DE VENTAS</title>
    <link rel="stylesheet" href="Fotos\style.css"> 
</head>
<body>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Listado de Ventas ) ]</h1><br><br>

<table border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Nº Venta</TD> 
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Linea</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Cliente</TD>
<TD WIDTH=200 ALIGN="CENTER" BGCOLOR="Brown">Nombre</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Articulo</TD>
<TD WIDTH=300 ALIGN="CENTER" BGCOLOR="Brown">Descripción</TD>
<TD WIDTH=100 ALIGN="CENTER" BGCOLOR="Brown">Fecha Venta</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Precio Und.</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Unidades</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Total Linea</TD>
</TR>
<%
double nTotalVentas = 0;    
ArrayList listaVentas = (ArrayList) request.getSession().getAttribute("listaVentas");
 
Iterator itlistaVentas = listaVentas.iterator();
        
while(itlistaVentas.hasNext()){
    Ventas venta_tmp = new Ventas();
    venta_tmp = (Ventas) itlistaVentas.next();
    nTotalVentas = nTotalVentas + venta_tmp.getTotal_linea();
%> 
<tr>
<td WIDTH=50 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=venta_tmp.getId_venta()%></td>
<td WIDTH=50 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=venta_tmp.getId_linea()%></td>
<td WIDTH=60 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=venta_tmp.getId_cliente_vt()%></td>
<td WIDTH=200 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=venta_tmp.getNombre()%></td>
<td WIDTH=60 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=venta_tmp.getId_art_vt()%></td>
<td WIDTH=300 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=venta_tmp.getDescripcion()%></td>
<td WIDTH=100 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=venta_tmp.getFecha_vt()%></td>
<td WIDTH=60 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=venta_tmp.getPrecio_art()%></td>
<td WIDTH=60 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=venta_tmp.getUnd_venta()%></td>
<td WIDTH=60 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=venta_tmp.getTotal_linea()%></td>
</tr>
<%}
// request.getSession().removeAttribute("listaVentas");
%>
</table>
</table><table border=1 ALIGN=“CENTER”>
<tr><TD WIDTH=963 ALIGN="RIGHT" BGCOLOR="Brown">Importe total ventas = &nbsp;&nbsp;</TD> <td WIDTH=100 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=nTotalVentas%></td>
</table>

<br><br><br>

<button onclick="location.href='MenuAdmin.jsp'">Menu Administrador</button> &nbsp; &nbsp;
<button onclick="location.href='ServletExportaExcelVta'">Exportar a Excel (POI)</button> &nbsp; &nbsp;
<button onclick="location.href='http://localhost:8080/Excel/ventas.xlsx'" download="ventas.xlsx">Descargar Fichero via navegador (debera estar exportado)</button> 

</body>
</html>
