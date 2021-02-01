<%-- 
    Document   : Menu_Usuario
    Created on : 14-ene-2021, 8:45:13
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<HTML>
<script>
function validar(){
	
	if( document.getElementById('seleccion').value == "" ){
		alert("La seleccion, NO puede estar vacia.");
	}else{
		document.menu_a.submit();
	}

}	
</script>

<%
HttpSession sesion = request.getSession();
Integer nUsuario = (Integer) sesion.getAttribute("nUsuario");
String cNombreUsr = (String) sesion.getAttribute("cNombre");
%>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
</HEAD>

<BODY>
<h1>[ AMAZON LIGHT ( Menu Administrador ) ]</h1>

<form id="menu_a" name="menu_a" action="Validar_Menu_A.jsp" method="POST">

Seleccione Opcion:
<br><br>
<select name="seleccion" id="seleccion" size=3>
  <option value="A">Alta artículo</option>
  <option value="L">Listado de Ventas</option>
  <option value="U">Listado de usuarios</option>
</select>

<br><br>
<input type="button" name="BotonOK" value="Ejecutar seleccion" onclick="validar()">
<br><br>
<input type="button" name="BotonVolver" value="Volver" onclick="location.href='index.jsp'">
</form>
  
</BODY>
</HTML>
