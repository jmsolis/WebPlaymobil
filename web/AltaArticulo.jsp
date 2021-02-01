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
	
    if(document.getElementById('descripcion').value == "" ){
	alert("El dato DESCRIPCION, NO puede estar vacio.");
	}else{
            if(document.getElementById('precio').value == "" ){
                alert("El dato PRECIO, NO puede estar vacio.");
            }else{
            if ( isNaN( document.getElementById('precio').value) ){
                alert("El dato PRECIO, NO es un numero.");
                }else{
                    if(document.getElementById('stock').value == "" ){
                         alert("El dato STOCK, NO puede estar vacio.");
                     }else{
                        if ( isNaN( document.getElementById('stock').value) ) {
                            alert("El dato STOCK, NO es un numero."); 
                           }else{
                            document.articulo.submit();
                          }
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
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Alta de Articulo ) ]</h1><br><br>
<form id="articulo" name="articulo" action="ServletAltaArticulo" method="POST">

<table BORDER ALIGN="LEFT">
<TR><TD WIDTH=70 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Descripción:</TD> <TD WIDTH=50 ALIGN="LEFT" BGCOLOR="#FFF3CF"> <input type="text" id="descripcion" name="descripcion" size="100"><br> </TD></TR>
<TR><TD WIDTH=70 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Foto:</TD> <TD WIDTH=100 ALIGN="LEFT" BGCOLOR="#FFF3CF"> <input type="text" id="foto" name="foto" size="50"><br> </TD></TR>
<TR><TD WIDTH=70 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Precio:</TD> <TD WIDTH=10 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="precio" name="precio" size="5"><br> </TD></TR>
<TR><TD WIDTH=70 ALIGN="LEFT" BGCOLOR="#FFF3CF">Stock: </TD> <TD WIDTH=10 ALIGN="LEFT" BGCOLOR="#FFF3CF"><input type="text" id="stock" name="stock" size="5"><br> </TD></TR>
</table>

 <br><br><br><br><br><br>

</form>

<br><br>
<input type="button" name="BotonOK" value="Grabar artículo" onclick="validar()"> &nbsp; &nbsp; &nbsp;
<input type="button" name="BotonVolver" value="Volver" onclick="location.href='MenuAdmin.jsp'">

</BODY>
</HTML>
