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
		document.menu_u.submit();
	}

}	
</script>

<%
//HttpSession sesion = request.getSession();
String cUsr = (String) request.getSession().getAttribute("cUsuario");
String cNom = (String) request.getSession().getAttribute("cNombre"); 
%>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
<link rel="stylesheet" href="Fotos\style.css"> 
</HEAD>

<BODY>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Menu Usuario ) ]</h1>
<h2>[  Usuario ]  [ &nbsp;<%=cUsr%> &nbsp; - &nbsp; <%=cNom%>&nbsp;]</h2><br><br>

<form id="menu_u" name="menu_u" action="ValidarMenuUser.jsp" method="POST">

Seleccione Opcion:
<br><br>
<select class="campo-select" name="seleccion" id="seleccion" size=4>
  <option value="1">Ver artículos con su stock</option>
  <option value="2">Buscar artículos por código</option>
  <option value="3">Buscar artículos por nombre</option>
  <option value="4">Comprar artículos</option>
</select>

<br><br>
<input type="button" name="BotonOK" value="Ejecutar seleccion" onclick="validar()"> 
<br><br>
<input type="button" name="BotonVolver" value="Volver" onclick="location.href='index.jsp'">

</form>

</BODY>
</HTML>
