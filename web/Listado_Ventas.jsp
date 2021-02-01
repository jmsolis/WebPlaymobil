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
<head><title>LISTADO DE VENTAS</title></head>
<script>
function exportTableToExcel(tableID, filename = ''){
    var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'excel_data.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
}
</script>
<body >
<h1>[ AMAZON LIGHT ( Listado de Ventas ) ]</h1><br><br>

<table id="tblVentas"border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Nº Venta</TD> 
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Linea</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Cliente</TD>
<TD WIDTH=200 ALIGN="CENTER" BGCOLOR="Brown">Nombre</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Articulo</TD>
<TD WIDTH=300 ALIGN="CENTER" BGCOLOR="Brown">Descripción</TD>
<TD WIDTH=100 ALIGN="CENTER" BGCOLOR="Brown">Fecha Venta</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Precio Und.</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Cantidad</TD>
<TD WIDTH=60 ALIGN="CENTER" BGCOLOR="Brown">Total Linea</TD>
</TR>
<%
ArrayList listaVentas = (ArrayList) request.getSession().getAttribute("listaVentas");
 
Iterator itlistaVentas = listaVentas.iterator();
        
while(itlistaVentas.hasNext()){
    Ventas venta_tmp = new Ventas();
    venta_tmp = (Ventas) itlistaVentas.next();
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
<td WIDTH=60 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=venta_tmp.getCantidad_art()%></td>
<td WIDTH=60 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=venta_tmp.getTotal_linea()%></td>
</tr>
<%}
request.getSession().removeAttribute("listaVentas");
%>
</table>

<br><br><br>

<button onclick="location.href='Menu_Admin.jsp'">Menu Usuario</button>&nbsp; &nbsp;
<button onclick="exportTableToExcel('tblVentas', 'ventas')">Export Ventas a Excel File</button>

</body>
</html>
