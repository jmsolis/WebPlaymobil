<%-- 
    Document   : index
    Created on : 26-ene-2021, 11:17:11
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<HTML>

<script>
function validar(){
	
	if(document.getElementById('user').value == "" ){
		alert("El Usuario, NO puede estar vacio.");
	}else{
		if(document.getElementById('pass').value == "" ){
			alert("El password, NO puede estar vacio.");
		}else{
			document.playmo.submit();
		}
	}
	
}	
</script>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">

<link rel="stylesheet" href="Fotos\style.css"> 

</HEAD>

<body>
   
<h1>[ PLAYMOBIL - SEGUNDA MANO ]</h1><br><br>
<form id="playmo" name="playmo" action="ServletValidaUser" method="POST">
   
<table BORDER ALIGN="LEFT">
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Usuario:</TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="user" name="user" size="10"><br> </TD></TR>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Password:</TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="password" id="pass" name="pass" size="20"><br> </TD></TR>
</table>

<br><br><br><br><br>
<input type="button" name="BotonOK" value="Iniciar Sesión" onclick="validar()">

</form>

<!--
<br><br>
<a class="boton" href="http://www.hola.es" target="Revista Hola">Visitar pagina</a>   
<br><br>
<a class="mi_boton" href="https://vinkula.com" target="Pulsar para ir a la pagina.">Soy un botón</a>
<br><br><br><br><br><br>
<a class="mi_boton_big" href="https://vinkula.com"><img src="Fotos\escuela.jpg"></a>
-->

</body>
</HTML>

