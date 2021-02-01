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
	
	if ( document.getElementById('codigo').value == "" ){
        alert("El dato CODIGO de ARTICULO, NO puede estar vacio.");
        }else {
            if( isNaN( document.getElementById('codigo').value) ){
                alert("El dato CODIGO de ARTICULO, NO es un numero.");
		}else{
                      document.buscacodigo.submit();  
                }
           }
	
}	
</script>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
<link rel="stylesheet" href="Fotos\style.css"> 
</HEAD>

<BODY>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Busqueda articulo por codigo ) ]</h1>
<%
String cUsr = (String) request.getSession().getAttribute("cUsuario");
String cNom = (String) request.getSession().getAttribute("cNombre"); 
request.getSession().setAttribute("cOpcion", "CD");
request.getSession().setAttribute("nCodigo", 0);
request.getSession().setAttribute("cDes", "");
%>    
<h2>[  Usuario ]  [ &nbsp;<%=cUsr%> &nbsp; - &nbsp; <%=cNom%>&nbsp;]</h2><br><br>


<form id="buscacodigo" name="buscacodigo" action="ServletBuscarCodigo" method="POST">

<table BORDER ALIGN=“CENTER>
<TR><TD WIDTH=120 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Codigo articulo: </TD> <TD WIDTH=20 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="codigo" name="codigo" size="10"><br> </TD></TR>
</table>

<br><br>
<input type="button" name="BotonOK" value="Buscar articulo" onclick="validar()"> <br><br>

</form>

<button onclick="location.href='MenuUsuario.jsp'">Volver</button>

</BODY>
</HTML>
