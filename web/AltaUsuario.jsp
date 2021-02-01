<%-- 
    Document   : index
    Created on : 12-ene-2021, 12:04:22
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<HTML>

<script>
function validarusr(){
	
	if(document.getElementById('user').value == "" ){
		alert("El Usuario, NO puede estar vacio.");
	}else{
		if(document.getElementById('pass').value == "" ){
			alert("El password, NO puede estar vacio.");
		}else{
			document.alta.submit();
		}
	}
	
}	
</script>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
</HEAD>

<BODY>
<h1>[ AMAZON LIGHT ( Alta Usuario ) ]</h1><br><br>
<form id="alta" name="alta" action="ServletGrabaUsuario" method="POST">

<table BORDER ALIGN=“CENTER>
<TR><TD WIDTH=250 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Usuario: <input type="text" id="user" name="user" size="10"><br> </TD></TR>
<TR><TD WIDTH=250 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Password: <input type="password" id="pass" name="pass" size="20"><br> </TD></TR>
<TR><TD WIDTH=250 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Dirección: <input type="text" id="direccion" name="direccion" size="50"><br> </TD></TR>
</table>

<br><br>
<input type="button" name="BotonOK" value="Dar de Alta" onclick="validarusr()"><br><br>

</form>

<button onclick="location.href='index.jsp'">Volver</button>

</BODY>
</HTML>
