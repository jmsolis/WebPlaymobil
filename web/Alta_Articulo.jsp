<%-- 
    Document   : Alta_Articulo
    Created on : 13-ene-2021, 11:50:22
    Author     : JuanMi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<HTML>

<script>
function validar(){
	
	if(document.getElementById('titulo').value == "" ){
		alert("El Titulo, NO puede estar vacio.");
	}else{
		if(document.getElementById('descripcion').value == "" ){
			alert("La Descripcion, NO puede estar vacia.");
		}else{
                      if ( isNaN( document.getElementById('precio').value) ){
                          alert("El campo Precio, NO es un numero.");
                      }else {
                           if ( isNaN( document.getElementById('cantidad').value) ) {
                              alert("El campo Cantidad, NO es un numero."); 
                           }else {
                              document.articulo.submit();
                            }
                      }
		}
	}
	
}	
</script>

<HEAD>
<meta http-equiv="content-type" content="text/html; chartset=utf-8">
</HEAD>

<BODY>
<h1>[ AMAZON LIGHT - Alta de Articulo ]</h1><br><br>
<form id="articulo" name="articulo" action="ServletAltaArticulo" method="POST">

<table BORDER ALIGN=“CENTER>
<TR><TD WIDTH=450 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Titulo: <input type="text" id="titulo" name="titulo" size="20"><br> </TD></TR>
<TR><TD WIDTH=450 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Descripción: <input type="text" id="descripcion" name="descripcion" size="50"><br> </TD></TR>
<TR><TD WIDTH=450 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Foto: <input type="text" id="foto" name="foto" size="50"><br> </TD></TR>
<TR><TD WIDTH=450 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Precio: <input type="text" id="precio" name="precio" size="5"><br> </TD></TR>
<TR><TD WIDTH=450 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Cantidad: <input type="text" id="cantidad" name="cantidad" size="5"><br> </TD></TR>
</table>

<br><br>
<input type="button" name="BotonOK" value="Grabar artículo" onclick="validar()">

</form>

<br><br>
<input type="button" name="BotonVolver" value="Volver" onclick="location.href='Menu_Admin.jsp'">

</BODY>
</HTML>
