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
		alert("El dato USUARIO, NO puede estar vacio.");
	}else{
	     if(document.getElementById('pass').value == "" ){
		alert("El dato PASSWORD, NO puede estar vacio.");
	    }else{
                 if(document.getElementById('nombre').value == "" ){
                    alert("El dato NOMBRE, NO puede estar vacio.");
                }else{
                    if(document.getElementById('email').value == "" ){
                         alert("El dato EMAIL, NO puede estar vacio.");
                    }else{
                         document.alta.submit();
                    }
                }
	    }
	}
	
}	
</script>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
<link rel="stylesheet" href="Fotos\style.css"> 
</HEAD>

<BODY>
<h1>¡¡¡  Usuario inexistente !!!</h1><br>   
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Alta Usuario ) ]</h1><br><br>
<form id="alta" name="alta" action="ServletGrabaUsuario" method="POST">

<table BORDER ALIGN=“CENTER>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Usuario: </TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="user" name="user" size="10"><br> </TD></TR>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Password: </TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="password" id="pass" name="pass" size="20"><br> </TD></TR>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Nombre: </TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="nombre" name="nombre" size="40"><br> </TD></TR>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Dirección: </TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="direccion" name="direccion" size="100"><br> </TD></TR>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Telefono: </TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="telefono" name="telefono" size="20"><br> </TD></TR>
<TR><TD WIDTH=80 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Email: </TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="email" name="email" size="100"><br> </TD></TR>
</table>

<br><br>


</form>
<input type="button" name="BotonOK" value="Registrarse" onclick="validarusr()"> &nbsp; &nbsp; &nbsp;
<button onclick="location.href='index.jsp'">Volver</button>

</BODY>
</HTML>
