<%-- 
    Document   : index
    Created on : 12-ene-2021, 12:04:22
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
			document.amz.submit();
		}
	}
	
}	
</script>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">

<!--
<style type="text/css">
    h1{color: red;
       font-size: 50px; 
    }  
    td{color: red;
       font-size: 30px;  
    }
</style>
-->

</HEAD>

<BODY>
<h1>[ AMAZON LIGHT ]</h1><br><br>
<form id="amz" name="amz" action="ServletValidaUser" method="POST">

<table BORDER ALIGN=“CENTER>
<TR><TD WIDTH=250 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Usuario: <input type="text" id="user" name="user" size="10"><br> </TD></TR>
<TR><TD WIDTH=250 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Password: <input type="password" id="pass" name="pass" size="20"><br> </TD></TR>
<input type="hidden" value="www.pagina.html" id="pagina" name="pagina" size="30"> 
</table>

<br><br>
<input type="button" name="BotonOK" value="Iniciar Sesión" onclick="validar()">

</form>

</BODY>
</HTML>
