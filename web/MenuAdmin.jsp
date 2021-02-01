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
String cUsr = (String) request.getSession().getAttribute("cUsuario");
String cNom = (String) request.getSession().getAttribute("cNombre"); 
%>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
<link rel="stylesheet" href="Fotos\style.css"> 
</HEAD>

<BODY>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Menu Administrador ) ]</h1>

<form id="menu_a" name="menu_a" action="ValidarMenuAdmin.jsp" method="POST">

Seleccione Opcion:
<br><br>
<select class="campo-select" name="seleccion" id="seleccion" size=5>
  <option value="1">Alta artículo</option>
  <option value="2">Entrada/Salida mercancía almacén</option>
  <option value="3">Listado de usuarios</option>
  <option value="4">Listado de árticulos</option>
  <option value="5">Listado de Ventas</option>
 </select>

<br><br>
<input type="button" name="BotonOK" value="Ejecutar seleccion" onclick="validar()">
<br><br>
<input type="button" name="BotonVolver" value="Volver" onclick="location.href='index.jsp'">
</form>
  
</BODY>
</HTML>
