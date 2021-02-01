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
<head><title>LISTADO DE USUARIOS</title></head>

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
<h1>[ AMAZON LIGHT ( Listado de Usuarios ) ]</h1><br><br>

<table id="tblUser" border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Id User</TD> 
<TD WIDTH=100 ALIGN="CENTER" BGCOLOR="Brown">Password</TD>
<TD WIDTH=200 ALIGN="CENTER" BGCOLOR="Brown">Nombre</TD>
<TD WIDTH=400 ALIGN="CENTER" BGCOLOR="Brown">Dirección</TD>
</TR>
<%
ArrayList listaUsuarios = (ArrayList) request.getSession().getAttribute("listaUsuarios");
 
Iterator itlistaUsuarios = listaUsuarios.iterator();
        
while(itlistaUsuarios.hasNext()){
    Usuarios usuario_tmp = new Usuarios();
    usuario_tmp = (Usuarios) itlistaUsuarios.next();
%> 

<tr>
<td WIDTH=50 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=usuario_tmp.getId_user()%></td>
<td WIDTH=100 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getPassword()%></td>
<td WIDTH=200 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getNombre()%></td>
<td WIDTH=400 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=usuario_tmp.getDireccion()%></td>
</tr>

<%}
request.getSession().removeAttribute("listaUsuarios");
%>
</table>

<br><br><br>

<button onclick="location.href='Menu_Admin.jsp'">Menu Administrador</button> &nbsp; &nbsp;
<button onclick="exportTableToExcel('tblUser', 'usuarios')">Export Usuarios a Excel File</button>

</body>
</html>
