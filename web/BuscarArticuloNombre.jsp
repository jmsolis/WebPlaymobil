<%-- 
    Document   : index
    Created on : 12-ene-2021, 12:04:22
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<HTML>

<script>
function validar(){
	
	if ( document.getElementById('descripcion').value == "" ){
            alert("El dato DESCRIPCION, NO puede estar vacio.");
        }else{
            document.buscanombre.submit();  
        }
	
}	
</script>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
<link rel="stylesheet" href="Fotos\style.css"> 
</HEAD>

<BODY>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Busqueda articulo por nombre ) ]</h1>
<%
String cUsr = (String) request.getSession().getAttribute("cUsuario");
String cNom = (String) request.getSession().getAttribute("cNombre"); 
request.getSession().setAttribute("cOpcion", "NM");
request.getSession().setAttribute("nCodigo", 0);
request.getSession().setAttribute("cDes", "");
%>    
<h2>[  Usuario ]  [ &nbsp;<%=cUsr%> &nbsp; - &nbsp; <%=cNom%>&nbsp;]</h2><br><br>


<form id="buscanombre" name="buscanombre" action="ServletBuscarNombre" method="POST">

<table BORDER ALIGN=“CENTER>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Descripción: </TD> <TD WIDTH=100 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="descripcion" name="descripcion" size="100"><br> </TD></TR>
</table>

<br><br>
<input type="button" name="BotonOK" value="Buscar articulo" onclick="validar()"> <br><br>

</form>

<button onclick="location.href='MenuUsuario.jsp'">Volver</button>

</BODY>
</HTML>
